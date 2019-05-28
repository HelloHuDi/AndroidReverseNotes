package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class d extends a<d> {
    public int Axo;
    public int[][] Axp;
    public int[][] Axq;
    public int[][] Axr;

    public final /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        if (this.Axo != dVar.Axo) {
            return c.hX(this.Axo, dVar.Axo);
        }
        int length = this.Axp.length;
        int length2 = this.Axq.length;
        int length3 = this.Axr.length;
        int length4 = dVar.Axp.length;
        int length5 = dVar.Axq.length;
        int length6 = dVar.Axr.length;
        if (length != length4) {
            return c.hY(length, length4);
        }
        if (length2 != length5) {
            return c.hY(length2, length5);
        }
        if (length3 != length6) {
            return c.hY(length3, length6);
        }
        int i;
        for (length4 = 0; length4 < length; length4++) {
            length5 = this.Axp[length4][0];
            length6 = this.Axp[length4][1];
            i = dVar.Axp[length4][0];
            int i2 = dVar.Axp[length4][1];
            if (length5 != i) {
                return c.hX(length5, i);
            }
            if (length6 != i2) {
                return c.hY(length6, i2);
            }
        }
        for (length4 = 0; length4 < length2; length4++) {
            length = this.Axq[length4][0];
            length5 = this.Axq[length4][1];
            length6 = dVar.Axq[length4][0];
            i = dVar.Axq[length4][1];
            if (length != length6) {
                return c.hX(length, length6);
            }
            if (length5 != i) {
                return c.hY(length5, i);
            }
        }
        for (length4 = 0; length4 < length3; length4++) {
            length = this.Axr[length4][0];
            length2 = this.Axr[length4][1];
            length5 = dVar.Axr[length4][0];
            length6 = dVar.Axr[length4][1];
            if (length != length5) {
                return c.hX(length, length5);
            }
            if (length2 != length6) {
                return c.hY(length2, length6);
            }
        }
        return 0;
    }

    public d(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.Axo = i2;
        this.Axp = iArr;
        this.Axq = iArr2;
        this.Axr = iArr3;
    }
}
