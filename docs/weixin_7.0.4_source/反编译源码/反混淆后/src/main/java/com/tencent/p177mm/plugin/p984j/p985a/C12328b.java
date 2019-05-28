package com.tencent.p177mm.plugin.p984j.p985a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.j.a.b */
public final class C12328b extends C1331a {
    public String dtV;
    public int nuH;
    public String nuI;
    public String nuJ;
    public String nuK;
    public String nuL;
    public String nuM;
    public String nuN;
    public String nuO;
    public String nuP;
    public String nuQ;
    public String title;
    public String type;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(21657);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.nuH);
            if (this.type != null) {
                c6093a.mo13475e(2, this.type);
            }
            if (this.title != null) {
                c6093a.mo13475e(3, this.title);
            }
            if (this.nuI != null) {
                c6093a.mo13475e(4, this.nuI);
            }
            if (this.nuJ != null) {
                c6093a.mo13475e(5, this.nuJ);
            }
            if (this.nuK != null) {
                c6093a.mo13475e(6, this.nuK);
            }
            if (this.nuL != null) {
                c6093a.mo13475e(7, this.nuL);
            }
            if (this.nuM != null) {
                c6093a.mo13475e(8, this.nuM);
            }
            if (this.nuN != null) {
                c6093a.mo13475e(9, this.nuN);
            }
            if (this.nuO != null) {
                c6093a.mo13475e(10, this.nuO);
            }
            if (this.dtV != null) {
                c6093a.mo13475e(11, this.dtV);
            }
            if (this.nuP != null) {
                c6093a.mo13475e(12, this.nuP);
            }
            if (this.nuQ != null) {
                c6093a.mo13475e(13, this.nuQ);
            }
            AppMethodBeat.m2505o(21657);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.nuH) + 0;
            if (this.type != null) {
                bs += C6091a.m9575f(2, this.type);
            }
            if (this.title != null) {
                bs += C6091a.m9575f(3, this.title);
            }
            if (this.nuI != null) {
                bs += C6091a.m9575f(4, this.nuI);
            }
            if (this.nuJ != null) {
                bs += C6091a.m9575f(5, this.nuJ);
            }
            if (this.nuK != null) {
                bs += C6091a.m9575f(6, this.nuK);
            }
            if (this.nuL != null) {
                bs += C6091a.m9575f(7, this.nuL);
            }
            if (this.nuM != null) {
                bs += C6091a.m9575f(8, this.nuM);
            }
            if (this.nuN != null) {
                bs += C6091a.m9575f(9, this.nuN);
            }
            if (this.nuO != null) {
                bs += C6091a.m9575f(10, this.nuO);
            }
            if (this.dtV != null) {
                bs += C6091a.m9575f(11, this.dtV);
            }
            if (this.nuP != null) {
                bs += C6091a.m9575f(12, this.nuP);
            }
            if (this.nuQ != null) {
                bs += C6091a.m9575f(13, this.nuQ);
            }
            AppMethodBeat.m2505o(21657);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(21657);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12328b c12328b = (C12328b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c12328b.nuH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 2:
                    c12328b.type = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 3:
                    c12328b.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 4:
                    c12328b.nuI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 5:
                    c12328b.nuJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 6:
                    c12328b.nuK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 7:
                    c12328b.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 8:
                    c12328b.nuM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 9:
                    c12328b.nuN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 10:
                    c12328b.nuO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 11:
                    c12328b.dtV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 12:
                    c12328b.nuP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                case 13:
                    c12328b.nuQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(21657);
                    return 0;
                default:
                    AppMethodBeat.m2505o(21657);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(21657);
            return -1;
        }
    }
}
