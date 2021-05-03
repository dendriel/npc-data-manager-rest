pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                //gradlew('clean', 'classes')
                sh './gradlew.bat clean build'
            }
        }
        stage('Test') {
            steps {
//                 gradlew('test')
                sh './gradlew.bat test'
            }
            post {
                always {
                    junit '**/build/test-results/test/TEST-*.xml'
                }
            }
        }
        stage('Create Image') {
            steps {
                docker.build("dendriel/npc-data-manager-rest")
            }
        }

       stage('Push image') {
           steps {
               docker.withRegistry('https://registry.hub.docker.com', 'git') {
                   app.push("${env.BUILD_NUMBER}")
                   app.push("latest")
               }
           }
       }

        stage('Release') {
            steps {
                sh "echo releasing new version"
            }
        }
    }
}
