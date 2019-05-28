package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.oj */
public final class C44152oj extends C1331a {
    public String code;
    public String csB;
    public String kbU;
    public String vUJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89044);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kbU != null) {
                c6093a.mo13475e(1, this.kbU);
            }
            if (this.code != null) {
                c6093a.mo13475e(2, this.code);
            }
            if (this.vUJ != null) {
                c6093a.mo13475e(3, this.vUJ);
            }
            if (this.csB != null) {
                c6093a.mo13475e(4, this.csB);
            }
            AppMethodBeat.m2505o(89044);
            return 0;
        } else if (i == 1) {
            if (this.kbU != null) {
                f = C6091a.m9575f(1, this.kbU) + 0;
            } else {
                f = 0;
            }
            if (this.code != null) {
                f += C6091a.m9575f(2, this.code);
            }
            if (this.vUJ != null) {
                f += C6091a.m9575f(3, this.vUJ);
            }
            if (this.csB != null) {
                f += C6091a.m9575f(4, this.csB);
            }
            AppMethodBeat.m2505o(89044);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89044);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44152oj c44152oj = (C44152oj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44152oj.kbU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89044);
                    return 0;
                case 2:
                    c44152oj.code = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89044);
                    return 0;
                case 3:
                    c44152oj.vUJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89044);
                    return 0;
                case 4:
                    c44152oj.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89044);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89044);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89044);
            return -1;
        }
    }
}
