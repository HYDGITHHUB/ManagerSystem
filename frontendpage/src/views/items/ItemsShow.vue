<template>
  <div>
    <div id="items-show">
      <el-table
        :data="tableData.filter(data => !search || data.project_theme.toLowerCase().includes(search.toLowerCase()))"
        style="width: 90%">
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
        @current-change="changePage">
      </el-pagination>
    </div>
  </div>
</template>

<script>
  export default {
    methods: {
      details(row) {
        this.$router.push({
          path: '/itemsDetails',
          query: {
            id: row.project_id
          }
        })
      },

      deleteById(row) {
        const _this = this
        this.$confirm('此操作将永久删除该项内容, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.delete('http://localhost:8181/researchProjected/deleteById/' + row.project_id).then(function (resp) {
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
      edit(row) {
        // console.log(row)
        // alert(row.user_id)
        this.$router.push({
          path: '/itemsUpdate',
          query:{
            id:row.project_id
          }
        })
        // console.log(row);
      },
      changePage(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/researchProjected/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
          _this.tableData = resp.data.content;
          _this.pageSize = resp.data.size;
          _this.total = resp.data.totalElements;
        })
      }
    },

    data() {
      return {
        pageSize: '',
        total: '',
        tableData: [],
        search: '',
        findTableData: [],
        role: 3
      }
    },

    //记录搜索框内容
    watch:{
      'search':function(newVal) {
        axios.get('http://localhost:8181/keyInfo/add/'+newVal).then(function (resp) {
        });
      },
    },

    created() {
      this.role = sessionStorage.getItem('role')
      const _this = this;

      //记录打开科研项目页面（点击按钮）
      axios.get('http://localhost:8181/clickInfo/add/kyxm').then(function (resp) {
        // console.log(resp);
      });

      axios.get('http://localhost:8181/researchProjected/findAll/0/5').then(function (resp) {
        // console.log(resp);
        _this.tableData = resp.data.content;
        _this.pageSize = resp.data.size;
        _this.total = resp.data.totalElements;
      })
    }
  }
</script>

<style scoped>

</style>
