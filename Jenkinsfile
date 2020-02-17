pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'MyApplication/gradlew assembleDebug -p MyApplication/'
                sh 'avdmanager -h'
            }
        }
    }
}