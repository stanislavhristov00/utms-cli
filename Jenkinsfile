pipeline {
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
    post {
        always {
            archiveArtifacts artifacts: 'target/utms-cli.jar', onlyIfSuccessful: true
        }
    }
}