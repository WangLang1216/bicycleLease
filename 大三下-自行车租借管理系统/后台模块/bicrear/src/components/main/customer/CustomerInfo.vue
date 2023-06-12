<!--
 * @Author: 李燕军
 * @Date: 2023-05-23 14:52:51
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-06-12 21:01:50
 * @FilePath: \bicrear\src\components\main\customer\CustomerInfo.vue
-->
<template>
   <!-- 页头 -->
   <div style="margin-top: 3%;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">顾客信息管理</a></el-breadcrumb-item>
    </el-breadcrumb>
  </div>
<!-- 主页面 -->
<div class="CustomerInfo">
    <!-- 头部操作 -->
    <div>
        <div>
            <el-form  :inline="true" class="demo-form-inline" style="width:100%">
            <el-form-item label="账号">
                <el-input style="width: 130px;" v-model="accountcustId" placeholder="账号/手机号">
                </el-input>
            </el-form-item>
             <el-form-item>
                <el-button type="primary" @click="queryLeaseInfo">查询</el-button>
            </el-form-item>
            </el-form>
        </div>
     </div>
  <!-- 数据列表 -->
  <div>
    <el-table :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)" style="width: 100%">
      <el-table-column type="index" label="序号" width="60" />
      <el-table-column prop="accountcustId" label="手机号/账号"  />
      <el-table-column prop="cName" width="90" label="姓名"  />
      <el-table-column prop="cSex" width="80" label="性别" />
      <el-table-column prop="cAge" width="80" label="年龄" />
      <el-table-column prop="cCard"  label="身份证号" show-overflow-tooltip />
      <el-table-column prop="cEmail" label="邮箱地址" show-overflow-tooltip />
      <el-table-column prop="cAddress" label="联系地址" show-overflow-tooltip />
      <el-table-column prop="customers.cDate" sortable label="注册日期" />
      <el-table-column
        prop="customers.cStatus"
        label="账号状态"
        :filters="[
          { text: '正常', value: 0 },
          { text: '异常', value: 1 },
        ]"
      :filter-method="filterStatus"
      filter-placement="bottom-end" >
        <template #default="scope">
          <el-switch 
            v-model="scope.row.customers.cStatus" 
            :active-value="0"
            :inactive-value="1"
            @change="change(scope.row)"/>
        </template>
      </el-table-column>
    </el-table>
  </div>
  <!-- 分页 -->
  <div class="block" style="margin-top:15px;">
    <el-pagination style="align:center; margin: 0 25%;"  @size-change="handleSizeChange" @current-change="handleCurrentChange" 
    :current-page="currentPage" 
    :page-sizes="[1,5,10,20]" 
    :page-size="pageSize" 
    layout="total, sizes, prev, pager, next, jumper" 
    :total="tableData.length">
    </el-pagination>
  </div>
</div>
</template>

<script>
import { ref } from 'vue'
import axios from 'axios'

export default {
  name:'CustomerInfo',
  data(){
    return{
      // 账号
      accountcustId: null,
      value1: true,
      tableData: [],
      tableDataTemp: [],
      currentPage: 1, // 当前页码
      total: 20, // 总条数
      pageSize: 8, // 每页的数据条数
      editStatus:null
    }
  },
  async mounted () {
    await axios.get('http://localhost:8081/user/queryCustomerList').then((res) => {
      this.tableData = res.data.data;
      this.tableDataTemp = res.data.data;
    });
    this.tableData.forEach(element => {
      element.customers.cDate = element.customers.cDate.toString().slice(0, 10)
    });
    this.tableDataTemp.forEach(element => {
      element.customers.cDate = element.customers.cDate.toString().slice(0, 10)
    });
  },
  methods: {
    // 查询
    queryLeaseInfo() {
      let temp = [];
      if(this.accountcustId != null && this.accountcustId != '') {
        this.tableDataTemp.forEach(element => {
          if(element.accountcustId.indexOf(this.accountcustId) >= 0) temp.push(element)
        });
        return this.tableData = temp
      }
      else return this.tableData = this.tableDataTemp
    },
    // 修改用户状态
    async change(row) {
      console.log(row);
      let code = 0;
      await axios.get('http://localhost:8081/user/updateStatusById/' + row.accountcustId + '/' + row.customers.cStatus).then((res) => {code = res.data.code});
      if(code == 0) alert('修改失败！');
      location.reload();
    },
    geto_status(o_status){
      if(o_status == '0') return '未退回';
      else return '已退回'; 
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.currentPage = 1;
      this.pageSize = val;
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        this.currentPage = val;
    },
  },
  setup(){
    const filterStatus = (value, row) => {
      return row.cStatus === value
    }
    return{
      filterStatus
    }
  }
}
</script>

<style scoped>
.CustomerInfo{
    width: 90%;
    background: white;
    margin-top: 1%;
    padding-top: 2%;
    padding-bottom: 2%;
    border-radius: 3px;
  }
.CustomerInfo>div:nth-child(1){
    padding-left: 2%;
    text-align: left;
    display: flex;
  }
.CustomerInfo>div:nth-child(1)>div:nth-child(2){
    text-align: right;
    flex: 1;
    padding-right: 1%;
  }
.CustomerInfo>div:nth-child(2){
    padding-left: 1%;
    padding-right: 1%;
    
  }
  .el-button{
    border-radius: 1px;
  }
</style>