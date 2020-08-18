# redis

## redis 数据类型

* String  ( 字符串)
* list  （列表）
* set （集合）
* 有序set （有序集合）
* hex  （2进制对象）

## redis持久化

* aof 日志的方式进行持久化

  > 优势：数据不会丢失，如果开始起了  fsync  会一秒同步一次，最多会丢失1秒的数据，
  >
  > 劣势：性能会受到一定的影响   ，开启fsync 性能下降较少

* rdb 快照的方式进行持久化

  > 优势：恢复数据快
  >
  > 劣势：会丢失数据

## redis 字符串的实现

* https://www.cnblogs.com/wyc1994666/p/10669212.html
* sds 代码结构  包含  len  free  和  buf数组
* 开辟与已使用大小len相同长度的空闲free空间（如果len < 1M）开辟1M长度的空闲free空间（如果len >= 1M）