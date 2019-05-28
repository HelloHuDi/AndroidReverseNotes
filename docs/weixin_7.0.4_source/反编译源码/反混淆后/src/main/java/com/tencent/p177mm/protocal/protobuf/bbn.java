package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bbn */
public final class bbn extends C1331a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public String guW;
    public String jBB;
    public int jCt;
    public String vXm;
    public String vXn;
    public int wGb;
    public int wGc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28551);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB != null) {
                c6093a.mo13475e(1, this.jBB);
            }
            c6093a.mo13480iz(2, this.jCt);
            c6093a.mo13480iz(3, this.guN);
            if (this.guP != null) {
                c6093a.mo13475e(4, this.guP);
            }
            if (this.guO != null) {
                c6093a.mo13475e(5, this.guO);
            }
            if (this.guQ != null) {
                c6093a.mo13475e(6, this.guQ);
            }
            c6093a.mo13480iz(7, this.wGb);
            c6093a.mo13480iz(8, this.wGc);
            if (this.guW != null) {
                c6093a.mo13475e(9, this.guW);
            }
            if (this.vXm != null) {
                c6093a.mo13475e(10, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(11, this.vXn);
            }
            AppMethodBeat.m2505o(28551);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = C6091a.m9575f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.jCt)) + C6091a.m9572bs(3, this.guN);
            if (this.guP != null) {
                f += C6091a.m9575f(4, this.guP);
            }
            if (this.guO != null) {
                f += C6091a.m9575f(5, this.guO);
            }
            if (this.guQ != null) {
                f += C6091a.m9575f(6, this.guQ);
            }
            f = (f + C6091a.m9572bs(7, this.wGb)) + C6091a.m9572bs(8, this.wGc);
            if (this.guW != null) {
                f += C6091a.m9575f(9, this.guW);
            }
            if (this.vXm != null) {
                f += C6091a.m9575f(10, this.vXm);
            }
            if (this.vXn != null) {
                f += C6091a.m9575f(11, this.vXn);
            }
            AppMethodBeat.m2505o(28551);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28551);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bbn bbn = (bbn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbn.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 2:
                    bbn.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 3:
                    bbn.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 4:
                    bbn.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 5:
                    bbn.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 6:
                    bbn.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 7:
                    bbn.wGb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 8:
                    bbn.wGc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 9:
                    bbn.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 10:
                    bbn.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                case 11:
                    bbn.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28551);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28551);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28551);
            return -1;
        }
    }
}
