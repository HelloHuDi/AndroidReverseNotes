package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.h */
public final class C36542h extends C31087a<C36542h> {
    public int AxU;
    public int[] AxV;
    public byte[] AxW;

    public final /* synthetic */ int compareTo(Object obj) {
        C36542h c36542h = (C36542h) obj;
        int i = this.AxU;
        int i2 = c36542h.AxU;
        if (i != i2) {
            return i - i2;
        }
        int[] iArr = this.AxV;
        int[] iArr2 = c36542h.AxV;
        int length = iArr.length;
        i = iArr2.length;
        if (length < i) {
            i = -1;
        } else if (length > i) {
            i = 1;
        } else {
            for (i2 = 0; i2 < length; i2++) {
                i = C5910c.m9194hX(iArr[i2], iArr2[i2]);
                if (i != 0) {
                    break;
                }
            }
            i = 0;
        }
        if (i == 0) {
            return C5910c.m9196o(this.AxW, c36542h.AxW);
        }
        return i;
    }

    public C36542h(int i, int i2, int[] iArr, byte[] bArr) {
        super(i);
        this.AxU = i2;
        this.AxV = iArr;
        this.AxW = bArr;
    }
}
