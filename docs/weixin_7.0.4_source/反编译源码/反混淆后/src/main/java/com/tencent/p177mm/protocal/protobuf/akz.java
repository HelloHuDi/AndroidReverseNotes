package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.akz */
public final class akz extends C1331a {
    public String wqx;
    public String wqy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94530);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wqx != null) {
                c6093a.mo13475e(1, this.wqx);
            }
            if (this.wqy != null) {
                c6093a.mo13475e(2, this.wqy);
            }
            AppMethodBeat.m2505o(94530);
            return 0;
        } else if (i == 1) {
            if (this.wqx != null) {
                f = C6091a.m9575f(1, this.wqx) + 0;
            } else {
                f = 0;
            }
            if (this.wqy != null) {
                f += C6091a.m9575f(2, this.wqy);
            }
            AppMethodBeat.m2505o(94530);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94530);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            akz akz = (akz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    akz.wqx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94530);
                    return 0;
                case 2:
                    akz.wqy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94530);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94530);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94530);
            return -1;
        }
    }
}
