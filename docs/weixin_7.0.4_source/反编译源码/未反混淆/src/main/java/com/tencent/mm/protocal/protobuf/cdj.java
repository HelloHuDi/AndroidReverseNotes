package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cdj extends bsr {
    public String ndF;
    public String ndG;
    public String vFF;
    public int xcZ;
    public int xda;
    public LinkedList<cdl> xdb = new LinkedList();
    public cdi xdc;
    public int xdd;
    public LinkedList<cdi> xde = new LinkedList();

    public cdj() {
        AppMethodBeat.i(80191);
        AppMethodBeat.o(80191);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80192);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.xcZ);
            if (this.ndG != null) {
                aVar.e(3, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(4, this.ndF);
            }
            if (this.vFF != null) {
                aVar.e(5, this.vFF);
            }
            aVar.iz(6, this.xda);
            aVar.e(7, 8, this.xdb);
            if (this.xdc != null) {
                aVar.iy(8, this.xdc.computeSize());
                this.xdc.writeFields(aVar);
            }
            aVar.iz(9, this.xdd);
            aVar.e(10, 8, this.xde);
            AppMethodBeat.o(80192);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.xcZ);
            if (this.ndG != null) {
                ix += e.a.a.b.b.a.f(3, this.ndG);
            }
            if (this.ndF != null) {
                ix += e.a.a.b.b.a.f(4, this.ndF);
            }
            if (this.vFF != null) {
                ix += e.a.a.b.b.a.f(5, this.vFF);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.xda)) + e.a.a.a.c(7, 8, this.xdb);
            if (this.xdc != null) {
                ix += e.a.a.a.ix(8, this.xdc.computeSize());
            }
            int bs = (ix + e.a.a.b.b.a.bs(9, this.xdd)) + e.a.a.a.c(10, 8, this.xde);
            AppMethodBeat.o(80192);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdb.clear();
            this.xde.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80192);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cdj cdj = (cdj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cdi cdi;
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
                        cdj.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80192);
                    return 0;
                case 2:
                    cdj.xcZ = aVar3.BTU.vd();
                    AppMethodBeat.o(80192);
                    return 0;
                case 3:
                    cdj.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(80192);
                    return 0;
                case 4:
                    cdj.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(80192);
                    return 0;
                case 5:
                    cdj.vFF = aVar3.BTU.readString();
                    AppMethodBeat.o(80192);
                    return 0;
                case 6:
                    cdj.xda = aVar3.BTU.vd();
                    AppMethodBeat.o(80192);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdl cdl = new cdl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdl.populateBuilderWithField(aVar4, cdl, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cdj.xdb.add(cdl);
                    }
                    AppMethodBeat.o(80192);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdi = new cdi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdi.populateBuilderWithField(aVar4, cdi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cdj.xdc = cdi;
                    }
                    AppMethodBeat.o(80192);
                    return 0;
                case 9:
                    cdj.xdd = aVar3.BTU.vd();
                    AppMethodBeat.o(80192);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdi = new cdi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdi.populateBuilderWithField(aVar4, cdi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cdj.xde.add(cdi);
                    }
                    AppMethodBeat.o(80192);
                    return 0;
                default:
                    AppMethodBeat.o(80192);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80192);
            return -1;
        }
    }
}
