/*pipeline {
    agent any
    tools { 
        maven 'Maven 3.6.3' 
        jdk 'jdk11' 
    }
    stages {
        stage ('Build') {
            steps {
                echo 'Building...'
                mnv clean package
            }
        }
    }
}*/

pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3'
        jdk 'jdk11'
    }

    stages {
        stage('Build') {
            steps {
               sh "mvn clean package"
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'generatedFile.txt', onlyIfSuccessful: true
        }
    }
}