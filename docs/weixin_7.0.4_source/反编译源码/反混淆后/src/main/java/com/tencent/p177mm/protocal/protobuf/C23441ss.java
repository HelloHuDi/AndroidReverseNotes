package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ss */
public final class C23441ss extends C1331a {
    public int Scene;
    public String jCh;
    public String mZV;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63688);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZV == null) {
                c6092b = new C6092b("Not all required fields were included: PkgId");
                AppMethodBeat.m2505o(63688);
                throw c6092b;
            }
            if (this.mZV != null) {
                c6093a.mo13475e(1, this.mZV);
            }
            if (this.jCh != null) {
                c6093a.mo13475e(2, this.jCh);
            }
            c6093a.mo13480iz(3, this.Scene);
            AppMethodBeat.m2505o(63688);
            return 0;
        } else if (i == 1) {
            if (this.mZV != null) {
                f = C6091a.m9575f(1, this.mZV) + 0;
            } else {
                f = 0;
            }
            if (this.jCh != null) {
                f += C6091a.m9575f(2, this.jCh);
            }
            int bs = f + C6091a.m9572bs(3, this.Scene);
            AppMethodBeat.m2505o(63688);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.mZV == null) {
                c6092b = new C6092b("Not all required fields were included: PkgId");
                AppMethodBeat.m2505o(63688);
                throw c6092b;
            }
            AppMethodBeat.m2505o(63688);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23441ss c23441ss = (C23441ss) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23441ss.mZV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63688);
                    return 0;
                case 2:
                    c23441ss.jCh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63688);
                    return 0;
                case 3:
                    c23441ss.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(63688);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63688);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63688);
            return -1;
        }
    }
}
