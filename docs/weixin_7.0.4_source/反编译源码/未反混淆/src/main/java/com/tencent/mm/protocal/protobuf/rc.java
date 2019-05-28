package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rc extends bsr {
    public int iAd;
    public String vYh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48819);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vYh != null) {
                aVar.e(2, this.vYh);
            }
            aVar.iz(3, this.iAd);
            AppMethodBeat.o(48819);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vYh != null) {
                ix += e.a.a.b.b.a.f(2, this.vYh);
            }
            int bs = ix + e.a.a.b.b.a.bs(3, this.iAd);
            AppMethodBeat.o(48819);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48819);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rc rcVar = (rc) objArr[1];
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
                        rcVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48819);
                    return 0;
                case 2:
                    rcVar.vYh = aVar3.BTU.readString();
                    AppMethodBeat.o(48819);
                    return 0;
                case 3:
                    rcVar.iAd = aVar3.BTU.vd();
                    AppMethodBeat.o(48819);
                    return 0;
                default:
                    AppMethodBeat.o(48819);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48819);
            return -1;
        }
    }
}
