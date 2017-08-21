node {
	
    		stage ('checkout') {
		        git url: 'https://github.com/sidtanu/msf-ws.git'
		}
		stage ('build') {
			echo "Starting Build"
			bat 'mvn -Dmaven.test.failure.ignore=true install'
			echo "Ending Build"
		}
    	
}
