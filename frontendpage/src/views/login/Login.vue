<template>
  <div id="login-btn">
    <!-- Table -->
    <!-- Form -->
    <el-button type="submit" @click="dialogFormVisible = true" class="login-button">登录</el-button>

    <el-dialog title="用户登录" :visible.sync="dialogFormVisible">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="age" style="width: 650px">
          <el-input v-model.number="ruleForm.age"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass" style="width: 650px">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="用户类型" prop="checkPass" style="width: 650px">
          <el-radio v-model="loginRadio" label="1">科研人员</el-radio>
          <el-radio v-model="loginRadio" label="2">科研管理员</el-radio>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')" >重置</el-button>
        </el-form-item>
      </el-form>
<!--      <div slot="footer" class="dialog-footer">-->
<!--        <el-button @click="dialogFormVisible = false">取 消</el-button>-->
<!--        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>-->
<!--      </div>-->
    </el-dialog>
    <slot name="exit-button"></slot>
    <slot name="manager-button"></slot>
  </div>
</template>

<script>
    export default {
        name: "login",
      data() { var checkAge = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('内容不能为空'));
        }
        setTimeout(() => {
          if (!Text.isInteger(value)) {
            callback(new Error('请输入内容'));
          } else {
            {
              callback();
            }
          }
        }, 1000);
      };
        var validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'));
          } else {
            if (this.ruleForm.checkPass !== '') {
              this.$refs.ruleForm.validateField('checkPass');
            }
            callback();
          }
        };
        var validatePass2 = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.ruleForm.pass) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        };
        return {
          dialogTableVisible: false,
          dialogFormVisible: false,
          loginRadio: '1',
          form: {
            name: '',
            region: '',
            date1: '',
            date2: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
          },
          formLabelWidth: '120px',
          ruleForm: {
            pass: '',
            checkPass: '',
            age: ''
          },
          rules: {
            pass: [
              { validator: validatePass, trigger: 'blur' }
            ],
            checkPass: [
              { validator: validatePass2, trigger: 'blur' }
            ],
            age: [
              { validator: checkAge, trigger: 'blur' }
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

  .login-button {
    background-color:#0c7ed9;
    color: #fff;
    border: none;
    height: 30px;
    margin: 10px;
    padding: 6px 10px
  }

</style>
