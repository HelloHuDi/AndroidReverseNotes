package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class je extends bsr {
    public int cHF;
    public String tCi;
    public String vKZ;
    public String vLa;
    public String vLb;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48780);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vKZ != null) {
                aVar.e(2, this.vKZ);
            }
            if (this.vLa != null) {
                aVar.e(3, this.vLa);
            }
            if (this.tCi != null) {
                aVar.e(4, this.tCi);
            }
            if (this.vLb != null) {
                aVar.e(5, this.vLb);
            }
            aVar.iz(7, this.cHF);
            AppMethodBeat.o(48780);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vKZ != null) {
                ix += e.a.a.b.b.a.f(2, this.vKZ);
            }
            if (this.vLa != null) {
                ix += e.a.a.b.b.a.f(3, this.vLa);
            }
            if (this.tCi != null) {
                ix += e.a.a.b.b.a.f(4, this.tCi);
            }
            if (this.vLb != null) {
                ix += e.a.a.b.b.a.f(5, this.vLb);
            }
            int bs = ix + e.a.a.b.b.a.bs(7, this.cHF);
            AppMethodBeat.o(48780);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48780);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            je jeVar = (je) objArr[1];
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
                        jeVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48780);
                    return 0;
                case 2:
                    jeVar.vKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(48780);
                    return 0;
                case 3:
                    jeVar.vLa = aVar3.BTU.readString();
                    AppMethodBeat.o(48780);
                    return 0;
                case 4:
                    jeVar.tCi = aVar3.BTU.readString();
                    AppMethodBeat.o(48780);
                    return 0;
                case 5:
                    jeVar.vLb = aVar3.BTU.readString();
                    AppMethodBeat.o(48780);
                    return 0;
                case 7:
                    jeVar.cHF = aVar3.BTU.vd();
                    AppMethodBeat.o(48780);
                    return 0;
                default:
                    AppMethodBeat.o(48780);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48780);
            return -1;
        }
    }
}
