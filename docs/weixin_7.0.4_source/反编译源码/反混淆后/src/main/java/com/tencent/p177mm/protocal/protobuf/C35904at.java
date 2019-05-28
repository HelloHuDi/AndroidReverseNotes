package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.at */
public final class C35904at extends C1331a {
    public String fKh;
    public String vCs;
    public String vCt;
    public String vCu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94489);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.fKh != null) {
                c6093a.mo13475e(1, this.fKh);
            }
            if (this.vCs != null) {
                c6093a.mo13475e(2, this.vCs);
            }
            if (this.vCt != null) {
                c6093a.mo13475e(3, this.vCt);
            }
            if (this.vCu != null) {
                c6093a.mo13475e(4, this.vCu);
            }
            AppMethodBeat.m2505o(94489);
            return 0;
        } else if (i == 1) {
            if (this.fKh != null) {
                f = C6091a.m9575f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            if (this.vCs != null) {
                f += C6091a.m9575f(2, this.vCs);
            }
            if (this.vCt != null) {
                f += C6091a.m9575f(3, this.vCt);
            }
            if (this.vCu != null) {
                f += C6091a.m9575f(4, this.vCu);
            }
            AppMethodBeat.m2505o(94489);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94489);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35904at c35904at = (C35904at) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35904at.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94489);
                    return 0;
                case 2:
                    c35904at.vCs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94489);
                    return 0;
                case 3:
                    c35904at.vCt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94489);
                    return 0;
                case 4:
                    c35904at.vCu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94489);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94489);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94489);
            return -1;
        }
    }
}
