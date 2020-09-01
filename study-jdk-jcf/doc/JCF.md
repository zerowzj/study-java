





# 三. Map

## 2.1 HashMap

### 2.1.1 重要参数

```java
//容量为16
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
//初始化最大容量：1<<30
static final int MAXIMUM_CAPACITY = 1 << 30;
//0.75为最优
static final float DEFAULT_LOAD_FACTOR = 0.75f;
//默认为 DEFAULT_LOAD_FACTOR 可修改调整
final float loadFactor;
//链表中长度>=8-1 的时候会转为红黑树
static final int TREEIFY_THRESHOLD = 8;
//数组的长度总是 长度总是2的幂（自动调整）
transient Node<K, V>[] table;

static class Node<K,V> implements Map.Entry<K,V> {
   final int hash;
   final K key;
   V value;
   Node<K,V> next;
}
```

### 2.1.2 构造函数

```

```

