package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.blr */
public final class blr extends C1331a {
    public String cEh;
    public String url;
    public String wOM;
    public int wON;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(852);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cEh != null) {
                c6093a.mo13475e(1, this.cEh);
            }
            if (this.url != null) {
                c6093a.mo13475e(2, this.url);
            }
            if (this.wOM != null) {
                c6093a.mo13475e(3, this.wOM);
            }
            c6093a.mo13480iz(4, this.wON);
            AppMethodBeat.m2505o(852);
            return 0;
        } else if (i == 1) {
            if (this.cEh != null) {
                f = C6091a.m9575f(1, this.cEh) + 0;
            } else {
                f = 0;
            }
            if (this.url != null) {
                f += C6091a.m9575f(2, this.url);
            }
            if (this.wOM != null) {
                f += C6091a.m9575f(3, this.wOM);
            }
            int bs = f + C6091a.m9572bs(4, this.wON);
            AppMethodBeat.m2505o(852);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(852);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            blr blr = (blr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    blr.cEh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(852);
                    return 0;
                case 2:
                    blr.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(852);
                    return 0;
                case 3:
                    blr.wOM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(852);
                    return 0;
                case 4:
                    blr.wON = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(852);
                    return 0;
                default:
                    AppMethodBeat.m2505o(852);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(852);
            return -1;
        }
    }
}
