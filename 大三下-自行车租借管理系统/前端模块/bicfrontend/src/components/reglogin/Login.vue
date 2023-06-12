<template>
    <div class="container-fluid top">
        <!--头部-->
       <div class="header">
            <img col-12 src="../../assets/images/giant_logo.png" class="img-fluid"/>
            <h5 class="font-monospace fw-semibold">账号登录</h5>
       </div>
       <!--账号密码输入框-->
       <div class="body">
            <input col-12 type="number" placeholder="请输入手机号" class="btnbg" v-model="account.accountcustId"/>
            <input col-12 type="password" placeholder="请输入密码" class="btnbg" v-model="account.cPassword"/><br>
            <button class="btnlogin" @click="login"><strong>登录</strong></button>
            <div class="atag">
                <router-link to="Register"><a href="" class="left">注册账号</a></router-link>
                <router-link to="Resetting"><a href="" class="right">忘记密码？</a></router-link>
            </div>
       </div>
       <!--尾部标签-->
       <div class="foot">
            <p col-12>成都东软学院物联网22304班</p>
       </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Login',
    data () {
        return {
            account: {
                accountcustId: '',
                cPassword: '',
            },
        }
    },
    methods: {
        // 登录
        async login() {
            let isAuccess = '';
            let msg = '';
            if (this.account.accountcustId == '') return alert("账号不能为空！");
            if (this.account.cPassword == '') return alert("密码不能为空！");
            await axios.post("http://localhost:8080/user/loginAccount", this.account, false)
            .then((res) => {
                isAuccess = res.data.code;
                msg = res.data.msg;
                console.log(res);
            })
            if(isAuccess == '0') return alert(msg);
            sessionStorage.setItem("accountcustId", this.account.accountcustId);
            // alert(sessionStorage.getItem("accountcustId"));
            this.$router.push({name: 'User', query: {isHome: true}})
        }
    }
}
</script>

<style scoped>
    .top{
        margin-top: -30%;
    }
    img{
        width: 60%;
        margin-bottom: 5%;
    }
    .body input{
        border: 1px solid grey;
        margin-top: 5%;
        width: 95%;
        height: 45px;
    }
    .body{
        margin-top: 10%;
    }
    .atag{
        margin-top: 5%;
    }
    .left{
        margin-left: 0%;
        color: gray;
        text-decoration: none;
    }
    .right{
        margin-left: 45%;
        color: grey;
        text-decoration: none;
    }
    .account{
        margin-top: 15%;
    }
    .btnbg{
        background-color: #fefbfb;
        padding-left: 2%;
    }
    .btnlogin{
        color: white;
        width: 95%;
        background-color: rgb(45, 135, 244);
        border-radius: 5px;
        margin-top: 10%;
    }
    .foot{
        margin-top: 35%;
    }
    .foot p{
        font-size: 12px;
        color: gray;
    }
    a{
        text-decoration: none;
    }
</style>
