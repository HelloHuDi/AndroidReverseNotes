package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ckk extends bsr {
    public int boZ;
    public LinkedList<cdb> xip = new LinkedList();

    public ckk() {
        AppMethodBeat.i(96301);
        AppMethodBeat.o(96301);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96302);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.boZ);
            aVar.e(3, 8, this.xip);
            AppMethodBeat.o(96302);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (ix + e.a.a.b.b.a.bs(2, this.boZ)) + e.a.a.a.c(3, 8, this.xip);
            AppMethodBeat.o(96302);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xip.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96302);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ckk ckk = (ckk) objArr[1];
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
                        ckk.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(96302);
                    return 0;
                case 2:
                    ckk.boZ = aVar3.BTU.vd();
                    AppMethodBeat.o(96302);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdb cdb = new cdb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdb.populateBuilderWithField(aVar4, cdb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ckk.xip.add(cdb);
                    }
                    AppMethodBeat.o(96302);
                    return 0;
                default:
                    AppMethodBeat.o(96302);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96302);
            return -1;
        }
    }
}
