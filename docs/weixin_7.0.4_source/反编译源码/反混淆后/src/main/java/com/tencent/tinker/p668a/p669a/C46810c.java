package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.c */
public final class C46810c extends C31087a<C46810c> {
    public int[] Axn;

    public final /* synthetic */ int compareTo(Object obj) {
        C46810c c46810c = (C46810c) obj;
        int length = this.Axn.length;
        int length2 = c46810c.Axn.length;
        if (length != length2) {
            return C5910c.m9194hX(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.Axn[length2] != c46810c.Axn[length2]) {
                return C5910c.m9194hX(this.Axn[length2], c46810c.Axn[length2]);
            }
        }
        return 0;
    }

    public C46810c(int i, int[] iArr) {
        super(i);
        this.Axn = iArr;
    }
}
