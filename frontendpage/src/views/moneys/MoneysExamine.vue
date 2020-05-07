<template>
  <div>
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
          width="100">
          <template slot-scope="scope"  >
            <el-button @click="examine(scope.row)" type="text" size="small">审核</el-button>
            <el-dialog title="审核信息" :visible.sync="dialogTableVisible">
              <el-form :model="findTableData" :rules="rules"ref="findTableData" label-width="150px" class="demo-ruleForm"
                       style="width: 80%;margin: 0 auto">
                <el-form-item label="编号" prop="project_id">
                  <el-input v-model="findTableData.project_id" readonly></el-input>
                </el-form-item>
                <el-form-item label="申请人" prop="project_owner">
                  <el-input v-model="findTableData.project_owner" readonly></el-input>
                </el-form-item>
                <el-form-item label="时间" prop="project_time">
                  <el-input v-model="findTableData.project_time" readonly></el-input>
                </el-form-item>
                <el-form-item label="额度" prop="project_money">
                  <el-input v-model="findTableData.project_money" readonly></el-input>
                </el-form-item>
                <el-form-item label="实拨额度" prop="project_moneyed">
                  <el-input v-model="findTableData.project_moneyed"></el-input>
                </el-form-item>
                <el-form-item label="类型" prop="project_type">
                  <el-input v-model="findTableData.project_type" readonly></el-input>
                </el-form-item>
                <el-form-item label="级别" prop="project_grade">
                  <el-input v-model="findTableData.project_grade" readonly></el-input>
                </el-form-item>
                <el-form-item label="主题" prop="project_theme">
                  <el-input v-model="findTableData.project_theme" readonly></el-input>
                </el-form-item>
                <el-form-item label="描述" prop="project_describe">
                  <el-input v-model="findTableData.project_describe" readonly></el-input>
                </el-form-item>
                <el-form-item label="前景" prop="project_prospect">
                  <el-input v-model="findTableData.project_prospect" readonly></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="submitForm('findTableData')">同意</el-button>
                  <el-button type="primary" @click="cancel" style="margin-left: 150px">取消</el-button>
                </el-form-item>
              </el-form>
            </el-dialog>
            <el-button @click="deletedById(scope.row)" type="text" size="small">否决</el-button>
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
    data() {
      return {
        pageSize: '',
        total: '',
        tableData: [],
        search: '',
        findTableData: {
        },
        dialogTableVisible: false,
        rules: {
          project_moneyed: [
            {required: true, message: '请输入实拨额度', trigger: 'blur'},
          ]
        }
      }
    },
    methods: {
      cancel() {
        window.location.reload();
      },
      deletedById(row) {
        const _this = this
        this.$confirm('是否确认否决该项申请？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.delete('http://localhost:8181/researchMoney/deleteById/' + row.project_id).then(function (resp) {
            _this.$alert(row.project_theme + ' ' + '已否决', '消息', {
              confirmButtonText: '确定',
              callback: action => {
                window.location.reload()
              }
            }
            );
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
      //     path: '/itemsUpdate',
      //     query: {
      //       id: row.project_id
      //     }
      //   })
      //   // console.log(row);
      // },
      changePage(currentPage) {
        const _this = this;
        axios.get('http://localhost:8181/researchMoney/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
          _this.tableData = resp.data.content;
          _this.pageSize = resp.data.size;
          _this.total = resp.data.totalElements;
        })
      },
      examine(row) {
        // console.log(row);
        // console.log("这是findTableDate")
        // console.log(this.findTableData);
        const _this = this;
        _this.dialogTableVisible = true;
        _this.findTableData.project_moneyed = _this.findTableData.project_money;
        axios.get("http://localhost:8181/researchMoney/findById/" + row.project_id).then(function (resp) {
          _this.findTableData = resp.data
          // console.log(_this.findTableData);
          // console.log(resp);
        })
      },
      submitForm(formName) {
        const _this = this;
        _this.findTableData.project_state = '已审核'
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8181/researchMoneyed/save', _this.findTableData).then(function (resp) {
              if (resp.data == 'success') {
                _this.$alert(_this.findTableData.project_theme + ' ' + '添加成功', '消息', {
                  confirmButtonText: '确定',
                  callback: action => {
                    _this.$router.push('/itemsShow')
                  }
                });
                axios.delete('http://localhost:8181/researchMoney/deleteById/' + _this.findTableData.project_id).then(function (resp) {
                  window.location.reload()
                  console.log("成功删除")
                })
              }
            })
          } else {
            // console.log('error submit!!');
            return false;
          }
        });
      }
    },
    created() {
      const _this = this;
      axios.get('http://localhost:8181/researchMoney/findAll/0/5').then(function (resp) {
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
