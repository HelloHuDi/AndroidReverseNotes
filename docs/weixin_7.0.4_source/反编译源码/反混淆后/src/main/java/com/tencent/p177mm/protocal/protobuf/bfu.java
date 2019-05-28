package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bfu */
public final class bfu extends C1331a {
    public String mZJ;
    public String mZr;
    public int mZx;
    public String ncH;
    public String vDm;
    public String vDo;
    public String vMD;
    public int vMG;
    public String wJA;
    public String wJB;
    public String wJC;
    public String wJD;
    public String wJE;
    public String wJF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80124);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZr != null) {
                c6093a.mo13475e(1, this.mZr);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(2, this.ncH);
            }
            if (this.wJA != null) {
                c6093a.mo13475e(3, this.wJA);
            }
            if (this.vDm != null) {
                c6093a.mo13475e(4, this.vDm);
            }
            if (this.mZJ != null) {
                c6093a.mo13475e(5, this.mZJ);
            }
            c6093a.mo13480iz(6, this.vMG);
            if (this.wJB != null) {
                c6093a.mo13475e(7, this.wJB);
            }
            if (this.vDo != null) {
                c6093a.mo13475e(8, this.vDo);
            }
            if (this.vMD != null) {
                c6093a.mo13475e(9, this.vMD);
            }
            if (this.wJC != null) {
                c6093a.mo13475e(10, this.wJC);
            }
            if (this.wJD != null) {
                c6093a.mo13475e(11, this.wJD);
            }
            if (this.wJE != null) {
                c6093a.mo13475e(12, this.wJE);
            }
            if (this.wJF != null) {
                c6093a.mo13475e(13, this.wJF);
            }
            c6093a.mo13480iz(14, this.mZx);
            AppMethodBeat.m2505o(80124);
            return 0;
        } else if (i == 1) {
            if (this.mZr != null) {
                f = C6091a.m9575f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.ncH != null) {
                f += C6091a.m9575f(2, this.ncH);
            }
            if (this.wJA != null) {
                f += C6091a.m9575f(3, this.wJA);
            }
            if (this.vDm != null) {
                f += C6091a.m9575f(4, this.vDm);
            }
            if (this.mZJ != null) {
                f += C6091a.m9575f(5, this.mZJ);
            }
            f += C6091a.m9572bs(6, this.vMG);
            if (this.wJB != null) {
                f += C6091a.m9575f(7, this.wJB);
            }
            if (this.vDo != null) {
                f += C6091a.m9575f(8, this.vDo);
            }
            if (this.vMD != null) {
                f += C6091a.m9575f(9, this.vMD);
            }
            if (this.wJC != null) {
                f += C6091a.m9575f(10, this.wJC);
            }
            if (this.wJD != null) {
                f += C6091a.m9575f(11, this.wJD);
            }
            if (this.wJE != null) {
                f += C6091a.m9575f(12, this.wJE);
            }
            if (this.wJF != null) {
                f += C6091a.m9575f(13, this.wJF);
            }
            int bs = f + C6091a.m9572bs(14, this.mZx);
            AppMethodBeat.m2505o(80124);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80124);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bfu bfu = (bfu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfu.mZr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 2:
                    bfu.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 3:
                    bfu.wJA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 4:
                    bfu.vDm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 5:
                    bfu.mZJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 6:
                    bfu.vMG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 7:
                    bfu.wJB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 8:
                    bfu.vDo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 9:
                    bfu.vMD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 10:
                    bfu.wJC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 11:
                    bfu.wJD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 12:
                    bfu.wJE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 13:
                    bfu.wJF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                case 14:
                    bfu.mZx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80124);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80124);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80124);
            return -1;
        }
    }
}
