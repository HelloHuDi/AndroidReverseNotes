package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bdx */
public final class bdx extends C1331a {
    public int nao;
    public String ndF;
    public String ndG;
    public int ptD;
    public long ptF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60052);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ndG != null) {
                c6093a.mo13475e(1, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(2, this.ndF);
            }
            c6093a.mo13480iz(3, this.ptD);
            c6093a.mo13480iz(4, this.nao);
            c6093a.mo13472ai(5, this.ptF);
            AppMethodBeat.m2505o(60052);
            return 0;
        } else if (i == 1) {
            if (this.ndG != null) {
                f = C6091a.m9575f(1, this.ndG) + 0;
            } else {
                f = 0;
            }
            if (this.ndF != null) {
                f += C6091a.m9575f(2, this.ndF);
            }
            int bs = ((f + C6091a.m9572bs(3, this.ptD)) + C6091a.m9572bs(4, this.nao)) + C6091a.m9578o(5, this.ptF);
            AppMethodBeat.m2505o(60052);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(60052);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bdx bdx = (bdx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bdx.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60052);
                    return 0;
                case 2:
                    bdx.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60052);
                    return 0;
                case 3:
                    bdx.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60052);
                    return 0;
                case 4:
                    bdx.nao = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60052);
                    return 0;
                case 5:
                    bdx.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(60052);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60052);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60052);
            return -1;
        }
    }
}
