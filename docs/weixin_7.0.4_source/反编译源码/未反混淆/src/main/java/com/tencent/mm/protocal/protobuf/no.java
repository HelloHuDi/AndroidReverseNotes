package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class no extends a {
    public String code;
    public int status;
    public int vRU;
    public int vRV;
    public LinkedList<op> vRW = new LinkedList();
    public LinkedList<op> vRX = new LinkedList();
    public LinkedList<op> vRY = new LinkedList();
    public LinkedList<String> vRZ = new LinkedList();
    public int vSa;
    public int vSb;
    public LinkedList<tm> vSc = new LinkedList();
    public long vSd;
    public int vSe;
    public String vSf;
    public tm vSg;
    public LinkedList<ax> vSh = new LinkedList();
    public tm vSi;
    public tm vSj;
    public tm vSk;
    public wz vSl;
    public String vSm;
    public tm vSn;
    public String vSo;
    public tm vSp;
    public boolean vSq;
    public boolean vSr;

    public no() {
        AppMethodBeat.i(89019);
        AppMethodBeat.o(89019);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89020);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.status);
            aVar.iz(2, this.vRU);
            aVar.iz(3, this.vRV);
            aVar.e(4, 8, this.vRW);
            aVar.e(5, 8, this.vRX);
            aVar.e(6, 8, this.vRY);
            aVar.e(7, 1, this.vRZ);
            aVar.iz(8, this.vSa);
            if (this.code != null) {
                aVar.e(9, this.code);
            }
            aVar.iz(10, this.vSb);
            aVar.e(11, 8, this.vSc);
            aVar.ai(12, this.vSd);
            aVar.iz(13, this.vSe);
            if (this.vSf != null) {
                aVar.e(14, this.vSf);
            }
            if (this.vSg != null) {
                aVar.iy(15, this.vSg.computeSize());
                this.vSg.writeFields(aVar);
            }
            aVar.e(16, 8, this.vSh);
            if (this.vSi != null) {
                aVar.iy(17, this.vSi.computeSize());
                this.vSi.writeFields(aVar);
            }
            if (this.vSj != null) {
                aVar.iy(18, this.vSj.computeSize());
                this.vSj.writeFields(aVar);
            }
            if (this.vSk != null) {
                aVar.iy(19, this.vSk.computeSize());
                this.vSk.writeFields(aVar);
            }
            if (this.vSl != null) {
                aVar.iy(20, this.vSl.computeSize());
                this.vSl.writeFields(aVar);
            }
            if (this.vSm != null) {
                aVar.e(21, this.vSm);
            }
            if (this.vSn != null) {
                aVar.iy(22, this.vSn.computeSize());
                this.vSn.writeFields(aVar);
            }
            if (this.vSo != null) {
                aVar.e(23, this.vSo);
            }
            if (this.vSp != null) {
                aVar.iy(24, this.vSp.computeSize());
                this.vSp.writeFields(aVar);
            }
            aVar.aO(25, this.vSq);
            aVar.aO(26, this.vSr);
            AppMethodBeat.o(89020);
            return 0;
        } else if (i == 1) {
            bs = (((((((e.a.a.b.b.a.bs(1, this.status) + 0) + e.a.a.b.b.a.bs(2, this.vRU)) + e.a.a.b.b.a.bs(3, this.vRV)) + e.a.a.a.c(4, 8, this.vRW)) + e.a.a.a.c(5, 8, this.vRX)) + e.a.a.a.c(6, 8, this.vRY)) + e.a.a.a.c(7, 1, this.vRZ)) + e.a.a.b.b.a.bs(8, this.vSa);
            if (this.code != null) {
                bs += e.a.a.b.b.a.f(9, this.code);
            }
            bs = (((bs + e.a.a.b.b.a.bs(10, this.vSb)) + e.a.a.a.c(11, 8, this.vSc)) + e.a.a.b.b.a.o(12, this.vSd)) + e.a.a.b.b.a.bs(13, this.vSe);
            if (this.vSf != null) {
                bs += e.a.a.b.b.a.f(14, this.vSf);
            }
            if (this.vSg != null) {
                bs += e.a.a.a.ix(15, this.vSg.computeSize());
            }
            bs += e.a.a.a.c(16, 8, this.vSh);
            if (this.vSi != null) {
                bs += e.a.a.a.ix(17, this.vSi.computeSize());
            }
            if (this.vSj != null) {
                bs += e.a.a.a.ix(18, this.vSj.computeSize());
            }
            if (this.vSk != null) {
                bs += e.a.a.a.ix(19, this.vSk.computeSize());
            }
            if (this.vSl != null) {
                bs += e.a.a.a.ix(20, this.vSl.computeSize());
            }
            if (this.vSm != null) {
                bs += e.a.a.b.b.a.f(21, this.vSm);
            }
            if (this.vSn != null) {
                bs += e.a.a.a.ix(22, this.vSn.computeSize());
            }
            if (this.vSo != null) {
                bs += e.a.a.b.b.a.f(23, this.vSo);
            }
            if (this.vSp != null) {
                bs += e.a.a.a.ix(24, this.vSp.computeSize());
            }
            bs = (bs + (e.a.a.b.b.a.fv(25) + 1)) + (e.a.a.b.b.a.fv(26) + 1);
            AppMethodBeat.o(89020);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vRW.clear();
            this.vRX.clear();
            this.vRY.clear();
            this.vRZ.clear();
            this.vSc.clear();
            this.vSh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89020);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            no noVar = (no) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            op opVar;
            e.a.a.a.a aVar4;
            boolean z;
            tm tmVar;
            switch (intValue) {
                case 1:
                    noVar.status = aVar3.BTU.vd();
                    AppMethodBeat.o(89020);
                    return 0;
                case 2:
                    noVar.vRU = aVar3.BTU.vd();
                    AppMethodBeat.o(89020);
                    return 0;
                case 3:
                    noVar.vRV = aVar3.BTU.vd();
                    AppMethodBeat.o(89020);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        opVar = new op();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = opVar.populateBuilderWithField(aVar4, opVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vRW.add(opVar);
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        opVar = new op();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = opVar.populateBuilderWithField(aVar4, opVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vRX.add(opVar);
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        opVar = new op();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = opVar.populateBuilderWithField(aVar4, opVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vRY.add(opVar);
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 7:
                    noVar.vRZ.add(aVar3.BTU.readString());
                    AppMethodBeat.o(89020);
                    return 0;
                case 8:
                    noVar.vSa = aVar3.BTU.vd();
                    AppMethodBeat.o(89020);
                    return 0;
                case 9:
                    noVar.code = aVar3.BTU.readString();
                    AppMethodBeat.o(89020);
                    return 0;
                case 10:
                    noVar.vSb = aVar3.BTU.vd();
                    AppMethodBeat.o(89020);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vSc.add(tmVar);
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 12:
                    noVar.vSd = aVar3.BTU.ve();
                    AppMethodBeat.o(89020);
                    return 0;
                case 13:
                    noVar.vSe = aVar3.BTU.vd();
                    AppMethodBeat.o(89020);
                    return 0;
                case 14:
                    noVar.vSf = aVar3.BTU.readString();
                    AppMethodBeat.o(89020);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vSg = tmVar;
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ax axVar = new ax();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axVar.populateBuilderWithField(aVar4, axVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vSh.add(axVar);
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vSi = tmVar;
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 18:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vSj = tmVar;
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 19:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vSk = tmVar;
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        wz wzVar = new wz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wzVar.populateBuilderWithField(aVar4, wzVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vSl = wzVar;
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 21:
                    noVar.vSm = aVar3.BTU.readString();
                    AppMethodBeat.o(89020);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vSn = tmVar;
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 23:
                    noVar.vSo = aVar3.BTU.readString();
                    AppMethodBeat.o(89020);
                    return 0;
                case 24:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tmVar = new tm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tmVar.populateBuilderWithField(aVar4, tmVar, a.getNextFieldNumber(aVar4))) {
                        }
                        noVar.vSp = tmVar;
                    }
                    AppMethodBeat.o(89020);
                    return 0;
                case 25:
                    noVar.vSq = aVar3.BTU.ehX();
                    AppMethodBeat.o(89020);
                    return 0;
                case 26:
                    noVar.vSr = aVar3.BTU.ehX();
                    AppMethodBeat.o(89020);
                    return 0;
                default:
                    AppMethodBeat.o(89020);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89020);
            return -1;
        }
    }
}
