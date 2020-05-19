<template>
  <div>
    <el-table
      :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
      border
      style="width: 50%">
      <el-table-column
        prop="id"
        label="编号"
        width="120">
      </el-table-column>
      <!--            <el-table-column-->
      <!--                    prop="user_eno"-->
      <!--                    label="职工号"-->
      <!--                    width="120">-->
      <!--            </el-table-column>-->
      <el-table-column
        prop="name"
        label="姓名"
        width="120">
      </el-table-column>
      <el-table-column
        prop="role"
        label="权限"
        width="120">
      </el-table-column>
      <!--            <el-table-column-->
      <!--                    prop="user_phone"-->
      <!--                    label="电话"-->
      <!--                    width="120">-->
      <!--            </el-table-column>-->
      <!--            <el-table-column-->
      <!--                    prop="user_mail"-->
      <!--                    label="邮箱"-->
      <!--                    width="200">-->
      <!--            </el-table-column>-->

      <el-table-column
        align="right">
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="mini"
            placeholder="输入用户名搜索"/>
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
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
    <ul style="margin-top: 20px">
      <li style="display: inline;color: crimson">*</li>
      <li style="display: inline;margin-left: 10px">一级用户：高校科研系统管理员</li><br>
      <li style="display: inline;color: crimson">*</li>
      <li style="display: inline;margin-left: 10px"">二级用户：高校科研管理员</li><br>
      <li style="display: inline;color: crimson">*</li>
      <li style="display: inline;margin-left: 10px"">三级用户：高校科研人员</li>
    </ul>
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
          axios.delete('http://localhost:8181/user/deleteById/' + row.id).then(function (resp) {
            _this.$alert(row.name + ' ' + '删除成功', '消息', {
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
          path: '/UpdateUserPersonnel',
          query: {
            id: row.id
          }
        })
        // console.log(row);
      },
      changePage(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/user/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
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
        search: ''
        // userType: {
        //   1: '科研系统管理员',
        //   2: '科研管理员',
        //   3: '科研人员'
        // },
        // typeName: '',
        // roles: []
      }
    },
    created() {
      const _this = this;
      axios.get('http://localhost:8181/user/findAll/0/5').then(function (resp) {
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
