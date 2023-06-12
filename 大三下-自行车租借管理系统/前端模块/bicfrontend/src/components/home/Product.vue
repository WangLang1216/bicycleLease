<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-09 11:16:23
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-06-05 08:56:11
 * @FilePath: \bicfrontend\src\components\home\Recommend.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div class="container-fluid product">
    <div class="row" v-if="isDefault">
      <div class="card col-6" v-for="(item, index) in productList" :key="index">
        <img :src="item.bimgurl" class="card-img-top" @click="goCar(item)">
        <div class="card-body content">
          <h5 class="card-title">{{item.bbrand}}</h5>
          <h6 class="card-subtitle mb-2 text-muted">{{ item.bname }}</h6>
          <p>{{item.cprice}}元/小时</p>
          <a class="btn btn-primary" @click="reservation(item)">点击预约</a>
        </div>
      </div>
    </div>
    <div class="row" v-else>
      <div class="card col-6" v-for="(item, index) in tempList" :key="index">
        <img :src="item.bimgurl" class="card-img-top" @click="goCar(item)">
        <div class="card-body content">
          <h5 class="card-title">{{item.bbrand}}</h5>
          <h6 class="card-subtitle mb-2 text-muted">{{ item.bname }}</h6>
          <p>{{item.cprice}}元/小时</p>
          <a class="btn btn-primary" @click="reservation(item.bicycleinfoId)">点击预约</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'Product',
  props: {
    selectAddress: Number,
    bikeId: String
  },
  data () {
    return {
      isDefault: true,
      productList: [],
      tempList: []
    }
  },
  mounted () {
    axios.get('http://localhost:8080/product/queryBicycleByType/' + this.bikeId)
    .then((res) => {
      this.productList = res.data.data;
    })
  },
  methods: {
    async reservation(id) {
      if(sessionStorage.getItem("accountcustId") == null) {
        alert("请先前往登录！");
        return this.$router.push({name: 'Login'});
      }
      let code = 0;
      let list = [];
      list.push(sessionStorage.getItem("accountcustId"));
      list.push(id.bicycleinfoId);
      console.log(list);
      await axios.post('http://localhost:8080/reservation/addReservation', list)
      .then((res) => {
        code = res.data.code;
      })
      if(code == 0) return alert("预约失败！");
      return alert("预约成功！");
    },
    goCar(item) {
      console.log(item);
      this.$router.push({name: 'Car', query: {bicycle: encodeURIComponent(JSON.stringify(item))}});
    }
  },
  watch: {
    selectAddress() {
      console.log(this.selectAddress);
      this.tempList = [];
      this.isDefault = false;
      if(this.selectAddress == 1) {
        this.productList.forEach(element => {
          if(element.saddress === '成都市武侯区锦城大道南段') this.tempList.push(element);
        });
        console.log(this.tempList);
      } else if(this.selectAddress == 2) {
        this.productList.forEach(element => {
          if(element.saddress === '成都市新都区新都大道西段') this.tempList.push(element);
        });
      } else if(this.selectAddress === 3) {
        this.productList.forEach(element => {
          if(element.saddress == '成都市青羊区青羊大道北段') this.tempList.push(element);
        });
      }
    },
    async bikeId() {
      await axios.get('http://localhost:8080/product/queryBicycleByType/' + this.bikeId)
      .then((res) => {
        this.productList = res.data.data;
      });
      this.isDefault = true;
    }
  }
}
</script>

<style scoped>
  .product{
    width: 100%;
  }
  .product img{
    width: 95%;
    margin-left: 2%;
  }
  .card{
    border: 0;
  }
  .content h5{
    font-size: 15px;
  }
  .content h6{
    font-size: 10px;
  }
  .content p:nth-child(3){
    font-size: 5px;
    color: red;
  }
  .content a{
    font-size: 10px;
  }
</style>