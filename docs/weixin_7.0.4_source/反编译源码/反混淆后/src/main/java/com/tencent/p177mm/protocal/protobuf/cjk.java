package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cjk */
public final class cjk extends C1331a {
    public String content;
    public int kCl;
    public int state;
    public String wYm;
    public int wYq;
    public String wYs;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(114992);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wYs != null) {
                c6093a.mo13475e(1, this.wYs);
            }
            c6093a.mo13480iz(2, this.kCl);
            if (this.content != null) {
                c6093a.mo13475e(3, this.content);
            }
            if (this.wYm != null) {
                c6093a.mo13475e(4, this.wYm);
            }
            c6093a.mo13480iz(5, this.wYq);
            c6093a.mo13480iz(6, this.state);
            AppMethodBeat.m2505o(114992);
            return 0;
        } else if (i == 1) {
            if (this.wYs != null) {
                f = C6091a.m9575f(1, this.wYs) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.kCl);
            if (this.content != null) {
                f += C6091a.m9575f(3, this.content);
            }
            if (this.wYm != null) {
                f += C6091a.m9575f(4, this.wYm);
            }
            int bs = (f + C6091a.m9572bs(5, this.wYq)) + C6091a.m9572bs(6, this.state);
            AppMethodBeat.m2505o(114992);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(114992);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cjk cjk = (cjk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjk.wYs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114992);
                    return 0;
                case 2:
                    cjk.kCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114992);
                    return 0;
                case 3:
                    cjk.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114992);
                    return 0;
                case 4:
                    cjk.wYm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114992);
                    return 0;
                case 5:
                    cjk.wYq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114992);
                    return 0;
                case 6:
                    cjk.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114992);
                    return 0;
                default:
                    AppMethodBeat.m2505o(114992);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(114992);
            return -1;
        }
    }
}
