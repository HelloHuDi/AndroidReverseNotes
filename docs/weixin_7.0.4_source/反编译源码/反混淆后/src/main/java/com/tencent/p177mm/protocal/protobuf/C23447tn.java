package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.tn */
public final class C23447tn extends C1331a {
    public String key;
    public long waD;
    public String waE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55699);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.key == null) {
                c6092b = new C6092b("Not all required fields were included: key");
                AppMethodBeat.m2505o(55699);
                throw c6092b;
            }
            if (this.key != null) {
                c6093a.mo13475e(1, this.key);
            }
            c6093a.mo13472ai(2, this.waD);
            if (this.waE != null) {
                c6093a.mo13475e(3, this.waE);
            }
            AppMethodBeat.m2505o(55699);
            return 0;
        } else if (i == 1) {
            if (this.key != null) {
                f = C6091a.m9575f(1, this.key) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9578o(2, this.waD);
            if (this.waE != null) {
                f += C6091a.m9575f(3, this.waE);
            }
            AppMethodBeat.m2505o(55699);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.key == null) {
                c6092b = new C6092b("Not all required fields were included: key");
                AppMethodBeat.m2505o(55699);
                throw c6092b;
            }
            AppMethodBeat.m2505o(55699);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23447tn c23447tn = (C23447tn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23447tn.key = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55699);
                    return 0;
                case 2:
                    c23447tn.waD = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55699);
                    return 0;
                case 3:
                    c23447tn.waE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55699);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55699);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55699);
            return -1;
        }
    }
}
