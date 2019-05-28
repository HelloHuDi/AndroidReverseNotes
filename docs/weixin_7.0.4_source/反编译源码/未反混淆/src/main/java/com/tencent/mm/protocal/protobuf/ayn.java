package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ayn extends bsr {
    public int wCn;
    public LinkedList<bts> wCo = new LinkedList();
    public int wCp;
    public LinkedList<bts> wCq = new LinkedList();
    public String wdB;

    public ayn() {
        AppMethodBeat.i(73733);
        AppMethodBeat.o(73733);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73734);
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
            aVar.iz(5, this.wCp);
            aVar.e(6, 8, this.wCq);
            AppMethodBeat.o(73734);
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
            int bs = (((ix + e.a.a.b.b.a.bs(3, this.wCn)) + e.a.a.a.c(4, 8, this.wCo)) + e.a.a.b.b.a.bs(5, this.wCp)) + e.a.a.a.c(6, 8, this.wCq);
            AppMethodBeat.o(73734);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wCo.clear();
            this.wCq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73734);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayn ayn = (ayn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
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
                        ayn.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(73734);
                    return 0;
                case 2:
                    ayn.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(73734);
                    return 0;
                case 3:
                    ayn.wCn = aVar3.BTU.vd();
                    AppMethodBeat.o(73734);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayn.wCo.add(bts);
                    }
                    AppMethodBeat.o(73734);
                    return 0;
                case 5:
                    ayn.wCp = aVar3.BTU.vd();
                    AppMethodBeat.o(73734);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayn.wCq.add(bts);
                    }
                    AppMethodBeat.o(73734);
                    return 0;
                default:
                    AppMethodBeat.o(73734);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73734);
            return -1;
        }
    }
}
