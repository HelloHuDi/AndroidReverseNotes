package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cgd extends a {
    public btr vCP;
    public String vJS;
    public bif wVz;
    public auj xff;
    public LinkedList<cgv> xfg = new LinkedList();
    public LinkedList<cgv> xfh = new LinkedList();
    public auj xfi;
    public bqn xfj;
    public btq xfk;

    public cgd() {
        AppMethodBeat.i(48965);
        AppMethodBeat.o(48965);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48966);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xff != null) {
                aVar.iy(1, this.xff.computeSize());
                this.xff.writeFields(aVar);
            }
            aVar.e(2, 8, this.xfg);
            aVar.e(3, 8, this.xfh);
            if (this.xfi != null) {
                aVar.iy(4, this.xfi.computeSize());
                this.xfi.writeFields(aVar);
            }
            if (this.xfj != null) {
                aVar.iy(5, this.xfj.computeSize());
                this.xfj.writeFields(aVar);
            }
            if (this.vJS != null) {
                aVar.e(6, this.vJS);
            }
            if (this.wVz != null) {
                aVar.iy(7, this.wVz.computeSize());
                this.wVz.writeFields(aVar);
            }
            if (this.vCP != null) {
                aVar.iy(8, this.vCP.computeSize());
                this.vCP.writeFields(aVar);
            }
            if (this.xfk != null) {
                aVar.iy(9, this.xfk.computeSize());
                this.xfk.writeFields(aVar);
            }
            AppMethodBeat.o(48966);
            return 0;
        } else if (i == 1) {
            if (this.xff != null) {
                ix = e.a.a.a.ix(1, this.xff.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 8, this.xfg)) + e.a.a.a.c(3, 8, this.xfh);
            if (this.xfi != null) {
                ix += e.a.a.a.ix(4, this.xfi.computeSize());
            }
            if (this.xfj != null) {
                ix += e.a.a.a.ix(5, this.xfj.computeSize());
            }
            if (this.vJS != null) {
                ix += e.a.a.b.b.a.f(6, this.vJS);
            }
            if (this.wVz != null) {
                ix += e.a.a.a.ix(7, this.wVz.computeSize());
            }
            if (this.vCP != null) {
                ix += e.a.a.a.ix(8, this.vCP.computeSize());
            }
            if (this.xfk != null) {
                ix += e.a.a.a.ix(9, this.xfk.computeSize());
            }
            AppMethodBeat.o(48966);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xfg.clear();
            this.xfh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48966);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgd cgd = (cgd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            auj auj;
            e.a.a.a.a aVar4;
            boolean z;
            cgv cgv;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj = new auj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(aVar4, auj, a.getNextFieldNumber(aVar4))) {
                        }
                        cgd.xff = auj;
                    }
                    AppMethodBeat.o(48966);
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
                        cgd.xfg.add(cgv);
                    }
                    AppMethodBeat.o(48966);
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
                        cgd.xfh.add(cgv);
                    }
                    AppMethodBeat.o(48966);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj = new auj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(aVar4, auj, a.getNextFieldNumber(aVar4))) {
                        }
                        cgd.xfi = auj;
                    }
                    AppMethodBeat.o(48966);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqn bqn = new bqn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqn.populateBuilderWithField(aVar4, bqn, a.getNextFieldNumber(aVar4))) {
                        }
                        cgd.xfj = bqn;
                    }
                    AppMethodBeat.o(48966);
                    return 0;
                case 6:
                    cgd.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48966);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bif bif = new bif();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bif.populateBuilderWithField(aVar4, bif, a.getNextFieldNumber(aVar4))) {
                        }
                        cgd.wVz = bif;
                    }
                    AppMethodBeat.o(48966);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(aVar4, btr, a.getNextFieldNumber(aVar4))) {
                        }
                        cgd.vCP = btr;
                    }
                    AppMethodBeat.o(48966);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btq btq = new btq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btq.populateBuilderWithField(aVar4, btq, a.getNextFieldNumber(aVar4))) {
                        }
                        cgd.xfk = btq;
                    }
                    AppMethodBeat.o(48966);
                    return 0;
                default:
                    AppMethodBeat.o(48966);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48966);
            return -1;
        }
    }
}
