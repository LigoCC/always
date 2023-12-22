├─demo_dynamicProxy
├─demo_rabbitmq
│  ├─consumer
│  └─publisher
├─demo_test
└─demo_websocket

- windows系统 .bat 脚本，linux系统 .sh 脚本

- 本地配置覆盖nacos配置Nacos增加如下配置

```
spring:
  cloud:
    config:
      override-none: true
      allow-override: true
      override-system-properties: false
```

