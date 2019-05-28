package com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.a.a.n */
public final class C11502n extends C1331a {
    public int kKI;
    public boolean kKJ;
    public long kKK;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35523);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.kKI);
            c6093a.mo13471aO(2, this.kKJ);
            c6093a.mo13472ai(3, this.kKK);
            AppMethodBeat.m2505o(35523);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.kKI) + 0) + (C6091a.m9576fv(2) + 1)) + C6091a.m9578o(3, this.kKK);
            AppMethodBeat.m2505o(35523);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35523);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C11502n c11502n = (C11502n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c11502n.kKI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35523);
                    return 0;
                case 2:
                    c11502n.kKJ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(35523);
                    return 0;
                case 3:
                    c11502n.kKK = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(35523);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35523);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35523);
            return -1;
        }
    }
}
