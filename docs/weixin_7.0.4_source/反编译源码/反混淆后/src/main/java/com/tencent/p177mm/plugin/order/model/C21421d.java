package com.tencent.p177mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.order.model.d */
public final class C21421d extends C1331a {
    public int month;
    public String pcO;
    public int year;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56617);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.year);
            c6093a.mo13480iz(2, this.month);
            if (this.pcO != null) {
                c6093a.mo13475e(3, this.pcO);
            }
            AppMethodBeat.m2505o(56617);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.year) + 0) + C6091a.m9572bs(2, this.month);
            if (this.pcO != null) {
                bs += C6091a.m9575f(3, this.pcO);
            }
            AppMethodBeat.m2505o(56617);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56617);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C21421d c21421d = (C21421d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c21421d.year = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56617);
                    return 0;
                case 2:
                    c21421d.month = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56617);
                    return 0;
                case 3:
                    c21421d.pcO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56617);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56617);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56617);
            return -1;
        }
    }
}
