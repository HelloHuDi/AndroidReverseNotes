package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.sm */
public final class C44168sm extends C1331a {
    public String csB;
    public long jVD;
    public int jVE;
    public String path;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11736);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.jVD);
            c6093a.mo13480iz(2, this.jVE);
            if (this.csB != null) {
                c6093a.mo13475e(3, this.csB);
            }
            if (this.path != null) {
                c6093a.mo13475e(4, this.path);
            }
            AppMethodBeat.m2505o(11736);
            return 0;
        } else if (i == 1) {
            o = (C6091a.m9578o(1, this.jVD) + 0) + C6091a.m9572bs(2, this.jVE);
            if (this.csB != null) {
                o += C6091a.m9575f(3, this.csB);
            }
            if (this.path != null) {
                o += C6091a.m9575f(4, this.path);
            }
            AppMethodBeat.m2505o(11736);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11736);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44168sm c44168sm = (C44168sm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44168sm.jVD = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11736);
                    return 0;
                case 2:
                    c44168sm.jVE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11736);
                    return 0;
                case 3:
                    c44168sm.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11736);
                    return 0;
                case 4:
                    c44168sm.path = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11736);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11736);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11736);
            return -1;
        }
    }
}
