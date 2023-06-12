//index.js
//导入axios
import axios from 'axios'

//创建axios实例
const request = axios.create({
	//统一的url前缀
	baseURL:"http://localhost:5714",
	//超时时间
	timeout:5000,
	//自定义请求头
	headers:{'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'},
})

//request请求拦截
request.interceptors.request.use(config => {
	//判断token是否存在，存在则向请求头添加token信息
	if(sessionStorage.getItem("token")){
		config.headers.Authorization = sessionStorage.getItem("token") 
	}
	return config
}),err => {
	//对请求错误进行处理
	return Promise.reject(err)
}

//response 响应拦截
request.interceptors.response.use(res => {
	//成功获取信息
	if(res.code == 200){
		return res
	}
	return res
}),err => {
	//对响应错误进行处理
	return Promise.reject(err)
}


export default request