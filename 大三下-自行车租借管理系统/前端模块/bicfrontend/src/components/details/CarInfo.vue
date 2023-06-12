<template>
    <div class="container-fluid carInfo">
        <!--自行车信息头部，轮播图-->
        <div class="carousel slide" data-bs-ride="carousel">
        <!-- 轮播图片 -->
            <div class="carousel-inner">
                <div class="carousel-item active" v-for="(item, index) in carurl" :key="index">
                    <img decoding="async" class="d-block" :src="item.bimgurl">
                    <p>{{ index+1 }}/{{ carurl.length }}</p>
                </div>
            </div>
        </div>
        <button type="button" @click="goHome">
            <i class="bi bi-chevron-left"></i>
        </button>
        <div class="info">
            <h2><strong>￥{{ bicycle.cprice }}元/时</strong></h2>
            <p style="color: orange;font-size: 20px;text-align: left;">{{ bicycle.bbrand }}<span style="margin-left: 1%;font-size: 18px;color: black;">{{ bicycle.bname }}</span></p>
            <p style="color: black;font-size: 15px;text-align: left;">{{ bicycle.saddress }}</p>
        </div>
      
        <img :src="imgATX" class="atx"/>
        <h2>简介</h2>
        <h6 style="margin-top: 2%;">
            {{ bicycle.bessay }}
        </h6>
        
    </div>
</template>

<script>
import axios from 'axios';

export default{
    name: 'CarInfo',
    data(){
        return{
            imgATX:"https://giant-shop.oss-cn-shanghai.aliyuncs.com/admin/ueditor/20221103/166746164379941.jpg",
            carurl:[],
            // carinfo:[
            //     {price:2198.00,"name":"捷安特新款ATX 720山地车"}
            // ],
            bicycle:{}
        }
    },
    async mounted() {
        this.bicycle = JSON.parse(decodeURIComponent(this.$route.query.bicycle));
        await axios.get('http://localhost:8080/product/queryBicycleImages/' + this.bicycle.bicycleinfoId)
        .then((res) => {
            this.carurl = res.data.data
        })
    },
    methods: {
        goHome() {
            this.$router.push("Home")
        }
    },
    
}
</script>
<style scoped>
.bg{
    background-color: white;
    height: 10px;
    width: 10px;
    position: relative;
    left: 200px;
    top: 55px;
}
.carInfo img{
    width: 100%;
}
.info h2{
    color: red;
    margin-left: -235px;
}
.info h1{
    margin-left: -42px;
}
button{
    background-color: transparent;
    position: fixed;
    height: 35px;
    width: 35px;
    left: 5px;
    top: 10px;
    border-radius: 30px;
}
button i{
    font-size: 30px;
    position: absolute;
    top: -5px;
    left: 2px;
    font-weight: bold;
}
.tag{
    right: 0px;
    top: 10px;
    background-color: grey;
    width: 40px;
    height: 20px;
}
/* p{
    position: fixed;
    z-index: 999;
} */
/* .atx{
    position: relative;
    top: 40px;
} */
</style>