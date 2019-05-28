package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class lm extends a {
    public int vOZ;
    public int vPa;
    public int vPb;
    public LinkedList<ll> vPc = new LinkedList();
    public LinkedList<ll> vPd = new LinkedList();

    public lm() {
        AppMethodBeat.i(58895);
        AppMethodBeat.o(58895);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58896);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vOZ);
            aVar.iz(2, this.vPa);
            aVar.iz(5, this.vPb);
            aVar.e(3, 8, this.vPc);
            aVar.e(4, 8, this.vPd);
            AppMethodBeat.o(58896);
            return 0;
        } else if (i == 1) {
            bs = ((((e.a.a.b.b.a.bs(1, this.vOZ) + 0) + e.a.a.b.b.a.bs(2, this.vPa)) + e.a.a.b.b.a.bs(5, this.vPb)) + e.a.a.a.c(3, 8, this.vPc)) + e.a.a.a.c(4, 8, this.vPd);
            AppMethodBeat.o(58896);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vPc.clear();
            this.vPd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(58896);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            lm lmVar = (lm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            ll llVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    lmVar.vOZ = aVar3.BTU.vd();
                    AppMethodBeat.o(58896);
                    return 0;
                case 2:
                    lmVar.vPa = aVar3.BTU.vd();
                    AppMethodBeat.o(58896);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        llVar = new ll();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = llVar.populateBuilderWithField(aVar4, llVar, a.getNextFieldNumber(aVar4))) {
                        }
                        lmVar.vPc.add(llVar);
                    }
                    AppMethodBeat.o(58896);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        llVar = new ll();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = llVar.populateBuilderWithField(aVar4, llVar, a.getNextFieldNumber(aVar4))) {
                        }
                        lmVar.vPd.add(llVar);
                    }
                    AppMethodBeat.o(58896);
                    return 0;
                case 5:
                    lmVar.vPb = aVar3.BTU.vd();
                    AppMethodBeat.o(58896);
                    return 0;
                default:
                    AppMethodBeat.o(58896);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58896);
            return -1;
        }
    }
}
