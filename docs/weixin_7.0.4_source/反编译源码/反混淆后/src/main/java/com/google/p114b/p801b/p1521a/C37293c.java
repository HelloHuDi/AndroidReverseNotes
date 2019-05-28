package com.google.p114b.p801b.p1521a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.b.b.a.c */
public final class C37293c {
    private final C41637a bzA;
    private final List<C45060b> bzC = new ArrayList();

    public C37293c(C41637a c41637a) {
        AppMethodBeat.m2504i(57164);
        this.bzA = c41637a;
        this.bzC.add(new C45060b(c41637a, new int[]{1}));
        AppMethodBeat.m2505o(57164);
    }

    /* renamed from: fD */
    private C45060b m62693fD(int i) {
        C45060b c45060b;
        AppMethodBeat.m2504i(57165);
        if (i >= this.bzC.size()) {
            c45060b = (C45060b) this.bzC.get(this.bzC.size() - 1);
            int size = this.bzC.size();
            C45060b c45060b2 = c45060b;
            while (size <= i) {
                C41637a c41637a = this.bzA;
                int[] iArr = new int[2];
                iArr[0] = 1;
                int i2 = (size - 1) + this.bzA.bzz;
                iArr[1] = this.bzA.bzu[i2];
                c45060b = new C45060b(c41637a, iArr);
                if (c45060b2.bzA.equals(c45060b.bzA)) {
                    if (c45060b2.isZero() || c45060b.isZero()) {
                        c45060b = c45060b2.bzA.bzw;
                    } else {
                        iArr = c45060b2.bzB;
                        int length = iArr.length;
                        int[] iArr2 = c45060b.bzB;
                        i2 = iArr2.length;
                        int[] iArr3 = new int[((length + i2) - 1)];
                        for (int i3 = 0; i3 < length; i3++) {
                            int i4 = iArr[i3];
                            for (int i5 = 0; i5 < i2; i5++) {
                                iArr3[i3 + i5] = C41637a.m72996bC(iArr3[i3 + i5], c45060b2.bzA.mo67033bD(i4, iArr2[i5]));
                            }
                        }
                        c45060b = new C45060b(c45060b2.bzA, iArr3);
                    }
                    this.bzC.add(c45060b);
                    size++;
                    c45060b2 = c45060b;
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                    AppMethodBeat.m2505o(57165);
                    throw illegalArgumentException;
                }
            }
        }
        c45060b = (C45060b) this.bzC.get(i);
        AppMethodBeat.m2505o(57165);
        return c45060b;
    }

    /* renamed from: e */
    public final void mo59988e(int[] iArr, int i) {
        AppMethodBeat.m2504i(57166);
        IllegalArgumentException illegalArgumentException;
        if (i == 0) {
            illegalArgumentException = new IllegalArgumentException("No error correction bytes");
            AppMethodBeat.m2505o(57166);
            throw illegalArgumentException;
        }
        int length = iArr.length - i;
        if (length <= 0) {
            illegalArgumentException = new IllegalArgumentException("No data bytes provided");
            AppMethodBeat.m2505o(57166);
            throw illegalArgumentException;
        }
        C45060b fD = m62693fD(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        iArr2 = new C45060b(this.bzA, iArr2).mo72814bE(i, 1).mo72813b(fD)[1].bzB;
        int length2 = i - iArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(iArr2, 0, iArr, length + length2, iArr2.length);
        AppMethodBeat.m2505o(57166);
    }
}
