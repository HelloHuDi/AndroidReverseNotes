package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.aa */
public final class C45750aa extends C1331a {
    public String jBt;
    public long jCE;
    public long jCF;
    public String jCG;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18076);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBt == null) {
                c6092b = new C6092b("Not all required fields were included: BakChatName");
                AppMethodBeat.m2505o(18076);
                throw c6092b;
            } else if (this.jCG == null) {
                c6092b = new C6092b("Not all required fields were included: MsgDataID");
                AppMethodBeat.m2505o(18076);
                throw c6092b;
            } else {
                if (this.jBt != null) {
                    c6093a.mo13475e(1, this.jBt);
                }
                c6093a.mo13472ai(2, this.jCE);
                c6093a.mo13472ai(3, this.jCF);
                if (this.jCG != null) {
                    c6093a.mo13475e(4, this.jCG);
                }
                AppMethodBeat.m2505o(18076);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBt != null) {
                f = C6091a.m9575f(1, this.jBt) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9578o(2, this.jCE)) + C6091a.m9578o(3, this.jCF);
            if (this.jCG != null) {
                f += C6091a.m9575f(4, this.jCG);
            }
            AppMethodBeat.m2505o(18076);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.jBt == null) {
                c6092b = new C6092b("Not all required fields were included: BakChatName");
                AppMethodBeat.m2505o(18076);
                throw c6092b;
            } else if (this.jCG == null) {
                c6092b = new C6092b("Not all required fields were included: MsgDataID");
                AppMethodBeat.m2505o(18076);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(18076);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45750aa c45750aa = (C45750aa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c45750aa.jBt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18076);
                    return 0;
                case 2:
                    c45750aa.jCE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18076);
                    return 0;
                case 3:
                    c45750aa.jCF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18076);
                    return 0;
                case 4:
                    c45750aa.jCG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18076);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18076);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18076);
            return -1;
        }
    }
}
