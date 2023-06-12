<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-15 08:10:30
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-05-16 13:29:42
 * @FilePath: \bicfrontend\src\components\order\OrderCard.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div class="orderCard" :style="getBackground(index)" v-for="(item, index) in order" :key="index">
    <div>
      <div class="input-group-text selected">
        <input class="form-check-input mt-0" :disabled="getDisabled(index)" type="checkbox" @click="isOrder(true, index)" v-model="item.isSelected" aria-label="Checkbox for following text input">
      </div>
    </div>
    <div>
      <img :src="item.bimgurl"/>
    </div>
    <div class="content">
      <div>
        <p>{{ item.bbrand }} {{ item.bname }}</p>
      </div>
      <div>
        <p>地点：{{ item.saddress }}</p>
      </div>
      <div>
        <div>
          <p>￥{{ item.rtotalprice }}元</p>
        </div>
        <div class="numerical">
          <div class="input-group">
            <button class="btn btn-outline-secondary" type="button" @click="reduceNum(item.rnumber, index)">-</button>
            <input type="text" class="form-control" v-model="item.rnumber" disabled/>
            <button class="btn btn-outline-secondary" type="button" @click="addNum(item.rnumber, index)">+</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div v-if="order == null" style="padding-top: 50%;">
    <h3 style="color: rgb(130, 127, 127);">您还没有预约订单信息！</h3>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'OrderCard',
  props: {
    isAll: Boolean,
    delOrder: Boolean,
    isManage: Boolean,
  },
  data () {
    return {
      order: []
    }
  },
  async mounted() {
    await axios.get('http://localhost:8080/reservation/queryReservationListById/' + sessionStorage.getItem("accountcustId"))
    .then((res) => {
      this.order = res.data.data;
    })
    if(this.order != null) {
      this.order.forEach(element => {
        element.isSelected = false;
        element.deposit = element.rtotalprice / element.rnumber;
      });
    }
  },
  methods: {
    async reduceNum(number, index) {
      if(number === 1) return alert("订单量不能小于1！");
      else {
        this.order[index].rnumber -= 1;
        this.order[index].rtotalprice = this.order[index].deposit * (--number);
        this.isOrder(false, index)
      }
      let Reservation = {
        'reservationId': this.order[index].reservationId,
        'rNumber': parseInt(this.order[index].rnumber),
        'rTotalprice': parseFloat(this.order[index].rtotalprice)
      }
      await axios.post('http://localhost:8080/reservation/updateReservation', Reservation)
      .then((res) => {
        let code = res.data.code;
        if(code == 0) {
          alert("修改失败，请重试！");
          return location.reload();
        }
      })
    },
    async addNum(number, index) {
      if(number >= this.order[index].bstock) return alert("库存不足！");
      else if(number === 3) return alert("已达到单次最大预约量！");
      else {
        this.order[index].rnumber += 1;
        this.order[index].rtotalprice = this.order[index].deposit * (++number);
        this.isOrder(false, index)
      }
      let Reservation = {
        'reservationId': this.order[index].reservationId,
        'rNumber': parseInt(this.order[index].rnumber),
        'rTotalprice': parseFloat(this.order[index].rtotalprice)
      }
      await axios.post('http://localhost:8080/reservation/updateReservation', Reservation)
      .then((res) => {
        let code = res.data.code;
        if(code == 0) {
          alert("修改失败，请重试！");
          return location.reload();
        }
      })
    },
    // 选中订单，并传递总价给父组件
    isOrder(is, index) {
      // if(this.order[index].stock == 0) {
      //   return alert("库存不足！");
      // }
      if(is == true) this.order[index].isSelected = !this.order[index].isSelected;
      let orderTotalPrice = null;
      let orderList = [];
      this.order.forEach(element => {
        if(element.isSelected == true) {
          orderTotalPrice += element.rtotalprice;
          orderList.push(element.reservationId);
        }
      });
      this.$emit("orderTotalPrice", orderTotalPrice);
      this.$emit("orderList", orderList);
    },
    // 判断库存情况是否改变该颜色
    getBackground(index) {
      if(this.order[index].bstock == 0) return {filter: 'opacity(0.5)'}
      else return {filter: 'opacity(1)'}
    },
    // 库存不足时让其不能被选中
    getDisabled(index) {
      if(this.order[index].bstock == 0 && this.isManage == true) return true;
      else return false;
    }
  },
  watch: {
    isAll() {
      if(this.isAll == true) {
        this.order.forEach(element => {
          if(this.getDisabled(this.order.indexOf(element)) == false) element.isSelected = true
        });
        this.isOrder(false, -1)
      } else {
        this.order.forEach(element => {
          element.isSelected = false
        });
        this.isOrder(false, -1)
      }
    },
    delOrder() {
      for (let i = 0; i < this.order.length; i++) {
        if(this.order[i].isSelected == true) this.order.splice(i, 1)
      }
      this.order.forEach(element => {
        let i = this.order.indexOf(element);
        if(element.isSelected == true) this.order.splice(i, 1)
      });
    },
  }
};

</script>

<style scoped>
  .orderCard{
    width: 94%;
    height: 80px;
    margin-left: 3%;
    margin-top: 2%;
    background-color: #fff;
    box-shadow: 0 1px 3px rgba(0,0,0,.1);
    display: flex;
    /* filter: opacity(0.5); */
  }
  .orderCard>div:nth-child(1){
    flex: 1;
    background-color:  #f9f9f9;
  }
  .orderCard>div:nth-child(2){
    flex: 2;
    background: white;
  }
  .orderCard>div:nth-child(3){
    background: white;
    flex: 5;
  }
  .selected{
    border: 0;
    margin-top: 50%;
    background-color: #f9f9f9;
  }
  .selected>input{
    width: 20px;
    height: 20px;
    border-radius: 50px;
  }
  .orderCard img{
    width: 100%;
    margin-top: 10%;
  }
  .orderCard .content{
    display: flex;
    overflow: hidden;
    padding-left: 1%;
    flex-direction: column;
  }
  .orderCard .content>div:nth-child(1){
    flex: 1;
    text-align: left;
    position: relative;
    top: 0;
  }
  .orderCard .content>div:nth-child(1) p{
    font-size: 18px;
    font-weight: bold;
  }
  .orderCard .content>div:nth-child(2){
    text-align: left;
    height: 20px;
    position: relative;
    top: -26%;
    line-height: 20px;
  }
  .orderCard .content>div:nth-child(2) p{
    color: #999;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    font-size: 14px;
  }
  .orderCard .content>div:nth-child(3){
    display: flex;
    position: relative;
    top: -25%;
    padding-right: 8%;
  }
  .orderCard .content>div:nth-child(3)>div:nth-child(1){
    flex: 1;
    text-align: left;
    line-height: 40px;
  }
  .orderCard .content>div:nth-child(3)>div:nth-child(1)>p{
    font-weight: 700;
    color: #f4330d;
    font-size: 16px;
  }
  .numerical{
    display: flex;
    padding-top: 2%;
  }
  .numerical button{
    border: 0;
    border-radius: 0;
    width: 30px;
    height: 30px;
    background: #f2f3f5;
    font-size: 15px;
    color: black;
  }
  .numerical input{
    width: 33px;
    height: 30px;
    font-size: 10px;
  }
</style>