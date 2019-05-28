package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ccm extends bsr {
    public int vFH;
    public String vHl;
    public String wZT;
    public long wZU;
    public long xbw;
    public int xbx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94623);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wZT != null) {
                aVar.e(2, this.wZT);
            }
            if (this.vHl != null) {
                aVar.e(3, this.vHl);
            }
            aVar.ai(4, this.wZU);
            aVar.iz(5, this.vFH);
            aVar.ai(6, this.xbw);
            aVar.iz(7, this.xbx);
            AppMethodBeat.o(94623);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZT != null) {
                ix += e.a.a.b.b.a.f(2, this.wZT);
            }
            if (this.vHl != null) {
                ix += e.a.a.b.b.a.f(3, this.vHl);
            }
            int o = (((ix + e.a.a.b.b.a.o(4, this.wZU)) + e.a.a.b.b.a.bs(5, this.vFH)) + e.a.a.b.b.a.o(6, this.xbw)) + e.a.a.b.b.a.bs(7, this.xbx);
            AppMethodBeat.o(94623);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94623);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccm ccm = (ccm) objArr[1];
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
                        ccm.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94623);
                    return 0;
                case 2:
                    ccm.wZT = aVar3.BTU.readString();
                    AppMethodBeat.o(94623);
                    return 0;
                case 3:
                    ccm.vHl = aVar3.BTU.readString();
                    AppMethodBeat.o(94623);
                    return 0;
                case 4:
                    ccm.wZU = aVar3.BTU.ve();
                    AppMethodBeat.o(94623);
                    return 0;
                case 5:
                    ccm.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(94623);
                    return 0;
                case 6:
                    ccm.xbw = aVar3.BTU.ve();
                    AppMethodBeat.o(94623);
                    return 0;
                case 7:
                    ccm.xbx = aVar3.BTU.vd();
                    AppMethodBeat.o(94623);
                    return 0;
                default:
                    AppMethodBeat.o(94623);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94623);
            return -1;
        }
    }
}
