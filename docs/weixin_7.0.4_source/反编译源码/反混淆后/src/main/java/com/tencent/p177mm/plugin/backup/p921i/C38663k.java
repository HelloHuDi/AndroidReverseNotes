package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.k */
public final class C38663k extends C1331a {
    public int jBA;
    public String jBB;
    public int jBz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18057);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(18057);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.jBz);
            c6093a.mo13480iz(2, this.jBA);
            if (this.jBB != null) {
                c6093a.mo13475e(3, this.jBB);
            }
            AppMethodBeat.m2505o(18057);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.jBz) + 0) + C6091a.m9572bs(2, this.jBA);
            if (this.jBB != null) {
                bs += C6091a.m9575f(3, this.jBB);
            }
            AppMethodBeat.m2505o(18057);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.jBB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(18057);
                throw c6092b;
            }
            AppMethodBeat.m2505o(18057);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C38663k c38663k = (C38663k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c38663k.jBz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18057);
                    return 0;
                case 2:
                    c38663k.jBA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(18057);
                    return 0;
                case 3:
                    c38663k.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18057);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18057);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18057);
            return -1;
        }
    }
}
