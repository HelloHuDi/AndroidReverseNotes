package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bfe */
public final class bfe extends C1331a {
    public int kaG;
    public int mXP;
    public String vNN;
    public int wIV;
    public int wIW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14737);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vNN != null) {
                c6093a.mo13475e(1, this.vNN);
            }
            c6093a.mo13480iz(2, this.wIV);
            c6093a.mo13480iz(3, this.mXP);
            c6093a.mo13480iz(4, this.wIW);
            c6093a.mo13480iz(5, this.kaG);
            AppMethodBeat.m2505o(14737);
            return 0;
        } else if (i == 1) {
            if (this.vNN != null) {
                f = C6091a.m9575f(1, this.vNN) + 0;
            } else {
                f = 0;
            }
            int bs = (((f + C6091a.m9572bs(2, this.wIV)) + C6091a.m9572bs(3, this.mXP)) + C6091a.m9572bs(4, this.wIW)) + C6091a.m9572bs(5, this.kaG);
            AppMethodBeat.m2505o(14737);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14737);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bfe bfe = (bfe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfe.vNN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14737);
                    return 0;
                case 2:
                    bfe.wIV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14737);
                    return 0;
                case 3:
                    bfe.mXP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14737);
                    return 0;
                case 4:
                    bfe.wIW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14737);
                    return 0;
                case 5:
                    bfe.kaG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14737);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14737);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14737);
            return -1;
        }
    }
}
