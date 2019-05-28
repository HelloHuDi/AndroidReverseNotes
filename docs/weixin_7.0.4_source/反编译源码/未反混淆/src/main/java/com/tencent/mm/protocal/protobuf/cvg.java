package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cvg extends a {
    public int Scene;
    public String luQ;
    public String vKt;
    public long vQd;
    public int wDH;
    public axy wDI;
    public LinkedList<String> xrm = new LinkedList();
    public LinkedList<tn> xrn = new LinkedList();

    public cvg() {
        AppMethodBeat.i(124383);
        AppMethodBeat.o(124383);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124384);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 1, this.xrm);
            aVar.iz(2, this.wDH);
            if (this.luQ != null) {
                aVar.e(3, this.luQ);
            }
            aVar.iz(4, this.Scene);
            aVar.ai(5, this.vQd);
            if (this.vKt != null) {
                aVar.e(6, this.vKt);
            }
            if (this.wDI != null) {
                aVar.iy(7, this.wDI.computeSize());
                this.wDI.writeFields(aVar);
            }
            aVar.e(8, 8, this.xrn);
            AppMethodBeat.o(124384);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 1, this.xrm) + 0) + e.a.a.b.b.a.bs(2, this.wDH);
            if (this.luQ != null) {
                c += e.a.a.b.b.a.f(3, this.luQ);
            }
            c = (c + e.a.a.b.b.a.bs(4, this.Scene)) + e.a.a.b.b.a.o(5, this.vQd);
            if (this.vKt != null) {
                c += e.a.a.b.b.a.f(6, this.vKt);
            }
            if (this.wDI != null) {
                c += e.a.a.a.ix(7, this.wDI.computeSize());
            }
            c += e.a.a.a.c(8, 8, this.xrn);
            AppMethodBeat.o(124384);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xrm.clear();
            this.xrn.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124384);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvg cvg = (cvg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cvg.xrm.add(aVar3.BTU.readString());
                    AppMethodBeat.o(124384);
                    return 0;
                case 2:
                    cvg.wDH = aVar3.BTU.vd();
                    AppMethodBeat.o(124384);
                    return 0;
                case 3:
                    cvg.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(124384);
                    return 0;
                case 4:
                    cvg.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124384);
                    return 0;
                case 5:
                    cvg.vQd = aVar3.BTU.ve();
                    AppMethodBeat.o(124384);
                    return 0;
                case 6:
                    cvg.vKt = aVar3.BTU.readString();
                    AppMethodBeat.o(124384);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axy.populateBuilderWithField(aVar4, axy, a.getNextFieldNumber(aVar4))) {
                        }
                        cvg.wDI = axy;
                    }
                    AppMethodBeat.o(124384);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tn tnVar = new tn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tnVar.populateBuilderWithField(aVar4, tnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cvg.xrn.add(tnVar);
                    }
                    AppMethodBeat.o(124384);
                    return 0;
                default:
                    AppMethodBeat.o(124384);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124384);
            return -1;
        }
    }
}
