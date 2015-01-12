package Hashing;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OpenAddressingHashMap<K,V> implements HashTable<K,V> {
	public static final int MIN_CAPACITY =11;
	private HashEntry<K,V>[] elements;
	private int capacity;
	private int size;
	private double minimum;
	private double maximum;
	private double defaultSize;
	
	
	public OpenAddressingHashMap(double min, double max, double defaultSize) {
		assert defaultSize < max && defaultSize<1;
		assert 0 < min && min < max;
		size =0;
		this.minimum = min;
		this.maximum = max;
		this.capacity =MIN_CAPACITY;
		this.defaultSize = defaultSize;
		 
		this.elements = (HashEntry<K,V>[])Array.newInstance(HashEntry.class, capacity);
	}
	
	
	public OpenAddressingHashMap(double min, double max) {
			this(min,max,0.5);
	}
	
	
	
	@Override
	public V get(K key) {
		assert(key != null);
		int index = hash(key)%capacity;
		while(elements[index] != null && !elements[index].getKey().equals(key) ) {
			index = (index +1)%capacity;
		}
		if(elements[index].getKey().equals(key)) {
			return elements[index].getValue();
		}
		
		return null;
	}
	
	private int hash(K key) {
		return Math.abs(key.hashCode());
	}
	
	@Override
	public void put(K key, V value) {
		assert(key != null);
		int index = hash(key)%capacity;
		while(elements[index] != null && !elements[index].getKey().equals(key)) {
			index = (index +1)%capacity;
		}
		 
		elements[index] = new HashEntry<K,V>(key,value);
		size ++;
		if( size> maximum || size < minimum) {
			resize();
		}
	}

	private void resize() {
		if((size*1.0/capacity) < maximum && (size*1.0)/capacity > minimum) {
			return;
		}
		int newCapacity = (int)Math.abs(size/defaultSize);
		if(newCapacity < MIN_CAPACITY) {
			return;
		}
		HashEntry<K,V>[] newElements = (HashEntry<K,V>[])Array.newInstance(HashEntry.class, capacity);
		for(HashEntry<K,V> element : elements ) {
			if(element == null) {
				continue;
			}
			int index = hash(element.getKey())%newCapacity;
			while(newElements[index] != null && !elements[index].getKey().equals(element.getKey())) {
				index = (index+1)%newCapacity;
			}
			newElements[index] = element;
		}
		this.elements = newElements;
		this.capacity = newCapacity;
	}
	
	
	@Override
	public V delete(K key) {
		// TODO Auto-generated method stub
		assert(key !=null);
		int index = hash(key)%capacity;
		List<HashEntry<K,V>> putBack = new LinkedList<HashEntry<K,V>>();
		while(elements[index] != null && !elements[index].getKey().equals(key)) {
			index = (index +1)%capacity;
		}
		
		if(elements[index] == null)
			return null;
		while(elements[index] != null) {
			putBack.add(elements[index]);
			elements[index]  = null;
			index = (index +1) % capacity;
		}
		HashEntry<K,V> deletedNode = putBack.remove(0);
		for(HashEntry<K,V> entry : putBack) {
			this.put(entry.getKey(),entry.getValue());
		}
		return deletedNode.getValue();
	}

	@Override
	public Set<K> keySet() {
		Set<K> keySet = new HashSet<K>();
		for(HashEntry<K,V> entry : elements) 
			keySet .add(entry.getKey());
		return keySet;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
