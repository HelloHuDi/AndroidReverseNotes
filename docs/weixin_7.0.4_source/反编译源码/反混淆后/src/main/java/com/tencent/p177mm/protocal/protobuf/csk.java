package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.csk */
public final class csk extends C1331a {
    public C1332b xpM;
    public C1332b xpN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(57000);
        int b;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xpM != null) {
                c6093a.mo13473c(1, this.xpM);
            }
            if (this.xpN != null) {
                c6093a.mo13473c(2, this.xpN);
            }
            AppMethodBeat.m2505o(57000);
            return 0;
        } else if (i == 1) {
            if (this.xpM != null) {
                b = C6091a.m9571b(1, this.xpM) + 0;
            } else {
                b = 0;
            }
            if (this.xpN != null) {
                b += C6091a.m9571b(2, this.xpN);
            }
            AppMethodBeat.m2505o(57000);
            return b;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (b = C1331a.getNextFieldNumber(c6086a); b > 0; b = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, b)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(57000);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            csk csk = (csk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csk.xpM = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(57000);
                    return 0;
                case 2:
                    csk.xpN = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(57000);
                    return 0;
                default:
                    AppMethodBeat.m2505o(57000);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(57000);
            return -1;
        }
    }
}
