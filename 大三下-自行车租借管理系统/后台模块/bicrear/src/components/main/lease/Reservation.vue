<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-23 11:44:40
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-06-12 20:59:48
 * @FilePath: \bicrear\src\components\main\lease\Reservation.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
    <div style="margin-top: 3%;">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/">租借信息管理</a></el-breadcrumb-item>
        <el-breadcrumb-item>预约查询</el-breadcrumb-item>
      </el-breadcrumb>
    </div>

  <div class="reservation">
    <!--头部查询-->
    <div>
      <el-row gutter="20">
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
      </el-row>
    </div>

    <!--列表数据-->
    <div>
      <el-table ref="tableRef" row-key="date" :data="reservationList.slice((currentPage-1)*pageSize,currentPage*pageSize)" style="width: 100%">
        <el-table-column
          prop="rresdate"
          label="预约日期"
          sortable
          width="150"
          column-key="rresdate"
          :filters="[
            { text: date1(), value: date1() },
            { text: date2(), value: date2() },
            { text: date3(), value: date3() }
          ]"
          :filter-method="filterHandler"
        />
        <el-table-column prop="reservationId" label="预约编号" width="150" show-overflow-tooltip />
        <el-table-column prop="accountcustId" label="顾客账号" width="150" show-overflow-tooltip />
        <el-table-column prop="cname" label="顾客姓名" width="100" />
        <el-table-column prop="bbrand" label="品牌" width="100" />
        <el-table-column prop="bname" label="名称" width="120" />
        <el-table-column prop="rnumber" sortable label="数量" width="80" />
        <el-table-column prop="rtotalprice" sortable label="总价" width="80" />
        <el-table-column prop="saddress" label="地址" :filters="addressList" :filter-method="filterAddress" show-overflow-tooltip />

        <el-table-column
          prop="rstatus"
          label="状态"
          width="100"
          :filters="[
            { text: '未成功', value: 0 },
            { text: '已成功', value: 1 },
          ]"
          :filter-method="filterTag"
          filter-placement="bottom-end"
        >
          <template #default="scope">
            <el-tag
              :type="scope.row.rstatus == '0' ? '' : 'success'"
              disable-transitions
              >{{ getStatus(scope.row.rstatus) }}</el-tag
            >
          </template>
        </el-table-column>
      </el-table>
    </div>

    <!--分页-->
    <div style="margin-top: 1%;">
      <el-row gutter="20">
        <el-col :span="7"></el-col>
        <el-col :span="17">
          <el-pagination
            @size-change="handleSizeChange" 
            @current-change="handleCurrentChange"
            :current-page="currentPage" 
            :page-sizes="[1, 5, 10, 50, 100, 500]" 
            :page-size="pageSize" 
            layout="total, sizes, prev, pager, next, jumper" 
            :total="reservationList.length">
          </el-pagination>
        </el-col>
      </el-row>
    </div>

  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'Reservation',
  data () {
    return {
      // 用户编号
      accountcustId: null,
      // 用户信息
      userList: [],
      userTemp: [],
      addressList: [
        {text: "成都锦城大道2段营业店", value: "成都锦城大道2段营业店"},
        {text: "成都武侯区天府5街营业店", value: "成都武侯区天府5街营业店"},
        {text: "成都成华大道二仙桥营业店", value: "成都成华大道二仙桥营业店"},
      ],
      reservationListTemp: [],
      reservationList: [],
      currentPage: 1, // 当前页码
      total: 20, // 总条数
      pageSize: 10, // 每页的数据条数
      }
  },
  async mounted () {
    await axios.get('http://localhost:8081/reservation/queryReservationList').then((res) => {
      this.reservationList = res.data.data;
      this.reservationListTemp = res.data.data;
      console.log(res);
    });

    await axios.get('http://localhost:8081/user/queryCustomerList').then((res) => {
      this.userList = res.data.data;
      this.userTemp = res.data.data
    });
  },
  methods: {
    getStatus(status) {
      return status == '0' ? '未成功' : '已成功'
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
      if(this.accountcustId != null || this.accountcustId != '') {
        this.reservationListTemp.forEach(element => {
          if(element.accountcustId.indexOf(this.accountcustId) >= 0) temp.push(element)
        });
        return this.reservationList = temp
      }
      else return this.reservationList = this.reservationListTemp
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
    const filterTag = (value, row) => {
      return row.rstatus == value
    }
    const filterHandler = (value, row, column) => {
      const property = column['property']
      return row[property] == value
    }
    const filterAddress = (value, row) => {
      return row.rstatus == value
    }

    return{
      filterTag,
      filterHandler,
      filterAddress
    }
  }
}
</script>

<style scoped>
  .reservation{
    width: 95%;
    background: white;
    margin-top: 1%;
    padding-top: 2%;
    padding-bottom: 1%;
    border-radius: 3px;
  }
  .reservation>div:nth-child(1){
    padding-left: 2%;
    padding-right: 2%;
  }
  .reservation>div:nth-child(2){
    padding-left: 1%;
    padding-right: 1%;
  }
  .el-button{
    border-radius: 1px;
  }
</style>