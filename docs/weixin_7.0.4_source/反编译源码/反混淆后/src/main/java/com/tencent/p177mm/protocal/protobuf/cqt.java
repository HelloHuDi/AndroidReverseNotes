package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cqt */
public final class cqt extends C1331a {
    public int akv;
    public String category;
    public int fQi;
    public int wWK;
    public C1332b wdt;
    public int xoy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102401);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.fQi);
            c6093a.mo13480iz(2, this.akv);
            if (this.category != null) {
                c6093a.mo13475e(3, this.category);
            }
            if (this.wdt != null) {
                c6093a.mo13473c(4, this.wdt);
            }
            c6093a.mo13480iz(5, this.wWK);
            c6093a.mo13480iz(6, this.xoy);
            AppMethodBeat.m2505o(102401);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.fQi) + 0) + C6091a.m9572bs(2, this.akv);
            if (this.category != null) {
                bs += C6091a.m9575f(3, this.category);
            }
            if (this.wdt != null) {
                bs += C6091a.m9571b(4, this.wdt);
            }
            bs = (bs + C6091a.m9572bs(5, this.wWK)) + C6091a.m9572bs(6, this.xoy);
            AppMethodBeat.m2505o(102401);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102401);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cqt cqt = (cqt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqt.fQi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102401);
                    return 0;
                case 2:
                    cqt.akv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102401);
                    return 0;
                case 3:
                    cqt.category = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102401);
                    return 0;
                case 4:
                    cqt.wdt = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(102401);
                    return 0;
                case 5:
                    cqt.wWK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102401);
                    return 0;
                case 6:
                    cqt.xoy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102401);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102401);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102401);
            return -1;
        }
    }
}
