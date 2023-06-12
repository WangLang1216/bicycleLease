<template>
  <div style="margin-top: 3%;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">自行车管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>车辆信息</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
  <div class="bikeInfo">
    <!--头部操作-->
    <div>
      <div>
        <el-form :inline="true" :model="bicycleInfoList" class="demo-form-inline">
          <el-form-item label="名称">
            <el-input v-model="bName" placeholder="自行车名称" />
          </el-form-item>
          <el-form-item label="品牌">
            <el-select style="width: 130px;" v-model="bBrand" placeholder="自行车品牌">
              <el-option label="全部" value="0"></el-option>
              <el-option v-for="(item, index) in brandList" :label="item.label" :value="item.value" :key="index"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="queryBrand">查询</el-button>
          </el-form-item>
        </el-form>
      </div>
      <div style="padding-right: 2%;">
        <el-button type="danger" @click="delBicycleInfoList">删除</el-button>
      </div>
      
    </div>
    <!--列表数据-->
    <div>
      <el-table
        ref="multipleTable"
        :data="bicycleInfoList.slice((currentPage-1)*pageSize,currentPage*pageSize)"
        tooltip-effect="dark"
        style="width: 100%; text-align: left;"
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          label="图像"
          width="120">
          <template #default="scope">
            <div class="demo-image__preview">
              <el-image
                style="width: 80%"
                :src="scope.row.bImgurl"
                :zoom-rate="1.2"
                :preview-src-list="images"
                :initial-index="0"
                preview-teleported="true"
                fit="cover"
              />
            </div>
          </template>
        </el-table-column>
        <el-table-column
          prop="bicycleinfoId"
          label="编号"
          show-overflow-tooltip
          width="100">
        </el-table-column>
        <el-table-column
          prop="bBrand"
          label="品牌"
          width="90">
        </el-table-column>
        <el-table-column
          prop="bName"
          label="名称"
          show-overflow-tooltip
          width="120">
        </el-table-column>
        <el-table-column
          prop="bType"
          label="类型"
          width="80">
        </el-table-column>
        <el-table-column
          prop="bStock"
          label="库存"
          sortable
          width="80">
        </el-table-column>
        <el-table-column
          prop="cPrice"
          label="时价"
          sortable
          width="80">
        </el-table-column>
        <el-table-column
          prop="dPrice"
          label="押金"
          sortable
          width="80">
        </el-table-column>
        <el-table-column
          prop="sAddress"
          label="地址"
          width="150"
          show-overflow-tooltip
          :filters=addressList
          :filter-method="filterTag"
          filter-placement="bottom-end">
          <template #default="scope">
            {{ scope.row.sAddress }}
          </template>
        </el-table-column>
        <el-table-column
          prop="bEssay"
          label="简介"
          width="150"
          show-overflow-tooltip>
        </el-table-column>
        <el-table-column label="操作">
          <template #default="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!--修改自行车部分-->
    <el-drawer v-model="drawer" direction="ltr">
      <template #header>
        <h4>修改自行车信息</h4>
      </template>
      <template #default>
        <div>
          <el-form :model="bikeInfo" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="车辆品牌">
              <el-select class="unify" v-model="bikeInfo.bBrand" placeholder="请选择自行车品牌">
                <el-option v-for="(item, index) in brandList" :label="item.label" :value="item.value" :key="index"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="车辆名称">
              <el-input class="el-input" v-model="bikeInfo.bName" placeholder="请输入自行车名称" style="width: 68%;"></el-input>
            </el-form-item>
            <el-form-item label="车辆类型">
              <el-select v-model="bikeInfo.bType" placeholder="请选择自行车类型">
                <el-option label="公路车" value="公路车"></el-option>
                <el-option label="山地车" value="山地车"></el-option>
              </el-select>
            </el-form-item>

            <el-row gutter="20">
              <el-col :span="12">
                <el-form-item label="押金选择">
                  <el-select v-model="bikeInfo.depositId" class="m-2" placeholder="押金" size="default">
                    <el-option
                      v-for="item in depositiInfoList"
                      :key="item.depositId"
                      :label="item.value"
                      :value="item.depositId"
                    />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="时价选择">
                  <el-select v-model="bikeInfo.currentpriceId" class="m-2" placeholder="时价" size="default">
                    <el-option
                      v-for="item in currentPriceInfoList"
                      :key="item.currentpriceId"
                      :label="item.value"
                      :value="item.currentpriceId"
                    />
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="20">
                <el-form-item label="位置选择">
                  <el-select v-model="bikeInfo.storeId" class="m-2" placeholder="位置" size="default">
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

            <el-form-item label="入库数量">
              <el-input-number v-model="bikeInfo.bStock" controls-position="right" @change="handleChange" :min="1"></el-input-number>
            </el-form-item>
            <el-form-item label="车辆图像">
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
              <el-input class="el-input" type="textarea" v-model="bikeInfo.bEssay" style="height: 200px;"></el-input>
            </el-form-item>
          </el-form>
        </div>
      </template>
      <template #footer>
        <div style="flex: auto">
          <el-button @click="drawer=false">取消</el-button>
          <el-button type="primary" @click="confirmClick">确定</el-button>
        </div>
      </template>
    </el-drawer>

    <!--分页-->
    <div style="margin-top: 1%;">
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
            :total="bicycleInfoList.length">
          </el-pagination>
        </el-col>
      </el-row>
    </div>

  </div>
