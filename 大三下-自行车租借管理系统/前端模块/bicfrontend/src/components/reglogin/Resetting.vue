<template>
  <div class="container resetting">
    <div class="row">
      <div class="col-12">
        <img class="rounded mx-auto d-block" src="../../assets/images/giant_logo.png"/>
      </div>
      <div class="col-12">
        <h5 class="font-monospace fw-semibold">重置密码</h5>
      </div>
      <div class="col-12">
        <form>
          <input type="email" class="form-control col-12" name="email" placeholder="电子邮箱" v-model="user.email"/>
          <div class="input-group verify">
            <input type="text" class="form-control" placeholder="邮箱验证码" v-model="user.captcha" aria-label="Recipient's username" aria-describedby="button-addon2">
            <button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="obtain">{{item}}</button>
          </div>
          <input type="password" class="form-control col-12" name="password" v-model="user.password" placeholder="设置密码" />
          <button type="submit" class="btn btn-primary col-12" @click="send">重置密码</button>
        </form>
        <p class="col-12 linkLogin">
          <router-link to="Login"><a href="#">前往登录</a></router-link>
        </p>
        <p class="bottom">天府骑行（成都）有限公司</p>
      </div>
    </div>
  </div>
</template>
  
<script>
import axios from 'axios';
export default {
  name: 'Resetting',
  data () {
    return {
      user: {
        email: null,
        password: null,
      },
      captcha: null,
      emailCode: '',
      item: '获取验证码',
      dsq: null
    }
  },
  methods: {
    // 获取验证码按钮
    async obtain() {
      if(isEmail(this.user.email)) {
        if(this.item != '获取验证码' && this.item >= 0) return alert('请等一分钟后再试！');
        this.item = 60;
        this.dsq = setInterval(this.zijian, 1000);
        await axios.get("http://localhost:8080/user/sendEmail/" + this.user.email)
        .then((response)=>{
          this.emailCode = response.data.data
        })
      }
    },
    zijian() {
      if(this.item == 0) {
        this.item = '获取验证码';
        return clearInterval(this.dsq);
      }
      else this.item--
    },
    // 重置密码按钮
    async send() {
      let code = 0;
      if(this.user.email == null || this.user.password == null) return alert("请输入邮箱进行验证！");
      if(this.user.emailCode != this.captcha) return alert("验证码输入错误！")
      await axios.post("http://localhost:8080/user/resettingAccount",this.user)
      .then((res) => {
        code = res.data.code
      })
      if(code == 0) return alert("重置失败！")
      return alert("重置成功！");
    }
  }
};

// 验证邮箱
function isEmail(strEmail) {
  if (strEmail == null || strEmail == '') {
    alert("邮箱地址不能为空！");
    return false;
  }
  if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
    return true;
  else {
    alert("邮箱地址不正确！");
    return false;
  }
}
  
</script>
  
<style scoped>
  .resetting{
    margin-top: -25%;
    width: 110%;
    margin-left: -5%;
  }
  img{
    width: 60%;
    margin-bottom: 5%;
  }
  form input{
    height: 42px;
    margin-top: 3%;
    border-radius: 0px;
    border: 1px solid #ccc;
    background: #f9f9f9;
  }
  form .verify button{
    height: 42px;
    margin-top: 3%;
    border-radius: 0px;
    background-color: #0070bc;
    color: #fff;
    box-shadow: 0 1px 2.5px #0070bc;
  }
  form>button{
    margin-top: 5%;
    border: 0px;
    line-height: 35px;
    border-radius: 3px;
    background: #E22608;
    box-shadow: 0 1px 2.5px rgba(226,38,8,0.6);
  }
  .resetting .linkLogin{
    margin-top: 2%;
    text-align: left;
  }
  .resetting .linkLogin a{
    color: #777;
    text-decoration: none;
  }
  .resetting .bottom{
    margin-top: 10%;
    color: #999999;
    font-size: 12px;
  }
</style>