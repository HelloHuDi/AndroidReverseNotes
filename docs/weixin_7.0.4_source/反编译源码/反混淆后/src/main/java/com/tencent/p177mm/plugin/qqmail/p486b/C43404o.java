package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.qqmail.b.o */
public final class C43404o extends C1331a {
    public String nJq;
    public String name;
    public int puf;
    public int pug;
    public String puh;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(67960);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.name == null) {
                c6092b = new C6092b("Not all required fields were included: name");
                AppMethodBeat.m2505o(67960);
                throw c6092b;
            } else if (this.nJq == null) {
                c6092b = new C6092b("Not all required fields were included: addr");
                AppMethodBeat.m2505o(67960);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.puf);
                if (this.name != null) {
                    c6093a.mo13475e(2, this.name);
                }
                if (this.nJq != null) {
                    c6093a.mo13475e(3, this.nJq);
                }
                c6093a.mo13480iz(4, this.pug);
                if (this.puh != null) {
                    c6093a.mo13475e(5, this.puh);
                }
                AppMethodBeat.m2505o(67960);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.puf) + 0;
            if (this.name != null) {
                bs += C6091a.m9575f(2, this.name);
            }
            if (this.nJq != null) {
                bs += C6091a.m9575f(3, this.nJq);
            }
            bs += C6091a.m9572bs(4, this.pug);
            if (this.puh != null) {
                bs += C6091a.m9575f(5, this.puh);
            }
            AppMethodBeat.m2505o(67960);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.name == null) {
                c6092b = new C6092b("Not all required fields were included: name");
                AppMethodBeat.m2505o(67960);
                throw c6092b;
            } else if (this.nJq == null) {
                c6092b = new C6092b("Not all required fields were included: addr");
                AppMethodBeat.m2505o(67960);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(67960);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43404o c43404o = (C43404o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c43404o.puf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(67960);
                    return 0;
                case 2:
                    c43404o.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(67960);
                    return 0;
                case 3:
                    c43404o.nJq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(67960);
                    return 0;
                case 4:
                    c43404o.pug = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(67960);
                    return 0;
                case 5:
                    c43404o.puh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(67960);
                    return 0;
                default:
                    AppMethodBeat.m2505o(67960);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(67960);
            return -1;
        }
    }
}
