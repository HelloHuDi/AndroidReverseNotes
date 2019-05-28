package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class a extends i {
    public String jBF;
    public b luJ;
    public int luK;
    public int luL;
    public int luM;
    public b luN;
    public b luO;
    public String luP;
    public String luQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(19418);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.lvj != null) {
                aVar.iy(1, this.lvj.computeSize());
                this.lvj.writeFields(aVar);
            }
            if (this.luJ != null) {
                aVar.c(2, this.luJ);
            }
            aVar.iz(3, this.luK);
            aVar.iz(4, this.luL);
            aVar.iz(5, this.luM);
            if (this.luN != null) {
                aVar.c(6, this.luN);
            }
            if (this.luO != null) {
                aVar.c(7, this.luO);
            }
            if (this.luP != null) {
                aVar.e(10, this.luP);
            }
            if (this.luQ != null) {
                aVar.e(11, this.luQ);
            }
            if (this.jBF != null) {
                aVar.e(12, this.jBF);
            }
            AppMethodBeat.o(19418);
            return 0;
        } else if (i == 1) {
            if (this.lvj != null) {
                ix = e.a.a.a.ix(1, this.lvj.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.luJ != null) {
                ix += e.a.a.b.b.a.b(2, this.luJ);
            }
            ix = ((ix + e.a.a.b.b.a.bs(3, this.luK)) + e.a.a.b.b.a.bs(4, this.luL)) + e.a.a.b.b.a.bs(5, this.luM);
            if (this.luN != null) {
                ix += e.a.a.b.b.a.b(6, this.luN);
            }
            if (this.luO != null) {
                ix += e.a.a.b.b.a.b(7, this.luO);
            }
            if (this.luP != null) {
                ix += e.a.a.b.b.a.f(10, this.luP);
            }
            if (this.luQ != null) {
                ix += e.a.a.b.b.a.f(11, this.luQ);
            }
            if (this.jBF != null) {
                ix += e.a.a.b.b.a.f(12, this.jBF);
            }
            AppMethodBeat.o(19418);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(19418);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar5, dVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.lvj = dVar;
                    }
                    AppMethodBeat.o(19418);
                    return 0;
                case 2:
                    aVar4.luJ = aVar3.BTU.emu();
                    AppMethodBeat.o(19418);
                    return 0;
                case 3:
                    aVar4.luK = aVar3.BTU.vd();
                    AppMethodBeat.o(19418);
                    return 0;
                case 4:
                    aVar4.luL = aVar3.BTU.vd();
                    AppMethodBeat.o(19418);
                    return 0;
                case 5:
                    aVar4.luM = aVar3.BTU.vd();
                    AppMethodBeat.o(19418);
                    return 0;
                case 6:
                    aVar4.luN = aVar3.BTU.emu();
                    AppMethodBeat.o(19418);
                    return 0;
                case 7:
                    aVar4.luO = aVar3.BTU.emu();
                    AppMethodBeat.o(19418);
                    return 0;
                case 10:
                    aVar4.luP = aVar3.BTU.readString();
                    AppMethodBeat.o(19418);
                    return 0;
                case 11:
                    aVar4.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(19418);
                    return 0;
                case 12:
                    aVar4.jBF = aVar3.BTU.readString();
                    AppMethodBeat.o(19418);
                    return 0;
                default:
                    AppMethodBeat.o(19418);
                    return -1;
            }
        } else {
            AppMethodBeat.o(19418);
            return -1;
        }
    }
}
