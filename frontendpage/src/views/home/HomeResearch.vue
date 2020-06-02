<template>
  <div id="home-main">
    <div id="main-left">
      <div>
        <a href="/home" style="color: #0c7ed9;cursor: pointer;
           display: inline-block; margin-bottom: 10px">&lt;返回首页</a><br>
        您搜索的关键字是:
        <span style="color: #d90c13">{{research}}</span>
        ;
        <span>&nbsp;&nbsp;&nbsp;搜索的结果为：</span>
      </div>
      <div>
        <el-table
          :data="tableData.filter(data => !search ||
          data.project_theme.toLowerCase().includes(search.toLowerCase()))"
          style="width: 95%;margin-left: 20px">
          <el-table-column
            prop="project_id"
            label="编号"
            width="60">
          </el-table-column>
          <el-table-column
            prop="project_owner"
            label="所有者"
            width="100">
          </el-table-column>
          <el-table-column
            prop="project_time"
            label="时间"
            width="250">
          </el-table-column>
          <el-table-column
            prop="project_theme"
            label="主题"
            width="200">
          </el-table-column>
          <el-table-column
            fixed="right"
            label="操作"
            width="150">
            <template slot-scope="scope">
              <el-button @click="details(scope.row)" type="text" size="small">详情</el-button>
              <el-button @click="edit(scope.row)" type="text" size="small" v-if="role == 2">修改</el-button>
              <el-button @click="deleteById(scope.row)" type="text" size="small" v-if="role == 2">删除</el-button>
            </template>
          </el-table-column>
          <el-table-column
            align="right">
            <template slot="header" slot-scope="scope">
              <el-input
                v-model="search"
                size="mini"
                placeholder="输入主题关键字搜索"/>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          background
          layout="prev, pager, next"
          :page-size="pageSize"
          :total="total"
          @current-change="changePage"
          style="margin-left: 20px">
        </el-pagination>
      </div>
    </div>
    <div id="main-right">
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
            research: '',
            pageSize: '',
            total: '',
          }
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
        },
      created() {
        const _this = this;
        _this.research = _this.$route.query.id;
        // alert(_this.$route.query.id)
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

  .main-tag p{
    color: #0c7ed9;
    cursor: pointer;
    font-size: 20px;
  }
  /*left*/
  #main-left p{
    color: #0c7ed9;
    cursor: pointer;
    font-size: 20px;
  }

  #main-left {
    width: 1000px;
    /*display: flex;*/
    /*flex-wrap: wrap;*/
    overflow: hidden;
  }

  .left-style{
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

  .right-content ul li{
    line-height: 25px;
    cursor: pointer;
    margin-top: 10px;
  }

</style>
