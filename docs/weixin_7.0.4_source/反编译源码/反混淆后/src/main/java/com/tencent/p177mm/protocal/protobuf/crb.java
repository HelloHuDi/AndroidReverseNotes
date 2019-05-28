package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.crb */
public final class crb extends C1331a {
    public String cso;
    public String csp;
    public long timestamp;
    public String xoK;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102411);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cso != null) {
                c6093a.mo13475e(1, this.cso);
            }
            if (this.csp != null) {
                c6093a.mo13475e(2, this.csp);
            }
            if (this.xoK != null) {
                c6093a.mo13475e(3, this.xoK);
            }
            c6093a.mo13472ai(4, this.timestamp);
            AppMethodBeat.m2505o(102411);
            return 0;
        } else if (i == 1) {
            if (this.cso != null) {
                f = C6091a.m9575f(1, this.cso) + 0;
            } else {
                f = 0;
            }
            if (this.csp != null) {
                f += C6091a.m9575f(2, this.csp);
            }
            if (this.xoK != null) {
                f += C6091a.m9575f(3, this.xoK);
            }
            int o = f + C6091a.m9578o(4, this.timestamp);
            AppMethodBeat.m2505o(102411);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102411);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            crb crb = (crb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crb.cso = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102411);
                    return 0;
                case 2:
                    crb.csp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102411);
                    return 0;
                case 3:
                    crb.xoK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102411);
                    return 0;
                case 4:
                    crb.timestamp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(102411);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102411);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102411);
            return -1;
        }
    }
}
