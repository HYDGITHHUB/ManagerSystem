<template>
  <div id="home-main">
    <div id="main-left">
    </div>
    <div id="main-right">
    </div>
  </div>
</template>

<script>
  import "echarts-wordcloud/dist/echarts-wordcloud";
  import "echarts-wordcloud/dist/echarts-wordcloud.min";
  export default {
    name: "Echarts",
    data() {
      return {

      }
    },
    mounted() {
      var myChart = this.echarts.init(document.getElementById('main-left'))
      let leftData = {home:0, kyjf:0, kycg:0, kyjg:0, kyxm:0, wdxm:0, xmsq:0,
        xmsh:0, wdjf:0, jfsq:0, jfsh:0, jtsq:0, jtsh:0, wdjt:0}
      axios.get('http://localhost:8181/clickInfo/findAll').then(function (resp) {
        if(resp.status===200){
          resp.data.forEach((val,index) => {
            if(val.menu==='home'){
              leftData.home++
            }else if(val.menu==='kyjf'){
              leftData.kyjf++
            }else if(val.menu==='kycg'){
              leftData.kycg++
            }else if(val.menu==='kyjg'){
              leftData.kyjg++
            }else if(val.menu==='kyxm'){
              leftData.kyxm++
            }else if(val.menu==='wdxm'){
              leftData.wdxm++
            }else if(val.menu==='xmsq'){
              leftData.xmsq++
            }else if(val.menu==='xmsh'){
              leftData.xmsh++
            }else if(val.menu==='wdjf'){
              leftData.wdjf++
            }else if(val.menu==='jfsq'){
              leftData.jfsq++
            }else if(val.menu==='jfsh'){
              leftData.jfsh++
            }
            else if(val.menu==='wdjt'){
              leftData.wdjt++
            }
            else if(val.menu==='jtsq'){
              leftData.jtsq++
            }
            else if(val.menu==='jtsh'){
              leftData.jtsh++
            }
          })
        }
        console.log(leftData)
        let datax = ['首页','科研项目','我的项目','项目申请','项目审核','科研经费','我的经费','经费申请','经费审核',
          '科研成果','我的结题','结题申请','结题审核','科研机构',]
        let datas = [leftData.home,leftData.kyxm,leftData.wdxm,leftData.xmsq,leftData.xmsh,
          leftData.kyjf,leftData.wdjf,leftData.jfsq,leftData.jfsh,
          leftData.kycg,leftData.wdjt,leftData.jtsq,leftData.jtsh,leftData.kyjg];
        let option = {
          color: ['#3398DB'],
          title: {
            text: "页面点击次数",
            x: "center"
          },
          xAxis: {
            name:'页面',
            type: 'category',
            data: datax,
          },
          yAxis: {
            name:'点击次数',
            type: 'value'
          },
          series: [{
            data: datas,
            type: 'bar',
            barWidth:'60%'
          }]
        };
        myChart.setOption(option);
      });



      let rightChart = this.echarts.init(document.getElementById('main-right'))
      axios.get('http://localhost:8181/keyInfo/findAll').then(function (resp) {

        if(resp.status===200) {
          let data = resp.data;
          let option = {
            title: {
              text: "关键词搜索词云图",
              x: "center"
            },
            backgroundColor: "#fff",
            series: [
              {
                type: "wordCloud",
                gridSize: 10,
                sizeRange: [12, 60],
                rotationRange: [0, 0],
                textStyle: {
                  normal: {
                    color: function() {
                      return (
                        "rgb(" +
                        Math.round(Math.random() * 255) +
                        ", " +
                        Math.round(Math.random() * 255) +
                        ", " +
                        Math.round(Math.random() * 255) +
                        ")"
                      );
                    }
                  }
                },
                data: data
              }
            ]
          };
          rightChart.setOption(option);
        }
      });

    },
    methods: {

    },
    created() {

    }
  }
</script>

<style scoped>
  /*main*/
  #home-main{
    width: 100%;
    height:500px;
  }

  #main-left {
    margin-left:10%;
    width: 80%;
    height:80%;
    float:left;
    display: flex;
  }
  #main-right {
    width:100%;
    height:80%;
    float:left;
    display: flex;
  }


</style>
