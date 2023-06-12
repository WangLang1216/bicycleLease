<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-08 15:21:17
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-05-11 11:04:58
 * @FilePath: \bicfrontend\src\components\home\Carousel.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div class="container carousel">
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active" v-for="(item, index) in carList" :key="index">
                <img :src="item.cimgurl" class="d-block w-100">
                <div class="carousel-caption center">
                    <!-- <h2>{{index+1}}/{{ carList.length }}</h2> -->
                </div>
            </div>
        </div>
      </div>
  </div>
</template>

<script>
import axios from 'axios'
import $ from 'jquery/dist/jquery';

export default {
  name: 'Carousel',
  data () {
    return {
      isHome: false,
      carList: [],
    }
  },
  async mounted() {
    await axios.get('http://localhost:8080/product/queryCarousel')
    .then((res) => {
      this.carList = res.data.data
    })
  },
}
</script>

<style scoped>
  .center{
    width: 100%;
    margin-bottom: 30%;
    margin-left: -10%;
  }
  .center h2{
    float: left;
    color: #008DFF;
  }
</style>