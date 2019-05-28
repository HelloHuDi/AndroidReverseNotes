package com.tencent.mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<E> {
    static final Object Li = new Object();
    boolean Lj;
    long[] Lk;
    Object[] Ll;
    int mSize;

    static {
        AppMethodBeat.i(51925);
        AppMethodBeat.o(51925);
    }

    public final void put(long j, E e) {
        AppMethodBeat.i(51924);
        int b = b(this.Lk, this.mSize, j);
        if (b >= 0) {
            this.Ll[b] = e;
            AppMethodBeat.o(51924);
            return;
        }
        b ^= -1;
        if (b >= this.mSize || this.Ll[b] != Li) {
            int i;
            Object[] objArr;
            if (this.Lj && this.mSize >= this.Lk.length) {
                int i2 = this.mSize;
                long[] jArr = this.Lk;
                Object[] objArr2 = this.Ll;
                b = 0;
                for (i = 0; i < i2; i++) {
                    Object obj = objArr2[i];
                    if (obj != Li) {
                        if (i != b) {
                            jArr[b] = jArr[i];
                            objArr2[b] = obj;
                        }
                        b++;
                    }
                }
                this.Lj = false;
                this.mSize = b;
                b = b(this.Lk, this.mSize, j) ^ -1;
            }
            if (this.mSize >= this.Lk.length) {
                i = a.idealIntArraySize(this.mSize + 1);
                long[] jArr2 = new long[i];
                objArr = new Object[i];
                System.arraycopy(this.Lk, 0, jArr2, 0, this.Lk.length);
                System.arraycopy(this.Ll, 0, objArr, 0, this.Ll.length);
                this.Lk = jArr2;
                this.Ll = objArr;
            }
            if (this.mSize - b != 0) {
                long[] jArr3 = this.Lk;
                System.arraycopy(jArr3, b, jArr3, b + 1, this.mSize - b);
                objArr = this.Ll;
                System.arraycopy(objArr, b, objArr, b + 1, this.mSize - b);
            }
            this.Lk[b] = j;
            this.Ll[b] = e;
            this.mSize++;
            AppMethodBeat.o(51924);
            return;
        }
        this.Lk[b] = j;
        this.Ll[b] = e;
        AppMethodBeat.o(51924);
    }

    static int b(long[] jArr, int i, long j) {
        int i2 = i + 0;
        int i3 = -1;
        while (i2 - i3 > 1) {
            int i4 = (i2 + i3) / 2;
            if (jArr[i4] < j) {
                i3 = i4;
            } else {
                i2 = i4;
            }
        }
        if (i2 == i + 0) {
            return (i + 0) ^ -1;
        }
        return jArr[i2] != j ? i2 ^ -1 : i2;
    }
}
