package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bfl */
public final class bfl extends C1331a {
    public int FileSize;
    public String fMd;
    public int vPb;
    public int vZF;
    public int wJn;
    public int wJo;
    public String wJp;
    public int wJq;
    public String wJr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28563);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.fMd != null) {
                c6093a.mo13475e(1, this.fMd);
            }
            c6093a.mo13480iz(2, this.wJn);
            c6093a.mo13480iz(3, this.wJo);
            c6093a.mo13480iz(4, this.vPb);
            if (this.wJp != null) {
                c6093a.mo13475e(5, this.wJp);
            }
            c6093a.mo13480iz(6, this.FileSize);
            c6093a.mo13480iz(7, this.wJq);
            c6093a.mo13480iz(8, this.vZF);
            if (this.wJr != null) {
                c6093a.mo13475e(9, this.wJr);
            }
            AppMethodBeat.m2505o(28563);
            return 0;
        } else if (i == 1) {
            if (this.fMd != null) {
                f = C6091a.m9575f(1, this.fMd) + 0;
            } else {
                f = 0;
            }
            f = ((f + C6091a.m9572bs(2, this.wJn)) + C6091a.m9572bs(3, this.wJo)) + C6091a.m9572bs(4, this.vPb);
            if (this.wJp != null) {
                f += C6091a.m9575f(5, this.wJp);
            }
            f = ((f + C6091a.m9572bs(6, this.FileSize)) + C6091a.m9572bs(7, this.wJq)) + C6091a.m9572bs(8, this.vZF);
            if (this.wJr != null) {
                f += C6091a.m9575f(9, this.wJr);
            }
            AppMethodBeat.m2505o(28563);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28563);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bfl bfl = (bfl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bfl.fMd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28563);
                    return 0;
                case 2:
                    bfl.wJn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28563);
                    return 0;
                case 3:
                    bfl.wJo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28563);
                    return 0;
                case 4:
                    bfl.vPb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28563);
                    return 0;
                case 5:
                    bfl.wJp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28563);
                    return 0;
                case 6:
                    bfl.FileSize = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28563);
                    return 0;
                case 7:
                    bfl.wJq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28563);
                    return 0;
                case 8:
                    bfl.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28563);
                    return 0;
                case 9:
                    bfl.wJr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28563);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28563);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28563);
            return -1;
        }
    }
}
