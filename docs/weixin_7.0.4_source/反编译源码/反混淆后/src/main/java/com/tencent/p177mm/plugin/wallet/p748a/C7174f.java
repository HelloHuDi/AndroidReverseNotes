package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.f */
public final class C7174f extends C1331a {
    public String tmO;
    public String tmP;
    public String tmQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56647);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.tmO != null) {
                c6093a.mo13475e(1, this.tmO);
            }
            if (this.tmP != null) {
                c6093a.mo13475e(2, this.tmP);
            }
            if (this.tmQ != null) {
                c6093a.mo13475e(3, this.tmQ);
            }
            AppMethodBeat.m2505o(56647);
            return 0;
        } else if (i == 1) {
            if (this.tmO != null) {
                f = C6091a.m9575f(1, this.tmO) + 0;
            } else {
                f = 0;
            }
            if (this.tmP != null) {
                f += C6091a.m9575f(2, this.tmP);
            }
            if (this.tmQ != null) {
                f += C6091a.m9575f(3, this.tmQ);
            }
            AppMethodBeat.m2505o(56647);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56647);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7174f c7174f = (C7174f) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7174f.tmO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56647);
                    return 0;
                case 2:
                    c7174f.tmP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56647);
                    return 0;
                case 3:
                    c7174f.tmQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56647);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56647);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56647);
            return -1;
        }
    }
}
