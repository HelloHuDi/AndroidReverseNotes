package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Value;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class V8Map<V> implements Releasable, Map<V8Value, V> {
    private Map<V8Value, V> map = new HashMap();
    private Map<V8Value, V8Value> twinMap = new HashMap();

    public V8Map() {
        AppMethodBeat.i(75090);
        AppMethodBeat.o(75090);
    }

    public void release() {
        AppMethodBeat.i(75091);
        clear();
        AppMethodBeat.o(75091);
    }

    public int size() {
        AppMethodBeat.i(75092);
        int size = this.map.size();
        AppMethodBeat.o(75092);
        return size;
    }

    public boolean isEmpty() {
        AppMethodBeat.i(75093);
        boolean isEmpty = this.map.isEmpty();
        AppMethodBeat.o(75093);
        return isEmpty;
    }

    public boolean containsKey(Object obj) {
        AppMethodBeat.i(75094);
        boolean containsKey = this.map.containsKey(obj);
        AppMethodBeat.o(75094);
        return containsKey;
    }

    public boolean containsValue(Object obj) {
        AppMethodBeat.i(75095);
        boolean containsValue = this.map.containsValue(obj);
        AppMethodBeat.o(75095);
        return containsValue;
    }

    public V get(Object obj) {
        AppMethodBeat.i(75096);
        Object obj2 = this.map.get(obj);
        AppMethodBeat.o(75096);
        return obj2;
    }

    public V put(V8Value v8Value, V v) {
        AppMethodBeat.i(75097);
        remove(v8Value);
        V8Value twin = v8Value.twin();
        this.twinMap.put(twin, twin);
        Object put = this.map.put(twin, v);
        AppMethodBeat.o(75097);
        return put;
    }

    public V remove(Object obj) {
        AppMethodBeat.i(75098);
        Object remove = this.map.remove(obj);
        V8Value v8Value = (V8Value) this.twinMap.remove(obj);
        if (v8Value != null) {
            v8Value.release();
        }
        AppMethodBeat.o(75098);
        return remove;
    }

    public void putAll(Map<? extends V8Value, ? extends V> map) {
        AppMethodBeat.i(75099);
        for (Entry entry : map.entrySet()) {
            put((V8Value) entry.getKey(), entry.getValue());
        }
        AppMethodBeat.o(75099);
    }

    public void clear() {
        AppMethodBeat.i(75100);
        this.map.clear();
        for (V8Value release : this.twinMap.keySet()) {
            release.release();
        }
        this.twinMap.clear();
        AppMethodBeat.o(75100);
    }

    public Set<V8Value> keySet() {
        AppMethodBeat.i(75101);
        Set keySet = this.map.keySet();
        AppMethodBeat.o(75101);
        return keySet;
    }

    public Collection<V> values() {
        AppMethodBeat.i(75102);
        Collection values = this.map.values();
        AppMethodBeat.o(75102);
        return values;
    }

    public Set<Entry<V8Value, V>> entrySet() {
        AppMethodBeat.i(75103);
        Set entrySet = this.map.entrySet();
        AppMethodBeat.o(75103);
        return entrySet;
    }
}
