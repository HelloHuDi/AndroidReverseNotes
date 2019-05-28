package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.jd */
public final class C23403jd extends C1331a {
    public String kKZ;
    public String nickname;
    public String username;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96209);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.username != null) {
                c6093a.mo13475e(1, this.username);
            }
            if (this.kKZ != null) {
                c6093a.mo13475e(2, this.kKZ);
            }
            if (this.nickname != null) {
                c6093a.mo13475e(3, this.nickname);
            }
            AppMethodBeat.m2505o(96209);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = C6091a.m9575f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.kKZ != null) {
                f += C6091a.m9575f(2, this.kKZ);
            }
            if (this.nickname != null) {
                f += C6091a.m9575f(3, this.nickname);
            }
            AppMethodBeat.m2505o(96209);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96209);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23403jd c23403jd = (C23403jd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23403jd.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96209);
                    return 0;
                case 2:
                    c23403jd.kKZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96209);
                    return 0;
                case 3:
                    c23403jd.nickname = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96209);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96209);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96209);
            return -1;
        }
    }
}
