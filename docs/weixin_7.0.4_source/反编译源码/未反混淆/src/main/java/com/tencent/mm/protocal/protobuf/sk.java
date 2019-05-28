package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class sk extends a {
    public int vZG;
    public int vZH;
    public int vZI;
    public LinkedList<sj> vZJ = new LinkedList();
    public b vZK;
    public atd vZL;

    public sk() {
        AppMethodBeat.i(72843);
        AppMethodBeat.o(72843);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72844);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vZG);
            aVar.iz(2, this.vZH);
            aVar.iz(3, this.vZI);
            aVar.e(4, 8, this.vZJ);
            if (this.vZK != null) {
                aVar.c(5, this.vZK);
            }
            if (this.vZL != null) {
                aVar.iy(6, this.vZL.computeSize());
                this.vZL.writeFields(aVar);
            }
            AppMethodBeat.o(72844);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.vZG) + 0) + e.a.a.b.b.a.bs(2, this.vZH)) + e.a.a.b.b.a.bs(3, this.vZI)) + e.a.a.a.c(4, 8, this.vZJ);
            if (this.vZK != null) {
                bs += e.a.a.b.b.a.b(5, this.vZK);
            }
            if (this.vZL != null) {
                bs += e.a.a.a.ix(6, this.vZL.computeSize());
            }
            AppMethodBeat.o(72844);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vZJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72844);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sk skVar = (sk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    skVar.vZG = aVar3.BTU.vd();
                    AppMethodBeat.o(72844);
                    return 0;
                case 2:
                    skVar.vZH = aVar3.BTU.vd();
                    AppMethodBeat.o(72844);
                    return 0;
                case 3:
                    skVar.vZI = aVar3.BTU.vd();
                    AppMethodBeat.o(72844);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sj sjVar = new sj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sjVar.populateBuilderWithField(aVar4, sjVar, a.getNextFieldNumber(aVar4))) {
                        }
                        skVar.vZJ.add(sjVar);
                    }
                    AppMethodBeat.o(72844);
                    return 0;
                case 5:
                    skVar.vZK = aVar3.BTU.emu();
                    AppMethodBeat.o(72844);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atd atd = new atd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atd.populateBuilderWithField(aVar4, atd, a.getNextFieldNumber(aVar4))) {
                        }
                        skVar.vZL = atd;
                    }
                    AppMethodBeat.o(72844);
                    return 0;
                default:
                    AppMethodBeat.o(72844);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72844);
            return -1;
        }
    }
}
