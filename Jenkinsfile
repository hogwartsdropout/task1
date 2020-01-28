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
                sh '$HOME/bin/kubectl apply -f ./server/deployment.yml'
                //patch deployment to have current second in its annotation.
                //this should help to restart autoshowroom pod with latest pulled image.
                sh '$HOME/bin/kubectl patch deployment autoshowroom -p ' +
                        '"{\\"spec\\":{\\"template\\":{\\"metadata\\":{\\"annotations\\":{\\"date\\":\\"`date +\'%s\'`\\"}}}}}"'
            }
        }
    }
}