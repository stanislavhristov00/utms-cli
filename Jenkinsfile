pipeline {
    agent any
    tools { 
        maven 'Maven 3.6.3' 
    }
    stages {
        stage ('Clone') {
            steps {
                git credentialsId: 'git_credentials', url: 'https://gitlab-talentboost.vmware.com/stanislavhristov00/utms-cli'
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Publish') {
            archiveArtifacts 'target/utms-cli.jar'
        }
    }
}