package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class ahi extends a {
    public int vZG;
    public int vZH;
    public int vZI;
    public b vZK;
    public atd vZL;
    public int wnO;
    public int wnP;
    public int wnQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72849);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vZG);
            aVar.iz(2, this.vZH);
            aVar.iz(3, this.vZI);
            if (this.vZK != null) {
                aVar.c(4, this.vZK);
            }
            aVar.iz(5, this.wnO);
            aVar.iz(6, this.wnP);
            aVar.iz(7, this.wnQ);
            if (this.vZL != null) {
                aVar.iy(8, this.vZL.computeSize());
                this.vZL.writeFields(aVar);
            }
            AppMethodBeat.o(72849);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.vZG) + 0) + e.a.a.b.b.a.bs(2, this.vZH)) + e.a.a.b.b.a.bs(3, this.vZI);
            if (this.vZK != null) {
                bs += e.a.a.b.b.a.b(4, this.vZK);
            }
            bs = ((bs + e.a.a.b.b.a.bs(5, this.wnO)) + e.a.a.b.b.a.bs(6, this.wnP)) + e.a.a.b.b.a.bs(7, this.wnQ);
            if (this.vZL != null) {
                bs += e.a.a.a.ix(8, this.vZL.computeSize());
            }
            AppMethodBeat.o(72849);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72849);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahi ahi = (ahi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ahi.vZG = aVar3.BTU.vd();
                    AppMethodBeat.o(72849);
                    return 0;
                case 2:
                    ahi.vZH = aVar3.BTU.vd();
                    AppMethodBeat.o(72849);
                    return 0;
                case 3:
                    ahi.vZI = aVar3.BTU.vd();
                    AppMethodBeat.o(72849);
                    return 0;
                case 4:
                    ahi.vZK = aVar3.BTU.emu();
                    AppMethodBeat.o(72849);
                    return 0;
                case 5:
                    ahi.wnO = aVar3.BTU.vd();
                    AppMethodBeat.o(72849);
                    return 0;
                case 6:
                    ahi.wnP = aVar3.BTU.vd();
                    AppMethodBeat.o(72849);
                    return 0;
                case 7:
                    ahi.wnQ = aVar3.BTU.vd();
                    AppMethodBeat.o(72849);
                    return 0;
                case 8:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        atd atd = new atd();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = atd.populateBuilderWithField(aVar4, atd, a.getNextFieldNumber(aVar4))) {
                        }
                        ahi.vZL = atd;
                    }
                    AppMethodBeat.o(72849);
                    return 0;
                default:
                    AppMethodBeat.o(72849);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72849);
            return -1;
        }
    }
}
