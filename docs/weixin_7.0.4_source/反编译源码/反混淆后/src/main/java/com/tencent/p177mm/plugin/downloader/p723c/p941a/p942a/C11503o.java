package com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.a.a.o */
public final class C11503o extends C1331a {
    public long kKK;
    public int limit;
    public int offset;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35524);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.offset);
            c6093a.mo13480iz(2, this.limit);
            c6093a.mo13472ai(3, this.kKK);
            AppMethodBeat.m2505o(35524);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.offset) + 0) + C6091a.m9572bs(2, this.limit)) + C6091a.m9578o(3, this.kKK);
            AppMethodBeat.m2505o(35524);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35524);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C11503o c11503o = (C11503o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c11503o.offset = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35524);
                    return 0;
                case 2:
                    c11503o.limit = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35524);
                    return 0;
                case 3:
                    c11503o.kKK = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(35524);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35524);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35524);
            return -1;
        }
    }
}
