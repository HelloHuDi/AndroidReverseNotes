package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cti */
public final class cti extends C1331a {
    public String vHl;
    public long xqp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28716);
        C6092b c6092b;
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vHl == null) {
                c6092b = new C6092b("Not all required fields were included: Username");
                AppMethodBeat.m2505o(28716);
                throw c6092b;
            }
            c6093a.mo13472ai(1, this.xqp);
            if (this.vHl != null) {
                c6093a.mo13475e(2, this.vHl);
            }
            AppMethodBeat.m2505o(28716);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.xqp) + 0;
            if (this.vHl != null) {
                o += C6091a.m9575f(2, this.vHl);
            }
            AppMethodBeat.m2505o(28716);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            if (this.vHl == null) {
                c6092b = new C6092b("Not all required fields were included: Username");
                AppMethodBeat.m2505o(28716);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28716);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cti cti = (cti) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cti.xqp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28716);
                    return 0;
                case 2:
                    cti.vHl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28716);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28716);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28716);
            return -1;
        }
    }
}
