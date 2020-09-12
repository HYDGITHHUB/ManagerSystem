<template>
  <div>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm"
             style="width: 60%">
      <!--            <el-form-item label="科研人员职工号" prop="user_eno">-->
      <!--                <el-input v-model="ruleForm.user_eno"></el-input>-->
      <!--            </el-form-item>-->
      <el-form-item label="科研人员姓名" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="科研人员密码" prop="password">
        <el-input v-model="ruleForm.password"></el-input>
      </el-form-item>
      <el-form-item label="科研人员权限" prop="role">
<!--        <el-input v-model="ruleForm.role"></el-input>-->
        <el-radio-group v-model="ruleForm.role">
          <el-radio label="1">科研系统管理员</el-radio>
          <el-radio label="2">科研管理员</el-radio>
          <el-radio label="3">科研人员</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">创建</el-button>
        <el-button type="primary" @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
          // user_eno: '',
          name: '',
          password: '111111',
          role: ''
        },
        rules: {
          // user_eno: [
          //   {required: true, message: '请输入科研人员职工号', trigger: 'blur'},
          //   {min: 10, max: 10, message: '长度为十位字符字符', trigger: 'blur'}
          // ],
          name: [
            {required: true, message: '请输入科研人员姓名', trigger: 'blur'},
            {min: 2, max: 11, message: '长度在 2 到 5 个字符', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入初始密码', trigger: 'blur'},
            {min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur'}
          ],
          role: [
            {required: true, message: '请输入权限值', trigger: 'blur'},
            {min: 1, max: 2, message: '长度在 1 到 2 个字符', trigger: 'blur'}
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        const _this = this;
        console.log(this.ruleForm);
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.post('http://localhost:8181/user/save', this.ruleForm).then(function (resp) {
              // console.log(resp);
              if (resp.data == 'success') {
                _this.$alert(_this.ruleForm.name + ' ' + '添加成功', '消息', {
                  confirmButtonText: '确定',
                  callback: action => {
                    _this.$router.push('/findUser')
                  }
                });

              }
            })
          } else {
            // console.log('error submit!!');
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

</style>
