package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gy */
public final class C46546gy extends C1331a {
    public String title;
    public int ttd;
    public String tte;
    public String ttg;
    public String tzW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56707);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            c6093a.mo13480iz(2, this.ttd);
            if (this.tte != null) {
                c6093a.mo13475e(3, this.tte);
            }
            if (this.tzW != null) {
                c6093a.mo13475e(4, this.tzW);
            }
            if (this.ttg != null) {
                c6093a.mo13475e(5, this.ttg);
            }
            AppMethodBeat.m2505o(56707);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.ttd);
            if (this.tte != null) {
                f += C6091a.m9575f(3, this.tte);
            }
            if (this.tzW != null) {
                f += C6091a.m9575f(4, this.tzW);
            }
            if (this.ttg != null) {
                f += C6091a.m9575f(5, this.ttg);
            }
            AppMethodBeat.m2505o(56707);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56707);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46546gy c46546gy = (C46546gy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46546gy.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56707);
                    return 0;
                case 2:
                    c46546gy.ttd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56707);
                    return 0;
                case 3:
                    c46546gy.tte = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56707);
                    return 0;
                case 4:
                    c46546gy.tzW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56707);
                    return 0;
                case 5:
                    c46546gy.ttg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56707);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56707);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56707);
            return -1;
        }
    }
}
