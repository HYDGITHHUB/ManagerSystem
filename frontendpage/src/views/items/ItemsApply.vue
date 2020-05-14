<template>
  <div id="items-apply">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="项目申请人" prop="project_owner">
        <el-input
          type="text"
          placeholder="请输入内容"
          v-model="ruleForm.project_owner"
          maxlength="20"
          show-word-limit
          style="width: 300px">
        </el-input>
      </el-form-item>
      <el-form-item label="项目主题" prop="project_theme">
        <el-input
          type="text"
          placeholder="请输入内容"
          v-model="ruleForm.project_theme"
          maxlength="20"
          show-word-limit
          style="width: 300px">
        </el-input>
      </el-form-item>
      <el-form-item label="项目类型" prop="project_type">
        <el-radio-group v-model="ruleForm.project_type">
          <el-radio label="应用性"></el-radio>
          <el-radio label="实验性"></el-radio>
          <el-radio label="经验研究性"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="项目级别" prop="project_grade">
        <el-select v-model="ruleForm.project_grade" placeholder="请选择">
          <el-option label="国家级" value="国家级"></el-option>
          <el-option label="省级" value="省级"></el-option>
          <el-option label="校级" value="校级"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="项目前景" prop="project_prospect">
        <el-input
          type="textarea"
          placeholder="请输入内容"
          v-model="ruleForm.project_prospect"
          maxlength="100"
          show-word-limit
          style="width: 600px">
        </el-input>
      </el-form-item>
      <el-form-item label="项目简介" prop="project_describe">
        <el-input
          type="textarea"
          placeholder="请输入内容"
          v-model="ruleForm.project_describe"
          maxlength="300"
          show-word-limit
          style="width: 600px">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即申请</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
          project_theme: '',
          project_prospect: '',
          project_describe: '',
          project_type: '',
          project_grade: '',
          project_owner: '',
          // project_state: '未审核'
        },
        rules: {
          project_owner: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ],
          project_theme: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ],
          project_prospect: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ],
          project_describe: [
            { required: true, message: '请选择', trigger: 'blur' }
          ],
        },
      };
    },
    methods: {
      submitForm(formName) {
        const _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8181/researchProject/save',this.ruleForm).then(function (resp) {
              if (resp.data == 'success') {
                console.log(_this.ruleForm);
                _this.$alert("申请提交成功！");
                setTimeout(()=>{
                  window.location.reload();
                },1500)
              }
            })
          } else {
            console.log("error");
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>

  #items-apply p{
    color: #0c7ed9;
    margin: 0 0 10px 0;
  }

</style>
