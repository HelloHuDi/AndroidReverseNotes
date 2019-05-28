package com.tencent.p177mm.plugin.exdevice.p1255e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.exdevice.e.e */
public final class C27831e extends C1331a {
    public int luT;
    public String luU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(19422);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.luT);
            if (this.luU != null) {
                c6093a.mo13475e(2, this.luU);
            }
            AppMethodBeat.m2505o(19422);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.luT) + 0;
            if (this.luU != null) {
                bs += C6091a.m9575f(2, this.luU);
            }
            AppMethodBeat.m2505o(19422);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(19422);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27831e c27831e = (C27831e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c27831e.luT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19422);
                    return 0;
                case 2:
                    c27831e.luU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19422);
                    return 0;
                default:
                    AppMethodBeat.m2505o(19422);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(19422);
            return -1;
        }
    }
}
