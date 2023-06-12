<template>
  <div class="userHeader">
    <div class="userName">
      <i v-if="isLogin" class="bi bi-person-check-fill"></i>
      <i v-else class="bi bi-person-dash-fill"></i>
      <p v-if="isLogin">{{ account }}</p>
      <p v-else><router-link to="Login"><a href="#">请登录！</a></router-link></p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserHeader',
  data () {
    return {
      account: '17345449129',
      isLogin: false
    }
  },
  mounted() {
    if(sessionStorage.getItem("accountcustId") != null) {
      this.account = sessionStorage.getItem("accountcustId");
      this.isLogin = true;
    }
  }
}
</script>

<style scoped>
  .userName{
    width: 100%;
    height: 100px;
    display: flex;
    line-height: 100px;
    padding-left: 5%;
    background: rgb(248,249,250);
  }
  .userName i{
    font-size: 60px;
    color: rgb(29, 32, 136);
  }
  .userName p{
    font-size: 25px;
    padding-left: 2%;
    color: #4e66ff;
  }
  a{
    text-decoration: none;
  }
</style>