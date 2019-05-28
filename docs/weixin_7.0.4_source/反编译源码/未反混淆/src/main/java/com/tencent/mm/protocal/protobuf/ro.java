package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ro extends bsr {
    public String fKh;
    public String jBB;
    public String ndP;
    public int vEt;
    public String vLo;
    public aw vRP;
    public String vXP;
    public String vYO;
    public String vYP;
    public String vYQ;
    public String vYR;
    public int vYS;
    public String vYT;
    public int vYU;
    public String vYV;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56760);
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
            if (this.vYO != null) {
                aVar.e(3, this.vYO);
            }
            if (this.vLo != null) {
                aVar.e(4, this.vLo);
            }
            if (this.vYP != null) {
                aVar.e(5, this.vYP);
            }
            if (this.vYQ != null) {
                aVar.e(6, this.vYQ);
            }
            if (this.vYR != null) {
                aVar.e(7, this.vYR);
            }
            if (this.vXP != null) {
                aVar.e(8, this.vXP);
            }
            aVar.iz(9, this.vYS);
            if (this.vRP != null) {
                aVar.iy(10, this.vRP.computeSize());
                this.vRP.writeFields(aVar);
            }
            if (this.vYT != null) {
                aVar.e(11, this.vYT);
            }
            if (this.jBB != null) {
                aVar.e(12, this.jBB);
            }
            if (this.ndP != null) {
                aVar.e(13, this.ndP);
            }
            aVar.iz(14, this.vEt);
            aVar.iz(15, this.vYU);
            if (this.vYV != null) {
                aVar.e(16, this.vYV);
            }
            AppMethodBeat.o(56760);
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
            if (this.vYO != null) {
                ix += e.a.a.b.b.a.f(3, this.vYO);
            }
            if (this.vLo != null) {
                ix += e.a.a.b.b.a.f(4, this.vLo);
            }
            if (this.vYP != null) {
                ix += e.a.a.b.b.a.f(5, this.vYP);
            }
            if (this.vYQ != null) {
                ix += e.a.a.b.b.a.f(6, this.vYQ);
            }
            if (this.vYR != null) {
                ix += e.a.a.b.b.a.f(7, this.vYR);
            }
            if (this.vXP != null) {
                ix += e.a.a.b.b.a.f(8, this.vXP);
            }
            ix += e.a.a.b.b.a.bs(9, this.vYS);
            if (this.vRP != null) {
                ix += e.a.a.a.ix(10, this.vRP.computeSize());
            }
            if (this.vYT != null) {
                ix += e.a.a.b.b.a.f(11, this.vYT);
            }
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(12, this.jBB);
            }
            if (this.ndP != null) {
                ix += e.a.a.b.b.a.f(13, this.ndP);
            }
            ix = (ix + e.a.a.b.b.a.bs(14, this.vEt)) + e.a.a.b.b.a.bs(15, this.vYU);
            if (this.vYV != null) {
                ix += e.a.a.b.b.a.f(16, this.vYV);
            }
            AppMethodBeat.o(56760);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56760);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ro roVar = (ro) objArr[1];
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
                        roVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56760);
                    return 0;
                case 2:
                    roVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 3:
                    roVar.vYO = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 4:
                    roVar.vLo = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 5:
                    roVar.vYP = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 6:
                    roVar.vYQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 7:
                    roVar.vYR = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 8:
                    roVar.vXP = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 9:
                    roVar.vYS = aVar3.BTU.vd();
                    AppMethodBeat.o(56760);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.populateBuilderWithField(aVar4, awVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        roVar.vRP = awVar;
                    }
                    AppMethodBeat.o(56760);
                    return 0;
                case 11:
                    roVar.vYT = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 12:
                    roVar.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 13:
                    roVar.ndP = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                case 14:
                    roVar.vEt = aVar3.BTU.vd();
                    AppMethodBeat.o(56760);
                    return 0;
                case 15:
                    roVar.vYU = aVar3.BTU.vd();
                    AppMethodBeat.o(56760);
                    return 0;
                case 16:
                    roVar.vYV = aVar3.BTU.readString();
                    AppMethodBeat.o(56760);
                    return 0;
                default:
                    AppMethodBeat.o(56760);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56760);
            return -1;
        }
    }
}
