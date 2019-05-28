package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bwv extends bsr {
    public int wCn;
    public LinkedList<bts> wCo = new LinkedList();
    public String wdB;

    public bwv() {
        AppMethodBeat.i(73760);
        AppMethodBeat.o(73760);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73761);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wdB != null) {
                aVar.e(2, this.wdB);
            }
            aVar.iz(3, this.wCn);
            aVar.e(4, 8, this.wCo);
            AppMethodBeat.o(73761);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wdB != null) {
                ix += e.a.a.b.b.a.f(2, this.wdB);
            }
            int bs = (ix + e.a.a.b.b.a.bs(3, this.wCn)) + e.a.a.a.c(4, 8, this.wCo);
            AppMethodBeat.o(73761);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wCo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73761);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwv bwv = (bwv) objArr[1];
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
                        bwv.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(73761);
                    return 0;
                case 2:
                    bwv.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(73761);
                    return 0;
                case 3:
                    bwv.wCn = aVar3.BTU.vd();
                    AppMethodBeat.o(73761);
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
                        bwv.wCo.add(bts);
                    }
                    AppMethodBeat.o(73761);
                    return 0;
                default:
                    AppMethodBeat.o(73761);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73761);
            return -1;
        }
    }
}
