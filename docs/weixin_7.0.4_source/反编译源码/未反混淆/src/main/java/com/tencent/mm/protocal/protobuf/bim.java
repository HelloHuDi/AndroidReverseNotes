package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bim extends a {
    public int wLR;
    public SKBuiltinBuffer_t wLS;
    public int wLT;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(123510);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wLR);
            if (this.wLS != null) {
                aVar.iy(2, this.wLS.computeSize());
                this.wLS.writeFields(aVar);
            }
            aVar.iz(3, this.wLT);
            AppMethodBeat.o(123510);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wLR) + 0;
            if (this.wLS != null) {
                bs += e.a.a.a.ix(2, this.wLS.computeSize());
            }
            bs += e.a.a.b.b.a.bs(3, this.wLT);
            AppMethodBeat.o(123510);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(123510);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bim bim = (bim) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bim.wLR = aVar3.BTU.vd();
                    AppMethodBeat.o(123510);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bim.wLS = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(123510);
                    return 0;
                case 3:
                    bim.wLT = aVar3.BTU.vd();
                    AppMethodBeat.o(123510);
                    return 0;
                default:
                    AppMethodBeat.o(123510);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123510);
            return -1;
        }
    }
}
