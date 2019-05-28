package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.va */
public final class C15390va extends C1331a {
    public String data;
    public String wcw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96217);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.data != null) {
                c6093a.mo13475e(1, this.data);
            }
            if (this.wcw != null) {
                c6093a.mo13475e(2, this.wcw);
            }
            AppMethodBeat.m2505o(96217);
            return 0;
        } else if (i == 1) {
            if (this.data != null) {
                f = C6091a.m9575f(1, this.data) + 0;
            } else {
                f = 0;
            }
            if (this.wcw != null) {
                f += C6091a.m9575f(2, this.wcw);
            }
            AppMethodBeat.m2505o(96217);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96217);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15390va c15390va = (C15390va) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15390va.data = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96217);
                    return 0;
                case 2:
                    c15390va.wcw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96217);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96217);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96217);
            return -1;
        }
    }
}
