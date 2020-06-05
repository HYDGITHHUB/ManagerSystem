<template>
  <div id="home-main">
    <div id="main-left">
      <div id="left-items" class="left-style">
        <div class="main-tag">
          <p>优秀科研项目</p>
          <a href="http://localhost:8080/itemsShow">>>更多</a>
        </div>
        <div class="main-content">
          <el-table
            :data="tableData.filter(data => !search_items || data.project_theme.toLowerCase().includes(search_items.toLowerCase()))"
            style="width: 100%">
            <el-table-column
              label="日期"
              prop="project_time">
            </el-table-column>
            <el-table-column
              label="标题"
              prop="project_theme">
            </el-table-column>
            <el-table-column
              align="right">
              <template slot="header" slot-scope="scope">
                <el-input
                  v-model="search_items"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <hr>
      </div>
      <div id="left-results" class="left-style">
        <div class="main-tag">
          <p>优秀科研成果</p>
          <a href="http://localhost:8080/resultsShow">>>更多</a>
        </div>
        <div class="main-content">
          <el-table
            :data="tableDataResults.filter(data => !search_results || data.project_theme.toLowerCase().includes(search_results.toLowerCase()))"
            style="width: 100%">
            <el-table-column
              label="日期"
              prop="project_time">
            </el-table-column>
            <el-table-column
              label="标题"
              prop="project_theme">
            </el-table-column>
            <el-table-column
              align="right">
              <template slot="header" slot-scope="scope">
                <el-input
                  v-model="search_results"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <hr>
      </div>
      <div id="left-money" class="left-style">
        <div class="main-tag">
          <p>科研经费拨出详情</p>
          <a href="http://localhost:8080/moneysShow">>>更多</a>
        </div>
        <div class="main-content">
          <el-table
            :data="tableDataMoneys.filter(data => !search_moneys || data.project_theme.toLowerCase().includes(search_moneys.toLowerCase()))"
            style="width: 100%">
            <el-table-column
              label="标题"
              prop="project_theme">
            </el-table-column>
            <el-table-column
              label="经费"
              prop="project_moneyed">
            </el-table-column>
            <el-table-column
              align="right">
              <template slot="header" slot-scope="scope">
                <el-input
                  v-model="search_moneys"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <hr>
      </div>
      <div id="left-orgies" class="left-style">
        <div class="main-tag">
          <p>优秀科研机构</p>
          <a href="#">>>更多</a>
        </div>
        <div class="main-content">
          <el-table
            :data="tableDataOrganizations.filter(data => !search_organizations || data.project_theme.toLowerCase().includes(search_organizations.toLowerCase()))"
            style="width: 100%">
            <el-table-column
              label="日期"
              prop="project_time">
            </el-table-column>
            <el-table-column
              label="标题"
              prop="project_theme">
            </el-table-column>
            <el-table-column
              align="right">
              <template slot="header" slot-scope="scope">
                <el-input
                  v-model="search_organizations"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <hr>
      </div>
    </div>
    <div id="main-right">
      <div>
        <el-form :model="ruleForm" ref="ruleForm" label-width="5" class="demo-ruleForm">
          <el-form-item prop="research" style="display: inline-block">
            <el-input
              type="text"
              placeholder="请输入搜索内容"
              v-model="ruleForm.research"
              show-word-limit
              style="width: 150px"
              size="small">
            </el-input>
          </el-form-item>
          <el-form-item style="display: inline-block;margin-left: 5px">
            <el-button type="submit" size="small"
                       @click="submitForm('ruleForm')">搜索
            </el-button>
          </el-form-item>
        </el-form>
      </div>
      <div id="right-info" class="right-style">
        <div class="main-tag">
          <p>通知公告</p>
          <a href="#">>>更多</a>
        </div>
        <hr>
        <div class="right-content">
          <ul>
            <li v-for="item in notice">{{item}}</li>
          </ul>
        </div>
      </div>
      <div id="right-party" class="right-style">
        <div class="main-tag">
          <p>信息公示</p>
          <a href="#">>>更多</a>
        </div>
        <hr>
        <div class="right-content">
          <ul>
            <li v-for="item in information">{{item}}</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Home",
    data() {
      return {
        notice: [
          '关于我校2020年放假时间',
          '关于我校2020年开学时间',
          '关于我校2020年大三实习时间',
          '关于我校2020年期末考试安排'
        ],
        information: [
          '关于我校2020年放假时间',
          '关于我校2020年开学时间',
          '关于我校2020年大三实习时间',
          '关于我校2020年期末考试安排'
        ],
        tableData: [],
        tableDataResults: [],
        tableDataMoneys: [],
        tableDataOrganizations: [],
        search_items: '',
        search_results: '',
        search_moneys: '',
        search_organizations: '',
        search: '',
        ruleForm: {
          research: ''
        }
      }
    },
    //记录搜索框内容
    watch: {
      'search_items': function (newVal) {
        axios.get('http://localhost:8181/keyInfo/add/' + newVal).then(function (resp) {
        });
      },
      'search_results': function (newVal) {
        axios.get('http://localhost:8181/keyInfo/add/' + newVal).then(function (resp) {
        });
      },
      'search_moneys': function (newVal) {
        axios.get('http://localhost:8181/keyInfo/add/' + newVal).then(function (resp) {
        });
      },
      'search_organizations': function (newVal) {
        axios.get('http://localhost:8181/keyInfo/add/' + newVal).then(function (resp) {
        });
      },
    },
    methods: {
      deletedById(row) {
        const _this = this
        this.$confirm('此操作将永久删除该项内容, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.delete('http://localhost:8181/researchMoneyed/deleteById/' + row.project_id).then(function (resp) {
            _this.$alert(row.project_theme + ' ' + '删除成功', '消息', {
              confirmButtonText: '确定',
              callback: action => {
                window.location.reload()
              }
            });
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      submitForm() {
        const _this = this;
        // alert(_this.ruleForm.research)
        this.$router.push({
          path: '/homeResearch',
          query: {
            id: _this.ruleForm.research
          }
        })
      }
    },
    created() {
      const _this = this;

      //记录打开home页面（点击按钮）
      axios.get('http://localhost:8181/clickInfo/add/home').then(function (resp) {
        // console.log(resp);
      });

      //记录打开home页面（点击按钮）
      axios.get('http://localhost:8181/clickInfo/findAll').then(function (resp) {
        console.log(resp);
      });

      axios.get('http://localhost:8181/researchProjected/findAll/0/5').then(function (resp) {
        // console.log(resp);
        _this.tableData = resp.data.content;
      });
      axios.get('http://localhost:8181/researchResulted/findAll/0/5').then(function (resp) {
        // console.log(resp);
        _this.tableDataResults = resp.data.content;
      });
      axios.get('http://localhost:8181/researchMoneyed/findAll/0/5').then(function (resp) {
        // console.log(resp);
        _this.tableDataMoneys = resp.data.content;
      });
      axios.get('http://localhost:8181/researchProjected/findAll/0/5').then(function (resp) {
        // console.log(resp);
        _this.tableDataOrganizations = resp.data.content;
      });
    }
  }
</script>

<style scoped>
  /*main*/

  #home-main {
    width: 80vw;
    margin: 0 auto;
    display: flex;
  }

  .main-tag {
    display: flex;
    justify-content: space-between;
  }

  .main-tag p {
    color: #0c7ed9;
    cursor: pointer;
    font-size: 20px;
  }

  /*left*/
  #main-left p {
    color: #0c7ed9;
    cursor: pointer;
    font-size: 20px;
  }

  #main-left {
    width: 1000px;
    display: flex;
    flex-wrap: wrap;
    overflow: hidden;
  }

  .left-style {
    width: 450px;
    height: 420px;
    margin-top: 10px;
    margin-left: 20px;
    overflow: hidden;
  }

  /*right*/

  #main-right {
    overflow: hidden;
  }

  .right-style {
    width: 200px;
    height: 400px;
    margin-top: 10px;
    margin-left: 20px;
    overflow: hidden;
    /*border-left: 1px solid #303133;*/
  }

  .right-content ul li {
    line-height: 25px;
    cursor: pointer;
    margin-top: 10px;
  }

</style>
