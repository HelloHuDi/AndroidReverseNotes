package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bzj */
public final class bzj extends C1331a {
    public String content;
    public int state;
    public String wYm;
    public String wYn;
    public String wYo;
    public String wYp;
    public int wYq;
    public String wYr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(114986);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.content != null) {
                c6093a.mo13475e(1, this.content);
            }
            if (this.wYm != null) {
                c6093a.mo13475e(2, this.wYm);
            }
            if (this.wYn != null) {
                c6093a.mo13475e(3, this.wYn);
            }
            if (this.wYo != null) {
                c6093a.mo13475e(4, this.wYo);
            }
            if (this.wYp != null) {
                c6093a.mo13475e(5, this.wYp);
            }
            c6093a.mo13480iz(6, this.wYq);
            c6093a.mo13480iz(7, this.state);
            if (this.wYr != null) {
                c6093a.mo13475e(8, this.wYr);
            }
            AppMethodBeat.m2505o(114986);
            return 0;
        } else if (i == 1) {
            if (this.content != null) {
                f = C6091a.m9575f(1, this.content) + 0;
            } else {
                f = 0;
            }
            if (this.wYm != null) {
                f += C6091a.m9575f(2, this.wYm);
            }
            if (this.wYn != null) {
                f += C6091a.m9575f(3, this.wYn);
            }
            if (this.wYo != null) {
                f += C6091a.m9575f(4, this.wYo);
            }
            if (this.wYp != null) {
                f += C6091a.m9575f(5, this.wYp);
            }
            f = (f + C6091a.m9572bs(6, this.wYq)) + C6091a.m9572bs(7, this.state);
            if (this.wYr != null) {
                f += C6091a.m9575f(8, this.wYr);
            }
            AppMethodBeat.m2505o(114986);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(114986);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bzj bzj = (bzj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzj.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114986);
                    return 0;
                case 2:
                    bzj.wYm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114986);
                    return 0;
                case 3:
                    bzj.wYn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114986);
                    return 0;
                case 4:
                    bzj.wYo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114986);
                    return 0;
                case 5:
                    bzj.wYp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114986);
                    return 0;
                case 6:
                    bzj.wYq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114986);
                    return 0;
                case 7:
                    bzj.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(114986);
                    return 0;
                case 8:
                    bzj.wYr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114986);
                    return 0;
                default:
                    AppMethodBeat.m2505o(114986);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(114986);
            return -1;
        }
    }
}
