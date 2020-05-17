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
import Login from "../views/login/Login";
import BackHome from "../views/backstage/BackHome";
import FindUserPersonnel from "../views/backstage/user/FindUserPersonnel";
import UpdateUserPersonnel from "../views/backstage/user/UpdateUserPersonnel";
import AddUserPersonnel from "../views/backstage/user/AddUserPersonnel";
import FindUserManagerPersonnel from "../views/backstage/usermanager/FindUserManagerPersonnel";
import UpdateUserManagerPersonnel from "../views/backstage/usermanager/UpdateUserManagerPersonnel";
import AddUserManagerPersonnel from "../views/backstage/usermanager/AddUserManagerPersonnel";
import FindUserSysManagerPersonnel from "../views/backstage/usersysmanager/FindUserSysManagerPersonnel";
import UpdateUserSysManagerPersonnel from "../views/backstage/usersysmanager/UpdateUserSysManagerPersonnel";
import AddUserSysManagerPersonnel from "../views/backstage/usersysmanager/AddUserSysManagerPersonnel";
import ItemsUpdate from "../views/items/ItemsUpdate";
import ResultsExamining from "../views/results/ResultsExamining";
import ItemsExamining from "../views/items/ItemsExamining";
import ItemsDetails from "../views/items/ItesmsDetails";
import ItemsDetailsed from "../views/items/ItemsDetailsed";
import MoneyApplyDetails from "../views/moneys/MoneyApplyDetails";
import MoneyApplyNumber from "../views/moneys/MoneyApplyNumber";
import MoneysDetailsed from "../views/moneys/MoneysDetailsed";
import MoneysExamining from "../views/moneys/MoneysExamining";

Vue.use(VueRouter)

  const routes = [
    {
      path: '/',
      redirect: '/home',
      show: false
    },
    {
      path: '/backHome',
      component: BackHome,
      redirect: '/findUser',
      show: false,
      children: [
        {
          path: '/UpdateUserPersonnel',
          name: '修改',
          component: UpdateUserPersonnel
        },
        {
          path: '/UpdateUserManagerPersonnel',
          name: '修改',
          component: UpdateUserManagerPersonnel
        },
        {
          path: '/UpdateUserSysManagerPersonnel',
          name: '修改',
          component: UpdateUserSysManagerPersonnel
        },
      ]
    },
    {
      path: '/backHome',
      name: '科研人员',
      component: BackHome,
      show: 'backHome',
      redirect: '/findUser',
      children: [
        {
          path: '/findUser',
          name: '查询',
          component: FindUserPersonnel
        },
        {
          path: '/AddUser',
          name: '添加',
          component: AddUserPersonnel
        }
      ]
    },
    {
      path: '/backHome',
      name: '科研管理人员',
      component: BackHome,
      show: 'backHome',
      children: [
        {
          path: '/findUserManager',
          name: '查询',
          component: FindUserManagerPersonnel
        },
        {
          path: '/AddUserManager',
          name: '添加',
          component: AddUserManagerPersonnel
        }
      ]
    },
    {
      path: '/backHome',
      name: '系统管理员',
      component: BackHome,
      show: 'backHome',
      children: [
        {
          path: '/findUserSysManager',
          name: '查询',
          component: FindUserSysManagerPersonnel
        },
        {
          path: '/AddUserSysManager',
          name: '添加',
          component: AddUserSysManagerPersonnel
        }
      ]
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
        },
        {
          path: '/itemsExamining',
          component: ItemsExamining
        },
        {
          path: '/itemsDetails',
          component: ItemsDetails,
        },
        {
          path: '/itemsDetailsed',
          component: ItemsDetailsed
        },
        {
          path: '/itemsUpdate',
          component: ItemsUpdate,
        },
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
        },
        {
          path: '/moneyApplyDetails',
          component: MoneyApplyDetails
        },
        {
          path: '/moneyApplyNumber',
          component: MoneyApplyNumber
        },
        {
          path: '/moneysDetailsed',
          component: MoneysDetailsed
        },
        {
          path: '/moneysExamining',
          component: MoneysExamining
        },
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
          component: ResultShow,
          show: 'results'
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
        },
        {
          path: '/resultsExamining',
          component: ResultsExamining,
        }
      ]
    },
    {
      path: '/login',
      name: '用户登录',
      component: Login
    }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
