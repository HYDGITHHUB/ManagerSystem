<template>
  <div>
    <el-form :model="ruleForm" ref="ruleForm" label-width="150px" class="demo-ruleForm" style="width: 60%;margin-left: 10px">
      <hr>
      <a href="/resultsShow" style="color: #0c7ed9;cursor: pointer">&lt;返回成果总览</a>
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
      <el-form-item label="实拨经费" prop="project_moneyed">
        <el-input v-model="ruleForm.project_moneyed" readonly></el-input>
      </el-form-item>
      <el-form-item label="类型" prop="project_type">
        <el-input v-model="ruleForm.project_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="级别" prop="project_grade">
        <el-input v-model="ruleForm.project_grade" readonly></el-input>
      </el-form-item>
      <el-form-item label="前景" prop="project_prospect">
        <el-input type="textarea" v-model="ruleForm.project_prospect" ></el-input>
      </el-form-item>
      <el-form-item label="描述" prop="project_describe">
        <el-input type="textarea" v-model="ruleForm.project_describe" ></el-input>
      </el-form-item>


      <el-form-item label="结题类型" prop="project_result_type">
        <el-input v-model="ruleForm.project_result_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著种类" prop="project_monograph_type">
        <el-input type="textarea" v-model="ruleForm.project_monograph_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="专著内容" prop="project_monograph_content">
        <el-input type="textarea" v-model="ruleForm.project_monograph_content" ></el-input>
      </el-form-item>


      <el-form-item label="报刊名称" prop="project_press_type">
        <el-input type="textarea" v-model="ruleForm.project_press_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="发表内容" prop="project_press_content">
        <el-input type="textarea" v-model="ruleForm.project_press_content" ></el-input>
      </el-form-item>


      <el-form-item label="专利类别" prop="project_patent_type">
        <el-input type="textarea" v-model="ruleForm.project_patent_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="详细描述" prop="project_patent_content">
        <el-input type="textarea" v-model="ruleForm.project_patent_content" ></el-input>
      </el-form-item>


      <el-form-item label="技术领域" prop="project_technology_type">
        <el-input type="textarea" v-model="ruleForm.project_technology_type" readonly></el-input>
      </el-form-item>
      <el-form-item label="技术描述" prop="project_technology_content">
        <el-input type="textarea" v-model="ruleForm.project_technology_content" ></el-input>
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
        <el-button type="primary" @click="cancel()"style="margin-left: 100px">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: "ResultsExamining",
    methods: {

      cancel() {
        this.$router.push('/resultsShow')
      },
      submitForm(formName) {
        const _this = this
        this.$confirm('是否修改该项申请?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            this.$refs[formName].validate((valid) => {
              if (valid) {
                axios.post('http://localhost:8181/researchResulted/save',this.ruleForm).then(function (resp) {
                  if (resp.data == 'success') {
                    // console.log(_this.ruleForm);
                    _this.$alert("申请修改成功！");
                    setTimeout(()=>{
                      _this.$router.push('/resultsShow')
                    },1000)
                  }
                })
              } else {
                console.log("error");
                return false;
              }
            });
          }
        ).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消修改'
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
      axios.get('http://localhost:8181/researchResulted/findById/' + _this.$route.query.id).then(function (resp) {
        _this.ruleForm = resp.data;
        // console.log(_this.ruleForm);
      })
    }
  }
</script>

<style scoped>

</style>
