package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cqx */
public final class cqx extends C1331a {
    public String script;
    public int xoI;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102405);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.script != null) {
                c6093a.mo13475e(1, this.script);
            }
            c6093a.mo13480iz(2, this.xoI);
            AppMethodBeat.m2505o(102405);
            return 0;
        } else if (i == 1) {
            if (this.script != null) {
                f = C6091a.m9575f(1, this.script) + 0;
            } else {
                f = 0;
            }
            int bs = f + C6091a.m9572bs(2, this.xoI);
            AppMethodBeat.m2505o(102405);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102405);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cqx cqx = (cqx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqx.script = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102405);
                    return 0;
                case 2:
                    cqx.xoI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102405);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102405);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102405);
            return -1;
        }
    }
}
