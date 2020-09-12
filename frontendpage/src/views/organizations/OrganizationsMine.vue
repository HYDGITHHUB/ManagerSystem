<template>
  <div>
    <div id="items-show">
      <el-table
        :data="tableData"
        style="width: 90%">
        <el-table-column
          prop="user_id"
          label="编号"
          width="60">
        </el-table-column>
        <el-table-column
          prop="user_eno"
          label="机构名称"
          width="150">
        </el-table-column>
        <el-table-column
          prop="user_eno"
          label="机构成员"
          width="250">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="150">
          <template slot-scope="scope">
            <el-button @click="deleteById(scope.row)" type="text" size="small">邀请组员</el-button>
            <el-button @click="deleteById(scope.row)" type="text" size="small">解散</el-button>
          </template>
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
      deleteById(row) {
        const _this = this
        axios.delete('http://localhost:8181/userPersonnel/deleteById/' + row.user_id).then(function (resp) {
          _this.$alert(row.user_name + ' ' + '删除成功', '消息', {
            confirmButtonText: '确定',
            callback: action => {
              window.location.reload()
            }
          });
        })
      },
      edit(row) {
        // console.log(row)
        // alert(row.user_id)
        this.$router.push({
          path: '/UpdateUserPersonnel',
          query:{
            id:row.user_id
          }
        })
        // console.log(row);
      },
      changePage(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/userPersonnel/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
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
        findTableData: []
      }
    },
    created() {
      const _this = this;
      axios.get('http://localhost:8181/userPersonnel/findAll/0/5').then(function (resp) {
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
