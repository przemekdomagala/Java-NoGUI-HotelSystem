package pl.edu.agh.kis.pz1;

import java.util.List;

/**
 * Interface used to implement custom map container MyMap
 **/
public interface Map<K, V> {
    /**
     * Adding element to map for passed key
     if key exist then value should be substituted
     * @param key key (not null)
     * @param value assigned to the key (not null)
     * @return true if adding was successful, false otherwise
     */
    boolean put(K key, V value);
    /**
     * Removal of passed key and value assigned to it
     * @param key key to remove
     * @return true if removal was successful, false otherwise
     */
    boolean remove(K key);
    /**
     * returns value assigned to the key, null if key doesn't exist
     * @param key key (not ull)
     * @return value assigned to the key or null if key doesn't exist
     */
    V get(K key);
    /**
     * Returns list of keys
     * @return java.util.List of keys
     */
    List<K> keys();
    /**
     * Checks whether passed key exist in map
     * @param key key to check
     * @return true if key exists in map
     */
    boolean contains(K key);
}
