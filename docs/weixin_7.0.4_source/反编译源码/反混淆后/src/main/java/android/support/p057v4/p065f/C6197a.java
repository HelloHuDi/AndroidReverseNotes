package android.support.p057v4.p065f;

import android.support.p057v4.p065f.C0414h.C0410b;
import android.support.p057v4.p065f.C0414h.C0413e;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.f.a */
public class C6197a<K, V> extends C0417m<K, V> implements Map<K, V> {
    /* renamed from: KU */
    C0414h<K, V> f1790KU;

    /* renamed from: android.support.v4.f.a$1 */
    class C61961 extends C0414h<K, V> {
        C61961() {
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: eh */
        public final int mo732eh() {
            return C6197a.this.mSize;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: v */
        public final Object mo735v(int i, int i2) {
            return C6197a.this.f498Ld[(i << 1) + i2];
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: E */
        public final int mo727E(Object obj) {
            return C6197a.this.indexOfKey(obj);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: F */
        public final int mo728F(Object obj) {
            return C6197a.this.indexOfValue(obj);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: ei */
        public final Map<K, V> mo733ei() {
            return C6197a.this;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: d */
        public final void mo731d(K k, V v) {
            C6197a.this.put(k, v);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final V mo729a(int i, V v) {
            return C6197a.this.setValueAt(i, v);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: aC */
        public final void mo730aC(int i) {
            C6197a.this.removeAt(i);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: ej */
        public final void mo734ej() {
            C6197a.this.clear();
        }
    }

    public C6197a(int i) {
        super(i);
    }

    public C6197a(C0417m c0417m) {
        super(c0417m);
    }

    /* renamed from: eg */
    private C0414h<K, V> m9961eg() {
        if (this.f1790KU == null) {
            this.f1790KU = new C61961();
        }
        return this.f1790KU;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        C0414h eg = m9961eg();
        if (eg.f490Lm == null) {
            eg.f490Lm = new C0410b();
        }
        return eg.f490Lm;
    }

    public Set<K> keySet() {
        return m9961eg().getKeySet();
    }

    public Collection<V> values() {
        C0414h eg = m9961eg();
        if (eg.f492Lo == null) {
            eg.f492Lo = new C0413e();
        }
        return eg.f492Lo;
    }
}
