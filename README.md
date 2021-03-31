###Successfuly compiled into native-image using graalvm8 v21.0.0.3

Command to compile info native image: __mvn -Pnative-image package__

where: -P**native-Image** - is the name of the maven profile (see pom.xml)

###Original size: 54M

compressed using [Ultimate Packer for eXecutables](https://github.com/upx/upx/releases/tag/v3.96) size: 14M

Command for compression: __upx -7 -k <executable_to_compress>__

###To run docker image use:
- __docker run --rm -p 8080:8080 native-spring-demo__

For some reason, first run of the docker image failed with the following error:
- Unable to create tempDir. java.io.tmpdir is set to /tmp

Second try was successful after adding -v /tmp:/tmp like this:
  - docker run --rm -p 8080:8080 __-v /tmp:/tmp__ native-spring-demo
