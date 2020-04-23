<template>
  <div id="home-main">
    <div id="main-left">
      <div id="left-items" class="left-style">
        <div class="main-tag">
          <p>优秀科研项目</p>
          <a href="#">>>更多</a>
        </div>
        <div class="main-content">
          <el-table
            :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
            <el-table-column
              label="日期"
              prop="date">
            </el-table-column>
            <el-table-column
              label="标题"
              prop="name">
            </el-table-column>
            <el-table-column
              align="right">
              <template slot="header" slot-scope="scope">
                <el-input
                  v-model="search"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                  size="mini"
                  type="primary"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <hr>
      </div>
      <div id="left-results" class="left-style">
        <div class="main-tag">
          <p>优秀科研成果</p>
          <a href="#">>>更多</a>
        </div>
        <div class="main-content">
          <el-table
            :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
            <el-table-column
              label="日期"
              prop="date">
            </el-table-column>
            <el-table-column
              label="标题"
              prop="name">
            </el-table-column>
            <el-table-column
              align="right">
              <template slot="header" slot-scope="scope">
                <el-input
                  v-model="search"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
                <el-button
                  size="mini"
                  type="primary"
                  @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <hr>
      </div>
      <div id="left-money" class="left-style">
        <div class="main-tag">
          <p>科研经费详情</p>
          <a href="#">>>更多</a>
        </div>
        <div class="main-content">
          <el-table
            :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
            <el-table-column
              label="日期"
              prop="date">
            </el-table-column>
            <el-table-column
              label="标题"
              prop="name">
            </el-table-column>
            <el-table-column
              align="right">
              <template slot="header" slot-scope="scope">
                <el-input
                  v-model="search"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
                <el-button
                  size="mini"
                  type="primary"
                  @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <hr>
      </div>
      <div id="left-orgies" class="left-style">
        <div class="main-tag">
          <p>科研机构一览</p>
          <a href="#">>>更多</a>
        </div>
        <div class="main-content">
          <el-table
            :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%">
            <el-table-column
              label="日期"
              prop="date">
            </el-table-column>
            <el-table-column
              label="标题"
              prop="name">
            </el-table-column>
            <el-table-column
              align="right">
              <template slot="header" slot-scope="scope">
                <el-input
                  v-model="search"
                  size="mini"
                  placeholder="输入关键字搜索"/>
              </template>
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
                <el-button
                  size="mini"
                  type="primary"
                  @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <hr>
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
            tableData: [{
              date: '2016-05-02',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1518 弄'
            }, {
              date: '2016-05-04',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1517 弄'
            }, {
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
            }, {
              date: '2016-05-03',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1516 弄'
            }, {
              date: '2016-05-03',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1516 弄'
            }, {
              date: '2016-05-03',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1516 弄'
            }, {
              date: '2016-05-03',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1516 弄'
            }],
            search: ''
          }
        },
        methods: {
          handleEdit(index, row) {
            console.log(index, row);
          },
          handleDelete(index, row) {
            console.log(index, row);
          }
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
  /*left*/
  #main-left p{
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

  .left-style{
    width: 450px;
    height: 400px;
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
  }

</style>
