<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-08 13:50:28
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-06-05 09:19:59
 * @FilePath: \bicfrontend\src\components\home\Head.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div class="container head">
    <nav class="navbar bg-body-tertiary fixed-top first"><!-- fixed-top-->
      <div class="container-fluid">
        <img src="../../assets/images/giant_logo.png"/>
        <span class="bi bi-search"></span>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
          <span class="bi bi-text-left"></span>
        </button>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
          <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasNavbarLabel">天府骑行</h5>
            <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
          </div>
          <div class="offcanvas-body">
            <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
              <li class="nav-item">
                <!-- <router-link to="Home"> -->
                  <a class="nav-link" @click="goHome">首页</a>
                <!-- </router-link> -->
              </li>
              <li class="nav-item">
                <router-link to="User"><a class="nav-link" href="#">我的</a></router-link>
              </li>
              <li class="nav-item">
                <router-link to="Order"><a class="nav-link" href="#">订单</a></router-link>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">联系我们</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" @click="esc">退出登录</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'Head',
  data () {
    return {
        
    }
  },
  methods: {
    esc() {
      this.$router.push({name: 'Login'})
    },
    goHome() {
      this.$router.push({name: 'Home'});
      setTimeout(function () {
        window.location.reload();
      }, 1);
    }
  }
}
</script>

<style scoped>
  .first>div>img{
    width: 40%;
  }
  .first>div>button{
    border: 0px;
  }
  .first>div>span:nth-child(2){
    font-size: 22px;
    color: black;
    margin-left: 30%;
  }
  .first>div>button>span{
    font-size: 28px;
    color: black;
    margin-left: 30%;
  }
  a{
    text-decoration: none;
  }
</style>