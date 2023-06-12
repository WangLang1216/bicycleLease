<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-09 10:57:28
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-05-09 13:41:20
 * @FilePath: \bicfrontend\src\components\home\NavGroup.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div class="container-fluid navGroup">
    <div class="row">
      <ul class="col-12">
        <li class="col-3" @click="recommend"><span>推荐</span></li>
        <li class="col-3" @click="roadBike"><span>公路车</span></li>
        <li class="col-3" @click="mountainBike"><span>山地车</span></li>
        <li class="col-3" @click="Other"><span>配件信息</span></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'NavGroup',
  data () {
    return {
      bikeId: '推荐'
    }
  },
  methods: {
    recommend() {
      this.bikeId = '推荐';
      this.$emit("bikeId", this.bikeId);
    },
    roadBike() {
      this.bikeId = '公路车';
      this.$emit("bikeId", this.bikeId);
    },
    mountainBike() {
      this.bikeId = '山地车';
      this.$emit("bikeId", this.bikeId);
    },
    Other() {
      this.bikeId = '配件';
      this.$emit("bikeId", this.bikeId);
    }
  }
};
</script>

<style scoped>
  .navGroup{
    width: 100%;
    height: 40px;
    position: absolute;
    right: 0;
    left: 0;
  }
  .navGroup ul{
    display: flex;
    box-shadow: 0px 3px 5px grey;
  }
  .navGroup ul li{
    list-style-type: none;
    text-align: center;
  }
  .navGroup ul li span{
    font-size: 13px;
    color: black;
    overflow: hidden;
    line-height: 40px;
  }
  .navGroup ul li:hover{
    border-bottom: 2px red solid;
  }
  
</style>