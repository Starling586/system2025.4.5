# 用户管理系统开发需求说明书

## 1. 项目背景
本项目基于对现有用户管理系统的不足和需求分析，计划开发一个基于Spring Boot、MyBatis和MySQL的用户管理系统。该系统旨在提供可靠、高效的用户管理解决方案，满足企业或组织对用户管理的需求，包括用户的注册、登录、信息管理以及权限和角色的分配与管理。

## 2. 功能需求
- 用户注册：允许用户通过填写表单注册账户，提供用户名、密码等基本信息，并进行验证
- 用户登录：注册成功的用户可以通过用户名和密码登录系统
- 用户信息管理：管理员可以查看、编辑和删除用户信息，包括用户名、密码、角色等
- 权限管理：系统支持对用户权限的管理，包括权限的分配、修改和删除
- 角色管理：系统支持对用户角色的管理，包括角色的创建、修改和删除

## 3. 技术选型
- Spring Boot：作为项目的基础框架，提供快速开发、集成、测试的能力
- MyBatis：用于数据库操作，提供简单、方便的数据持久化方案
- MySQL：作为数据库存储用户信息等数据

## 4. 数据库设计
系统需要设计以下数据库表：
- 用户表（User）：存储用户的基本信息，包括用户名、密码、角色等
- 权限表（Permission）：存储系统的权限信息
- 角色表（Role）：存储系统的角色信息，包括角色名称、权限等
- 用户角色关联表（User_Role）：用于关联用户和角色的关系
- 角色权限表（Role_Permission）：用于关联角色和权限的关系

## 5. 接口设计
系统需要设计以下接口：
- 用户注册接口：`POST /api/user/register`
- 用户登录接口：`POST /api/user/login`
- 用户信息查询接口：`GET /api/user/{userId}`
- 用户信息编辑接口：`PUT /api/user/{userId}`
- 用户信息删除接口：`DELETE /api/user/{userId}`
- 权限管理接口：`GET /api/permission`、`POST /api/permission`、`PUT /api/permission`、`DELETE /api/permission`
- 角色管理接口：`GET /api/role`、`POST /api/role`、`PUT /api/role`、`DELETE /api/role`

## 6. 开发计划
项目开发分为以下阶段：
1. 系统设计与技术选型：完成系统架构设计、技术选型等工作
2. 数据库设计与搭建：设计数据库表结构，并在MySQL中创建相应的表
3. 后端接口开发：开发后端接口，实现用户注册、登录等功能
4. 前端界面开发：开发用户界面，实现用户注册、登录界面等
5. 测试与部署：进行系统功能测试，并将系统部署到服务器上供用户访问

## 7. 项目评分与标准
- 系统设计与技术选型：20分
  - 产出UML类图来说明后端Java类别的设计结构：15分
  - 产出UML部署图来说明系统的技术架构：5分
- 数据库设计与搭建：10分
  - 产出ERD图来说明数据库的设计架构，如表间的关系
- 后端接口开发：40分
  - 按每个接口功能的完成占比来给分（A/N * 40分）
- 前端界面开发：15分
  - 按每个前端界面的完成占比来给分（A/N * 15分）
- 测试与部署：15分
  - 每个接口提交Postman的测试与结果截图（A/N * 15分）

## 8. 提交物
最终提交为班级+姓名+学号的压缩包（如："22软件1张三221000"），包含：

1. 系统设计结果物（UML）
2. 项目源代码
   - 前端代码
   - 后端代码
3. 数据库文件
   - SQL文件或数据库截图（包括表结构截图）
4. 测试和部署文件
   - 测试：测试用例图、测试报告、API测试截图
   - 部署：打包的jar包文件
