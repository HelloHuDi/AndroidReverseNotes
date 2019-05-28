package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agn extends bsr {
    public int cME;
    public String kKO;
    public String kLv;
    public String sign;
    public String vBu;
    public String vBv;
    public int vBw;
    public LinkedList<nx> vBz = new LinkedList();
    public String wni;

    public agn() {
        AppMethodBeat.i(89079);
        AppMethodBeat.o(89079);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89080);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.vBz);
            aVar.iz(3, this.cME);
            if (this.kLv != null) {
                aVar.e(4, this.kLv);
            }
            if (this.kKO != null) {
                aVar.e(5, this.kKO);
            }
            if (this.sign != null) {
                aVar.e(6, this.sign);
            }
            if (this.vBu != null) {
                aVar.e(7, this.vBu);
            }
            if (this.vBv != null) {
                aVar.e(8, this.vBv);
            }
            if (this.wni != null) {
                aVar.e(9, this.wni);
            }
            aVar.iz(10, this.vBw);
            AppMethodBeat.o(89080);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 8, this.vBz)) + e.a.a.b.b.a.bs(3, this.cME);
            if (this.kLv != null) {
                ix += e.a.a.b.b.a.f(4, this.kLv);
            }
            if (this.kKO != null) {
                ix += e.a.a.b.b.a.f(5, this.kKO);
            }
            if (this.sign != null) {
                ix += e.a.a.b.b.a.f(6, this.sign);
            }
            if (this.vBu != null) {
                ix += e.a.a.b.b.a.f(7, this.vBu);
            }
            if (this.vBv != null) {
                ix += e.a.a.b.b.a.f(8, this.vBv);
            }
            if (this.wni != null) {
                ix += e.a.a.b.b.a.f(9, this.wni);
            }
            int bs = ix + e.a.a.b.b.a.bs(10, this.vBw);
            AppMethodBeat.o(89080);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vBz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89080);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agn agn = (agn) objArr[1];
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
                        agn.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(89080);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nx nxVar = new nx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nxVar.populateBuilderWithField(aVar4, nxVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agn.vBz.add(nxVar);
                    }
                    AppMethodBeat.o(89080);
                    return 0;
                case 3:
                    agn.cME = aVar3.BTU.vd();
                    AppMethodBeat.o(89080);
                    return 0;
                case 4:
                    agn.kLv = aVar3.BTU.readString();
                    AppMethodBeat.o(89080);
                    return 0;
                case 5:
                    agn.kKO = aVar3.BTU.readString();
                    AppMethodBeat.o(89080);
                    return 0;
                case 6:
                    agn.sign = aVar3.BTU.readString();
                    AppMethodBeat.o(89080);
                    return 0;
                case 7:
                    agn.vBu = aVar3.BTU.readString();
                    AppMethodBeat.o(89080);
                    return 0;
                case 8:
                    agn.vBv = aVar3.BTU.readString();
                    AppMethodBeat.o(89080);
                    return 0;
                case 9:
                    agn.wni = aVar3.BTU.readString();
                    AppMethodBeat.o(89080);
                    return 0;
                case 10:
                    agn.vBw = aVar3.BTU.vd();
                    AppMethodBeat.o(89080);
                    return 0;
                default:
                    AppMethodBeat.o(89080);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89080);
            return -1;
        }
    }
}
