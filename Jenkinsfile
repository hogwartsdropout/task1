pipeline {
  agent any


  stages {
    stage('Initialize') {
      steps {
        echo 'Hello'
      }
    }
    stage ('Gradle build'){
    steps{
        sh './gradlew :server:build'}
    }

  }
}