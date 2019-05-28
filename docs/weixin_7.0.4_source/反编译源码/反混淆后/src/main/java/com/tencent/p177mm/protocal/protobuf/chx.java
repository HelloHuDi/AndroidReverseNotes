package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chx */
public final class chx extends C1331a {
    public String cHr;
    public long xha;
    public long xhj;
    public long xhk;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55712);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cHr != null) {
                c6093a.mo13475e(1, this.cHr);
            }
            c6093a.mo13472ai(2, this.xhj);
            c6093a.mo13472ai(3, this.xhk);
            c6093a.mo13472ai(4, this.xha);
            AppMethodBeat.m2505o(55712);
            return 0;
        } else if (i == 1) {
            if (this.cHr != null) {
                f = C6091a.m9575f(1, this.cHr) + 0;
            } else {
                f = 0;
            }
            int o = ((f + C6091a.m9578o(2, this.xhj)) + C6091a.m9578o(3, this.xhk)) + C6091a.m9578o(4, this.xha);
            AppMethodBeat.m2505o(55712);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55712);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chx chx = (chx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chx.cHr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55712);
                    return 0;
                case 2:
                    chx.xhj = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55712);
                    return 0;
                case 3:
                    chx.xhk = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55712);
                    return 0;
                case 4:
                    chx.xha = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55712);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55712);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55712);
            return -1;
        }
    }
}
