package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agp extends bsr {
    public double latitude;
    public double longitude;
    public String vSR;
    public long vTi;
    public int wnj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89082);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vSR != null) {
                aVar.e(2, this.vSR);
            }
            aVar.f(3, this.latitude);
            aVar.f(4, this.longitude);
            aVar.ai(5, this.vTi);
            aVar.iz(6, this.wnj);
            AppMethodBeat.o(89082);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vSR != null) {
                ix += e.a.a.b.b.a.f(2, this.vSR);
            }
            int fv = (((ix + (e.a.a.b.b.a.fv(3) + 8)) + (e.a.a.b.b.a.fv(4) + 8)) + e.a.a.b.b.a.o(5, this.vTi)) + e.a.a.b.b.a.bs(6, this.wnj);
            AppMethodBeat.o(89082);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89082);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agp agp = (agp) objArr[1];
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
                        agp.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(89082);
                    return 0;
                case 2:
                    agp.vSR = aVar3.BTU.readString();
                    AppMethodBeat.o(89082);
                    return 0;
                case 3:
                    agp.latitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(89082);
                    return 0;
                case 4:
                    agp.longitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(89082);
                    return 0;
                case 5:
                    agp.vTi = aVar3.BTU.ve();
                    AppMethodBeat.o(89082);
                    return 0;
                case 6:
                    agp.wnj = aVar3.BTU.vd();
                    AppMethodBeat.o(89082);
                    return 0;
                default:
                    AppMethodBeat.o(89082);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89082);
            return -1;
        }
    }
}
