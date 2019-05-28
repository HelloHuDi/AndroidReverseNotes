package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cts */
public final class cts extends C1331a {
    public String jBB;
    public String jCH;
    public String ncM;
    public int ndE;
    public C1332b xqr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28728);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(28728);
                throw c6092b;
            } else if (this.jCH == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(28728);
                throw c6092b;
            } else if (this.ncM == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(28728);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.ndE);
                if (this.jBB != null) {
                    c6093a.mo13475e(2, this.jBB);
                }
                if (this.jCH != null) {
                    c6093a.mo13475e(3, this.jCH);
                }
                if (this.ncM != null) {
                    c6093a.mo13475e(4, this.ncM);
                }
                if (this.xqr != null) {
                    c6093a.mo13473c(5, this.xqr);
                }
                AppMethodBeat.m2505o(28728);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.ndE) + 0;
            if (this.jBB != null) {
                bs += C6091a.m9575f(2, this.jBB);
            }
            if (this.jCH != null) {
                bs += C6091a.m9575f(3, this.jCH);
            }
            if (this.ncM != null) {
                bs += C6091a.m9575f(4, this.ncM);
            }
            if (this.xqr != null) {
                bs += C6091a.m9571b(5, this.xqr);
            }
            AppMethodBeat.m2505o(28728);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.jBB == null) {
                c6092b = new C6092b("Not all required fields were included: UserName");
                AppMethodBeat.m2505o(28728);
                throw c6092b;
            } else if (this.jCH == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(28728);
                throw c6092b;
            } else if (this.ncM == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(28728);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28728);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cts cts = (cts) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cts.ndE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28728);
                    return 0;
                case 2:
                    cts.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28728);
                    return 0;
                case 3:
                    cts.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28728);
                    return 0;
                case 4:
                    cts.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28728);
                    return 0;
                case 5:
                    cts.xqr = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28728);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28728);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28728);
            return -1;
        }
    }
}
