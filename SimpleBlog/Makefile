debugDeploy:
	sh restartTomcat.sh debug
	mvn -Dmaven.test.skip=true clean compile package tomcat:undeploy tomcat:deploy
	
deploy:
	sh restartTomcat.sh
	mvn -Dmaven.test.skip=true clean compile package tomcat:undeploy tomcat:deploy
