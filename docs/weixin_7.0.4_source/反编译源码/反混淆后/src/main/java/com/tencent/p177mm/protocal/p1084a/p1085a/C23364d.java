package com.tencent.p177mm.protocal.p1084a.p1085a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.a.a.d */
public final class C23364d extends C1331a {
    public int count;
    public int qsz;
    public int vyQ;
    public C1332b vyZ;
    public int vza;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72819);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vyZ == null) {
                c6092b = new C6092b("Not all required fields were included: value");
                AppMethodBeat.m2505o(72819);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.vyQ);
            if (this.vyZ != null) {
                c6093a.mo13473c(2, this.vyZ);
            }
            c6093a.mo13480iz(3, this.vza);
            c6093a.mo13480iz(4, this.qsz);
            c6093a.mo13480iz(5, this.count);
            AppMethodBeat.m2505o(72819);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.vyQ) + 0;
            if (this.vyZ != null) {
                bs += C6091a.m9571b(2, this.vyZ);
            }
            bs = ((bs + C6091a.m9572bs(3, this.vza)) + C6091a.m9572bs(4, this.qsz)) + C6091a.m9572bs(5, this.count);
            AppMethodBeat.m2505o(72819);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.vyZ == null) {
                c6092b = new C6092b("Not all required fields were included: value");
                AppMethodBeat.m2505o(72819);
                throw c6092b;
            }
            AppMethodBeat.m2505o(72819);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23364d c23364d = (C23364d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23364d.vyQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72819);
                    return 0;
                case 2:
                    c23364d.vyZ = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(72819);
                    return 0;
                case 3:
                    c23364d.vza = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72819);
                    return 0;
                case 4:
                    c23364d.qsz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72819);
                    return 0;
                case 5:
                    c23364d.count = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72819);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72819);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72819);
            return -1;
        }
    }
}
