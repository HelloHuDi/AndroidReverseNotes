package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bix */
public final class bix extends C1331a {
    public String csB;
    public String kbV;
    public String vTT;
    public int wMn;
    public String wMo;
    public String wMp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56884);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.csB != null) {
                c6093a.mo13475e(1, this.csB);
            }
            c6093a.mo13480iz(2, this.wMn);
            if (this.wMo != null) {
                c6093a.mo13475e(3, this.wMo);
            }
            if (this.wMp != null) {
                c6093a.mo13475e(4, this.wMp);
            }
            if (this.vTT != null) {
                c6093a.mo13475e(5, this.vTT);
            }
            if (this.kbV != null) {
                c6093a.mo13475e(6, this.kbV);
            }
            AppMethodBeat.m2505o(56884);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = C6091a.m9575f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wMn);
            if (this.wMo != null) {
                f += C6091a.m9575f(3, this.wMo);
            }
            if (this.wMp != null) {
                f += C6091a.m9575f(4, this.wMp);
            }
            if (this.vTT != null) {
                f += C6091a.m9575f(5, this.vTT);
            }
            if (this.kbV != null) {
                f += C6091a.m9575f(6, this.kbV);
            }
            AppMethodBeat.m2505o(56884);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56884);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bix bix = (bix) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bix.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56884);
                    return 0;
                case 2:
                    bix.wMn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56884);
                    return 0;
                case 3:
                    bix.wMo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56884);
                    return 0;
                case 4:
                    bix.wMp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56884);
                    return 0;
                case 5:
                    bix.vTT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56884);
                    return 0;
                case 6:
                    bix.kbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56884);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56884);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56884);
            return -1;
        }
    }
}
