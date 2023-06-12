<template>
  <div style="margin-top: 3%;">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item><a href="/">前端数据管理</a></el-breadcrumb-item>
      <el-breadcrumb-item>板块数据设计</el-breadcrumb-item>
    </el-breadcrumb>
  </div>

  <div class="segmentData">
    <!--添加-->
    <div>
      <el-row gutter="20">
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
        <el-col :span="4">
          <el-form-item label="板块">
            <el-select v-model="plate" class="m-2" placeholder="板块选择">
              <el-option
                v-for="item in p_plateList"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item>
            <el-button type="primary" @click="addBick">添加</el-button>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item>
            <el-button type="warning" @click="delBick">批量删除</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </div>
    <!--列表数据-->
    <div>
      <el-table row-key="date" @selection-change="selectList" :data="segmentData.slice((currentPage-1)*pageSize,currentPage*pageSize)" style="width: 100%">
        <el-table-column type="selection" width="50" />
        <el-table-column
          prop="bimgurl"
          label="图像"
          width="120">
          <template #default="scope">
            <div class="demo-image__preview">
              <el-image
                style="width: 80%"
                :src="scope.row.bimgurl"
                :zoom-rate="1.2"
                :initial-index="0"
                preview-teleported="true"
                fit="cover"
              />
            </div>
          </template>
        </el-table-column>
        <el-table-column prop="bbrand" label="品牌" />
        <el-table-column prop="bname" label="名称" />
        <el-table-column prop="btype" label="类型" />
        <el-table-column prop="bstock" label="库存" sortable />
        <el-table-column prop="saddress" width="200" label="位置" show-overflow-tooltip/>
        <el-table-column
          prop="pplate"
          label="板块"
          width="120"
          :filters="[
            {text: '推荐', value: '推荐'},
            {text: '公路车', value: '公路车'},
            {text: '山地车', value: '山地车'},
            {text: '配件', value: '配件'},
          ]"
          :filter-method="filterPlate"
          filter-placement="bottom-end"
        >
          <template #default="scope">
            <el-tag
              :type=getSegment(scope.row.pplate)
              disable-transitions
              >{{ scope.row.pplate }}</el-tag
            >
          </template>
        </el-table-column>
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
    <!--分页-->
    <div>
      <el-row gutter="20">
        <el-col :span="7"></el-col>
        <el-col :span="17">
          <el-pagination
            @size-change="handleSizeChange" 
            @current-change="handleCurrentChange"
            :current-page="currentPage" 
            :page-sizes="[1, 5, 10, 20, 50, 100, 500]" 
            :page-size="pageSize" 
            layout="total, sizes, prev, pager, next, jumper" 
            :total="segmentData.length">
          </el-pagination>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'SegmentData',
  data () {
    return {
      segmentData: [],
      segmentDataTemp: [],
      currentPage: 1, // 当前页码
      total: 20, // 总条数
      pageSize: 6, // 每页的数据条数
      p_plateList: [
        { label: '推荐', value: '推荐' },
        { label: '公路车', value: '公路车' },
        { label: '山地车', value: '山地车' },
        { label: '配件', value: '配件' }
      ],
      plate: null,
      bicycle: null,
      bicycleId: null,
      // 自行车信息
      bicList: [],
      bicTemp: [],
      platedataIdList: [],
    }
  },
  async mounted () {
    await axios.get('http://localhost:8081/plate/queryPlateDataAll').then((res) => {
      this.segmentData = res.data.data;
      this.segmentDataTemp = res.data.data
    });
    await axios.get('http://localhost:8081/bicycle/queryBicycleInfo').then((res) => {
      this.bicList = res.data.data;
      this.bicTemp = res.data.data
    });
  },
  methods: {
    // 添加
    async addBick() {
      let code = 0;
      await axios.get('http://localhost:8081/plate/addPlateDataInfo/' + this.bicycleId + '/' + this.plate).then((res) => {code = res.data.code});
      if(code == 0) return alert('新增失败！');
      alert("新增成功！");
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
    // 选中
    selectList(item) {
      this.platedataIdList = [];
      item.forEach(element => {
        this.platedataIdList.push(element.platedataId)
      });
    },
    // 批量删除
    async delBick() {
      let code = 0;
      await axios.post('http://localhost:8081/plate/deletePlateDataListById', this.platedataIdList).then((res) => {code = res.data.code});
      if(code == 0) return alert('删除失败！');
      alert("删除成功！");
      location.reload();
    },
    async handleDelete(index, row) {
      let code = 0;
      let temp = [];
      temp.push(row.platedataId)
      await axios.post('http://localhost:8081/plate/deletePlateDataListById', temp).then((res) => {code = res.data.code});
      if(code == 0) return alert('删除失败！');
      alert("删除成功！");
      location.reload();
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
    getSegment(p_plate){
      if(p_plate == '推荐') return 'success';
      else if(p_plate == '公路车') return ' ';
      else if(p_plate == '山地车') return 'warning';
      else return 'info';
    }
  },
  setup() {
    const filterPlate = (value, row) => {
      return row.pplate == value
    }
    return {
      filterPlate
    }
  }
}
</script>

<style scoped>
  .segmentData{
    width: 90%;
    background: white;
    margin-top: 1%;
    padding-top: 2%;
    padding-bottom: 1%;
    border-radius: 3px;
  }
  .segmentData>div:nth-child(1){
    padding-left: 2%;
  }
  .segmentData>div:nth-child(2){
    padding-left: 2%;
    padding-right: 2%;
  }
  .segmentData>div:nth-child(3){
    margin-top: 1%;
  }
  .el-button{
    border-radius: 1px;
  }
</style>