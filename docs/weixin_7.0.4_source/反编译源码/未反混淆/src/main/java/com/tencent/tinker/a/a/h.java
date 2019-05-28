package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class h extends a<h> {
    public int AxU;
    public int[] AxV;
    public byte[] AxW;

    public final /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        int i = this.AxU;
        int i2 = hVar.AxU;
        if (i != i2) {
            return i - i2;
        }
        int[] iArr = this.AxV;
        int[] iArr2 = hVar.AxV;
        int length = iArr.length;
        i = iArr2.length;
        if (length < i) {
            i = -1;
        } else if (length > i) {
            i = 1;
        } else {
            for (i2 = 0; i2 < length; i2++) {
                i = c.hX(iArr[i2], iArr2[i2]);
                if (i != 0) {
                    break;
                }
            }
            i = 0;
        }
        if (i == 0) {
            return c.o(this.AxW, hVar.AxW);
        }
        return i;
    }

    public h(int i, int i2, int[] iArr, byte[] bArr) {
        super(i);
        this.AxU = i2;
        this.AxV = iArr;
        this.AxW = bArr;
    }
}
