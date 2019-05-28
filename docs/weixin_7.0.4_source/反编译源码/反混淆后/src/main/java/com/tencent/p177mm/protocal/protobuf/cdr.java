package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdr */
public final class cdr extends C1331a {
    public String ThumbUrl;
    public String jBB;
    public String nbr;
    public long xdq;
    public int xdr;
    public int xds;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56499);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB != null) {
                c6093a.mo13475e(1, this.jBB);
            }
            c6093a.mo13472ai(2, this.xdq);
            c6093a.mo13480iz(3, this.xdr);
            if (this.ThumbUrl != null) {
                c6093a.mo13475e(4, this.ThumbUrl);
            }
            c6093a.mo13480iz(5, this.xds);
            if (this.nbr != null) {
                c6093a.mo13475e(6, this.nbr);
            }
            AppMethodBeat.m2505o(56499);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = C6091a.m9575f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9578o(2, this.xdq)) + C6091a.m9572bs(3, this.xdr);
            if (this.ThumbUrl != null) {
                f += C6091a.m9575f(4, this.ThumbUrl);
            }
            f += C6091a.m9572bs(5, this.xds);
            if (this.nbr != null) {
                f += C6091a.m9575f(6, this.nbr);
            }
            AppMethodBeat.m2505o(56499);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56499);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdr cdr = (cdr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdr.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56499);
                    return 0;
                case 2:
                    cdr.xdq = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56499);
                    return 0;
                case 3:
                    cdr.xdr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56499);
                    return 0;
                case 4:
                    cdr.ThumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56499);
                    return 0;
                case 5:
                    cdr.xds = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56499);
                    return 0;
                case 6:
                    cdr.nbr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56499);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56499);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56499);
            return -1;
        }
    }
}
