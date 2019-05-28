package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.t.a.a;

public final class c extends a<c> {
    public int[] Axn;

    public final /* synthetic */ int compareTo(Object obj) {
        c cVar = (c) obj;
        int length = this.Axn.length;
        int length2 = cVar.Axn.length;
        if (length != length2) {
            return com.tencent.tinker.a.a.b.c.hX(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.Axn[length2] != cVar.Axn[length2]) {
                return com.tencent.tinker.a.a.b.c.hX(this.Axn[length2], cVar.Axn[length2]);
            }
        }
        return 0;
    }

    public c(int i, int[] iArr) {
        super(i);
        this.Axn = iArr;
    }
}
