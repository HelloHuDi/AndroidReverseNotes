package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.n */
public final class C33905n extends C1331a {
    public String egm;
    public int kLK;
    public String kLL;
    public String kLM;
    public String kLN;
    public String kLO;
    public int kLP;
    public String kLQ;
    public String kLR;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35540);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.kLK);
            if (this.egm != null) {
                c6093a.mo13475e(2, this.egm);
            }
            if (this.kLL != null) {
                c6093a.mo13475e(3, this.kLL);
            }
            if (this.kLM != null) {
                c6093a.mo13475e(4, this.kLM);
            }
            if (this.kLN != null) {
                c6093a.mo13475e(5, this.kLN);
            }
            if (this.kLO != null) {
                c6093a.mo13475e(6, this.kLO);
            }
            c6093a.mo13480iz(7, this.kLP);
            if (this.kLQ != null) {
                c6093a.mo13475e(8, this.kLQ);
            }
            if (this.kLR != null) {
                c6093a.mo13475e(9, this.kLR);
            }
            AppMethodBeat.m2505o(35540);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.kLK) + 0;
            if (this.egm != null) {
                bs += C6091a.m9575f(2, this.egm);
            }
            if (this.kLL != null) {
                bs += C6091a.m9575f(3, this.kLL);
            }
            if (this.kLM != null) {
                bs += C6091a.m9575f(4, this.kLM);
            }
            if (this.kLN != null) {
                bs += C6091a.m9575f(5, this.kLN);
            }
            if (this.kLO != null) {
                bs += C6091a.m9575f(6, this.kLO);
            }
            bs += C6091a.m9572bs(7, this.kLP);
            if (this.kLQ != null) {
                bs += C6091a.m9575f(8, this.kLQ);
            }
            if (this.kLR != null) {
                bs += C6091a.m9575f(9, this.kLR);
            }
            AppMethodBeat.m2505o(35540);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35540);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C33905n c33905n = (C33905n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c33905n.kLK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35540);
                    return 0;
                case 2:
                    c33905n.egm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35540);
                    return 0;
                case 3:
                    c33905n.kLL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35540);
                    return 0;
                case 4:
                    c33905n.kLM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35540);
                    return 0;
                case 5:
                    c33905n.kLN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35540);
                    return 0;
                case 6:
                    c33905n.kLO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35540);
                    return 0;
                case 7:
                    c33905n.kLP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35540);
                    return 0;
                case 8:
                    c33905n.kLQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35540);
                    return 0;
                case 9:
                    c33905n.kLR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35540);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35540);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35540);
            return -1;
        }
    }
}
