<template>
  <div class="container register">
    <div class="row">
      <div class="col-12">
        <img class="rounded mx-auto d-block" src="../../assets/images/giant_logo.png"/>
      </div>
      <div class="col-12">
        <h5 class="font-monospace fw-semibold">账号注册</h5>
      </div>
      <div class="col-12">
        <form>
          <input type="tel" class="form-control col-12" placeholder="手机号/账号" v-model="raDto.accountcustId" />
          <input type="text" class="form-control col-12" placeholder="身份证号" v-model="raDto.cCard" />
          <input type="email" class="form-control col-12" placeholder="电子邮箱" v-model="raDto.cEmail" />
          <div class="input-group verify">
            <input type="text" class="form-control" placeholder="邮箱验证码" v-model="captcha" aria-label="Recipient's username" aria-describedby="button-addon2">
            <button class="btn btn-outline-secondary" type="button" @click="obtain">{{item}}</button>
          </div>
          <input type="password" class="form-control col-12" placeholder="设置密码" v-model="raDto.cPassword" />
          <button type="submit" class="btn btn-primary col-12" @click="register">注册</button>
        </form>
        <div class="form-check agree">
          <input class="form-check-input" type="checkbox" v-model="isAgree">
          <span>点击注册，即表示您同意</span>&nbsp;
          <span>天府骑行用户服务协议</span>
        </div>
        <p class="text-muted linkLogin">
          有天府骑行账号？ <router-link to="Login"><a href="#" class="text-reset">直接登录</a></router-link>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Register',
  data () {
    return {
      isAgree: false,
      raDto: {
        accountcustId: null,
        cCard: null,
        cEmail: null,
        cPassword: null,
      },
      captcha: null,  // 用户输入的邮箱验证码！
      emailCode: null,// 后台发送邮箱验证码！
      item: '获取验证码',
      dsq: null
    }
  },
  methods: {
    // 获取邮箱验证码
    async obtain() {
      if(this.item != '获取验证码' && this.item >= 0) return alert('请等一分钟后再试！');
      this.item = 60;
      this.dsq = setInterval(this.zijian, 1000);
      await axios.get("http://localhost:8080/user/sendEmail/" + this.raDto.cEmail)
      .then((res) => {
        console.log(res);
        this.emailCode = res.data.data;
      })
    },
    zijian() {
      if(this.item == 0) {
        this.item = '获取验证码';
        return clearInterval(this.dsq);
      }
      else this.item--
    },
    // 注册
    async register() {
      let code = '';
      let msg = '';
      // 判断是否已勾选“用户协议”
      if(isPhone(this.raDto.accountcustId) && validIdNumber(this.raDto.cCard) && this.isAgree == false) return alert("请勾选 天府骑行用户服务协议！");
      // 判断邮箱验证码值是否相同
      if(this.captcha != this.emailCode) return alert("邮箱验证码不正确！");
      // 进行注册操作
      await axios.post('http://localhost:8080/user/registerAccount', this.raDto)
      .then((res) => {
        console.log(res);
        code = res.data.code;
        msg = res.data.msg;
      })
      if(code == 0) return alert(msg);
      return this.$router.push({name:'Login', params: {accountcustId: this.raDto.accountcustId, cPassword: this.raDto.cPassword}})
    }
  }
};
// 身份证号验证
function validIdNumber(code) {
  const city = {
    11: "北京",
    12: "天津",
    13: "河北",
    14: "山西",
    15: "内蒙古",
    21: "辽宁",
    22: "吉林",
    23: "黑龙江 ",
    31: "上海",
    32: "江苏",
    33: "浙江",
    34: "安徽",
    35: "福建",
    36: "江西",
    37: "山东",
    41: "河南",
    42: "湖北 ",
    43: "湖南",
    44: "广东",
    45: "广西",
    46: "海南",
    50: "重庆",
    51: "四川",
    52: "贵州",
    53: "云南",
    54: "西藏 ",
    61: "陕西",
    62: "甘肃",
    63: "青海",
    64: "宁夏",
    65: "新疆",
    71: "台湾",
    81: "香港",
    82: "澳门",
    91: "国外 ",
  };
  let pass = true;
  if (!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|X|x)$/i.test(code)) pass = false;
  else if (!city[code.substr(0, 2)]) pass = false;
  else {
    //18位身份证需要验证最后一位校验位
    code = code.toUpperCase();
    if (code.length === 18) {
      code = code.split("");
      //∑(ai×Wi)(mod 11)
      //加权因子
      let factor = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
      //校验位
      let parity = [1, 0, "X", 9, 8, 7, 6, 5, 4, 3, 2];
      let sum = 0;
      let ai = 0;
      let wi = 0;
      for (let i = 0; i < 17; i++) {
        ai = code[i];
        wi = factor[i];
        sum += ai * wi;
      }
      let last = parity[sum % 11];
      if (last + "" !== code[17] + "") pass = false;
    }
  }
  console.log(pass);
  if (pass == false) alert("身份证号验证不通过");
  return pass;
};

// 手机号验证
function isPhone(str){
  let reg = /^1[3456789]\d{9}$/;
  // ^1  以1开头
  // [3456789] 第2位，使用原子表里的任意一个原子都可以
  // \d{9}$  第三位  朝后可以是任意数字  并且最后结尾必须是数字

  if(reg.test(str)){
    console.log("合法");
    return true;
  }else{
    console.log("手机格式不正确");
    alert("手机格式不正确");
    return false;
  }
}
</script>

<style scoped>
  .register{
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
  form button{
    margin-top: 5%;
    border: 0px;
    line-height: 35px;
    border-radius: 3px;
    background: #2da403;
    box-shadow: 0 1px 2.5px rgba(45, 164, 3, .6);
  }
  .agree{
    margin-top: 1%;
  }
  .agree span{
    font-size: 12px;
    color: #9d9d9d;
  }
  .agree span:nth-child(3){
    font-weight: bold;
    color: #333;
  }
  .linkLogin{
    margin-top: 20%;
  }
  form>div>button{
    height: 42px;
    margin-top: 9px;
    color: white;
    line-height: 20px;
    border: 0;
  }
</style>