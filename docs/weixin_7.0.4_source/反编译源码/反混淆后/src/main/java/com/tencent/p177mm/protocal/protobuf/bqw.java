package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bqw */
public final class bqw extends C1331a {
    public String jCH;
    public String luP;
    public String wGk;
    public String wTj;
    public String wTk;
    public String wTl;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(123515);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jCH != null) {
                c6093a.mo13475e(1, this.jCH);
            }
            if (this.wTj != null) {
                c6093a.mo13475e(2, this.wTj);
            }
            if (this.wGk != null) {
                c6093a.mo13475e(3, this.wGk);
            }
            if (this.wTk != null) {
                c6093a.mo13475e(4, this.wTk);
            }
            if (this.luP != null) {
                c6093a.mo13475e(5, this.luP);
            }
            if (this.wTl != null) {
                c6093a.mo13475e(6, this.wTl);
            }
            AppMethodBeat.m2505o(123515);
            return 0;
        } else if (i == 1) {
            if (this.jCH != null) {
                f = C6091a.m9575f(1, this.jCH) + 0;
            } else {
                f = 0;
            }
            if (this.wTj != null) {
                f += C6091a.m9575f(2, this.wTj);
            }
            if (this.wGk != null) {
                f += C6091a.m9575f(3, this.wGk);
            }
            if (this.wTk != null) {
                f += C6091a.m9575f(4, this.wTk);
            }
            if (this.luP != null) {
                f += C6091a.m9575f(5, this.luP);
            }
            if (this.wTl != null) {
                f += C6091a.m9575f(6, this.wTl);
            }
            AppMethodBeat.m2505o(123515);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(123515);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bqw bqw = (bqw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqw.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123515);
                    return 0;
                case 2:
                    bqw.wTj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123515);
                    return 0;
                case 3:
                    bqw.wGk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123515);
                    return 0;
                case 4:
                    bqw.wTk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123515);
                    return 0;
                case 5:
                    bqw.luP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123515);
                    return 0;
                case 6:
                    bqw.wTl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123515);
                    return 0;
                default:
                    AppMethodBeat.m2505o(123515);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(123515);
            return -1;
        }
    }
}
