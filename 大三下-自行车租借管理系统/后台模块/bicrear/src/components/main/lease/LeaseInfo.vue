<template>
  <div style="margin-top: 3%;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">租借信息管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>租借查询</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
  <!--头部查询-->
  <div class="leaseInfo">
    <div>
      <el-row gutter="20">
        <el-col :span="5">
          <el-form-item label="订单">
            <el-input v-model="leaseinfoId" placeholder="租借编号" />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="账号">
            <el-autocomplete
              v-model="accountcustId"
              :fetch-suggestions="querySearchAsyncUser"
              placeholder="手机号/账号"
              @input="userInput"
              @select="handleSelectUser"
            />
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item>
            <el-button type="primary" @click="queryLeaseInfo">查询</el-button>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="状态">
            <el-select v-model="editStatus" class="m-2" placeholder="状态" size="default" style="width: 50%;">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              />
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="4" style="display: flex;">
          <el-form-item style="margin-left: -55%;">
            <el-button type="success" @click="editStatusList">修改</el-button>
          </el-form-item>
          <el-form-item style="margin-left: 60%;">
            <el-button type="danger" @click="delLeaseInfo">删除</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </div>
    <!--数据列表-->
    <div>
      <el-table :row-key="leaseInfoList.date" @selection-change="selectList" :data="leaseInfoList.slice((currentPage-1)*pageSize,currentPage*pageSize)" style="width: 100%">
        <el-table-column type="selection" width="55" />
        <el-table-column
          prop="ldatefrist"
          label="日期"
          sortable
          width="110"
          show-overflow-tooltip
          column-key="ldatefrist"
          :filters="[
            { text: date1(), value: date1() },
            { text: date2(), value: date2() },
            { text: date3(), value: date3() }
          ]"
          :filter-method="filterHandler"
        />
        <el-table-column width="183" show-overflow-tooltip prop="leaseinfoId" label="租借编号" />
        <el-table-column prop="cname" label="顾客姓名" />
        <el-table-column prop="bbrand" label="车辆品牌" />
        <el-table-column prop="bname" show-overflow-tooltip label="车辆名称" />
        <el-table-column prop="ltimefrist" width="110" sortable label="开始时间" />
        <el-table-column prop="lduration" sortable label="时长" />
        <el-table-column prop="lmoney" sortable label="金额" />
        <el-table-column prop="dprice" sortable label="押金" />

        <el-table-column
          prop="lstatus"
          label="租借状态"
          width="100"
          :filters="[
            { text: '租借中', value: 0 },
            { text: '已结束', value: 1 },
            { text: '异常中', value: 2 },
          ]"
          :filter-method="filterTag"
          filter-placement="bottom-end"
        >
          <template #default="scope">
            <el-tag
              :type="getStatus(scope.row.lstatus)"
              disable-transitions
            >
              {{ gotStatus(scope.row.lstatus) }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button type="warning" size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!--分页-->
    <div>
      <el-row gutter="20">
        <el-col :span="7"></el-col>
        <el-col :span="17">
          <el-pagination
            @size-change="handleSizeChange" 
            @current-change="handleCurrentChange"
            :current-page="currentPage" 
            :page-sizes="[1, 5, 10, 20, 50, 100]" 
            :page-size="pageSize" 
            layout="total, sizes, prev, pager, next, jumper" 
            :total="leaseInfoList.length">
          </el-pagination>
        </el-col>
      </el-row>
    </div>
    <!--编辑弹出-->
    <div>
      <el-dialog v-model="dialogFormVisible" title="租借信息修改">
        <!--顾客信息-->
        <el-row gutter="80">
          <el-col :span="2" style="line-height: 27px;">
            <el-tag class="ml-2" type="success">顾客信息</el-tag>
          </el-col>
          <el-col :span="10">
            <el-form-item label="账号">
              <el-autocomplete
                v-model="accountcustId"
                :fetch-suggestions="querySearchAsyncUser"
                placeholder="手机号/账号"
                @input="userInput"
                @select="handleSelectUser"
              />
            </el-form-item>
          </el-col>
        </el-row>
        <!--车辆信息-->
        <el-row gutter="80">
          <el-col :span="2" style="line-height: 27px;">
            <el-tag class="ml-2" type="warning">车辆信息</el-tag>
          </el-col>
          <el-col :span="10">
            <el-form-item label="名称">
              <el-autocomplete
                v-model="zhanwei"
                :fetch-suggestions="querySearch"
                clearable
                class="inline-input w-50"
                placeholder="车辆名称"
                @input="handlerChange"
                @select="handleSelect"
                />
            </el-form-item>
          </el-col>
          <el-col :span="10">
            <el-form-item label="数量">
              <el-input-number v-model="number" min="1" max="3"  />
            </el-form-item>
          </el-col>
        </el-row>
        <!--日期信息-->
        <el-row gutter="80">
          <el-col :span="2" style="line-height: 27px;">
            <el-tag class="ml-2" type="danger">日期信息</el-tag>
          </el-col>
          <el-col :span="10">
            <el-form-item label="日期">
              <div class="demo-date-picker">
                <div class="block">
                  <el-date-picker style="width: 90%;"
                    v-model="date"
                    type="daterange"
                    range-separator="To"
                    start-placeholder="开始日期"
                    end-placeholder="结束日期"
                    format="YYYY-MM-DD"
                    value-format="YYYY-MM-DD"
                    size="default"
                  />
                </div>
              </div>
            </el-form-item>
          </el-col>
          <el-col :span="10">
              <el-form-item label="时间">
                <div class="demo-range">
                  <el-time-picker style="width: 90%;"
                    v-model="times"
                    is-range
                    range-separator="To"
                    start-placeholder="开始时间"
                    end-placeholder="结束时间"
                    format="hh:mm:ss"
                    value-format="hh:mm:ss"
                  />
                </div>
              </el-form-item>
          </el-col>
        </el-row>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取消</el-button>
            <el-button type="primary" @click="save">确认</el-button>
          </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { ref, reactive } from 'vue'
import { getCurrentInstance } from "vue";
import axios from 'axios';

export default {
  name: 'LeaseInfo',
  data () {
    return {
      options: [
        {value: 1, label: '已结束'},
        {value: 0, label: '租借中'},
        {value: 2, label: '异常中'},
      ],
      // 订单号
      leaseinfoId: null,
      // 用户编号
      accountcustId: null,
      // 用户信息
      userList: [],
      userTemp: [],
      // 自行车信息
      bicList: [],
      bicTemp: [],
      // 租借信息
      leaseInfoListTemp: [],
      leaseInfoList: [],
      currentPage: 1, // 当前页码
      total: 20, // 总条数
      pageSize: 10, // 每页的数据条数
      dialogFormVisible: false,  // 弹框
      index: '',
      editStatus: null,
      // 下面为弹框修改的内容
      zhanwei: null,
      account: null,
      bicycle: null,
      number: 1,
      date: null,  // 日期，获取的是一个数组，里面两个Date对象，拿出日期需要使用Date类的方法实现
      times: null,  // 时间，获取的是一个数组，里面两个Date对象，拿出日期需要使用Date类的方法实现
      // 多选
      leaseInfoIdList: [],
      // 订单号
      leaseId: null
    }
  },
  async mounted () {
    await axios.get('http://localhost:8081/lease/queryLeaseInfoList').then((res) => {
      this.leaseInfoList = res.data.data;
      this.leaseInfoListTemp = res.data.data
    })

    await axios.get('http://localhost:8081/user/queryCustomerList').then((res) => {
      this.userList = res.data.data;
      this.userTemp = res.data.data
    });
    await axios.get('http://localhost:8081/bicycle/queryBicycleInfo').then((res) => {
      this.bicList = res.data.data;
      this.bicTemp = res.data.data
    });
  },
  methods: {
    getStatus(status) {
      if(status == 0) return ' ';
      else if(status == 1) return 'success';
      else return 'danger'
    },
    gotStatus(status) {
      if(status == 0) return '租借中';
      else if(status == 1) return '已结束';
      else return '异常中'
    },
    // 编辑
    handleEdit(index, row){
      this.dialogFormVisible = true;
      this.index = index;
      this.leaseId = row.leaseinfoId
    },
    // 查询
    queryLeaseInfo() {
      let temp = [];
      if(this.leaseinfoId != null && this.leaseinfoId != '') {
        this.leaseInfoListTemp.forEach(element => {
          if(element.leaseinfoId == this.leaseinfoId) temp.push(element)
        });
        return this.leaseInfoList = temp
      }
      else if(this.accountcustId != null && this.accountcustId != '') {
        this.leaseInfoListTemp.forEach(element => {
          if(element.accountcustId == this.accountcustId) return temp =  element
        });
      }
      return this.leaseInfoList = this.leaseInfoListTemp
    },
    // 自行车
    // 返回值
    querySearch() {
      this.bicList.forEach(element => {
        element.value = element.bName
      });
      return this.bicList
    },
    // 修改
    handleSelect(item) {
      this.bicycle = item.bicycleinfoId;
    },
    // 监听
    handlerChange(e) {
      console.log(e)
      let temp = [];
      if(e != null) {
        this.bicTemp.forEach(element => {
          if(element.bName.indexOf(e) >= 0) temp.push(element)
        });
        return this.bicList = temp
      }
      else this.bicList = this.bicTemp
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
      this.zhanwei = item.bName;
      this.account = item.accountcustId;
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

    // 多选
    selectList(item) {
      this.leaseInfoIdList = [];
      item.forEach(element => {
        this.leaseInfoIdList.push(element.leaseinfoId)
      });
    },
    // 修改状态
    async editStatusList() {
      let code = 0;
      let temp = {};
      temp.leaseInfoIdList = this.leaseInfoIdList;
      temp.l_status = this.editStatus;
      await axios.post('http://localhost:8081/lease/editLeaseStatusListById', temp).then((res) => {code = res.data.code});
      if(code == 0) return alert("修改失败！");
      alert("修改成功");
      location.reload();
    },
    // 删除订单
    async delLeaseInfo() {
      let code = 0;
      let temp = {};
      temp.leaseInfoIdList = this.leaseInfoIdList;
      temp.l_status = 3;
      await axios.post('http://localhost:8081/lease/editLeaseStatusListById', temp).then((res) => {code = res.data.code});
      if(code == 0) return alert("删除失败！");
      alert("删除成功");
      location.reload();
    },

    // 保存
    async save(){
      // 后端返回是否成功执行
      if(true) {
        // 是否修改日期或时间
        // if(this.date === null && this.times != null)
        //   this.leaseInfoList[this.index].timeFirst = this.times[0].getHours() +':'+ this.times[0].getMinutes()
        // else if(this.times === null && this.date != null) 
        //   this.leaseInfoList[this.index].date = this.date[0].getFullYear() +'-'+ (this.date[0].getMonth()+1) +'-'+ this.date[0].getDate();
        // else {
        //   this.leaseInfoList[this.index].date = this.date[0].getFullYear() +'-'+ (this.date[0].getMonth()+1) +'-'+ this.date[0].getDate();
        //   this.leaseInfoList[this.index].timeFirst = this.times[0].getHours() +':'+ this.times[0].getMinutes()
        // }
        // 其他数据操作
        let code = 0;
        let temp = {};
        temp.leaseInfoId = this.leaseId;
        temp.accountcustId = this.account;
        temp.bicycleinfoId = this.bicycle;
        temp.lNumber = this.number;
        temp.lDatefrist = this.date[0];
        temp.lDatesecond = this.date[1];
        temp.lTimefrist = this.times[0];
        temp.lTimesecond = this.times[1];

        console.log(temp.lTimefrist);

        await axios.post('http://localhost:8081/lease/updateLeaseInfoById', temp).then((res) => {code = res.data.code});
        if(code == 0) return alert("修改失败！");
        alert("修改成功！");
        this.dialogFormVisible = false;
        location.reload();
      }
    },
    // 日期
    timestampToTime(times, index) {
        let time = times[1]
        let mdy = times[0]
        mdy = mdy.split('/')
        let month = parseInt(mdy[0]);
        if(month.toString().length == 1) month = '0' + month;
        let day = parseInt(mdy[1]);
        if(index == 1) day -= 1;
        if(index == 2) day -= 2;
        if(day.toString().length == 1) day = '0' + day;
        let year = parseInt(mdy[2]);
        return year + '-' + month + '-' + day
    },
    date1() {
      let date = new Date()
      return this.timestampToTime(date.toLocaleString('en-US', {hour12: false}).split(" "), 0)
    },
    date2() {
      let date = new Date()
      return this.timestampToTime(date.toLocaleString('en-US', {hour12: false}).split(" "), 1)
    },
    date3() {
      let date = new Date()
      return this.timestampToTime(date.toLocaleString('en-US', {hour12: false}).split(" "), 2)
    },

    //每页条数改变时触发 选择一页显示多少行
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.currentPage = 1;
      this.pageSize = val;
    },
    //当前页改变时触发 跳转其他页
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.currentPage = val;
    }
  },
  setup() {
    const exData = getCurrentInstance();
    const filterHandler = (value, row, column) => {
      const property = column['property'];
      return row[property] === value
    }
    const filterTag = (value, row) => {
      return row.status === value
    }
    return {
      filterHandler,
      filterTag
    }
  }
}
</script>

<style scoped>
  .leaseInfo{
    width: 96%;
    background: white;
    margin-top: 1%;
    padding-top: 2%;
    padding-bottom: 2%;
    border-radius: 3px;
  }
  .leaseInfo>div:nth-child(1){
    padding-left: 3%;
    padding-right: 2%;
  }
  .leaseInfo>div:nth-child(2){
    padding-left: 2%;
    padding-right: 2%;
  }
  .leaseInfo>div:nth-child(3){
    margin-top: 1%;
  }
  .el-button{
    border-radius: 1px;
  }
  .leaseInfo>div:nth-child(4) .el-row{
    margin-top: 2%;
  }
</style>