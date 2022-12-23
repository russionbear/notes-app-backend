# 笔记软件后端

- 使用spring boot3 + nacos 进行微服务框架开发
- 不管理html、css、js等静态资源，只提供后端接口，有的接口能返回图片
- 未部署服务器，因为部署过程中的bug太多且解决不了

## 运行
out/jar文件夹中有四个jar包
- 导入sql，数据库的版本还是要高一点，不然`uuid()`都不能用
- 运行nacos，本项目使用的端口为8848
- 启动四个jar包，或者`idea`启动这四个子项目
- 浏览器访问```http://whitebear.ml/note/local```(github静态页面，[项目地址](https://github.com/russionbear/notes-app-vue))、或者启动out/里面的 `javafx + webView`工程

## codemaker
mybatis-plus的代码生成器

## resource
主要负责静态资源
/static/**: 将数据、图片、视频等从数据数据库中取出  
部署过程中的bug
- 地址映射，宝塔不支持填写端口的外网地址，nginx配置listen之后，该端口的服务就启动不了了
- mysql、mariadb数据双部署，因为还有node程序在跑
- 开发和部署完全不同啊！！！

## article
主要负责管理博客、笔记本
- 没有版本控制的相关字段，删了就没了

## user_info
如其名，主要负责管理用户信息

- 有个表专门存放token信息、token用来对请求来源进行验证
- 嘿嘿，因为时间有限，没有任何接口实现这个token验证
- 有版本控制的字段，但好像不存在一样

## gateway
目前配置文件里的路由的地址没有用 lb://* (应该没记错) ，因为不启作用
- 路由里的端口写死了，其他的几个程序不能随机更改启动端口
- 默认端口：20010

## feeling
感觉node更好用点，除了不能保证稳定性，其他的、框架健全程度、运行速度、<b>开发效率</b>（甚至前后端同一个）都很ok，而boot则不然，不知是b站上的教程不够丰富还是我用的版本太高  
这应该是第一个/最后一个 spring boot项目吧
