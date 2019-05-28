package com.tencent.mm.a;

import java.util.Map;
import java.util.Set;

public interface f<K, O> {

    public interface a<K, O> {
    }

    public interface b<K, O> {
        void c(K k, O o, O o2);
    }

    public interface c<K, O> {
        int l(K k, O o);
    }

    void a(a<K, O> aVar);

    O ai(K k);

    boolean aj(K k);

    boolean ak(K k);

    void clear();

    int createCount();

    int evictionCount();

    O get(K k);

    int hitCount();

    void k(K k, O o);

    Set<K> keySet();

    int maxSize();

    int missCount();

    O put(K k, O o);

    int putCount();

    O remove(K k);

    int size();

    int sizeOf(K k, O o);

    Map<K, O> snapshot();

    void trimToSize(int i);
}
