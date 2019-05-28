package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvj */
public final class cvj extends C1331a {
    public int Scene;
    public String luQ;
    public cgg tZF;
    public int vOq;
    public long vQd;
    public String vQg;
    public C1332b wCA;
    public int wCu;
    public int wCv = 2;
    public String wCy;
    public C1332b wCz;
    public axy wDI;
    public int wUr;
    public LinkedList<cmg> wWp = new LinkedList();
    public String wkD;
    public LinkedList<C23447tn> xqa = new LinkedList();
    public int xrc;
    public String xro;
    public String xrp;
    public int xrq;
    public LinkedList<String> xrr = new LinkedList();
    public LinkedList<bem> xrs = new LinkedList();
    public caw xrt;
    public C15391vb xru;
    public bkr xrv;

    public cvj() {
        AppMethodBeat.m2504i(124386);
        AppMethodBeat.m2505o(124386);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124387);
        C6092b c6092b;
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wkD == null) {
                c6092b = new C6092b("Not all required fields were included: Keyword");
                AppMethodBeat.m2505o(124387);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.wUr);
            if (this.wkD != null) {
                c6093a.mo13475e(2, this.wkD);
            }
            c6093a.mo13480iz(3, this.vOq);
            c6093a.mo13472ai(4, this.vQd);
            c6093a.mo13480iz(5, this.wCu);
            if (this.wDI != null) {
                c6093a.mo13479iy(6, this.wDI.computeSize());
                this.wDI.writeFields(c6093a);
            }
            c6093a.mo13474e(7, 8, this.wWp);
            c6093a.mo13480iz(8, this.Scene);
            if (this.vQg != null) {
                c6093a.mo13475e(9, this.vQg);
            }
            c6093a.mo13480iz(10, this.xrc);
            if (this.xro != null) {
                c6093a.mo13475e(11, this.xro);
            }
            if (this.xrp != null) {
                c6093a.mo13475e(12, this.xrp);
            }
            c6093a.mo13480iz(13, this.xrq);
            c6093a.mo13474e(14, 1, this.xrr);
            c6093a.mo13480iz(15, this.wCv);
            if (this.tZF != null) {
                c6093a.mo13479iy(16, this.tZF.computeSize());
                this.tZF.writeFields(c6093a);
            }
            c6093a.mo13474e(17, 8, this.xqa);
            c6093a.mo13474e(18, 8, this.xrs);
            if (this.luQ != null) {
                c6093a.mo13475e(19, this.luQ);
            }
            if (this.wCA != null) {
                c6093a.mo13473c(20, this.wCA);
            }
            if (this.wCy != null) {
                c6093a.mo13475e(21, this.wCy);
            }
            if (this.wCz != null) {
                c6093a.mo13473c(22, this.wCz);
            }
            if (this.xrt != null) {
                c6093a.mo13479iy(23, this.xrt.computeSize());
                this.xrt.writeFields(c6093a);
            }
            if (this.xru != null) {
                c6093a.mo13479iy(24, this.xru.computeSize());
                this.xru.writeFields(c6093a);
            }
            if (this.xrv != null) {
                c6093a.mo13479iy(25, this.xrv.computeSize());
                this.xrv.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(124387);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wUr) + 0;
            if (this.wkD != null) {
                bs += C6091a.m9575f(2, this.wkD);
            }
            bs = ((bs + C6091a.m9572bs(3, this.vOq)) + C6091a.m9578o(4, this.vQd)) + C6091a.m9572bs(5, this.wCu);
            if (this.wDI != null) {
                bs += C6087a.m9557ix(6, this.wDI.computeSize());
            }
            bs = (bs + C6087a.m9552c(7, 8, this.wWp)) + C6091a.m9572bs(8, this.Scene);
            if (this.vQg != null) {
                bs += C6091a.m9575f(9, this.vQg);
            }
            bs += C6091a.m9572bs(10, this.xrc);
            if (this.xro != null) {
                bs += C6091a.m9575f(11, this.xro);
            }
            if (this.xrp != null) {
                bs += C6091a.m9575f(12, this.xrp);
            }
            bs = ((bs + C6091a.m9572bs(13, this.xrq)) + C6087a.m9552c(14, 1, this.xrr)) + C6091a.m9572bs(15, this.wCv);
            if (this.tZF != null) {
                bs += C6087a.m9557ix(16, this.tZF.computeSize());
            }
            bs = (bs + C6087a.m9552c(17, 8, this.xqa)) + C6087a.m9552c(18, 8, this.xrs);
            if (this.luQ != null) {
                bs += C6091a.m9575f(19, this.luQ);
            }
            if (this.wCA != null) {
                bs += C6091a.m9571b(20, this.wCA);
            }
            if (this.wCy != null) {
                bs += C6091a.m9575f(21, this.wCy);
            }
            if (this.wCz != null) {
                bs += C6091a.m9571b(22, this.wCz);
            }
            if (this.xrt != null) {
                bs += C6087a.m9557ix(23, this.xrt.computeSize());
            }
            if (this.xru != null) {
                bs += C6087a.m9557ix(24, this.xru.computeSize());
            }
            if (this.xrv != null) {
                bs += C6087a.m9557ix(25, this.xrv.computeSize());
            }
            AppMethodBeat.m2505o(124387);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wWp.clear();
            this.xrr.clear();
            this.xqa.clear();
            this.xrs.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wkD == null) {
                c6092b = new C6092b("Not all required fields were included: Keyword");
                AppMethodBeat.m2505o(124387);
                throw c6092b;
            }
            AppMethodBeat.m2505o(124387);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvj cvj = (cvj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    cvj.wUr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 2:
                    cvj.wkD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 3:
                    cvj.vOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 4:
                    cvj.vQd = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 5:
                    cvj.wCu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axy.populateBuilderWithField(c6086a3, axy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvj.wDI = axy;
                    }
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmg cmg = new cmg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmg.populateBuilderWithField(c6086a3, cmg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvj.wWp.add(cmg);
                    }
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 8:
                    cvj.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 9:
                    cvj.vQg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 10:
                    cvj.xrc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 11:
                    cvj.xro = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 12:
                    cvj.xrp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 13:
                    cvj.xrq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 14:
                    cvj.xrr.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 15:
                    cvj.wCv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgg cgg = new cgg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgg.populateBuilderWithField(c6086a3, cgg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvj.tZF = cgg;
                    }
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 17:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23447tn c23447tn = new C23447tn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23447tn.populateBuilderWithField(c6086a3, c23447tn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvj.xqa.add(c23447tn);
                    }
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 18:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bem bem = new bem();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bem.populateBuilderWithField(c6086a3, bem, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvj.xrs.add(bem);
                    }
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 19:
                    cvj.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 20:
                    cvj.wCA = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 21:
                    cvj.wCy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 22:
                    cvj.wCz = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        caw caw = new caw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = caw.populateBuilderWithField(c6086a3, caw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvj.xrt = caw;
                    }
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 24:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15391vb c15391vb = new C15391vb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15391vb.populateBuilderWithField(c6086a3, c15391vb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvj.xru = c15391vb;
                    }
                    AppMethodBeat.m2505o(124387);
                    return 0;
                case 25:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkr bkr = new bkr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkr.populateBuilderWithField(c6086a3, bkr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cvj.xrv = bkr;
                    }
                    AppMethodBeat.m2505o(124387);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124387);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124387);
            return -1;
        }
    }
}
