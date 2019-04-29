#Docker server Java
FROM java:8

ADD MocMock /opt/src

WORKDIR /opt/src

ENTRYPOINT ["java","-jar","MockMock.jar", "-p", "2525"]
