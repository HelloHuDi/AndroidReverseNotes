package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bzd */
public final class bzd extends C1331a {
    public int Height;
    public int Width;
    public String wVm;
    public String wYi;
    public String wdO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28654);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wdO != null) {
                c6093a.mo13475e(1, this.wdO);
            }
            c6093a.mo13480iz(2, this.Width);
            c6093a.mo13480iz(3, this.Height);
            if (this.wVm != null) {
                c6093a.mo13475e(4, this.wVm);
            }
            if (this.wYi != null) {
                c6093a.mo13475e(5, this.wYi);
            }
            AppMethodBeat.m2505o(28654);
            return 0;
        } else if (i == 1) {
            if (this.wdO != null) {
                f = C6091a.m9575f(1, this.wdO) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.Width)) + C6091a.m9572bs(3, this.Height);
            if (this.wVm != null) {
                f += C6091a.m9575f(4, this.wVm);
            }
            if (this.wYi != null) {
                f += C6091a.m9575f(5, this.wYi);
            }
            AppMethodBeat.m2505o(28654);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28654);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bzd bzd = (bzd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzd.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28654);
                    return 0;
                case 2:
                    bzd.Width = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28654);
                    return 0;
                case 3:
                    bzd.Height = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28654);
                    return 0;
                case 4:
                    bzd.wVm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28654);
                    return 0;
                case 5:
                    bzd.wYi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28654);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28654);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28654);
            return -1;
        }
    }
}
