package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chl */
public final class chl extends C1331a {
    public String kmr;
    public String sign;
    public String wmb;
    public String xgh;
    public int xgi;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56989);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xgh != null) {
                c6093a.mo13475e(4, this.xgh);
            }
            if (this.sign != null) {
                c6093a.mo13475e(5, this.sign);
            }
            if (this.kmr != null) {
                c6093a.mo13475e(6, this.kmr);
            }
            c6093a.mo13480iz(7, this.xgi);
            if (this.wmb != null) {
                c6093a.mo13475e(8, this.wmb);
            }
            AppMethodBeat.m2505o(56989);
            return 0;
        } else if (i == 1) {
            if (this.xgh != null) {
                f = C6091a.m9575f(4, this.xgh) + 0;
            } else {
                f = 0;
            }
            if (this.sign != null) {
                f += C6091a.m9575f(5, this.sign);
            }
            if (this.kmr != null) {
                f += C6091a.m9575f(6, this.kmr);
            }
            f += C6091a.m9572bs(7, this.xgi);
            if (this.wmb != null) {
                f += C6091a.m9575f(8, this.wmb);
            }
            AppMethodBeat.m2505o(56989);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56989);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chl chl = (chl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 4:
                    chl.xgh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56989);
                    return 0;
                case 5:
                    chl.sign = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56989);
                    return 0;
                case 6:
                    chl.kmr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56989);
                    return 0;
                case 7:
                    chl.xgi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56989);
                    return 0;
                case 8:
                    chl.wmb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56989);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56989);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56989);
            return -1;
        }
    }
}
