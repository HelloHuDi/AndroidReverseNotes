package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cwr extends bsr {
    public String appId;
    public LinkedList<bbm> xsn = new LinkedList();

    public cwr() {
        AppMethodBeat.i(115001);
        AppMethodBeat.o(115001);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115002);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.appId != null) {
                aVar.e(2, this.appId);
            }
            aVar.e(3, 8, this.xsn);
            AppMethodBeat.o(115002);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.appId != null) {
                ix += e.a.a.b.b.a.f(2, this.appId);
            }
            int c = ix + e.a.a.a.c(3, 8, this.xsn);
            AppMethodBeat.o(115002);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xsn.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115002);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwr cwr = (cwr) objArr[1];
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
                        cwr.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(115002);
                    return 0;
                case 2:
                    cwr.appId = aVar3.BTU.readString();
                    AppMethodBeat.o(115002);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbm bbm = new bbm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbm.populateBuilderWithField(aVar4, bbm, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cwr.xsn.add(bbm);
                    }
                    AppMethodBeat.o(115002);
                    return 0;
                default:
                    AppMethodBeat.o(115002);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115002);
            return -1;
        }
    }
}
