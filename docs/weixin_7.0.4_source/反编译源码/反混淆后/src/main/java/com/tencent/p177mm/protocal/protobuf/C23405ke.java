package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ke */
public final class C23405ke extends C1331a {
    public String vMV;
    public String vNb;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11701);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vNb != null) {
                c6093a.mo13475e(2, this.vNb);
            }
            if (this.vMV != null) {
                c6093a.mo13475e(3, this.vMV);
            }
            AppMethodBeat.m2505o(11701);
            return 0;
        } else if (i == 1) {
            if (this.vNb != null) {
                f = C6091a.m9575f(2, this.vNb) + 0;
            } else {
                f = 0;
            }
            if (this.vMV != null) {
                f += C6091a.m9575f(3, this.vMV);
            }
            AppMethodBeat.m2505o(11701);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11701);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23405ke c23405ke = (C23405ke) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    c23405ke.vNb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11701);
                    return 0;
                case 3:
                    c23405ke.vMV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11701);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11701);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11701);
            return -1;
        }
    }
}
