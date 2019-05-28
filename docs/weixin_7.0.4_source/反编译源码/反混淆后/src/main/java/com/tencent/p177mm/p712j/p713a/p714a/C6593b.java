package com.tencent.p177mm.p712j.p713a.p714a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.j.a.a.b */
public final class C6593b extends C1331a {
    public int eoA;
    public String eoB;
    public String eoz;
    public String userName;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(59616);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.userName != null) {
                c6093a.mo13475e(1, this.userName);
            }
            if (this.eoz != null) {
                c6093a.mo13475e(2, this.eoz);
            }
            c6093a.mo13480iz(3, this.eoA);
            if (this.eoB != null) {
                c6093a.mo13475e(4, this.eoB);
            }
            AppMethodBeat.m2505o(59616);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                f = C6091a.m9575f(1, this.userName) + 0;
            } else {
                f = 0;
            }
            if (this.eoz != null) {
                f += C6091a.m9575f(2, this.eoz);
            }
            f += C6091a.m9572bs(3, this.eoA);
            if (this.eoB != null) {
                f += C6091a.m9575f(4, this.eoB);
            }
            AppMethodBeat.m2505o(59616);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(59616);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6593b c6593b = (C6593b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c6593b.userName = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(59616);
                    return 0;
                case 2:
                    c6593b.eoz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(59616);
                    return 0;
                case 3:
                    c6593b.eoA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(59616);
                    return 0;
                case 4:
                    c6593b.eoB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(59616);
                    return 0;
                default:
                    AppMethodBeat.m2505o(59616);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(59616);
            return -1;
        }
    }
}
