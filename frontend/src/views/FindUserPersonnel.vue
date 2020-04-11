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
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                    <el-button type="text" size="small">编辑</el-button>
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
            handleClick(row) {
                console.log(row);
            },
            changePage(currentPage) {
                const _this = this;
                axios.get('http://localhost:8181/userPersonnel/findAll/'+ (currentPage-1) +'/5').then(function (resp) {
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
                tableData: [

                ]
            }
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8181/userPersonnel/findAll/0/3').then(function (resp) {
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