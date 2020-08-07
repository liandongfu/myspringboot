pipeline {
    agent any
    stages {
        stage('Source') {
            steps {
                git 'https://github.com/liandongfu/myspringboot.git'
            }
        }
        stage('Build') {
            steps {
                bat './gradlew clean test --no-daemon'
            }
            post always {
                junit '**/build/test-results/test/*.xml'
            }
        }
        stage('deploy') {
            steps {
                bat 'docker build -t myspringboot:1.0 .'
                bat 'docker run --name myspringboot -p 9090:9090  myspringboot:1.0'
            }
        }

        post always {
            steps {
                archiveArtifacts artifacts: '*/**', followSymlinks: false
            }
        }
    }
}
