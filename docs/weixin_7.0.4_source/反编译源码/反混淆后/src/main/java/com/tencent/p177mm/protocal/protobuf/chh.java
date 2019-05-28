package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chh */
public final class chh extends C1331a {
    public String pXM;
    public String vMU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14755);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vMU != null) {
                c6093a.mo13475e(1, this.vMU);
            }
            if (this.pXM != null) {
                c6093a.mo13475e(2, this.pXM);
            }
            AppMethodBeat.m2505o(14755);
            return 0;
        } else if (i == 1) {
            if (this.vMU != null) {
                f = C6091a.m9575f(1, this.vMU) + 0;
            } else {
                f = 0;
            }
            if (this.pXM != null) {
                f += C6091a.m9575f(2, this.pXM);
            }
            AppMethodBeat.m2505o(14755);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14755);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chh chh = (chh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chh.vMU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14755);
                    return 0;
                case 2:
                    chh.pXM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14755);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14755);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14755);
            return -1;
        }
    }
}
