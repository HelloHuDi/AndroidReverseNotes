package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.um */
public final class C46591um extends C1331a {
    public String tCl;
    public String twd;
    public String wca;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56768);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.twd != null) {
                c6093a.mo13475e(1, this.twd);
            }
            if (this.tCl != null) {
                c6093a.mo13475e(2, this.tCl);
            }
            if (this.wca != null) {
                c6093a.mo13475e(3, this.wca);
            }
            AppMethodBeat.m2505o(56768);
            return 0;
        } else if (i == 1) {
            if (this.twd != null) {
                f = C6091a.m9575f(1, this.twd) + 0;
            } else {
                f = 0;
            }
            if (this.tCl != null) {
                f += C6091a.m9575f(2, this.tCl);
            }
            if (this.wca != null) {
                f += C6091a.m9575f(3, this.wca);
            }
            AppMethodBeat.m2505o(56768);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56768);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46591um c46591um = (C46591um) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46591um.twd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56768);
                    return 0;
                case 2:
                    c46591um.tCl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56768);
                    return 0;
                case 3:
                    c46591um.wca = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56768);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56768);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56768);
            return -1;
        }
    }
}
