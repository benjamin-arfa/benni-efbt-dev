pipeline {
    agent any
    tools {
        maven 'apache-maven-latest'
        jdk 'adoptopenjdk-hotspot-jdk8-latest'
    }
    stages {
        stage('Build') {
            steps {
                sh '''
                    java -version
                    mvn -v
                    cd org.eclipse.efbt.cocamo.core
                    mvn install
                    cd ..
                    cd org.eclipse.efbt.dependencies.accessdb
                    mvn install
                    cd ..
                    cd org.eclipse.efbt.cocamo.smcubes
                    mvn install
                    cd ..
                    cd org.eclipse.efbt.cocason
                    mvn install -DskipTests
                    cd ..
                    cd org.eclipse.efbt.ldm
                    mvn install
                    cd ..
                '''
            }
        }
        stage('Deploy') {
	      steps {
	        sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
	          sh '''
	            ssh genie.efbt@projects-storage.eclipse.org rm -rf /home/data/httpd/download.eclipse.org/efbt/snapshots
	            ssh genie.efbt@projects-storage.eclipse.org mkdir -p /home/data/httpd/download.eclipse.org/efbt/snapshots
	            cd org.eclipse.efbt.parent	            	          
	            scp -r org.eclipse.efbt.aorta.repository/target/repository/* genie.efbt@projects-storage.eclipse.org:/home/data/httpd/download.eclipse.org/efbt/snapshots
	          '''
	        }
	      }
    }
    }
    post {
        // send a mail on unsuccessful and fixed builds
        unsuccessful { // means unstable || failure || aborted
            emailext subject: 'Build $BUILD_STATUS $PROJECT_NAME #$BUILD_NUMBER!', 
            body: '''Check console output at $BUILD_URL to view the results.''',
            recipientProviders: [culprits(), requestor()], 
            to: 'other.recipient@domain.org'
        }
        fixed { // back to normal
            emailext subject: 'Build $BUILD_STATUS $PROJECT_NAME #$BUILD_NUMBER!', 
            body: '''Check console output at $BUILD_URL to view the results.''',
            recipientProviders: [culprits(), requestor()], 
            to: 'other.recipient@domain.org'
        }
    }
}