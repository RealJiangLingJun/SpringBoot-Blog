# SpringBoot-Blog
这是一个基于SpringBoot的个人博客项目。

一、使用技术

后端：SpringBoot、Spring、SpringMVC、Mybatis

前段：thymeleaf、Semantic UI、markdown插件

数据库：mysql

开发工具：idea

JDK：java8

二、数据库表

博客表

```
id、标题、博客摘要、博客内容、发布时间、浏览数、标签、分类、评论、博客首页图、状态（已发布、草稿）、是否开启赞赏、是否开启评论、是否开启推荐、是否开启转载声明，创建时间
```

用户表（管理员）

```
id、用户名称、用户密码、创建时间、是否是管理员、用户头像
```

标签表

```
id、标签名称、博客数量、创建时间
```

分类表

```
id、分类名称（专栏）、简介、博客数量、创建时间
```

评论表

```
id、留言人、留言邮箱、博客id、发布时间、是否是博主、留言状态（未审核、通过）、留言内容、父评论ID
```

