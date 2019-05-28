package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.c.a.b.a;
import com.tencent.tinker.c.a.c.c;
import java.util.Arrays;

public abstract class i<T extends Comparable<T>> {
    protected final com.tencent.tinker.a.a.i Azk;
    protected final a Azm;
    private final c Azn;

    public abstract T a(com.tencent.tinker.a.a.a.a aVar);

    public abstract t.a c(com.tencent.tinker.a.a.i iVar);

    public abstract int e(T t);

    public i(a aVar, com.tencent.tinker.a.a.i iVar, c cVar) {
        this.Azm = aVar;
        this.Azk = iVar;
        this.Azn = cVar;
    }

    /* Access modifiers changed, original: protected */
    public T a(com.tencent.tinker.c.a.c.a aVar, T t) {
        return t;
    }

    /* Access modifiers changed, original: protected */
    public void a(c cVar, int i, int i2, int i3, int i4) {
    }

    /* Access modifiers changed, original: protected */
    public void a(c cVar, int i, int i2) {
    }

    private int[] RK(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int a = o.a(this.Azm.AAj) + i3;
            iArr[i2] = a;
            i2++;
            i3 = a;
        }
        return iArr;
    }

    private static int a(int i, T t) {
        if (t instanceof t.a.a) {
            return ((t.a.a) t).off;
        }
        return i;
    }

    public final void execute() {
        int i;
        com.tencent.tinker.a.a.a.a aVar;
        int[] RK = RK(o.b(this.Azm.AAj));
        int[] RK2 = RK(o.b(this.Azm.AAj));
        int[] RK3 = RK(o.b(this.Azm.AAj));
        t.a c = c(this.Azk);
        if (c.exists()) {
            com.tencent.tinker.a.a.a.a a = this.Azk.a(c);
            i = c.size;
            aVar = a;
        } else {
            i = 0;
            aVar = null;
        }
        int length = RK.length;
        int length2 = RK2.length;
        int length3 = RK3.length;
        int i2 = (i + length2) - length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i3 >= i && i4 >= i2) {
                break;
            } else if (i6 < length2 && RK2[i6] == i4) {
                e(a(this.Azm.AAj));
                i4++;
                i6++;
            } else if (i5 < length3 && RK3[i5] == i4) {
                e(a(this.Azm.AAj));
                i4++;
                i5++;
            } else if (Arrays.binarySearch(RK, i3) >= 0) {
                a(this.Azn, i3, a(i3, a(aVar)));
                i3++;
                i7++;
            } else if (Arrays.binarySearch(RK3, i3) >= 0) {
                a(this.Azn, i3, a(i3, a(aVar)));
                i3++;
            } else if (i3 < i) {
                Comparable a2 = a(this.Azn, a(aVar));
                int e = e(a2);
                a(this.Azn, i3, a(i3, a2), i4, e);
                i3++;
                i4++;
            }
        }
        if (i6 != length2 || i7 != length || i5 != length3) {
            throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", new Object[]{Integer.valueOf(i6), Integer.valueOf(length2), Integer.valueOf(i7), Integer.valueOf(length), Integer.valueOf(i5), Integer.valueOf(length3)}));
        }
    }
}
