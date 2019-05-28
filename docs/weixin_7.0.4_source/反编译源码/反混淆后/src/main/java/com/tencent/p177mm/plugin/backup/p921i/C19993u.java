package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.u */
public final class C19993u extends C1331a {
    public String cHr;
    public String dJC;
    public int jCp;
    public int jCq;
    public long jCr;
    public String path;
    public int type;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18069);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jCp);
            if (this.dJC != null) {
                c6093a.mo13475e(2, this.dJC);
            }
            if (this.cHr != null) {
                c6093a.mo13475e(3, this.cHr);
            }
            if (this.path != null) {
                c6093a.mo13475e(4, this.path);
            }
            c6093a.mo13480iz(5, this.type);
            c6093a.mo13480iz(6, this.jCq);
            c6093a.mo13472ai(7, this.jCr);
            AppMethodBeat.m2505o(18069);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.jCp) + 0;
            if (this.dJC != null) {
                bs += C6091a.m9575f(2, this.dJC);
            }
            if (this.cHr != null) {
                bs += C6091a.m9575f(3, this.cHr);
            }
            if (this.path != null) {
                bs += C6091a.m9575f(4, this.path);
            }
            bs = ((bs + C6091a.m9572bs(5, this.type)) + C6091a.m9572bs(6, this.jCq)) + C6091a.m9578o(7, this.jCr);
            AppMethodBeat.m2505o(18069);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(18069);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C19993u c19993u = (C19993u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c19993u.jCp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18069);
                    return 0;
                case 2:
                    c19993u.dJC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18069);
                    return 0;
                case 3:
                    c19993u.cHr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18069);
                    return 0;
                case 4:
                    c19993u.path = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18069);
                    return 0;
                case 5:
                    c19993u.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18069);
                    return 0;
                case 6:
                    c19993u.jCq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18069);
                    return 0;
                case 7:
                    c19993u.jCr = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18069);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18069);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18069);
            return -1;
        }
    }
}
