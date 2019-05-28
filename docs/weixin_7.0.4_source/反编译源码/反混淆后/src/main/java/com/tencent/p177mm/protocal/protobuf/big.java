package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.big */
public final class big extends C1331a {
    public String csB;
    public String fBq;
    public String iAa;
    public String iAe;
    public String izZ;
    public int position;
    public String username;
    public int vFr;
    public int wLx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(134434);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.username != null) {
                c6093a.mo13475e(1, this.username);
            }
            if (this.izZ != null) {
                c6093a.mo13475e(2, this.izZ);
            }
            if (this.fBq != null) {
                c6093a.mo13475e(3, this.fBq);
            }
            if (this.iAa != null) {
                c6093a.mo13475e(4, this.iAa);
            }
            if (this.csB != null) {
                c6093a.mo13475e(5, this.csB);
            }
            if (this.iAe != null) {
                c6093a.mo13475e(6, this.iAe);
            }
            c6093a.mo13480iz(7, this.position);
            c6093a.mo13480iz(8, this.wLx);
            c6093a.mo13480iz(9, this.vFr);
            AppMethodBeat.m2505o(134434);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = C6091a.m9575f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.izZ != null) {
                f += C6091a.m9575f(2, this.izZ);
            }
            if (this.fBq != null) {
                f += C6091a.m9575f(3, this.fBq);
            }
            if (this.iAa != null) {
                f += C6091a.m9575f(4, this.iAa);
            }
            if (this.csB != null) {
                f += C6091a.m9575f(5, this.csB);
            }
            if (this.iAe != null) {
                f += C6091a.m9575f(6, this.iAe);
            }
            int bs = ((f + C6091a.m9572bs(7, this.position)) + C6091a.m9572bs(8, this.wLx)) + C6091a.m9572bs(9, this.vFr);
            AppMethodBeat.m2505o(134434);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(134434);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            big big = (big) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    big.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134434);
                    return 0;
                case 2:
                    big.izZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134434);
                    return 0;
                case 3:
                    big.fBq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134434);
                    return 0;
                case 4:
                    big.iAa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134434);
                    return 0;
                case 5:
                    big.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134434);
                    return 0;
                case 6:
                    big.iAe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134434);
                    return 0;
                case 7:
                    big.position = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134434);
                    return 0;
                case 8:
                    big.wLx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134434);
                    return 0;
                case 9:
                    big.vFr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134434);
                    return 0;
                default:
                    AppMethodBeat.m2505o(134434);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(134434);
            return -1;
        }
    }
}
