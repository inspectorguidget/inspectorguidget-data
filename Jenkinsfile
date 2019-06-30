pipeline {
    agent any

    stages {

        stage ('Build') {
            steps {
                //going to build on the branch master
                git branch: 'master', url: "https://github.com/inspectorguidget/inspectorguidget-data"

                withMaven (
                    maven: 'Maven',                                                // Tool name from Jenkins configuration
                    jdk: 'jdk11'
                ) {
                    sh "mvn clean install"
                }
            }
        }

        stage ('Artifactory configuration') {
            steps {
                rtServer (
                    id: "ARTIFACTORY_SERVER",
                    url: "http://maven.irisa.fr/artifactory",
                    credentialsId: 'credRepoInria'                                  // add credentials in Jenkins
                )

                rtMavenDeployer (
                    id: "MAVEN_DEPLOYER",
                    serverId: "ARTIFACTORY_SERVER",
                    releaseRepo: "malai-public-release",
                    snapshotRepo: "malai-public-snapshot"
                )
            }
        }

        stage ('Publish build info') {
            steps {
                rtPublishBuildInfo (
                    serverId: "ARTIFACTORY_SERVER",
                    buildName: 'inspectorguidget-data'
                )
            }
        }
    }
}
