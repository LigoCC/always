@echo off

@REM 清空所有停止的容器
docker container prune -f
@REM 清空所有不使用的镜像
docker image prune -f

docker-compose -f docker-compose-middleware-test.yml down
docker-compose -f docker-compose-middleware-test.yml up -d --build

docker-compose -f docker-compose-service-test.yml down
docker-compose -f docker-compose-service-test.yml up -d --build

