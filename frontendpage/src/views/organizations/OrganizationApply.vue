<template>
  <div id="items-apply">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="机构名称" prop="textarea">
        <el-input
          type="text"
          placeholder="请输入内容"
          v-model="ruleForm.textarea"
          maxlength="20"
          show-word-limit
          style="width: 300px">
        </el-input>
      </el-form-item>
      <el-form-item label="机构宗旨" prop="textarea">
        <el-input
          type="textarea"
          placeholder="请输入内容"
          v-model="ruleForm.textarea"
          maxlength="100"
          show-word-limit
          style="width: 600px">
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
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
          textarea: ''
        },
        rules: {
          desc: [
            { required: true, message: '请输入内容', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
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
