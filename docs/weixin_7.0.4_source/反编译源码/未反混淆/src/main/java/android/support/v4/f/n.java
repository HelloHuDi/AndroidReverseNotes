package android.support.v4.f;

public final class n<E> implements Cloneable {
    private static final Object Li = new Object();
    public boolean Lj;
    private Object[] Ll;
    public int[] Ly;
    public int mSize;

    public final /* synthetic */ Object clone() {
        return em();
    }

    public n() {
        this(10);
    }

    public n(int i) {
        this.Lj = false;
        if (i == 0) {
            this.Ly = c.Lf;
            this.Ll = c.Lh;
        } else {
            int idealIntArraySize = c.idealIntArraySize(i);
            this.Ly = new int[idealIntArraySize];
            this.Ll = new Object[idealIntArraySize];
        }
        this.mSize = 0;
    }

    private n<E> em() {
        try {
            n<E> nVar = (n) super.clone();
            try {
                nVar.Ly = (int[]) this.Ly.clone();
                nVar.Ll = (Object[]) this.Ll.clone();
                return nVar;
            } catch (CloneNotSupportedException e) {
                return nVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public final E aH(int i) {
        int a = c.a(this.Ly, this.mSize, i);
        if (a < 0 || this.Ll[a] == Li) {
            return null;
        }
        return this.Ll[a];
    }

    public final void delete(int i) {
        int a = c.a(this.Ly, this.mSize, i);
        if (a >= 0 && this.Ll[a] != Li) {
            this.Ll[a] = Li;
            this.Lj = true;
        }
    }

    public final void gc() {
        int i = this.mSize;
        int[] iArr = this.Ly;
        Object[] objArr = this.Ll;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != Li) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.Lj = false;
        this.mSize = i2;
    }

    public final void put(int i, E e) {
        int a = c.a(this.Ly, this.mSize, i);
        if (a >= 0) {
            this.Ll[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.mSize || this.Ll[a] != Li) {
            Object[] objArr;
            if (this.Lj && this.mSize >= this.Ly.length) {
                gc();
                a = c.a(this.Ly, this.mSize, i) ^ -1;
            }
            if (this.mSize >= this.Ly.length) {
                int idealIntArraySize = c.idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                objArr = new Object[idealIntArraySize];
                System.arraycopy(this.Ly, 0, iArr, 0, this.Ly.length);
                System.arraycopy(this.Ll, 0, objArr, 0, this.Ll.length);
                this.Ly = iArr;
                this.Ll = objArr;
            }
            if (this.mSize - a != 0) {
                int[] iArr2 = this.Ly;
                System.arraycopy(iArr2, a, iArr2, a + 1, this.mSize - a);
                objArr = this.Ll;
                System.arraycopy(objArr, a, objArr, a + 1, this.mSize - a);
            }
            this.Ly[a] = i;
            this.Ll[a] = e;
            this.mSize++;
            return;
        }
        this.Ly[a] = i;
        this.Ll[a] = e;
    }

    public final int size() {
        if (this.Lj) {
            gc();
        }
        return this.mSize;
    }

    public final int keyAt(int i) {
        if (this.Lj) {
            gc();
        }
        return this.Ly[i];
    }

    public final E valueAt(int i) {
        if (this.Lj) {
            gc();
        }
        return this.Ll[i];
    }

    public final int indexOfValue(E e) {
        if (this.Lj) {
            gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.Ll[i] == e) {
                return i;
            }
        }
        return -1;
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

    public final void append(int i, E e) {
        if (this.mSize == 0 || i > this.Ly[this.mSize - 1]) {
            if (this.Lj && this.mSize >= this.Ly.length) {
                gc();
            }
            int i2 = this.mSize;
            if (i2 >= this.Ly.length) {
                int idealIntArraySize = c.idealIntArraySize(i2 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                System.arraycopy(this.Ly, 0, iArr, 0, this.Ly.length);
                System.arraycopy(this.Ll, 0, objArr, 0, this.Ll.length);
                this.Ly = iArr;
                this.Ll = objArr;
            }
            this.Ly[i2] = i;
            this.Ll[i2] = e;
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
            n valueAt = valueAt(i);
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
