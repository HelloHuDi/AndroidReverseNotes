package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.tp */
public final class C44173tp extends C1331a {
    public String content;
    public String vGs;
    public int vGu;
    public int vNm;
    public int waH;
    public String waI;
    public int waJ;
    public int waK;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14724);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.content != null) {
                c6093a.mo13475e(1, this.content);
            }
            if (this.vGs != null) {
                c6093a.mo13475e(3, this.vGs);
            }
            c6093a.mo13480iz(4, this.vNm);
            c6093a.mo13480iz(5, this.vGu);
            c6093a.mo13480iz(6, this.waH);
            if (this.waI != null) {
                c6093a.mo13475e(7, this.waI);
            }
            c6093a.mo13480iz(8, this.waJ);
            c6093a.mo13480iz(9, this.waK);
            AppMethodBeat.m2505o(14724);
            return 0;
        } else if (i == 1) {
            if (this.content != null) {
                f = C6091a.m9575f(1, this.content) + 0;
            } else {
                f = 0;
            }
            if (this.vGs != null) {
                f += C6091a.m9575f(3, this.vGs);
            }
            f = ((f + C6091a.m9572bs(4, this.vNm)) + C6091a.m9572bs(5, this.vGu)) + C6091a.m9572bs(6, this.waH);
            if (this.waI != null) {
                f += C6091a.m9575f(7, this.waI);
            }
            int bs = (f + C6091a.m9572bs(8, this.waJ)) + C6091a.m9572bs(9, this.waK);
            AppMethodBeat.m2505o(14724);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14724);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44173tp c44173tp = (C44173tp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44173tp.content = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14724);
                    return 0;
                case 3:
                    c44173tp.vGs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14724);
                    return 0;
                case 4:
                    c44173tp.vNm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14724);
                    return 0;
                case 5:
                    c44173tp.vGu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14724);
                    return 0;
                case 6:
                    c44173tp.waH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14724);
                    return 0;
                case 7:
                    c44173tp.waI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14724);
                    return 0;
                case 8:
                    c44173tp.waJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14724);
                    return 0;
                case 9:
                    c44173tp.waK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14724);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14724);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14724);
            return -1;
        }
    }
}
