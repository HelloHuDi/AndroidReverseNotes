package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bcq */
public final class bcq extends C1331a {
    public int vOw;
    public String vXm;
    public String vXn;
    public int wGT;
    public C1332b wGU;
    public String wGV;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28556);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vOw);
            c6093a.mo13480iz(2, this.wGT);
            if (this.wGU != null) {
                c6093a.mo13473c(3, this.wGU);
            }
            if (this.wGV != null) {
                c6093a.mo13475e(4, this.wGV);
            }
            if (this.vXm != null) {
                c6093a.mo13475e(5, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(6, this.vXn);
            }
            AppMethodBeat.m2505o(28556);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.vOw) + 0) + C6091a.m9572bs(2, this.wGT);
            if (this.wGU != null) {
                bs += C6091a.m9571b(3, this.wGU);
            }
            if (this.wGV != null) {
                bs += C6091a.m9575f(4, this.wGV);
            }
            if (this.vXm != null) {
                bs += C6091a.m9575f(5, this.vXm);
            }
            if (this.vXn != null) {
                bs += C6091a.m9575f(6, this.vXn);
            }
            AppMethodBeat.m2505o(28556);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28556);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bcq bcq = (bcq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcq.vOw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28556);
                    return 0;
                case 2:
                    bcq.wGT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28556);
                    return 0;
                case 3:
                    bcq.wGU = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28556);
                    return 0;
                case 4:
                    bcq.wGV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28556);
                    return 0;
                case 5:
                    bcq.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28556);
                    return 0;
                case 6:
                    bcq.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28556);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28556);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28556);
            return -1;
        }
    }
}
