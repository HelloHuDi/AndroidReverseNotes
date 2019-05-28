package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.jy */
public final class C35930jy extends C1331a {
    public long jVD;
    public int jVE;
    public String url;
    public String vGE;
    public long vGH;
    public long vMM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11695);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vGE != null) {
                c6093a.mo13475e(1, this.vGE);
            }
            c6093a.mo13472ai(2, this.jVD);
            c6093a.mo13472ai(3, this.vGH);
            c6093a.mo13472ai(4, this.vMM);
            c6093a.mo13480iz(5, this.jVE);
            if (this.url != null) {
                c6093a.mo13475e(6, this.url);
            }
            AppMethodBeat.m2505o(11695);
            return 0;
        } else if (i == 1) {
            if (this.vGE != null) {
                f = C6091a.m9575f(1, this.vGE) + 0;
            } else {
                f = 0;
            }
            f = (((f + C6091a.m9578o(2, this.jVD)) + C6091a.m9578o(3, this.vGH)) + C6091a.m9578o(4, this.vMM)) + C6091a.m9572bs(5, this.jVE);
            if (this.url != null) {
                f += C6091a.m9575f(6, this.url);
            }
            AppMethodBeat.m2505o(11695);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11695);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35930jy c35930jy = (C35930jy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35930jy.vGE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11695);
                    return 0;
                case 2:
                    c35930jy.jVD = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11695);
                    return 0;
                case 3:
                    c35930jy.vGH = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11695);
                    return 0;
                case 4:
                    c35930jy.vMM = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11695);
                    return 0;
                case 5:
                    c35930jy.jVE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11695);
                    return 0;
                case 6:
                    c35930jy.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11695);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11695);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11695);
            return -1;
        }
    }
}
