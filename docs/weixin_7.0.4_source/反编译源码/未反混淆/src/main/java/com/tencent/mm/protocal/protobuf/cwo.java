package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cwo extends bsr {
    public LinkedList<cwt> xsk = new LinkedList();
    public brr xsl;

    public cwo() {
        AppMethodBeat.i(96326);
        AppMethodBeat.o(96326);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96327);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.xsk);
            if (this.xsl != null) {
                aVar.iy(3, this.xsl.computeSize());
                this.xsl.writeFields(aVar);
            }
            AppMethodBeat.o(96327);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.xsk);
            if (this.xsl != null) {
                ix += e.a.a.a.ix(3, this.xsl.computeSize());
            }
            AppMethodBeat.o(96327);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xsk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96327);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwo cwo = (cwo) objArr[1];
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
                        cwo.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(96327);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwt cwt = new cwt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwt.populateBuilderWithField(aVar4, cwt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cwo.xsk.add(cwt);
                    }
                    AppMethodBeat.o(96327);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brr brr = new brr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brr.populateBuilderWithField(aVar4, brr, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cwo.xsl = brr;
                    }
                    AppMethodBeat.o(96327);
                    return 0;
                default:
                    AppMethodBeat.o(96327);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96327);
            return -1;
        }
    }
}
