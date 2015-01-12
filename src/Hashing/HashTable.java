package Hashing;

import java.util.Set;

public interface HashTable<K,V> {
   V get(K key);
   void put(K key, V value);
   V delete(K key);
   Set<K> keySet();
   int size();
}
