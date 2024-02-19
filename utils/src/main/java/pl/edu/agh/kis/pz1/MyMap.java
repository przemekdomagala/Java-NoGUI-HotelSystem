package pl.edu.agh.kis.pz1;

import java.util.ArrayList;
import java.util.List;

/**Class implementing custom Map interface.*/
public class MyMap<K, V> implements Map<K, V>{

    /**List of map's keys.*/
    protected List<K> listOfKeys;

    /**List of map's values.*/
    protected List<V> listOfValues;

    /**Default constructor creating lists of keys and values.*/
    MyMap(){
        this.listOfKeys = new ArrayList<>();
        this.listOfValues = new ArrayList<>();
    }

    @Override
    public boolean put(K key, V value) {
        if(key==null || value==null){
            return false;
        }
        if(!this.listOfKeys.contains(key)){
            this.listOfKeys.add(key);
            int idx = this.listOfKeys.indexOf(key);
            this.listOfValues.add(idx, value);
        }
        else{
            this.listOfValues.set(this.listOfKeys.indexOf(key), value);
        }
        return true;
    }

    @Override
    public boolean remove(K key) {
        if(this.listOfKeys.contains(key)){
            this.listOfValues.remove(this.listOfKeys.indexOf(key));
            this.listOfKeys.remove(key);
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        if(this.listOfKeys.contains(key)){
            return this.listOfValues.get(this.listOfKeys.indexOf(key));
        }
        return null;
    }

    @Override
    public List<K> keys() {
        return this.listOfKeys;
    }

    @Override
    public boolean contains(K key) {
        return this.listOfKeys.contains(key);
    }
}
