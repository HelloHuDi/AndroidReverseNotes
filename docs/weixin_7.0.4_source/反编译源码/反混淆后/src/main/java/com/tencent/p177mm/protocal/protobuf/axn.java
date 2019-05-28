package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.axn */
public final class axn extends C1331a {
    public int vAS;
    public String wBu;
    public boolean wBv;
    public String wBw;
    public String wup;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96272);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vAS);
            if (this.wBu != null) {
                c6093a.mo13475e(2, this.wBu);
            }
            c6093a.mo13471aO(3, this.wBv);
            if (this.wBw != null) {
                c6093a.mo13475e(4, this.wBw);
            }
            if (this.wup != null) {
                c6093a.mo13475e(5, this.wup);
            }
            AppMethodBeat.m2505o(96272);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.vAS) + 0;
            if (this.wBu != null) {
                bs += C6091a.m9575f(2, this.wBu);
            }
            bs += C6091a.m9576fv(3) + 1;
            if (this.wBw != null) {
                bs += C6091a.m9575f(4, this.wBw);
            }
            if (this.wup != null) {
                bs += C6091a.m9575f(5, this.wup);
            }
            AppMethodBeat.m2505o(96272);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96272);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            axn axn = (axn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axn.vAS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96272);
                    return 0;
                case 2:
                    axn.wBu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96272);
                    return 0;
                case 3:
                    axn.wBv = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(96272);
                    return 0;
                case 4:
                    axn.wBw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96272);
                    return 0;
                case 5:
                    axn.wup = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96272);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96272);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96272);
            return -1;
        }
    }
}
