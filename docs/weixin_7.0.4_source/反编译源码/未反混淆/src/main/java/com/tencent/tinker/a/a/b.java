package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class b extends a<b> {
    public int[] Axm;

    public final /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        int length = this.Axm.length;
        int length2 = bVar.Axm.length;
        if (length != length2) {
            return c.hX(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.Axm[length2] != bVar.Axm[length2]) {
                return c.hX(this.Axm[length2], bVar.Axm[length2]);
            }
        }
        return 0;
    }

    public b(int i, int[] iArr) {
        super(i);
        this.Axm = iArr;
    }
}
