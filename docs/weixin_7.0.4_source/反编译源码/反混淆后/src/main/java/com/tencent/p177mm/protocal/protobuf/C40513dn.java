package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.dn */
public final class C40513dn extends C1331a {
    public String csB;
    public String fBq;
    public String iAa;
    public String iAe;
    public int position;
    public String username;
    public int vFr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(134422);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.username != null) {
                c6093a.mo13475e(1, this.username);
            }
            if (this.fBq != null) {
                c6093a.mo13475e(2, this.fBq);
            }
            if (this.iAa != null) {
                c6093a.mo13475e(3, this.iAa);
            }
            if (this.csB != null) {
                c6093a.mo13475e(4, this.csB);
            }
            if (this.iAe != null) {
                c6093a.mo13475e(5, this.iAe);
            }
            c6093a.mo13480iz(6, this.position);
            c6093a.mo13480iz(7, this.vFr);
            AppMethodBeat.m2505o(134422);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = C6091a.m9575f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.fBq != null) {
                f += C6091a.m9575f(2, this.fBq);
            }
            if (this.iAa != null) {
                f += C6091a.m9575f(3, this.iAa);
            }
            if (this.csB != null) {
                f += C6091a.m9575f(4, this.csB);
            }
            if (this.iAe != null) {
                f += C6091a.m9575f(5, this.iAe);
            }
            int bs = (f + C6091a.m9572bs(6, this.position)) + C6091a.m9572bs(7, this.vFr);
            AppMethodBeat.m2505o(134422);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(134422);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40513dn c40513dn = (C40513dn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40513dn.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134422);
                    return 0;
                case 2:
                    c40513dn.fBq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134422);
                    return 0;
                case 3:
                    c40513dn.iAa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134422);
                    return 0;
                case 4:
                    c40513dn.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134422);
                    return 0;
                case 5:
                    c40513dn.iAe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134422);
                    return 0;
                case 6:
                    c40513dn.position = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134422);
                    return 0;
                case 7:
                    c40513dn.vFr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134422);
                    return 0;
                default:
                    AppMethodBeat.m2505o(134422);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(134422);
            return -1;
        }
    }
}
