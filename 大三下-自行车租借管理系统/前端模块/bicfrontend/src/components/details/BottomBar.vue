<template>
    <div class="container-fluid bottomBar">
        <div class="bar">
            <div class="row">
                <div class="col-2">
                    <label>
                        <i class="bi bi-wechat" style="color: #ff8b43;"></i>
                        <br/><span>客服</span>
                    </label>
                </div>
                <div class="col-2">
                    <label>
                        <i class="bi bi-geo-alt-fill" style="color: #f96c5e;"></i>
                        <br/><span>门店</span>
                    </label>
                </div>
                <div class="col-4">
                    <button class="shopcar" @click="addReservation">加入预约单</button>
                </div>
                <div class="col-4">
                    <button class="buy" @click="goOrder">立即预约</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'BottomBar',
    data () {
        return {
            
        }
    },
    methods: {
        async goOrder() {
            if(sessionStorage.getItem("accountcustId") == null) {
                alert("请先前往登录！");
                return this.$router.push({name: 'Login'});
            }
            let code = 0;
            let bicycle = JSON.parse(decodeURIComponent(this.$route.query.bicycle));
            if(bicycle.bstock == 0) return alert("库存不足！");
            let list = [];
            list.push(sessionStorage.getItem("accountcustId"));
            list.push(bicycle.bicycleinfoId);
            await axios.post('http://localhost:8080/reservation/addReservation', list)
            .then((res) => {
                code = res.data.code;
            })
            if(code == 0) return alert("预约失败！");
            this.$router.push("Order");
        },
        async addReservation() {
            if(sessionStorage.getItem("accountcustId") == null) {
                alert("请先前往登录！");
                return this.$router.push({name: 'Login'});
            }
            let code = 0;
            let bicycle = JSON.parse(decodeURIComponent(this.$route.query.bicycle));
            if(bicycle.bstock == 0) return alert("库存不足！");
            let list = [];
            list.push(sessionStorage.getItem("accountcustId"));
            list.push(bicycle.bicycleinfoId);
            await axios.post('http://localhost:8080/reservation/addReservation', list)
            .then((res) => {
                code = res.data.code;
            })
            if(code == 0) return alert("预约失败！");
            return alert("预约成功！");
        }
    }
}
</script>
<style scoped>
.bottomBar{
    background-color: white;
    width: 100%;
}
span{
    font-size: 13px;
}
.shopcar{
    background-color: #ff7e00;
    font-size: 8px;
    width: 100px;
    height: 40px;
    color: white;
    position: relative;
    top: 5px;
    border-radius: 20px;
}
.buy{
    background-color: #ef3a3a;
    position: relative;
    top: 5px;
    font-size: 8px;
    width: 100px;
    height: 40px;
    color: white;
    border-radius: 20px;
}
</style>