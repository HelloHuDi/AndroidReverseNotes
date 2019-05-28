package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cle extends bsr {
    public String jBB;
    public int vIJ;
    public String vLs;
    public LinkedList<bbl> wCo = new LinkedList();
    public int xiQ;
    public int xiR;
    public LinkedList<azc> xiS = new LinkedList();

    public cle() {
        AppMethodBeat.i(73773);
        AppMethodBeat.o(73773);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73774);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            aVar.iz(3, this.vIJ);
            if (this.vLs != null) {
                aVar.e(4, this.vLs);
            }
            aVar.iz(5, this.xiQ);
            aVar.e(6, 8, this.wCo);
            aVar.iz(7, this.xiR);
            aVar.e(8, 8, this.xiS);
            AppMethodBeat.o(73774);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(2, this.jBB);
            }
            ix += e.a.a.b.b.a.bs(3, this.vIJ);
            if (this.vLs != null) {
                ix += e.a.a.b.b.a.f(4, this.vLs);
            }
            int bs = (((ix + e.a.a.b.b.a.bs(5, this.xiQ)) + e.a.a.a.c(6, 8, this.wCo)) + e.a.a.b.b.a.bs(7, this.xiR)) + e.a.a.a.c(8, 8, this.xiS);
            AppMethodBeat.o(73774);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wCo.clear();
            this.xiS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73774);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cle cle = (cle) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cle.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(73774);
                    return 0;
                case 2:
                    cle.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(73774);
                    return 0;
                case 3:
                    cle.vIJ = aVar3.BTU.vd();
                    AppMethodBeat.o(73774);
                    return 0;
                case 4:
                    cle.vLs = aVar3.BTU.readString();
                    AppMethodBeat.o(73774);
                    return 0;
                case 5:
                    cle.xiQ = aVar3.BTU.vd();
                    AppMethodBeat.o(73774);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbl bbl = new bbl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbl.populateBuilderWithField(aVar4, bbl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cle.wCo.add(bbl);
                    }
                    AppMethodBeat.o(73774);
                    return 0;
                case 7:
                    cle.xiR = aVar3.BTU.vd();
                    AppMethodBeat.o(73774);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        azc azc = new azc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azc.populateBuilderWithField(aVar4, azc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cle.xiS.add(azc);
                    }
                    AppMethodBeat.o(73774);
                    return 0;
                default:
                    AppMethodBeat.o(73774);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73774);
            return -1;
        }
    }
}
