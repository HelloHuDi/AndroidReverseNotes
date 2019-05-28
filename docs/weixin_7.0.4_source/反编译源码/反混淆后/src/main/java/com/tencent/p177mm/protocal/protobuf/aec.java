package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aec */
public final class aec extends C1331a {
    public String fKh;
    public int jCt;
    public int vFs;
    public int wmf;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96220);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.fKh != null) {
                c6093a.mo13475e(1, this.fKh);
            }
            c6093a.mo13480iz(2, this.jCt);
            c6093a.mo13480iz(3, this.vFs);
            c6093a.mo13480iz(4, this.wmf);
            AppMethodBeat.m2505o(96220);
            return 0;
        } else if (i == 1) {
            if (this.fKh != null) {
                f = C6091a.m9575f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            int bs = ((f + C6091a.m9572bs(2, this.jCt)) + C6091a.m9572bs(3, this.vFs)) + C6091a.m9572bs(4, this.wmf);
            AppMethodBeat.m2505o(96220);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96220);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aec aec = (aec) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aec.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96220);
                    return 0;
                case 2:
                    aec.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96220);
                    return 0;
                case 3:
                    aec.vFs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96220);
                    return 0;
                case 4:
                    aec.wmf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96220);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96220);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96220);
            return -1;
        }
    }
}
