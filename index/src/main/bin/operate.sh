#!/bin/bash

if [ -z "$JAVA_HOME" ]; then
  export JAVA=`which java`
else
  export JAVA="$JAVA_HOME/bin/java"
fi

#取当前目录
BASE_PATH=`cd "$(dirname "$0")"; pwd`

WORKDIR=`cd ..;pwd`


JAVA_OPTS='-server -Xmx1g -Xms1g -XX:SurvivorRatio=8 -XX:NewRatio=2 -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+DisableExplicitGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:ParallelCMSThreads=4 -XX:+CMSClassUnloadingEnabled -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=1 -XX:CMSInitiatingOccupancyFraction=50  -DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector'else

#设置java运行参数 -Xmn256m
DEFAULT_JAVA_OPTS=" -server -Xmx1g -Xms1g -XX:SurvivorRatio=8 -XX:NewRatio=2 -XX:PermSize=128m -XX:MaxPermSize=256m -XX:+DisableExplicitGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:ParallelCMSThreads=4 -XX:+CMSClassUnloadingEnabled -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=1 -XX:CMSInitiatingOccupancyFraction=50  -DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector "

#定义变量:
APP_PATH=${APP_PATH:-`dirname "$BASE_PATH"`}
JAVA_OPTS=${JAVA_OPTS:-$DEFAULT_JAVA_OPTS}


APP_NAME="yak"
LOGDIR=../logs

if [ ! -d "$LOGDIR" ];then
mkdir $LOGDIR
fi

JARNAME=/lib/$APP_NAME.jar --spring.profiles.active=prod
LOGFILE=$APP_NAME.boot.log.`date "+%Y%m%d"`


exist(){
    if test $( pgrep -f "$MAIN_CLASS $APP_PATH" | wc -l ) -eq 0
    then
        return 1
    else
        return 0
    fi
}

start(){
    if exist; then
            echo "Service is already running."
            exit 1
    else
        cd $BASE_PATH
        nohup java $JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOGDIR/$APP_NAME.heaperr.log.`date "+%Y%m%d%H%M%S"` -Denvironment=$ENVIRONMENT -Xloggc:$LOGDIR/$APP_NAME.gc.log.`date "+%Y%m%d%H%M%S"` -Dapp.port=8080 -Dfile.encoding=utf8 -Dapp.key=$APP_NAME  -jar $WORKDIR/$JARNAME 2> /dev/null &
        echo "Service is started."
    fi
}

stop(){
    runningPID=`pgrep -f "$APP_NAME"`
    if [ "$runningPID" ]; then
        echo "Service pid: $runningPID"
        count=0
        kwait=5
        echo "Service is stopping, please wait..."
        kill -15 $runningPID
        until [ `ps --pid $runningPID 2> /dev/null | grep -c $runningPID 2> /dev/null` -eq '0' ] || [ $count -gt $kwait ]
        do
            sleep 1
            let count=$count+1;
        done

        if [ $count -gt $kwait ]; then
            kill -9 $runningPID
        fi
        clear
        echo "Service is stopped."
    else
            echo "Service has not been started."
    fi
}

check(){
   if exist; then
     echo "Service is alive."
     exit 0
   else
     echo "Service is dead."
     exit -1
   fi
}

restart(){
        stop
        start
}

case "$1" in

    start)
            start
    ;;
    stop)
            stop
    ;;
    restart)
            restart
    ;;
    check)
            check
    ;;
    *)
            echo "available operations: [start|stop|restart|check]"
            exit 1
    ;;
esac