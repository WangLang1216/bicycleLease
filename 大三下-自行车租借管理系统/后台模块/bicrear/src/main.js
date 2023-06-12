import { createApp } from 'vue'
import './style.css'
import App from './App.vue'

import router from './router/index.js'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// import * as ElementPlusIconsVue from '@element-plus/icons-vue'

import 'bootstrap-icons/font/bootstrap-icons.css'

const app = createApp(App).use(ElementPlus).use(router).mount('#app');

