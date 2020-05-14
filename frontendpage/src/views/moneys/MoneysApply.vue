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
            <el-dialog title="项目详情" :visible.sync="dialogTableVisible">
              <el-form :model="findTableData" ref="findTableData" label-width="150px" class="demo-ruleForm"
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
                  <el-input type="textarea" v-model="findTableData.project_describe" readonly></el-input>
                </el-form-item>
                <el-form-item label="前景" prop="project_prospect">
                  <el-input type="textarea" v-model="findTableData.project_prospect" readonly></el-input>
                </el-form-item>
              </el-form>
            </el-dialog>
            <el-button @click="examine(scope.row)" type="text" size="small" style="margin-left: 10px">经费申请</el-button>
            <el-dialog title="经费申请" :visible.sync="dialogExamine">
              <el-form :model="findTableData" ref="findTableData" label-width="150px" class="demo-ruleForm"
                       style="width: 80%;margin: 0 auto">
                <el-form-item label="额度" prop="project_money">
                  <el-input v-model="findTableData.project_money"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="submitForm('findTableData')">确认</el-button>
                  <el-button type="primary" @click="cancel" style="margin-left: 150px">取消</el-button>
                </el-form-item>
              </el-form>
            </el-dialog>
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
        const _this = this;
        this.dialogExamine = true;
        axios.get("http://localhost:8181/researchProjected/findById/" + row.project_id).then(function (resp) {
          _this.findTableData = resp.data
          // console.log(_this.findTableData);
          // console.log(resp);
        })
      },
      submitForm(formName) {
        const _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8181/researchMoney/save',this.findTableData).then(function (resp) {
              if (resp.data == 'success') {
                // console.log(_this.findTableData);
                _this.$alert("申请提交成功！")
                setTimeout(() =>{
                  window.location.reload();
                },2000)
              }
            })
          } else {
            console.log("error");
            return false;
          }
        });
      },
      cancel() {

      },
      details(row) {
        const _this = this;
        _this.dialogTableVisible = true;
        axios.get("http://localhost:8181/researchProjected/findById/" + row.project_id).then(function (resp) {
          _this.findTableData = resp.data
          // console.log(_this.findTableData);
          // console.log(resp);
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
      axios.get('http://localhost:8181/researchProjected/findAll/0/5').then(function (resp) {
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
