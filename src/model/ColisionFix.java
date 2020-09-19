package model;

import java.util.Hashtable;

import hashstructure.HashNode;
import hashstructure.InterfaceHashTable;

public class ColisionFix implements InterfaceHashTable<String, String>{

	private Hashtable<String,HashNode<String, String>> list;//Hashtable de java

	public ColisionFix() {
		list = new Hashtable<String, HashNode<String,String>>();
	}
	
	@Override
	public void add(String key, String value) {
		if(list.containsKey(key)) {
			list.get(key).add(new HashNode<String, String>(key, value));
		}else
			list.put(key,new HashNode<String, String>(key, value));
	}

	@Override
	public String getValue(String key) {
		HashNode<String, String> aux = list.get(key);
		if(aux!=null) {
			if(aux.getKey().compareTo(key)==0) {
				return aux.getValue();
			}else
				return aux.searchValue(key);
		}else
			return null;
	}

	@Override
	public boolean remove(String key) {
		HashNode<String, String> aux = list.get(key);
		if(aux != null) {
			if(aux.getKey().compareTo(key)==0) {
				if(aux.getNext()==null) {
					list.remove(key);
					return true;
				}else {
					HashNode<String, String> x = aux;
					aux = x.getNext();
					x.getNext().setPrevious(null);
					
					return true;
				}
			}else {
				if(aux.removeValue(key)) {
					return true;
				}else
					return false;
			}
		}else 
			return false;
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return  list.containsKey(key);
	}

	@Override
	public long getSize() {
		return list.size();
	}

	


	
}
