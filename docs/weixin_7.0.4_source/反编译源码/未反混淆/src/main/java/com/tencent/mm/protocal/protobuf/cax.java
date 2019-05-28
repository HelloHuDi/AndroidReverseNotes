package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cax extends bsr {
    public int jCt;
    public int ptw;
    public int ptx;
    public String xac;
    public int xad;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94573);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.ptx);
            aVar.iz(3, this.ptw);
            if (this.xac != null) {
                aVar.e(4, this.xac);
            }
            aVar.iz(5, this.jCt);
            aVar.iz(6, this.xad);
            AppMethodBeat.o(94573);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.ptx)) + e.a.a.b.b.a.bs(3, this.ptw);
            if (this.xac != null) {
                ix += e.a.a.b.b.a.f(4, this.xac);
            }
            int bs = (ix + e.a.a.b.b.a.bs(5, this.jCt)) + e.a.a.b.b.a.bs(6, this.xad);
            AppMethodBeat.o(94573);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94573);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cax cax = (cax) objArr[1];
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
                        cax.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94573);
                    return 0;
                case 2:
                    cax.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(94573);
                    return 0;
                case 3:
                    cax.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(94573);
                    return 0;
                case 4:
                    cax.xac = aVar3.BTU.readString();
                    AppMethodBeat.o(94573);
                    return 0;
                case 5:
                    cax.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(94573);
                    return 0;
                case 6:
                    cax.xad = aVar3.BTU.vd();
                    AppMethodBeat.o(94573);
                    return 0;
                default:
                    AppMethodBeat.o(94573);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94573);
            return -1;
        }
    }
}
