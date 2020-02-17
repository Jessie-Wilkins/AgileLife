pipeline {
    agent any
    environment {
        ANDROID_SDK_TOOLS = '/home/jessie/Android/Sdk/tools/'
    }
    stages {
        stage('Build') {
            steps {
                sh 'MyApplication/gradlew assembleDebug -p MyApplication/'
                sh "${ANDROID_SDK_TOOLS}android create avd -n Ev o4G -t 9 -c 8000MB -s 480-800"
            }
        }
    }
}