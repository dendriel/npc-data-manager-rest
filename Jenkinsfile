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
        stage('Release') {
            steps {
                sh "echo releasing new version"
            }
        }
    }
}
