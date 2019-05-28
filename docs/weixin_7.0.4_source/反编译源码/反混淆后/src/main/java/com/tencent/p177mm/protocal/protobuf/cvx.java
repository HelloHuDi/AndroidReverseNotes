package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvx */
public final class cvx extends C1331a {
    public int vAS;
    public String wBw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96318);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vAS);
            if (this.wBw != null) {
                c6093a.mo13475e(2, this.wBw);
            }
            AppMethodBeat.m2505o(96318);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.vAS) + 0;
            if (this.wBw != null) {
                bs += C6091a.m9575f(2, this.wBw);
            }
            AppMethodBeat.m2505o(96318);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96318);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvx cvx = (cvx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvx.vAS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96318);
                    return 0;
                case 2:
                    cvx.wBw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96318);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96318);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96318);
            return -1;
        }
    }
}
