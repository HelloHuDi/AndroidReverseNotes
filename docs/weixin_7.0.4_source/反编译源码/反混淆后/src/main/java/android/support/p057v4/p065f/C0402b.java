package android.support.p057v4.p065f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.f.b */
public final class C0402b<E> implements Collection<E>, Set<E> {
    /* renamed from: KW */
    private static final int[] f464KW = new int[0];
    /* renamed from: KX */
    private static final Object[] f465KX = new Object[0];
    /* renamed from: KY */
    private static Object[] f466KY;
    /* renamed from: KZ */
    private static int f467KZ;
    /* renamed from: La */
    private static Object[] f468La;
    /* renamed from: Lb */
    private static int f469Lb;
    /* renamed from: KU */
    private C0414h<E, E> f470KU;
    /* renamed from: Lc */
    private int[] f471Lc;
    /* renamed from: Ld */
    public Object[] f472Ld;
    private int mSize;

    /* renamed from: android.support.v4.f.b$1 */
    class C04031 extends C0414h<E, E> {
        C04031() {
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: eh */
        public final int mo732eh() {
            return C0402b.this.mSize;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: v */
        public final Object mo735v(int i, int i2) {
            return C0402b.this.f472Ld[i];
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: E */
        public final int mo727E(Object obj) {
            return C0402b.this.indexOf(obj);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: F */
        public final int mo728F(Object obj) {
            return C0402b.this.indexOf(obj);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: ei */
        public final Map<E, E> mo733ei() {
            throw new UnsupportedOperationException("not a map");
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: d */
        public final void mo731d(E e, E e2) {
            C0402b.this.add(e);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: a */
        public final E mo729a(int i, E e) {
            throw new UnsupportedOperationException("not a map");
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: aC */
        public final void mo730aC(int i) {
            C0402b.this.removeAt(i);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: ej */
        public final void mo734ej() {
            C0402b.this.clear();
        }
    }

    private int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int a = C0404c.m688a(this.f471Lc, i2, i);
        if (a < 0 || obj.equals(this.f472Ld[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f471Lc[i3] == i) {
            if (obj.equals(this.f472Ld[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f471Lc[a] == i) {
            if (obj.equals(this.f472Ld[a])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    /* renamed from: ek */
    private int m678ek() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int a = C0404c.m688a(this.f471Lc, i, 0);
        if (a < 0 || this.f472Ld[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f471Lc[i2] == 0) {
            if (this.f472Ld[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f471Lc[a] == 0) {
            if (this.f472Ld[a] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    /* renamed from: aD */
    private void m676aD(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0402b.class) {
                if (f468La != null) {
                    objArr = f468La;
                    this.f472Ld = objArr;
                    f468La = (Object[]) objArr[0];
                    this.f471Lc = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f469Lb--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0402b.class) {
                if (f466KY != null) {
                    objArr = f466KY;
                    this.f472Ld = objArr;
                    f466KY = (Object[]) objArr[0];
                    this.f471Lc = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f467KZ--;
                    return;
                }
            }
        }
        this.f471Lc = new int[i];
        this.f472Ld = new Object[i];
    }

    /* renamed from: a */
    private static void m675a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0402b.class) {
                if (f469Lb < 10) {
                    objArr[0] = f468La;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f468La = objArr;
                    f469Lb++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0402b.class) {
                if (f467KZ < 10) {
                    objArr[0] = f466KY;
                    objArr[1] = iArr;
                    for (i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f466KY = objArr;
                    f467KZ++;
                }
            }
        }
    }

    public C0402b() {
        this(0);
    }

    public C0402b(int i) {
        if (i == 0) {
            this.f471Lc = f464KW;
            this.f472Ld = f465KX;
        } else {
            m676aD(i);
        }
        this.mSize = 0;
    }

    public final void clear() {
        if (this.mSize != 0) {
            C0402b.m675a(this.f471Lc, this.f472Ld, this.mSize);
            this.f471Lc = f464KW;
            this.f472Ld = f465KX;
            this.mSize = 0;
        }
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final int indexOf(Object obj) {
        return obj == null ? m678ek() : indexOf(obj, obj.hashCode());
    }

    public final boolean isEmpty() {
        return this.mSize <= 0;
    }

    public final boolean add(E e) {
        int ek;
        int i;
        int i2 = 8;
        if (e == null) {
            ek = m678ek();
            i = 0;
        } else {
            i = e.hashCode();
            ek = indexOf(e, i);
        }
        if (ek >= 0) {
            return false;
        }
        ek ^= -1;
        if (this.mSize >= this.f471Lc.length) {
            if (this.mSize >= 8) {
                i2 = this.mSize + (this.mSize >> 1);
            } else if (this.mSize < 4) {
                i2 = 4;
            }
            int[] iArr = this.f471Lc;
            Object[] objArr = this.f472Ld;
            m676aD(i2);
            if (this.f471Lc.length > 0) {
                System.arraycopy(iArr, 0, this.f471Lc, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f472Ld, 0, objArr.length);
            }
            C0402b.m675a(iArr, objArr, this.mSize);
        }
        if (ek < this.mSize) {
            int[] iArr2 = this.f471Lc;
            System.arraycopy(iArr2, ek, iArr2, ek + 1, this.mSize - ek);
            Object[] objArr2 = this.f472Ld;
            System.arraycopy(objArr2, ek, objArr2, ek + 1, this.mSize - ek);
        }
        this.f471Lc[ek] = i;
        this.f472Ld[ek] = e;
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
        E e = this.f472Ld[i];
        if (this.mSize <= 1) {
            C0402b.m675a(this.f471Lc, this.f472Ld, this.mSize);
            this.f471Lc = f464KW;
            this.f472Ld = f465KX;
            this.mSize = 0;
        } else if (this.f471Lc.length <= 8 || this.mSize >= this.f471Lc.length / 3) {
            this.mSize--;
            if (i < this.mSize) {
                System.arraycopy(this.f471Lc, i + 1, this.f471Lc, i, this.mSize - i);
                System.arraycopy(this.f472Ld, i + 1, this.f472Ld, i, this.mSize - i);
            }
            this.f472Ld[this.mSize] = null;
        } else {
            if (this.mSize > 8) {
                i2 = this.mSize + (this.mSize >> 1);
            }
            int[] iArr = this.f471Lc;
            Object[] objArr = this.f472Ld;
            m676aD(i2);
            this.mSize--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f471Lc, 0, i);
                System.arraycopy(objArr, 0, this.f472Ld, 0, i);
            }
            if (i < this.mSize) {
                System.arraycopy(iArr, i + 1, this.f471Lc, i, this.mSize - i);
                System.arraycopy(objArr, i + 1, this.f472Ld, i, this.mSize - i);
            }
        }
        return e;
    }

    public final int size() {
        return this.mSize;
    }

    public final Object[] toArray() {
        Object[] objArr = new Object[this.mSize];
        System.arraycopy(this.f472Ld, 0, objArr, 0, this.mSize);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        Object obj;
        if (tArr.length < this.mSize) {
            obj = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize);
        } else {
            obj = tArr;
        }
        System.arraycopy(this.f472Ld, 0, obj, 0, this.mSize);
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
                if (!set.contains(this.f472Ld[i])) {
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
        int[] iArr = this.f471Lc;
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
            C0402b c0402b = this.f472Ld[i];
            if (c0402b != this) {
                stringBuilder.append(c0402b);
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
        if (this.f471Lc.length < size) {
            int[] iArr = this.f471Lc;
            Object[] objArr = this.f472Ld;
            m676aD(size);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.f471Lc, 0, this.mSize);
                System.arraycopy(objArr, 0, this.f472Ld, 0, this.mSize);
            }
            C0402b.m675a(iArr, objArr, this.mSize);
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
            if (!collection.contains(this.f472Ld[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    public final Iterator<E> iterator() {
        if (this.f470KU == null) {
            this.f470KU = new C04031();
        }
        return this.f470KU.getKeySet().iterator();
    }
}
