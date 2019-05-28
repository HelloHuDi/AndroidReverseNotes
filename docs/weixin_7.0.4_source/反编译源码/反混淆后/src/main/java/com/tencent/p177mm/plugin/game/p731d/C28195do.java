package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.do */
public final class C28195do extends C1331a {
    public int ndJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(117004);
        int bs;
        if (i == 0) {
            ((C6093a) objArr[0]).mo13480iz(1, this.ndJ);
            AppMethodBeat.m2505o(117004);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.ndJ) + 0;
            AppMethodBeat.m2505o(117004);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(117004);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28195do c28195do = (C28195do) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c28195do.ndJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(117004);
                    return 0;
                default:
                    AppMethodBeat.m2505o(117004);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(117004);
            return -1;
        }
    }
}
