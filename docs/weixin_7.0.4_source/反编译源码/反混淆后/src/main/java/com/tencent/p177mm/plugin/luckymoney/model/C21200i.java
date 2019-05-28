package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.i */
public final class C21200i extends C1331a {
    public int kCv;
    public int nRO;
    public double nRP;
    public double nRQ;
    public double nRR;
    public double nRS;
    public String nRT;
    public String nRU;
    public String nWH;
    public String nWI;
    public int nWJ;
    public String nWK;
    public String nWL;
    public String nWM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56609);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.nRO);
            c6093a.mo13476f(2, this.nRR);
            if (this.nWH != null) {
                c6093a.mo13475e(3, this.nWH);
            }
            if (this.nWI != null) {
                c6093a.mo13475e(4, this.nWI);
            }
            c6093a.mo13476f(5, this.nRP);
            c6093a.mo13476f(6, this.nRS);
            c6093a.mo13476f(7, this.nRQ);
            c6093a.mo13480iz(8, this.nWJ);
            c6093a.mo13480iz(9, this.kCv);
            if (this.nRT != null) {
                c6093a.mo13475e(10, this.nRT);
            }
            if (this.nRU != null) {
                c6093a.mo13475e(11, this.nRU);
            }
            if (this.nWK != null) {
                c6093a.mo13475e(12, this.nWK);
            }
            if (this.nWL != null) {
                c6093a.mo13475e(13, this.nWL);
            }
            if (this.nWM != null) {
                c6093a.mo13475e(14, this.nWM);
            }
            AppMethodBeat.m2505o(56609);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.nRO) + 0) + (C6091a.m9576fv(2) + 8);
            if (this.nWH != null) {
                bs += C6091a.m9575f(3, this.nWH);
            }
            if (this.nWI != null) {
                bs += C6091a.m9575f(4, this.nWI);
            }
            bs = ((((bs + (C6091a.m9576fv(5) + 8)) + (C6091a.m9576fv(6) + 8)) + (C6091a.m9576fv(7) + 8)) + C6091a.m9572bs(8, this.nWJ)) + C6091a.m9572bs(9, this.kCv);
            if (this.nRT != null) {
                bs += C6091a.m9575f(10, this.nRT);
            }
            if (this.nRU != null) {
                bs += C6091a.m9575f(11, this.nRU);
            }
            if (this.nWK != null) {
                bs += C6091a.m9575f(12, this.nWK);
            }
            if (this.nWL != null) {
                bs += C6091a.m9575f(13, this.nWL);
            }
            if (this.nWM != null) {
                bs += C6091a.m9575f(14, this.nWM);
            }
            AppMethodBeat.m2505o(56609);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56609);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C21200i c21200i = (C21200i) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c21200i.nRO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 2:
                    c21200i.nRR = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 3:
                    c21200i.nWH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 4:
                    c21200i.nWI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 5:
                    c21200i.nRP = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 6:
                    c21200i.nRS = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 7:
                    c21200i.nRQ = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 8:
                    c21200i.nWJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 9:
                    c21200i.kCv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 10:
                    c21200i.nRT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 11:
                    c21200i.nRU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 12:
                    c21200i.nWK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 13:
                    c21200i.nWL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                case 14:
                    c21200i.nWM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56609);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56609);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56609);
            return -1;
        }
    }
}
