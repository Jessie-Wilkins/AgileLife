pipeline {
    agent any
    environment {
        ANDROID_SDK_ROOT = '/home/jessie/Android/Sdk/'
    }
    stages {
        stage('Build') {
            steps {
                sh 'MyApplication/gradlew assembleDebug -p MyApplication/'
                sh "${ANDROID_SDK_ROOT}avdmanager -h"
            }
        }
    }
}