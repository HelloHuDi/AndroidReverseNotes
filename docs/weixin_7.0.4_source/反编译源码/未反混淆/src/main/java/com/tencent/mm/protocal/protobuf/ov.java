package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ov extends bsr {
    public int cIb;
    public int nUf;
    public int pOA;
    public String pPS;
    public String pPT;
    public String vFb;
    public String vFc;
    public String vVW;
    public String vVX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56749);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vFb != null) {
                aVar.e(2, this.vFb);
            }
            if (this.vFc != null) {
                aVar.e(3, this.vFc);
            }
            aVar.iz(4, this.nUf);
            if (this.pPT != null) {
                aVar.e(5, this.pPT);
            }
            if (this.pPS != null) {
                aVar.e(6, this.pPS);
            }
            aVar.iz(7, this.cIb);
            aVar.iz(8, this.pOA);
            if (this.vVW != null) {
                aVar.e(9, this.vVW);
            }
            if (this.vVX != null) {
                aVar.e(10, this.vVX);
            }
            AppMethodBeat.o(56749);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vFb != null) {
                ix += e.a.a.b.b.a.f(2, this.vFb);
            }
            if (this.vFc != null) {
                ix += e.a.a.b.b.a.f(3, this.vFc);
            }
            ix += e.a.a.b.b.a.bs(4, this.nUf);
            if (this.pPT != null) {
                ix += e.a.a.b.b.a.f(5, this.pPT);
            }
            if (this.pPS != null) {
                ix += e.a.a.b.b.a.f(6, this.pPS);
            }
            ix = (ix + e.a.a.b.b.a.bs(7, this.cIb)) + e.a.a.b.b.a.bs(8, this.pOA);
            if (this.vVW != null) {
                ix += e.a.a.b.b.a.f(9, this.vVW);
            }
            if (this.vVX != null) {
                ix += e.a.a.b.b.a.f(10, this.vVX);
            }
            AppMethodBeat.o(56749);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56749);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ov ovVar = (ov) objArr[1];
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
                        ovVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56749);
                    return 0;
                case 2:
                    ovVar.vFb = aVar3.BTU.readString();
                    AppMethodBeat.o(56749);
                    return 0;
                case 3:
                    ovVar.vFc = aVar3.BTU.readString();
                    AppMethodBeat.o(56749);
                    return 0;
                case 4:
                    ovVar.nUf = aVar3.BTU.vd();
                    AppMethodBeat.o(56749);
                    return 0;
                case 5:
                    ovVar.pPT = aVar3.BTU.readString();
                    AppMethodBeat.o(56749);
                    return 0;
                case 6:
                    ovVar.pPS = aVar3.BTU.readString();
                    AppMethodBeat.o(56749);
                    return 0;
                case 7:
                    ovVar.cIb = aVar3.BTU.vd();
                    AppMethodBeat.o(56749);
                    return 0;
                case 8:
                    ovVar.pOA = aVar3.BTU.vd();
                    AppMethodBeat.o(56749);
                    return 0;
                case 9:
                    ovVar.vVW = aVar3.BTU.readString();
                    AppMethodBeat.o(56749);
                    return 0;
                case 10:
                    ovVar.vVX = aVar3.BTU.readString();
                    AppMethodBeat.o(56749);
                    return 0;
                default:
                    AppMethodBeat.o(56749);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56749);
            return -1;
        }
    }
}
