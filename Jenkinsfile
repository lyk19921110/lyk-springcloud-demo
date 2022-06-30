//凭证
def git_auth="ca617273-88f2-44c0-9bed-63ea9ac93fa8"
//项目地址
def git_url="git@github.com:lyk19921110/lyk-springcloud-demo.git"
node {
    stage('拉取代码') { // for display purposes
        echo'拉取代码'
        checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], extensions: [], userRemoteConfigs: [[credentialsId:"${git_auth}", url:"${git_url}"]]])
    }

      stage('编译-打包-构建docker镜像') { // for display purposes
         sh "mvn -f ${project_name} clean package dockerfile:build"
        }

}
