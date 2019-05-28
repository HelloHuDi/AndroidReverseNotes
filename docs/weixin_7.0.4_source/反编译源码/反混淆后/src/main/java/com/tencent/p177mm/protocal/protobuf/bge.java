package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bge */
public final class bge extends C1331a {
    public String appId;
    public String bCu;
    public String eoz;
    public String userName;
    public int wKg;
    public String wKh;
    public String wKi;
    public String wcj;
    public String wck;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80131);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.userName != null) {
                c6093a.mo13475e(1, this.userName);
            }
            if (this.bCu != null) {
                c6093a.mo13475e(2, this.bCu);
            }
            if (this.eoz != null) {
                c6093a.mo13475e(3, this.eoz);
            }
            if (this.wcj != null) {
                c6093a.mo13475e(4, this.wcj);
            }
            if (this.wck != null) {
                c6093a.mo13475e(5, this.wck);
            }
            c6093a.mo13480iz(6, this.wKg);
            if (this.appId != null) {
                c6093a.mo13475e(7, this.appId);
            }
            if (this.wKh != null) {
                c6093a.mo13475e(8, this.wKh);
            }
            if (this.wKi != null) {
                c6093a.mo13475e(9, this.wKi);
            }
            AppMethodBeat.m2505o(80131);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                f = C6091a.m9575f(1, this.userName) + 0;
            } else {
                f = 0;
            }
            if (this.bCu != null) {
                f += C6091a.m9575f(2, this.bCu);
            }
            if (this.eoz != null) {
                f += C6091a.m9575f(3, this.eoz);
            }
            if (this.wcj != null) {
                f += C6091a.m9575f(4, this.wcj);
            }
            if (this.wck != null) {
                f += C6091a.m9575f(5, this.wck);
            }
            f += C6091a.m9572bs(6, this.wKg);
            if (this.appId != null) {
                f += C6091a.m9575f(7, this.appId);
            }
            if (this.wKh != null) {
                f += C6091a.m9575f(8, this.wKh);
            }
            if (this.wKi != null) {
                f += C6091a.m9575f(9, this.wKi);
            }
            AppMethodBeat.m2505o(80131);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80131);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bge bge = (bge) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bge.userName = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80131);
                    return 0;
                case 2:
                    bge.bCu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80131);
                    return 0;
                case 3:
                    bge.eoz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80131);
                    return 0;
                case 4:
                    bge.wcj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80131);
                    return 0;
                case 5:
                    bge.wck = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80131);
                    return 0;
                case 6:
                    bge.wKg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80131);
                    return 0;
                case 7:
                    bge.appId = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80131);
                    return 0;
                case 8:
                    bge.wKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80131);
                    return 0;
                case 9:
                    bge.wKi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80131);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80131);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80131);
            return -1;
        }
    }
}
