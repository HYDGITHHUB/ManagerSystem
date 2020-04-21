import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../views/home/Home";
import Items from "../views/items/Items";
import Moneys from "../views/moneys/Moneys";
import Organizations from "../views/organizations/Organizations";
import Results from "../views/results/Results";

Vue.use(VueRouter)

  const routes = [
    {
      path: '/',
      redirect: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/items',
      name: 'Items',
      component: Items
    },
    {
      path: '/moneys',
      name: 'Moneys',
      component: Moneys
    },
    {
      path: '/organizations',
      name: 'Organizations',
      component: Organizations
    },
    {
      path: '/results',
      name: 'Results',
      component: Results
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
