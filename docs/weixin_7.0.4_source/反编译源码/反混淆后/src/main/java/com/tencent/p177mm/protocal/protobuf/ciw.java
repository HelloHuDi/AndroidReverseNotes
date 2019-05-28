package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ciw */
public final class ciw extends C1331a {
    public int uin;
    public C1332b xhL;
    public String xhM;
    public C1332b xhN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10244);
        int b;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xhL != null) {
                c6093a.mo13473c(1, this.xhL);
            }
            if (this.xhM != null) {
                c6093a.mo13475e(2, this.xhM);
            }
            if (this.xhN != null) {
                c6093a.mo13473c(3, this.xhN);
            }
            c6093a.mo13480iz(4, this.uin);
            AppMethodBeat.m2505o(10244);
            return 0;
        } else if (i == 1) {
            if (this.xhL != null) {
                b = C6091a.m9571b(1, this.xhL) + 0;
            } else {
                b = 0;
            }
            if (this.xhM != null) {
                b += C6091a.m9575f(2, this.xhM);
            }
            if (this.xhN != null) {
                b += C6091a.m9571b(3, this.xhN);
            }
            int bs = b + C6091a.m9572bs(4, this.uin);
            AppMethodBeat.m2505o(10244);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (b = C1331a.getNextFieldNumber(c6086a); b > 0; b = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, b)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10244);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ciw ciw = (ciw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ciw.xhL = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(10244);
                    return 0;
                case 2:
                    ciw.xhM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10244);
                    return 0;
                case 3:
                    ciw.xhN = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(10244);
                    return 0;
                case 4:
                    ciw.uin = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10244);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10244);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10244);
            return -1;
        }
    }
}
