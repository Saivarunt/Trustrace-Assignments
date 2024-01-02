FROM maven:latest
WORKDIR /usr/schain
COPY . .
# RUN apk add udisks2
# RUN apk add util-linux pciutils usbutils coreutils binutils findutils grep iproute2
# RUN apk add bash bash-completion
# RUN apk update
# RUN apk add --upgrade maven
# ENTRYPOINT [ "mvnw spring-boot:run" ]
CMD ["mvn","spring-boot:run"]
# CMD ["mvn","clean","build"] 
#Maven doesn't have build target (phase in Maven lingo), what you probably want is either compile, test or install depending what you want to achieve.
