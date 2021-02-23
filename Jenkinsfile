pipeline {
  agent any
  stages {
    stage ('Build Backend') {
      steps {
        sh 'mvn clean package -DskipTests=true'
      }
    }
    stage ('Unit Tests') {
      steps {
        sh 'mvn test'
      }
    }
    stage ('Sonar Analysis') {
      environment {
        scannerHome = tool 'SONAR_SCANNER'
      }
      steps {
        withSonarQubeEnv('SONAR_LOCAL'){
          sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=7eb04aadb8d87e654e2d298bc0c456408fb57e34 -Dsonar.java.binaries=target"
        }
      }
    }
    // stage ('Quality Gate'){
    //   steps{
    //     sleep(30)
    //     timeout(time: 2, unit: 'MINUTES') {
    //       waitForQualityGate abortPipeline: true
    //     }
    //   }
    // }
    stage ('Deploy BackEnd') {
      steps {
        deploy adapters: [tomcat8(credentialsId: 'TomcatLogin', path: '', url: 'http://localhost:8001/')], contextPath: 'tasks-backend', war: 'target/tasks-backend.war'        
      }
    }
    stage ('API Test') {
      steps {
        git credentialsId: 'github_login', url: 'https://github.com/crisleicon/tasks-api-test'
        sh 'mvn test'
      }
    }
  }
}

