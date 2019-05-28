package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.jz */
public final class C35931jz extends C1331a {
    public int enabled;
    public int jVA;
    public int vGw;
    public int vMN;
    public int vMO;
    public int vMP;
    public int vMQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14711);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.enabled);
            c6093a.mo13480iz(2, this.vMN);
            c6093a.mo13480iz(3, this.vMO);
            c6093a.mo13480iz(4, this.vMP);
            c6093a.mo13480iz(5, this.vMQ);
            c6093a.mo13480iz(6, this.jVA);
            c6093a.mo13480iz(7, this.vGw);
            AppMethodBeat.m2505o(14711);
            return 0;
        } else if (i == 1) {
            bs = ((((((C6091a.m9572bs(1, this.enabled) + 0) + C6091a.m9572bs(2, this.vMN)) + C6091a.m9572bs(3, this.vMO)) + C6091a.m9572bs(4, this.vMP)) + C6091a.m9572bs(5, this.vMQ)) + C6091a.m9572bs(6, this.jVA)) + C6091a.m9572bs(7, this.vGw);
            AppMethodBeat.m2505o(14711);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14711);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35931jz c35931jz = (C35931jz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35931jz.enabled = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14711);
                    return 0;
                case 2:
                    c35931jz.vMN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14711);
                    return 0;
                case 3:
                    c35931jz.vMO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14711);
                    return 0;
                case 4:
                    c35931jz.vMP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14711);
                    return 0;
                case 5:
                    c35931jz.vMQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14711);
                    return 0;
                case 6:
                    c35931jz.jVA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14711);
                    return 0;
                case 7:
                    c35931jz.vGw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14711);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14711);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14711);
            return -1;
        }
    }
}
