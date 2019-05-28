package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.view.d;
import java.util.LinkedList;

public final class bav extends a {
    public String cMm;
    public int cRU;
    public String cvF;
    public int eRu;
    public String ptv;
    public String token;
    public int wEJ;
    public int wFd;
    public int wFe;
    public LinkedList<ayq> wFf = new LinkedList();
    public LinkedList<cco> wFg = new LinkedList();
    public int wFh;
    public long wFi;
    public int wFj;
    public LinkedList<Long> wFk = new LinkedList();
    public int wFl;
    public int wFm;
    public String wFn;
    public int wFo;
    public LinkedList<bts> wFp = new LinkedList();
    public cbp wFq;
    public LinkedList<cbv> wFr = new LinkedList();
    public String wFs;
    public long wFt;
    public String wFu;
    public boolean wFv;
    public cap wFw;
    public String wdB;

    public bav() {
        AppMethodBeat.i(94540);
        AppMethodBeat.o(94540);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94541);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wFd);
            aVar.iz(2, this.wFe);
            aVar.iz(3, this.wEJ);
            if (this.ptv != null) {
                aVar.e(4, this.ptv);
            }
            aVar.e(5, 8, this.wFf);
            aVar.e(6, 8, this.wFg);
            aVar.iz(7, this.wFh);
            aVar.iz(8, this.eRu);
            aVar.ai(9, this.wFi);
            aVar.iz(10, this.wFj);
            aVar.e(11, 3, this.wFk);
            aVar.iz(12, this.wFl);
            aVar.iz(13, this.wFm);
            if (this.token != null) {
                aVar.e(14, this.token);
            }
            if (this.wFn != null) {
                aVar.e(15, this.wFn);
            }
            aVar.iz(16, this.wFo);
            aVar.e(17, 8, this.wFp);
            if (this.wFq != null) {
                aVar.iy(18, this.wFq.computeSize());
                this.wFq.writeFields(aVar);
            }
            if (this.cMm != null) {
                aVar.e(19, this.cMm);
            }
            aVar.e(20, 8, this.wFr);
            if (this.cvF != null) {
                aVar.e(21, this.cvF);
            }
            if (this.wFs != null) {
                aVar.e(22, this.wFs);
            }
            if (this.wdB != null) {
                aVar.e(23, this.wdB);
            }
            aVar.iz(24, this.cRU);
            aVar.ai(25, this.wFt);
            if (this.wFu != null) {
                aVar.e(26, this.wFu);
            }
            aVar.aO(27, this.wFv);
            if (this.wFw != null) {
                aVar.iy(28, this.wFw.computeSize());
                this.wFw.writeFields(aVar);
            }
            AppMethodBeat.o(94541);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.wFd) + 0) + e.a.a.b.b.a.bs(2, this.wFe)) + e.a.a.b.b.a.bs(3, this.wEJ);
            if (this.ptv != null) {
                bs += e.a.a.b.b.a.f(4, this.ptv);
            }
            bs = ((((((((bs + e.a.a.a.c(5, 8, this.wFf)) + e.a.a.a.c(6, 8, this.wFg)) + e.a.a.b.b.a.bs(7, this.wFh)) + e.a.a.b.b.a.bs(8, this.eRu)) + e.a.a.b.b.a.o(9, this.wFi)) + e.a.a.b.b.a.bs(10, this.wFj)) + e.a.a.a.c(11, 3, this.wFk)) + e.a.a.b.b.a.bs(12, this.wFl)) + e.a.a.b.b.a.bs(13, this.wFm);
            if (this.token != null) {
                bs += e.a.a.b.b.a.f(14, this.token);
            }
            if (this.wFn != null) {
                bs += e.a.a.b.b.a.f(15, this.wFn);
            }
            bs = (bs + e.a.a.b.b.a.bs(16, this.wFo)) + e.a.a.a.c(17, 8, this.wFp);
            if (this.wFq != null) {
                bs += e.a.a.a.ix(18, this.wFq.computeSize());
            }
            if (this.cMm != null) {
                bs += e.a.a.b.b.a.f(19, this.cMm);
            }
            bs += e.a.a.a.c(20, 8, this.wFr);
            if (this.cvF != null) {
                bs += e.a.a.b.b.a.f(21, this.cvF);
            }
            if (this.wFs != null) {
                bs += e.a.a.b.b.a.f(22, this.wFs);
            }
            if (this.wdB != null) {
                bs += e.a.a.b.b.a.f(23, this.wdB);
            }
            bs = (bs + e.a.a.b.b.a.bs(24, this.cRU)) + e.a.a.b.b.a.o(25, this.wFt);
            if (this.wFu != null) {
                bs += e.a.a.b.b.a.f(26, this.wFu);
            }
            bs += e.a.a.b.b.a.fv(27) + 1;
            if (this.wFw != null) {
                bs += e.a.a.a.ix(28, this.wFw.computeSize());
            }
            AppMethodBeat.o(94541);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wFf.clear();
            this.wFg.clear();
            this.wFk.clear();
            this.wFp.clear();
            this.wFr.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94541);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bav bav = (bav) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bav.wFd = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 2:
                    bav.wFe = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 3:
                    bav.wEJ = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 4:
                    bav.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(94541);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayq ayq = new ayq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayq.populateBuilderWithField(aVar4, ayq, a.getNextFieldNumber(aVar4))) {
                        }
                        bav.wFf.add(ayq);
                    }
                    AppMethodBeat.o(94541);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cco cco = new cco();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cco.populateBuilderWithField(aVar4, cco, a.getNextFieldNumber(aVar4))) {
                        }
                        bav.wFg.add(cco);
                    }
                    AppMethodBeat.o(94541);
                    return 0;
                case 7:
                    bav.wFh = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 8:
                    bav.eRu = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 9:
                    bav.wFi = aVar3.BTU.ve();
                    AppMethodBeat.o(94541);
                    return 0;
                case 10:
                    bav.wFj = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 11:
                    bav.wFk.add(Long.valueOf(aVar3.BTU.ve()));
                    AppMethodBeat.o(94541);
                    return 0;
                case 12:
                    bav.wFl = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 13:
                    bav.wFm = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 14:
                    bav.token = aVar3.BTU.readString();
                    AppMethodBeat.o(94541);
                    return 0;
                case 15:
                    bav.wFn = aVar3.BTU.readString();
                    AppMethodBeat.o(94541);
                    return 0;
                case 16:
                    bav.wFo = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bav.wFp.add(bts);
                    }
                    AppMethodBeat.o(94541);
                    return 0;
                case 18:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbp cbp = new cbp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbp.populateBuilderWithField(aVar4, cbp, a.getNextFieldNumber(aVar4))) {
                        }
                        bav.wFq = cbp;
                    }
                    AppMethodBeat.o(94541);
                    return 0;
                case 19:
                    bav.cMm = aVar3.BTU.readString();
                    AppMethodBeat.o(94541);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbv cbv = new cbv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbv.populateBuilderWithField(aVar4, cbv, a.getNextFieldNumber(aVar4))) {
                        }
                        bav.wFr.add(cbv);
                    }
                    AppMethodBeat.o(94541);
                    return 0;
                case 21:
                    bav.cvF = aVar3.BTU.readString();
                    AppMethodBeat.o(94541);
                    return 0;
                case 22:
                    bav.wFs = aVar3.BTU.readString();
                    AppMethodBeat.o(94541);
                    return 0;
                case 23:
                    bav.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(94541);
                    return 0;
                case 24:
                    bav.cRU = aVar3.BTU.vd();
                    AppMethodBeat.o(94541);
                    return 0;
                case 25:
                    bav.wFt = aVar3.BTU.ve();
                    AppMethodBeat.o(94541);
                    return 0;
                case 26:
                    bav.wFu = aVar3.BTU.readString();
                    AppMethodBeat.o(94541);
                    return 0;
                case 27:
                    bav.wFv = aVar3.BTU.ehX();
                    AppMethodBeat.o(94541);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cap cap = new cap();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cap.populateBuilderWithField(aVar4, cap, a.getNextFieldNumber(aVar4))) {
                        }
                        bav.wFw = cap;
                    }
                    AppMethodBeat.o(94541);
                    return 0;
                default:
                    AppMethodBeat.o(94541);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94541);
            return -1;
        }
    }
}
