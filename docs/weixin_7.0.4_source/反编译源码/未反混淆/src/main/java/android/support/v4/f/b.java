package android.support.v4.f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] KW = new int[0];
    private static final Object[] KX = new Object[0];
    private static Object[] KY;
    private static int KZ;
    private static Object[] La;
    private static int Lb;
    private h<E, E> KU;
    private int[] Lc;
    public Object[] Ld;
    private int mSize;

    private int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int a = c.a(this.Lc, i2, i);
        if (a < 0 || obj.equals(this.Ld[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.Lc[i3] == i) {
            if (obj.equals(this.Ld[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.Lc[a] == i) {
            if (obj.equals(this.Ld[a])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private int ek() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int a = c.a(this.Lc, i, 0);
        if (a < 0 || this.Ld[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.Lc[i2] == 0) {
            if (this.Ld[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.Lc[a] == 0) {
            if (this.Ld[a] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void aD(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (b.class) {
                if (La != null) {
                    objArr = La;
                    this.Ld = objArr;
                    La = (Object[]) objArr[0];
                    this.Lc = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    Lb--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (b.class) {
                if (KY != null) {
                    objArr = KY;
                    this.Ld = objArr;
                    KY = (Object[]) objArr[0];
                    this.Lc = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    KZ--;
                    return;
                }
            }
        }
        this.Lc = new int[i];
        this.Ld = new Object[i];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (Lb < 10) {
                    objArr[0] = La;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    La = objArr;
                    Lb++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (KZ < 10) {
                    objArr[0] = KY;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    KY = objArr;
                    KZ++;
                }
            }
        }
    }

    public b() {
        this(0);
    }

    public b(int i) {
        if (i == 0) {
            this.Lc = KW;
            this.Ld = KX;
        } else {
            aD(i);
        }
        this.mSize = 0;
    }

    public final void clear() {
        if (this.mSize != 0) {
            a(this.Lc, this.Ld, this.mSize);
            this.Lc = KW;
            this.Ld = KX;
            this.mSize = 0;
        }
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final int indexOf(Object obj) {
        return obj == null ? ek() : indexOf(obj, obj.hashCode());
    }

    public final boolean isEmpty() {
        return this.mSize <= 0;
    }

    public final boolean add(E e) {
        int ek;
        int i;
        int i2 = 8;
        if (e == null) {
            ek = ek();
            i = 0;
        } else {
            i = e.hashCode();
            ek = indexOf(e, i);
        }
        if (ek >= 0) {
            return false;
        }
        ek ^= -1;
        if (this.mSize >= this.Lc.length) {
            if (this.mSize >= 8) {
                i2 = this.mSize + (this.mSize >> 1);
            } else if (this.mSize < 4) {
                i2 = 4;
            }
            int[] iArr = this.Lc;
            Object[] objArr = this.Ld;
            aD(i2);
            if (this.Lc.length > 0) {
                System.arraycopy(iArr, 0, this.Lc, 0, iArr.length);
                System.arraycopy(objArr, 0, this.Ld, 0, objArr.length);
            }
            a(iArr, objArr, this.mSize);
        }
        if (ek < this.mSize) {
            int[] iArr2 = this.Lc;
            System.arraycopy(iArr2, ek, iArr2, ek + 1, this.mSize - ek);
            Object[] objArr2 = this.Ld;
            System.arraycopy(objArr2, ek, objArr2, ek + 1, this.mSize - ek);
        }
        this.Lc[ek] = i;
        this.Ld[ek] = e;
        this.mSize++;
        return true;
    }

    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final E removeAt(int i) {
        int i2 = 8;
        E e = this.Ld[i];
        if (this.mSize <= 1) {
            a(this.Lc, this.Ld, this.mSize);
            this.Lc = KW;
            this.Ld = KX;
            this.mSize = 0;
        } else if (this.Lc.length <= 8 || this.mSize >= this.Lc.length / 3) {
            this.mSize--;
            if (i < this.mSize) {
                System.arraycopy(this.Lc, i + 1, this.Lc, i, this.mSize - i);
                System.arraycopy(this.Ld, i + 1, this.Ld, i, this.mSize - i);
            }
            this.Ld[this.mSize] = null;
        } else {
            if (this.mSize > 8) {
                i2 = this.mSize + (this.mSize >> 1);
            }
            int[] iArr = this.Lc;
            Object[] objArr = this.Ld;
            aD(i2);
            this.mSize--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.Lc, 0, i);
                System.arraycopy(objArr, 0, this.Ld, 0, i);
            }
            if (i < this.mSize) {
                System.arraycopy(iArr, i + 1, this.Lc, i, this.mSize - i);
                System.arraycopy(objArr, i + 1, this.Ld, i, this.mSize - i);
            }
        }
        return e;
    }

    public final int size() {
        return this.mSize;
    }

    public final Object[] toArray() {
        Object[] objArr = new Object[this.mSize];
        System.arraycopy(this.Ld, 0, objArr, 0, this.mSize);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        Object obj;
        if (tArr.length < this.mSize) {
            obj = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize);
        } else {
            obj = tArr;
        }
        System.arraycopy(this.Ld, 0, obj, 0, this.mSize);
        if (obj.length > this.mSize) {
            obj[this.mSize] = null;
        }
        return obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.mSize) {
            try {
                if (!set.contains(this.Ld[i])) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int[] iArr = this.Lc;
        int i = 0;
        int i2 = 0;
        while (i < this.mSize) {
            i++;
            i2 = iArr[i] + i2;
        }
        return i2;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            b bVar = this.Ld[i];
            if (bVar != this) {
                stringBuilder.append(bVar);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        int i = 0;
        int size = this.mSize + collection.size();
        if (this.Lc.length < size) {
            int[] iArr = this.Lc;
            Object[] objArr = this.Ld;
            aD(size);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.Lc, 0, this.mSize);
                System.arraycopy(objArr, 0, this.Ld, 0, this.mSize);
            }
            a(iArr, objArr, this.mSize);
        }
        for (Object add : collection) {
            i |= add(add);
        }
        return i;
    }

    public final boolean removeAll(Collection<?> collection) {
        int i = 0;
        for (Object remove : collection) {
            i |= remove(remove);
        }
        return i;
    }

    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.mSize - 1; i >= 0; i--) {
            if (!collection.contains(this.Ld[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    public final Iterator<E> iterator() {
        if (this.KU == null) {
            this.KU = new h<E, E>() {
                /* Access modifiers changed, original: protected|final */
                public final int eh() {
                    return b.this.mSize;
                }

                /* Access modifiers changed, original: protected|final */
                public final Object v(int i, int i2) {
                    return b.this.Ld[i];
                }

                /* Access modifiers changed, original: protected|final */
                public final int E(Object obj) {
                    return b.this.indexOf(obj);
                }

                /* Access modifiers changed, original: protected|final */
                public final int F(Object obj) {
                    return b.this.indexOf(obj);
                }

                /* Access modifiers changed, original: protected|final */
                public final Map<E, E> ei() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* Access modifiers changed, original: protected|final */
                public final void d(E e, E e2) {
                    b.this.add(e);
                }

                /* Access modifiers changed, original: protected|final */
                public final E a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* Access modifiers changed, original: protected|final */
                public final void aC(int i) {
                    b.this.removeAt(i);
                }

                /* Access modifiers changed, original: protected|final */
                public final void ej() {
                    b.this.clear();
                }
            };
        }
        return this.KU.getKeySet().iterator();
    }
}
