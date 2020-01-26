pipeline {
  agent any

//   tools{
//   gradle "Gradle Wrapper"
//   }
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