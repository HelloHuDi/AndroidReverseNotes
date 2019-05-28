package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abz */
public final class abz extends C1331a {
    public String cEh;
    /* renamed from: id */
    public String f16202id = "101";
    public boolean wjP;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55700);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f16202id != null) {
                c6093a.mo13475e(1, this.f16202id);
            }
            if (this.cEh != null) {
                c6093a.mo13475e(2, this.cEh);
            }
            c6093a.mo13471aO(3, this.wjP);
            AppMethodBeat.m2505o(55700);
            return 0;
        } else if (i == 1) {
            if (this.f16202id != null) {
                f = C6091a.m9575f(1, this.f16202id) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += C6091a.m9575f(2, this.cEh);
            }
            int fv = f + (C6091a.m9576fv(3) + 1);
            AppMethodBeat.m2505o(55700);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55700);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abz abz = (abz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abz.f16202id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55700);
                    return 0;
                case 2:
                    abz.cEh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55700);
                    return 0;
                case 3:
                    abz.wjP = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(55700);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55700);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55700);
            return -1;
        }
    }
}
