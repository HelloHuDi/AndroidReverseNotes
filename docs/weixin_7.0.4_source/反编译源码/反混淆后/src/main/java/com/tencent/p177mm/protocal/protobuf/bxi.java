package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bxi */
public final class bxi extends C1331a {
    public String nickname;
    public String username;
    public boolean wXq;
    public String wrK;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(114983);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.username != null) {
                c6093a.mo13475e(1, this.username);
            }
            c6093a.mo13471aO(2, this.wXq);
            if (this.nickname != null) {
                c6093a.mo13475e(3, this.nickname);
            }
            if (this.wrK != null) {
                c6093a.mo13475e(4, this.wrK);
            }
            AppMethodBeat.m2505o(114983);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = C6091a.m9575f(1, this.username) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9576fv(2) + 1;
            if (this.nickname != null) {
                f += C6091a.m9575f(3, this.nickname);
            }
            if (this.wrK != null) {
                f += C6091a.m9575f(4, this.wrK);
            }
            AppMethodBeat.m2505o(114983);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(114983);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bxi bxi = (bxi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bxi.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114983);
                    return 0;
                case 2:
                    bxi.wXq = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(114983);
                    return 0;
                case 3:
                    bxi.nickname = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114983);
                    return 0;
                case 4:
                    bxi.wrK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(114983);
                    return 0;
                default:
                    AppMethodBeat.m2505o(114983);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(114983);
            return -1;
        }
    }
}
