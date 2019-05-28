package android.support.v4.f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class h<K, V> {
    b Lm;
    c Ln;
    e Lo;

    final class a<T> implements Iterator<T> {
        final int Lp;
        boolean Lq = false;
        int mIndex;
        int mSize;

        a(int i) {
            this.Lp = i;
            this.mSize = h.this.eh();
        }

        public final boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        public final T next() {
            if (hasNext()) {
                Object v = h.this.v(this.mIndex, this.Lp);
                this.mIndex++;
                this.Lq = true;
                return v;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            if (this.Lq) {
                this.mIndex--;
                this.mSize--;
                this.Lq = false;
                h.this.aC(this.mIndex);
                return;
            }
            throw new IllegalStateException();
        }
    }

    final class b implements Set<Entry<K, V>> {
        b() {
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int eh = h.this.eh();
            for (Entry entry : collection) {
                h.this.d(entry.getKey(), entry.getValue());
            }
            return eh != h.this.eh();
        }

        public final void clear() {
            h.this.ej();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int E = h.this.E(entry.getKey());
            if (E >= 0) {
                return c.equal(h.this.v(E, 1), entry.getValue());
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
            return h.this.eh() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d();
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
            return h.this.eh();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        public final int hashCode() {
            int eh = h.this.eh() - 1;
            int i = 0;
            while (eh >= 0) {
                int i2;
                Object v = h.this.v(eh, 0);
                Object v2 = h.this.v(eh, 1);
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

    final class c implements Set<K> {
        c() {
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            h.this.ej();
        }

        public final boolean contains(Object obj) {
            return h.this.E(obj) >= 0;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map ei = h.this.ei();
            for (Object containsKey : collection) {
                if (!ei.containsKey(containsKey)) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return h.this.eh() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(0);
        }

        public final boolean remove(Object obj) {
            int E = h.this.E(obj);
            if (E < 0) {
                return false;
            }
            h.this.aC(E);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map ei = h.this.ei();
            int size = ei.size();
            for (Object remove : collection) {
                ei.remove(remove);
            }
            return size != ei.size();
        }

        public final boolean retainAll(Collection<?> collection) {
            return h.a(h.this.ei(), (Collection) collection);
        }

        public final int size() {
            return h.this.eh();
        }

        public final Object[] toArray() {
            return h.this.aG(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return h.this.c(tArr, 0);
        }

        public final boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int eh = h.this.eh() - 1; eh >= 0; eh--) {
                Object v = h.this.v(eh, 0);
                i += v == null ? 0 : v.hashCode();
            }
            return i;
        }
    }

    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int Ls;
        boolean Lt = false;
        int mIndex;

        d() {
            this.Ls = h.this.eh() - 1;
            this.mIndex = -1;
        }

        public final boolean hasNext() {
            return this.mIndex < this.Ls;
        }

        public final void remove() {
            if (this.Lt) {
                h.this.aC(this.mIndex);
                this.mIndex--;
                this.Ls--;
                this.Lt = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.Lt) {
                return h.this.v(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.Lt) {
                return h.this.v(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.Lt) {
                return h.this.a(this.mIndex, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.Lt) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (c.equal(entry.getKey(), h.this.v(this.mIndex, 0)) && c.equal(entry.getValue(), h.this.v(this.mIndex, 1))) {
                    return true;
                }
                return false;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.Lt) {
                Object v = h.this.v(this.mIndex, 0);
                Object v2 = h.this.v(this.mIndex, 1);
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
                this.Lt = true;
                return this;
            }
            throw new NoSuchElementException();
        }
    }

    final class e implements Collection<V> {
        e() {
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            h.this.ej();
        }

        public final boolean contains(Object obj) {
            return h.this.F(obj) >= 0;
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
            return h.this.eh() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(1);
        }

        public final boolean remove(Object obj) {
            int F = h.this.F(obj);
            if (F < 0) {
                return false;
            }
            h.this.aC(F);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int eh = h.this.eh();
            int i = 0;
            boolean z = false;
            while (i < eh) {
                if (collection.contains(h.this.v(i, 1))) {
                    h.this.aC(i);
                    i--;
                    eh--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int eh = h.this.eh();
            int i = 0;
            boolean z = false;
            while (i < eh) {
                if (!collection.contains(h.this.v(i, 1))) {
                    h.this.aC(i);
                    i--;
                    eh--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return h.this.eh();
        }

        public final Object[] toArray() {
            return h.this.aG(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return h.this.c(tArr, 1);
        }
    }

    public abstract int E(Object obj);

    public abstract int F(Object obj);

    public abstract V a(int i, V v);

    public abstract void aC(int i);

    public abstract void d(K k, V v);

    public abstract int eh();

    public abstract Map<K, V> ei();

    public abstract void ej();

    public abstract Object v(int i, int i2);

    h() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] aG(int i) {
        int eh = eh();
        Object[] objArr = new Object[eh];
        for (int i2 = 0; i2 < eh; i2++) {
            objArr[i2] = v(i2, i);
        }
        return objArr;
    }

    public final <T> T[] c(T[] tArr, int i) {
        T[] tArr2;
        int eh = eh();
        if (tArr.length < eh) {
            tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), eh);
        } else {
            tArr2 = tArr;
        }
        for (int i2 = 0; i2 < eh; i2++) {
            tArr2[i2] = v(i2, i);
        }
        if (tArr2.length > eh) {
            tArr2[eh] = null;
        }
        return tArr2;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
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
        if (this.Ln == null) {
            this.Ln = new c();
        }
        return this.Ln;
    }
}
