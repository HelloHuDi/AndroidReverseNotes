package android.support.v4.f;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class m<K, V> {
    static Object[] Lu;
    static int Lv;
    static Object[] Lw;
    static int Lx;
    int[] Lc;
    Object[] Ld;
    int mSize;

    private static int b(int[] iArr, int i, int i2) {
        try {
            return c.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ConcurrentModificationException();
        }
    }

    private int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int b = b(this.Lc, i2, i);
        if (b < 0 || obj.equals(this.Ld[b << 1])) {
            return b;
        }
        int i3 = b + 1;
        while (i3 < i2 && this.Lc[i3] == i) {
            if (obj.equals(this.Ld[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        b--;
        while (b >= 0 && this.Lc[b] == i) {
            if (obj.equals(this.Ld[b << 1])) {
                return b;
            }
            b--;
        }
        return i3 ^ -1;
    }

    private int ek() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int b = b(this.Lc, i, 0);
        if (b < 0 || this.Ld[b << 1] == null) {
            return b;
        }
        int i2 = b + 1;
        while (i2 < i && this.Lc[i2] == 0) {
            if (this.Ld[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        b--;
        while (b >= 0 && this.Lc[b] == 0) {
            if (this.Ld[b << 1] == null) {
                return b;
            }
            b--;
        }
        return i2 ^ -1;
    }

    private void aD(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (a.class) {
                if (Lw != null) {
                    objArr = Lw;
                    this.Ld = objArr;
                    Lw = (Object[]) objArr[0];
                    this.Lc = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    Lx--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (Lu != null) {
                    objArr = Lu;
                    this.Ld = objArr;
                    Lu = (Object[]) objArr[0];
                    this.Lc = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    Lv--;
                    return;
                }
            }
        }
        this.Lc = new int[i];
        this.Ld = new Object[(i << 1)];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (Lx < 10) {
                    objArr[0] = Lw;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    Lw = objArr;
                    Lx++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (Lv < 10) {
                    objArr[0] = Lu;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    Lu = objArr;
                    Lv++;
                }
            }
        }
    }

    public m() {
        this.Lc = c.Lf;
        this.Ld = c.Lh;
        this.mSize = 0;
    }

    public m(int i) {
        if (i == 0) {
            this.Lc = c.Lf;
            this.Ld = c.Lh;
        } else {
            aD(i);
        }
        this.mSize = 0;
    }

    public m(m<K, V> mVar) {
        this();
        if (mVar != null) {
            a(mVar);
        }
    }

    public void clear() {
        if (this.mSize > 0) {
            int[] iArr = this.Lc;
            Object[] objArr = this.Ld;
            int i = this.mSize;
            this.Lc = c.Lf;
            this.Ld = c.Lh;
            this.mSize = 0;
            a(iArr, objArr, i);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final void ensureCapacity(int i) {
        int i2 = this.mSize;
        if (this.Lc.length < i) {
            int[] iArr = this.Lc;
            Object[] objArr = this.Ld;
            aD(i);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.Lc, 0, i2);
                System.arraycopy(objArr, 0, this.Ld, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.mSize != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? ek() : indexOf(obj, obj.hashCode());
    }

    /* Access modifiers changed, original: final */
    public final int indexOfValue(Object obj) {
        int i = 1;
        int i2 = this.mSize * 2;
        Object[] objArr = this.Ld;
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
        return indexOfKey >= 0 ? this.Ld[(indexOfKey << 1) + 1] : null;
    }

    public final K keyAt(int i) {
        return this.Ld[i << 1];
    }

    public final V valueAt(int i) {
        return this.Ld[(i << 1) + 1];
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.Ld[i2];
        this.Ld[i2] = v;
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
            ek = ek();
            i = 0;
        } else {
            i = k.hashCode();
            ek = indexOf(k, i);
        }
        if (ek >= 0) {
            int i4 = (ek << 1) + 1;
            V v2 = this.Ld[i4];
            this.Ld[i4] = v;
            return v2;
        }
        ek ^= -1;
        if (i3 >= this.Lc.length) {
            if (i3 >= 8) {
                i2 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i2 = 4;
            }
            int[] iArr = this.Lc;
            Object[] objArr = this.Ld;
            aD(i2);
            if (i3 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            if (this.Lc.length > 0) {
                System.arraycopy(iArr, 0, this.Lc, 0, iArr.length);
                System.arraycopy(objArr, 0, this.Ld, 0, objArr.length);
            }
            a(iArr, objArr, i3);
        }
        if (ek < i3) {
            int[] iArr2 = this.Lc;
            System.arraycopy(iArr2, ek, iArr2, ek + 1, i3 - ek);
            System.arraycopy(this.Ld, ek << 1, this.Ld, (ek + 1) << 1, (this.mSize - ek) << 1);
        }
        if (i3 != this.mSize || ek >= this.Lc.length) {
            throw new ConcurrentModificationException();
        }
        this.Lc[ek] = i;
        this.Ld[ek << 1] = k;
        this.Ld[(ek << 1) + 1] = v;
        this.mSize++;
        return null;
    }

    public void a(m<? extends K, ? extends V> mVar) {
        int i = 0;
        int i2 = mVar.mSize;
        ensureCapacity(this.mSize + i2);
        if (this.mSize != 0) {
            while (i < i2) {
                put(mVar.keyAt(i), mVar.valueAt(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(mVar.Lc, 0, this.Lc, 0, i2);
            System.arraycopy(mVar.Ld, 0, this.Ld, 0, i2 << 1);
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
        V v = this.Ld[(i << 1) + 1];
        int i3 = this.mSize;
        if (i3 <= 1) {
            a(this.Lc, this.Ld, i3);
            this.Lc = c.Lf;
            this.Ld = c.Lh;
            i2 = 0;
        } else {
            int i4 = i3 - 1;
            if (this.Lc.length <= 8 || this.mSize >= this.Lc.length / 3) {
                if (i < i4) {
                    System.arraycopy(this.Lc, i + 1, this.Lc, i, i4 - i);
                    System.arraycopy(this.Ld, (i + 1) << 1, this.Ld, i << 1, (i4 - i) << 1);
                }
                this.Ld[i4 << 1] = null;
                this.Ld[(i4 << 1) + 1] = null;
                i2 = i4;
            } else {
                if (i3 > 8) {
                    i2 = (i3 >> 1) + i3;
                }
                int[] iArr = this.Lc;
                Object[] objArr = this.Ld;
                aD(i2);
                if (i3 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.Lc, 0, i);
                    System.arraycopy(objArr, 0, this.Ld, 0, i << 1);
                }
                if (i < i4) {
                    System.arraycopy(iArr, i + 1, this.Lc, i, i4 - i);
                    System.arraycopy(objArr, (i + 1) << 1, this.Ld, i << 1, (i4 - i) << 1);
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
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (size() != mVar.size()) {
                return false;
            }
            i = 0;
            while (i < this.mSize) {
                try {
                    keyAt = keyAt(i);
                    valueAt = valueAt(i);
                    obj2 = mVar.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !mVar.containsKey(keyAt)) {
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
        int[] iArr = this.Lc;
        Object[] objArr = this.Ld;
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
            m keyAt = keyAt(i);
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
