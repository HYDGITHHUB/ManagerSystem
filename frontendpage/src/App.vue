<template>
  <div id="app">
    <div id="home-header">
      <div id="header-logo">
        <img src="./assets/img/home/logo.jpg" alt="logo" style="height: 120px">
        <p>高校科研管理系统</p>
        <div>
          <Login>
              <el-button slot="exit-button" class="login-button" type="submit">退出</el-button>
              <el-button slot="manager-button" class="login-button" type="submit" @click="jumpBackTage">管理员</el-button>
          </Login>
        </div>
      </div>
      <div id="header-navigation">
        <p @click="homeClick" :class="{active: isHomeActive}">首页</p>
        <p @click="itemsClick" :class="{active: isItemsActive}">科研项目</p>
        <p @click="resultsClick" :class="{active: isResultsActive}">科研成果</p>
        <p @click="moneysClick" :class="{active: isMoneysActive}">科研经费</p>
        <p @click="organizationsClick" :class="{active: isOrganizationsActive}">科研机构</p>
      </div>
    </div>
    <router-view></router-view>
    <div id="home-footer">
      <p style="line-height: 80px">ALL CONTENTS COPYRIGHT © CHENG DU POLYTECHNIC 2007-2020. ALL RIGHTS RESERVED.</p>
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
  data() {
    return {
      isHomeActive: true,
      isItemsActive: false,
      isMoneysActive: false,
      isResultsActive: false,
      isOrganizationsActive: false
    }
  },
  methods: {
    homeClick() {
      this.$router.push('/home');
      this.isHomeActive = true;
      this.isItemsActive = false;
      this.isMoneysActive = false;
      this.isResultsActive = false;
      this.isOrganizationsActive = false;
    },
    itemsClick() {
      this.$router.push('/items')
      this.isHomeActive = false;
      this.isItemsActive = true;
      this.isMoneysActive = false;
      this.isResultsActive = false;
      this.isOrganizationsActive = false;
    },
    resultsClick() {
      this.$router.push('/results')
      this.isHomeActive = false;
      this.isItemsActive = false;
      this.isMoneysActive = false;
      this.isResultsActive = true;
      this.isOrganizationsActive = false;
    },
    moneysClick() {
      this.$router.push('/moneys')
      this.isHomeActive = false;
      this.isItemsActive = false;
      this.isMoneysActive = true;
      this.isResultsActive = false;
      this.isOrganizationsActive = false;
    },
    organizationsClick() {
      this.$router.push('/organizations')
      this.isHomeActive = false;
      this.isItemsActive = false;
      this.isMoneysActive = false;
      this.isResultsActive = false;
      this.isOrganizationsActive = true;
    },
    jumpBackTage() {
      this.$router.push('/backHome');
      this.isHomeActive = false;
      this.isItemsActive = false;
      this.isMoneysActive = false;
      this.isResultsActive = false;
      this.isOrganizationsActive = false;
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
    margin: 0 0 0 -400px;
  }

  #home-header {
    height: 200px;
  }
</style>
