<template>
  <div class="userOrder">
    <div class="order">
      <div>
        <p>我的订单</p>
        <p><a href="#">全部订单<i class="bi bi-chevron-right"></i></a></p>
      </div>
      <div class="row">
        <div class="col-4">
          <i class="bi bi-bag-check"></i>
          <p>待付款</p>
        </div>
        <div class="col-4">
          <i class="bi bi-box2-heart"></i>
          <p>待取车</p>
        </div>
        <div class="col-4">
          <i class="bi bi-dash-circle-dotted"></i>
          <p>待维护</p>
        </div>
      </div>
    </div>
    <div class="info">
      <div>
        <i class="bi bi-mortarboard-fill" style="color: #fdbf2d;"></i>
        <div>
          <router-link to="UserInfo"><p>基本资料</p></router-link>
          <i class="bi bi-chevron-right"></i>
        </div>
      </div>
      <div>
        <i class="bi bi-terminal-fill" style="color: #51bbe0;"></i>
        <div>
          <p>我的优惠</p>
          <i class="bi bi-chevron-right"></i>
        </div>
      </div>
    </div>

    <div class="info">
      <div>
        <i class="bi bi-geo-alt-fill" style="color: #f96c5e;"></i>
        <div>
          <p>门店位置</p>
          <i class="bi bi-chevron-right"></i>
        </div>
      </div>
      <div>
        <i class="bi bi-wechat" style="color: #ff8b43;"></i>
        <div>
          <p>联系我们</p>
          <i class="bi bi-chevron-right"></i>
        </div>
      </div>
    </div>

    <div class="info">
      <div>
        <i class="bi bi-toggles" style="color: #ffb302;"></i>
        <div>
          <p>其他</p>
          <i class="bi bi-chevron-right"></i>
        </div>
      </div>
      <div>
        <i class="bi bi-nut-fill" style="color: #818c99;"></i>
        <div>
          <p>设置</p>
          <i class="bi bi-chevron-right"></i>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserOrder',
  data () {
    return {
      
    }
  }
}
</script>

<style scoped>
  .userOrder{
    background: #f5f5f5;
    width: 100%;
  }
  .userOrder .order{
    background: #fff;
    margin-top: 3%;
  }
  .userOrder .order>div:nth-child(1){
    height: 40px;
    display: flex;
    line-height: 30px;
    border-bottom: 1px solid rgba(0,0,0,.15);
  }
  .userOrder .order p{
    color: rgba(0,0,0,.87);
  }
  .userOrder .order>div:nth-child(1) p:nth-child(1){
    flex: 1;
    text-align: left;
    margin-left: 5%;
  }
  .userOrder .order>div:nth-child(1) p:nth-child(2){
    flex: 1;
    text-align: right;
    margin-right: 3%;
  }
  .userOrder .order a{
    text-decoration: none;
  }
  .userOrder .order>div:nth-child(2){
    height: 80px;
    padding-top: 3%;
  }
  .userOrder .order>div:nth-child(2) i{
    font-size: 25px;
    color: #b5b5b5;
  }
  .userOrder .order>div:nth-child(2) p{
    font-size: 10px;
    color: rgba(0,0,0,.87);
  }
  .userOrder .info{
    background: #fff;
    margin-top: 3%;
  }
  .userOrder .info>div{
    height: 50px;
    display: flex;
    padding-left: 5%;
    line-height: 50px;
  }
  .userOrder .info>div i{
    font-size: 30px;
  }
  .userOrder .info>div>div{
    display: flex;
    width: 100%;
    margin-left: 5%;
    padding-right: 3%;
  }
  .userOrder .info>div:nth-child(1) div{
    border-bottom: 1px solid rgba(0,0,0,.15);
  }
  .userOrder .info>div>div i{
    flex: 1;
    text-align: right;
  }
  a{
    text-decoration: none;
    color: rgba(0,0,0,.87);
  }
</style>