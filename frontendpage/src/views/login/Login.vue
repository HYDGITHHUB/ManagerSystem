<template>
  <div id="login-btn">
    <!-- Table -->
    <!-- Form -->
<!--    <slot name="search_input"></slot>-->
<!--    <slot name="search"></slot>-->
    <span class="login-button" v-if="userInfo.name">{{userInfo.name}}</span>
    <el-button type="submit" @click="dialogFormVisible = true" class="login-button" v-else>登录</el-button>
    <span class="login-button" v-if="userInfo.role">当前角色：{{roleName[userInfo.role]}}</span>

    <el-dialog title="用户登录" :visible.sync="dialogFormVisible">
      <el-form :model="loginForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="name">
          <el-input v-model.number="loginForm.name"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="loginForm.password" autocomplete="off"></el-input>
        </el-form-item>
<!--        <el-form-item label="用户类型" prop="userType" style="width: 650px">-->
<!--          <el-radio v-model="loginRadio" label="1">科研人员</el-radio>-->
<!--          <el-radio v-model="loginRadio" label="2">科研管理员</el-radio>-->
<!--        </el-form-item>-->
        <el-form-item>
          <el-button type="primary" @click="submitForm()">提交</el-button>
          <el-button @click="resetForm()">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <slot name="exit-button"></slot>
    <slot name="manager-button"></slot>
  </div>
</template>

<script>
    export default {
        name: "login",
      data() {
      //   var checkAge = (rule, value, callback) => {
      //   if (!value) {
      //     return callback(new Error('内容不能为空'));
      //   }
      //   setTimeout(() => {
      //     if (!Text.isInteger(value)) {
      //       callback(new Error('请输入内容'));
      //     } else {
      //       {
      //         callback();
      //       }
      //     }
      //   }, 1000);
      // };
      //   var validatePass = (rule, value, callback) => {
      //     if (value === '') {
      //       callback(new Error('请输入密码'));
      //     } else {
      //       if (this.ruleForm.checkPass !== '') {
      //         this.$refs.ruleForm.validateField('checkPass');
      //       }
      //       callback();
      //     }
      //   };
        // var validatePass2 = (rule, value, callback) => {
        //   if (value === '') {
        //     callback(new Error('请再次输入密码'));
        //   } else if (value !== this.ruleForm.pass) {
        //     callback(new Error('两次输入密码不一致!'));
        //   } else {
        //     callback();
        //   }
        // };
        return {
          dialogTableVisible: false,
          dialogFormVisible: false,
          loginRadio: '1',
          form: {
            name: '',
            userType: '',
            region: '',
            date1: '',
            date2: '',
            delivery: false,
            type: [],
            resource: '',
            desc: ''
          },
          formLabelWidth: '120px',
          loginForm: {
            name: '',
            // userType: '',
            password: ''
          },
          userInfo: {
            name: '',
            role: ''
          },
          rules: {
            // 验证用户名是否合法
            name: [
              { required: true, message: '请输入登录用户名', trigger: 'blur' },
              {min: 2, max: 40, message: '长度在 2 到 40 个字符', trigger: 'blur'}
            ],
            password: [
              { required: true, message: '请输入登录密码', trigger: 'blur' },
              {min: 2, max: 30, message: '长度在 2 到 30 个字符', trigger: 'blur'}
            ]
          },
          roleName: {
            1: '科研系统管理员',
            2: '科研管理员',
            3: '科研人员'
          }
        };
      },
      created () {
          if (window.sessionStorage.getItem('name')) {
            this.userInfo.name = window.sessionStorage.getItem('name')
            this.userInfo.role = window.sessionStorage.getItem('role')
          }
      },
    methods: {
      async submitForm() {
        this.$refs.ruleForm.validate(async (valid) => {
          if (!valid) return null
        })
        const { data: res } = await this.$http.post('user/login',this.loginForm)
        if (res.data == 'error') {
          return this.$alert("登录失败！");
        }
        this.$alert("登录成功！");
        // setTimeout(()=>{
        //     window.location.reload();
        // },1000)
        window.sessionStorage.setItem('token', res.token)
        window.sessionStorage.setItem('name', res.name)
        window.sessionStorage.setItem('role', res.role)
        // this.userInfo.name = this.loginForm.name
        // this.dialogFormVisible = false
        // this.resetForm()
        window.location.reload()
      },
      resetForm() {
        this.$refs.ruleForm.resetFields()
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
  .demo-ruleForm {
    width: 100%;
  }
  .login-button {
    background-color:#0c7ed9;
    color: #fff;
    border: none;
    height: 30px;
    margin: 10px;
    padding: 6px 10px
  }
</style>
