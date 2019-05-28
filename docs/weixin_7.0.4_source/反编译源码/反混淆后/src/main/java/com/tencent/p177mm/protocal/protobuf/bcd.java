package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bcd */
public final class bcd extends C1331a {
    public int jCt;
    public String ncF;
    public String pXM;
    public String wGI;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51432);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ncF != null) {
                c6093a.mo13475e(1, this.ncF);
            }
            if (this.wGI != null) {
                c6093a.mo13475e(2, this.wGI);
            }
            if (this.pXM != null) {
                c6093a.mo13475e(3, this.pXM);
            }
            c6093a.mo13480iz(4, this.jCt);
            AppMethodBeat.m2505o(51432);
            return 0;
        } else if (i == 1) {
            if (this.ncF != null) {
                f = C6091a.m9575f(1, this.ncF) + 0;
            } else {
                f = 0;
            }
            if (this.wGI != null) {
                f += C6091a.m9575f(2, this.wGI);
            }
            if (this.pXM != null) {
                f += C6091a.m9575f(3, this.pXM);
            }
            int bs = f + C6091a.m9572bs(4, this.jCt);
            AppMethodBeat.m2505o(51432);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51432);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bcd bcd = (bcd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcd.ncF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51432);
                    return 0;
                case 2:
                    bcd.wGI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51432);
                    return 0;
                case 3:
                    bcd.pXM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51432);
                    return 0;
                case 4:
                    bcd.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51432);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51432);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51432);
            return -1;
        }
    }
}
