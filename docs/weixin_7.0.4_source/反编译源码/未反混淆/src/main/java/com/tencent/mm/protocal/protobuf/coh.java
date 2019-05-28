package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class coh extends bsr {
    public int vZF;
    public String wPm;
    public int wem;
    public long wen;
    public int xlL;
    public cpx xlM;
    public cpx xlN;
    public String xlO;
    public int xlP;
    public long xlQ;
    public int xlR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5225);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.ai(3, this.wen);
            if (this.wPm != null) {
                aVar.e(4, this.wPm);
            }
            aVar.iz(5, this.xlL);
            if (this.xlM != null) {
                aVar.iy(6, this.xlM.computeSize());
                this.xlM.writeFields(aVar);
            }
            if (this.xlN != null) {
                aVar.iy(7, this.xlN.computeSize());
                this.xlN.writeFields(aVar);
            }
            aVar.iz(8, this.vZF);
            if (this.xlO != null) {
                aVar.e(9, this.xlO);
            }
            aVar.iz(10, this.xlP);
            aVar.ai(11, this.xlQ);
            aVar.iz(12, this.xlR);
            AppMethodBeat.o(5225);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.o(3, this.wen);
            if (this.wPm != null) {
                ix += e.a.a.b.b.a.f(4, this.wPm);
            }
            ix += e.a.a.b.b.a.bs(5, this.xlL);
            if (this.xlM != null) {
                ix += e.a.a.a.ix(6, this.xlM.computeSize());
            }
            if (this.xlN != null) {
                ix += e.a.a.a.ix(7, this.xlN.computeSize());
            }
            ix += e.a.a.b.b.a.bs(8, this.vZF);
            if (this.xlO != null) {
                ix += e.a.a.b.b.a.f(9, this.xlO);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(10, this.xlP)) + e.a.a.b.b.a.o(11, this.xlQ)) + e.a.a.b.b.a.bs(12, this.xlR);
            AppMethodBeat.o(5225);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(5225);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            coh coh = (coh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            cpx cpx;
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
                        coh.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5225);
                    return 0;
                case 2:
                    coh.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5225);
                    return 0;
                case 3:
                    coh.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5225);
                    return 0;
                case 4:
                    coh.wPm = aVar3.BTU.readString();
                    AppMethodBeat.o(5225);
                    return 0;
                case 5:
                    coh.xlL = aVar3.BTU.vd();
                    AppMethodBeat.o(5225);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(aVar4, cpx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        coh.xlM = cpx;
                    }
                    AppMethodBeat.o(5225);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(aVar4, cpx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        coh.xlN = cpx;
                    }
                    AppMethodBeat.o(5225);
                    return 0;
                case 8:
                    coh.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(5225);
                    return 0;
                case 9:
                    coh.xlO = aVar3.BTU.readString();
                    AppMethodBeat.o(5225);
                    return 0;
                case 10:
                    coh.xlP = aVar3.BTU.vd();
                    AppMethodBeat.o(5225);
                    return 0;
                case 11:
                    coh.xlQ = aVar3.BTU.ve();
                    AppMethodBeat.o(5225);
                    return 0;
                case 12:
                    coh.xlR = aVar3.BTU.vd();
                    AppMethodBeat.o(5225);
                    return 0;
                default:
                    AppMethodBeat.o(5225);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5225);
            return -1;
        }
    }
}
