package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.d */
public final class C16311d extends C31087a<C16311d> {
    public int Axo;
    public int[][] Axp;
    public int[][] Axq;
    public int[][] Axr;

    public final /* synthetic */ int compareTo(Object obj) {
        C16311d c16311d = (C16311d) obj;
        if (this.Axo != c16311d.Axo) {
            return C5910c.m9194hX(this.Axo, c16311d.Axo);
        }
        int length = this.Axp.length;
        int length2 = this.Axq.length;
        int length3 = this.Axr.length;
        int length4 = c16311d.Axp.length;
        int length5 = c16311d.Axq.length;
        int length6 = c16311d.Axr.length;
        if (length != length4) {
            return C5910c.m9195hY(length, length4);
        }
        if (length2 != length5) {
            return C5910c.m9195hY(length2, length5);
        }
        if (length3 != length6) {
            return C5910c.m9195hY(length3, length6);
        }
        int i;
        for (length4 = 0; length4 < length; length4++) {
            length5 = this.Axp[length4][0];
            length6 = this.Axp[length4][1];
            i = c16311d.Axp[length4][0];
            int i2 = c16311d.Axp[length4][1];
            if (length5 != i) {
                return C5910c.m9194hX(length5, i);
            }
            if (length6 != i2) {
                return C5910c.m9195hY(length6, i2);
            }
        }
        for (length4 = 0; length4 < length2; length4++) {
            length = this.Axq[length4][0];
            length5 = this.Axq[length4][1];
            length6 = c16311d.Axq[length4][0];
            i = c16311d.Axq[length4][1];
            if (length != length6) {
                return C5910c.m9194hX(length, length6);
            }
            if (length5 != i) {
                return C5910c.m9195hY(length5, i);
            }
        }
        for (length4 = 0; length4 < length3; length4++) {
            length = this.Axr[length4][0];
            length2 = this.Axr[length4][1];
            length5 = c16311d.Axr[length4][0];
            length6 = c16311d.Axr[length4][1];
            if (length != length5) {
                return C5910c.m9194hX(length, length5);
            }
            if (length2 != length6) {
                return C5910c.m9195hY(length2, length6);
            }
        }
        return 0;
    }

    public C16311d(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.Axo = i2;
        this.Axp = iArr;
        this.Axq = iArr2;
        this.Axr = iArr3;
    }
}
