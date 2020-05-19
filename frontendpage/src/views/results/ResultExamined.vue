<template>
  <div>
    <el-form :model="ruleForm" ref="ruleForm" label-width="150px" class="demo-ruleForm" style="width: 60%;margin-left: 10px">
      <a href="/resultExamine" style="color: #0c7ed9;cursor: pointer">&lt;返回项目审核</a>
      <hr>
      <p style="color: #0c7ed9">项目信息</p>
      <el-form-item label="编号" prop="project_id">
        <el-input v-model="ruleForm.project_id" readonly></el-input>
      </el-form-item>
      <el-form-item label="项目负责人" prop="project_owner">
        <el-input v-model="ruleForm.project_owner" readonly></el-input>
      </el-form-item>
      <el-form-item label="开始时间" prop="project_time">
        <el-input v-model="ruleForm.project_time" readonly></el-input>
      </el-form-item>
      <el-form-item label="主题" prop="project_theme">
        <el-input v-model="ruleForm.project_theme" readonly></el-input>
      </el-form-item>
      <el-form-item label="预期经费" prop="project_money">
        <el-input v-model="ruleForm.project_money" readonly></el-input>
      </el-form-item>
      <el-form-item label="类型" prop="project_type">
        <el-input v-model="ruleForm.project_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="级别" prop="project_grade">
        <el-input v-model="ruleForm.project_grade" readonly></el-input>
      </el-form-item>
      <el-form-item label="前景" prop="project_prospect">
        <el-input type="textarea" v-model="ruleForm.project_prospect" readonly></el-input>
      </el-form-item>
      <el-form-item label="描述" prop="project_describe">
        <el-input type="textarea" v-model="ruleForm.project_describe" readonly></el-input>
      </el-form-item>

      <hr>
      <p style="color: #0c7ed9">结题信息</p>
      <el-form-item label="结题类型" prop="project_result_type">
        <el-input v-model="ruleForm.project_result_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著种类" prop="project_monograph_type">
        <el-input type="textarea" v-model="ruleForm.project_monograph_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著内容" prop="project_monograph_content">
        <el-input type="textarea" v-model="ruleForm.project_monograph_content" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著种类" prop="project_press_type">
        <el-input type="textarea" v-model="ruleForm.project_press_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著内容" prop="project_press_content">
        <el-input type="textarea" v-model="ruleForm.project_press_content" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著种类" prop="project_patent_type">
        <el-input type="textarea" v-model="ruleForm.project_patent_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著内容" prop="project_patent_content">
        <el-input type="textarea" v-model="ruleForm.project_patent_content" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著种类" prop="project_technology_type">
        <el-input type="textarea" v-model="ruleForm.project_technology_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著内容" prop="project_technology_content">
        <el-input type="textarea" v-model="ruleForm.project_technology_content" readonly></el-input>
      </el-form-item>

      <hr>
      <p style="color: #0c7ed9">结题评价</p>
      <el-form-item label="项目评分" prop="project_result_grade">
        <el-input type="textarea" v-model="ruleForm.project_result_grade"></el-input>
      </el-form-item>
      <el-form-item label="项目评价" prop="project_result_comment">
        <el-input type="textarea" v-model="ruleForm.project_result_comment"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">通过</el-button>
        <el-button type="primary" @click="deleteById()"style="margin-left: 100px">否决</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "ResultsExamining",
    methods: {

      submitForm(formName) {
        const _this = this;
        _this.ruleForm.project_state = '已审核';
        this.$confirm('是否通过该项申请?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$refs[formName].validate((valid) => {
              if (valid) {
                axios.post('http://localhost:8181/researchResulted/save',this.ruleForm).then(function (resp) {
                  if (resp.data == 'success') {
                    // console.log(_this.ruleForm);
                    _this.$alert("申请审核成功！");
                    _this.$router.push('/resultExamine');
                    axios.delete('http://localhost:8181/researchResulting/deleteById/' + _this.ruleForm.project_id).then(function (resp) {
                      setTimeout(()=>{
                        window.location.reload()
                      },1500)
                    });
                  }
                });
              } else {
                console.log("error");
                return false;
              }
            });
          }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消审核'
          });
        });
      },

      deleteById(row) {
        const _this = this
        this.$confirm('是否确认否决该项申请?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.delete('http://localhost:8181/researchResulting/deleteById/' + row.project_id).then(function (resp) {
            _this.$alert(row.project_theme + ' ' + '已否决', '消息', {
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
    },
    data() {
      return {
        ruleForm: {},
        rules: '',
      }
    },
    created() {
      const _this = this;
      axios.get('http://localhost:8181/researchResulting/findById/' + _this.$route.query.id).then(function (resp) {
        _this.ruleForm = resp.data;
        // console.log(_this.ruleForm);
      })
    }
  }
</script>

<style scoped>

</style>
