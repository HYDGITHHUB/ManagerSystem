<template>
  <div id="main">
    <el-container style="height: 500px; border: 1px solid #eee">
      <el-menu router :default-openeds="['0','1','2','3','4','5','6','7','8','9','10','11']">
        <el-submenu v-for="(item,index) in $router.options.routes" :index="index + ''" v-if="item.show == 'organizations'">
          <template slot="title"><i class="el-icon-trophy"></i>{{item.name}}</template>
          <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path"
                        :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
        </el-submenu>
      </el-menu>

      <el-container>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: "Organizations",
    data() {
      const item = {
      };
      return {
        tabPosition: 'left',
        tableData: Array(20).fill(item)
      };
    }
  }
</script>

<style scoped>

  /*main*/
  #main {
    width: 80vw;
    margin: 0 auto;
    /*overflow: hidden;*/
  }

  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }

</style>
