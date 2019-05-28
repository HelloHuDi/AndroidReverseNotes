package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ccc extends bsr {
    public int OpCode;
    public int Scene;
    public int jBv;
    public LinkedList<bts> jBw = new LinkedList();
    public String ncF;
    public long xbt;

    public ccc() {
        AppMethodBeat.i(94611);
        AppMethodBeat.o(94611);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94612);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.OpCode);
            aVar.ai(3, this.xbt);
            if (this.ncF != null) {
                aVar.e(4, this.ncF);
            }
            aVar.iz(5, this.jBv);
            aVar.e(6, 8, this.jBw);
            aVar.iz(7, this.Scene);
            AppMethodBeat.o(94612);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.OpCode)) + e.a.a.b.b.a.o(3, this.xbt);
            if (this.ncF != null) {
                ix += e.a.a.b.b.a.f(4, this.ncF);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(5, this.jBv)) + e.a.a.a.c(6, 8, this.jBw)) + e.a.a.b.b.a.bs(7, this.Scene);
            AppMethodBeat.o(94612);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94612);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ccc ccc = (ccc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        ccc.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94612);
                    return 0;
                case 2:
                    ccc.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(94612);
                    return 0;
                case 3:
                    ccc.xbt = aVar3.BTU.ve();
                    AppMethodBeat.o(94612);
                    return 0;
                case 4:
                    ccc.ncF = aVar3.BTU.readString();
                    AppMethodBeat.o(94612);
                    return 0;
                case 5:
                    ccc.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(94612);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ccc.jBw.add(bts);
                    }
                    AppMethodBeat.o(94612);
                    return 0;
                case 7:
                    ccc.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(94612);
                    return 0;
                default:
                    AppMethodBeat.o(94612);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94612);
            return -1;
        }
    }
}