</template>

<script>
import { ref } from 'vue'
import { reactive } from 'vue'
import { ElMessageBox } from 'element-plus'
import { getCurrentInstance } from "vue";
import axios from 'axios';

// import { tr } from 'element-plus/es/locale'

export default {
  name: 'BikeInfo',
  data () {
    return {
      bBrand: null,
      bName: null,
      // 品牌信息
      brandList: [
        {label: '捷安特', value: 'GIANT'},
        {label: '喜德盛', value: 'XDS'},
        {label: '坎普', value: 'GAMP'},
        {label: '闪电', value: 'Specialized'},
      ],
      addressList: [
        {text: "成都市武侯区锦城大道南段", value: "成都市武侯区锦城大道南段"},
        {text: "成都市新都区新都大道西段", value: "成都市新都区新都大道西段"},
        {text: "成都市青羊区青羊大道北段", value: "成都市青羊区青羊大道北段"},
      ],
      bicycleInfoList: [],
      images: [
        'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220819/166087296229868.jpg',
        'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20230519/168445705542796.jpg',
        'https://giant-img.oss-cn-shanghai.aliyuncs.com/bike/20220819/166087296229868.jpg'
      ],
      currentPage: 1, // 当前页码
      total: 20, // 总条数
      pageSize: 6, // 每页的数据条数
      multipleSelection: [],
      listTemp: [],
       // 押金信息
       depositiInfoList: [],
      // 时价信息
      currentPriceInfoList: [],
      // 店铺信息
      storeInfoList: [],

      fileList: [],
      dialogImageUrl: '',
      dialogVisible: false,
    }
  },
  async mounted () {
    await axios.get('http://localhost:8081/bicycle/queryBicycleInfo')
    .then((res) => {
      this.bicycleInfoList = res.data.data;
      this.listTemp = res.data.data
    })

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
    handleSelectionChange(val) {
      console.log(val);
      this.multipleSelection = [];
      val.forEach(element => {
        this.multipleSelection.push(element.bicycleinfoId)
      });
    },
    // 删除
    async delBicycleInfoList() {
      let code = 0;
      await axios.post('http://localhost:8081/bicycle/deleteBicycleInfoListById', this.multipleSelection)
      .then((res) => {
        code = res.data.code
      })
      if(code == 1) {
        alert("删除成功！")
        return location.reload();
      }
      else return alert("删除失败！")
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
    },
    // 查询
    queryBrand() {
      let temp = [];
      if((this.bName != null) && (this.bBrand != null && this.bBrand != '0')) {
        this.listTemp.forEach(element => {
          if(element.bName.indexOf(this.bName) >= '0') temp.push(element)
        });
        let r = [];
        temp.forEach(element => {
          if(element.bBrand === this.bBrand) r.push(element)
        });
        return this.bicycleInfoList = r
      }
      else if(this.bName != null) {
        this.listTemp.forEach(element => {
          if(element.bName.indexOf(this.bName) >= '0') temp.push(element)
        });
        return this.bicycleInfoList = temp
      }
      else if(this.bBrand != null && this.bBrand != '0') {
        this.listTemp.forEach(element => {
          if(element.bBrand === this.bBrand) temp.push(element)
        });
        return this.bicycleInfoList = temp
      }
      return this.bicycleInfoList = this.listTemp;
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
        this.imgUrl = res.data.data
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
  },
  setup() {
    const exData = getCurrentInstance();
    const drawer = ref(false);
    const bikeInfo = reactive({bicycleinfoId: '', bBrand: '', bName: '', bType: '', bStock: null, cPrice: '', dPrice: '',  sAddress: '', bImage: '', bImgurl: '', bEssay: ''});
    let i = ref(null);
    const handleClose = done => {
      ElMessageBox.confirm('Are you sure you want to close this?')
        .then(() => {
          done()
        })
        .catch(() => {
          // catch error
        })
    }
    // 赋值
    function assignment(data) {
      bikeInfo.bicycleinfoId = data.bicycleinfoId;
      bikeInfo.bBrand = data.bBrand;
      bikeInfo.bName = data.bName;
      bikeInfo.bType = data.bType;
      bikeInfo.bStock = data.bStock;
      bikeInfo.cPrice = data.cPrice,
      bikeInfo.dPrice = data.dPrice;
      bikeInfo.sAddress = data.sAddress;
      bikeInfo.bImage = data.bName;
      bikeInfo.bImgurl = data.bImgurl;
      bikeInfo.bEssay = data.bEssay;
    }
    // 编辑按钮
    function handleEdit(index, row) {
      drawer.value = true;
      assignment(row);
      i.value = index;
    }
    // 点击确定按钮
    async function confirmClick() {
      console.log("进来了");
      let code = 0;
      drawer.value = false;
      await axios.post('http://localhost:8081/bicycle/updateBicycleInfoById', bikeInfo)
      .then((res) => {
        code = res.data.code
      })
      if(code == 1) {
        exData.data.bicycleInfoList[i.value] = bikeInfo;
        return alert("修改成功！")
      }
      else return alert("修改失败！")
    }
    // 地区筛选
    const filterTag = (value, row) => {
      return row.sAddress === value
    };
    //上传图片的方法
    async function UploadImage(file, filelist) {
      //console.log(file);
      let fd = new FormData()
      fd.append('image', file.raw) //传给后台接收的名字 file
      await axios.post('http://localhost:8081/bicycle/uploadBicycleImg', 
        fd, {headers: {'Content-Type': 'multipart/form-data'}}).then(res => {
        //上传成功后返回的数据,
        console.log("上传图片到:" + res.data);
        // 将图片地址给到表单.
        bikeInfo.bImgurl = res.data.data
      })
    };
    //移除图片功能
    function handleRemove(file, fileList) {
      console.log(file, fileList)
    };
    //预览图片功能
    function handlePictureCardPreview(file) {
      console.log(file.url);
      this.dialogVisible = true
      this.dialogImageUrl = file.url
    };
    return{
      drawer,
      handleClose,
      handleEdit,
      confirmClick,
      bikeInfo,
      filterTag,
      UploadImage,
      handleRemove,
      handleRemove
    }
  }
}
</script>

<style scoped>
  .bikeInfo{
    width: 95%;
    background: white;
    margin-top: 1%;
    padding-top: 2%;
    padding-bottom: 1%;
    border-radius: 3px;
  }
  .bikeInfo>div:nth-child(1){
    padding-left: 1%;
    text-align: left;
    display: flex;
  }
  .bikeInfo>div:nth-child(1)>div:nth-child(2){
    text-align: right;
    flex: 1;
    padding-right: 1%;
  }
  .bikeInfo>div:nth-child(2){
    padding-left: 1%;
    padding-right: 1%;
  }
  .demo-image__error .image-slot {
    font-size: 30px;
  }
  .demo-image__error .image-slot .el-icon {
    font-size: 30px;
  }
  .demo-image__error .el-image {
    width: 100%;
    height: 200px;
  }
  .el-button{
    border-radius: 1px;
  }
</style>