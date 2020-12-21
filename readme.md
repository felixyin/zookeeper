# zookeeper

zookeeper 最小例子

## 环境

- docker
- java8
- vscode

## 启动

`docker-compose up`

## 手动搭建

### java配置

1. 拉取镜像
`docker pull qtrj.i234.me:8084/centos`
2. 启动镜像
`docker run -it qtrj.i234.me:8084/centos /bin/bash`
3. 复制jdk到容器
`docker cp /home/fy/workspaces/zookeeper/jdk-8u131-linux-x64.tar.gz 052aaa61228d:/root`
4. 解压
`tar -xvf jdk-8u131-linux-x64.tar.gz`
5. 配置java环境变量
vi /etc/profile
```
export JAVA_HOME=/root/jdk1.8.0_131
export CLASSPATH=.:$JAVA_HOME/lib
export PATH=$PATH:$JAVA_HOME/bin
```
6. 测试
```
source /ect/profile
java  -version
javac -version
```

### 统一时区

```
cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
date
```
> 需要保证三台机器都的实践都统一

### zookeeper安装

1. 复制zoo到容器
`docker cp ./apache-zookeeper-3.6.2-bin.tar.gz 052aaa61228d:/root`
2. 解压
`tar -xvf apache-zookeeper-3.6.2-bin.tar.gz`
3. 复制默认配置文件，调整配置项
`cp zoo_sample.cfg zoo.cfg`
末尾添加：
```
server.1=node-1:2888:3888 #（2888是心跳端口，3888是选举端口）
server.2=node-2:2887:3887
server.3=node-3:2886:3886
```
设置数据目录：
`mkdir /root/zkdata`
设置节点编号：
`echo 1 /root/zkdata/myid`
