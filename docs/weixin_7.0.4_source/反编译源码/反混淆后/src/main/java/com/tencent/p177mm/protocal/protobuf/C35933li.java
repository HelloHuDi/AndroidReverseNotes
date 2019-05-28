package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.li */
public final class C35933li extends C1331a {
    public String csB;
    public String kLN;
    public int qzj;
    public int vOO;
    public int vOP;
    public int vOQ;
    public String vOR;
    public int vOS;
    public int vOT;
    public int vOU;
    public String vOV;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124290);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.csB != null) {
                c6093a.mo13475e(1, this.csB);
            }
            c6093a.mo13480iz(2, this.vOO);
            c6093a.mo13480iz(3, this.vOP);
            if (this.kLN != null) {
                c6093a.mo13475e(4, this.kLN);
            }
            c6093a.mo13480iz(5, this.vOQ);
            if (this.vOR != null) {
                c6093a.mo13475e(6, this.vOR);
            }
            c6093a.mo13480iz(7, this.vOS);
            c6093a.mo13480iz(8, this.vOT);
            c6093a.mo13480iz(9, this.vOU);
            if (this.vOV != null) {
                c6093a.mo13475e(10, this.vOV);
            }
            c6093a.mo13480iz(15, this.qzj);
            AppMethodBeat.m2505o(124290);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = C6091a.m9575f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.vOO)) + C6091a.m9572bs(3, this.vOP);
            if (this.kLN != null) {
                f += C6091a.m9575f(4, this.kLN);
            }
            f += C6091a.m9572bs(5, this.vOQ);
            if (this.vOR != null) {
                f += C6091a.m9575f(6, this.vOR);
            }
            f = ((f + C6091a.m9572bs(7, this.vOS)) + C6091a.m9572bs(8, this.vOT)) + C6091a.m9572bs(9, this.vOU);
            if (this.vOV != null) {
                f += C6091a.m9575f(10, this.vOV);
            }
            int bs = f + C6091a.m9572bs(15, this.qzj);
            AppMethodBeat.m2505o(124290);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124290);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35933li c35933li = (C35933li) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35933li.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 2:
                    c35933li.vOO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 3:
                    c35933li.vOP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 4:
                    c35933li.kLN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 5:
                    c35933li.vOQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 6:
                    c35933li.vOR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 7:
                    c35933li.vOS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 8:
                    c35933li.vOT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 9:
                    c35933li.vOU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 10:
                    c35933li.vOV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                case 15:
                    c35933li.qzj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124290);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124290);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124290);
            return -1;
        }
    }
}
