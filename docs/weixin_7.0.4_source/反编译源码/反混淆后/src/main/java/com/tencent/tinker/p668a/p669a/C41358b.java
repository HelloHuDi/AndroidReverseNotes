package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.b */
public final class C41358b extends C31087a<C41358b> {
    public int[] Axm;

    public final /* synthetic */ int compareTo(Object obj) {
        C41358b c41358b = (C41358b) obj;
        int length = this.Axm.length;
        int length2 = c41358b.Axm.length;
        if (length != length2) {
            return C5910c.m9194hX(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.Axm[length2] != c41358b.Axm[length2]) {
                return C5910c.m9194hX(this.Axm[length2], c41358b.Axm[length2]);
            }
        }
        return 0;
    }

    public C41358b(int i, int[] iArr) {
        super(i);
        this.Axm = iArr;
    }
}
