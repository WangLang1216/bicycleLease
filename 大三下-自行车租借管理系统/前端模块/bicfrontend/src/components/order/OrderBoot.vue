<template>
  <div class="orderBoot">
    <div class="row">
      <div class="col-3">
        <div class="form-check allCheck">
          <input class="form-check-input" type="checkbox" v-model="isAll" @click="isAllOrder"/>&nbsp;
          <label class="form-check-label">全选</label>
        </div>
      </div>
      <div class="col-9 settlement" v-if="isManage">
        <div class="row">
          <div class="col-5">
            <p><span>合计：</span>￥{{ orderTotalPrice }}</p>
          </div>
          <div class="col-7">
            <button type="button" class="btn btn-danger" @click="subOrder">结算</button>
          </div>
        </div>
      </div>
      <div class="col-9" v-else>
        <button type="button" class="btn btn-danger" id="liveToastBtn" @click="delOrder">删除</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'OrderBoot',
  props: {
    isManage: Boolean,
    selectDate: {
      type: String,
      default: ''
    },
    orderTotalPrice: Number,
    orderList: Array
  },
  data () {
    return {
      isAll: false,
      isDel: false
    }
  },
  methods: {
    // 日期
    timestampToTime(times) {
        let time = times[1]
        let mdy = times[0]
        mdy = mdy.split('/')
        let month = parseInt(mdy[0]);
        if(month.toString().length == 1) month = '0' + month;
        let day = parseInt(mdy[1]);
        if(day.toString().length == 1) day = '0' + day;
        let year = parseInt(mdy[2]);
        return year + '-' + month + '-' + day
    },
    async date1() {
      let date = new Date()
      return this.timestampToTime(date).split(" ")
    },
    // 结算
    async subOrder() {
      if(this.selectDate == null || this.selectDate == '') this.selectDate = this.date1();
      console.log(this.selectDate);
      if(this.orderTotalPrice == 0) return alert("请选择结算订单！");
      let code = 0;
      let map = {};
      map.reservationId = this.orderList;
      map.rResdate = this.selectDate;
      await axios.post('http://localhost:8080/reservation/fulfilReservationListById', map)
      .then((res) => {
        code = res.data.code;
      })
      if(code == 0) alert("结算失败！");
      else alert("结算成功！");
      location.reload();
    },
    // 删除
    async delOrder() {
      this.isDel = !this.isDel;
      this.$emit("delOrder", this.isDel);
      let code = 0;
      if(this.orderList != null) {
        await axios.post('http://localhost:8080/reservation/delReservationListById', this.orderList)
        .then((res) => {
          code = res.data.code;
        })
      }
      if(code == 0) {
        alert("删除失败");
        return location.reload();
      }
    },
    isAllOrder() {
      this.isAll = !this.isAll;
      this.$emit("isAll", this.isAll)
    }
  }
}

</script>

<style scoped>
  .orderBoot{
    width: 100%;
    height: 50px;
    background: white;
    position: fixed;
    bottom: 0;
    padding-right: 1%;
  }
  .orderBoot .allCheck{
    display: flex;
    width: 100%;
    padding-left: 55%;
    line-height: 48px;
  }
  .orderBoot .allCheck input{
    margin-top: 45%;
  }
  .orderBoot button{
    width: 90%;
    border-radius: 45px;
    background-color: #ef3a3a;
    box-shadow: inset 0 0 0 1px #ef3a3a;
    margin-top: 2%;
  }
  .orderBoot .settlement>div>div{
    text-align: left;
  }
  .orderBoot .settlement p{
    line-height: 45px;
    color: red;
    font-size: 15px;
  }
  .orderBoot .settlement span{
    color: #6d6d6d;
    font-size: 10px;  
  }
  .orderBoot .settlement button{
    width: 100%;
    margin-top: 4%;
  }

</style>