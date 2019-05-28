package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.asp */
public final class asp extends C1331a {
    public long wwg;
    public int wwh;
    public long wwi;
    public int wwj;
    public long wwk;
    public int wwl;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5217);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.wwg);
            c6093a.mo13480iz(2, this.wwh);
            c6093a.mo13472ai(3, this.wwi);
            c6093a.mo13480iz(4, this.wwj);
            c6093a.mo13472ai(5, this.wwk);
            c6093a.mo13480iz(6, this.wwl);
            AppMethodBeat.m2505o(5217);
            return 0;
        } else if (i == 1) {
            o = (((((C6091a.m9578o(1, this.wwg) + 0) + C6091a.m9572bs(2, this.wwh)) + C6091a.m9578o(3, this.wwi)) + C6091a.m9572bs(4, this.wwj)) + C6091a.m9578o(5, this.wwk)) + C6091a.m9572bs(6, this.wwl);
            AppMethodBeat.m2505o(5217);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(5217);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            asp asp = (asp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asp.wwg = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5217);
                    return 0;
                case 2:
                    asp.wwh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5217);
                    return 0;
                case 3:
                    asp.wwi = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5217);
                    return 0;
                case 4:
                    asp.wwj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5217);
                    return 0;
                case 5:
                    asp.wwk = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(5217);
                    return 0;
                case 6:
                    asp.wwl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5217);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5217);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5217);
            return -1;
        }
    }
}
