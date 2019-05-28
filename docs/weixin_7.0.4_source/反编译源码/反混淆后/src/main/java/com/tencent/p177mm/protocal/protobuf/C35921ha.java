package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ha */
public final class C35921ha extends C1331a {
    public String nuL;
    public String pbn;
    public String pck;
    public String vJF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56709);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vJF != null) {
                c6093a.mo13475e(1, this.vJF);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(2, this.pbn);
            }
            if (this.nuL != null) {
                c6093a.mo13475e(3, this.nuL);
            }
            if (this.pck != null) {
                c6093a.mo13475e(4, this.pck);
            }
            AppMethodBeat.m2505o(56709);
            return 0;
        } else if (i == 1) {
            if (this.vJF != null) {
                f = C6091a.m9575f(1, this.vJF) + 0;
            } else {
                f = 0;
            }
            if (this.pbn != null) {
                f += C6091a.m9575f(2, this.pbn);
            }
            if (this.nuL != null) {
                f += C6091a.m9575f(3, this.nuL);
            }
            if (this.pck != null) {
                f += C6091a.m9575f(4, this.pck);
            }
            AppMethodBeat.m2505o(56709);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56709);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35921ha c35921ha = (C35921ha) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35921ha.vJF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56709);
                    return 0;
                case 2:
                    c35921ha.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56709);
                    return 0;
                case 3:
                    c35921ha.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56709);
                    return 0;
                case 4:
                    c35921ha.pck = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56709);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56709);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56709);
            return -1;
        }
    }
}
