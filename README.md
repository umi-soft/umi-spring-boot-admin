# 项目介绍  
## 基本介绍
  + 作为脚手架工程，面向用户、部门、菜单、权限、角色等基础功能
  + 本工程提供了代码生成器(界面开发ing)，基于模板生成代码，针对mybatis-plus和spring-jpa进行封装，实现了单表操作接口层的封装，单表操作覆盖率可达99%，但你需要读懂这里面涉及到的一些接口规范
  + **面向controller、service、mybatis-dao、jpa-repository、以及entity层的封装**，简化代码开发工作
  + 本工程Controller接口类操作封装，约束了一整套单表操作的接口规范
## 所属配套工程
  + umi-spring-boot-admin工程为[element-admin](https://github.com/umi-soft/element-admin)的配套后端工程
  + umi-spring-boot-admin所属parent版本控制工程为[umi-parent-dependencies](https://github.com/umi-soft/umi-parent-dependencies)
  + 与element-admin版本匹配关系为:  

    element-admin|umi-spring-boot-admin  
    --|:--:|  
    v2.x|v1.x  
    v3.x|v2.x  
    v4.x|v3.x   

  + 与umi-parent-dependencies版本匹配关系为:详见pom依赖即可  

# 开发文档
## 前端
  参见[element-admin](https://github.com/umi-soft/element-admin)即可  
## 本工程
### 环境准备
  redis、jdk8、mysql5.7+、idea
### 数据初始化
  运行database/init.sql
### 运行
  修改好application.yml配置文件，以spring boot工程方式运行即可
# 使用者信息
  暂无