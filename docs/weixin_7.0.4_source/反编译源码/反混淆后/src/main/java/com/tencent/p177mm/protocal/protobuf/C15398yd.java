package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.yd */
public final class C15398yd extends C1331a {
    public int Ret;
    public long ptF;
    public int ptw;
    public int ptx;
    public String wdO;
    public int wdU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(53872);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.Ret);
            c6093a.mo13480iz(2, this.ptx);
            c6093a.mo13480iz(3, this.ptw);
            if (this.wdO != null) {
                c6093a.mo13475e(4, this.wdO);
            }
            c6093a.mo13480iz(5, this.wdU);
            c6093a.mo13472ai(6, this.ptF);
            AppMethodBeat.m2505o(53872);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.Ret) + 0) + C6091a.m9572bs(2, this.ptx)) + C6091a.m9572bs(3, this.ptw);
            if (this.wdO != null) {
                bs += C6091a.m9575f(4, this.wdO);
            }
            bs = (bs + C6091a.m9572bs(5, this.wdU)) + C6091a.m9578o(6, this.ptF);
            AppMethodBeat.m2505o(53872);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(53872);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15398yd c15398yd = (C15398yd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15398yd.Ret = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(53872);
                    return 0;
                case 2:
                    c15398yd.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(53872);
                    return 0;
                case 3:
                    c15398yd.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(53872);
                    return 0;
                case 4:
                    c15398yd.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(53872);
                    return 0;
                case 5:
                    c15398yd.wdU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(53872);
                    return 0;
                case 6:
                    c15398yd.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(53872);
                    return 0;
                default:
                    AppMethodBeat.m2505o(53872);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(53872);
            return -1;
        }
    }
}
