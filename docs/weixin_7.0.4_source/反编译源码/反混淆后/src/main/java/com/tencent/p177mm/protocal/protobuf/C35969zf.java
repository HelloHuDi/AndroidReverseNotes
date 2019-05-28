package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.zf */
public final class C35969zf extends C1331a {
    public int weA;
    public int weB;
    public int weC;
    public String weD;
    public int weE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73648);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.weA);
            c6093a.mo13480iz(2, this.weB);
            c6093a.mo13480iz(3, this.weC);
            if (this.weD != null) {
                c6093a.mo13475e(4, this.weD);
            }
            c6093a.mo13480iz(5, this.weE);
            AppMethodBeat.m2505o(73648);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.weA) + 0) + C6091a.m9572bs(2, this.weB)) + C6091a.m9572bs(3, this.weC);
            if (this.weD != null) {
                bs += C6091a.m9575f(4, this.weD);
            }
            bs += C6091a.m9572bs(5, this.weE);
            AppMethodBeat.m2505o(73648);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73648);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35969zf c35969zf = (C35969zf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35969zf.weA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73648);
                    return 0;
                case 2:
                    c35969zf.weB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73648);
                    return 0;
                case 3:
                    c35969zf.weC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73648);
                    return 0;
                case 4:
                    c35969zf.weD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73648);
                    return 0;
                case 5:
                    c35969zf.weE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73648);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73648);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73648);
            return -1;
        }
    }
}
