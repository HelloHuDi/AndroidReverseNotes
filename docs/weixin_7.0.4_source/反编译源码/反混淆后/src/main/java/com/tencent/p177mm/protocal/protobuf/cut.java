package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cut */
public final class cut extends C1331a {
    public int jBv;
    public int jCt;
    public String ndF;
    public int pcX;
    public String vEG;
    public int wFW;
    public int xqR;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28761);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ndF != null) {
                c6093a.mo13475e(1, this.ndF);
            }
            c6093a.mo13480iz(2, this.jCt);
            c6093a.mo13480iz(3, this.jBv);
            c6093a.mo13480iz(4, this.pcX);
            c6093a.mo13480iz(5, this.wFW);
            if (this.vEG != null) {
                c6093a.mo13475e(6, this.vEG);
            }
            c6093a.mo13480iz(7, this.xqR);
            AppMethodBeat.m2505o(28761);
            return 0;
        } else if (i == 1) {
            if (this.ndF != null) {
                f = C6091a.m9575f(1, this.ndF) + 0;
            } else {
                f = 0;
            }
            f = (((f + C6091a.m9572bs(2, this.jCt)) + C6091a.m9572bs(3, this.jBv)) + C6091a.m9572bs(4, this.pcX)) + C6091a.m9572bs(5, this.wFW);
            if (this.vEG != null) {
                f += C6091a.m9575f(6, this.vEG);
            }
            int bs = f + C6091a.m9572bs(7, this.xqR);
            AppMethodBeat.m2505o(28761);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28761);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cut cut = (cut) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cut.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28761);
                    return 0;
                case 2:
                    cut.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28761);
                    return 0;
                case 3:
                    cut.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28761);
                    return 0;
                case 4:
                    cut.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28761);
                    return 0;
                case 5:
                    cut.wFW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28761);
                    return 0;
                case 6:
                    cut.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28761);
                    return 0;
                case 7:
                    cut.xqR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28761);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28761);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28761);
            return -1;
        }
    }
}
