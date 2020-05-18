<template>
  <el-form :model="ruleForm" ref="ruleForm" label-width="150px" class="demo-ruleForm" style="width: 60%;margin-left: 10px">
    <hr>
    <a href="/moneysApply" style="color: #0c7ed9">&lt;返回经费申请</a>
    <el-form-item label="申请额度" prop="project_money" style="margin-left: 50px">
      <el-input v-model="ruleForm.project_money"></el-input>
    </el-form-item>
    <el-form-item style="margin-left: 50px">
      <el-button type="primary" @click="submitForm('ruleForm')" style="margin-left: 30px">申请</el-button>
      <el-button type="primary" @click="cancel" style="margin-left: 120px">取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
    export default {
      name: "MoneyApplyNumber",
      data() {
        return{
          ruleForm: {}
        }
      },
      methods: {
        submitForm(formName) {
          const _this = this;
          // console.log(_this.ruleForm);
          this.$confirm('是否发起申请?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
              this.$refs[formName].validate((valid) => {
                if (valid) {
                  axios.put('http://localhost:8181/researchProjected/update',this.ruleForm).then(function (resp) {
                    if (resp.data == 'success') {
                      // console.log(_this.ruleForm);
                      _this.$alert("申请成功！");
                      _this.$router.push('/moneysExamine')
                    }
                  });
                  axios.post('http://localhost:8181/researchMoneying/save',this.ruleForm).then(function (resp) {
                    if (resp.data == 'success') {
                      console.log('success')
                    }
                  });
                  axios.delete('http://localhost:8181/researchMoney/deleteById/' + _this.ruleForm.project_id).then(function (resp) {
                      window.location.reload()
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
              message: '已取消审核'
            });
          });
        },
        cancel() {
          this.$router.push('/moneysApply')
        }
      },
      created() {
        const _this = this;
        axios.get('http://localhost:8181/researchMoney/findById/' + _this.$route.query.id).then(function (resp) {
          _this.ruleForm = resp.data;
          // console.log(_this.ruleForm);
        })
      }
    }
</script>

<style scoped>

</style>
