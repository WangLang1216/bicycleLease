import { createApp } from 'vue'
import './style.css'
import App from './App.vue'

import router from './router/index.js'

import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle'
import 'bootstrap-icons/font/bootstrap-icons.css'
// import 'jquery/dist/jquery'

import'axios'

// Vue.prototype.$http = axios

createApp(App).use(router).mount('#app')
