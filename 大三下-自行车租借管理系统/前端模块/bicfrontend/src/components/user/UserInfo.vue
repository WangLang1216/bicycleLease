<template>  
  <div class="userInfo">
    <Head></Head>
    <div class="setInfo">
      <h4>个人资料</h4>
      <div class="info">
        <div>
          <div><p>账号</p></div>
          <div><p>{{ userInfo.accountcustId }}</p><span>已验证不可修改</span></div>
        </div>
        <div>
          <div><p>姓名</p></div>
          <div><input class="form-control" type="text" v-model="userInfo.cName"/></div>
        </div>
        <div>
          <div><p>性别</p></div>
          <div>
            <input style="width: 8%;" type="radio" value="男" name="sex" v-model="userInfo.cSex"/><span style="color: black;font-size: 15px;line-height: 40px;margin-left: 0;">男</span>&nbsp;&nbsp;
            <input style="width: 8%;" type="radio" value="女" name="sex" v-model="userInfo.cSex"/><span style="color: black;font-size: 15px;line-height: 40px;margin-left: 0;">女</span>
          </div>
        </div>
        <div>
          <div><p>年龄</p></div>
          <div><input class="form-control" type="number" v-model="userInfo.cAge"/></div>
        </div>
        <div>
          <div><p>邮箱</p></div>
          <div><input type="email" class="form-control" v-model="userInfo.cEmail"/></div>
        </div>
        <div>
          <div><p>地址</p></div>
          <div><textarea class="form-control" style="width: 90%;" v-model="userInfo.cAddress"></textarea></div>
        </div>
        <button class="btn btn-primary" @click="changeInfo">修改</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Head from '../home/Head.vue';

export default {
  name: 'UserInfo',
  data () {
    return {
      userInfo: {}
    }
  },
  async mounted(){
    // sessionStorage.getItem("custaccountId")
    await axios.get('http://localhost:8080/user/queryCustomerById/' + sessionStorage.getItem("accountcustId"))
    .then(response=>{
      this.userInfo = response.data.data
    })
  },
  methods:{
    async changeInfo(){
      let code = 0;
      await axios.post("http://localhost:8080/user/updateUser", this.userInfo)
      .then(response=>{
        code = response.data.code;
      })
      if(code == 0) return alert("修改失败！");
      return alert("修改成功！");
    }
  },
  components: {
    Head
  }
}
</script>

<style scoped>
  .userInfo{
    width: 100%;
    height: 1000px;
    position: fixed;
    left: 0;
    top: 5%;
    background: #f5f5f5;
  }
  .userInfo .setInfo{
    margin-top: 8%;
    width: 97%;
    background: white;
    position: absolute;
    right: 0;
    border-radius: 5px;
    padding-top: 5%;
    padding-left: 5%;
    padding-bottom: 10%;
  }
  .userInfo .setInfo h4{
    font-size: 18px;
    font-weight: bold;
    text-align: left;
  }
  .userInfo .info{
    padding-top: 5%;
  }
  .userInfo .info>div{
    display: flex;
  }
  .userInfo .info>div>div:nth-child(1){
    flex: 1;
    text-align: left;
    height: 50px;
  }
  .userInfo .info>div>div:nth-child(1) p{
    color: #8c8c8c;
  }
  .userInfo .info>div>div:nth-child(2) span{
    margin-left: 5%;
    font-size: 10px;
    color: #999;
    line-height: 25px;
  }
  .userInfo .info>div>div:nth-child(2){
    flex: 4;
    text-align: left;
    display: flex;
    height: 50px;
  }
  input{
    width: 90%;
    height: 40px;
  }
  button{
    width: 50%;
    margin-top: 20%;
  }
</style>