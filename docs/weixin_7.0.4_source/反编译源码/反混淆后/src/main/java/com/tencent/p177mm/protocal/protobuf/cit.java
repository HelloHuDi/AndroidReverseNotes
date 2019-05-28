package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cit */
public final class cit extends C1331a {
    public int Height;
    public int Width;
    /* renamed from: X */
    public int f17917X;
    /* renamed from: Y */
    public int f17918Y;
    public String wIG;
    public int weB;
    public String xhG;
    public int xhH;
    public int xhI;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(81507);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.f17917X);
            c6093a.mo13480iz(2, this.f17918Y);
            c6093a.mo13480iz(3, this.Width);
            c6093a.mo13480iz(4, this.Height);
            if (this.xhG != null) {
                c6093a.mo13475e(5, this.xhG);
            }
            if (this.wIG != null) {
                c6093a.mo13475e(6, this.wIG);
            }
            c6093a.mo13480iz(7, this.xhH);
            c6093a.mo13480iz(8, this.weB);
            c6093a.mo13480iz(9, this.xhI);
            AppMethodBeat.m2505o(81507);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.f17917X) + 0) + C6091a.m9572bs(2, this.f17918Y)) + C6091a.m9572bs(3, this.Width)) + C6091a.m9572bs(4, this.Height);
            if (this.xhG != null) {
                bs += C6091a.m9575f(5, this.xhG);
            }
            if (this.wIG != null) {
                bs += C6091a.m9575f(6, this.wIG);
            }
            bs = ((bs + C6091a.m9572bs(7, this.xhH)) + C6091a.m9572bs(8, this.weB)) + C6091a.m9572bs(9, this.xhI);
            AppMethodBeat.m2505o(81507);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(81507);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cit cit = (cit) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cit.f17917X = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81507);
                    return 0;
                case 2:
                    cit.f17918Y = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81507);
                    return 0;
                case 3:
                    cit.Width = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81507);
                    return 0;
                case 4:
                    cit.Height = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81507);
                    return 0;
                case 5:
                    cit.xhG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(81507);
                    return 0;
                case 6:
                    cit.wIG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(81507);
                    return 0;
                case 7:
                    cit.xhH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81507);
                    return 0;
                case 8:
                    cit.weB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81507);
                    return 0;
                case 9:
                    cit.xhI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81507);
                    return 0;
                default:
                    AppMethodBeat.m2505o(81507);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(81507);
            return -1;
        }
    }
}
