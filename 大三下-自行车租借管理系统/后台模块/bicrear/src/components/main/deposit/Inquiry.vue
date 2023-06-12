<!--
 * @Author: 李燕军
 * @Date: 2023-05-21 22:00:04
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-06-12 20:58:32
 * @FilePath: \bicrear\src\components\main\deposit\Inquiry.vue
-->
<template>
  <!-- 页头 -->
  <div style="margin-top: 3%;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">收费与押金管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>押金/收费查询</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
<!-- 主页面 -->
<div class="Inquiry">
    <!-- 头部操作 -->
    <div>
      <el-form :inline="true" class="demo-form-inline" style="width:100%">
        <el-form-item label="编号">
            <el-input style="width: 130px;" v-model="orderdepositId" placeholder="押金订单编号"></el-input>
        </el-form-item>
        <el-form-item label="账号">
          <el-autocomplete
            v-model="accountcustId"
            :fetch-suggestions="querySearchAsyncUser"
            placeholder="手机号/账号"
            @input="userInput"
            @select="handleSelectUser"
          />
        </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="queryLeaseInfo">查询</el-button>
        </el-form-item>
        <div class="el-form-item" style="margin-left: 21.7%;">
          <el-form-item label="状态">
              <el-select style="width: 130px;" v-model="editStatus"  placeholder="状态" >
                  <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"/>
                  </el-select>
          </el-form-item>
          <el-form-item>
              <el-button type="success" @click="editStatusList" >修改</el-button>
          </el-form-item>
        </div>
      </el-form>
     </div>
  <!-- 数据列表 -->
  <div>
    <el-table :data="tableData.slice((currentPage-1)*pageSize,currentPage*pageSize)" @selection-change="selectListChange" style="width: 100%">
      <el-table-column type="selection" width="60"></el-table-column>
      <el-table-column prop="orderdepositId" label="押金订单编号"  />
      <el-table-column prop="accountcustId" label="顾客账号" />
      <el-table-column prop="cname" width="100" label="顾客姓名"  />
      <el-table-column prop="bbrand" label="车辆品牌" />
      <el-table-column prop="bname" label="车辆名称" />
      <el-table-column prop="oprice" sortable label="押金金额" />
      <el-table-column prop="ldatefrist" width="150" sortable show-overflow-tooltip label="订单日期" />
      <el-table-column
        prop="ostatus"
        label="状态"
        width="100"
        :filters="[
          { text:'未退回', value: '0' },
          { text:'已退回',value: '1' },
        ]"
        :filter-method="filterTag"
        filter-placement="bottom-end"
      >
        <template #default="scope">
          <el-tag
            :type="scope.row.ostatus == '1' ? 'success' : ''"
            disable-transitions
            >{{ geto_status(scope.row.ostatus) }}</el-tag
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
  <!-- 分页 -->
  <div class="block" style="margin-top:15px;">
            <el-pagination style="align:center; margin: 0 25%;"  @size-change="handleSizeChange" @current-change="handleCurrentChange" 
            :current-page="currentPage" 
            :page-sizes="[1,5,10,20,50,100]" 
            :page-size="pageSize" 
            layout="total, sizes, prev, pager, next, jumper" 
            :total="tableData.length">
            </el-pagination>
        </div>
</div>
</template>

<script>
import { ref } from 'vue'
import axios from 'axios';

export default {
    name: 'Inquiry',
  data () {
    return {
      options:[
        {value: '0',label: '未退回'},
        {value: '1',label: '已退回'}
      ],
      tableData: [],
      tableDataTemp: [],
      selectList: [],
      currentPage: 1, // 当前页码
      total: 20, // 总条数
      pageSize: 10, // 每页的数据条数
      editStatus: null,
      // 用户信息
      userList: [],
      userTemp: [],
      // 用户编号
      accountcustId: null,
      // 订单编号
      orderdepositId: null,
      // 订单编号集合
      orderdepositIdList: []
    }
  },
  async mounted () {
    await axios.get('http://localhost:8081/deposit/queryOrderDepositList').then((res) => {
      this.tableData = res.data.data;
      this.tableDataTemp = res.data.data
    });
    await axios.get('http://localhost:8081/user/queryCustomerList').then((res) => {
      this.userList = res.data.data;
      this.userTemp = res.data.data
    });
  },
  methods: {
    geto_status(ostatus){
      if(ostatus == 0) return '未退回';
      else  return '已退回'; 
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
    // 选中
    selectListChange(item) {
      this.orderdepositIdList = [];
      item.forEach(element => {
        this.orderdepositIdList.push(element.orderdepositId)
      });
    },
    // 用户
    querySearchAsyncUser() {
      if(this.accountcustId === null || this.accountcustId == '') return [];
      this.userList.forEach(element => {
        element.value = element.accountcustId
      });
      return this.userList
    },
    handleSelectUser(item) {
      this.accountcustId = item.accountcustId;
    },
    userInput(e) {
      let temp = [];
      if(e != null || e != '') {
        this.userTemp.forEach(element => {
          if(element.accountcustId.indexOf(e) >= 0) temp.push(element)
        });
        return this.userList = temp
      }
      else this.userList = this.userTemp
    },
    // 查询
    queryLeaseInfo() {
      let temp = [];
      if(this.orderdepositId != null && this.orderdepositId != '') {
        this.tableDataTemp.forEach(element => {
          if(element.orderdepositId == this.orderdepositId) temp.push(element)
        });
        return this.tableData = temp
      }
      else if(this.accountcustId != null && this.accountcustId != '') {
        this.tableDataTemp.forEach(element => {
          if(element.accountcustId == this.accountcustId) temp.push(element)
        });
        return this.tableData = temp
      }
      else return this.tableData = this.tableDataTemp
    },
    select(val){
      console.log(val);
      this.selectList = null;
      val.forEach(element => {
        this.selectList.push(element.orderdepositId)
      });
    },
    // 修改状态
    async editStatusList() {
      let code = 0;
      let temp = {};
      temp.orderdepositIdList = this.orderdepositIdList;
      temp.status = this.editStatus;
      await axios.post('http://localhost:8081/deposit/updateOrderDepositList', temp).then((res) => {code = res.data.code});
      if(code == 0) return alert('修改失败！');
      alert("修改成功！");
      location.reload();
    }
  },
  setup() {
    const filterTag = (value, row) => {
      return row.ostatus === value
    }
    return{
      filterTag
    }
  }
}
  
</script>

<style scoped>
  .Inquiry{
    width: 95%;
    background: white;
    margin-top: 1%;
    padding-top: 2%;
    padding-bottom: 1%;
    border-radius: 3px;
  }
  .Inquiry>div:nth-child(1){
    padding-left: 2%;
    text-align: left;
    display: flex;
  }
  .Inquiry>div:nth-child(2){
    padding-left: 1%;
    padding-right: 1%;
    
  }
  .el-button{
    border-radius: 1px;
  }
</style>