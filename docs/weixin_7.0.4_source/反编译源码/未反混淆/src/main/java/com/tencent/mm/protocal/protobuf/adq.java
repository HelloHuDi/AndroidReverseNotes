package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class adq extends a {
    public int bJt;
    public int wlM;
    public LinkedList<za> wlN = new LinkedList();
    public int wlO;

    public adq() {
        AppMethodBeat.i(118196);
        AppMethodBeat.o(118196);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(118197);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wlM);
            aVar.e(2, 8, this.wlN);
            aVar.iz(3, this.wlO);
            aVar.iz(4, this.bJt);
            AppMethodBeat.o(118197);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.wlM) + 0) + e.a.a.a.c(2, 8, this.wlN)) + e.a.a.b.b.a.bs(3, this.wlO)) + e.a.a.b.b.a.bs(4, this.bJt);
            AppMethodBeat.o(118197);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(118197);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adq adq = (adq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    adq.wlM = aVar3.BTU.vd();
                    AppMethodBeat.o(118197);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        za zaVar = new za();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = zaVar.populateBuilderWithField(aVar4, zaVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adq.wlN.add(zaVar);
                    }
                    AppMethodBeat.o(118197);
                    return 0;
                case 3:
                    adq.wlO = aVar3.BTU.vd();
                    AppMethodBeat.o(118197);
                    return 0;
                case 4:
                    adq.bJt = aVar3.BTU.vd();
                    AppMethodBeat.o(118197);
                    return 0;
                default:
                    AppMethodBeat.o(118197);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118197);
            return -1;
        }
    }
}
