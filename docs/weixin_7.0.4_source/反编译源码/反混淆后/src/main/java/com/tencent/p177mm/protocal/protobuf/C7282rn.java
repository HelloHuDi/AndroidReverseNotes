package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.rn */
public final class C7282rn extends C1331a {
    public String cEh;
    public String pRD;
    public String pcw;
    public String title;
    public int vYN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48821);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.cEh != null) {
                c6093a.mo13475e(2, this.cEh);
            }
            if (this.pcw != null) {
                c6093a.mo13475e(3, this.pcw);
            }
            if (this.pRD != null) {
                c6093a.mo13475e(4, this.pRD);
            }
            c6093a.mo13480iz(5, this.vYN);
            AppMethodBeat.m2505o(48821);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += C6091a.m9575f(2, this.cEh);
            }
            if (this.pcw != null) {
                f += C6091a.m9575f(3, this.pcw);
            }
            if (this.pRD != null) {
                f += C6091a.m9575f(4, this.pRD);
            }
            int bs = f + C6091a.m9572bs(5, this.vYN);
            AppMethodBeat.m2505o(48821);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48821);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7282rn c7282rn = (C7282rn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7282rn.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48821);
                    return 0;
                case 2:
                    c7282rn.cEh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48821);
                    return 0;
                case 3:
                    c7282rn.pcw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48821);
                    return 0;
                case 4:
                    c7282rn.pRD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48821);
                    return 0;
                case 5:
                    c7282rn.vYN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48821);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48821);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48821);
            return -1;
        }
    }
}
