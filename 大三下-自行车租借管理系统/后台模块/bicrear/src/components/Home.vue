<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-17 14:01:56
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-06-12 11:22:11
 * @FilePath: \bicrear\src\components\home.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div class="home">
    <Herd></Herd>
    <LeftNav></LeftNav>
    <div class="main">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import LeftNav from './left/LeftNav.vue';
import Herd from './header/Herd.vue';

export default {
  name: 'Home',
  components: {
    LeftNav,
    Herd,
  }
}
</script>

<style scoped>
  .home{
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    background-color: #f1f3f4;
  }
  .home .main{
    padding-top: 50px;
    padding-left: 250px;
  }
</style>