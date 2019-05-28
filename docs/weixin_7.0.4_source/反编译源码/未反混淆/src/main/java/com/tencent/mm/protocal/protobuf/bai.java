package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bai extends bsr {
    public LinkedList<bak> wEd = new LinkedList();
    public int wEe;
    public String wEf;

    public bai() {
        AppMethodBeat.i(28542);
        AppMethodBeat.o(28542);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28543);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.wEd);
            aVar.iz(3, this.wEe);
            if (this.wEf != null) {
                aVar.e(4, this.wEf);
            }
            AppMethodBeat.o(28543);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 8, this.wEd)) + e.a.a.b.b.a.bs(3, this.wEe);
            if (this.wEf != null) {
                ix += e.a.a.b.b.a.f(4, this.wEf);
            }
            AppMethodBeat.o(28543);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wEd.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28543);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bai bai = (bai) objArr[1];
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
                        bai.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28543);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bak bak = new bak();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bak.populateBuilderWithField(aVar4, bak, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bai.wEd.add(bak);
                    }
                    AppMethodBeat.o(28543);
                    return 0;
                case 3:
                    bai.wEe = aVar3.BTU.vd();
                    AppMethodBeat.o(28543);
                    return 0;
                case 4:
                    bai.wEf = aVar3.BTU.readString();
                    AppMethodBeat.o(28543);
                    return 0;
                default:
                    AppMethodBeat.o(28543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28543);
            return -1;
        }
    }
}
