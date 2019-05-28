package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aye extends bsr {
    public int OpCode;
    public String fLc;
    public float vRp;
    public float vRq;
    public int wCj;
    public int wCk;
    public int wfG;
    public String wfH;
    public String wfI;
    public int wfJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55530);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.OpCode);
            aVar.r(3, this.vRp);
            aVar.r(4, this.vRq);
            aVar.iz(5, this.wfG);
            if (this.wfH != null) {
                aVar.e(6, this.wfH);
            }
            if (this.wfI != null) {
                aVar.e(7, this.wfI);
            }
            aVar.iz(8, this.wfJ);
            if (this.fLc != null) {
                aVar.e(9, this.fLc);
            }
            aVar.iz(10, this.wCj);
            aVar.iz(11, this.wCk);
            AppMethodBeat.o(55530);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((ix + e.a.a.b.b.a.bs(2, this.OpCode)) + (e.a.a.b.b.a.fv(3) + 4)) + (e.a.a.b.b.a.fv(4) + 4)) + e.a.a.b.b.a.bs(5, this.wfG);
            if (this.wfH != null) {
                ix += e.a.a.b.b.a.f(6, this.wfH);
            }
            if (this.wfI != null) {
                ix += e.a.a.b.b.a.f(7, this.wfI);
            }
            ix += e.a.a.b.b.a.bs(8, this.wfJ);
            if (this.fLc != null) {
                ix += e.a.a.b.b.a.f(9, this.fLc);
            }
            int bs = (ix + e.a.a.b.b.a.bs(10, this.wCj)) + e.a.a.b.b.a.bs(11, this.wCk);
            AppMethodBeat.o(55530);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55530);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aye aye = (aye) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aye.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(55530);
                    return 0;
                case 2:
                    aye.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(55530);
                    return 0;
                case 3:
                    aye.vRp = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(55530);
                    return 0;
                case 4:
                    aye.vRq = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(55530);
                    return 0;
                case 5:
                    aye.wfG = aVar3.BTU.vd();
                    AppMethodBeat.o(55530);
                    return 0;
                case 6:
                    aye.wfH = aVar3.BTU.readString();
                    AppMethodBeat.o(55530);
                    return 0;
                case 7:
                    aye.wfI = aVar3.BTU.readString();
                    AppMethodBeat.o(55530);
                    return 0;
                case 8:
                    aye.wfJ = aVar3.BTU.vd();
                    AppMethodBeat.o(55530);
                    return 0;
                case 9:
                    aye.fLc = aVar3.BTU.readString();
                    AppMethodBeat.o(55530);
                    return 0;
                case 10:
                    aye.wCj = aVar3.BTU.vd();
                    AppMethodBeat.o(55530);
                    return 0;
                case 11:
                    aye.wCk = aVar3.BTU.vd();
                    AppMethodBeat.o(55530);
                    return 0;
                default:
                    AppMethodBeat.o(55530);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55530);
            return -1;
        }
    }
}
