package android.arch.p1150a.p1152b;

import android.arch.p1150a.p1152b.C41468b.C25283c;
import java.util.HashMap;

/* renamed from: android.arch.a.b.a */
public final class C17362a<K, V> extends C41468b<K, V> {
    /* renamed from: bR */
    public HashMap<K, C25283c<K, V>> f3605bR = new HashMap();

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final C25283c<K, V> mo31439d(K k) {
        return (C25283c) this.f3605bR.get(k);
    }

    public final V putIfAbsent(K k, V v) {
        C25283c d = mo31439d(k);
        if (d != null) {
            return d.mValue;
        }
        this.f3605bR.put(k, mo66101b(k, v));
        return null;
    }

    public final V remove(K k) {
        Object remove = super.remove(k);
        this.f3605bR.remove(k);
        return remove;
    }

    public final boolean contains(K k) {
        return this.f3605bR.containsKey(k);
    }
}
