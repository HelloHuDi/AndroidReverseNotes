package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aza */
public final class aza extends C1331a {
    public String devicename;
    public String devicetype;
    public String eCq;
    public int wCN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73737);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.eCq != null) {
                c6093a.mo13475e(1, this.eCq);
            }
            if (this.devicename != null) {
                c6093a.mo13475e(2, this.devicename);
            }
            if (this.devicetype != null) {
                c6093a.mo13475e(3, this.devicetype);
            }
            c6093a.mo13480iz(4, this.wCN);
            AppMethodBeat.m2505o(73737);
            return 0;
        } else if (i == 1) {
            if (this.eCq != null) {
                f = C6091a.m9575f(1, this.eCq) + 0;
            } else {
                f = 0;
            }
            if (this.devicename != null) {
                f += C6091a.m9575f(2, this.devicename);
            }
            if (this.devicetype != null) {
                f += C6091a.m9575f(3, this.devicetype);
            }
            int bs = f + C6091a.m9572bs(4, this.wCN);
            AppMethodBeat.m2505o(73737);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73737);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aza aza = (aza) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aza.eCq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73737);
                    return 0;
                case 2:
                    aza.devicename = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73737);
                    return 0;
                case 3:
                    aza.devicetype = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73737);
                    return 0;
                case 4:
                    aza.wCN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73737);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73737);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73737);
            return -1;
        }
    }
}
