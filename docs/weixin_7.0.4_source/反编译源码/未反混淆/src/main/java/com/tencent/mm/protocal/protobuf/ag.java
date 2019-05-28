package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ag extends a {
    public int vBo;
    public int vBp;
    public int vBq;
    public LinkedList<ae> vBr = new LinkedList();
    public int vBs;
    public LinkedList<ae> vBt = new LinkedList();

    public ag() {
        AppMethodBeat.i(72839);
        AppMethodBeat.o(72839);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72840);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vBo);
            aVar.iz(2, this.vBq);
            aVar.e(3, 8, this.vBr);
            aVar.iz(4, this.vBp);
            aVar.iz(5, this.vBs);
            aVar.e(6, 8, this.vBt);
            AppMethodBeat.o(72840);
            return 0;
        } else if (i == 1) {
            bs = (((((e.a.a.b.b.a.bs(1, this.vBo) + 0) + e.a.a.b.b.a.bs(2, this.vBq)) + e.a.a.a.c(3, 8, this.vBr)) + e.a.a.b.b.a.bs(4, this.vBp)) + e.a.a.b.b.a.bs(5, this.vBs)) + e.a.a.a.c(6, 8, this.vBt);
            AppMethodBeat.o(72840);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vBr.clear();
            this.vBt.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72840);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ag agVar = (ag) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            ae aeVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    agVar.vBo = aVar3.BTU.vd();
                    AppMethodBeat.o(72840);
                    return 0;
                case 2:
                    agVar.vBq = aVar3.BTU.vd();
                    AppMethodBeat.o(72840);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aeVar = new ae();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aeVar.populateBuilderWithField(aVar4, aeVar, a.getNextFieldNumber(aVar4))) {
                        }
                        agVar.vBr.add(aeVar);
                    }
                    AppMethodBeat.o(72840);
                    return 0;
                case 4:
                    agVar.vBp = aVar3.BTU.vd();
                    AppMethodBeat.o(72840);
                    return 0;
                case 5:
                    agVar.vBs = aVar3.BTU.vd();
                    AppMethodBeat.o(72840);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aeVar = new ae();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aeVar.populateBuilderWithField(aVar4, aeVar, a.getNextFieldNumber(aVar4))) {
                        }
                        agVar.vBt.add(aeVar);
                    }
                    AppMethodBeat.o(72840);
                    return 0;
                default:
                    AppMethodBeat.o(72840);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72840);
            return -1;
        }
    }
}
