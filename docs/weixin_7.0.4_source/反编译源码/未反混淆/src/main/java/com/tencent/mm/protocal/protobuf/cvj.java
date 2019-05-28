package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class cvj extends a {
    public int Scene;
    public String luQ;
    public cgg tZF;
    public int vOq;
    public long vQd;
    public String vQg;
    public b wCA;
    public int wCu;
    public int wCv = 2;
    public String wCy;
    public b wCz;
    public axy wDI;
    public int wUr;
    public LinkedList<cmg> wWp = new LinkedList();
    public String wkD;
    public LinkedList<tn> xqa = new LinkedList();
    public int xrc;
    public String xro;
    public String xrp;
    public int xrq;
    public LinkedList<String> xrr = new LinkedList();
    public LinkedList<bem> xrs = new LinkedList();
    public caw xrt;
    public vb xru;
    public bkr xrv;

    public cvj() {
        AppMethodBeat.i(124386);
        AppMethodBeat.o(124386);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124387);
        e.a.a.b bVar;
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wkD == null) {
                bVar = new e.a.a.b("Not all required fields were included: Keyword");
                AppMethodBeat.o(124387);
                throw bVar;
            }
            aVar.iz(1, this.wUr);
            if (this.wkD != null) {
                aVar.e(2, this.wkD);
            }
            aVar.iz(3, this.vOq);
            aVar.ai(4, this.vQd);
            aVar.iz(5, this.wCu);
            if (this.wDI != null) {
                aVar.iy(6, this.wDI.computeSize());
                this.wDI.writeFields(aVar);
            }
            aVar.e(7, 8, this.wWp);
            aVar.iz(8, this.Scene);
            if (this.vQg != null) {
                aVar.e(9, this.vQg);
            }
            aVar.iz(10, this.xrc);
            if (this.xro != null) {
                aVar.e(11, this.xro);
            }
            if (this.xrp != null) {
                aVar.e(12, this.xrp);
            }
            aVar.iz(13, this.xrq);
            aVar.e(14, 1, this.xrr);
            aVar.iz(15, this.wCv);
            if (this.tZF != null) {
                aVar.iy(16, this.tZF.computeSize());
                this.tZF.writeFields(aVar);
            }
            aVar.e(17, 8, this.xqa);
            aVar.e(18, 8, this.xrs);
            if (this.luQ != null) {
                aVar.e(19, this.luQ);
            }
            if (this.wCA != null) {
                aVar.c(20, this.wCA);
            }
            if (this.wCy != null) {
                aVar.e(21, this.wCy);
            }
            if (this.wCz != null) {
                aVar.c(22, this.wCz);
            }
            if (this.xrt != null) {
                aVar.iy(23, this.xrt.computeSize());
                this.xrt.writeFields(aVar);
            }
            if (this.xru != null) {
                aVar.iy(24, this.xru.computeSize());
                this.xru.writeFields(aVar);
            }
            if (this.xrv != null) {
                aVar.iy(25, this.xrv.computeSize());
                this.xrv.writeFields(aVar);
            }
            AppMethodBeat.o(124387);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wUr) + 0;
            if (this.wkD != null) {
                bs += e.a.a.b.b.a.f(2, this.wkD);
            }
            bs = ((bs + e.a.a.b.b.a.bs(3, this.vOq)) + e.a.a.b.b.a.o(4, this.vQd)) + e.a.a.b.b.a.bs(5, this.wCu);
            if (this.wDI != null) {
                bs += e.a.a.a.ix(6, this.wDI.computeSize());
            }
            bs = (bs + e.a.a.a.c(7, 8, this.wWp)) + e.a.a.b.b.a.bs(8, this.Scene);
            if (this.vQg != null) {
                bs += e.a.a.b.b.a.f(9, this.vQg);
            }
            bs += e.a.a.b.b.a.bs(10, this.xrc);
            if (this.xro != null) {
                bs += e.a.a.b.b.a.f(11, this.xro);
            }
            if (this.xrp != null) {
                bs += e.a.a.b.b.a.f(12, this.xrp);
            }
            bs = ((bs + e.a.a.b.b.a.bs(13, this.xrq)) + e.a.a.a.c(14, 1, this.xrr)) + e.a.a.b.b.a.bs(15, this.wCv);
            if (this.tZF != null) {
                bs += e.a.a.a.ix(16, this.tZF.computeSize());
            }
            bs = (bs + e.a.a.a.c(17, 8, this.xqa)) + e.a.a.a.c(18, 8, this.xrs);
            if (this.luQ != null) {
                bs += e.a.a.b.b.a.f(19, this.luQ);
            }
            if (this.wCA != null) {
                bs += e.a.a.b.b.a.b(20, this.wCA);
            }
            if (this.wCy != null) {
                bs += e.a.a.b.b.a.f(21, this.wCy);
            }
            if (this.wCz != null) {
                bs += e.a.a.b.b.a.b(22, this.wCz);
            }
            if (this.xrt != null) {
                bs += e.a.a.a.ix(23, this.xrt.computeSize());
            }
            if (this.xru != null) {
                bs += e.a.a.a.ix(24, this.xru.computeSize());
            }
            if (this.xrv != null) {
                bs += e.a.a.a.ix(25, this.xrv.computeSize());
            }
            AppMethodBeat.o(124387);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wWp.clear();
            this.xrr.clear();
            this.xqa.clear();
            this.xrs.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wkD == null) {
                bVar = new e.a.a.b("Not all required fields were included: Keyword");
                AppMethodBeat.o(124387);
                throw bVar;
            }
            AppMethodBeat.o(124387);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvj cvj = (cvj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cvj.wUr = aVar3.BTU.vd();
                    AppMethodBeat.o(124387);
                    return 0;
                case 2:
                    cvj.wkD = aVar3.BTU.readString();
                    AppMethodBeat.o(124387);
                    return 0;
                case 3:
                    cvj.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(124387);
                    return 0;
                case 4:
                    cvj.vQd = aVar3.BTU.ve();
                    AppMethodBeat.o(124387);
                    return 0;
                case 5:
                    cvj.wCu = aVar3.BTU.vd();
                    AppMethodBeat.o(124387);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axy.populateBuilderWithField(aVar4, axy, a.getNextFieldNumber(aVar4))) {
                        }
                        cvj.wDI = axy;
                    }
                    AppMethodBeat.o(124387);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmg cmg = new cmg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmg.populateBuilderWithField(aVar4, cmg, a.getNextFieldNumber(aVar4))) {
                        }
                        cvj.wWp.add(cmg);
                    }
                    AppMethodBeat.o(124387);
                    return 0;
                case 8:
                    cvj.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124387);
                    return 0;
                case 9:
                    cvj.vQg = aVar3.BTU.readString();
                    AppMethodBeat.o(124387);
                    return 0;
                case 10:
                    cvj.xrc = aVar3.BTU.vd();
                    AppMethodBeat.o(124387);
                    return 0;
                case 11:
                    cvj.xro = aVar3.BTU.readString();
                    AppMethodBeat.o(124387);
                    return 0;
                case 12:
                    cvj.xrp = aVar3.BTU.readString();
                    AppMethodBeat.o(124387);
                    return 0;
                case 13:
                    cvj.xrq = aVar3.BTU.vd();
                    AppMethodBeat.o(124387);
                    return 0;
                case 14:
                    cvj.xrr.add(aVar3.BTU.readString());
                    AppMethodBeat.o(124387);
                    return 0;
                case 15:
                    cvj.wCv = aVar3.BTU.vd();
                    AppMethodBeat.o(124387);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgg cgg = new cgg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgg.populateBuilderWithField(aVar4, cgg, a.getNextFieldNumber(aVar4))) {
                        }
                        cvj.tZF = cgg;
                    }
                    AppMethodBeat.o(124387);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tn tnVar = new tn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tnVar.populateBuilderWithField(aVar4, tnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cvj.xqa.add(tnVar);
                    }
                    AppMethodBeat.o(124387);
                    return 0;
                case 18:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bem bem = new bem();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bem.populateBuilderWithField(aVar4, bem, a.getNextFieldNumber(aVar4))) {
                        }
                        cvj.xrs.add(bem);
                    }
                    AppMethodBeat.o(124387);
                    return 0;
                case 19:
                    cvj.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(124387);
                    return 0;
                case 20:
                    cvj.wCA = aVar3.BTU.emu();
                    AppMethodBeat.o(124387);
                    return 0;
                case 21:
                    cvj.wCy = aVar3.BTU.readString();
                    AppMethodBeat.o(124387);
                    return 0;
                case 22:
                    cvj.wCz = aVar3.BTU.emu();
                    AppMethodBeat.o(124387);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        caw caw = new caw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caw.populateBuilderWithField(aVar4, caw, a.getNextFieldNumber(aVar4))) {
                        }
                        cvj.xrt = caw;
                    }
                    AppMethodBeat.o(124387);
                    return 0;
                case 24:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        vb vbVar = new vb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vbVar.populateBuilderWithField(aVar4, vbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cvj.xru = vbVar;
                    }
                    AppMethodBeat.o(124387);
                    return 0;
                case 25:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkr bkr = new bkr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkr.populateBuilderWithField(aVar4, bkr, a.getNextFieldNumber(aVar4))) {
                        }
                        cvj.xrv = bkr;
                    }
                    AppMethodBeat.o(124387);
                    return 0;
                default:
                    AppMethodBeat.o(124387);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124387);
            return -1;
        }
    }
}
