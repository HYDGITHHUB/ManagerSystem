<template>
  <div>
    <el-form :model="ruleForm" ref="ruleForm" label-width="150px" class="demo-ruleForm" style="width: 60%;margin-left: 10px">
      <a href="/moneysExamine" style="color: #0c7ed9;cursor: pointer">&lt;返回经费审核</a>
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
      <el-form-item label="实拨经费" prop="project_money">
        <el-input v-model="ruleForm.project_moneyed"></el-input>
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
      deleteById() {
        const _this = this
        this.$confirm('是否确认否决该项申请?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.delete('http://localhost:8181/researchMoneying/deleteById/' + _this.ruleForm.project_id).then(function (resp) {
            _this.$alert(_this.ruleForm.project_theme + ' ' + '已否决', '消息', {
              confirmButtonText: '确定',
              callback: action => {
                setTimeout(()=>{
                  _this.$router.push('/itemsExamine')
                })
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
                axios.post('http://localhost:8181/researchMoneyed/save',this.ruleForm).then(function (resp) {
                  if (resp.data == 'success') {
                    // console.log(_this.ruleForm);
                    _this.$alert("申请审核成功！");
                    _this.$router.push('/itemsExamine');
                    axios.post('http://localhost:8181/researchMoney/save',_this.ruleForm).then(function (resp) {
                      if (resp.data == 'success') {
                        console.log("success");
                        console.log(this.ruleForm);
                      }
                    });
                    axios.delete('http://localhost:8181/researchMoneying/deleteById/' + _this.ruleForm.project_id).then(function (resp) {
                      setTimeout(()=>{
                        window.location.reload()
                      },1500)
                    })
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
    },
    data() {
      return {
        ruleForm: {},
        rules: '',
      }
    },
    created() {
      const _this = this;
      axios.get('http://localhost:8181/researchMoneying/findById/' + _this.$route.query.id).then(function (resp) {
        _this.ruleForm = resp.data;
        // console.log(_this.ruleForm);
      })
    }
  }
</script>

<style scoped>

</style>
