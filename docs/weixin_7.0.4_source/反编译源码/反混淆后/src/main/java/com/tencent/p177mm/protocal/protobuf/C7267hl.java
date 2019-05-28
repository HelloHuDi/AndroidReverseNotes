package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.hl */
public final class C7267hl extends C1331a {
    public int Scene;
    public int luF;
    public C1332b vKb;
    public C1332b vKc;
    public int vKd;
    public C1332b vKe;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58892);
        int b;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vKb != null) {
                c6093a.mo13473c(1, this.vKb);
            }
            c6093a.mo13480iz(2, this.luF);
            if (this.vKc != null) {
                c6093a.mo13473c(3, this.vKc);
            }
            c6093a.mo13480iz(4, this.vKd);
            if (this.vKe != null) {
                c6093a.mo13473c(5, this.vKe);
            }
            c6093a.mo13480iz(6, this.Scene);
            AppMethodBeat.m2505o(58892);
            return 0;
        } else if (i == 1) {
            if (this.vKb != null) {
                b = C6091a.m9571b(1, this.vKb) + 0;
            } else {
                b = 0;
            }
            b += C6091a.m9572bs(2, this.luF);
            if (this.vKc != null) {
                b += C6091a.m9571b(3, this.vKc);
            }
            b += C6091a.m9572bs(4, this.vKd);
            if (this.vKe != null) {
                b += C6091a.m9571b(5, this.vKe);
            }
            int bs = b + C6091a.m9572bs(6, this.Scene);
            AppMethodBeat.m2505o(58892);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (b = C1331a.getNextFieldNumber(c6086a); b > 0; b = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, b)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58892);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7267hl c7267hl = (C7267hl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7267hl.vKb = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(58892);
                    return 0;
                case 2:
                    c7267hl.luF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58892);
                    return 0;
                case 3:
                    c7267hl.vKc = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(58892);
                    return 0;
                case 4:
                    c7267hl.vKd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58892);
                    return 0;
                case 5:
                    c7267hl.vKe = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(58892);
                    return 0;
                case 6:
                    c7267hl.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58892);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58892);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58892);
            return -1;
        }
    }
}
