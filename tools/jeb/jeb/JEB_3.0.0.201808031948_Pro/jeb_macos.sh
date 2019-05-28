#!/bin/bash

# Start-up script for JEB (macOS)
# Prefer local JRE
JAVA=bin/runtime/bin/java
if [ ! -f "$JAVA" ]; then

  # Prefer a JDK over a JRE
  if [ -z "$JAVA_HOME" ]; then
    JAVA=`which java`
  else
    JAVA=$JAVA_HOME/bin/java
  fi

  # Note: If the Java path generation does not yield a correct result, manually set
  # the JAVA variable (defined above) to a correct value
  if [ ! -f "$JAVA" ]; then
    echo "JEB requires a Java runtime environment, please install one."
    exit -1
  fi
fi

cd "`dirname "$0"`"
BASEDIR=`pwd -P`
cd - >/dev/null

INSTALLER=$BASEDIR/bin/app/jebi.jar
"$JAVA" -jar "$INSTALLER" --di -- "$@"
RETCODE=$?
if [ $RETCODE -lt 0 ]; then
  exit $RETCODE
fi

"$JAVA" -jar "$INSTALLER" --up -- "$@"
RETCODE=$?
if [ $RETCODE -lt 0 ]; then
  exit $RETCODE
fi

if [ "$1" == "-c" ]; then
  "$JAVA" -jar "$BASEDIR/bin/app/jeb.jar" "$@"
  exit 0
fi

JEB=$BASEDIR/bin/jeb.app/Contents/MacOS/jeb
if [ -f "$JEB" ]; then
  chmod +x "$JEB"
  "$JEB" "$@"
  exit 0
fi
"$JAVA" -jar "$BASEDIR/bin/app/jebc.jar" "$@"
exit 0
