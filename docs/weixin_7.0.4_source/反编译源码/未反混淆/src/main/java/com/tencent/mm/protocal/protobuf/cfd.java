package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cfd extends bsr {
    public String jBB;
    public String vEf;
    public int vFH;
    public String wZT;
    public long wZU;
    public long xbw;
    public int xbx;
    public long xeF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56548);
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
            if (this.jBB != null) {
                aVar.e(3, this.jBB);
            }
            aVar.ai(4, this.wZU);
            aVar.ai(5, this.xbw);
            aVar.iz(6, this.xbx);
            aVar.ai(7, this.xeF);
            aVar.iz(8, this.vFH);
            if (this.vEf != null) {
                aVar.e(9, this.vEf);
            }
            AppMethodBeat.o(56548);
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
            if (this.jBB != null) {
                ix += e.a.a.b.b.a.f(3, this.jBB);
            }
            ix = ((((ix + e.a.a.b.b.a.o(4, this.wZU)) + e.a.a.b.b.a.o(5, this.xbw)) + e.a.a.b.b.a.bs(6, this.xbx)) + e.a.a.b.b.a.o(7, this.xeF)) + e.a.a.b.b.a.bs(8, this.vFH);
            if (this.vEf != null) {
                ix += e.a.a.b.b.a.f(9, this.vEf);
            }
            AppMethodBeat.o(56548);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56548);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cfd cfd = (cfd) objArr[1];
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
                        cfd.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56548);
                    return 0;
                case 2:
                    cfd.wZT = aVar3.BTU.readString();
                    AppMethodBeat.o(56548);
                    return 0;
                case 3:
                    cfd.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(56548);
                    return 0;
                case 4:
                    cfd.wZU = aVar3.BTU.ve();
                    AppMethodBeat.o(56548);
                    return 0;
                case 5:
                    cfd.xbw = aVar3.BTU.ve();
                    AppMethodBeat.o(56548);
                    return 0;
                case 6:
                    cfd.xbx = aVar3.BTU.vd();
                    AppMethodBeat.o(56548);
                    return 0;
                case 7:
                    cfd.xeF = aVar3.BTU.ve();
                    AppMethodBeat.o(56548);
                    return 0;
                case 8:
                    cfd.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(56548);
                    return 0;
                case 9:
                    cfd.vEf = aVar3.BTU.readString();
                    AppMethodBeat.o(56548);
                    return 0;
                default:
                    AppMethodBeat.o(56548);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56548);
            return -1;
        }
    }
}
