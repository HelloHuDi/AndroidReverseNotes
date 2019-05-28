package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ll */
public final class C7269ll extends C1331a {
    public int port;
    public int type;
    public C1332b vOX;
    public C1332b vOY;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58894);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.type);
            c6093a.mo13480iz(2, this.port);
            if (this.vOX != null) {
                c6093a.mo13473c(3, this.vOX);
            }
            if (this.vOY != null) {
                c6093a.mo13473c(4, this.vOY);
            }
            AppMethodBeat.m2505o(58894);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.type) + 0) + C6091a.m9572bs(2, this.port);
            if (this.vOX != null) {
                bs += C6091a.m9571b(3, this.vOX);
            }
            if (this.vOY != null) {
                bs += C6091a.m9571b(4, this.vOY);
            }
            AppMethodBeat.m2505o(58894);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58894);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7269ll c7269ll = (C7269ll) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7269ll.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58894);
                    return 0;
                case 2:
                    c7269ll.port = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58894);
                    return 0;
                case 3:
                    c7269ll.vOX = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(58894);
                    return 0;
                case 4:
                    c7269ll.vOY = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(58894);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58894);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58894);
            return -1;
        }
    }
}
