package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;

/* renamed from: com.tencent.mm.protocal.protobuf.mj */
public final class C46565mj extends C1331a {
    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124297);
        if (i == 0) {
            AppMethodBeat.m2505o(124297);
            return 0;
        } else if (i == 1) {
            AppMethodBeat.m2505o(124297);
            return 0;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = C1331a.getNextFieldNumber(c6086a); nextFieldNumber > 0; nextFieldNumber = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, nextFieldNumber)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124297);
            return 0;
        } else if (i == 3) {
            ((Integer) objArr[2]).intValue();
            AppMethodBeat.m2505o(124297);
            return -1;
        } else {
            AppMethodBeat.m2505o(124297);
            return -1;
        }
    }
}
