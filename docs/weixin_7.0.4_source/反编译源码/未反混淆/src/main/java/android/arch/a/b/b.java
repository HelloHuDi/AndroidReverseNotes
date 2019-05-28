package android.arch.a.b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Entry<K, V>> {
    public c<K, V> bS;
    public c<K, V> bT;
    public WeakHashMap<f<K, V>, Boolean> bU = new WeakHashMap();
    public int mSize = 0;

    public static class b<K, V> extends e<K, V> {
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* Access modifiers changed, original: final */
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.bX;
        }

        /* Access modifiers changed, original: final */
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.bW;
        }
    }

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* Access modifiers changed, original: final */
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.bW;
        }

        /* Access modifiers changed, original: final */
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.bX;
        }
    }

    public static class c<K, V> implements Entry<K, V> {
        final K bV;
        c<K, V> bW;
        public c<K, V> bX;
        final V mValue;

        c(K k, V v) {
            this.bV = k;
            this.mValue = v;
        }

        public final K getKey() {
            return this.bV;
        }

        public final V getValue() {
            return this.mValue;
        }

        public final V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.bV + "=" + this.mValue;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.bV.equals(cVar.bV) && this.mValue.equals(cVar.mValue)) {
                return true;
            }
            return false;
        }
    }

    public class d implements f<K, V>, Iterator<Entry<K, V>> {
        private c<K, V> bY;
        private boolean bZ;

        private d() {
            this.bZ = true;
        }

        /* synthetic */ d(b bVar, byte b) {
            this();
        }

        public final void c(c<K, V> cVar) {
            if (cVar == this.bY) {
                this.bY = this.bY.bX;
                this.bZ = this.bY == null;
            }
        }

        public final boolean hasNext() {
            if (this.bZ) {
                if (b.this.bS != null) {
                    return true;
                }
                return false;
            } else if (this.bY == null || this.bY.bW == null) {
                return false;
            } else {
                return true;
            }
        }

        public final /* synthetic */ Object next() {
            c a;
            d dVar;
            if (this.bZ) {
                this.bZ = false;
                a = b.this.bS;
                dVar = this;
            } else if (this.bY != null) {
                a = this.bY.bW;
                dVar = this;
            } else {
                a = null;
                dVar = this;
            }
            dVar.bY = a;
            return this.bY;
        }
    }

    interface f<K, V> {
        void c(c<K, V> cVar);
    }

    static abstract class e<K, V> implements f<K, V>, Iterator<Entry<K, V>> {
        c<K, V> bW;
        c<K, V> cb;

        public abstract c<K, V> a(c<K, V> cVar);

        public abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.cb = cVar2;
            this.bW = cVar;
        }

        public boolean hasNext() {
            return this.bW != null;
        }

        public final void c(c<K, V> cVar) {
            if (this.cb == cVar && cVar == this.bW) {
                this.bW = null;
                this.cb = null;
            }
            if (this.cb == cVar) {
                this.cb = b(this.cb);
            }
            if (this.bW == cVar) {
                this.bW = aa();
            }
        }

        private c<K, V> aa() {
            if (this.bW == this.cb || this.cb == null) {
                return null;
            }
            return a(this.bW);
        }

        public /* synthetic */ Object next() {
            c cVar = this.bW;
            this.bW = aa();
            return cVar;
        }
    }

    /* Access modifiers changed, original: protected */
    public c<K, V> d(K k) {
        c cVar = this.bS;
        while (cVar != null && !cVar.bV.equals(k)) {
            cVar = cVar.bW;
        }
        return cVar;
    }

    public V putIfAbsent(K k, V v) {
        c d = d(k);
        if (d != null) {
            return d.mValue;
        }
        b(k, v);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final c<K, V> b(K k, V v) {
        c cVar = new c(k, v);
        this.mSize++;
        if (this.bT == null) {
            this.bS = cVar;
            this.bT = this.bS;
        } else {
            this.bT.bW = cVar;
            cVar.bX = this.bT;
            this.bT = cVar;
        }
        return cVar;
    }

    public V remove(K k) {
        c d = d(k);
        if (d == null) {
            return null;
        }
        this.mSize--;
        if (!this.bU.isEmpty()) {
            for (f c : this.bU.keySet()) {
                c.c(d);
            }
        }
        if (d.bX != null) {
            d.bX.bW = d.bW;
        } else {
            this.bS = d.bW;
        }
        if (d.bW != null) {
            d.bW.bX = d.bX;
        } else {
            this.bT = d.bX;
        }
        d.bW = null;
        d.bX = null;
        return d.mValue;
    }

    public Iterator<Entry<K, V>> iterator() {
        a aVar = new a(this.bS, this.bT);
        this.bU.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public final d Z() {
        d dVar = new d(this, (byte) 0);
        this.bU.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.mSize != bVar.mSize) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
