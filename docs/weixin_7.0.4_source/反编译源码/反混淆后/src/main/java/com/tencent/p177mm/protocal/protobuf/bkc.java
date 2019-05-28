package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bkc */
public final class bkc extends C1331a {
    public String pbn;
    public String wNi;
    public String wNj;
    public String wNk;
    public String wNl;
    public boolean wNm;
    public String wNn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48921);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wNi != null) {
                c6093a.mo13475e(1, this.wNi);
            }
            if (this.wNj != null) {
                c6093a.mo13475e(2, this.wNj);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(3, this.pbn);
            }
            if (this.wNk != null) {
                c6093a.mo13475e(4, this.wNk);
            }
            if (this.wNl != null) {
                c6093a.mo13475e(5, this.wNl);
            }
            c6093a.mo13471aO(6, this.wNm);
            if (this.wNn != null) {
                c6093a.mo13475e(7, this.wNn);
            }
            AppMethodBeat.m2505o(48921);
            return 0;
        } else if (i == 1) {
            if (this.wNi != null) {
                f = C6091a.m9575f(1, this.wNi) + 0;
            } else {
                f = 0;
            }
            if (this.wNj != null) {
                f += C6091a.m9575f(2, this.wNj);
            }
            if (this.pbn != null) {
                f += C6091a.m9575f(3, this.pbn);
            }
            if (this.wNk != null) {
                f += C6091a.m9575f(4, this.wNk);
            }
            if (this.wNl != null) {
                f += C6091a.m9575f(5, this.wNl);
            }
            f += C6091a.m9576fv(6) + 1;
            if (this.wNn != null) {
                f += C6091a.m9575f(7, this.wNn);
            }
            AppMethodBeat.m2505o(48921);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48921);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bkc bkc = (bkc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkc.wNi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48921);
                    return 0;
                case 2:
                    bkc.wNj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48921);
                    return 0;
                case 3:
                    bkc.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48921);
                    return 0;
                case 4:
                    bkc.wNk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48921);
                    return 0;
                case 5:
                    bkc.wNl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48921);
                    return 0;
                case 6:
                    bkc.wNm = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48921);
                    return 0;
                case 7:
                    bkc.wNn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48921);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48921);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48921);
            return -1;
        }
    }
}
