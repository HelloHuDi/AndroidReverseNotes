package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.t */
public final class C35955t extends C1331a {
    public String vAh;
    public long vAi;
    public int vAj;
    public long vzU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56688);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vAh != null) {
                c6093a.mo13475e(1, this.vAh);
            }
            c6093a.mo13472ai(2, this.vzU);
            c6093a.mo13472ai(3, this.vAi);
            c6093a.mo13480iz(4, this.vAj);
            AppMethodBeat.m2505o(56688);
            return 0;
        } else if (i == 1) {
            if (this.vAh != null) {
                f = C6091a.m9575f(1, this.vAh) + 0;
            } else {
                f = 0;
            }
            int o = ((f + C6091a.m9578o(2, this.vzU)) + C6091a.m9578o(3, this.vAi)) + C6091a.m9572bs(4, this.vAj);
            AppMethodBeat.m2505o(56688);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56688);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35955t c35955t = (C35955t) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35955t.vAh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56688);
                    return 0;
                case 2:
                    c35955t.vzU = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56688);
                    return 0;
                case 3:
                    c35955t.vAi = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56688);
                    return 0;
                case 4:
                    c35955t.vAj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56688);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56688);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56688);
            return -1;
        }
    }
}
