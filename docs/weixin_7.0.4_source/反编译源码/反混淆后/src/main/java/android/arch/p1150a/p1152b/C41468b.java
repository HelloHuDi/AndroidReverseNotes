package android.arch.p1150a.p1152b;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

/* renamed from: android.arch.a.b.b */
public class C41468b<K, V> implements Iterable<Entry<K, V>> {
    /* renamed from: bS */
    public C25283c<K, V> f16596bS;
    /* renamed from: bT */
    public C25283c<K, V> f16597bT;
    /* renamed from: bU */
    public WeakHashMap<C41467f<K, V>, Boolean> f16598bU = new WeakHashMap();
    public int mSize = 0;

    /* renamed from: android.arch.a.b.b$b */
    public static class C17363b<K, V> extends C41469e<K, V> {
        public C17363b(C25283c<K, V> c25283c, C25283c<K, V> c25283c2) {
            super(c25283c, c25283c2);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final C25283c<K, V> mo31442a(C25283c<K, V> c25283c) {
            return c25283c.f5023bX;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final C25283c<K, V> mo31443b(C25283c<K, V> c25283c) {
            return c25283c.f5022bW;
        }
    }

    /* renamed from: android.arch.a.b.b$a */
    static class C25282a<K, V> extends C41469e<K, V> {
        C25282a(C25283c<K, V> c25283c, C25283c<K, V> c25283c2) {
            super(c25283c, c25283c2);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final C25283c<K, V> mo31442a(C25283c<K, V> c25283c) {
            return c25283c.f5022bW;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final C25283c<K, V> mo31443b(C25283c<K, V> c25283c) {
            return c25283c.f5023bX;
        }
    }

    /* renamed from: android.arch.a.b.b$c */
    public static class C25283c<K, V> implements Entry<K, V> {
        /* renamed from: bV */
        final K f5021bV;
        /* renamed from: bW */
        C25283c<K, V> f5022bW;
        /* renamed from: bX */
        public C25283c<K, V> f5023bX;
        final V mValue;

        C25283c(K k, V v) {
            this.f5021bV = k;
            this.mValue = v;
        }

        public final K getKey() {
            return this.f5021bV;
        }

        public final V getValue() {
            return this.mValue;
        }

        public final V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.f5021bV + "=" + this.mValue;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C25283c)) {
                return false;
            }
            C25283c c25283c = (C25283c) obj;
            if (this.f5021bV.equals(c25283c.f5021bV) && this.mValue.equals(c25283c.mValue)) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: android.arch.a.b.b$d */
    public class C37092d implements C41467f<K, V>, Iterator<Entry<K, V>> {
        /* renamed from: bY */
        private C25283c<K, V> f15630bY;
        /* renamed from: bZ */
        private boolean f15631bZ;

        private C37092d() {
            this.f15631bZ = true;
        }

        /* synthetic */ C37092d(C41468b c41468b, byte b) {
            this();
        }

        /* renamed from: c */
        public final void mo59111c(C25283c<K, V> c25283c) {
            if (c25283c == this.f15630bY) {
                this.f15630bY = this.f15630bY.f5023bX;
                this.f15631bZ = this.f15630bY == null;
            }
        }

        public final boolean hasNext() {
            if (this.f15631bZ) {
                if (C41468b.this.f16596bS != null) {
                    return true;
                }
                return false;
            } else if (this.f15630bY == null || this.f15630bY.f5022bW == null) {
                return false;
            } else {
                return true;
            }
        }

        public final /* synthetic */ Object next() {
            C25283c a;
            C37092d c37092d;
            if (this.f15631bZ) {
                this.f15631bZ = false;
                a = C41468b.this.f16596bS;
                c37092d = this;
            } else if (this.f15630bY != null) {
                a = this.f15630bY.f5022bW;
                c37092d = this;
            } else {
                a = null;
                c37092d = this;
            }
            c37092d.f15630bY = a;
            return this.f15630bY;
        }
    }

    /* renamed from: android.arch.a.b.b$f */
    interface C41467f<K, V> {
        /* renamed from: c */
        void mo59111c(C25283c<K, V> c25283c);
    }

    /* renamed from: android.arch.a.b.b$e */
    static abstract class C41469e<K, V> implements C41467f<K, V>, Iterator<Entry<K, V>> {
        /* renamed from: bW */
        C25283c<K, V> f16599bW;
        /* renamed from: cb */
        C25283c<K, V> f16600cb;

        /* renamed from: a */
        public abstract C25283c<K, V> mo31442a(C25283c<K, V> c25283c);

        /* renamed from: b */
        public abstract C25283c<K, V> mo31443b(C25283c<K, V> c25283c);

        C41469e(C25283c<K, V> c25283c, C25283c<K, V> c25283c2) {
            this.f16600cb = c25283c2;
            this.f16599bW = c25283c;
        }

        public boolean hasNext() {
            return this.f16599bW != null;
        }

        /* renamed from: c */
        public final void mo59111c(C25283c<K, V> c25283c) {
            if (this.f16600cb == c25283c && c25283c == this.f16599bW) {
                this.f16599bW = null;
                this.f16600cb = null;
            }
            if (this.f16600cb == c25283c) {
                this.f16600cb = mo31443b(this.f16600cb);
            }
            if (this.f16599bW == c25283c) {
                this.f16599bW = m72351aa();
            }
        }

        /* renamed from: aa */
        private C25283c<K, V> m72351aa() {
            if (this.f16599bW == this.f16600cb || this.f16600cb == null) {
                return null;
            }
            return mo31442a(this.f16599bW);
        }

        public /* synthetic */ Object next() {
            C25283c c25283c = this.f16599bW;
            this.f16599bW = m72351aa();
            return c25283c;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: d */
    public C25283c<K, V> mo31439d(K k) {
        C25283c c25283c = this.f16596bS;
        while (c25283c != null && !c25283c.f5021bV.equals(k)) {
            c25283c = c25283c.f5022bW;
        }
        return c25283c;
    }

    public V putIfAbsent(K k, V v) {
        C25283c d = mo31439d(k);
        if (d != null) {
            return d.mValue;
        }
        mo66101b(k, v);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final C25283c<K, V> mo66101b(K k, V v) {
        C25283c c25283c = new C25283c(k, v);
        this.mSize++;
        if (this.f16597bT == null) {
            this.f16596bS = c25283c;
            this.f16597bT = this.f16596bS;
        } else {
            this.f16597bT.f5022bW = c25283c;
            c25283c.f5023bX = this.f16597bT;
            this.f16597bT = c25283c;
        }
        return c25283c;
    }

    public V remove(K k) {
        C25283c d = mo31439d(k);
        if (d == null) {
            return null;
        }
        this.mSize--;
        if (!this.f16598bU.isEmpty()) {
            for (C41467f c : this.f16598bU.keySet()) {
                c.mo59111c(d);
            }
        }
        if (d.f5023bX != null) {
            d.f5023bX.f5022bW = d.f5022bW;
        } else {
            this.f16596bS = d.f5022bW;
        }
        if (d.f5022bW != null) {
            d.f5022bW.f5023bX = d.f5023bX;
        } else {
            this.f16597bT = d.f5023bX;
        }
        d.f5022bW = null;
        d.f5023bX = null;
        return d.mValue;
    }

    public Iterator<Entry<K, V>> iterator() {
        C25282a c25282a = new C25282a(this.f16596bS, this.f16597bT);
        this.f16598bU.put(c25282a, Boolean.FALSE);
        return c25282a;
    }

    /* renamed from: Z */
    public final C37092d mo66100Z() {
        C37092d c37092d = new C37092d(this, (byte) 0);
        this.f16598bU.put(c37092d, Boolean.FALSE);
        return c37092d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C41468b)) {
            return false;
        }
        C41468b c41468b = (C41468b) obj;
        if (this.mSize != c41468b.mSize) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c41468b.iterator();
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
