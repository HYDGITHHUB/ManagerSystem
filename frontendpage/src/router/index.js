import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../views/home/Home";
import Items from "../views/items/Items";
import Moneys from "../views/moneys/Moneys";
import Organizations from "../views/organizations/Organizations";
import Results from "../views/results/Results";
import ItemsShow from "../views/items/ItemsShow";
import ItemsApply from "../views/items/ItemsApply";
import ItemsExamine from "../views/items/ItemsExamine";
import ItemsMine from "../views/items/ItemsMine";
import MoneysShow from "../views/moneys/MoneysShow";
import MoneysApply from "../views/moneys/MoneysApply";
import MoneysExamine from "../views/moneys/MoneysExamine";
import MoneysMine from "../views/moneys/MoneysMine";
import OrganizationShow from "../views/organizations/OrganizationShow";
import OrganizationApply from "../views/organizations/OrganizationApply";
import OrganizationExamine from "../views/organizations/OrganizationExamine";
import OrganizationsMine from "../views/organizations/OrganizationsMine";
import ResultShow from "../views/results/ResultShow";
import ResultApply from "../views/results/ResultApply";
import ResultExamine from "../views/results/ResultExamine";
import ResultsMine from "../views/results/ResultsMine";

Vue.use(VueRouter)

  const routes = [
    {
      path: '/',
      redirect: '/home',
      show: false
    },
    {
      path: '/home',
      name: '首页',
      component: Home,
      show: false
    },
    {
      path: '/items',
      name: '科研项目',
      component: Items,
      show: 'items',
      redirect: '/itemsShow',
      children: [
        {
          path: '/itemsShow',
          name: '项目总览',
          component: ItemsShow
        },        {
          path: '/itemsMine',
          name: '我的项目',
          component: ItemsMine
        },
        {
          path: '/itemsApply',
          name: '项目申请',
          component: ItemsApply
        },
        {
          path: '/itemsExamine',
          name: '项目审核',
          component: ItemsExamine
        }
      ]
    },
    {
      path: '/moneys',
      name: '科研经费',
      component: Moneys,
      show: 'moneys',
      redirect: '/moneysShow',
      children: [
        {
          path: '/moneysShow',
          name: '经费详情',
          component: MoneysShow
        },
        {
          path: '/moneysMine',
          name: '我的经费',
          component: MoneysMine
        },
        {
          path: '/moneysApply',
          name: '经费申请',
          component: MoneysApply
        },
        {
          path: '/moneysExamine',
          name: '经费审核',
          component: MoneysExamine
        }
      ]
    },
    {
      path: '/organizations',
      name: '科研机构',
      component: Organizations,
      show: 'organizations',
      redirect: 'organizationsShow',
      children: [
        {
          path: '/organizationsShow',
          name: '机构总览',
          component: OrganizationShow
        },
        {
          path: '/organizationsMine',
          name: '我的机构',
          component: OrganizationsMine
        },
        {
          path: '/organizationsApply',
          name: '机构创建',
          component: OrganizationApply
        },
        {
          path: '/organizationsExamine',
          name: '我的邀请',
          component: OrganizationExamine
        }
      ]
    },
    {
      path: '/results',
      name: '项目成果',
      component: Results,
      show: 'results',
      redirect: 'resultsShow',
      children: [
        {
          path: '/resultsShow',
          name: '成果详情',
          component: ResultShow
        },
        {
          path: '/resultsMine',
          name: '我的结题',
          component: ResultsMine
        },
        {
          path: '/resultsApply',
          name: '结题申请',
          component: ResultApply
        },
        {
          path: '/resultsExamine',
          name: '结题审核',
          component: ResultExamine
        }
      ]
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
