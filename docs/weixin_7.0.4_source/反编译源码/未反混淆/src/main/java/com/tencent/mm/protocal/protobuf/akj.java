package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class akj extends bsr {
    public int Height;
    public int Width;
    public String luQ;
    public float vRp;
    public float vRq;
    public int wqd;
    public int wqe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113780);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.r(2, this.vRp);
            aVar.r(3, this.vRq);
            aVar.iz(4, this.Width);
            aVar.iz(5, this.Height);
            if (this.luQ != null) {
                aVar.e(6, this.luQ);
            }
            aVar.iz(7, this.wqd);
            aVar.iz(8, this.wqe);
            AppMethodBeat.o(113780);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((ix + (e.a.a.b.b.a.fv(2) + 4)) + (e.a.a.b.b.a.fv(3) + 4)) + e.a.a.b.b.a.bs(4, this.Width)) + e.a.a.b.b.a.bs(5, this.Height);
            if (this.luQ != null) {
                ix += e.a.a.b.b.a.f(6, this.luQ);
            }
            int bs = (ix + e.a.a.b.b.a.bs(7, this.wqd)) + e.a.a.b.b.a.bs(8, this.wqe);
            AppMethodBeat.o(113780);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(113780);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akj akj = (akj) objArr[1];
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
                        akj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(113780);
                    return 0;
                case 2:
                    akj.vRp = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(113780);
                    return 0;
                case 3:
                    akj.vRq = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(113780);
                    return 0;
                case 4:
                    akj.Width = aVar3.BTU.vd();
                    AppMethodBeat.o(113780);
                    return 0;
                case 5:
                    akj.Height = aVar3.BTU.vd();
                    AppMethodBeat.o(113780);
                    return 0;
                case 6:
                    akj.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(113780);
                    return 0;
                case 7:
                    akj.wqd = aVar3.BTU.vd();
                    AppMethodBeat.o(113780);
                    return 0;
                case 8:
                    akj.wqe = aVar3.BTU.vd();
                    AppMethodBeat.o(113780);
                    return 0;
                default:
                    AppMethodBeat.o(113780);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113780);
            return -1;
        }
    }
}
