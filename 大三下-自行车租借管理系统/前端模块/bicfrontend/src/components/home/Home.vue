<template>
  <div class="home">
    <Head></Head>
    <div class="carousel">
      <Carousel></Carousel>
    </div>
    <NavGroup @bikeId="getBike"></NavGroup>
    <div class="bikeList">
      <Product :selectAddress="selectAddress" :bikeId="bikeId"></Product>
    </div>
    <div>
      <ReturnTop @selectAddress="getSelectAddress"></ReturnTop>
    </div>
  </div>
</template>

<script>
import Head from './Head.vue';
import Carousel from './Carousel.vue';
import NavGroup from './NavGroup.vue';
import Product from './Product.vue';
import ReturnTop from './ReturnTop.vue';

export default {
  name: 'Home',
  data () {
    return {
      bikeId: '推荐',
      selectAddress: 0
    }
  },
  components: {
    Head,
    Carousel,
    NavGroup,
    Product,
    ReturnTop
  },
  mounted () {
    window.console.log(this.$router);
  },
  methods: {
    getBike(val) {
      this.bikeId = val
    },
    getSelectAddress(val) {
      this.selectAddress = val
    }
  },
  watch: {
    $route() {
      if(this.$router.currentRoute._value.name = 'Home') {
        console.log("进来了");
        this.$router.go()
      }
    }
  }
}
</script>

<style scoped>
  .home{
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
  }
  .carousel{
    margin-top: 15%;
  }
  .bikeList{
    margin-top: 50px;
    width: 100%;
  }
</style>