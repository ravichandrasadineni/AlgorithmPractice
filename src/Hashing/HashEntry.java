package Hashing;

public class HashEntry<K,V> {
	K key;
	V value;
	HashEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	K getKey() {
		return this.key;
	}
	V getValue() {
		return this.value;
	}
}
