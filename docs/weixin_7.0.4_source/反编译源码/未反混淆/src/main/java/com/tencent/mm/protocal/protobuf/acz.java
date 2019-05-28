package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class acz extends bsr {
    public String guW;
    public String nbs;
    public LinkedList<String> wkE = new LinkedList();
    public LinkedList<String> wkL = new LinkedList();
    public int wkM;

    public acz() {
        AppMethodBeat.i(112426);
        AppMethodBeat.o(112426);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(112427);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 1, this.wkL);
            aVar.e(3, 1, this.wkE);
            if (this.nbs != null) {
                aVar.e(4, this.nbs);
            }
            if (this.guW != null) {
                aVar.e(5, this.guW);
            }
            aVar.iz(6, this.wkM);
            AppMethodBeat.o(112427);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 1, this.wkL)) + e.a.a.a.c(3, 1, this.wkE);
            if (this.nbs != null) {
                ix += e.a.a.b.b.a.f(4, this.nbs);
            }
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(5, this.guW);
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.wkM);
            AppMethodBeat.o(112427);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wkL.clear();
            this.wkE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(112427);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acz acz = (acz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        acz.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(112427);
                    return 0;
                case 2:
                    acz.wkL.add(aVar3.BTU.readString());
                    AppMethodBeat.o(112427);
                    return 0;
                case 3:
                    acz.wkE.add(aVar3.BTU.readString());
                    AppMethodBeat.o(112427);
                    return 0;
                case 4:
                    acz.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(112427);
                    return 0;
                case 5:
                    acz.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(112427);
                    return 0;
                case 6:
                    acz.wkM = aVar3.BTU.vd();
                    AppMethodBeat.o(112427);
                    return 0;
                default:
                    AppMethodBeat.o(112427);
                    return -1;
            }
        } else {
            AppMethodBeat.o(112427);
            return -1;
        }
    }
}
