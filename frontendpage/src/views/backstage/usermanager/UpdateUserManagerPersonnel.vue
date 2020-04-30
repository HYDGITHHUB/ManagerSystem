<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm" style="width: 60%">
        <el-form-item label="编号" prop="user_id">
            <el-input v-model="ruleForm.user_id" readonly></el-input>
        </el-form-item>
        <el-form-item label="科研人员职工号" prop="user_eno">
            <el-input v-model="ruleForm.user_eno"></el-input>
        </el-form-item>
        <el-form-item label="科研人员姓名" prop="user_name">
            <el-input v-model="ruleForm.user_name"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    user_id: '',
                    user_eno: '',
                    user_name: '',
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
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.put('http://localhost:8181/userManagerPersonnel/update', this.ruleForm).then(function (resp) {
                            // console.log(resp);
                            if (resp.data == 'success') {
                                _this.$alert(_this.ruleForm.user_name + ' ' + '修改成功', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/FindUserPersonnel')
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
        created() {
            const _this = this
            axios.get('http://localhost:8181/userManagerPersonnel/findById/' + this.$route.query.id).then(function (resp) {
                _this.ruleForm = resp.data
                // console.log("到了修改页面")
                // console.log((resp.data))
            })
        }
    }
</script>
