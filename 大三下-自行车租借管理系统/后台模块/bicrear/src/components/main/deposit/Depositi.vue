<template>
  <!--页头-->
  <div style="margin-top: 3%;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">收费与押金管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>押金/时价设计</el-breadcrumb-item>
    </el-breadcrumb>
  </div>

  <!--正文-->
  <div class="depositi">
    <el-row>
      <!--押金-->
      <el-col :span="12">
        <div>
          <el-row gutter="20">
            <el-col :span="7">
              <el-form-item label="区间1">
                <el-select-v2
                  v-model="depositiInfo.dPrimary"
                  :options="primaryList1"
                  placeholder="开始价格"
                />
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="区间2">
                <el-select-v2
                  v-model="depositiInfo.dSecondary"
                  :options="primaryList2"
                  placeholder="结束价格"
                />
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="押金">
                <el-select-v2
                  v-model="depositiInfo.dPrice"
                  :options="depositiList"
                  placeholder="押金金额"
                />
              </el-form-item>
            </el-col>
            <el-col :span="3">
              <el-button type="primary" @click="addDepositiInfo">提交</el-button>
            </el-col>
          </el-row>
          <!--数据-->
          <el-table :data="depositiData" style="width: 100%" height="500">
            <el-table-column type="index" label="序数" width="100" />
            <!-- <el-table-column label="编号" prop="id"/> -->
            <el-table-column label="开始价格" sortable prop="dPrimary"/>
            <el-table-column label="结束价格" prop="dSecondary"/>
            <el-table-column label="押金金额" sortable prop="dPrice"/>
            <el-table-column label="操作">
              <template #default="scope">
                <el-button
                  size="small"
                  type="danger"
                  @click="handleDelete1(scope.$index, scope.row)"
                  >删除</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-col>
      
      <!--时价-->
      <el-col :span="12">
        <div>
          <el-row gutter="20">
            <el-col :span="7">
              <el-form-item label="区间1">
                <el-select-v2
                  v-model="currentPrice.cPrimary"
                  :options="primaryList1"
                  placeholder="开始价格"
                />
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="区间2">
                <el-select-v2
                  v-model="currentPrice.cSecondary"
                  :options="primaryList2"
                  placeholder="结束价格"
                />
              </el-form-item>
            </el-col>
            <el-col :span="7">
              <el-form-item label="时价">
                <el-input-number v-model="currentPrice.cPrice" :min="0" :precision="2" :step="0.5" controls-position="right" placeholder="0.00" />
              </el-form-item>
            </el-col>
            <el-col :span="3">
              <el-button type="success" @click="addCurrentPrice">提交</el-button>
            </el-col>
          </el-row>
          <!--数据-->
          <el-table :data="currentpriceData" style="width: 100%" height="500">
            <el-table-column type="index" label="序数" width="100" />
            <!-- <el-table-column label="编号" prop="id"/> -->
            <el-table-column label="开始价格" sortable prop="cPrimary"/>
            <el-table-column label="结束价格" prop="cSecondary"/>
            <el-table-column label="时价金额" sortable prop="cPrice"/>
            <el-table-column label="操作">
              <template #default="scope">
                <el-button
                  size="small"
                  type="danger"
                  @click="handleDelete2(scope.$index, scope.row)"
                  >删除</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { ref } from 'vue';
import axios from 'axios';


export default {
  name: 'Depositi',
  data() {
    return{
      // 押金信息
      depositiInfo: {
        dPrimary:'',
        dSecondary:'',
        dPrice:''
      },
      // 时价信息
      currentPrice: {
        cPrimary:'',
        cSecondary:'',
        cPrice:'',
      },
      //押金信息
      depositiData: [],
      // 时价信息
      currentpriceData: []
    }
  },
  async mounted () {
    await axios.get('http://localhost:8081/deposit/queryDepositiInfoList').then((res) => {this.depositiData = res.data.data});
    await axios.get('http://localhost:8081/deposit/queryCurrentPriceInfoList').then((res) => {this.currentpriceData = res.data.data});
    this.depositiData.forEach(element => {
      element.dPrimary = Number(element.dPrimary)
    });
    this.currentpriceData.forEach(element => {
      element.cPrimary = Number(element.cPrimary)
    });
  },
  methods: {
    async addDepositiInfo() {
      let code = 0;
      await axios.post('http://localhost:8081/deposit/addDepositiInfo', this.depositiInfo).then((res) => {code = res.data.code});
      if(code == 0) return alert("新增失败");
      alert("新增成功！");
      location.reload();
    },
    async addCurrentPrice() {
      let code = 0;
      await axios.post('http://localhost:8081/deposit/addCurrentPriceInfo', this.currentPrice).then((res) => {code = res.data.code});
      if(code == 0) return alert("新增失败");
      alert("新增成功！");
      location.reload();
    },
    // 押金删除
    async handleDelete1(index, row) {
      let code = 0;
      await axios.get('http://localhost:8081/deposit/delDepositiInfoById/' + row.depositId).then((res) => {code = res.data.code});
      if(code == 0) return alert('删除失败！');
      alert('删除成功！');
      location.reload();
    },
    // 时价删除
    async handleDelete2(index, row) {
      let code = 0;
      await axios.get('http://localhost:8081/deposit/delCurrentPriceInfoById/' + row.currentpriceId).then((res) => {code = res.data.code});
      if(code == 0) return alert('删除失败！');
      alert('删除成功！');
      location.reload();
    },
  },
  setup(){
    // 押金设计
    const primaryList1 = Array.from({ length: 200 }).map((_, idx) => ({
      value: `${idx * 2 + 1}00`,
      label: `${idx * 2 + 1}00`,
    }));
    const primaryList2 = Array.from({ length: 200 }).map((_, idx) => ({
      value: `${idx * 2 + 1}00`,
      label: `${idx * 2 + 1}00`,
    }));
    const depositiList = Array.from({ length: 50 }).map((_, idx) => ({
      value: `${(idx + 1) * 100 / 2}`,
      label: `${(idx + 1) * 100 / 2}`,
    }));
    // 时价设计
    const currentpriceList1 = Array.from({ length: 200 }).map((_, idx) => ({
      value: `${idx * 2 + 1}00`,
      label: `${idx * 2 + 1}00`,
    }));
    const currentpriceList2 = Array.from({ length: 200 }).map((_, idx) => ({
      value: `${idx * 2 + 1}00`,
      label: `${idx * 2 + 1}00`,
    }));
    return{
      primaryList1,
      primaryList2,
      depositiList,
      currentpriceList1,
      currentpriceList2,
    }
  }
}


</script>

<style scoped>
  .depositi{
    width: 98%;
    background: transparent;
    padding-top: 2%;
    padding-bottom: 1%;
    border-radius: 3px;
  }
  .depositi>.el-row>.el-col>div{
    width: 95%;
    background: white;
    border-radius: 2px;
  }
  .depositi>.el-row>.el-col>div>.el-row{
    padding: 2% 2% 0 2%;
  }
</style>