package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cat */
public final class cat extends C1331a {
    public int jCt;
    public String ncM;
    public int pcX;
    public int vFH;
    public String vHl;
    public String wCW;
    public int wGu;
    public int wZF;
    public int wZG;
    public int wZH;
    public long wZI;
    public long wZJ;
    public int wZL;
    public String xaa;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94570);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vHl != null) {
                c6093a.mo13475e(1, this.vHl);
            }
            if (this.wCW != null) {
                c6093a.mo13475e(2, this.wCW);
            }
            c6093a.mo13480iz(3, this.vFH);
            c6093a.mo13480iz(4, this.jCt);
            if (this.ncM != null) {
                c6093a.mo13475e(5, this.ncM);
            }
            c6093a.mo13480iz(6, this.pcX);
            c6093a.mo13480iz(7, this.wZG);
            c6093a.mo13480iz(8, this.wZF);
            if (this.xaa != null) {
                c6093a.mo13475e(9, this.xaa);
            }
            c6093a.mo13480iz(10, this.wZH);
            c6093a.mo13472ai(11, this.wZI);
            c6093a.mo13472ai(12, this.wZJ);
            c6093a.mo13480iz(13, this.wGu);
            c6093a.mo13480iz(14, this.wZL);
            AppMethodBeat.m2505o(94570);
            return 0;
        } else if (i == 1) {
            if (this.vHl != null) {
                f = C6091a.m9575f(1, this.vHl) + 0;
            } else {
                f = 0;
            }
            if (this.wCW != null) {
                f += C6091a.m9575f(2, this.wCW);
            }
            f = (f + C6091a.m9572bs(3, this.vFH)) + C6091a.m9572bs(4, this.jCt);
            if (this.ncM != null) {
                f += C6091a.m9575f(5, this.ncM);
            }
            f = ((f + C6091a.m9572bs(6, this.pcX)) + C6091a.m9572bs(7, this.wZG)) + C6091a.m9572bs(8, this.wZF);
            if (this.xaa != null) {
                f += C6091a.m9575f(9, this.xaa);
            }
            int bs = ((((f + C6091a.m9572bs(10, this.wZH)) + C6091a.m9578o(11, this.wZI)) + C6091a.m9578o(12, this.wZJ)) + C6091a.m9572bs(13, this.wGu)) + C6091a.m9572bs(14, this.wZL);
            AppMethodBeat.m2505o(94570);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94570);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cat cat = (cat) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cat.vHl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 2:
                    cat.wCW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 3:
                    cat.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 4:
                    cat.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 5:
                    cat.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 6:
                    cat.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 7:
                    cat.wZG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 8:
                    cat.wZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 9:
                    cat.xaa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 10:
                    cat.wZH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 11:
                    cat.wZI = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 12:
                    cat.wZJ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 13:
                    cat.wGu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                case 14:
                    cat.wZL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94570);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94570);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94570);
            return -1;
        }
    }
}
