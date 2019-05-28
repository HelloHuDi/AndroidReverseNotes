package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.avf */
public final class avf extends C1331a {
    public int vIc;
    public String wzd;
    public String wze;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10197);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wzd != null) {
                c6093a.mo13475e(1, this.wzd);
            }
            c6093a.mo13480iz(2, this.vIc);
            if (this.wze != null) {
                c6093a.mo13475e(3, this.wze);
            }
            AppMethodBeat.m2505o(10197);
            return 0;
        } else if (i == 1) {
            if (this.wzd != null) {
                f = C6091a.m9575f(1, this.wzd) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.vIc);
            if (this.wze != null) {
                f += C6091a.m9575f(3, this.wze);
            }
            AppMethodBeat.m2505o(10197);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10197);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            avf avf = (avf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avf.wzd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10197);
                    return 0;
                case 2:
                    avf.vIc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10197);
                    return 0;
                case 3:
                    avf.wze = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10197);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10197);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10197);
            return -1;
        }
    }
}
