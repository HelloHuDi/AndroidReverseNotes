package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.c */
public final class C33709c extends C1331a {
    public int jBh;
    public C1332b jBi;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18046);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jBh);
            if (this.jBi != null) {
                c6093a.mo13473c(2, this.jBi);
            }
            AppMethodBeat.m2505o(18046);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.jBh) + 0;
            if (this.jBi != null) {
                bs += C6091a.m9571b(2, this.jBi);
            }
            AppMethodBeat.m2505o(18046);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(18046);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C33709c c33709c = (C33709c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c33709c.jBh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18046);
                    return 0;
                case 2:
                    c33709c.jBi = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(18046);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18046);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18046);
            return -1;
        }
    }
}
