package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bin extends bsr {
    public String fKh;
    public String mZu;
    public String ncH;
    public aw vRP;
    public String vYO;
    public String vYP;
    public String vYQ;
    public String vYR;
    public String wLU;
    public String wLV;
    public String wLW;
    public String wLX;
    public String wLY;
    public String wlb;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56876);
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
            if (this.wLU != null) {
                aVar.e(3, this.wLU);
            }
            if (this.wlb != null) {
                aVar.e(4, this.wlb);
            }
            if (this.vYO != null) {
                aVar.e(5, this.vYO);
            }
            if (this.wLV != null) {
                aVar.e(6, this.wLV);
            }
            if (this.vYP != null) {
                aVar.e(7, this.vYP);
            }
            if (this.vYQ != null) {
                aVar.e(8, this.vYQ);
            }
            if (this.vYR != null) {
                aVar.e(9, this.vYR);
            }
            if (this.wLW != null) {
                aVar.e(10, this.wLW);
            }
            if (this.vRP != null) {
                aVar.iy(11, this.vRP.computeSize());
                this.vRP.writeFields(aVar);
            }
            if (this.wLX != null) {
                aVar.e(12, this.wLX);
            }
            if (this.mZu != null) {
                aVar.e(13, this.mZu);
            }
            if (this.ncH != null) {
                aVar.e(14, this.ncH);
            }
            if (this.wLY != null) {
                aVar.e(15, this.wLY);
            }
            AppMethodBeat.o(56876);
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
            if (this.wLU != null) {
                ix += e.a.a.b.b.a.f(3, this.wLU);
            }
            if (this.wlb != null) {
                ix += e.a.a.b.b.a.f(4, this.wlb);
            }
            if (this.vYO != null) {
                ix += e.a.a.b.b.a.f(5, this.vYO);
            }
            if (this.wLV != null) {
                ix += e.a.a.b.b.a.f(6, this.wLV);
            }
            if (this.vYP != null) {
                ix += e.a.a.b.b.a.f(7, this.vYP);
            }
            if (this.vYQ != null) {
                ix += e.a.a.b.b.a.f(8, this.vYQ);
            }
            if (this.vYR != null) {
                ix += e.a.a.b.b.a.f(9, this.vYR);
            }
            if (this.wLW != null) {
                ix += e.a.a.b.b.a.f(10, this.wLW);
            }
            if (this.vRP != null) {
                ix += e.a.a.a.ix(11, this.vRP.computeSize());
            }
            if (this.wLX != null) {
                ix += e.a.a.b.b.a.f(12, this.wLX);
            }
            if (this.mZu != null) {
                ix += e.a.a.b.b.a.f(13, this.mZu);
            }
            if (this.ncH != null) {
                ix += e.a.a.b.b.a.f(14, this.ncH);
            }
            if (this.wLY != null) {
                ix += e.a.a.b.b.a.f(15, this.wLY);
            }
            AppMethodBeat.o(56876);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56876);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bin bin = (bin) objArr[1];
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
                        bin.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56876);
                    return 0;
                case 2:
                    bin.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 3:
                    bin.wLU = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 4:
                    bin.wlb = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 5:
                    bin.vYO = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 6:
                    bin.wLV = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 7:
                    bin.vYP = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 8:
                    bin.vYQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 9:
                    bin.vYR = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 10:
                    bin.wLW = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.populateBuilderWithField(aVar4, awVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bin.vRP = awVar;
                    }
                    AppMethodBeat.o(56876);
                    return 0;
                case 12:
                    bin.wLX = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 13:
                    bin.mZu = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 14:
                    bin.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                case 15:
                    bin.wLY = aVar3.BTU.readString();
                    AppMethodBeat.o(56876);
                    return 0;
                default:
                    AppMethodBeat.o(56876);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56876);
            return -1;
        }
    }
}
