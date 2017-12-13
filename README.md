# taiji-work-day1213-redis

**redis**

开源的内存数据库，key-value,nosql

特点： 常用于持久化。数据结构丰富。设置TTL存活时间，自动删除。

redis单线程(java)，memcached多线程(php)。

应用：缓存，分布式session存储等。。。

	redis默认端口:6379
	
	timeout 300; 过期
	loglevel verbose 日志记录级别
	logfile stdout 日志记录方式

	save <seconds> <changes>
	save 300 1;

	dbfilename dump.rdb 指定本地默认数据库

	maxmemory <bytes>
	appendonly no异步写入磁盘

redis支持：push/pop,add/remove

	setnx name iii# 键已存在则返回0，不更新，防止覆盖
	setex key 1 red 设置key存在1s
	setnx key value key 已存在，则返回(integer) 0，不会覆盖
	keys * 显示所有key
	getset key newvalue 重新设置key的值，并显示原来的值
	
	getrange key start end 显示key 从start到end 的字符(字符数组从0开始)
	mset name1 value1 name2 value2 name3 value3#一次设置多个键的值
	mget name1 name2 name3#一次获取多个键的值
	append name1 @126.com 给name1的值后面添加 @126.com，并显示现在字符长度

	incr key 值为整数类型，则 +1；不是，则报错
	decrby key value 值为整数类型，则 -value(自定义值)；不是，则报错


	哈希：
		hset key field1 value
		hset key field2 value 给指定对象的给属性赋值
		hmset key field1 value field2 value
 		hmget key field1 field2 添加、获取指定对象多个字段
		
		hincrby key field -3	指定对象的指定字段-3(自定义值)
		hexists key field 指定对象的指定字段是(1) 否(0)存在
		hgetall key 获取指定对象所有属性和值
		hlen key 指定对象的 属性个数
		hdel key field 删除指定对象的指定字段
		hkeys key 返回key中所有字段

	list
		lpush key headvalue 从头插入值
		rpush key endvalue 从尾插入值

		lrange key 0 -1 获取0到最后(从后数用 负数)1位


	set
		sadd key value    set存数据
		sdiffstore retkey key1 key2 返回key1,key2的差集到retkey
		sinterstore inkey key1 key2 返回key1,key2的交集到retkey

		zincrby zsetkey increment "field"



redis 持久化：① RBD方式 ② AOF方式(常用)

redis消息队列：

	①生产者消费者模式(先到先得)；
	② 发布订阅者方式(一对多)

Spring Data Redis 基于jedis客户端API的封装

	jedis不足
		数据操作需要序列化(编译成二进制流)和反序列化(从二进制流转出)
		事务操作纯粹为硬编码

	Spring Data Redis提供功能
		连接池自动管理
		封装operation接口（5个）
		将事务封装，用容器控制
		redisSeralizer
		基于设计模式和JMS开发思路，将pub/sub的API进行封装





