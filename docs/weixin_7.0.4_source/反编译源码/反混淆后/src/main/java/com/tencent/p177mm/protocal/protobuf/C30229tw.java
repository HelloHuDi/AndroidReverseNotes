package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.tw */
public final class C30229tw extends C1331a {
    public String cuF;
    public String cuG;
    public int version;
    public int wbk;
    public int wbl;
    public String wbm;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28365);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.version);
            c6093a.mo13480iz(2, this.wbk);
            c6093a.mo13480iz(3, this.wbl);
            if (this.cuG != null) {
                c6093a.mo13475e(4, this.cuG);
            }
            if (this.wbm != null) {
                c6093a.mo13475e(5, this.wbm);
            }
            if (this.cuF != null) {
                c6093a.mo13475e(6, this.cuF);
            }
            AppMethodBeat.m2505o(28365);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.version) + 0) + C6091a.m9572bs(2, this.wbk)) + C6091a.m9572bs(3, this.wbl);
            if (this.cuG != null) {
                bs += C6091a.m9575f(4, this.cuG);
            }
            if (this.wbm != null) {
                bs += C6091a.m9575f(5, this.wbm);
            }
            if (this.cuF != null) {
                bs += C6091a.m9575f(6, this.cuF);
            }
            AppMethodBeat.m2505o(28365);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28365);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30229tw c30229tw = (C30229tw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c30229tw.version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28365);
                    return 0;
                case 2:
                    c30229tw.wbk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28365);
                    return 0;
                case 3:
                    c30229tw.wbl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28365);
                    return 0;
                case 4:
                    c30229tw.cuG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28365);
                    return 0;
                case 5:
                    c30229tw.wbm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28365);
                    return 0;
                case 6:
                    c30229tw.cuF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28365);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28365);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28365);
            return -1;
        }
    }
}
