package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bml */
public final class bml extends C1331a {
    public int luT;
    public String luU;
    public int nwA;
    public String nwB;
    public int wPq;
    public int wPr;
    public int wPs;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28595);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wPr);
            c6093a.mo13480iz(2, this.wPs);
            c6093a.mo13480iz(3, this.wPq);
            c6093a.mo13480iz(4, this.luT);
            if (this.luU != null) {
                c6093a.mo13475e(5, this.luU);
            }
            c6093a.mo13480iz(6, this.nwA);
            if (this.nwB != null) {
                c6093a.mo13475e(7, this.nwB);
            }
            AppMethodBeat.m2505o(28595);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.wPr) + 0) + C6091a.m9572bs(2, this.wPs)) + C6091a.m9572bs(3, this.wPq)) + C6091a.m9572bs(4, this.luT);
            if (this.luU != null) {
                bs += C6091a.m9575f(5, this.luU);
            }
            bs += C6091a.m9572bs(6, this.nwA);
            if (this.nwB != null) {
                bs += C6091a.m9575f(7, this.nwB);
            }
            AppMethodBeat.m2505o(28595);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28595);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bml bml = (bml) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bml.wPr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28595);
                    return 0;
                case 2:
                    bml.wPs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28595);
                    return 0;
                case 3:
                    bml.wPq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28595);
                    return 0;
                case 4:
                    bml.luT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28595);
                    return 0;
                case 5:
                    bml.luU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28595);
                    return 0;
                case 6:
                    bml.nwA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28595);
                    return 0;
                case 7:
                    bml.nwB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28595);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28595);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28595);
            return -1;
        }
    }
}
