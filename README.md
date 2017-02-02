# ManagementSystem Introduce
1.项目目的：是对互联网上的FhAdmin管理系统的重构（多数都重新开发），做到通用的管理平台。
如果想看“易扩容的、易开发的”架构，请浏览我的<a target=_blank href="https://github.com/orange1438/SpringBootService">《SpringBootService》</a>项目。<br>

2.管理系统通常会在一台服务器部署使用（管理的系统，一般都是内部企业的使用，中国企业算有1-2万人，一台服务器足以承受）<br>
3.权限管理方面，根据RBAC原则，重新设计数据表，做到权限达到细颗粒的权限控制（以按钮为例）<br>
4.代码编码：utf-8编码<br><br>
- - - 

### 更新说明
1.增加环境配置：开发环境、生产环境的区分；<br>
2.在代码、前端的文件夹等对应地方，增加了ReadMe.md，用来说明相应的命名规范；<br>
3.事务统一配置在service层，故service层只做业务数据的处理；<br>
4.因为需求关系（该项目是管理系统），不使用redis，用ehcache技术（也可以分布式的配置）作为缓存，替代session；<br>
注：数据表等我通用权限设计好，并业务逻辑写好就上传

### 使用的框架
*   bootstrap（前端）、<br>
*   ichart（前端的图表控件）、<br>
*   SpringMvc（MVC框架）、<br>
*   mybabit（数据库访问层）、<br>
*   quartz（定时器，监控方面可能会用到）、<br>
*   Restful（为传递json等格式使用）、<br>

### 视情况而用的技术——提高并发处理的能力
*   redis（缓存，如果不用session，就会用redis来共享session等，方便系统做负载均衡的配置）、<br>
*   gRPC/ Dubbo框架（rpc框架，为了让平台服务和MVC分离。我看了代码风格，感觉和netty类似，结果是基于netty开发的，或者扩展的）、<br>
*   rabbitmq（目前待定）。<br>
*   其中mysql、rabbitmq、redis的集群等配置，略。<br>
*   对于部署集群方面，参考vert-x3框架、RxJava、netty、nginx、actor模型等。<br>

## 插件maven
同时，我也为了照顾、方便小白，我连会用到的tomcat，都会写在pom.xml中，只要使用者run一下，就可以使用，无需多余的配置操作。<br>
注：我使用的org.mybatis.generator的版本是我自己修改的<a target=_blank href="https://github.com/orange1438/mybatis-generator-core-chinese-annotation">1.3.5-chinese-annotation-by-orange1438版本</a><br>