<template>
  <div id="back-home">
    <el-container style="height: 500px;width: 1500px; border: 1px solid #eee">
      <el-menu router :default-openeds="['0','1','2','3','4','5','6']">
        <el-submenu v-for="(item,index) in $router.options.routes" :index="index + ''" v-if="item.show == 'backHome'">
          <template slot="title"><i class="el-icon-user"></i>{{item.name}}</template>
          <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                        :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
        </el-submenu>
      </el-menu>

      <el-container>
        <el-header style="text-align: left; font-size: 18px;font-weight: bolder">
          <span>高校科研管理系统后台用户管理系统</span>
        </el-header>

        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }

  #back-home {
    width: 80vw;
    margin: 0 auto;
    overflow: hidden;
  }
</style>

<script>
  export default {
    data() {
      const item = {
      };
      return {
        tableData: Array(20).fill(item)
      }
    },
  };
</script>
