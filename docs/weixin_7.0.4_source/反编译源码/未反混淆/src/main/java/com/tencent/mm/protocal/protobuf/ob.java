package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ob extends a {
    public String pbn;
    public String pbo;
    public int state;
    public cgv vCN;
    public btr vCP;
    public String vJS;
    public auj vTA;
    public LinkedList<cgv> vTB = new LinkedList();
    public int vTC;
    public int vTD;

    public ob() {
        AppMethodBeat.i(48789);
        AppMethodBeat.o(48789);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48790);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTA != null) {
                aVar.iy(1, this.vTA.computeSize());
                this.vTA.writeFields(aVar);
            }
            if (this.vCN != null) {
                aVar.iy(2, this.vCN.computeSize());
                this.vCN.writeFields(aVar);
            }
            aVar.e(3, 8, this.vTB);
            if (this.pbo != null) {
                aVar.e(4, this.pbo);
            }
            if (this.pbn != null) {
                aVar.e(5, this.pbn);
            }
            if (this.vCP != null) {
                aVar.iy(6, this.vCP.computeSize());
                this.vCP.writeFields(aVar);
            }
            aVar.iz(7, this.state);
            aVar.iz(8, this.vTC);
            aVar.iz(9, this.vTD);
            if (this.vJS != null) {
                aVar.e(10, this.vJS);
            }
            AppMethodBeat.o(48790);
            return 0;
        } else if (i == 1) {
            if (this.vTA != null) {
                ix = e.a.a.a.ix(1, this.vTA.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vCN != null) {
                ix += e.a.a.a.ix(2, this.vCN.computeSize());
            }
            ix += e.a.a.a.c(3, 8, this.vTB);
            if (this.pbo != null) {
                ix += e.a.a.b.b.a.f(4, this.pbo);
            }
            if (this.pbn != null) {
                ix += e.a.a.b.b.a.f(5, this.pbn);
            }
            if (this.vCP != null) {
                ix += e.a.a.a.ix(6, this.vCP.computeSize());
            }
            ix = ((ix + e.a.a.b.b.a.bs(7, this.state)) + e.a.a.b.b.a.bs(8, this.vTC)) + e.a.a.b.b.a.bs(9, this.vTD);
            if (this.vJS != null) {
                ix += e.a.a.b.b.a.f(10, this.vJS);
            }
            AppMethodBeat.o(48790);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vTB.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48790);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ob obVar = (ob) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cgv cgv;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj auj = new auj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(aVar4, auj, a.getNextFieldNumber(aVar4))) {
                        }
                        obVar.vTA = auj;
                    }
                    AppMethodBeat.o(48790);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        obVar.vCN = cgv;
                    }
                    AppMethodBeat.o(48790);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        obVar.vTB.add(cgv);
                    }
                    AppMethodBeat.o(48790);
                    return 0;
                case 4:
                    obVar.pbo = aVar3.BTU.readString();
                    AppMethodBeat.o(48790);
                    return 0;
                case 5:
                    obVar.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(48790);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(aVar4, btr, a.getNextFieldNumber(aVar4))) {
                        }
                        obVar.vCP = btr;
                    }
                    AppMethodBeat.o(48790);
                    return 0;
                case 7:
                    obVar.state = aVar3.BTU.vd();
                    AppMethodBeat.o(48790);
                    return 0;
                case 8:
                    obVar.vTC = aVar3.BTU.vd();
                    AppMethodBeat.o(48790);
                    return 0;
                case 9:
                    obVar.vTD = aVar3.BTU.vd();
                    AppMethodBeat.o(48790);
                    return 0;
                case 10:
                    obVar.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48790);
                    return 0;
                default:
                    AppMethodBeat.o(48790);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48790);
            return -1;
        }
    }
}
