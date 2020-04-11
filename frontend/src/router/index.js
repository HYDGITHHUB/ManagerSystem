import Vue from 'vue'
import VueRouter from 'vue-router'
import FindUserPersonnel from "../views/FindUserPersonnel";
import AddUserPersonnel from "../views/AddUserPersonnel";
import FindUserManagerPersonnel from "../views/FindUserManagerPersonnel";
import AddUserManagerPersonnel from "../views/AddUserManagerPersonnel";
import FindUserSysManagerPersonnel from "../views/FindUserSysManagerPersonnel";
import AddUserSysManagerPersonnel from "../views/AddUserSysManagerPersonnel";
import Index from "../views/Index";

Vue.use(VueRouter)

  const routes = [
    {
      path: "/",
      name: "科研人员",
      component: Index,
      redirect: "/FindUserPersonnel",
      children: [
        {
          path: "/FindUserPersonnel",
          name: "查询",
          component: FindUserPersonnel
        },
        {
          path: "/AddUserPersonnel",
          name: "添加",
          component: AddUserPersonnel
        }
      ]
    },
    {
      path: "/userManagerPersonnel",
      name: "科研管理人员",
      component: Index,
      children: [
        {
          path: "/FindUserManagerPersonnel",
          name: "查询",
          component: FindUserManagerPersonnel
        },
        {
          path: "/AddUserManagerPersonnel",
          name: "添加",
          component: AddUserManagerPersonnel
        }
      ]
    },
    {
      path: "/userSysManagerPersonnel",
      name: "系统管理人员",
      component: Index,
      children: [
        {
          path: "/FindUserSysManagerPersonnel",
          name: "查询",
          component: FindUserSysManagerPersonnel
        },
        {
          path: "/AddUserSysManagerPersonnel",
          name: "添加",
          component: AddUserSysManagerPersonnel
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
