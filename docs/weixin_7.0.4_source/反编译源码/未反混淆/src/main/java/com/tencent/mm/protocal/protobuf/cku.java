package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cku extends bsr {
    public int bIb;
    public String ceI;
    public String cws;
    public String fhH;
    public String wWc;
    public int xiA;
    public int xiB;
    public int xiu;
    public int xiv;
    public String xiw;
    public int xix;
    public String xiy;
    public LinkedList<ccz> xiz = new LinkedList();

    public cku() {
        AppMethodBeat.i(55725);
        AppMethodBeat.o(55725);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55726);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ceI != null) {
                aVar.e(2, this.ceI);
            }
            if (this.cws != null) {
                aVar.e(3, this.cws);
            }
            aVar.iz(4, this.xiu);
            aVar.iz(5, this.xiv);
            aVar.iz(6, this.bIb);
            if (this.xiw != null) {
                aVar.e(7, this.xiw);
            }
            if (this.wWc != null) {
                aVar.e(8, this.wWc);
            }
            if (this.fhH != null) {
                aVar.e(9, this.fhH);
            }
            aVar.iz(10, this.xix);
            if (this.xiy != null) {
                aVar.e(11, this.xiy);
            }
            aVar.e(12, 8, this.xiz);
            aVar.iz(13, this.xiA);
            aVar.iz(14, this.xiB);
            AppMethodBeat.o(55726);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ceI != null) {
                ix += e.a.a.b.b.a.f(2, this.ceI);
            }
            if (this.cws != null) {
                ix += e.a.a.b.b.a.f(3, this.cws);
            }
            ix = ((ix + e.a.a.b.b.a.bs(4, this.xiu)) + e.a.a.b.b.a.bs(5, this.xiv)) + e.a.a.b.b.a.bs(6, this.bIb);
            if (this.xiw != null) {
                ix += e.a.a.b.b.a.f(7, this.xiw);
            }
            if (this.wWc != null) {
                ix += e.a.a.b.b.a.f(8, this.wWc);
            }
            if (this.fhH != null) {
                ix += e.a.a.b.b.a.f(9, this.fhH);
            }
            ix += e.a.a.b.b.a.bs(10, this.xix);
            if (this.xiy != null) {
                ix += e.a.a.b.b.a.f(11, this.xiy);
            }
            int c = ((ix + e.a.a.a.c(12, 8, this.xiz)) + e.a.a.b.b.a.bs(13, this.xiA)) + e.a.a.b.b.a.bs(14, this.xiB);
            AppMethodBeat.o(55726);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xiz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55726);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cku cku = (cku) objArr[1];
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
                        cku.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(55726);
                    return 0;
                case 2:
                    cku.ceI = aVar3.BTU.readString();
                    AppMethodBeat.o(55726);
                    return 0;
                case 3:
                    cku.cws = aVar3.BTU.readString();
                    AppMethodBeat.o(55726);
                    return 0;
                case 4:
                    cku.xiu = aVar3.BTU.vd();
                    AppMethodBeat.o(55726);
                    return 0;
                case 5:
                    cku.xiv = aVar3.BTU.vd();
                    AppMethodBeat.o(55726);
                    return 0;
                case 6:
                    cku.bIb = aVar3.BTU.vd();
                    AppMethodBeat.o(55726);
                    return 0;
                case 7:
                    cku.xiw = aVar3.BTU.readString();
                    AppMethodBeat.o(55726);
                    return 0;
                case 8:
                    cku.wWc = aVar3.BTU.readString();
                    AppMethodBeat.o(55726);
                    return 0;
                case 9:
                    cku.fhH = aVar3.BTU.readString();
                    AppMethodBeat.o(55726);
                    return 0;
                case 10:
                    cku.xix = aVar3.BTU.vd();
                    AppMethodBeat.o(55726);
                    return 0;
                case 11:
                    cku.xiy = aVar3.BTU.readString();
                    AppMethodBeat.o(55726);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccz ccz = new ccz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccz.populateBuilderWithField(aVar4, ccz, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cku.xiz.add(ccz);
                    }
                    AppMethodBeat.o(55726);
                    return 0;
                case 13:
                    cku.xiA = aVar3.BTU.vd();
                    AppMethodBeat.o(55726);
                    return 0;
                case 14:
                    cku.xiB = aVar3.BTU.vd();
                    AppMethodBeat.o(55726);
                    return 0;
                default:
                    AppMethodBeat.o(55726);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55726);
            return -1;
        }
    }
}
