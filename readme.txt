1.日志 使用内置的logback.可以实现不同包存放不同文件路径、不同级别存放不同文件路径。配置文件名默认为：logback-spring.xml
2.配置文件默认为applicaton.properties
3.mybatis整合、数据源配置 。
        现在通过mapper.xml进行配置，该配置比较适合sql语句很复杂的情况。
        之前使用注解方式（弃用），需要每个sql都进行结果映射并且多表关联sql语句较长看起来费劲，可能不符合较复杂的权限业务。
4.maven打包。mvn clean compile进行编译。mvn clean package进行打包，会自动存在target文件夹中。运行时可以直接java -jar运行
5.多环境部署。
     1）创建多环境配置文件。application-{profile}.properties   比如两个环境，dev与test。则创建两个配置文件application-dev.properties与application-test.properties
     2）在配置文件application.properties中配置默认的环境。内容为：spring.profiles.active=dev
     3）打完jar包后，运行的语句可以指定部署环境。java -jar target/iLawSpringBoot-1.0-SNAPSHOT.jar --spring.profiles.active=test

6.事务配置。通过注解@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED) 进行配置
7.aop配置，主要是针对请求日志。在包com.springboot.aspect.WebLogAspect
8.单元测试。
9.swagger只需要修改代码根目录下Swagger2类。
前端接口页面会显示多个controller，主要是作用于springboot自带监控、web同一异常处理等功能。
8.监控。需要在配置中开启权限：management.security.enabled=false
     1）/health：服务状态。包括数据库状态。磁盘空间状态
     {
     "db": {
          "database": "MySQL",
          "hello": 1,
          "status": "UP"
     },
     "diskSpace": {
          "free": 184993943552,
          "status": "UP",
          "threshold": 10485760,
          "total": 249678528512
     },
     "status": "UP"
}

2）/dump:堆栈信息
3）/metrics显示了应用当前的指标信息
系统内存总量（mem），单位:Kb
空闲内存数量（mem.free），单位:Kb
处理器数量（processors）
系统正常运行时间（uptime），单位:毫秒
应用上下文（就是一个应用实例）正常运行时间（instance.uptime），单位:毫秒
系统平均负载（systemload.average）
堆信息（heap，heap.committed，heap.init，heap.used），单位:Kb
线程信息（threads，thread.peak，thead.daemon）
类加载信息（classes，classes.loaded，classes.unloaded）
垃圾收集信息（gc.xxx.count, gc.xxx.time）
最大连接数（datasource.xxx.max）
最小连接数（datasource.xxx.min）
活动连接数（datasource.xxx.active）
连接池的使用情况（datasource.xxx.usage）
9.basic-error-controller : Basic Error Controller该controller是springboot自带的处理同一请求失败处理的。





