<template>
  <div class="store">
    <!--顶部搜索栏和新增按钮-->
    <el-row>
      <el-col :span="4">
        <div class="flex">
          <el-input placeholder="请输入店铺名称" prefix-icon="el-icon-search" v-model="search" size="default"></el-input>
          <el-button type="primary" style="margin-left: 5%;">搜索</el-button>
        </div>
      </el-col>
      <el-col :span="10"></el-col>
      <el-col :span="10">
        <div>
          <el-button type="primary" @click="drawer = true">新增店铺</el-button>
        </div>
      </el-col>
    </el-row>
    <!--店铺信息展示-->
    <div class="storeinfo">
        <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        prop="storeId"
        label="店铺编号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="sName"
        label="联系人"
        width="180">
      </el-table-column>
      <el-table-column
        prop="sAddress"
        label="店铺地址"
        width="200">
      </el-table-column>
      <el-table-column
        prop="sPhone"
        label="店铺电话"
        width="180">
      </el-table-column>
      <el-table-column
        prop="sStatus"
        label="店铺状态"
        width="180">
      </el-table-column>
      <el-table-column
        prop="status"
        label="操作"
        show-overflow-tooltip>
        <template #default="scope">
          <el-button type="primary" @click="editStoreInfo(scope.$index,scope.row)">修改</el-button>
        </template>
      </el-table-column>
    </el-table>
    </div>
  </div>
  <!--新增店铺信息-->
  <div>
    <el-drawer
    v-model="drawer"
    title="新增店铺"
    :direction="direction">
    <!--新增店铺表单-->
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="店铺名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="店铺地址" prop="address">
        <el-input v-model="ruleForm.address"></el-input>
      </el-form-item>
      <el-form-item label="店铺电话" prop="phone">
        <el-input v-model="ruleForm.phone"></el-input>
      </el-form-item>
      <el-form-item style="margin-left: 50px;">
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </el-drawer>
  </div>
  <!--修改店铺信息-->
  <div>
    <el-drawer
    v-model="drawer1"
    title="修改店铺信息"
    :direction="directionl">
    <el-form :model="storeInfo" label-width="100px">
    <el-form-item label="店铺编号">
      <el-input v-model="storeInfo.store_id" />
    </el-form-item>
    <el-form-item label="店铺名称">
      <el-input v-model="storeInfo.name" />
    </el-form-item>
    <el-form-item label="店铺地址">
      <el-input v-model="storeInfo.address" />
    </el-form-item>
    <el-form-item label="店铺编号">
      <el-input v-model="storeInfo.phone" />
    </el-form-item>
    <el-form-item label="店铺状态">
      <el-input v-model="storeInfo.status" />
    </el-form-item>
    <el-form-item>
        <el-button type="primary" @click="editFrim">提交</el-button>
        <el-button @click="drawer1=false">关闭</el-button>
      </el-form-item>
  </el-form>
    
  </el-drawer>
  </div>
</template>

<script>
import { ref } from 'vue'
import axios from 'axios'
  export default {
    data() {
      return {
        index: null,
        storeInfo: {store_id: '', name: '', address: '', phone:'', status: null},
        tableData: [],
        multipleSelection: [],
        search:null,
        ruleForm: {
          name: '',
          address:'',
          phone:'',
          region: ''
        },
        rules: {
          name: [
            { required: true, message: '请输入店铺名称', trigger: 'blur' },
            { min: 2, max: 100, message: '请正确输入店铺名称', trigger: 'blur' }
          ],
          address:[
            { required: true, message: '请输入店铺地址', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
          ],
          phone:[
            { required: true, message: '请输入店铺联系电话', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 11 字符', trigger: 'blur' }
          ],
        }
      }
    },
    async mounted () {
      await axios.get('http://localhost:8081/store/queryStoreInfoList').then((res) => {this.tableData = res.data.data})
    },
    methods: {
      toggleSelection(rows) {
        if (rows) {
          rows.forEach(row => {
            this.$refs.multipleTable.toggleRowSelection(row);
          });
        } else {
          this.$refs.multipleTable.clearSelection();
        }
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      // 修改信息
      editStoreInfo(index, row) {
        this.drawer1 = true;
        this.index = index;
        this.edit(row);
        console.log(this.storeInfo);
      },
      edit(data) {
        this.storeInfo.store_id = data.store_id;
        this.storeInfo.name = data.name;
        this.storeInfo.address = data.address;
        this.storeInfo.phone = data.phone;
        this.storeInfo.status = data.status;
      },
      editFrim() {
        this.drawer1=false
        this.tableData[this.index] = this.storeInfo;
      }
    },

    setup(){
      const drawer = ref(false)
      const drawer1=ref(false)
      const direction = ref('rtl')
      const directionl= ref('ltr')
      return{
        drawer,
        drawer1,
        direction,
        directionl
      }
    },
  }
</script>

<style scoped>
.store{
  margin-top: 80px;
}
.flex{
  display: flex;
}
.storeinfo{
  margin-top: 20px;
  width: 82.5%;
}
.el-button{
  border-radius: 1px;
}
</style>