<template>
  <div>
    <div class="items-show">
      <p style="color: #0c7ed9; font-weight: bolder">未结题</p>
      <el-table
        :data="examining"
        style="width: 90%">
        <el-table-column
          prop="project_id"
          label="编号"
          width="60">
        </el-table-column>
        <el-table-column
          prop="project_time"
          label="申请时间"
          width="250">
        </el-table-column>
        <el-table-column
          prop="project_type"
          label="类型"
          width="80">
        </el-table-column>
        <el-table-column
          prop="project_result_state"
          label="状态"
          width="80">
        </el-table-column>
        <el-table-column
          prop="project_theme"
          label="科研主题"
          width="150">
        </el-table-column>
        <el-table-column
          align="right">
          <template slot="header" slot-scope="scope">
            <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
          </template>
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope">
            <!--          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>-->
            <el-button @click="deleteById(scope.row)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="pageSize"
        :total="total"
        @current-change="changePage">
      </el-pagination>
    </div>
    <div class="items-show" style="margin-top: 20px">
      <hr>
      <p style="color: #0c7ed9; font-weight: bolder">已结题</p>
      <el-table
        :data="examined"
        style="width: 90%">
        <el-table-column
          prop="project_id"
          label="编号"
          width="60">
        </el-table-column>
        <el-table-column
          prop="project_time"
          label="申请时间"
          width="250">
        </el-table-column>
        <el-table-column
          prop="project_type"
          label="类型"
          width="80">
        </el-table-column>
        <el-table-column
          prop="project_result_state"
          label="状态"
          width="80">
        </el-table-column>
        <el-table-column
          prop="project_theme"
          label="科研主题"
          width="150">
        </el-table-column>
        <el-table-column
          align="right">
          <template slot="header" slot-scope="scope">
            <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
          </template>
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope">
            <!--          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>-->
            <el-button @click="deletedById(scope.row)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="pageSized"
        :total="totaled"
        @current-change="changePaged">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  export default {
    methods: {
      deleteById(row) {
        const _this = this
        this.$confirm('此操作将永久删除该项内容, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.delete('http://localhost:8181/researchResult/deleteById/' + row.project_id).then(function (resp) {
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
      deletedById(row) {
        const _this = this
        this.$confirm('此操作将永久删除该项内容, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.delete('http://localhost:8181/researchResulted/deleteById/' + row.project_id).then(function (resp) {
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
      // edit(row) {
      //   // console.log(row)
      //   // alert(row.user_id)
      //   this.$router.push({
      //     path: '/UpdateUserPersonnel',
      //     query:{
      //       id:row.user_id
      //     }
      //   })
      //   // console.log(row);
      // },
      changePage(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/researchResulted/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
          _this.examining = resp.data.content;
          _this.pageSize = resp.data.size;
          _this.total = resp.data.totalElements;
        })
      },
      changePaged(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/researchResulted/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
          _this.examined = resp.data.content;
          _this.pageSized = resp.data.size;
          _this.totaled = resp.data.totalElements;
        })
      }
    },

    data() {
      return {
        pageSize: '',
        total: '',
        pageSized: '',
        totaled: '',
        examining: [],
        examined: [],
        search: ''
      }
    },
    created() {
      const _this = this;
      axios.get('http://localhost:8181/researchResult/findAll/0/5').then(function (resp) {
        console.log(resp);
        _this.examining = resp.data.content;
        _this.pageSize = resp.data.size;
        _this.total = resp.data.totalElements;
      }),
        axios.get('http://localhost:8181/researchResulted/findAll/0/5').then(function (resp) {
          console.log(resp);
          _this.examined = resp.data.content;
          _this.pageSized = resp.data.size;
          _this.totaled = resp.data.totalElements;
        })
    }
  }
</script>

<style scoped>

</style>
