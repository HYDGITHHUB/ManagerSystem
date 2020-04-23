<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 65%">
            <el-table-column
                    prop="user_id"
                    label="编号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user_eno"
                    label="职工号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user_name"
                    label="姓名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user_phone"
                    label="电话"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="user_mail"
                    label="邮箱"
                    width="200">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteById(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                @current-change="changePage">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            deleteById(row) {
                const _this = this
                axios.delete('http://localhost:8181/userManagerPersonnel/deleteById/' + row.user_id).then(function (resp) {
                    _this.$alert(row.user_name + ' ' + '删除成功', '消息', {
                        confirmButtonText: '确定',
                        callback: action => {
                            window.location.reload()
                        }
                    });
                })
            },
            edit(row) {
                // console.log(row)
                // alert(row.user_id)
                this.$router.push({
                    path: '/UpdateUserPersonnel',
                    query:{
                        id:row.user_id
                    }
                })
                // console.log(row);
            },
            changePage(currentPage) {
                const _this = this;
                axios.get('http://localhost:8181/userManagerPersonnel/findAll/' + (currentPage - 1) + '/5').then(function (resp) {
                    _this.tableData = resp.data.content;
                    _this.pageSize = resp.data.size;
                    _this.total = resp.data.totalElements;
                })
            }
        },

        data() {
            return {
                pageSize: '',
                total: '',
                tableData: []
            }
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8181/userManagerPersonnel/findAll/0/5').then(function (resp) {
                // console.log(resp);
                _this.tableData = resp.data.content;
                _this.pageSize = resp.data.size;
                _this.total = resp.data.totalElements;
            })
        }
    }
</script>

<style scoped>

</style>