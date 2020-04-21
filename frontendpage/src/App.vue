<template>
  <div id="app">
    <div id="home-header">
      <div id="header-logo">
        <img src="./assets/img/home/logo.jpg" alt="logo" style="height: 120px">
        <p>高校科研管理系统</p>
        <div>
          <button><a href="#">登录</a></button>
          <button><a href="#">退出</a></button>
        </div>
      </div>
      <div id="header-navigation">
        <p @click="homeClick">首页</p>
        <p @click="itemsClick">科研项目</p>
        <p @click="resultsClick">科研成果</p>
        <p @click="moneysClick">科研经费</p>
        <p @click="organizationsClick">科研机构</p>
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

export default {
  name: 'app',
  components: {
  },
  methods: {
    homeClick() {
      this.$router.push('/home')
    },
    itemsClick() {
      this.$router.push('/items')
    },
    resultsClick() {
      this.$router.push('/results')
    },
    moneysClick() {
      this.$router.push('/moneys')
    },
    organizationsClick() {
      this.$router.push('/organizations')
    }
  }
}
</script>

<style>
  @import "assets/css/base.css";

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
    color: #303133;
    cursor: pointer;
    box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
    border-radius: 2px;
  }
  /*logo*/
  #header-logo button {
    height: 30px;
    margin: 10px;
    background-color: #0c7ed9;
    color: #fff;
  }

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
    color: white;
    font-weight: bolder;
    margin: 0 0 0 -40%;
  }

  #home-header {
    height: 200px;
  }
</style>
