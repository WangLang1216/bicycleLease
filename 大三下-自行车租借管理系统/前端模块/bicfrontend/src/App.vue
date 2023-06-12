<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-07 13:55:04
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-06-05 09:16:06
 * @FilePath: \bicfrontend\src\App.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<script setup>
  import Register from './components/reglogin/Register.vue';
  import Resetting from './components/reglogin/Resetting.vue';
  import Home from './components/home/Home.vue';
  import User from './components/user/User.vue';
  import Order from './components/order/Order.vue';
</script>

<template>
  <div class="app">
    <!-- <Register></Register> -->
    <!-- <Resetting></Resetting> -->
    <!-- <Home></Home> -->
    <!-- <User></User> -->
    <!-- <Order></Order> -->
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'APP',
  data () {
    return {
      isReload: true
    }
  },
  components: {
    User,
    Home,
    Register,
    Resetting,
    Order

  }
}
</script>

<style scoped>

</style>
