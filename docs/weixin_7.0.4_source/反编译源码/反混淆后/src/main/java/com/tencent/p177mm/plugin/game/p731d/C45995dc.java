package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.dc */
public final class C45995dc extends C1331a {
    public String Name;
    public int ncp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111670);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Name == null) {
                c6092b = new C6092b("Not all required fields were included: Name");
                AppMethodBeat.m2505o(111670);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.ncp);
            if (this.Name != null) {
                c6093a.mo13475e(2, this.Name);
            }
            AppMethodBeat.m2505o(111670);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.ncp) + 0;
            if (this.Name != null) {
                bs += C6091a.m9575f(2, this.Name);
            }
            AppMethodBeat.m2505o(111670);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.Name == null) {
                c6092b = new C6092b("Not all required fields were included: Name");
                AppMethodBeat.m2505o(111670);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111670);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45995dc c45995dc = (C45995dc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c45995dc.ncp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111670);
                    return 0;
                case 2:
                    c45995dc.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111670);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111670);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111670);
            return -1;
        }
    }
}
