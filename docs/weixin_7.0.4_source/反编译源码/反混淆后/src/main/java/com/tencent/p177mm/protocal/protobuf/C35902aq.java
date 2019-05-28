package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aq */
public final class C35902aq extends C1331a {
    public String kcU;
    public String kcV;
    public String kcW;
    public String kcX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89002);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kcU != null) {
                c6093a.mo13475e(1, this.kcU);
            }
            if (this.kcV != null) {
                c6093a.mo13475e(2, this.kcV);
            }
            if (this.kcW != null) {
                c6093a.mo13475e(3, this.kcW);
            }
            if (this.kcX != null) {
                c6093a.mo13475e(4, this.kcX);
            }
            AppMethodBeat.m2505o(89002);
            return 0;
        } else if (i == 1) {
            if (this.kcU != null) {
                f = C6091a.m9575f(1, this.kcU) + 0;
            } else {
                f = 0;
            }
            if (this.kcV != null) {
                f += C6091a.m9575f(2, this.kcV);
            }
            if (this.kcW != null) {
                f += C6091a.m9575f(3, this.kcW);
            }
            if (this.kcX != null) {
                f += C6091a.m9575f(4, this.kcX);
            }
            AppMethodBeat.m2505o(89002);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89002);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35902aq c35902aq = (C35902aq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35902aq.kcU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89002);
                    return 0;
                case 2:
                    c35902aq.kcV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89002);
                    return 0;
                case 3:
                    c35902aq.kcW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89002);
                    return 0;
                case 4:
                    c35902aq.kcX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89002);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89002);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89002);
            return -1;
        }
    }
}
