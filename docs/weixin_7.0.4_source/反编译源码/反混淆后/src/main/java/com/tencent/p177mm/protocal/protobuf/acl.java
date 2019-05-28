package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.acl */
public final class acl extends C1331a {
    public int cyE;
    /* renamed from: id */
    public String f17913id;
    public int mwG;
    public String wkh;
    public long wki;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28409);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f17913id != null) {
                c6093a.mo13475e(1, this.f17913id);
            }
            c6093a.mo13480iz(2, this.mwG);
            if (this.wkh != null) {
                c6093a.mo13475e(3, this.wkh);
            }
            c6093a.mo13472ai(4, this.wki);
            c6093a.mo13480iz(5, this.cyE);
            AppMethodBeat.m2505o(28409);
            return 0;
        } else if (i == 1) {
            if (this.f17913id != null) {
                f = C6091a.m9575f(1, this.f17913id) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.mwG);
            if (this.wkh != null) {
                f += C6091a.m9575f(3, this.wkh);
            }
            int o = (f + C6091a.m9578o(4, this.wki)) + C6091a.m9572bs(5, this.cyE);
            AppMethodBeat.m2505o(28409);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28409);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            acl acl = (acl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acl.f17913id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28409);
                    return 0;
                case 2:
                    acl.mwG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28409);
                    return 0;
                case 3:
                    acl.wkh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28409);
                    return 0;
                case 4:
                    acl.wki = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28409);
                    return 0;
                case 5:
                    acl.cyE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28409);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28409);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28409);
            return -1;
        }
    }
}
