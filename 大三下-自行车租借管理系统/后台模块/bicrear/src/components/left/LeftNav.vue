<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-17 14:08:51
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-05-20 23:12:51
 * @FilePath: \bicrear\src\components\left\LeftNav.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div class="leftNav">
    <!-- <el-radio-group class="top" v-model="isCollapse" style="margin-bottom: 20px;">
      <el-radio-button :label="false">展开</el-radio-button>
      <el-radio-button :label="true">收起</el-radio-button>
    </el-radio-group> -->
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      :collapse="isCollapse"
      @open="handleOpen"
      @close="handleClose"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-sub-menu index="1">
        <template #title>
          <el-icon><i class="bi bi-box-seam"></i></el-icon>
          <span>自行车管理</span>
        </template>
        <el-menu-item-group>
          <router-link to="addBike"><el-menu-item index="1-1">新增</el-menu-item></router-link>
          <router-link to="bikeInfo"><el-menu-item index="1-2">查询/修改</el-menu-item></router-link>
        </el-menu-item-group>
      </el-sub-menu>

      <el-sub-menu index="2">
        <template #title>
          <el-icon><i class="bi bi-calendar2-check"></i></el-icon>
          <span>租借信息管理</span>
        </template>
        <el-menu-item-group>
          <router-link to="registration"><el-menu-item index="2-1">租借登记</el-menu-item></router-link>
          <router-link to="leaseInfo"><el-menu-item index="2-2">租借查询</el-menu-item></router-link>
          <router-link to="reservation"><el-menu-item index="2-3">预约查询</el-menu-item></router-link>
        </el-menu-item-group>
      </el-sub-menu>

      <el-sub-menu index="3">
        <template #title>
          <el-icon><i class="bi bi-credit-card"></i></el-icon>
          <span>收费与押金管理</span></template>
        <el-menu-item-group>
          <router-link to="depositi"><el-menu-item index="3-1">押金设计</el-menu-item></router-link>
          <router-link to="inquiry"><el-menu-item index="3-2">押金/收费查询</el-menu-item></router-link>
        </el-menu-item-group>
      </el-sub-menu>

      <el-menu-item index="4" class="store">
        <el-icon><i class="bi bi-person-square"></i></el-icon>
        <template #title><router-link to="customerInfo">顾客信息管理</router-link></template>
      </el-menu-item>

      <el-sub-menu index="5">
        <template #title> 
          <el-icon><i class="bi bi-window-sidebar"></i></el-icon>
          <span>前端数据管理</span>
        </template>
        <el-menu-item-group>
          <router-link to="carousel"><el-menu-item index="5-1">轮播图</el-menu-item></router-link>
          <router-link to="segmentData"><el-menu-item index="5-2">板块数据</el-menu-item></router-link>
        </el-menu-item-group>
      </el-sub-menu>

      <el-menu-item index="6" class="store">
        <el-icon><i class="bi bi-shop"></i></el-icon>
        <template #title><router-link to="store">店面信息管理</router-link></template>
      </el-menu-item>

      <el-menu-item index="7">
        <el-icon><i class="bi bi-folder"></i></el-icon>
        <template #title>报表管理</template>
      </el-menu-item>
    </el-menu>
  </div>
  
</template>

<script>

export default {
  name: 'LeftNav',
  data () {
    return {
      isCollapse: false
    }
  }
}
</script>

<style scoped>
  .leftNav{
    width: 200px;
    height: 100%;
    margin-top: 50px;
    background: #545c64;
    position: fixed;
    padding-top: 1%;
    z-index: 999;
  }
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 400px;
  }
  .store a{
    color: white;
  }
  .store a:hover{
    color: #ffd04b;
  }
</style>