package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bwt extends bsr {
    public String csB;
    public String cxb;
    public String pbn;
    public String vId;
    public LinkedList<Integer> wXf = new LinkedList();
    public String wXg;

    public bwt() {
        AppMethodBeat.i(96285);
        AppMethodBeat.o(96285);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96286);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.csB != null) {
                aVar.e(2, this.csB);
            }
            aVar.e(3, 2, this.wXf);
            if (this.wXg != null) {
                aVar.e(4, this.wXg);
            }
            if (this.vId != null) {
                aVar.e(5, this.vId);
            }
            if (this.cxb != null) {
                aVar.e(6, this.cxb);
            }
            if (this.pbn != null) {
                aVar.e(7, this.pbn);
            }
            AppMethodBeat.o(96286);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(2, this.csB);
            }
            ix += e.a.a.a.c(3, 2, this.wXf);
            if (this.wXg != null) {
                ix += e.a.a.b.b.a.f(4, this.wXg);
            }
            if (this.vId != null) {
                ix += e.a.a.b.b.a.f(5, this.vId);
            }
            if (this.cxb != null) {
                ix += e.a.a.b.b.a.f(6, this.cxb);
            }
            if (this.pbn != null) {
                ix += e.a.a.b.b.a.f(7, this.pbn);
            }
            AppMethodBeat.o(96286);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wXf.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96286);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwt bwt = (bwt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bwt.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(96286);
                    return 0;
                case 2:
                    bwt.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(96286);
                    return 0;
                case 3:
                    bwt.wXf.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(96286);
                    return 0;
                case 4:
                    bwt.wXg = aVar3.BTU.readString();
                    AppMethodBeat.o(96286);
                    return 0;
                case 5:
                    bwt.vId = aVar3.BTU.readString();
                    AppMethodBeat.o(96286);
                    return 0;
                case 6:
                    bwt.cxb = aVar3.BTU.readString();
                    AppMethodBeat.o(96286);
                    return 0;
                case 7:
                    bwt.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(96286);
                    return 0;
                default:
                    AppMethodBeat.o(96286);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96286);
            return -1;
        }
    }
}
