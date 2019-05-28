package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class nf extends bsr {
    public int pdi;
    public LinkedList<btx> vRM = new LinkedList();
    public String vRN;

    public nf() {
        AppMethodBeat.i(56737);
        AppMethodBeat.o(56737);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56738);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.pdi);
            aVar.e(3, 8, this.vRM);
            if (this.vRN != null) {
                aVar.e(4, this.vRN);
            }
            AppMethodBeat.o(56738);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.pdi)) + e.a.a.a.c(3, 8, this.vRM);
            if (this.vRN != null) {
                ix += e.a.a.b.b.a.f(4, this.vRN);
            }
            AppMethodBeat.o(56738);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vRM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56738);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            nf nfVar = (nf) objArr[1];
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
                        nfVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56738);
                    return 0;
                case 2:
                    nfVar.pdi = aVar3.BTU.vd();
                    AppMethodBeat.o(56738);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btx btx = new btx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btx.populateBuilderWithField(aVar4, btx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        nfVar.vRM.add(btx);
                    }
                    AppMethodBeat.o(56738);
                    return 0;
                case 4:
                    nfVar.vRN = aVar3.BTU.readString();
                    AppMethodBeat.o(56738);
                    return 0;
                default:
                    AppMethodBeat.o(56738);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56738);
            return -1;
        }
    }
}
