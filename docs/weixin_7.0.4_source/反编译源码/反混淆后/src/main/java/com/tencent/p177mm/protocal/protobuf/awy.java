package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.awy */
public final class awy extends C1331a {
    public int jBv;
    public int wBd;
    public C1332b wBe;
    public int wBf;
    public int wBg;
    public int wdc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72858);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wBd);
            if (this.wBe != null) {
                c6093a.mo13473c(2, this.wBe);
            }
            c6093a.mo13480iz(3, this.wBf);
            c6093a.mo13480iz(4, this.wdc);
            c6093a.mo13480iz(5, this.jBv);
            c6093a.mo13480iz(6, this.wBg);
            AppMethodBeat.m2505o(72858);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wBd) + 0;
            if (this.wBe != null) {
                bs += C6091a.m9571b(2, this.wBe);
            }
            bs = (((bs + C6091a.m9572bs(3, this.wBf)) + C6091a.m9572bs(4, this.wdc)) + C6091a.m9572bs(5, this.jBv)) + C6091a.m9572bs(6, this.wBg);
            AppMethodBeat.m2505o(72858);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72858);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            awy awy = (awy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    awy.wBd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72858);
                    return 0;
                case 2:
                    awy.wBe = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(72858);
                    return 0;
                case 3:
                    awy.wBf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72858);
                    return 0;
                case 4:
                    awy.wdc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72858);
                    return 0;
                case 5:
                    awy.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72858);
                    return 0;
                case 6:
                    awy.wBg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72858);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72858);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72858);
            return -1;
        }
    }
}
