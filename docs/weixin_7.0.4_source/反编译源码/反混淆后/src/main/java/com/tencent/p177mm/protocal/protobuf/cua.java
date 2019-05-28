package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cua */
public final class cua extends C1331a {
    public long vIs;
    public boolean xqC;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28738);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.vIs);
            c6093a.mo13471aO(2, this.xqC);
            AppMethodBeat.m2505o(28738);
            return 0;
        } else if (i == 1) {
            o = (C6091a.m9578o(1, this.vIs) + 0) + (C6091a.m9576fv(2) + 1);
            AppMethodBeat.m2505o(28738);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28738);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cua cua = (cua) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cua.vIs = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28738);
                    return 0;
                case 2:
                    cua.xqC = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28738);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28738);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28738);
            return -1;
        }
    }
}
