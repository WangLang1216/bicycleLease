<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-14 20:54:56
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-05-16 13:18:35
 * @FilePath: \bicfrontend\src\components\order\Order.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div class="order">
    <OrderHead @isManage="getManage" @selectDate="getSelectDate"></OrderHead>
    <div class="orderCard">
      <OrderCard @orderTotalPrice="getOrderTotalPrice" @orderList="getOrderList" :isAll="isAll" :delOrder="delOrder" :isManage="isManage"></OrderCard>
    </div>
    <OrderBoot :isManage="isManage" :selectDate="selectDate" :orderTotalPrice="orderTotalPrice" :orderList="orderList" @isAll="getIsAll" @delOrder="getDelOrder"></OrderBoot>
  </div>
</template>

<script>
import OrderHead from './OrderHead.vue';
import OrderCard from './OrderCard.vue';
import OrderBoot from './OrderBoot.vue';

export default {
  name: 'Order',
  data () {
    return {
      isManage: true,
      selectDate: new Date().getFullYear() + '-' + (new Date().getMonth() + 1) + '-' + new Date().getDate(),
      orderTotalPrice: null,
      orderList: null,
      isAll: null,
      delOrder: null,
    }
  },
  components: {
    OrderHead,
    OrderCard,
    OrderBoot
  },
  methods: {
    getManage(val) {
      this.isManage = val
    },
    getSelectDate(val) {
      this.selectDate = val
    },
    getOrderTotalPrice(val) {
      this.orderTotalPrice = val
    },
    getOrderList(val) {
      this.orderList = val
    },
    getIsAll(val) {
      this.isAll = val
    },
    getDelOrder(val) {
      this.delOrder = val
    },
  }
}
</script>

<style scoped>
  .order{
    width: 100%;
    height: 650px;
    position: absolute;
    top: 0;
    left: 0;
    background: #f3f3f3;
  }
  
</style>