tomcatPID=`ps -ef | grep java | grep tomcat | sort | cut -f3 -d' '`
tomcatPIDTwo=`ps -ef | grep java | grep tomcat | sort | cut -f2 -d' '`
TOMCAT_HOME=/home/duellmat/bin/apache-tomcat-6.0.37
kill -9 $tomcatPID
kill -9 $tomcatPIDTwo

if [ "$1" = "debug" ]; then
	export JPDA_ADDRESS=8000
	export JPDA_TRANSPORT=dt_socket
	sh $TOMCAT_HOME/bin/catalina.sh jpda start
	exit 0
fi
sh $TOMCAT_HOME/bin/startup.sh
