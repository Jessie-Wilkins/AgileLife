pipeline {
    agent any
    tools {
        gradle "android_gradle"
    }
    stages {
        stage('Build') {
            steps {
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''
                sh 'gradlew --version'
                
            }
        }
    }
}