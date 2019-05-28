package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.r */
public final class C21206r extends C1331a {
    public int cRT;
    public String nSX;
    public String nWR;
    public long nWU;
    public long nWW;
    public String nWX;
    public String nXL;
    public long nXM;
    public String nXN;
    public String nXO;
    public String nXP;
    public long nXQ;
    public int nXR;
    public int nXi;
    public int status;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56614);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nXL != null) {
                c6093a.mo13475e(1, this.nXL);
            }
            if (this.nWR != null) {
                c6093a.mo13475e(2, this.nWR);
            }
            c6093a.mo13472ai(3, this.nXM);
            if (this.nXN != null) {
                c6093a.mo13475e(4, this.nXN);
            }
            c6093a.mo13480iz(5, this.cRT);
            if (this.nXO != null) {
                c6093a.mo13475e(6, this.nXO);
            }
            if (this.nXP != null) {
                c6093a.mo13475e(7, this.nXP);
            }
            c6093a.mo13472ai(8, this.nWW);
            c6093a.mo13472ai(9, this.nXQ);
            c6093a.mo13472ai(10, this.nWU);
            c6093a.mo13480iz(11, this.status);
            c6093a.mo13480iz(12, this.nXR);
            if (this.nWX != null) {
                c6093a.mo13475e(13, this.nWX);
            }
            if (this.nSX != null) {
                c6093a.mo13475e(14, this.nSX);
            }
            c6093a.mo13480iz(15, this.nXi);
            AppMethodBeat.m2505o(56614);
            return 0;
        } else if (i == 1) {
            if (this.nXL != null) {
                f = C6091a.m9575f(1, this.nXL) + 0;
            } else {
                f = 0;
            }
            if (this.nWR != null) {
                f += C6091a.m9575f(2, this.nWR);
            }
            f += C6091a.m9578o(3, this.nXM);
            if (this.nXN != null) {
                f += C6091a.m9575f(4, this.nXN);
            }
            f += C6091a.m9572bs(5, this.cRT);
            if (this.nXO != null) {
                f += C6091a.m9575f(6, this.nXO);
            }
            if (this.nXP != null) {
                f += C6091a.m9575f(7, this.nXP);
            }
            f = ((((f + C6091a.m9578o(8, this.nWW)) + C6091a.m9578o(9, this.nXQ)) + C6091a.m9578o(10, this.nWU)) + C6091a.m9572bs(11, this.status)) + C6091a.m9572bs(12, this.nXR);
            if (this.nWX != null) {
                f += C6091a.m9575f(13, this.nWX);
            }
            if (this.nSX != null) {
                f += C6091a.m9575f(14, this.nSX);
            }
            int bs = f + C6091a.m9572bs(15, this.nXi);
            AppMethodBeat.m2505o(56614);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56614);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C21206r c21206r = (C21206r) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c21206r.nXL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 2:
                    c21206r.nWR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 3:
                    c21206r.nXM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 4:
                    c21206r.nXN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 5:
                    c21206r.cRT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 6:
                    c21206r.nXO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 7:
                    c21206r.nXP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 8:
                    c21206r.nWW = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 9:
                    c21206r.nXQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 10:
                    c21206r.nWU = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 11:
                    c21206r.status = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 12:
                    c21206r.nXR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 13:
                    c21206r.nWX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 14:
                    c21206r.nSX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                case 15:
                    c21206r.nXi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56614);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56614);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56614);
            return -1;
        }
    }
}
