pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t demo-app .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh 'docker stop demo-container || true'
                sh 'docker rm demo-container || true'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run -d --name demo-container -p 8082:8082 demo-app'
            }
        }
    }
}

