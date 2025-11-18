pipeline {
    agent any
    
    tools {
        maven 'Maven 3.9.11'
        jdk 'JDK 8'
    }
    
    environment {
        MAVEN_OPTS = '-Xmx1024m'
        BUILD_TOOL = "${params.BUILD_TOOL ?: 'maven'}"
    }
    
    parameters {
        choice(name: 'BUILD_TOOL', choices: ['maven', 'gradle'], description: 'Select build tool')
    }
    
    stages {
        stage('Source') {
            steps {
                git 'https://github.com/liandongfu/myspringboot.git'
            }
        }
        
        stage('Build & Test - Maven') {
            when {
                expression { BUILD_TOOL == 'maven' }
            }
            steps {
                sh 'mvn clean test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Build & Test - Gradle') {
            when {
                expression { BUILD_TOOL == 'gradle' }
            }
            steps {
                sh './gradlew clean test --no-daemon'
            }
            post {
                always {
                    junit '**/build/test-results/test/*.xml'
                }
            }
        }
        
        stage('Package - Maven') {
            when {
                expression { BUILD_TOOL == 'maven' }
            }
            steps {
                sh 'mvn package -DskipTests'
            }
        }
        
        stage('Package - Gradle') {
            when {
                expression { BUILD_TOOL == 'gradle' }
            }
            steps {
                sh './gradlew build -x test'
            }
        }
        
        stage('Docker Build') {
            steps {
                sh 'docker build -t myspringboot:1.0 .'
            }
        }
        
        stage('Deploy') {
            steps {
                sh '''
                    docker stop myspringboot || true
                    docker rm myspringboot || true
                    docker run -d --name myspringboot -p 9090:9090 myspringboot:1.0
                '''
            }
        }
    }
    
    post {
        success {
            archiveArtifacts artifacts: '**/target/*.jar, **/build/libs/*.jar', fingerprint: true, allowEmptyArchive: true
        }
        always {
            cleanWs()
        }
    }
}
