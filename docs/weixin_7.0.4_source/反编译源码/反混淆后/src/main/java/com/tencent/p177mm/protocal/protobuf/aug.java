package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aug */
public final class aug extends C1331a {
    public int cts;
    public int wyf;
    public int wyg;
    public int wyh;
    public int wyi;
    public int wyj;
    public int wyk;
    public int wyl;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72857);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wyf);
            c6093a.mo13480iz(2, this.cts);
            c6093a.mo13480iz(3, this.wyg);
            c6093a.mo13480iz(4, this.wyh);
            c6093a.mo13480iz(5, this.wyi);
            c6093a.mo13480iz(6, this.wyj);
            c6093a.mo13480iz(7, this.wyk);
            c6093a.mo13480iz(8, this.wyl);
            AppMethodBeat.m2505o(72857);
            return 0;
        } else if (i == 1) {
            bs = (((((((C6091a.m9572bs(1, this.wyf) + 0) + C6091a.m9572bs(2, this.cts)) + C6091a.m9572bs(3, this.wyg)) + C6091a.m9572bs(4, this.wyh)) + C6091a.m9572bs(5, this.wyi)) + C6091a.m9572bs(6, this.wyj)) + C6091a.m9572bs(7, this.wyk)) + C6091a.m9572bs(8, this.wyl);
            AppMethodBeat.m2505o(72857);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72857);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aug aug = (aug) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aug.wyf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72857);
                    return 0;
                case 2:
                    aug.cts = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72857);
                    return 0;
                case 3:
                    aug.wyg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72857);
                    return 0;
                case 4:
                    aug.wyh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72857);
                    return 0;
                case 5:
                    aug.wyi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72857);
                    return 0;
                case 6:
                    aug.wyj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72857);
                    return 0;
                case 7:
                    aug.wyk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72857);
                    return 0;
                case 8:
                    aug.wyl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72857);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72857);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72857);
            return -1;
        }
    }
}
