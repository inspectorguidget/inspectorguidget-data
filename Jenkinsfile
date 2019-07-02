pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'jdk11'
    }

    stages {
        stage ('Tools Info') {
            steps {
                sh '''
                    java -version
                    mvn -v
                '''
            }
        }

        stage ('Git') {
            steps {
                //going to build on the branch master
                git branch: 'master', url: "https://github.com/inspectorguidget/inspectorguidget-data"
            }
        }

        stage ('Artifactory configuration') {
            steps {
                rtServer (
                    id: "InriaArtifactoryServer",
                    url: 'http://maven.irisa.fr/artifactory',
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

        stage("github => pending") {
            steps {
                script{
                    def commitHash = checkout(scm).GIT_COMMIT
                }
                githubNotify account: 'arnobl',sha: '${commitHash}', status: 'PENDING', description: 'Setting build status', credentialsId: 'jenkinsInria', repo: 'https://github.com/inspectorguidget/inspectorguidget-data'
            }
        }

        stage ('Build') {
            steps {
                rtMavenRun (
                    pom: 'pom.xml',
                    goals: 'clean install',
                    deployerId: 'MAVEN_DEPLOYER'
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
