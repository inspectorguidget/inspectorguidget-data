pipeline {
    agent any

    stages {

        stage ('Clone') {
            steps {
                //going to build on the branch master
                git branch: 'master', url: "https://github.com/inspectorguidget/inspectorguidget-data"
            }
        }

        stage ('Artifactory configuration') {
            steps {
                rtServer (
                    id: "ARTIFACTORY_SERVER",
                    url: "http://maven.inria.fr/artifactory/webapp/#/home",
                    credentialsId: 'credRepoInria'                                  // add credentials in Jenkins
                )

                rtMavenDeployer (
                    id: "MAVEN_DEPLOYER",
                    serverId: "ARTIFACTORY_SERVER",
                    releaseRepo: "libs-release-local",
                    snapshotRepo: "libs-snapshot-local"
                )

                rtMavenResolver (
                    id: "MAVEN_RESOLVER",
                    serverId: "ARTIFACTORY_SERVER",
                    releaseRepo: "libs-release",
                    snapshotRepo: "libs-snapshot"
                )
            }
        }

        stage('Build Maven') {
            steps {

                rtMavenRun (
                    tool: Maven,                                                // Tool name from Jenkins configuration
                    pom: 'pom.xml',
                    goals: 'clean install',
                    deployerId: "MAVEN_DEPLOYER",
                    resolverId: "MAVEN_RESOLVER"
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
