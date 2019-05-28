package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.g */
public final class C39489g extends C1331a {
    public String country;
    public String duc;
    public String dud;
    public String fBg;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56630);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.country != null) {
                c6093a.mo13475e(1, this.country);
            }
            if (this.duc != null) {
                c6093a.mo13475e(2, this.duc);
            }
            if (this.dud != null) {
                c6093a.mo13475e(3, this.dud);
            }
            if (this.fBg != null) {
                c6093a.mo13475e(4, this.fBg);
            }
            AppMethodBeat.m2505o(56630);
            return 0;
        } else if (i == 1) {
            if (this.country != null) {
                f = C6091a.m9575f(1, this.country) + 0;
            } else {
                f = 0;
            }
            if (this.duc != null) {
                f += C6091a.m9575f(2, this.duc);
            }
            if (this.dud != null) {
                f += C6091a.m9575f(3, this.dud);
            }
            if (this.fBg != null) {
                f += C6091a.m9575f(4, this.fBg);
            }
            AppMethodBeat.m2505o(56630);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56630);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39489g c39489g = (C39489g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c39489g.country = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56630);
                    return 0;
                case 2:
                    c39489g.duc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56630);
                    return 0;
                case 3:
                    c39489g.dud = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56630);
                    return 0;
                case 4:
                    c39489g.fBg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56630);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56630);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56630);
            return -1;
        }
    }
}
