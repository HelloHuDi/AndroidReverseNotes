package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xt */
public final class C30244xt extends C1331a {
    public boolean wdu;
    public boolean wdv;
    public String wdw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89065);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.wdu);
            c6093a.mo13471aO(2, this.wdv);
            if (this.wdw != null) {
                c6093a.mo13475e(3, this.wdw);
            }
            AppMethodBeat.m2505o(89065);
            return 0;
        } else if (i == 1) {
            fv = ((C6091a.m9576fv(1) + 1) + 0) + (C6091a.m9576fv(2) + 1);
            if (this.wdw != null) {
                fv += C6091a.m9575f(3, this.wdw);
            }
            AppMethodBeat.m2505o(89065);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89065);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30244xt c30244xt = (C30244xt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c30244xt.wdu = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89065);
                    return 0;
                case 2:
                    c30244xt.wdv = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(89065);
                    return 0;
                case 3:
                    c30244xt.wdw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89065);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89065);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89065);
            return -1;
        }
    }
}
