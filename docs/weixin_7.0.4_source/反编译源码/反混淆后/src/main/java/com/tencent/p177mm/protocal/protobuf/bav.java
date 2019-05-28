package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bav */
public final class bav extends C1331a {
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
        AppMethodBeat.m2504i(94540);
        AppMethodBeat.m2505o(94540);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94541);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wFd);
            c6093a.mo13480iz(2, this.wFe);
            c6093a.mo13480iz(3, this.wEJ);
            if (this.ptv != null) {
                c6093a.mo13475e(4, this.ptv);
            }
            c6093a.mo13474e(5, 8, this.wFf);
            c6093a.mo13474e(6, 8, this.wFg);
            c6093a.mo13480iz(7, this.wFh);
            c6093a.mo13480iz(8, this.eRu);
            c6093a.mo13472ai(9, this.wFi);
            c6093a.mo13480iz(10, this.wFj);
            c6093a.mo13474e(11, 3, this.wFk);
            c6093a.mo13480iz(12, this.wFl);
            c6093a.mo13480iz(13, this.wFm);
            if (this.token != null) {
                c6093a.mo13475e(14, this.token);
            }
            if (this.wFn != null) {
                c6093a.mo13475e(15, this.wFn);
            }
            c6093a.mo13480iz(16, this.wFo);
            c6093a.mo13474e(17, 8, this.wFp);
            if (this.wFq != null) {
                c6093a.mo13479iy(18, this.wFq.computeSize());
                this.wFq.writeFields(c6093a);
            }
            if (this.cMm != null) {
                c6093a.mo13475e(19, this.cMm);
            }
            c6093a.mo13474e(20, 8, this.wFr);
            if (this.cvF != null) {
                c6093a.mo13475e(21, this.cvF);
            }
            if (this.wFs != null) {
                c6093a.mo13475e(22, this.wFs);
            }
            if (this.wdB != null) {
                c6093a.mo13475e(23, this.wdB);
            }
            c6093a.mo13480iz(24, this.cRU);
            c6093a.mo13472ai(25, this.wFt);
            if (this.wFu != null) {
                c6093a.mo13475e(26, this.wFu);
            }
            c6093a.mo13471aO(27, this.wFv);
            if (this.wFw != null) {
                c6093a.mo13479iy(28, this.wFw.computeSize());
                this.wFw.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94541);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.wFd) + 0) + C6091a.m9572bs(2, this.wFe)) + C6091a.m9572bs(3, this.wEJ);
            if (this.ptv != null) {
                bs += C6091a.m9575f(4, this.ptv);
            }
            bs = ((((((((bs + C6087a.m9552c(5, 8, this.wFf)) + C6087a.m9552c(6, 8, this.wFg)) + C6091a.m9572bs(7, this.wFh)) + C6091a.m9572bs(8, this.eRu)) + C6091a.m9578o(9, this.wFi)) + C6091a.m9572bs(10, this.wFj)) + C6087a.m9552c(11, 3, this.wFk)) + C6091a.m9572bs(12, this.wFl)) + C6091a.m9572bs(13, this.wFm);
            if (this.token != null) {
                bs += C6091a.m9575f(14, this.token);
            }
            if (this.wFn != null) {
                bs += C6091a.m9575f(15, this.wFn);
            }
            bs = (bs + C6091a.m9572bs(16, this.wFo)) + C6087a.m9552c(17, 8, this.wFp);
            if (this.wFq != null) {
                bs += C6087a.m9557ix(18, this.wFq.computeSize());
            }
            if (this.cMm != null) {
                bs += C6091a.m9575f(19, this.cMm);
            }
            bs += C6087a.m9552c(20, 8, this.wFr);
            if (this.cvF != null) {
                bs += C6091a.m9575f(21, this.cvF);
            }
            if (this.wFs != null) {
                bs += C6091a.m9575f(22, this.wFs);
            }
            if (this.wdB != null) {
                bs += C6091a.m9575f(23, this.wdB);
            }
            bs = (bs + C6091a.m9572bs(24, this.cRU)) + C6091a.m9578o(25, this.wFt);
            if (this.wFu != null) {
                bs += C6091a.m9575f(26, this.wFu);
            }
            bs += C6091a.m9576fv(27) + 1;
            if (this.wFw != null) {
                bs += C6087a.m9557ix(28, this.wFw.computeSize());
            }
            AppMethodBeat.m2505o(94541);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wFf.clear();
            this.wFg.clear();
            this.wFk.clear();
            this.wFp.clear();
            this.wFr.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94541);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bav bav = (bav) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bav.wFd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 2:
                    bav.wFe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 3:
                    bav.wEJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 4:
                    bav.ptv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayq ayq = new ayq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayq.populateBuilderWithField(c6086a3, ayq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bav.wFf.add(ayq);
                    }
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cco cco = new cco();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cco.populateBuilderWithField(c6086a3, cco, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bav.wFg.add(cco);
                    }
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 7:
                    bav.wFh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 8:
                    bav.eRu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 9:
                    bav.wFi = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 10:
                    bav.wFj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 11:
                    bav.wFk.add(Long.valueOf(c6086a2.BTU.mo13459ve()));
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 12:
                    bav.wFl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 13:
                    bav.wFm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 14:
                    bav.token = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 15:
                    bav.wFn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 16:
                    bav.wFo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bav.wFp.add(bts);
                    }
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 18:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbp cbp = new cbp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbp.populateBuilderWithField(c6086a3, cbp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bav.wFq = cbp;
                    }
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 19:
                    bav.cMm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbv cbv = new cbv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbv.populateBuilderWithField(c6086a3, cbv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bav.wFr.add(cbv);
                    }
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 21:
                    bav.cvF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 22:
                    bav.wFs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 23:
                    bav.wdB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 24:
                    bav.cRU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 25:
                    bav.wFt = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 26:
                    bav.wFu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case 27:
                    bav.wFv = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(94541);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cap cap = new cap();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cap.populateBuilderWithField(c6086a3, cap, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bav.wFw = cap;
                    }
                    AppMethodBeat.m2505o(94541);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94541);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94541);
            return -1;
        }
    }
}
