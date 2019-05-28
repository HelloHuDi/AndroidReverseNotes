package com.tencent.p177mm.compatible.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.compatible.loader.b */
public final class C45292b<E> {
    /* renamed from: Li */
    static final Object f17874Li = new Object();
    /* renamed from: Lj */
    boolean f17875Lj;
    /* renamed from: Lk */
    long[] f17876Lk;
    /* renamed from: Ll */
    Object[] f17877Ll;
    int mSize;

    static {
        AppMethodBeat.m2504i(51925);
        AppMethodBeat.m2505o(51925);
    }

    public final void put(long j, E e) {
        AppMethodBeat.m2504i(51924);
        int b = C45292b.m83516b(this.f17876Lk, this.mSize, j);
        if (b >= 0) {
            this.f17877Ll[b] = e;
            AppMethodBeat.m2505o(51924);
            return;
        }
        b ^= -1;
        if (b >= this.mSize || this.f17877Ll[b] != f17874Li) {
            int i;
            Object[] objArr;
            if (this.f17875Lj && this.mSize >= this.f17876Lk.length) {
                int i2 = this.mSize;
                long[] jArr = this.f17876Lk;
                Object[] objArr2 = this.f17877Ll;
                b = 0;
                for (i = 0; i < i2; i++) {
                    Object obj = objArr2[i];
                    if (obj != f17874Li) {
                        if (i != b) {
                            jArr[b] = jArr[i];
                            objArr2[b] = obj;
                        }
                        b++;
                    }
                }
                this.f17875Lj = false;
                this.mSize = b;
                b = C45292b.m83516b(this.f17876Lk, this.mSize, j) ^ -1;
            }
            if (this.mSize >= this.f17876Lk.length) {
                i = C32473a.idealIntArraySize(this.mSize + 1);
                long[] jArr2 = new long[i];
                objArr = new Object[i];
                System.arraycopy(this.f17876Lk, 0, jArr2, 0, this.f17876Lk.length);
                System.arraycopy(this.f17877Ll, 0, objArr, 0, this.f17877Ll.length);
                this.f17876Lk = jArr2;
                this.f17877Ll = objArr;
            }
            if (this.mSize - b != 0) {
                long[] jArr3 = this.f17876Lk;
                System.arraycopy(jArr3, b, jArr3, b + 1, this.mSize - b);
                objArr = this.f17877Ll;
                System.arraycopy(objArr, b, objArr, b + 1, this.mSize - b);
            }
            this.f17876Lk[b] = j;
            this.f17877Ll[b] = e;
            this.mSize++;
            AppMethodBeat.m2505o(51924);
            return;
        }
        this.f17876Lk[b] = j;
        this.f17877Ll[b] = e;
        AppMethodBeat.m2505o(51924);
    }

    /* renamed from: b */
    static int m83516b(long[] jArr, int i, long j) {
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
