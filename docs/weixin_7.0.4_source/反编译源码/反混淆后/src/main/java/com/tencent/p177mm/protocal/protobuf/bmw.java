package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bmw */
public final class bmw extends C1331a {
    public int wPN;
    public String wdO;
    public int wep;
    public String wkk;
    public int wrw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73750);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wrw);
            if (this.wkk != null) {
                c6093a.mo13475e(2, this.wkk);
            }
            if (this.wdO != null) {
                c6093a.mo13475e(3, this.wdO);
            }
            c6093a.mo13480iz(4, this.wep);
            c6093a.mo13480iz(5, this.wPN);
            AppMethodBeat.m2505o(73750);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wrw) + 0;
            if (this.wkk != null) {
                bs += C6091a.m9575f(2, this.wkk);
            }
            if (this.wdO != null) {
                bs += C6091a.m9575f(3, this.wdO);
            }
            bs = (bs + C6091a.m9572bs(4, this.wep)) + C6091a.m9572bs(5, this.wPN);
            AppMethodBeat.m2505o(73750);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73750);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bmw bmw = (bmw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmw.wrw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73750);
                    return 0;
                case 2:
                    bmw.wkk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73750);
                    return 0;
                case 3:
                    bmw.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73750);
                    return 0;
                case 4:
                    bmw.wep = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73750);
                    return 0;
                case 5:
                    bmw.wPN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73750);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73750);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73750);
            return -1;
        }
    }
}
