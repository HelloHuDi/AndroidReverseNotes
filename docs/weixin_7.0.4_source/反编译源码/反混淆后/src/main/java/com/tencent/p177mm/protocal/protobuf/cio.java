package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cio */
public final class cio extends C1331a {
    public String nuL;
    public String pLH;
    public String pMd;
    public String pMe;
    public String pMf;
    public String pMg;
    public String pbn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48974);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pMd != null) {
                c6093a.mo13475e(1, this.pMd);
            }
            if (this.pMe != null) {
                c6093a.mo13475e(2, this.pMe);
            }
            if (this.pLH != null) {
                c6093a.mo13475e(3, this.pLH);
            }
            if (this.nuL != null) {
                c6093a.mo13475e(4, this.nuL);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(5, this.pbn);
            }
            if (this.pMf != null) {
                c6093a.mo13475e(6, this.pMf);
            }
            if (this.pMg != null) {
                c6093a.mo13475e(7, this.pMg);
            }
            AppMethodBeat.m2505o(48974);
            return 0;
        } else if (i == 1) {
            if (this.pMd != null) {
                f = C6091a.m9575f(1, this.pMd) + 0;
            } else {
                f = 0;
            }
            if (this.pMe != null) {
                f += C6091a.m9575f(2, this.pMe);
            }
            if (this.pLH != null) {
                f += C6091a.m9575f(3, this.pLH);
            }
            if (this.nuL != null) {
                f += C6091a.m9575f(4, this.nuL);
            }
            if (this.pbn != null) {
                f += C6091a.m9575f(5, this.pbn);
            }
            if (this.pMf != null) {
                f += C6091a.m9575f(6, this.pMf);
            }
            if (this.pMg != null) {
                f += C6091a.m9575f(7, this.pMg);
            }
            AppMethodBeat.m2505o(48974);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48974);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cio cio = (cio) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cio.pMd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48974);
                    return 0;
                case 2:
                    cio.pMe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48974);
                    return 0;
                case 3:
                    cio.pLH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48974);
                    return 0;
                case 4:
                    cio.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48974);
                    return 0;
                case 5:
                    cio.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48974);
                    return 0;
                case 6:
                    cio.pMf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48974);
                    return 0;
                case 7:
                    cio.pMg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48974);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48974);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48974);
            return -1;
        }
    }
}
