<template>
  <Head></Head>
  <div class="user">
    <UserHeader></UserHeader>
    <UserOrderVue></UserOrderVue>
  </div>
</template>

<script>
import Head from '../home/Head.vue';
import UserHeader from './UserHeader.vue';
import UserOrderVue from './UserOrder.vue';
import UserInfo from './UserInfo.vue';

export default {
  name: 'User',
  data () {
    return {
      
    }
  },
  components: {
    Head,
    UserHeader,
    UserOrderVue,
    UserInfo
  }
}
</script>

<style scoped>
  .user{
    width: 100%;
    position: absolute;
    left: 0;
    top: 5%;
  }
</style>