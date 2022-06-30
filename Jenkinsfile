//凭证
def git_auth="ca617273-88f2-44c0-9bed-63ea9ac93fa8"
//项目地址
def git_url="git@github.com:lyk19921110/lyk-springcloud-demo.git"
def tag="latest"
def harbor_url="1.116.179.8:85"
def harbor_project="lyk_jenkins"
def harbor_auth="50635711-ee21-4cfc-8992-173f18bc4ba6"
node {
    stage('拉取代码') { // for display purposes
        echo'拉取代码'
        checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], extensions: [], userRemoteConfigs: [[credentialsId:"${git_auth}", url:"${git_url}"]]])
    }

      stage('编译-打包-构建docker镜像-上传镜像到harbor-') { // for display purposes
         sh "mvn -f ${project_name} clean package dockerfile:build"
         def imageName=${project_name}:${tag}
         //打标签
         sh "docker tag ${imageName} ${harbor_url}/${harbor_project}/${imageName}"
         //把镜像推送搭配harbor
         withCredentials([usernamePassword(credentialsId: "${harbor_auth}", passwordVariable: 'password', usernameVariable: 'username')]) {
            //登录到harbor
            sh "docker login -u ${username} -p ${password}"
            sh "docker push ${harbor_url}/${harbor_project}/${imageName}"
            sh "echo 镜像上传成功"
         }


        }

}
