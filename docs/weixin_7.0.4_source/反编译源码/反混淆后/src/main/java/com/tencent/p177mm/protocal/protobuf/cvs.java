package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvs */
public final class cvs extends C1331a {
    public String Md5;
    public String vMJ;
    public int xrE;
    public int xrF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63699);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Md5 == null) {
                c6092b = new C6092b("Not all required fields were included: Md5");
                AppMethodBeat.m2505o(63699);
                throw c6092b;
            } else if (this.vMJ == null) {
                c6092b = new C6092b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.m2505o(63699);
                throw c6092b;
            } else {
                if (this.Md5 != null) {
                    c6093a.mo13475e(1, this.Md5);
                }
                if (this.vMJ != null) {
                    c6093a.mo13475e(2, this.vMJ);
                }
                c6093a.mo13480iz(3, this.xrE);
                c6093a.mo13480iz(4, this.xrF);
                AppMethodBeat.m2505o(63699);
                return 0;
            }
        } else if (i == 1) {
            if (this.Md5 != null) {
                f = C6091a.m9575f(1, this.Md5) + 0;
            } else {
                f = 0;
            }
            if (this.vMJ != null) {
                f += C6091a.m9575f(2, this.vMJ);
            }
            int bs = (f + C6091a.m9572bs(3, this.xrE)) + C6091a.m9572bs(4, this.xrF);
            AppMethodBeat.m2505o(63699);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Md5 == null) {
                c6092b = new C6092b("Not all required fields were included: Md5");
                AppMethodBeat.m2505o(63699);
                throw c6092b;
            } else if (this.vMJ == null) {
                c6092b = new C6092b("Not all required fields were included: DownloadUrl");
                AppMethodBeat.m2505o(63699);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(63699);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvs cvs = (cvs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvs.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63699);
                    return 0;
                case 2:
                    cvs.vMJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63699);
                    return 0;
                case 3:
                    cvs.xrE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(63699);
                    return 0;
                case 4:
                    cvs.xrF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(63699);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63699);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63699);
            return -1;
        }
    }
}
