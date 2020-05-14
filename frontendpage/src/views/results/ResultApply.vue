<template>
  <div>
    <div class="items-show" style="margin-top: 20px">
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
          prop="project_theme"
          label="科研主题"
          width="200">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope"  >
            <el-button @click="examine(scope.row)" type="text" size="small">发起结题</el-button>
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
      submitForm() {

      },
      cancel() {

      },
      examine(row) {
        this.$router.push({
          path: '/resultsExamining',
          query: {
            id: row.project_id
          }
        })
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
        search: '',
        examined: [],
        dialogTableVisible: false,
        findTableData: {}
      }
    },
    created() {
      const _this = this;
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
