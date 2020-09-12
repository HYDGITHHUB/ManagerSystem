<template>
<div>
  <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm" style="width: 60%;margin: 10px">
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
        <el-radio label="学术专著">学术专著</el-radio>
        <el-radio label="报刊发表">报刊发表</el-radio>
        <el-radio label="专利发表">专利发表</el-radio>
        <el-radio label="技术研发">技术研发</el-radio>
      </el-radio-group>
    </el-form-item>
    <div v-if="projectMonograph">
      <el-form-item label="专著种类" prop="project_monograph_type">
        <el-select v-model="ruleForm.project_monograph_type" placeholder="请选择">
          <el-option label="基础论著" value="基础论著"></el-option>
          <el-option label="技术理论" value="技术理论"></el-option>
          <el-option label="应用著作" value="应用著作"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="专著内容" prop="project_monograph_content">
        <el-input type="textarea" v-model="ruleForm.project_monograph_content"></el-input>
      </el-form-item>
    </div>
    <div v-if="projectPress">
      <el-form-item label="报刊名称" prop="project_press_type">
        <el-select v-model="ruleForm.project_press_type" placeholder="请选择">
          <el-option label="自然（Nature）" value="自然"></el-option>
          <el-option label="科学（Science）" value="科学"></el-option>
          <el-option label="细胞（Cell）" value="细胞"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="发表内容" prop="project_press_content">
        <el-input type="textarea" v-model="ruleForm.project_press_content"></el-input>
      </el-form-item>
    </div>
    <div v-if="projectPatent">
      <el-form-item label="专利类别" prop="project_patent_type">
        <el-select v-model="ruleForm.project_patent_type" placeholder="请选择">
          <el-option label="发明专利" value="发明专利"></el-option>
          <el-option label="实用型专利" value="实用型专利"></el-option>
          <el-option label="外观设计专利" value="外观设计专利"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="详细描述" prop="project_patent_content">
        <el-input type="textarea" v-model="ruleForm.project_patent_content"></el-input>
      </el-form-item>
    </div>
    <div v-if="projectTechnology">
      <el-form-item label="技术领域" prop="project_technology_type">
        <el-select v-model="ruleForm.project_technology_type" placeholder="请选择">
          <el-option label="信息技术" value="信息技术"></el-option>
          <el-option label="生物技术" value="生物技术"></el-option>
          <el-option label="新材料" value="新材料"></el-option>
          <el-option label="能源技术" value="能源技术"></el-option>
          <el-option label="自动化技术" value="自动化技术"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="技术描述" prop="project_technology_content">
        <el-input type="textarea" v-model="ruleForm.project_technology_content"></el-input>
      </el-form-item>
    </div>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
      <el-button type="primary" @click="cancel">取消</el-button>
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
          if (resp == '学术专著') {
            _this.projectMonograph = true;
            _this.projectPress = false;
            _this.projectPatent = false;
            _this.projectTechnology = false;
          } else if (resp == '报刊发表') {
            _this.projectMonograph = false;
            _this.projectPress = true;
            _this.projectPatent = false;
            _this.projectTechnology = false;
          } else if (resp == '专利发表') {
            _this.projectMonograph = false;
            _this.projectPress = false;
            _this.projectPatent = true;
            _this.projectTechnology = false;
          } else if (resp == '技术研发') {
            _this.projectMonograph = false;
            _this.projectPress = false;
            _this.projectPatent = false;
            _this.projectTechnology = true;
          }
        },
        submitForm(formName) {
          const _this = this;
          this.$refs[formName].validate((valid) => {
            if (valid) {
              axios.post('http://localhost:8181/researchResulting/save',this.ruleForm).then(function (resp) {
                if (resp.data == 'success') {
                  // console.log(_this.ruleForm);
                  _this.$alert("申请提交成功！");
                  _this.$router.push('/resultsApply')
                  axios.delete('http://localhost:8181/researchResult/deleteById/' + _this.ruleForm.project_id).then(function (resp) {
                    window.location.reload()
                  })
                }
              })
            } else {
              console.log("error");
              return false;
            }
          });
        },
        cancel() {

        }
      },
      data() {
        return {
          ruleForm: {
            project_result_type: '学术专著'
          },
          projectMonograph: true,
          projectPress: false,
          projectPatent: false,
          projectTechnology: false,
          rules: {

          }
        }
      },
      created() {
        const _this = this;
        axios.get('http://localhost:8181/researchResult/findById/' + this.$route.query.id).then(function (resp) {
          _this.ruleForm = resp.data;
          // console.log(_this.ruleForm);
        })
      }
    }
</script>

<style scoped>

</style>
