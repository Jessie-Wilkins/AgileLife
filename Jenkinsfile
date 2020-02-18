pipeline {
    agent any
    environment {
        ANDROID_SDK_TOOLS = '/home/jessie/Android/Sdk/tools/'
        ANDROID_SDK_TOOLS_BIN = '/home/jessie/Android/Sdk/tools/bin/'
    }
    stages {
        stage('Build') {
            steps {
                sh 'MyApplication/gradlew assembleDebug -p MyApplication/'
                sh "${ANDROID_SDK_TOOLS_BIN}avdmanager create avd --force --name testAVD --abi google_apis_playstore/x86 --package 'system-images;android-29;google_apis_playstore;x86'"
            }
        }
    }
}