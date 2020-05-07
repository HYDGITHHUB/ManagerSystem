<template>
<div>
  <el-form :model="ruleForm" ref="ruleForm" label-width="150px" class="demo-ruleForm" style="width: 60%;margin: 0 auto">
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
      <el-input v-model="ruleForm.project_prospect" readonly></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="project_describe">
      <el-input type="textarea" v-model="ruleForm.project_describe" readonly></el-input>
    </el-form-item>
    <hr>
    <p style="color: #0c7ed9">结题信息</p>
    <el-form-item label="结题类型" prop="project_result_type">
      <el-radio-group v-model="ruleForm.project_result_type" @change="btnChange(ruleForm.project_result_type)">
        <el-radio label="学术专著"></el-radio>
        <el-radio label="报刊发表"></el-radio>
        <el-radio label="专利发表"></el-radio>
        <el-radio label="技术研发"></el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="">
      <router-view></router-view>
    </el-form-item>
  </el-form>
</div>
</template>

<script>
    export default {
      name: "ResultsExamining",
      methods: {
        btnChange(resp) {
          const _this = this;
          console.log("切换按钮")
          console.log(resp);
        }
      },
      data() {
        return {
          ruleForm: '',
          rules: ''
        }
      },
      created() {
        const _this = this;
        axios.get('http://localhost:8181/researchMoneyed/findById/' + this.$route.query.id).then(function (resp) {
          _this.ruleForm = resp.data;
          console.log(_this.ruleForm);
        })
      }
    }
</script>

<style scoped>

</style>
