pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                gradlew('clean', 'classes')
            }
        }
        stage('Test') {
            steps {
                gradlew('test')
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
