import { createRouter, createWebHashHistory } from "vue-router";
import Home from '../components/home/Home.vue';
import Order from '../components/order/Order.vue';
import User from '../components/user/User.vue';
import UserInfo from '../components/user/UserInfo.vue';
import Login from '../components/reglogin/Login.vue';
import Register from '../components/reglogin/Register.vue';
import Resetting from '../components/reglogin/Resetting.vue';
import Car from '../components/details/Car.vue'


const routes = [
    {
        path: '/',
        components: {
            default: Home
        }
    },
    {
        path: '/home',
        name: 'Home',
        component: Home
    },
    {
        path: '/order',
        name: 'Order',
        component: Order
    },
    {
        path: '/user',
        name: 'User',
        component: User
    },
    {
        path: '/userinfo',
        name: 'UserInfo',
        component: UserInfo
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/resetting',
        name: 'Resetting',
        component: Resetting
    },
    {
        path: '/car',
        name: 'Car',
        component: Car
    },
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
});

router.afterEach((to, from, next) => {
    // 解决页面/路由跳转后，滚动条消失，页面无法滚动
    document.querySelector("body").setAttribute("style", "overflow: auto !important;")
});

export default router;