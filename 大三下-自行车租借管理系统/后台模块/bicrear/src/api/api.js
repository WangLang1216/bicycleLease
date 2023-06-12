import request from "../utils/request";

// 查询自行车信息
export function getQueryBicycleInfo(pageName, pageSize, e_name) {
  return request.get('http://localhost:8081/bicycle/queryBicycleInfo',{
    params: {
      pageName,
      pageSize,
      e_name
    }
  })
}

// 新增自行车信息
export function addBicycleInfo(bicycleInfo) {
  return request.post('http://localhost:8081/bicycle/addBicycleInfo', bicycleInfo)
}

// 上传图片
export function uploadBicycleImg(image) {
  return request.post('http://localhost:8081/bicycle/uploadBicycleImg', image)
}

// 区间押金查询
export function queryDepositiInfoList() {
  return request.get('http://localhost:8081/deposit/queryDepositiInfoList')
}

// 区间时价查询
export function queryCurrentPriceInfoList() {
  return request.get('http://localhost:8081/deposit/queryCurrentPriceInfoList')
}

// 查询店铺信息
export function queryStoreInfoList() {
  return request.get('http://localhost:8081/store/queryStoreInfoList')
}

// 查询用户信息
export function queryCustomerList() {
  return request.get('http://localhost:8081/user/queryCustomerList')
}



