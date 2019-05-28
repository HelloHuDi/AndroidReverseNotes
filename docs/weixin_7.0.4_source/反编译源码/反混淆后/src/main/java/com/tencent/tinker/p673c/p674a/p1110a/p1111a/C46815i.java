package com.tencent.tinker.p673c.p674a.p1110a.p1111a;

import com.tencent.tinker.p668a.p669a.C16316o;
import com.tencent.tinker.p668a.p669a.C36543i;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a;
import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p1365a.C46943a;
import com.tencent.tinker.p673c.p674a.p1426b.C31093a;
import com.tencent.tinker.p673c.p674a.p675c.C5920a;
import com.tencent.tinker.p673c.p674a.p675c.C7392c;
import java.util.Arrays;

/* renamed from: com.tencent.tinker.c.a.a.a.i */
public abstract class C46815i<T extends Comparable<T>> {
    protected final C36543i Azk;
    protected final C31093a Azm;
    private final C7392c Azn;

    /* renamed from: a */
    public abstract T mo29593a(C46943a c46943a);

    /* renamed from: c */
    public abstract C31086a mo29597c(C36543i c36543i);

    /* renamed from: e */
    public abstract int mo29598e(T t);

    public C46815i(C31093a c31093a, C36543i c36543i, C7392c c7392c) {
        this.Azm = c31093a;
        this.Azk = c36543i;
        this.Azn = c7392c;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public T mo29594a(C5920a c5920a, T t) {
        return t;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29596a(C7392c c7392c, int i, int i2, int i3, int i4) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29595a(C7392c c7392c, int i, int i2) {
    }

    /* renamed from: RK */
    private int[] m89032RK(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int a = C16316o.m25139a(this.Azm.AAj) + i3;
            iArr[i2] = a;
            i2++;
            i3 = a;
        }
        return iArr;
    }

    /* renamed from: a */
    private static int m89033a(int i, T t) {
        if (t instanceof C31087a) {
            return ((C31087a) t).off;
        }
        return i;
    }

    public final void execute() {
        int i;
        C46943a c46943a;
        int[] RK = m89032RK(C16316o.m25141b(this.Azm.AAj));
        int[] RK2 = m89032RK(C16316o.m25141b(this.Azm.AAj));
        int[] RK3 = m89032RK(C16316o.m25141b(this.Azm.AAj));
        C31086a c = mo29597c(this.Azk);
        if (c.exists()) {
            C46943a a = this.Azk.mo57798a(c);
            i = c.size;
            c46943a = a;
        } else {
            i = 0;
            c46943a = null;
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
                mo29598e(mo29593a(this.Azm.AAj));
                i4++;
                i6++;
            } else if (i5 < length3 && RK3[i5] == i4) {
                mo29598e(mo29593a(this.Azm.AAj));
                i4++;
                i5++;
            } else if (Arrays.binarySearch(RK, i3) >= 0) {
                mo29595a(this.Azn, i3, C46815i.m89033a(i3, mo29593a(c46943a)));
                i3++;
                i7++;
            } else if (Arrays.binarySearch(RK3, i3) >= 0) {
                mo29595a(this.Azn, i3, C46815i.m89033a(i3, mo29593a(c46943a)));
                i3++;
            } else if (i3 < i) {
                Comparable a2 = mo29594a(this.Azn, mo29593a(c46943a));
                int e = mo29598e(a2);
                mo29596a(this.Azn, i3, C46815i.m89033a(i3, a2), i4, e);
                i3++;
                i4++;
            }
        }
        if (i6 != length2 || i7 != length || i5 != length3) {
            throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", new Object[]{Integer.valueOf(i6), Integer.valueOf(length2), Integer.valueOf(i7), Integer.valueOf(length), Integer.valueOf(i5), Integer.valueOf(length3)}));
        }
    }
}
