package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bed */
public final class bed extends C1331a {
    public String jBB;
    public String jCH;
    public int luF;
    public String vLe;
    public String wHM;
    public String wbw;
    public int weB;
    public int wyY;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73744);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.luF);
            if (this.jCH != null) {
                c6093a.mo13475e(2, this.jCH);
            }
            if (this.vLe != null) {
                c6093a.mo13475e(3, this.vLe);
            }
            if (this.wbw != null) {
                c6093a.mo13475e(4, this.wbw);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(5, this.jBB);
            }
            c6093a.mo13480iz(6, this.wyY);
            c6093a.mo13480iz(7, this.weB);
            if (this.wHM != null) {
                c6093a.mo13475e(8, this.wHM);
            }
            AppMethodBeat.m2505o(73744);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.luF) + 0;
            if (this.jCH != null) {
                bs += C6091a.m9575f(2, this.jCH);
            }
            if (this.vLe != null) {
                bs += C6091a.m9575f(3, this.vLe);
            }
            if (this.wbw != null) {
                bs += C6091a.m9575f(4, this.wbw);
            }
            if (this.jBB != null) {
                bs += C6091a.m9575f(5, this.jBB);
            }
            bs = (bs + C6091a.m9572bs(6, this.wyY)) + C6091a.m9572bs(7, this.weB);
            if (this.wHM != null) {
                bs += C6091a.m9575f(8, this.wHM);
            }
            AppMethodBeat.m2505o(73744);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73744);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bed bed = (bed) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bed.luF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73744);
                    return 0;
                case 2:
                    bed.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73744);
                    return 0;
                case 3:
                    bed.vLe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73744);
                    return 0;
                case 4:
                    bed.wbw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73744);
                    return 0;
                case 5:
                    bed.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73744);
                    return 0;
                case 6:
                    bed.wyY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73744);
                    return 0;
                case 7:
                    bed.weB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73744);
                    return 0;
                case 8:
                    bed.wHM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73744);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73744);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73744);
            return -1;
        }
    }
}
