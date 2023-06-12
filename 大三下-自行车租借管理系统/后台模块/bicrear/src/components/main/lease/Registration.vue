<template>
  <div style="margin-top: 3%;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">租借信息管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>租借登记</el-breadcrumb-item>
    </el-breadcrumb>
  </div>

  <div class="registration">
    <el-form :model="leaseInfo" label-width="120px">
      <!--顾客信息-->
      <el-row>
        <el-col :span="2">
          <el-tag class="ml-2" type="success">顾客信息</el-tag>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12"><div class="grid-content ep-bg-purple" />
          <el-row :gutter="10">
            <el-col :span="12">
              <el-form-item label="账号">
                <el-autocomplete
                  v-model="leaseInfo.accountcustId"
                  :fetch-suggestions="querySearchAsyncUser"
                  placeholder="手机号/账号"
                  @input="userInput"
                  @select="handleSelectUser"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="姓名">
                <el-input v-model="leaseInfo.cName" placeholder="姓名" />
              </el-form-item>
            </el-col>

          </el-row>
        </el-col>
        <el-col :span="12"><div class="grid-content ep-bg-purple" />
          <el-row gutter="10">
            <el-col :span="10">
              <el-form-item label="性别">
                <el-select v-model="leaseInfo.cSex" placeholder="性别">
                  <el-option label="男" value="男" />
                  <el-option label="女" value="女" />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="10">
              <el-form-item
                label="年龄"
                prop="cAge"
                :rules="[
                  { required: true, message: '年龄不能为空' },
                  { type: 'number', message: '必须为整数' },
                ]"
              >
                <el-input
                  v-model.number="leaseInfo.cAge"
                  type="text"
                  autocomplete="off"
                  v-min="14"
                />
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12"><div class="grid-content ep-bg-purple" />
          <el-row :gutter="10">
            <el-col :span="12">
              <el-form-item
                prop="cEmail"
                label="邮箱地址"
                :rules="[
                  {
                    required: true,
                    message: '邮箱不能为空',
                    trigger: 'blur',
                  },
                  {
                    type: 'email',
                    message: '邮箱地址不正确',
                    trigger: ['blur', 'change'],
                  },
                ]"
              >
                <el-input v-model="leaseInfo.cEmail" placeholder="xxx@xx.com" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="身份证号">
                <el-input v-model="leaseInfo.cCard" placeholder="身份证号" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="12"><div class="grid-content ep-bg-purple" />
          <el-row gutter="10">
            <el-col :span="20">
              <el-form-item label="联系地址">
                <el-input v-model="leaseInfo.cAddress" placeholder="联系地址" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
      <!--车辆信息-->
      <el-row gutter="10">
        <el-col :span="2">
          <el-tag class="ml-2" type="warning">车辆信息</el-tag>
        </el-col>
      </el-row>
      <el-row gutter="20">
        <el-col :span="12">
          <el-row gutter="10">
            <el-col :span="12">
              <el-form-item label="品牌">
                <el-select v-model="bBrand" placeholder="自行车品牌">
                  <el-option value="0" label="全部"></el-option>
                  <el-option v-for="(item, index) in brandList" :label="item.label" :value="item.value" :key="index"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item
                label="名称"
              >
                <el-autocomplete
                  v-model="zhanWei"
                  :fetch-suggestions="querySearch"
                  clearable
                  class="inline-input w-50"
                  placeholder="车辆名称"
                  @input="handlerChange"
                  @select="handleSelect"
                />
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="12">
          <el-row gutter="10">
            <el-col :span="12">
              <el-form-item
                label="数量"
                prop="number"
                :rules="[{ required: true, message: '数量不能为控' }]"
              >
                <el-input-number v-model="leaseInfo.lNumber" :min="1" :max="3" @change="handleChange" />
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
      <!--时间选择-->
      <el-row gutter="10">
        <el-col :span="2">
          <el-tag class="ml-2" type="danger">始发时间</el-tag>
        </el-col>
        <el-col :span="7">
          <!-- <el-text class="mx-1" type="danger" size="small">注：日期/时间不做选择时默认立即生效，即当前日期/时间</el-text> -->
        </el-col>
      </el-row>
      <el-row gutter="20">
        <el-col :span="12">
          <el-row gutter="10">
            <el-col :span="12">
              <el-form-item label="日期">
                <el-date-picker
                  v-model="leaseInfo.lDatefrist"
                  type="date"
                  placeholder="开始日期"
                  size="default"
                  format="YYYY-MM-DD"
                  value-format="YYYY-MM-DD"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item
                label="时间"
                prop="time"
              >
                <el-time-select
                  v-model="leaseInfo.lTimefrist"
                  start="00:00"
                  step="00:15"
                  end="23:45"
                  placeholder="开始时间"
                />
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="12">
          <el-row gutter="10">
            <el-col :span="14">
              <el-text class="mx-1" type="danger" size="small">*注：日期/时间不做选择时默认立即生效，即当前日期/时间</el-text>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
      <!--提交按钮-->
      <el-row gutter="20" style="margin-top: 3%;">
        <el-col :span="7"></el-col>
        <el-col :span="17">
          <el-form-item>
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm">清空</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
  </div>

