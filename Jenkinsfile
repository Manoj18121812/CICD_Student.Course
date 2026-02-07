pipeline {
    agent any

    stages {

        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Manoj18121812/CICD_Student.Course.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t student-app .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker rm -f student || true
                docker run -d -p 8081:8080 --name student student-app
                '''
            }
        }
    }
}

