package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gj */
public final class C23391gj extends C1331a {
    public String guQ;
    public String jBB;
    public String jCH;
    public int mAk;
    public String vEn;
    public int vID;
    public String vIE;
    public String vIF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28323);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEn != null) {
                c6093a.mo13475e(1, this.vEn);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(2, this.jCH);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(3, this.jBB);
            }
            c6093a.mo13480iz(4, this.vID);
            if (this.vIE != null) {
                c6093a.mo13475e(5, this.vIE);
            }
            if (this.guQ != null) {
                c6093a.mo13475e(6, this.guQ);
            }
            if (this.vIF != null) {
                c6093a.mo13475e(7, this.vIF);
            }
            c6093a.mo13480iz(8, this.mAk);
            AppMethodBeat.m2505o(28323);
            return 0;
        } else if (i == 1) {
            if (this.vEn != null) {
                f = C6091a.m9575f(1, this.vEn) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += C6091a.m9575f(2, this.jCH);
            }
            if (this.jBB != null) {
                f += C6091a.m9575f(3, this.jBB);
            }
            f += C6091a.m9572bs(4, this.vID);
            if (this.vIE != null) {
                f += C6091a.m9575f(5, this.vIE);
            }
            if (this.guQ != null) {
                f += C6091a.m9575f(6, this.guQ);
            }
            if (this.vIF != null) {
                f += C6091a.m9575f(7, this.vIF);
            }
            int bs = f + C6091a.m9572bs(8, this.mAk);
            AppMethodBeat.m2505o(28323);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28323);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23391gj c23391gj = (C23391gj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23391gj.vEn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28323);
                    return 0;
                case 2:
                    c23391gj.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28323);
                    return 0;
                case 3:
                    c23391gj.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28323);
                    return 0;
                case 4:
                    c23391gj.vID = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28323);
                    return 0;
                case 5:
                    c23391gj.vIE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28323);
                    return 0;
                case 6:
                    c23391gj.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28323);
                    return 0;
                case 7:
                    c23391gj.vIF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28323);
                    return 0;
                case 8:
                    c23391gj.mAk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28323);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28323);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28323);
            return -1;
        }
    }
}
