﻿# ManagementSystem Introduce
1.以学习的目的，带小弟系统的开发一个项目，该项目是对互联网上的FhAdmin管理系统的重构（多数都重新开发）。<br>
2.管理系统通常会在一台服务器部署使用（管理的系统，一般都是内部企业的使用，中国企业算有1-2万人，一台服务器足以承受），但是前面提到，是以学习的目的而开发，所以该系统会用到分布式等方式，所以不易扩展的session，最后看情况会不会用到。<br>
3.权限管理方面，不晓得用什么好，是Shiro，还是其他什么？目前还没确定。<br>
4.使用的框架、技术有：<br>
 bootstrap（前端）、<br>
 ichart（前端的图表控件）、<br>
 SpringMvc（MVC框架）、<br>
 mybabit（数据库访问层）、<br>
 redis（缓存，如果不用session，就会用redis来共享session等，方便系统做负载均衡的配置）、<br>
 quartz（定时器，监控方面可能会用到）、<br>
 Restful（Web service方式，为传递json等格式使用）、<br>
 gRPC/ Dubbo框架（rpc框架，为了让平台服务和MVC分离。我看了代码风格，感觉和netty类似，结果是基于netty开发的，或者扩展的）、<br>
 rabbitmq（目前待定）。<br>
 其中mysql、rabbitmq、redis的集群等配置，略。<br>
 <br>

插件管理方面，用的maven。同时，我也也为了照顾、方便小白，我连会用到的tomcat，都会写在pom.xml中，只要使用者run一下，就可以使用，无需多余的配置操作。<br>