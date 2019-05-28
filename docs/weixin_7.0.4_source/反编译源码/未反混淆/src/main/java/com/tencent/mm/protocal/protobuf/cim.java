package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cim extends bsr {
    public String vIk;
    public String wbq;
    public atr xhs;
    public int xht;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28672);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wbq != null) {
                aVar.e(2, this.wbq);
            }
            if (this.vIk != null) {
                aVar.e(3, this.vIk);
            }
            if (this.xhs != null) {
                aVar.iy(4, this.xhs.computeSize());
                this.xhs.writeFields(aVar);
            }
            aVar.iz(5, this.xht);
            AppMethodBeat.o(28672);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbq != null) {
                ix += e.a.a.b.b.a.f(2, this.wbq);
            }
            if (this.vIk != null) {
                ix += e.a.a.b.b.a.f(3, this.vIk);
            }
            if (this.xhs != null) {
                ix += e.a.a.a.ix(4, this.xhs.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.xht);
            AppMethodBeat.o(28672);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28672);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cim cim = (cim) objArr[1];
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
                        cim.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28672);
                    return 0;
                case 2:
                    cim.wbq = aVar3.BTU.readString();
                    AppMethodBeat.o(28672);
                    return 0;
                case 3:
                    cim.vIk = aVar3.BTU.readString();
                    AppMethodBeat.o(28672);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atr atr = new atr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atr.populateBuilderWithField(aVar4, atr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cim.xhs = atr;
                    }
                    AppMethodBeat.o(28672);
                    return 0;
                case 5:
                    cim.xht = aVar3.BTU.vd();
                    AppMethodBeat.o(28672);
                    return 0;
                default:
                    AppMethodBeat.o(28672);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28672);
            return -1;
        }
    }
}
