<template>
  <div style="margin-top: 3%;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">自行车管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>车辆新增</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
  <!--正文-->
  <div class="addBike">
    <el-form :model="bicycleInfo" :rules="rules" label-width="100px" class="demo-ruleForm">
      <el-form-item label="车辆品牌" prop="bBrand">
        <el-select class="unify" v-model="bicycleInfo.bBrand" placeholder="请选择自行车品牌">
          <el-option v-for="(item, index) in brandList" :label="item.label" :value="item.value" :key="index"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="车辆名称" prop="bName">
        <el-input class="el-input" v-model="bicycleInfo.bName" placeholder="请输入自行车名称"></el-input>
      </el-form-item>

      <el-form-item label="车辆类型" prop="bType">
        <el-select v-model="bicycleInfo.bType" placeholder="请选择自行车类型">
          <el-option label="公路车" value="公路车"></el-option>
          <el-option label="山地车" value="山地车"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="入库数量" prop="bStock">
        <el-input-number v-model="bicycleInfo.bStock" controls-position="right" @change="handleChange" :min="1"></el-input-number>
      </el-form-item>

      <el-row gutter="20">
        <el-col :span="6">
          <el-form-item label="押金选择" prop="depositId">
            <el-select v-model="bicycleInfo.depositId" class="m-2" placeholder="押金" size="default">
              <el-option
                v-for="item in depositiInfoList"
                :key="item.depositId"
                :label="item.value"
                :value="item.depositId"
              />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="时价选择" prop="currentpriceId">
            <el-select v-model="bicycleInfo.currentpriceId" class="m-2" placeholder="时价" size="default">
              <el-option
                v-for="item in currentPriceInfoList"
                :key="item.currentpriceId"
                :label="item.value"
                :value="item.currentpriceId"
              />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="位置选择" prop="storeId">
            <el-select v-model="bicycleInfo.storeId" class="m-2" placeholder="位置" size="default">
              <el-option
                v-for="item in storeInfoList"
                :key="item.storeId"
                :label="item.value"
                :value="item.storeId"
              />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      
      <el-form-item label="车辆图像" prop="bImgurl">
        <el-upload
          ref="upload"
          action=""
          list-type="picture"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          :on-change="UploadImage"
          :limit="1"
          :file-list="fileList"
          :auto-upload="false"
        >
          <el-button type="primary">选择图片</el-button>
          <i class="el-icon-plus"></i>
          <template #tip>
            <div style="font-size: 12px; color: #919191;">
              单次限制上传一张图片
            </div>
          </template>
        </el-upload>
        <el-dialog v-model="dialogVisible" style="line-height: 0;">
          <img style="width: 100%;height: 100%"  :src="dialogImageUrl" alt="" />
        </el-dialog>
      </el-form-item>
      
      <el-form-item label="车辆简介">
        <el-input class="el-input" type="textarea" v-model="bicycleInfo.bEssay"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="addBicycle">立即创建</el-button>
        <el-button @click="resting">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { onMounted, ref, reactive } from 'vue'
import axios from 'axios'

export default {
  name: 'AddBike',
  data() {
    return {
      // 品牌信息
      brandList: [
        {label: '捷安特', value: 'GIANT'},
        {label: '喜德盛', value: 'XDS'},
        {label: '坎普', value: 'GAMP'},
        {label: '闪电', value: 'Specialized'},
      ],
      // 自行车信息
      bicycleInfo: {
        storeId:'',
        depositId: '',
        currentpriceId: '',
        bBrand: '',
        bName: '',
        bType: '',
        bStock: 1,
        bImage: '',
        bImgurl: '',
        bEssay: ''
      },
      imgUrl: 'http://localhost:8081/bicycle/uploadBicycleImg',
      // 押金信息
      depositiInfoList: [],
      // 时价信息
      currentPriceInfoList: [],
      // 店铺信息
      storeInfoList: [],
      rules: {
        bBrand: [
          { required: true, message: '请选择品牌名', trigger: 'blur' }
        ],
        bName: [
          { required: true, message: '请输入车辆名称', trigger: 'blur' },
          { min: 3, max: 20, message: '长度在 3 到 20个字符', trigger: 'blur' }
        ],
        bType: [
          { required: true, message: '请选择自行车类型', trigger: 'blur' }
        ],
        handleChange(value) {
          console.log(value);
        }
      },
      fileList: [],
      dialogImageUrl: '',
      dialogVisible: false,
    };
  },
  async mounted () {
    let temp = [];
    await axios.get('http://localhost:8081/deposit/queryDepositiInfoList').then((res) => {temp = res.data.data});
    temp.forEach(element => {
      let i = {
        depositId: element.depositId,
        value: element.dPrice,
      }
      this.depositiInfoList.push(i)
    });
    await axios.get('http://localhost:8081/deposit/queryCurrentPriceInfoList').then((res) => {temp = res.data.data});
    temp.forEach(element => {
      let i = {
        currentpriceId: element.currentpriceId,
        value: element.cPrice
      }
      this.currentPriceInfoList.push(i)
    });
    await axios.get('http://localhost:8081/store/queryStoreInfoList').then((res) => {temp = res.data.data});
    temp.forEach(element => {
      let i = {
        storeId: element.storeId,
        value: element.sAddress
      }
      this.storeInfoList.push(i)
    });
  },
  methods: {
    async addBicycle() {
      let code = 0;
      this.bicycleInfo.bImage = this.bicycleInfo.bName;
      await axios.post('http://localhost:8081/bicycle/addBicycleInfo', this.bicycleInfo).then((res) => {code = res.data.code})
      if(code == 0) return alert("添加失败，不能为空！");
      this.bicycleInfo =  {storeId:'', depositId: '', currentpriceId: '', bBrand: '', bName: '', bType: '', bStock: 1, bImage: '', bImgurl: '', bEssay: ''};
      return alert("添加成功！")
    },
    //上传图片的方法
    async UploadImage(file, filelist) {
      //console.log(file);
      let fd = new FormData()
      fd.append('image', file.raw) //传给后台接收的名字 file
      await axios.post('http://localhost:8081/bicycle/uploadBicycleImg', 
        fd, {headers: {'Content-Type': 'multipart/form-data'}}).then(res => {
        //上传成功后返回的数据,
        console.log("上传图片到:" + res.data);
        // 将图片地址给到表单.
        this.bicycleInfo.bImgurl = res.data.data
      })
    },
    //移除图片功能
    handleRemove(file, fileList) {
      console.log(file, fileList)
    },
    //预览图片功能
    handlePictureCardPreview(file) {
      console.log(file.url);
      this.dialogVisible = true
      this.dialogImageUrl = file.url
    },
    // 重置
    resting() {
      let a = confirm("确定重置吗？")
      if(a) this.bicycleInfo =  {storeId:'', depositId: '', currentpriceId: '', bBrand: '', bName: '', bType: '', bStock: 1, bImage: '', bImgurl: '', bEssay: ''};
    }
  },
  watch: {

  },
  setup() {
    
  }
}
</script>

<style scoped>
  .addBike{
    width: 80%;
    background: white;
    margin-top: 1%;
    padding-top: 2%;
    padding-bottom: 5%;
    border-radius: 3px;
  }
  .el-input{
    width: 50%;
  }
  button{
    border-radius: 1px;
  }
</style>