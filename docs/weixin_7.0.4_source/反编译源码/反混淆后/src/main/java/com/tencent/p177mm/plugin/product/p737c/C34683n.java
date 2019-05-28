package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.n */
public final class C34683n extends C1331a {
    public int bJt;
    public String csB;
    public String name;
    public String pia;
    public String username;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56639);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.csB != null) {
                c6093a.mo13475e(1, this.csB);
            }
            if (this.name != null) {
                c6093a.mo13475e(2, this.name);
            }
            if (this.pia != null) {
                c6093a.mo13475e(3, this.pia);
            }
            if (this.username != null) {
                c6093a.mo13475e(4, this.username);
            }
            c6093a.mo13480iz(5, this.bJt);
            AppMethodBeat.m2505o(56639);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = C6091a.m9575f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.name != null) {
                f += C6091a.m9575f(2, this.name);
            }
            if (this.pia != null) {
                f += C6091a.m9575f(3, this.pia);
            }
            if (this.username != null) {
                f += C6091a.m9575f(4, this.username);
            }
            int bs = f + C6091a.m9572bs(5, this.bJt);
            AppMethodBeat.m2505o(56639);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56639);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34683n c34683n = (C34683n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c34683n.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56639);
                    return 0;
                case 2:
                    c34683n.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56639);
                    return 0;
                case 3:
                    c34683n.pia = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56639);
                    return 0;
                case 4:
                    c34683n.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56639);
                    return 0;
                case 5:
                    c34683n.bJt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56639);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56639);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56639);
            return -1;
        }
    }
}
