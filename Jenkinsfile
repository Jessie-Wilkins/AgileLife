pipeline {
    agent any
    environment {
        ANDROID_SDK_TOOLS = '/home/jessie/Android/Sdk/tools'
        ANDROID_SDK_TOOLS_BIN = '/home/jessie/Android/Sdk/tools/bin'
        ANDROID_SDK_EMU = '/home/jessie/Android/Sdk/emulator'

    }
    stages {
        stage('Build') {
            steps {
                sh 'MyApplication/gradlew assembleDebug -p MyApplication/'
                sh 'MyApplication/gradlew test'
                //sh "${ANDROID_SDK_TOOLS_BIN}/avdmanager delete avd --name testAVD"
                //sh "echo no | ${ANDROID_SDK_TOOLS_BIN}/avdmanager create avd --force --name testAVD --abi google_apis_playstore/x86 --package 'system-images;android-29;google_apis_playstore;x86'"
                //sh "${ANDROID_SDK_EMU}/emulator -avd testAVD -no-window"
            }
        }
    }
}