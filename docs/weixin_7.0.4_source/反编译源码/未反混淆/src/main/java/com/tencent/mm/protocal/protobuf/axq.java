package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class axq extends bsr {
    public String fKh;
    public cwf wBB;
    public cxm wBC;
    public cxe wBD;
    public cyb wBE;
    public cxj wBF;
    public cxn wBG;
    public int wBH;
    public int wsv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96273);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            if (this.wBB != null) {
                aVar.iy(3, this.wBB.computeSize());
                this.wBB.writeFields(aVar);
            }
            aVar.iz(4, this.wsv);
            if (this.wBC != null) {
                aVar.iy(5, this.wBC.computeSize());
                this.wBC.writeFields(aVar);
            }
            if (this.wBD != null) {
                aVar.iy(6, this.wBD.computeSize());
                this.wBD.writeFields(aVar);
            }
            if (this.wBE != null) {
                aVar.iy(7, this.wBE.computeSize());
                this.wBE.writeFields(aVar);
            }
            if (this.wBF != null) {
                aVar.iy(8, this.wBF.computeSize());
                this.wBF.writeFields(aVar);
            }
            if (this.wBG != null) {
                aVar.iy(9, this.wBG.computeSize());
                this.wBG.writeFields(aVar);
            }
            aVar.iz(10, this.wBH);
            AppMethodBeat.o(96273);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(2, this.fKh);
            }
            if (this.wBB != null) {
                ix += e.a.a.a.ix(3, this.wBB.computeSize());
            }
            ix += e.a.a.b.b.a.bs(4, this.wsv);
            if (this.wBC != null) {
                ix += e.a.a.a.ix(5, this.wBC.computeSize());
            }
            if (this.wBD != null) {
                ix += e.a.a.a.ix(6, this.wBD.computeSize());
            }
            if (this.wBE != null) {
                ix += e.a.a.a.ix(7, this.wBE.computeSize());
            }
            if (this.wBF != null) {
                ix += e.a.a.a.ix(8, this.wBF.computeSize());
            }
            if (this.wBG != null) {
                ix += e.a.a.a.ix(9, this.wBG.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(10, this.wBH);
            AppMethodBeat.o(96273);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96273);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axq axq = (axq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        axq.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(96273);
                    return 0;
                case 2:
                    axq.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(96273);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwf cwf = new cwf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwf.populateBuilderWithField(aVar4, cwf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axq.wBB = cwf;
                    }
                    AppMethodBeat.o(96273);
                    return 0;
                case 4:
                    axq.wsv = aVar3.BTU.vd();
                    AppMethodBeat.o(96273);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxm cxm = new cxm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxm.populateBuilderWithField(aVar4, cxm, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axq.wBC = cxm;
                    }
                    AppMethodBeat.o(96273);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxe cxe = new cxe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxe.populateBuilderWithField(aVar4, cxe, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axq.wBD = cxe;
                    }
                    AppMethodBeat.o(96273);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyb cyb = new cyb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyb.populateBuilderWithField(aVar4, cyb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axq.wBE = cyb;
                    }
                    AppMethodBeat.o(96273);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxj cxj = new cxj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxj.populateBuilderWithField(aVar4, cxj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axq.wBF = cxj;
                    }
                    AppMethodBeat.o(96273);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxn cxn = new cxn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxn.populateBuilderWithField(aVar4, cxn, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axq.wBG = cxn;
                    }
                    AppMethodBeat.o(96273);
                    return 0;
                case 10:
                    axq.wBH = aVar3.BTU.vd();
                    AppMethodBeat.o(96273);
                    return 0;
                default:
                    AppMethodBeat.o(96273);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96273);
            return -1;
        }
    }
}
