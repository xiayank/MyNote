# Concept & Definition

## Web Service

简单地说, 也就是服务器如何向客户端提供服务.

常用的方法有:
RPC 所谓的远程过程调用 (面向方法)
SOA 所谓的面向服务的架构(面向消息)
REST 所谓的 Representational state transfer (面向资源)

- RPC
RPC 即远程过程调用, 很简单的概念, 像调用本地服务(方法)一样调用服务器的服务(方法).
通常的实现有 XML-RPC , JSON-RPC , 通信方式基本相同, 所不同的只是传输数据的格式.

- REST
REST 是以 资源 为中心, 名词即资源的地址, 动词即施加于名词上的一些有限操作, 表达是对各种资源形态的抽象.
以HTTP为例, 名词即为URI(统一资源标识), 动词包括POST, GET, PUT, DELETE等(还有其它不常用的2个,所以 整个动词集合是有限的), 资源的形态(如text, html, image, pdf等)

如果你想只记住一点,那么就请记住 RPC是以动词为中心的, REST是以名词为中心的, 此处的 动词指的是一些方法, 名词是指资源.

### HTTP和RPC场景比较
http接口是在接口不多、系统与系统交互较少的情况下，解决信息孤岛初期常使用的一种通信手段；优点就是简单、直接、开发方便。利用现成的http协议进行传输。
但是如果是一个大型的网站，内部子系统较多、接口非常多的情况下，RPC框架的好处就显示出来了，首先就是长链接，不必每次通信都要像http一样去3次握手什么的，减少了网络开销；其次就是RPC框架一般都有注册中心，有丰富的监控管理；发布、下线接口、动态扩展等，对调用方来说是无感知、统一化的操作。第三个来说就是安全性。最后就是最近流行的服务化架构、服务化治理，RPC框架是一个强力的支撑

-----

## Collection

#### Type
- Collection（一组对立的元素）
 - List（有顺序）
 - Set（不能有重复元素）add
 - Queue（保存队列先进先出 的顺序）

- Map（键值对（key-value）- put(key, value), get(key)

#### Interface Iterable
Collection 的父接口，可以使用foreach 进行遍历，还有迭代器iterator() 方法进行遍历

#### Collection & Map 区别
- Collection
每个位置只能保存一个元素
- Map
保存的是键值对（key-value），可以通过过key，来找到value

> https://github.com/Tikitoo/blog/issues/30
