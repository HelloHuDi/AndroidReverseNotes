package android.support.p057v4.p065f;

/* renamed from: android.support.v4.f.n */
public final class C0418n<E> implements Cloneable {
    /* renamed from: Li */
    private static final Object f499Li = new Object();
    /* renamed from: Lj */
    public boolean f500Lj;
    /* renamed from: Ll */
    private Object[] f501Ll;
    /* renamed from: Ly */
    public int[] f502Ly;
    public int mSize;

    public final /* synthetic */ Object clone() {
        return m715em();
    }

    public C0418n() {
        this(10);
    }

    public C0418n(int i) {
        this.f500Lj = false;
        if (i == 0) {
            this.f502Ly = C0404c.f474Lf;
            this.f501Ll = C0404c.f476Lh;
        } else {
            int idealIntArraySize = C0404c.idealIntArraySize(i);
            this.f502Ly = new int[idealIntArraySize];
            this.f501Ll = new Object[idealIntArraySize];
        }
        this.mSize = 0;
    }

    /* renamed from: em */
    private C0418n<E> m715em() {
        try {
            C0418n<E> c0418n = (C0418n) super.clone();
            try {
                c0418n.f502Ly = (int[]) this.f502Ly.clone();
                c0418n.f501Ll = (Object[]) this.f501Ll.clone();
                return c0418n;
            } catch (CloneNotSupportedException e) {
                return c0418n;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* renamed from: aH */
    public final E mo847aH(int i) {
        int a = C0404c.m688a(this.f502Ly, this.mSize, i);
        if (a < 0 || this.f501Ll[a] == f499Li) {
            return null;
        }
        return this.f501Ll[a];
    }

    public final void delete(int i) {
        int a = C0404c.m688a(this.f502Ly, this.mSize, i);
        if (a >= 0 && this.f501Ll[a] != f499Li) {
            this.f501Ll[a] = f499Li;
            this.f500Lj = true;
        }
    }

    /* renamed from: gc */
    public final void mo852gc() {
        int i = this.mSize;
        int[] iArr = this.f502Ly;
        Object[] objArr = this.f501Ll;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f499Li) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f500Lj = false;
        this.mSize = i2;
    }

    public final void put(int i, E e) {
        int a = C0404c.m688a(this.f502Ly, this.mSize, i);
        if (a >= 0) {
            this.f501Ll[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.mSize || this.f501Ll[a] != f499Li) {
            Object[] objArr;
            if (this.f500Lj && this.mSize >= this.f502Ly.length) {
                mo852gc();
                a = C0404c.m688a(this.f502Ly, this.mSize, i) ^ -1;
            }
            if (this.mSize >= this.f502Ly.length) {
                int idealIntArraySize = C0404c.idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                objArr = new Object[idealIntArraySize];
                System.arraycopy(this.f502Ly, 0, iArr, 0, this.f502Ly.length);
                System.arraycopy(this.f501Ll, 0, objArr, 0, this.f501Ll.length);
                this.f502Ly = iArr;
                this.f501Ll = objArr;
            }
            if (this.mSize - a != 0) {
                int[] iArr2 = this.f502Ly;
                System.arraycopy(iArr2, a, iArr2, a + 1, this.mSize - a);
                objArr = this.f501Ll;
                System.arraycopy(objArr, a, objArr, a + 1, this.mSize - a);
            }
            this.f502Ly[a] = i;
            this.f501Ll[a] = e;
            this.mSize++;
            return;
        }
        this.f502Ly[a] = i;
        this.f501Ll[a] = e;
    }

    public final int size() {
        if (this.f500Lj) {
            mo852gc();
        }
        return this.mSize;
    }

    public final int keyAt(int i) {
        if (this.f500Lj) {
            mo852gc();
        }
        return this.f502Ly[i];
    }

    public final E valueAt(int i) {
        if (this.f500Lj) {
            mo852gc();
        }
        return this.f501Ll[i];
    }

    public final int indexOfValue(E e) {
        if (this.f500Lj) {
            mo852gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.f501Ll[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public final void clear() {
        int i = this.mSize;
        Object[] objArr = this.f501Ll;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.f500Lj = false;
    }

    public final void append(int i, E e) {
        if (this.mSize == 0 || i > this.f502Ly[this.mSize - 1]) {
            if (this.f500Lj && this.mSize >= this.f502Ly.length) {
                mo852gc();
            }
            int i2 = this.mSize;
            if (i2 >= this.f502Ly.length) {
                int idealIntArraySize = C0404c.idealIntArraySize(i2 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                System.arraycopy(this.f502Ly, 0, iArr, 0, this.f502Ly.length);
                System.arraycopy(this.f501Ll, 0, objArr, 0, this.f501Ll.length);
                this.f502Ly = iArr;
                this.f501Ll = objArr;
            }
            this.f502Ly[i2] = i;
            this.f501Ll[i2] = e;
            this.mSize = i2 + 1;
            return;
        }
        put(i, e);
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            C0418n valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
