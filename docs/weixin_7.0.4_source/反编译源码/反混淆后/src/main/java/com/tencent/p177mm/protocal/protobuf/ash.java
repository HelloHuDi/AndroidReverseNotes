package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ash */
public final class ash extends C1331a {
    public String nSa;
    public String nickname;
    public String username;
    public long wvQ;
    public long wvR;
    public int wvS;
    public String wvT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56842);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.wvQ);
            c6093a.mo13472ai(2, this.wvR);
            if (this.nickname != null) {
                c6093a.mo13475e(3, this.nickname);
            }
            if (this.nSa != null) {
                c6093a.mo13475e(4, this.nSa);
            }
            c6093a.mo13480iz(5, this.wvS);
            if (this.username != null) {
                c6093a.mo13475e(6, this.username);
            }
            if (this.wvT != null) {
                c6093a.mo13475e(7, this.wvT);
            }
            AppMethodBeat.m2505o(56842);
            return 0;
        } else if (i == 1) {
            o = (C6091a.m9578o(1, this.wvQ) + 0) + C6091a.m9578o(2, this.wvR);
            if (this.nickname != null) {
                o += C6091a.m9575f(3, this.nickname);
            }
            if (this.nSa != null) {
                o += C6091a.m9575f(4, this.nSa);
            }
            o += C6091a.m9572bs(5, this.wvS);
            if (this.username != null) {
                o += C6091a.m9575f(6, this.username);
            }
            if (this.wvT != null) {
                o += C6091a.m9575f(7, this.wvT);
            }
            AppMethodBeat.m2505o(56842);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56842);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ash ash = (ash) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ash.wvQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56842);
                    return 0;
                case 2:
                    ash.wvR = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56842);
                    return 0;
                case 3:
                    ash.nickname = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56842);
                    return 0;
                case 4:
                    ash.nSa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56842);
                    return 0;
                case 5:
                    ash.wvS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56842);
                    return 0;
                case 6:
                    ash.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56842);
                    return 0;
                case 7:
                    ash.wvT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56842);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56842);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56842);
            return -1;
        }
    }
}
