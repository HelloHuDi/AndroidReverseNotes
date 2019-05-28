package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avw extends bsr {
    public String fKh;
    public LinkedList<String> wzD = new LinkedList();
    public int wzF;
    public cxh wzG;
    public String wzI;

    public avw() {
        AppMethodBeat.i(96255);
        AppMethodBeat.o(96255);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96256);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            aVar.e(3, 1, this.wzD);
            aVar.iz(4, this.wzF);
            if (this.wzG != null) {
                aVar.iy(5, this.wzG.computeSize());
                this.wzG.writeFields(aVar);
            }
            if (this.wzI != null) {
                aVar.e(6, this.wzI);
            }
            AppMethodBeat.o(96256);
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
            ix = (ix + e.a.a.a.c(3, 1, this.wzD)) + e.a.a.b.b.a.bs(4, this.wzF);
            if (this.wzG != null) {
                ix += e.a.a.a.ix(5, this.wzG.computeSize());
            }
            if (this.wzI != null) {
                ix += e.a.a.b.b.a.f(6, this.wzI);
            }
            AppMethodBeat.o(96256);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzD.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96256);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avw avw = (avw) objArr[1];
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
                        avw.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(96256);
                    return 0;
                case 2:
                    avw.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(96256);
                    return 0;
                case 3:
                    avw.wzD.add(aVar3.BTU.readString());
                    AppMethodBeat.o(96256);
                    return 0;
                case 4:
                    avw.wzF = aVar3.BTU.vd();
                    AppMethodBeat.o(96256);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cxh cxh = new cxh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxh.populateBuilderWithField(aVar4, cxh, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avw.wzG = cxh;
                    }
                    AppMethodBeat.o(96256);
                    return 0;
                case 6:
                    avw.wzI = aVar3.BTU.readString();
                    AppMethodBeat.o(96256);
                    return 0;
                default:
                    AppMethodBeat.o(96256);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96256);
            return -1;
        }
    }
}
