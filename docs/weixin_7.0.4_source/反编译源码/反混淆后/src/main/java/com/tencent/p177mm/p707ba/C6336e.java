package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.ba.e */
public final class C6336e extends C1331a {
    public String fMh;
    public String lang;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(78442);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.fMh != null) {
                c6093a.mo13475e(1, this.fMh);
            }
            if (this.lang != null) {
                c6093a.mo13475e(2, this.lang);
            }
            AppMethodBeat.m2505o(78442);
            return 0;
        } else if (i == 1) {
            if (this.fMh != null) {
                f = C6091a.m9575f(1, this.fMh) + 0;
            } else {
                f = 0;
            }
            if (this.lang != null) {
                f += C6091a.m9575f(2, this.lang);
            }
            AppMethodBeat.m2505o(78442);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(78442);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6336e c6336e = (C6336e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c6336e.fMh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(78442);
                    return 0;
                case 2:
                    c6336e.lang = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(78442);
                    return 0;
                default:
                    AppMethodBeat.m2505o(78442);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(78442);
            return -1;
        }
    }
}
