FROM ubuntu:latest
LABEL authors="joaoaugustopf"

ENTRYPOINT ["top", "-b"]