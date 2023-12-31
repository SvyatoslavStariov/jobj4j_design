package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int index = getIndex(key);
        boolean isPresent = table[index] == null;
        if (isPresent) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            if (count >= table.length * LOAD_FACTOR) {
                expand();
            }
        }
        return isPresent;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        MapEntry<K, V>[] temp = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> entry : temp) {
            if (entry != null) {
                int index = getIndex(entry.key);
                table[index] = new MapEntry<>(entry.key, entry.value);
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        int hash = hash(Objects.hashCode(key));
        int index = indexFor(hash);
        MapEntry<K, V> entry = table[index];
        if (isKeyEquals(key, entry)) {
            result = entry.value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        int hash = hash(Objects.hashCode(key));
        int index = indexFor(hash);
        MapEntry<K, V> entry = table[index];
        boolean isRemove = false;
        if (isKeyEquals(key, entry)) {
            modCount++;
            count--;
            table[index] = null;
            isRemove = true;
        }
        return isRemove;
    }

    private boolean isKeyEquals(K key, MapEntry<K, V> entry) {
        return entry != null && (Objects.hashCode(entry.key) == Objects.hashCode(key) && entry.key == key
                || (key != null && key.equals(entry.key)));
    }

    private int getIndex(K key) {
        return indexFor(hash(Objects.hashCode(key)));
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int index;

            private final int modCountIter = modCount;

            @Override
            public boolean hasNext() {
                if (modCountIter != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (table.length != index && table[index] == null) {
                    index++;
                }
                return table.length > index;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}