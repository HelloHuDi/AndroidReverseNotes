package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chz */
public final class chz extends C1331a {
    public C1332b vPM;
    public int vPN;
    public int xhl;
    public int xhm;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56990);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(7, this.xhl);
            if (this.vPM != null) {
                c6093a.mo13473c(8, this.vPM);
            }
            c6093a.mo13480iz(9, this.vPN);
            c6093a.mo13480iz(10, this.xhm);
            AppMethodBeat.m2505o(56990);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(7, this.xhl) + 0;
            if (this.vPM != null) {
                bs += C6091a.m9571b(8, this.vPM);
            }
            bs = (bs + C6091a.m9572bs(9, this.vPN)) + C6091a.m9572bs(10, this.xhm);
            AppMethodBeat.m2505o(56990);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56990);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chz chz = (chz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 7:
                    chz.xhl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56990);
                    return 0;
                case 8:
                    chz.vPM = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(56990);
                    return 0;
                case 9:
                    chz.vPN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56990);
                    return 0;
                case 10:
                    chz.xhm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56990);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56990);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56990);
            return -1;
        }
    }
}