</template>

<script>
import { reactive } from 'vue'
import axios from 'axios';

export default {
  name: 'Registration',
  data () {
    return {
      zhanWei: null,
      bBrand: null,
      // 品牌信息
      brandList: [
        {label: '捷安特', value: 'GIANT'},
        {label: '喜德盛', value: 'XDS'},
        {label: '坎普', value: 'GAMP'},
        {label: '闪电', value: 'Specialized'},
      ],
      // 自行车信息
      bicList: [],
      bicTemp: [],
      // 用户信息
      userList: [],
      userTemp: [],
      leaseInfo: {
        accountcustId: null,
        cName: '',
        cSex: '',
        cAge: '',
        cEmail: '',
        cCard: '',
        cAddress: '',
        bicycleinfoId: '',
        lNumber: 1,
        lDatefrist: new Date().getFullYear() + '-' + (new Date().getMonth() + 1) + '-' + new Date().getDate(),
        lTimefrist: new Date().toLocaleTimeString()
      }
    }
  },
  async mounted () {
    await axios.get('http://localhost:8081/bicycle/queryBicycleInfo').then((res) => {
      this.bicList = res.data.data;
      this.bicTemp = res.data.data
    });
    await axios.get('http://localhost:8081/user/queryCustomerList').then((res) => {
      this.userList = res.data.data;
      this.userTemp = res.data.data
    })
  },
  methods: {
    // 返回值
    querySearch() {
      this.bicList.forEach(element => {
        element.value = element.bName
      });
      return this.bicList
    },
    // 修改
    handleSelect(item) {
      this.leaseInfo.bicycleinfoId = item.bicycleinfoId;
      this.zhanwei = item.bicycleinfoId;
      console.log(this.leaseInfo.bicycleinfoId);
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
      if(this.leaseInfo.accountcustId === null || this.leaseInfo.accountcustId == '') return [];
      this.userList.forEach(element => {
        element.value = element.accountcustId
      });
      return this.userList
    },
    handleSelectUser(item) {
      this.leaseInfo.accountcustId = item.accountcustId;
      this.leaseInfo.cName = item.cName;
      this.leaseInfo.cSex = item.cSex;
      this.leaseInfo.cAge = item.cAge;
      this.leaseInfo.cEmail = item.cEmail;
      this.leaseInfo.cCard = item.cCard;
      this.leaseInfo.cAddress = item.cAddress;
    },
    userInput(e) {
      console.log(e)
      let temp = [];
      if(e != null || e != '') {
        this.userTemp.forEach(element => {
          if(element.accountcustId.indexOf(e) >= 0) temp.push(element)
        });
        return this.userList = temp
      }
      else this.userList = this.userTemp
    },

    async submitForm() {
      console.log(this.leaseInfo.lDatefrist);
      let code = 0;
      // let str = this.leaseInfo.lDatefrist.toString().slice(11, 10);
      // this.leaseInfo.lDatefrist = str;
      // console.log(this.leaseInfo.lDatefrist);
      await axios.post('http://localhost:8081/lease/addLeaseInfo', this.leaseInfo).then((res) => {
        code = res.data.code
      })
      if(code == 0) return alert("添加失败！");
      else {
        alert("添加成功！");
        location.reload();
      }
    },
    resetForm() {
      this.leaseInfo = {accountcustId: null, cName: '', cSex: '', cAge: '', cEmail: '', cCard: '', cAddress: '', bicycleinfoId: '', lNumber: 1,
        lDatefrist: new Date().getFullYear() + '-' + (new Date().getMonth() + 1) + '-' + new Date().getDate(),
        lTimefrist: new Date().toLocaleTimeString()
      }
    }
 
  },
  watch: {
    bBrand() {
      console.log(this.bBrand);
      if(this.bBrand === '0') return this.bicList = this.bicTemp;
      let temp = [];
      this.bicTemp.forEach(element => {
        if(element.bBrand === this.bBrand) temp.push(element)
      });
      return this.bicList = temp;
    },
  }
}
</script>

<style scoped>
  .registration{
    width: 90%;
    background: white;
    margin-top: 1%;
    padding-top: 2%;
    padding-bottom: 2%;
    border-radius: 3px;
  }
  .el-button{
    width: 100px;
    height: 33px;
    border-radius: 1px;
  }
  .el-row{
    margin-top: 1%;
  }
</style>