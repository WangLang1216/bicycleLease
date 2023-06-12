<template>
  <div class="head">
    <div>
      <a href="#"><img src="../../assets/images/giant_logo.png"/></a>
    </div>
    <div>
      <p><a href="#">{{ store }}</a></p>
    </div>
  </div>
</template>

<script>

export default {
  name: 'Head',
  data () {
    return {
      store: "锦城大道2段租借店"
    }
  }
}
</script>

<style scoped>
  .head{
    width: 100%;
    height: 50px;
    background: white;
    box-shadow: 0 3px 12px rgba(98,107,181,.25);
    position: fixed;
    display: flex;
    z-index: 999;
  }
  .head>div{
    flex: 1;
  }
  .head>div:nth-child(1){
    text-align: left;
    padding-left: 2%;
    line-height: 70px;
  }
  .head>div:nth-child(2){
    text-align: right;
    padding-right: 5%;
  }
  .head>div p{
    color: #ffd04b;
  }
  a{
    text-decoration: none;
    color: #ffd04b;
  }
  img{
    width: 20%;
  }
</style>