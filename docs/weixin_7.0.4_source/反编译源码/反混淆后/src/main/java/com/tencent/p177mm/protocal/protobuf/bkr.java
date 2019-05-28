package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bkr */
public final class bkr extends C1331a {
    public String guP;
    public String guW;
    public float vRp;
    public float vRq;
    public String wNK;
    public String wNL;
    public long wNM;
    public String wxQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124333);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wNK != null) {
                c6093a.mo13475e(1, this.wNK);
            }
            if (this.guW != null) {
                c6093a.mo13475e(2, this.guW);
            }
            if (this.guP != null) {
                c6093a.mo13475e(3, this.guP);
            }
            if (this.wxQ != null) {
                c6093a.mo13475e(4, this.wxQ);
            }
            c6093a.mo13481r(5, this.vRq);
            c6093a.mo13481r(6, this.vRp);
            if (this.wNL != null) {
                c6093a.mo13475e(7, this.wNL);
            }
            c6093a.mo13472ai(8, this.wNM);
            AppMethodBeat.m2505o(124333);
            return 0;
        } else if (i == 1) {
            if (this.wNK != null) {
                f = C6091a.m9575f(1, this.wNK) + 0;
            } else {
                f = 0;
            }
            if (this.guW != null) {
                f += C6091a.m9575f(2, this.guW);
            }
            if (this.guP != null) {
                f += C6091a.m9575f(3, this.guP);
            }
            if (this.wxQ != null) {
                f += C6091a.m9575f(4, this.wxQ);
            }
            f = (f + (C6091a.m9576fv(5) + 4)) + (C6091a.m9576fv(6) + 4);
            if (this.wNL != null) {
                f += C6091a.m9575f(7, this.wNL);
            }
            int o = f + C6091a.m9578o(8, this.wNM);
            AppMethodBeat.m2505o(124333);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124333);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bkr bkr = (bkr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkr.wNK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124333);
                    return 0;
                case 2:
                    bkr.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124333);
                    return 0;
                case 3:
                    bkr.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124333);
                    return 0;
                case 4:
                    bkr.wxQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124333);
                    return 0;
                case 5:
                    bkr.vRq = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(124333);
                    return 0;
                case 6:
                    bkr.vRp = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(124333);
                    return 0;
                case 7:
                    bkr.wNL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124333);
                    return 0;
                case 8:
                    bkr.wNM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(124333);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124333);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124333);
            return -1;
        }
    }
}
