package android.support.v4.f;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a<K, V> extends m<K, V> implements Map<K, V> {
    h<K, V> KU;

    public a(int i) {
        super(i);
    }

    public a(m mVar) {
        super(mVar);
    }

    private h<K, V> eg() {
        if (this.KU == null) {
            this.KU = new h<K, V>() {
                /* Access modifiers changed, original: protected|final */
                public final int eh() {
                    return a.this.mSize;
                }

                /* Access modifiers changed, original: protected|final */
                public final Object v(int i, int i2) {
                    return a.this.Ld[(i << 1) + i2];
                }

                /* Access modifiers changed, original: protected|final */
                public final int E(Object obj) {
                    return a.this.indexOfKey(obj);
                }

                /* Access modifiers changed, original: protected|final */
                public final int F(Object obj) {
                    return a.this.indexOfValue(obj);
                }

                /* Access modifiers changed, original: protected|final */
                public final Map<K, V> ei() {
                    return a.this;
                }

                /* Access modifiers changed, original: protected|final */
                public final void d(K k, V v) {
                    a.this.put(k, v);
                }

                /* Access modifiers changed, original: protected|final */
                public final V a(int i, V v) {
                    return a.this.setValueAt(i, v);
                }

                /* Access modifiers changed, original: protected|final */
                public final void aC(int i) {
                    a.this.removeAt(i);
                }

                /* Access modifiers changed, original: protected|final */
                public final void ej() {
                    a.this.clear();
                }
            };
        }
        return this.KU;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        h eg = eg();
        if (eg.Lm == null) {
            eg.Lm = new b();
        }
        return eg.Lm;
    }

    public Set<K> keySet() {
        return eg().getKeySet();
    }

    public Collection<V> values() {
        h eg = eg();
        if (eg.Lo == null) {
            eg.Lo = new e();
        }
        return eg.Lo;
    }
}
