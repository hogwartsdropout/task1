pipeline {
    agent any


    stages {
        stage('Initialize') {
            steps {
                echo 'Hello'
            }
        }
        stage('Gradle build') {
            steps {
                sh './gradlew :server:build'
            }
        }

        stage('Gradle test') {
            steps {
                sh './gradlew :server:test'
            }
        }

        stage('Containerize') {
            steps {
                script{
                    image = docker.build("cr.yandex/crp329gu3h4tnvmvff3b/autoshowroom","./server/")
                    image.push()
                }
            }
        }
        stage("Deploy"){
            steps{
                sh 'kubectl apply -f ./server/depoyment.yml'
            }
        }
    }
}