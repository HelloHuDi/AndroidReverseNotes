package android.support.p057v4.p065f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: android.support.v4.f.h */
public abstract class C0414h<K, V> {
    /* renamed from: Lm */
    C0410b f490Lm;
    /* renamed from: Ln */
    C0411c f491Ln;
    /* renamed from: Lo */
    C0413e f492Lo;

    /* renamed from: android.support.v4.f.h$a */
    final class C0409a<T> implements Iterator<T> {
        /* renamed from: Lp */
        final int f481Lp;
        /* renamed from: Lq */
        boolean f482Lq = false;
        int mIndex;
        int mSize;

        C0409a(int i) {
            this.f481Lp = i;
            this.mSize = C0414h.this.mo732eh();
        }

        public final boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        public final T next() {
            if (hasNext()) {
                Object v = C0414h.this.mo735v(this.mIndex, this.f481Lp);
                this.mIndex++;
                this.f482Lq = true;
                return v;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            if (this.f482Lq) {
                this.mIndex--;
                this.mSize--;
                this.f482Lq = false;
                C0414h.this.mo730aC(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: android.support.v4.f.h$b */
    final class C0410b implements Set<Entry<K, V>> {
        C0410b() {
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int eh = C0414h.this.mo732eh();
            for (Entry entry : collection) {
                C0414h.this.mo731d(entry.getKey(), entry.getValue());
            }
            return eh != C0414h.this.mo732eh();
        }

        public final void clear() {
            C0414h.this.mo734ej();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int E = C0414h.this.mo727E(entry.getKey());
            if (E >= 0) {
                return C0404c.equal(C0414h.this.mo735v(E, 1), entry.getValue());
            }
            return false;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return C0414h.this.mo732eh() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new C0412d();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return C0414h.this.mo732eh();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return C0414h.m697a((Set) this, obj);
        }

        public final int hashCode() {
            int eh = C0414h.this.mo732eh() - 1;
            int i = 0;
            while (eh >= 0) {
                int i2;
                Object v = C0414h.this.mo735v(eh, 0);
                Object v2 = C0414h.this.mo735v(eh, 1);
                int hashCode = v == null ? 0 : v.hashCode();
                if (v2 == null) {
                    i2 = 0;
                } else {
                    i2 = v2.hashCode();
                }
                eh--;
                i += i2 ^ hashCode;
            }
            return i;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: android.support.v4.f.h$c */
    final class C0411c implements Set<K> {
        C0411c() {
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            C0414h.this.mo734ej();
        }

        public final boolean contains(Object obj) {
            return C0414h.this.mo727E(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map ei = C0414h.this.mo733ei();
            for (Object containsKey : collection) {
                if (!ei.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return C0414h.this.mo732eh() == 0;
        }

        public final Iterator<K> iterator() {
            return new C0409a(0);
        }

        public final boolean remove(Object obj) {
            int E = C0414h.this.mo727E(obj);
            if (E < 0) {
                return false;
            }
            C0414h.this.mo730aC(E);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map ei = C0414h.this.mo733ei();
            int size = ei.size();
            for (Object remove : collection) {
                ei.remove(remove);
            }
            return size != ei.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return C0414h.m696a(C0414h.this.mo733ei(), (Collection) collection);
        }

        public final int size() {
            return C0414h.this.mo732eh();
        }

        public final Object[] toArray() {
            return C0414h.this.mo822aG(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return C0414h.this.mo823c(tArr, 0);
        }

        public final boolean equals(Object obj) {
            return C0414h.m697a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int eh = C0414h.this.mo732eh() - 1; eh >= 0; eh--) {
                Object v = C0414h.this.mo735v(eh, 0);
                i += v == null ? 0 : v.hashCode();
            }
            return i;
        }
    }

    /* renamed from: android.support.v4.f.h$d */
    final class C0412d implements Iterator<Entry<K, V>>, Entry<K, V> {
        /* renamed from: Ls */
        int f487Ls;
        /* renamed from: Lt */
        boolean f488Lt = false;
        int mIndex;

        C0412d() {
            this.f487Ls = C0414h.this.mo732eh() - 1;
            this.mIndex = -1;
        }

        public final boolean hasNext() {
            return this.mIndex < this.f487Ls;
        }

        public final void remove() {
            if (this.f488Lt) {
                C0414h.this.mo730aC(this.mIndex);
                this.mIndex--;
                this.f487Ls--;
                this.f488Lt = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.f488Lt) {
                return C0414h.this.mo735v(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.f488Lt) {
                return C0414h.this.mo735v(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.f488Lt) {
                return C0414h.this.mo729a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.f488Lt) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (C0404c.equal(entry.getKey(), C0414h.this.mo735v(this.mIndex, 0)) && C0404c.equal(entry.getValue(), C0414h.this.mo735v(this.mIndex, 1))) {
                    return true;
                }
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f488Lt) {
                Object v = C0414h.this.mo735v(this.mIndex, 0);
                Object v2 = C0414h.this.mo735v(this.mIndex, 1);
                int hashCode = v == null ? 0 : v.hashCode();
                if (v2 != null) {
                    i = v2.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }

        public final /* synthetic */ Object next() {
            if (hasNext()) {
                this.mIndex++;
                this.f488Lt = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    /* renamed from: android.support.v4.f.h$e */
    final class C0413e implements Collection<V> {
        C0413e() {
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            C0414h.this.mo734ej();
        }

        public final boolean contains(Object obj) {
            return C0414h.this.mo728F(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return C0414h.this.mo732eh() == 0;
        }

        public final Iterator<V> iterator() {
            return new C0409a(1);
        }

        public final boolean remove(Object obj) {
            int F = C0414h.this.mo728F(obj);
            if (F < 0) {
                return false;
            }
            C0414h.this.mo730aC(F);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int eh = C0414h.this.mo732eh();
            int i = 0;
            boolean z = false;
            while (i < eh) {
                if (collection.contains(C0414h.this.mo735v(i, 1))) {
                    C0414h.this.mo730aC(i);
                    i--;
                    eh--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int eh = C0414h.this.mo732eh();
            int i = 0;
            boolean z = false;
            while (i < eh) {
                if (!collection.contains(C0414h.this.mo735v(i, 1))) {
                    C0414h.this.mo730aC(i);
                    i--;
                    eh--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return C0414h.this.mo732eh();
        }

        public final Object[] toArray() {
            return C0414h.this.mo822aG(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return C0414h.this.mo823c(tArr, 1);
        }
    }

    /* renamed from: E */
    public abstract int mo727E(Object obj);

    /* renamed from: F */
    public abstract int mo728F(Object obj);

    /* renamed from: a */
    public abstract V mo729a(int i, V v);

    /* renamed from: aC */
    public abstract void mo730aC(int i);

    /* renamed from: d */
    public abstract void mo731d(K k, V v);

    /* renamed from: eh */
    public abstract int mo732eh();

    /* renamed from: ei */
    public abstract Map<K, V> mo733ei();

    /* renamed from: ej */
    public abstract void mo734ej();

    /* renamed from: v */
    public abstract Object mo735v(int i, int i2);

    C0414h() {
    }

    /* renamed from: a */
    public static <K, V> boolean m696a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: aG */
    public final Object[] mo822aG(int i) {
        int eh = mo732eh();
        Object[] objArr = new Object[eh];
        for (int i2 = 0; i2 < eh; i2++) {
            objArr[i2] = mo735v(i2, i);
        }
        return objArr;
    }

    /* renamed from: c */
    public final <T> T[] mo823c(T[] tArr, int i) {
        T[] tArr2;
        int eh = mo732eh();
        if (tArr.length < eh) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), eh);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < eh; i2++) {
            tArr2[i2] = mo735v(i2, i);
        }
        if (tArr2.length > eh) {
            tArr2[eh] = null;
        }
        return tArr2;
    }

    /* renamed from: a */
    public static <T> boolean m697a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size() && set.containsAll(set2)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public final Set<K> getKeySet() {
        if (this.f491Ln == null) {
            this.f491Ln = new C0411c();
        }
        return this.f491Ln;
    }
}
