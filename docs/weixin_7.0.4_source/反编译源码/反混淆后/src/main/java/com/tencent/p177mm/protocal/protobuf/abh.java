package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abh */
public final class abh extends C1331a {
    public int cOi;
    public String cvF;
    public int index;
    public int jSW;
    public String mfg;
    public String query;
    public int scene;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51406);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.scene);
            c6093a.mo13480iz(2, this.jSW);
            c6093a.mo13480iz(3, this.index);
            if (this.cvF != null) {
                c6093a.mo13475e(4, this.cvF);
            }
            if (this.query != null) {
                c6093a.mo13475e(5, this.query);
            }
            if (this.mfg != null) {
                c6093a.mo13475e(6, this.mfg);
            }
            c6093a.mo13480iz(7, this.cOi);
            AppMethodBeat.m2505o(51406);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.scene) + 0) + C6091a.m9572bs(2, this.jSW)) + C6091a.m9572bs(3, this.index);
            if (this.cvF != null) {
                bs += C6091a.m9575f(4, this.cvF);
            }
            if (this.query != null) {
                bs += C6091a.m9575f(5, this.query);
            }
            if (this.mfg != null) {
                bs += C6091a.m9575f(6, this.mfg);
            }
            bs += C6091a.m9572bs(7, this.cOi);
            AppMethodBeat.m2505o(51406);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51406);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abh abh = (abh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abh.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51406);
                    return 0;
                case 2:
                    abh.jSW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51406);
                    return 0;
                case 3:
                    abh.index = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51406);
                    return 0;
                case 4:
                    abh.cvF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51406);
                    return 0;
                case 5:
                    abh.query = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51406);
                    return 0;
                case 6:
                    abh.mfg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51406);
                    return 0;
                case 7:
                    abh.cOi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51406);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51406);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51406);
            return -1;
        }
    }
}
