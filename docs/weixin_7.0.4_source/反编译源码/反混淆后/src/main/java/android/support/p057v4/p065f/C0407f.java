package android.support.p057v4.p065f;

/* renamed from: android.support.v4.f.f */
public final class C0407f<E> implements Cloneable {
    /* renamed from: Li */
    public static final Object f477Li = new Object();
    /* renamed from: Lj */
    public boolean f478Lj;
    /* renamed from: Lk */
    public long[] f479Lk;
    /* renamed from: Ll */
    public Object[] f480Ll;
    public int mSize;

    public final /* synthetic */ Object clone() {
        return m693el();
    }

    public C0407f() {
        this((byte) 0);
    }

    private C0407f(byte b) {
        this.f478Lj = false;
        int aE = C0404c.m690aE(10);
        this.f479Lk = new long[aE];
        this.f480Ll = new Object[aE];
        this.mSize = 0;
    }

    /* renamed from: el */
    private C0407f<E> m693el() {
        try {
            C0407f<E> c0407f = (C0407f) super.clone();
            try {
                c0407f.f479Lk = (long[]) this.f479Lk.clone();
                c0407f.f480Ll = (Object[]) this.f480Ll.clone();
                return c0407f;
            } catch (CloneNotSupportedException e) {
                return c0407f;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* renamed from: k */
    public final E mo742k(long j) {
        int a = C0404c.m689a(this.f479Lk, this.mSize, j);
        if (a < 0 || this.f480Ll[a] == f477Li) {
            return null;
        }
        return this.f480Ll[a];
    }

    public final void removeAt(int i) {
        if (this.f480Ll[i] != f477Li) {
            this.f480Ll[i] = f477Li;
            this.f478Lj = true;
        }
    }

    /* renamed from: gc */
    private void m694gc() {
        int i = this.mSize;
        long[] jArr = this.f479Lk;
        Object[] objArr = this.f480Ll;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f477Li) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f478Lj = false;
        this.mSize = i2;
    }

    public final void put(long j, E e) {
        int a = C0404c.m689a(this.f479Lk, this.mSize, j);
        if (a >= 0) {
            this.f480Ll[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.mSize || this.f480Ll[a] != f477Li) {
            Object[] objArr;
            if (this.f478Lj && this.mSize >= this.f479Lk.length) {
                m694gc();
                a = C0404c.m689a(this.f479Lk, this.mSize, j) ^ -1;
            }
            if (this.mSize >= this.f479Lk.length) {
                int aE = C0404c.m690aE(this.mSize + 1);
                long[] jArr = new long[aE];
                objArr = new Object[aE];
                System.arraycopy(this.f479Lk, 0, jArr, 0, this.f479Lk.length);
                System.arraycopy(this.f480Ll, 0, objArr, 0, this.f480Ll.length);
                this.f479Lk = jArr;
                this.f480Ll = objArr;
            }
            if (this.mSize - a != 0) {
                long[] jArr2 = this.f479Lk;
                System.arraycopy(jArr2, a, jArr2, a + 1, this.mSize - a);
                objArr = this.f480Ll;
                System.arraycopy(objArr, a, objArr, a + 1, this.mSize - a);
            }
            this.f479Lk[a] = j;
            this.f480Ll[a] = e;
            this.mSize++;
            return;
        }
        this.f479Lk[a] = j;
        this.f480Ll[a] = e;
    }

    public final int size() {
        if (this.f478Lj) {
            m694gc();
        }
        return this.mSize;
    }

    public final long keyAt(int i) {
        if (this.f478Lj) {
            m694gc();
        }
        return this.f479Lk[i];
    }

    public final E valueAt(int i) {
        if (this.f478Lj) {
            m694gc();
        }
        return this.f480Ll[i];
    }

    public final int indexOfKey(long j) {
        if (this.f478Lj) {
            m694gc();
        }
        return C0404c.m689a(this.f479Lk, this.mSize, j);
    }

    public final void clear() {
        int i = this.mSize;
        Object[] objArr = this.f480Ll;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.f478Lj = false;
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
            C0407f valueAt = valueAt(i);
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
