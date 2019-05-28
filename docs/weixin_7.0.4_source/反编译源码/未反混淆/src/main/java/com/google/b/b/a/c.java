package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class c {
    private final a bzA;
    private final List<b> bzC = new ArrayList();

    public c(a aVar) {
        AppMethodBeat.i(57164);
        this.bzA = aVar;
        this.bzC.add(new b(aVar, new int[]{1}));
        AppMethodBeat.o(57164);
    }

    private b fD(int i) {
        b bVar;
        AppMethodBeat.i(57165);
        if (i >= this.bzC.size()) {
            bVar = (b) this.bzC.get(this.bzC.size() - 1);
            int size = this.bzC.size();
            b bVar2 = bVar;
            while (size <= i) {
                a aVar = this.bzA;
                int[] iArr = new int[2];
                iArr[0] = 1;
                int i2 = (size - 1) + this.bzA.bzz;
                iArr[1] = this.bzA.bzu[i2];
                bVar = new b(aVar, iArr);
                if (bVar2.bzA.equals(bVar.bzA)) {
                    if (bVar2.isZero() || bVar.isZero()) {
                        bVar = bVar2.bzA.bzw;
                    } else {
                        iArr = bVar2.bzB;
                        int length = iArr.length;
                        int[] iArr2 = bVar.bzB;
                        i2 = iArr2.length;
                        int[] iArr3 = new int[((length + i2) - 1)];
                        for (int i3 = 0; i3 < length; i3++) {
                            int i4 = iArr[i3];
                            for (int i5 = 0; i5 < i2; i5++) {
                                iArr3[i3 + i5] = a.bC(iArr3[i3 + i5], bVar2.bzA.bD(i4, iArr2[i5]));
                            }
                        }
                        bVar = new b(bVar2.bzA, iArr3);
                    }
                    this.bzC.add(bVar);
                    size++;
                    bVar2 = bVar;
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                    AppMethodBeat.o(57165);
                    throw illegalArgumentException;
                }
            }
        }
        bVar = (b) this.bzC.get(i);
        AppMethodBeat.o(57165);
        return bVar;
    }

    public final void e(int[] iArr, int i) {
        AppMethodBeat.i(57166);
        IllegalArgumentException illegalArgumentException;
        if (i == 0) {
            illegalArgumentException = new IllegalArgumentException("No error correction bytes");
            AppMethodBeat.o(57166);
            throw illegalArgumentException;
        }
        int length = iArr.length - i;
        if (length <= 0) {
            illegalArgumentException = new IllegalArgumentException("No data bytes provided");
            AppMethodBeat.o(57166);
            throw illegalArgumentException;
        }
        b fD = fD(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        iArr2 = new b(this.bzA, iArr2).bE(i, 1).b(fD)[1].bzB;
        int length2 = i - iArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(iArr2, 0, iArr, length + length2, iArr2.length);
        AppMethodBeat.o(57166);
    }
}
