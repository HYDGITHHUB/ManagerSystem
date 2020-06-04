import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import axios from 'axios'
import Echarts from 'echarts'

Vue.prototype.echarts = Echarts
Vue.use(Echarts)

axios.defaults.baseURL = 'http://localhost:8181/'
// 在request 拦截器中，展示进度条 NProgress.start()
axios.interceptors.request.use(config => {
  config.headers.Authorization = window.sessionStorage.getItem('token')
  // 必须返回config
  return config
})
// 在response 拦截器中，隐藏进度条 NProgress.done()
axios.interceptors.response.use(config => {
  return config
})
Vue.prototype.$http = axios
Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
