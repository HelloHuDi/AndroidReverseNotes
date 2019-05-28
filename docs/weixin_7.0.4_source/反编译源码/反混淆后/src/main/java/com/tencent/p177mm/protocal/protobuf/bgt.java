package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bgt */
public final class bgt extends C1331a {
    public int type;
    public C1332b wKq;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60054);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wKq == null) {
                c6092b = new C6092b("Not all required fields were included: buf");
                AppMethodBeat.m2505o(60054);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.type);
            if (this.wKq != null) {
                c6093a.mo13473c(2, this.wKq);
            }
            AppMethodBeat.m2505o(60054);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.type) + 0;
            if (this.wKq != null) {
                bs += C6091a.m9571b(2, this.wKq);
            }
            AppMethodBeat.m2505o(60054);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wKq == null) {
                c6092b = new C6092b("Not all required fields were included: buf");
                AppMethodBeat.m2505o(60054);
                throw c6092b;
            }
            AppMethodBeat.m2505o(60054);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bgt bgt = (bgt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgt.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60054);
                    return 0;
                case 2:
                    bgt.wKq = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(60054);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60054);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60054);
            return -1;
        }
    }
}
