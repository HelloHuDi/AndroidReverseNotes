package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.sq */
public final class C23440sq extends C1331a {
    public double latitude;
    public double longitude;
    public String waf;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(134426);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.waf != null) {
                c6093a.mo13475e(1, this.waf);
            }
            c6093a.mo13476f(2, this.longitude);
            c6093a.mo13476f(3, this.latitude);
            AppMethodBeat.m2505o(134426);
            return 0;
        } else if (i == 1) {
            if (this.waf != null) {
                f = C6091a.m9575f(1, this.waf) + 0;
            } else {
                f = 0;
            }
            int fv = (f + (C6091a.m9576fv(2) + 8)) + (C6091a.m9576fv(3) + 8);
            AppMethodBeat.m2505o(134426);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(134426);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23440sq c23440sq = (C23440sq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23440sq.waf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134426);
                    return 0;
                case 2:
                    c23440sq.longitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(134426);
                    return 0;
                case 3:
                    c23440sq.latitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(134426);
                    return 0;
                default:
                    AppMethodBeat.m2505o(134426);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(134426);
            return -1;
        }
    }
}
