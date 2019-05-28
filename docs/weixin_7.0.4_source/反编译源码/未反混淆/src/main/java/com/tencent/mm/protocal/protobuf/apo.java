package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class apo extends bsr {
    public int Scene;
    public String mZr;
    public LinkedList<bts> vEg = new LinkedList();
    public int wnW;

    public apo() {
        AppMethodBeat.i(28474);
        AppMethodBeat.o(28474);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28475);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.mZr != null) {
                aVar.e(2, this.mZr);
            }
            aVar.iz(3, this.wnW);
            aVar.e(4, 8, this.vEg);
            aVar.iz(5, this.Scene);
            AppMethodBeat.o(28475);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mZr != null) {
                ix += e.a.a.b.b.a.f(2, this.mZr);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(3, this.wnW)) + e.a.a.a.c(4, 8, this.vEg)) + e.a.a.b.b.a.bs(5, this.Scene);
            AppMethodBeat.o(28475);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28475);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            apo apo = (apo) objArr[1];
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
                        apo.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28475);
                    return 0;
                case 2:
                    apo.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(28475);
                    return 0;
                case 3:
                    apo.wnW = aVar3.BTU.vd();
                    AppMethodBeat.o(28475);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        apo.vEg.add(bts);
                    }
                    AppMethodBeat.o(28475);
                    return 0;
                case 5:
                    apo.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28475);
                    return 0;
                default:
                    AppMethodBeat.o(28475);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28475);
            return -1;
        }
    }
}
