<template>
  <div>
    <div class="items-show" style="margin-top: 20px">
      <el-table
        :data="examined.filter(data => !search || data.project_theme.toLowerCase().includes(search.toLowerCase()))"
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
          prop="project_theme"
          label="科研主题"
          width="100">
        </el-table-column>
        <el-table-column
          prop="project_money"
          label="预期额度"
          width="80">
        </el-table-column>
        <el-table-column
          prop="project_moneyed"
          label="实际额度"
          width="80">
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
        <el-table-column
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope">
            <el-button @click="details(scope.row)" type="text" size="small">详情</el-button>
            <el-button @click="deletedById(scope.row)" type="text" size="small" v-if="role == 2">删除</el-button>
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
      details(row) {
        this.$router.push({
          path: '/moneyMineDetails',
          query: {
            id: row.project_id
          }
        })
      },
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
      changePaged(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/researchMoneyed/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
          _this.examined = resp.data.content;
          _this.pageSized = resp.data.size;
          _this.totaled = resp.data.totalElements;
        })
      }
    },

    data() {
      return {
        pageSized: '',
        totaled: '',
        examining: [],
        examined: [],
        search: '',
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

      //记录打开我的经费页面（点击按钮）
      axios.get('http://localhost:8181/clickInfo/add/wdjf').then(function (resp) {
        // console.log(resp);
      });

      axios.get('http://localhost:8181/researchMoneyed/findAll/0/5').then(function (resp) {
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
