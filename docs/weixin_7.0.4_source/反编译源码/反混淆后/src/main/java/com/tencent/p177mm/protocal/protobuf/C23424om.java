package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.om */
public final class C23424om extends C1331a {
    public String vUO;
    public String vUP;
    public int vUQ;
    public int vUR;
    public int vUS;
    public int vUT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96210);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vUO != null) {
                c6093a.mo13475e(1, this.vUO);
            }
            if (this.vUP != null) {
                c6093a.mo13475e(2, this.vUP);
            }
            c6093a.mo13480iz(3, this.vUQ);
            c6093a.mo13480iz(4, this.vUR);
            c6093a.mo13480iz(5, this.vUS);
            c6093a.mo13480iz(6, this.vUT);
            AppMethodBeat.m2505o(96210);
            return 0;
        } else if (i == 1) {
            if (this.vUO != null) {
                f = C6091a.m9575f(1, this.vUO) + 0;
            } else {
                f = 0;
            }
            if (this.vUP != null) {
                f += C6091a.m9575f(2, this.vUP);
            }
            int bs = (((f + C6091a.m9572bs(3, this.vUQ)) + C6091a.m9572bs(4, this.vUR)) + C6091a.m9572bs(5, this.vUS)) + C6091a.m9572bs(6, this.vUT);
            AppMethodBeat.m2505o(96210);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96210);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23424om c23424om = (C23424om) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23424om.vUO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96210);
                    return 0;
                case 2:
                    c23424om.vUP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96210);
                    return 0;
                case 3:
                    c23424om.vUQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96210);
                    return 0;
                case 4:
                    c23424om.vUR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96210);
                    return 0;
                case 5:
                    c23424om.vUS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96210);
                    return 0;
                case 6:
                    c23424om.vUT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96210);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96210);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96210);
            return -1;
        }
    }
}
