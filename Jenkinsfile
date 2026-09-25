pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }
    }
}



http://54.160.147.111:8081/job/demo-pipeline/6/console