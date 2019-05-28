package android.arch.a.b;

import android.arch.a.b.b.c;
import java.util.HashMap;

public final class a<K, V> extends b<K, V> {
    public HashMap<K, c<K, V>> bR = new HashMap();

    /* Access modifiers changed, original: protected|final */
    public final c<K, V> d(K k) {
        return (c) this.bR.get(k);
    }

    public final V putIfAbsent(K k, V v) {
        c d = d(k);
        if (d != null) {
            return d.mValue;
        }
        this.bR.put(k, b(k, v));
        return null;
    }

    public final V remove(K k) {
        Object remove = super.remove(k);
        this.bR.remove(k);
        return remove;
    }

    public final boolean contains(K k) {
        return this.bR.containsKey(k);
    }
}
