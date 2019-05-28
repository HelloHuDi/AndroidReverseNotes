package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cgf */
public final class cgf extends C1331a {
    public String color;
    public String tag;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89149);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.tag != null) {
                c6093a.mo13475e(1, this.tag);
            }
            if (this.color != null) {
                c6093a.mo13475e(2, this.color);
            }
            AppMethodBeat.m2505o(89149);
            return 0;
        } else if (i == 1) {
            if (this.tag != null) {
                f = C6091a.m9575f(1, this.tag) + 0;
            } else {
                f = 0;
            }
            if (this.color != null) {
                f += C6091a.m9575f(2, this.color);
            }
            AppMethodBeat.m2505o(89149);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89149);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cgf cgf = (cgf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cgf.tag = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89149);
                    return 0;
                case 2:
                    cgf.color = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89149);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89149);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89149);
            return -1;
        }
    }
}
