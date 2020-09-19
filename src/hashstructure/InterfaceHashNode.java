package hashstructure;

public interface InterfaceHashNode <K extends Comparable<K>, V>{

	public K getKey();

	public void setKey(K key);

	public V getValue();

	public void setValue(V value);

	public HashNode<K, V> getNext();

	public void setNext(HashNode<K, V> next);
	
	public HashNode<K, V> getPrevious();

	public void setPrevious(HashNode<K, V> previus);

	public void add(HashNode<K, V> node);

	public boolean removeValue(K key);

	public V searchValue(K key);
}
