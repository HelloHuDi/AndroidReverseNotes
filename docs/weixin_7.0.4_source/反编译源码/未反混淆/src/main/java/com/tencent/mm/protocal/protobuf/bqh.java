package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bqh extends a {
    public bts wSA;
    public int wSB;
    public LinkedList<bvn> wSC = new LinkedList();

    public bqh() {
        AppMethodBeat.i(14738);
        AppMethodBeat.o(14738);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14739);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wSA == null) {
                bVar = new b("Not all required fields were included: GroupName");
                AppMethodBeat.o(14739);
                throw bVar;
            }
            if (this.wSA != null) {
                aVar.iy(1, this.wSA.computeSize());
                this.wSA.writeFields(aVar);
            }
            aVar.iz(2, this.wSB);
            aVar.e(3, 8, this.wSC);
            AppMethodBeat.o(14739);
            return 0;
        } else if (i == 1) {
            if (this.wSA != null) {
                ix = e.a.a.a.ix(1, this.wSA.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (ix + e.a.a.b.b.a.bs(2, this.wSB)) + e.a.a.a.c(3, 8, this.wSC);
            AppMethodBeat.o(14739);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wSC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wSA == null) {
                bVar = new b("Not all required fields were included: GroupName");
                AppMethodBeat.o(14739);
                throw bVar;
            }
            AppMethodBeat.o(14739);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqh bqh = (bqh) objArr[1];
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
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bqh.wSA = bts;
                    }
                    AppMethodBeat.o(14739);
                    return 0;
                case 2:
                    bqh.wSB = aVar3.BTU.vd();
                    AppMethodBeat.o(14739);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvn bvn = new bvn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvn.populateBuilderWithField(aVar4, bvn, a.getNextFieldNumber(aVar4))) {
                        }
                        bqh.wSC.add(bvn);
                    }
                    AppMethodBeat.o(14739);
                    return 0;
                default:
                    AppMethodBeat.o(14739);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14739);
            return -1;
        }
    }
}
