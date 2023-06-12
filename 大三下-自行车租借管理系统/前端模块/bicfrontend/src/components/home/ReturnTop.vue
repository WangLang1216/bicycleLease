<template>
  <div>
    <div class="leftNav-item">
      <ul>
        <li>
          <i class="bi bi-cart-check-fill"></i>
          <!-- <router-link to="Order"> -->
            <a href="javascript:void(0)" class="rota" @click="goOrder">查订单</a>
          <!-- </router-link> -->
        </li>
        <li title="位置">
          <i class="bi bi-geo-alt-fill"></i>
          <a href="javascript:void(0)" class="rota" data-bs-toggle="offcanvas" data-bs-target="#offcanvasBottom" aria-controls="offcanvasBottom">选位置</a>
        </li> 
        <li lay-data="img" data-fooc="">
          <i class="bi bi-chat-dots-fill"></i><a href="javascript:;" class="rota">找客服</a>
        </li> 
        <li title="返回顶部" class="for-top" @click="top">
          <i class="bi bi-capslock-fill"></i>
          <a href="javascript:;" class="rota" @click="refresh">去顶部</a>
        </li>
      </ul>
	  </div>
    <div class="offcanvas offcanvas-bottom" tabindex="-1" id="offcanvasBottom" aria-labelledby="offcanvasBottomLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasBottomLabel">店铺位置选择</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body default">
        <div v-for="(item, index) in addressList" :key="index">
          <label>
            <input type="radio" name="date" v-model="selectAddress" @click="selectAddressValue(item.value)" :value="item.value" :checked="item.value == 0"/>&nbsp;{{ item.label }}
          </label>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import $ from 'jquery/dist/jquery';


export default {
  name: 'ReturnTop',
  data () {
    return {
      addressList: [
        {value: 0, label: '全部'},
        {value: 1, label: '武侯区锦城大道南段'},
        {value: 2, label: '新都区新都大道西段'},
        {value: 3, label: '青羊区青羊大道北段'},
      ],
      selectAddress: 0,
    }
  },
  methods: {
    top() {
      $(".for-top").click(function () {
        console.log("Are You Ok?");
        $('html,body').animate({
            scrollTop: 0
        }, 100);
      })
    },
    selectAddressValue(value) {
      this.$emit("selectAddress", value);
    },
    goOrder() {
      if(sessionStorage.getItem("accountcustId") == null) {
        alert("请先前往登录！");
        return this.$router.push({name: 'Login'});
      }
      this.$router.push({name: 'Order'});
    }
  }
};

function setlayer(alias, str, icon) {
  var html = "";
  if (alias == "text") {
      html += "<div class=\"text-item\">";
      html += "<span>";
      html += "<i class=\"" + icon + "\"></i>" + str + "</span>";
      html += "</div>";
  } else {
      html += "<div class=\"img-item\">";
      html += "<img src=\"" + str + "\">";
      html += "</div>";
  }
  return html;
}

$(function () {
  $(".leftNav-item li").hover(function (e) {
      var alias = $(this).attr("lay-data");
      var str = $(this).attr("data-fooc");
      var icon = $(this).children("i").attr("class");
      if (!alias) {
          return false;
      }
      $(this).append(setlayer(alias, str, icon));
      $(this).children("div").show(300);
  }, function (e) {
      $(this).children("div").remove();
  });
  $(window).scroll(function () {
      var scrollTop = $(document).scrollTop();
      if (scrollTop >= 200) {
          $(".for-top").show();
      } else {
          $(".for-top").hide();
      }
  });
  
})
</script>

<style scoped>
  @import url("../../assets/css/returnTop.css");
</style>