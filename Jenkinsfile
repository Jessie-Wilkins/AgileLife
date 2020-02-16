pipeline {
    agent any
    tools {
        gradle "android_gradle"
    }
    environment {
        S
    }
    stages {
        stage('Build') {
            steps {
                sh 'MyApplication/gradlew assembleDebug -p MyApplication/'
                
            }
        }
    }
}