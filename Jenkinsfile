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
                    id: "InriaArtifactoryServer",
                    credentialsId: 'credRepoInria'                                  // add credentials in Jenkins
                )

                rtMavenDeployer (
                    id: "MAVEN_DEPLOYER",
                    serverId: "InriaArtifactoryServer",
                    releaseRepo: "malai-public-release",
                    snapshotRepo: "malai-public-snapshot"
                )
            }
        }

        stage ('Publish build info') {
            steps {
                rtPublishBuildInfo (
                    serverId: "InriaArtifactoryServer"
                )
            }
        }
    }
}
