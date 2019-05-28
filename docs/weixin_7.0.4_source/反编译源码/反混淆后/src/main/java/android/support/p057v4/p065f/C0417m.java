package android.support.p057v4.p065f;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: android.support.v4.f.m */
public class C0417m<K, V> {
    /* renamed from: Lu */
    static Object[] f493Lu;
    /* renamed from: Lv */
    static int f494Lv;
    /* renamed from: Lw */
    static Object[] f495Lw;
    /* renamed from: Lx */
    static int f496Lx;
    /* renamed from: Lc */
    int[] f497Lc;
    /* renamed from: Ld */
    Object[] f498Ld;
    int mSize;

    /* renamed from: b */
    private static int m712b(int[] iArr, int i, int i2) {
        try {
            return C0404c.m688a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConcurrentModificationException();
        }
    }

    private int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int b = C0417m.m712b(this.f497Lc, i2, i);
        if (b < 0 || obj.equals(this.f498Ld[b << 1])) {
            return b;
        }
        int i3 = b + 1;
        while (i3 < i2 && this.f497Lc[i3] == i) {
            if (obj.equals(this.f498Ld[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        b--;
        while (b >= 0 && this.f497Lc[b] == i) {
            if (obj.equals(this.f498Ld[b << 1])) {
                return b;
            }
            b--;
        }
        return i3 ^ -1;
    }

    /* renamed from: ek */
    private int m713ek() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int b = C0417m.m712b(this.f497Lc, i, 0);
        if (b < 0 || this.f498Ld[b << 1] == null) {
            return b;
        }
        int i2 = b + 1;
        while (i2 < i && this.f497Lc[i2] == 0) {
            if (this.f498Ld[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        b--;
        while (b >= 0 && this.f497Lc[b] == 0) {
            if (this.f498Ld[b << 1] == null) {
                return b;
            }
            b--;
        }
        return i2 ^ -1;
    }

    /* renamed from: aD */
    private void m711aD(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C6197a.class) {
                if (f495Lw != null) {
                    objArr = f495Lw;
                    this.f498Ld = objArr;
                    f495Lw = (Object[]) objArr[0];
                    this.f497Lc = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f496Lx--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C6197a.class) {
                if (f493Lu != null) {
                    objArr = f493Lu;
                    this.f498Ld = objArr;
                    f493Lu = (Object[]) objArr[0];
                    this.f497Lc = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f494Lv--;
                    return;
                }
            }
        }
        this.f497Lc = new int[i];
        this.f498Ld = new Object[(i << 1)];
    }

    /* renamed from: a */
    private static void m710a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C6197a.class) {
                if (f496Lx < 10) {
                    objArr[0] = f495Lw;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f495Lw = objArr;
                    f496Lx++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C6197a.class) {
                if (f494Lv < 10) {
                    objArr[0] = f493Lu;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f493Lu = objArr;
                    f494Lv++;
                }
            }
        }
    }

    public C0417m() {
        this.f497Lc = C0404c.f474Lf;
        this.f498Ld = C0404c.f476Lh;
        this.mSize = 0;
    }

    public C0417m(int i) {
        if (i == 0) {
            this.f497Lc = C0404c.f474Lf;
            this.f498Ld = C0404c.f476Lh;
        } else {
            m711aD(i);
        }
        this.mSize = 0;
    }

    public C0417m(C0417m<K, V> c0417m) {
        this();
        if (c0417m != null) {
            mo828a(c0417m);
        }
    }

    public void clear() {
        if (this.mSize > 0) {
            int[] iArr = this.f497Lc;
            Object[] objArr = this.f498Ld;
            int i = this.mSize;
            this.f497Lc = C0404c.f474Lf;
            this.f498Ld = C0404c.f476Lh;
            this.mSize = 0;
            C0417m.m710a(iArr, objArr, i);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final void ensureCapacity(int i) {
        int i2 = this.mSize;
        if (this.f497Lc.length < i) {
            int[] iArr = this.f497Lc;
            Object[] objArr = this.f498Ld;
            m711aD(i);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.f497Lc, 0, i2);
                System.arraycopy(objArr, 0, this.f498Ld, 0, i2 << 1);
            }
            C0417m.m710a(iArr, objArr, i2);
        }
        if (this.mSize != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? m713ek() : indexOf(obj, obj.hashCode());
    }

    /* Access modifiers changed, original: final */
    public final int indexOfValue(Object obj) {
        int i = 1;
        int i2 = this.mSize * 2;
        Object[] objArr = this.f498Ld;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? this.f498Ld[(indexOfKey << 1) + 1] : null;
    }

    public final K keyAt(int i) {
        return this.f498Ld[i << 1];
    }

    public final V valueAt(int i) {
        return this.f498Ld[(i << 1) + 1];
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f498Ld[i2];
        this.f498Ld[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public V put(K k, V v) {
        int ek;
        int i;
        int i2 = 8;
        int i3 = this.mSize;
        if (k == null) {
            ek = m713ek();
            i = 0;
        } else {
            i = k.hashCode();
            ek = indexOf(k, i);
        }
        if (ek >= 0) {
            int i4 = (ek << 1) + 1;
            V v2 = this.f498Ld[i4];
            this.f498Ld[i4] = v;
            return v2;
        }
        ek ^= -1;
        if (i3 >= this.f497Lc.length) {
            if (i3 >= 8) {
                i2 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i2 = 4;
            }
            int[] iArr = this.f497Lc;
            Object[] objArr = this.f498Ld;
            m711aD(i2);
            if (i3 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            if (this.f497Lc.length > 0) {
                System.arraycopy(iArr, 0, this.f497Lc, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f498Ld, 0, objArr.length);
            }
            C0417m.m710a(iArr, objArr, i3);
        }
        if (ek < i3) {
            int[] iArr2 = this.f497Lc;
            System.arraycopy(iArr2, ek, iArr2, ek + 1, i3 - ek);
            System.arraycopy(this.f498Ld, ek << 1, this.f498Ld, (ek + 1) << 1, (this.mSize - ek) << 1);
        }
        if (i3 != this.mSize || ek >= this.f497Lc.length) {
            throw new ConcurrentModificationException();
        }
        this.f497Lc[ek] = i;
        this.f498Ld[ek << 1] = k;
        this.f498Ld[(ek << 1) + 1] = v;
        this.mSize++;
        return null;
    }

    /* renamed from: a */
    public void mo828a(C0417m<? extends K, ? extends V> c0417m) {
        int i = 0;
        int i2 = c0417m.mSize;
        ensureCapacity(this.mSize + i2);
        if (this.mSize != 0) {
            while (i < i2) {
                put(c0417m.keyAt(i), c0417m.valueAt(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(c0417m.f497Lc, 0, this.f497Lc, 0, i2);
            System.arraycopy(c0417m.f498Ld, 0, this.f498Ld, 0, i2 << 1);
            this.mSize = i2;
        }
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i) {
        int i2 = 8;
        V v = this.f498Ld[(i << 1) + 1];
        int i3 = this.mSize;
        if (i3 <= 1) {
            C0417m.m710a(this.f497Lc, this.f498Ld, i3);
            this.f497Lc = C0404c.f474Lf;
            this.f498Ld = C0404c.f476Lh;
            i2 = 0;
        } else {
            int i4 = i3 - 1;
            if (this.f497Lc.length <= 8 || this.mSize >= this.f497Lc.length / 3) {
                if (i < i4) {
                    System.arraycopy(this.f497Lc, i + 1, this.f497Lc, i, i4 - i);
                    System.arraycopy(this.f498Ld, (i + 1) << 1, this.f498Ld, i << 1, (i4 - i) << 1);
                }
                this.f498Ld[i4 << 1] = null;
                this.f498Ld[(i4 << 1) + 1] = null;
                i2 = i4;
            } else {
                if (i3 > 8) {
                    i2 = (i3 >> 1) + i3;
                }
                int[] iArr = this.f497Lc;
                Object[] objArr = this.f498Ld;
                m711aD(i2);
                if (i3 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f497Lc, 0, i);
                    System.arraycopy(objArr, 0, this.f498Ld, 0, i << 1);
                }
                if (i < i4) {
                    System.arraycopy(iArr, i + 1, this.f497Lc, i, i4 - i);
                    System.arraycopy(objArr, (i + 1) << 1, this.f498Ld, i << 1, (i4 - i) << 1);
                }
                i2 = i4;
            }
        }
        if (i3 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = i2;
        return v;
    }

    public int size() {
        return this.mSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        int i;
        Object keyAt;
        Object valueAt;
        Object obj2;
        if (obj instanceof C0417m) {
            C0417m c0417m = (C0417m) obj;
            if (size() != c0417m.size()) {
                return false;
            }
            i = 0;
            while (i < this.mSize) {
                try {
                    keyAt = keyAt(i);
                    valueAt = valueAt(i);
                    obj2 = c0417m.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !c0417m.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
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
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            i = 0;
            while (i < this.mSize) {
                try {
                    keyAt = keyAt(i);
                    valueAt = valueAt(i);
                    obj2 = map.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !map.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (NullPointerException e3) {
                    return false;
                } catch (ClassCastException e4) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] iArr = this.f497Lc;
        Object[] objArr = this.f498Ld;
        int i = this.mSize;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0417m keyAt = keyAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            keyAt = valueAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
