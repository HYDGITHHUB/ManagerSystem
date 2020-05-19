<template>
  <div id="back-home">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm"
             style="width: 60%">
      <el-form-item label="用户编号" prop="id">
        <el-input v-model="ruleForm.id" readonly></el-input>
      </el-form-item>
      <!--        <el-form-item label="科研人员职工号" prop="name">-->
      <!--            <el-input v-model="ruleForm.name"></el-input>-->
      <!--        </el-form-item>-->
      <el-form-item label="用户姓名" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="用户权限" prop="role">
        <el-input v-model="ruleForm.role"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
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
          id: '',
          name: '',
          role: ''
        },
        rules: {
          name: [
            {required: true, message: '请输入科研人员姓名', trigger: 'blur'},
            {min: 2, max: 11, message: '长度在 2 到 5 个字符', trigger: 'blur'}
          ],
          role: [
            {required: true, message: '请输入科研人员姓名', trigger: 'blur'},
            {min: 1, max: 2, message: '长度在 2 到 5 个字符', trigger: 'blur'}
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        const _this = this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            axios.put('http://localhost:8181/user/update', this.ruleForm).then(function (resp) {
              // console.log(resp);
              if (resp.data == 'success') {
                _this.$alert(_this.ruleForm.name + ' ' + '修改成功', '消息', {
                  confirmButtonText: '确定',
                  callback: action => {
                    _this.$router.push('/FindUser')
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
    },
    // async created() {
    //     const _this = this
    //     await axios.get('http://localhost:8181/userPersonnel/findById/' + this.$route.query.id).then(function (resp) {
    //         _this.ruleForm = resp.data
    //
    //         // _this.$forceUpdate()
    //         // _this.$set(_this,'ruleForm',resp.data)
    //         console.log("到了修改页面")
    //         console.log((resp.data))
    //     })
    // }
    async created() {
      const resp = await axios.get('http://localhost:8181/user/findById/' + this.$route.query.id)
      this.ruleForm = resp.data
      // console.log(resp.data)
      // console.log("到了修改页面")
    }
  }
</script>

<style>

  #back-home {
    width: 80vw;
    margin: 0 auto;
    overflow: hidden;
  }

</style>
