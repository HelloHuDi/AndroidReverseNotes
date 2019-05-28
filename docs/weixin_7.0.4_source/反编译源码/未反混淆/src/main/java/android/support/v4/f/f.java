package android.support.v4.f;

public final class f<E> implements Cloneable {
    public static final Object Li = new Object();
    public boolean Lj;
    public long[] Lk;
    public Object[] Ll;
    public int mSize;

    public final /* synthetic */ Object clone() {
        return el();
    }

    public f() {
        this((byte) 0);
    }

    private f(byte b) {
        this.Lj = false;
        int aE = c.aE(10);
        this.Lk = new long[aE];
        this.Ll = new Object[aE];
        this.mSize = 0;
    }

    private f<E> el() {
        try {
            f<E> fVar = (f) super.clone();
            try {
                fVar.Lk = (long[]) this.Lk.clone();
                fVar.Ll = (Object[]) this.Ll.clone();
                return fVar;
            } catch (CloneNotSupportedException e) {
                return fVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E k(long j) {
        int a = c.a(this.Lk, this.mSize, j);
        if (a < 0 || this.Ll[a] == Li) {
            return null;
        }
        return this.Ll[a];
    }

    public final void removeAt(int i) {
        if (this.Ll[i] != Li) {
            this.Ll[i] = Li;
            this.Lj = true;
        }
    }

    private void gc() {
        int i = this.mSize;
        long[] jArr = this.Lk;
        Object[] objArr = this.Ll;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != Li) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.Lj = false;
        this.mSize = i2;
    }

    public final void put(long j, E e) {
        int a = c.a(this.Lk, this.mSize, j);
        if (a >= 0) {
            this.Ll[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.mSize || this.Ll[a] != Li) {
            Object[] objArr;
            if (this.Lj && this.mSize >= this.Lk.length) {
                gc();
                a = c.a(this.Lk, this.mSize, j) ^ -1;
            }
            if (this.mSize >= this.Lk.length) {
                int aE = c.aE(this.mSize + 1);
                long[] jArr = new long[aE];
                objArr = new Object[aE];
                System.arraycopy(this.Lk, 0, jArr, 0, this.Lk.length);
                System.arraycopy(this.Ll, 0, objArr, 0, this.Ll.length);
                this.Lk = jArr;
                this.Ll = objArr;
            }
            if (this.mSize - a != 0) {
                long[] jArr2 = this.Lk;
                System.arraycopy(jArr2, a, jArr2, a + 1, this.mSize - a);
                objArr = this.Ll;
                System.arraycopy(objArr, a, objArr, a + 1, this.mSize - a);
            }
            this.Lk[a] = j;
            this.Ll[a] = e;
            this.mSize++;
            return;
        }
        this.Lk[a] = j;
        this.Ll[a] = e;
    }

    public final int size() {
        if (this.Lj) {
            gc();
        }
        return this.mSize;
    }

    public final long keyAt(int i) {
        if (this.Lj) {
            gc();
        }
        return this.Lk[i];
    }

    public final E valueAt(int i) {
        if (this.Lj) {
            gc();
        }
        return this.Ll[i];
    }

    public final int indexOfKey(long j) {
        if (this.Lj) {
            gc();
        }
        return c.a(this.Lk, this.mSize, j);
    }

    public final void clear() {
        int i = this.mSize;
        Object[] objArr = this.Ll;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.Lj = false;
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
            f valueAt = valueAt(i);
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
