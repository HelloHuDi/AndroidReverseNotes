package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ayr extends bsr {
    public int vOq;
    public String vQg;
    public b wCA;
    public int wCu;
    public int wCv = 2;
    public double wCw;
    public double wCx;
    public String wCy;
    public b wCz;
    public String wol;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124321);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wol != null) {
                aVar.e(2, this.wol);
            }
            aVar.iz(3, this.vOq);
            aVar.iz(4, this.wCu);
            if (this.vQg != null) {
                aVar.e(5, this.vQg);
            }
            aVar.iz(6, this.wCv);
            aVar.f(7, this.wCw);
            aVar.f(8, this.wCx);
            if (this.wCy != null) {
                aVar.e(9, this.wCy);
            }
            if (this.wCz != null) {
                aVar.c(11, this.wCz);
            }
            if (this.wCA != null) {
                aVar.c(12, this.wCA);
            }
            AppMethodBeat.o(124321);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wol != null) {
                ix += e.a.a.b.b.a.f(2, this.wol);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.vOq)) + e.a.a.b.b.a.bs(4, this.wCu);
            if (this.vQg != null) {
                ix += e.a.a.b.b.a.f(5, this.vQg);
            }
            ix = ((ix + e.a.a.b.b.a.bs(6, this.wCv)) + (e.a.a.b.b.a.fv(7) + 8)) + (e.a.a.b.b.a.fv(8) + 8);
            if (this.wCy != null) {
                ix += e.a.a.b.b.a.f(9, this.wCy);
            }
            if (this.wCz != null) {
                ix += e.a.a.b.b.a.b(11, this.wCz);
            }
            if (this.wCA != null) {
                ix += e.a.a.b.b.a.b(12, this.wCA);
            }
            AppMethodBeat.o(124321);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124321);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayr ayr = (ayr) objArr[1];
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
                        ayr.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(124321);
                    return 0;
                case 2:
                    ayr.wol = aVar3.BTU.readString();
                    AppMethodBeat.o(124321);
                    return 0;
                case 3:
                    ayr.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(124321);
                    return 0;
                case 4:
                    ayr.wCu = aVar3.BTU.vd();
                    AppMethodBeat.o(124321);
                    return 0;
                case 5:
                    ayr.vQg = aVar3.BTU.readString();
                    AppMethodBeat.o(124321);
                    return 0;
                case 6:
                    ayr.wCv = aVar3.BTU.vd();
                    AppMethodBeat.o(124321);
                    return 0;
                case 7:
                    ayr.wCw = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(124321);
                    return 0;
                case 8:
                    ayr.wCx = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(124321);
                    return 0;
                case 9:
                    ayr.wCy = aVar3.BTU.readString();
                    AppMethodBeat.o(124321);
                    return 0;
                case 11:
                    ayr.wCz = aVar3.BTU.emu();
                    AppMethodBeat.o(124321);
                    return 0;
                case 12:
                    ayr.wCA = aVar3.BTU.emu();
                    AppMethodBeat.o(124321);
                    return 0;
                default:
                    AppMethodBeat.o(124321);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124321);
            return -1;
        }
    }
}
