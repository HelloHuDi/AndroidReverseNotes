package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chd */
public class chd extends C1331a {
    public String kbV;
    public String vGE;
    public int weight;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11819);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vGE != null) {
                c6093a.mo13475e(1, this.vGE);
            }
            if (this.kbV != null) {
                c6093a.mo13475e(2, this.kbV);
            }
            c6093a.mo13480iz(3, this.weight);
            AppMethodBeat.m2505o(11819);
            return 0;
        } else if (i == 1) {
            if (this.vGE != null) {
                f = C6091a.m9575f(1, this.vGE) + 0;
            } else {
                f = 0;
            }
            if (this.kbV != null) {
                f += C6091a.m9575f(2, this.kbV);
            }
            int bs = f + C6091a.m9572bs(3, this.weight);
            AppMethodBeat.m2505o(11819);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11819);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chd chd = (chd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chd.vGE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11819);
                    return 0;
                case 2:
                    chd.kbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11819);
                    return 0;
                case 3:
                    chd.weight = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11819);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11819);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11819);
            return -1;
        }
    }
}
