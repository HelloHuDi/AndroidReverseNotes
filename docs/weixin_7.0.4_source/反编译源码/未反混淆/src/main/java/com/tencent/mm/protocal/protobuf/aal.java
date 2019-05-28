package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aal extends bsr {
    public int OpCode;
    public float vRp;
    public float vRq;
    public String wdB;
    public String wfF;
    public int wfG;
    public String wfH;
    public String wfI;
    public int wfJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28403);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.OpCode);
            if (this.wfF != null) {
                aVar.e(3, this.wfF);
            }
            aVar.r(4, this.vRp);
            aVar.r(5, this.vRq);
            aVar.iz(6, this.wfG);
            if (this.wfH != null) {
                aVar.e(7, this.wfH);
            }
            if (this.wfI != null) {
                aVar.e(8, this.wfI);
            }
            aVar.iz(9, this.wfJ);
            if (this.wdB != null) {
                aVar.e(10, this.wdB);
            }
            AppMethodBeat.o(28403);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.OpCode);
            if (this.wfF != null) {
                ix += e.a.a.b.b.a.f(3, this.wfF);
            }
            ix = ((ix + (e.a.a.b.b.a.fv(4) + 4)) + (e.a.a.b.b.a.fv(5) + 4)) + e.a.a.b.b.a.bs(6, this.wfG);
            if (this.wfH != null) {
                ix += e.a.a.b.b.a.f(7, this.wfH);
            }
            if (this.wfI != null) {
                ix += e.a.a.b.b.a.f(8, this.wfI);
            }
            ix += e.a.a.b.b.a.bs(9, this.wfJ);
            if (this.wdB != null) {
                ix += e.a.a.b.b.a.f(10, this.wdB);
            }
            AppMethodBeat.o(28403);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28403);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aal aal = (aal) objArr[1];
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
                        aal.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28403);
                    return 0;
                case 2:
                    aal.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(28403);
                    return 0;
                case 3:
                    aal.wfF = aVar3.BTU.readString();
                    AppMethodBeat.o(28403);
                    return 0;
                case 4:
                    aal.vRp = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(28403);
                    return 0;
                case 5:
                    aal.vRq = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(28403);
                    return 0;
                case 6:
                    aal.wfG = aVar3.BTU.vd();
                    AppMethodBeat.o(28403);
                    return 0;
                case 7:
                    aal.wfH = aVar3.BTU.readString();
                    AppMethodBeat.o(28403);
                    return 0;
                case 8:
                    aal.wfI = aVar3.BTU.readString();
                    AppMethodBeat.o(28403);
                    return 0;
                case 9:
                    aal.wfJ = aVar3.BTU.vd();
                    AppMethodBeat.o(28403);
                    return 0;
                case 10:
                    aal.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(28403);
                    return 0;
                default:
                    AppMethodBeat.o(28403);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28403);
            return -1;
        }
    }
}
