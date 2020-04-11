<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm" style="width: 60%">
            <el-form-item label="科研人员职工号" prop="user_eno">
                <el-input v-model="ruleForm.user_eno"></el-input>
            </el-form-item>
            <el-form-item label="科研人员姓名" prop="user_name">
                <el-input v-model="ruleForm.user_name"></el-input>
            </el-form-item>
            <el-form-item label="科研人员密码" prop="user_pwd">
                <el-input v-model="ruleForm.user_pwd"></el-input>
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
                    user_eno: '',
                    user_name: '',
                    user_pwd: '',
                },
                rules: {
                    user_eno: [
                        {required: true, message: '请输入科研人员职工号', trigger: 'blur'},
                        {min: 10, max: 10, message: '长度为十位字符字符', trigger: 'blur'}
                    ],
                    user_name: [
                        {required: true, message: '请输入科研人员姓名', trigger: 'blur'},
                        {min: 2, max: 11, message: '长度在 2 到 5 个字符', trigger: 'blur'}
                    ],
                    user_pwd: [
                        {required: true, message: '请输入初始密码', trigger: 'blur'},
                        {min: 6, max: 16, message: '3长度在 6 到 16 个字符', trigger: 'blur'}
                    ],
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8181/userPersonnel/save', this.ruleForm).then(function (resp) {
                            // console.log(resp);
                            if (resp.data == 'success') {
                                _this.$alert(_this.ruleForm.user_name + ' ' + '添加成功', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/FindUserPersonnel')
                                    }
                                });
                            }
                        })
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

</style>