<!--
 * @Author: WangCute 2605735186@qq.com
 * @Date: 2023-05-23 15:18:51
 * @LastEditors: WangCute 2605735186@qq.com
 * @LastEditTime: 2023-06-12 18:01:28
 * @FilePath: \bicrear\src\components\main\frontend\Carousel.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div style="margin-top: 3%;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">前端数据管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>轮播图设计</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
  
  <div class="carousel">
    <!--添加-->
    <div>
      <el-row gutter="20">
        <el-col :span="2" style="margin-top: 0.3%;"><el-tag>快捷添加</el-tag></el-col>
        <el-col :span="4">
          <el-form-item label="名称">
            <el-autocomplete
              v-model="bicycle"
              :fetch-suggestions="querySearch"
              clearable
              class="inline-input w-50"
              placeholder="车辆名称"
              @input="handlerChange"
              @select="handleSelect"
            />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item>
            <el-button type="primary" @click="addBick">添加</el-button>
          </el-form-item>
        </el-col>
        <el-col :span="2"><el-tag style="margin-top: 1%;" type="success">自定义添加</el-tag></el-col>
        <el-col :span="4">
          <el-form-item label="名称">
            <el-input v-model="image" placeholder="自定义名称" />
          </el-form-item>
        </el-col>
        <el-col :span="2">
          <el-upload
            ref="upload"
            action=""
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
            :on-change="UploadImage"
            :limit="1"
            :file-list="fileList"
            :auto-upload="false"
          >
            <el-button type="primary">选择图片</el-button>
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog v-model="dialogVisible" style="line-height: 0;">
            <img style="width: 100%;height: 100%"  :src="dialogImageUrl" alt="" />
          </el-dialog>
        </el-col>
        <el-col :span="2">
          <el-form-item>
            <el-button type="warning" @click="addCustom">添加</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </div>
    <!--列表数据-->
    <div>
      <el-table ref="tableRef" row-key="date" :data="carouselList" style="width: 100%">
        <el-table-column type="index" width="50" />
        <el-table-column
          prop="cimgurl"
          label="图像"
          width="120">
          <template #default="scope">
            <div class="demo-image__preview">
              <el-image
                style="width: 80%"
                :src="scope.row.cimgurl"
                :zoom-rate="1.2"
                :initial-index="0"
                preview-teleported="true"
                fit="cover"
              />
            </div>
          </template>
        </el-table-column>
        <el-table-column prop="cimage" width="305" label="图名" />
        <!-- <el-table-column prop="b_brand" label="品牌" />
        <el-table-column prop="b_name" label="名称" />
        <el-table-column prop="b_type" label="类型" /> -->
        <el-table-column prop="cimgurl" width="580" label="图片地址" show-overflow-tooltip />
        <el-table-column label="操作">
          <template #default="scope">
            <el-button
              size="small"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
        
      </el-table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Carousel',
  data () {
    return {
      carouselList: [],
      bicycle: null,
      bicycleId: null,
      // 自行车信息
      bicList: [],
      bicTemp: [],
      imgurl: '',
      image: '',
    }
  },
  async mounted () {
    await axios.get('http://localhost:8080/product/queryCarousel').then((res) => {this.carouselList = res.data.data});
    await axios.get('http://localhost:8081/bicycle/queryBicycleInfo').then((res) => {
      this.bicList = res.data.data;
      this.bicTemp = res.data.data
    });
  },
  methods: {
    //上传图片的方法
    async UploadImage(file, filelist) {
      //console.log(file);
      let fd = new FormData()
      fd.append('image', file.raw) //传给后台接收的名字 file
      await axios.post('http://localhost:8081/bicycle/uploadBicycleImg', 
        fd, {headers: {'Content-Type': 'multipart/form-data'}}).then((res) => {
        //上传成功后返回的数据,
        console.log("上传图片到:" + res.data.data);
        // 将图片地址给到表单.
        this.imgurl = res.data.data;
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
    // DIY图片
    async addCustom() {
      let code = 0;
      console.log(this.imgurl);
      if(this.imgurl == null || this.imgurl == '') return alert('地址不能为空！');
      let temp = {};
      temp.image = this.image;
      temp.imgurl = this.imgurl;
      await axios.post('http://localhost:8081/carousel/addCarouselInfoDIY', temp).then((res) => {code = res.data.code});
      if(code == 0) return alert('添加失败！');
      alert("添加成功！");
      location.reload();
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
      this.bicycle = item.bName;
      this.bicycleId = item.bicycleinfoId
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
    // 添加
    async addBick() {
      let code = 0;
      let bicycleinfoId = this.bicycleId;
      await axios.get('http://localhost:8081/carousel/addCarouselInfo/' + bicycleinfoId).then((res) => {code = res.data.code});
      if(code == 0) return alert('添加失败！');
      alert("添加成功！");
      location.reload();
    },
    // 删除
    async handleDelete(index, row) {
      let code = 0;
      let carouselId = row.carouselId;
      await axios.get('http://localhost:8081/carousel/deleteCarouselInfoById/' + carouselId).then((res) => {code = res.data.code});
      if(code == 0) return alert('删除失败！');
      alert("删除成功！");
      location.reload();
    }
  }
    
}
</script>

<style scoped>
  .carousel{
    width: 90%;
    background: white;
    margin-top: 1%;
    padding-top: 2%;
    padding-bottom: 2%;
    border-radius: 3px;
  }
  .carousel>div:nth-child(1){
    padding-left: 1%;
    padding-right: 2%;
  }
  .carousel>div:nth-child(2){
    padding-left: 1%;
    /* padding-right: 1%; */
  }
  .el-button{
    border-radius: 1px;
  }
</style>