pipeline {
  agent any
  stages {
    stage('Kill Process') {
      steps {
        bat '%userprofile%\\Downloads\\jenkins-plugins-mast\\jenkins-plugins-master\\BatchFiles\\Kill_Process.bat 4000'
      }
    }

    stage('Maven Build') {
      steps {
        bat 'mvn clean install'
      }
    }

    stage('Deploy Jar') {
      steps {
        bat 'C:\\Users\\sonal.baraskar\\Downloads\\jenkins-plugins-master (1)\\jenkins-plugins-master\\BatchFiles\\Deploy_Server.bat Cibo_master CiboServerSideApp-0.0.1-SNAPSHOT'
      }
    }

  }
}