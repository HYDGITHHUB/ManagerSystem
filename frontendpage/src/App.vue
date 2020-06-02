<template>
  <div id="app">
    <div id="home-header">
      <div id="header-logo">
        <img src="./assets/img/home/logo1.jpg" alt="logo" style="height: 120px">
<!--        <p>高校科研管理系统</p>-->
        <div>
          <Login>
<!--            <input slot="search_input" type="text"></input>-->
<!--            <el-button slot="search" class="login-button" type="submit">搜索</el-button>-->
            <el-button slot="exit-button" class="login-button" type="submit" @click="logout()" v-if="role">退出</el-button>
            <el-button slot="manager-button" class="login-button" type="submit" @click="jumpBackPage" v-if="role == 1">管理员</el-button>
          </Login>
        </div>
      </div>
      <div id="header-navigation">
        <p @click="homeClick" :class="{active: isHomeActive}">首页</p>
        <p @click="itemsClick" :class="{active: isItemsActive}">科研项目</p>
        <p @click="moneysClick" :class="{active: isMoneysActive}">科研经费</p>
        <p @click="resultsClick" :class="{active: isResultsActive}">科研成果</p>
        <p @click="organizationsClick" :class="{active: isOrganizationsActive}">科研机构</p>
        </div>
    </div>
    <router-view></router-view>
    <div id="home-footer">
      <p style="line-height: 80px">ALL CONTENTS COPYRIGHT  CHENG DU POLYTECHNIC 2007-2020. ALL RIGHTS RESERVED.</p>
      <p>蜀ICP备11016755号| 川公网安备 51019002001345号　|　信息中心制作技术支持　|　51La |</p>
    </div>
  </div>
</template>

<script>
  import Login from "./views/login/Login";

  export default {
    name: 'app',
    components: {
      Login
    },
    computed: {
      // isActive() {
      //   return this.$route.path.indexOf(this.path1) !== -1
      // }
    },
    data() {
      return {
        path1: '/home',
        path2: '/itemsShow',
        path3: '/resultsShow',
        path4: '/moneysShow',
        path5: '/organizationsShow',
        path6: '/findUser',

        isHomeActive: '',
        isItemsActive: '',
        isMoneysActive: '',
        isResultsActive: '',
        isOrganizationsActive: '',
        role: null
      }
    },
    created() {
      this.role = sessionStorage.getItem('role')
    },
    methods: {
      homeClick() {
        this.$router.push(this.path1);
        if (this.$route.path == this.path1) {
          this.isHomeActive = true;
          this.isItemsActive = false;
          this.isMoneysActive = false;
          this.isResultsActive = false;
          this.isOrganizationsActive = false;
        }
      },
      itemsClick() {
        this.$router.push(this.path2);
        if (this.$route.path == this.path2) {
          this.isHomeActive = false;
          this.isItemsActive = true;
          this.isMoneysActive = false;
          this.isResultsActive = false;
          this.isOrganizationsActive = false;
        }
      },
      resultsClick() {
        this.$router.push(this.path3);
        if (this.$route.path == this.path3) {
          this.isHomeActive = false;
          this.isItemsActive = false;
          this.isMoneysActive = false;
          this.isResultsActive = true;
          this.isOrganizationsActive = false;
        }
      },
      moneysClick() {
        this.$router.push(this.path4);
        if (this.$route.path == this.path4) {
          this.isHomeActive = false;
          this.isItemsActive = false;
          this.isMoneysActive = true;
          this.isResultsActive = false;
          this.isOrganizationsActive = false;
        }
      },
      organizationsClick() {
        this.$router.push(this.path5);
        if (this.$route.path == this.path5) {
          this.isHomeActive = false;
          this.isItemsActive = false;
          this.isMoneysActive = false;
          this.isResultsActive = false;
          this.isOrganizationsActive = true;
        }
      },
      jumpBackPage() {
        this.$router.push(this.path6);
        if (this.$route.path == this.path6) {
          this.isHomeActive = false;
          this.isItemsActive = false;
          this.isMoneysActive = false;
          this.isResultsActive = false;
          this.isOrganizationsActive = false;
        }
      },
      logout () {
        window.sessionStorage.clear()
        window.location.reload();
      }
    }
  }
</script>

<style>
  @import "assets/css/base.css";

  .active {
    color: #0c7ed9;
  }

  .login-button {
    background-color:#0c7ed9;
    color: #fff;
    border: none;
    height: 30px;
    margin: 10px;
    padding: 6px 10px
  }


  /*footer*/

  #home-footer {
    height: 120px;
    width: 80vw;
    margin: 20px auto;
    background-color: #bbbec5;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  /*header*/
  /*导航*/
  #header-navigation {
    width: 80vw;
    margin: 0 auto;
    display: flex;
    justify-content: space-evenly;
  }

  #header-navigation p {
    width: 100px;
    font-size: 20px;
    border: 1px solid #666666;
    text-align: center;
    line-height: 50px;
    flex-grow: 1;
    background-color: #DCDFE6;
    /*color: #303133;*/
    cursor: pointer;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    border-radius: 2px;
  }
  /*logo*/

  #header-logo button a {
    color: #fff;
  }

  #header-logo {
    width: 80vw;
    margin: 0 auto;
    height: 120px;
    background-color: #0c7ed9;
    display: flex;
    justify-content: space-between;
  }

  #header-logo p {
    font-size: 32px;
    line-height: 110px;
    color: #e8ecf4;
    font-weight: bolder;
    margin: 0 0 0 -550px;
  }

  #home-header {
    height: 200px;
  }
</style>
