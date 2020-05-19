<template>
  <div v-if="role == 2">
    <div id="items-show">
      <el-table
        :data="tableData"
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
          <template slot-scope="scope"  >
            <el-button @click="details(scope.row)" type="text" size="small">详情</el-button>
            <el-button @click="examine(scope.row)" type="text" size="small">审核</el-button>
<!--            <el-button @click="deleteById(scope.row)" type="text" size="small" style="margin-left: 10px">否决</el-button>-->
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
    data() {
      return {
        pageSize: '',
        total: '',
        tableData: [],
        search: '',
        findTableData: {
          project_state: '已审核'
        },
        role: 3
      }
    },
    methods:
      {
        details(row) {
        this.$router.push({
          path: '/itemsDetailsed',
          query: {
            id: row.project_id
          }
        })
      },
      cancel() {
        window.location.reload();
      },
      // deleteById(row) {
      //   const _this = this
      //   this.$confirm('是否确认否决该项申请?', '提示', {
      //     confirmButtonText: '确定',
      //     cancelButtonText: '取消',
      //     type: 'warning'
      //   }).then(() => {
      //     axios.delete('http://localhost:8181/researchProject/deleteById/' + row.project_id).then(function (resp) {
      //       _this.$alert(row.project_theme + ' ' + '已否决', '消息', {
      //         confirmButtonText: '确定',
      //         callback: action => {
      //           window.location.reload()
      //         }
      //       });
      //     })
      //   }).catch(() => {
      //     this.$message({
      //       type: 'info',
      //       message: '已取消删除'
      //     });
      //   });
      // },
      // edit(row) {
      //   // console.log(row)
      //   // alert(row.user_id)
      //   this.$router.push({
      //     path: '/itemsUpdate',
      //     query: {
      //       id: row.project_id
      //     }
      //   })
      //   // console.log(row);
      // },
      changePage(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/researchProject/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
          _this.tableData = resp.data.content;
          _this.pageSize = resp.data.size;
          _this.total = resp.data.totalElements;
        })
      },
      examine(row) {
        this.$router.push({
          path: '/itemsExamining',
          query: {
            id: row.project_id
          }
        })
      },
    },
    created() {
      this.role = sessionStorage.getItem('role')
      const _this = this;
      axios.get('http://localhost:8181/researchProject/findAll/0/5').then(function (resp) {
        // console.log(resp);
        _this.tableData = resp.data.content;
        _this.pageSize = resp.data.size;
        _this.total = resp.data.totalElements;
      })
    }
  }
</script>

<style scoped>
  /*.demo-ruleForm el-form-item input  {*/
  /*  width: 400px;*/
  /*}*/
</style>
