#!/bin/bash
result=$( sudo docker images -q mocmock/mockmock.jar )
if [[ -n "$result" ]]; then
  echo "existing"
  sudo docker run -p 8282:8282 -p 2525:2525 mocmock/mockmock.jar
else
  sudo docker build -f util/Dockerfile -t mocmock/mockmock.jar .
  sudo docker run -p 8282:8282 -p 2525:2525 mocmock/mockmock.jar
fi
