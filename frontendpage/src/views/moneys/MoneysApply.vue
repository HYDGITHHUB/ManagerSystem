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
          width="150">
          <template slot-scope="scope">
            <el-button @click="details(scope.row)" type="text" size="small">详情</el-button>
            <el-button @click="examine(scope.row)" type="text" size="small" style="margin-left: 10px">经费申请</el-button>
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
      examine(row) {
        this.$router.push({
          path: '/moneyApplyNumber',
          query: {
            id: row.project_id
          }
        })
      },
      details(row) {
        this.$router.push({
          path: '/moneyApplyDetails',
          query: {
            id: row.project_id
          }
        })
      },
      changePaged(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/researchProjected/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
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
        findTableData: {},
        dialogExamine: false
      }
    },
    created() {
      const _this = this;

      //记录打开经费申请页面（点击按钮）
      axios.get('http://localhost:8181/clickInfo/add/jfsq').then(function (resp) {
        // console.log(resp);
      });

      axios.get('http://localhost:8181/researchMoney/findAll/0/5').then(function (resp) {
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
