import { createRouter, createWebHashHistory } from "vue-router";
import { handleError } from "vue";

import Primary from '../components/main/Primary.vue';
import AddBike from '../components/main/bicycle/AddBike.vue';
import BikeInfo from '../components/main/bicycle/BikeInfo.vue';
import Registration from '../components/main/lease/Registration.vue';
import LeaseInfo from '../components/main/lease/LeaseInfo.vue';
import Reservation from '../components/main/lease/Reservation.vue';
import Store from '../components/main/store/Store.vue';
import Depositi from '../components/main/deposit/Depositi.vue'
import Inquiry from '../components/main/deposit/Inquiry.vue';
import Carousel from '../components/main/frontend/Carousel.vue';
import SegmentData from '../components/main/frontend/SegmentData.vue';
import CustomerInfo from '../components/main/customer/CustomerInfo.vue';


const routes = [
  {
    path: '/',
    components: {
      default: Primary
    }
  },
  {
    path: '/addBike',
    name: 'addBike',
    component: AddBike
  },
  {
    path: '/bikeInfo',
    name: 'bikeInfo',
    component: BikeInfo
  },
  {
    path: '/registration',
    name: 'registration',
    component: Registration
  },
  {
    path: '/leaseInfo',
    name: 'leaseInfo',
    component: LeaseInfo
  },
  {
    path: '/reservation',
    name: 'reservation',
    component: Reservation
  },
  {
    path: '/store',
    name: 'store',
    component: Store
  },
  {
    path: '/depositi',
    name: 'depositi',
    component: Depositi
  },
  {
    path: '/inquiry',
    name: 'inquiry',
    component: Inquiry
  },
  {
    path: '/carousel',
    name: 'carousel',
    component: Carousel
  },
  {
    path: '/segmentData',
    name: 'segmentData',
    component: SegmentData
  },
  {
    path: '/customerInfo',
    name: 'customerInfo',
    component: CustomerInfo
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  mode: History,
  routes
});

router.afterEach((to, from, next) => {
  // 解决页面/路由跳转后，滚动条消失，页面无法滚动
  document.querySelector("body").setAttribute("style", "overflow: auto !important;")
});

export default router;