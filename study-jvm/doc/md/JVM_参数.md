# 1. JVM参数

​		JVM参数分为以下3类：

| 分类         | 使用 | 说明                                                         |
| ------------ | ---- | ------------------------------------------------------------ |
| 标准参数     | -    | 所有的JVM实现都必须实现这些参数的功能，而且向后兼容          |
| 非标准参数   | -X   | 又称扩展参数，默认JVM实现这些参数的功能，但是并不保证所有JVM实现都满足，且不保证向后兼容 |
| 非stable参数 | -XX  | 此类参数各个JVM实现会有所不同，将来可能会随时取消，需要慎重使用 |



# 2. 标准参数

1. -classpath或-cp

2. -server

3. -D<name>=<value> 

4. verbose

   - -verbose:class

     输出JVM载入类的相关信息，当JVM报告说找不到类或者类冲突时可此进行诊断

   - -verbose:gc

     输出每次gc的情况

   - -verbose:jni

     输出native方法调用的相关情况，一般用于诊断jni调用错误信息



# 3. 非标准参数

​		又称为扩展参数。

1. -Xms

   

2. -Xmx

   设置JVM最大可用内存

3. -Xmn

   设置年轻代大小

4. -Xss

   设置每个线程的堆栈大小。jkd5以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K

5. -Xloggc:file

   与-verbose:gc功能类似，只是将每次GC事件的相关情况记录到一个文件中，文件的位置最好在本地，以避免网络的潜在问题。 若与verbose命令同时出现在命令行中，则以-Xloggc为准



# 4. 非stable参数

​		用-XX作为前缀的参数列表在JVM中可能是不健壮的，sun也不推荐使用，后续可能会在没有通知的情况下就直接取消了；但是由于这些参数中的确有很多是对我们很有用的，比如我们经常会见到的-XX:PermSize、-XX:MaxPermSize等等；

## 4.1 行为参数

1. -XX:-UseSerialGC
2. -XX:-UseParallelGC

## 4.2 调优参数

1. -XX:MaxNewSize=

   新生成对象能占用内存的最大值

2. -XX:NewSize=

   新生代对象生成时占用内存的默认值

3. -XX:MaxPermSize=

   老生代对象能占用内存的最大值

## 4.3 调试参数

1. -XX:-TraceClassLoading

   跟踪类的加载信息

2. -XX:-TraceClassLoadingPreorder

   跟踪被引用到的所有类的加载信息

3. -XX:-PrintGC

   每次GC时打印相关信息

4. -XX:-PrintGC Details

   每次GC时打印详细信息

5. -XX:-PrintGCTimeStamps

   打印每次GC的时间戳

6. -XX:-TraceClassResolution

   跟踪常量池


