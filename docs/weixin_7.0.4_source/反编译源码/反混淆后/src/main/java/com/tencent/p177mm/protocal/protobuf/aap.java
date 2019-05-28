package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aap */
public final class aap extends C1331a {
    public String appId;
    public int cBc;
    public String csu;
    public String iconUrl;
    public int type;
    public String username;
    public String wfO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51388);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.username != null) {
                c6093a.mo13475e(1, this.username);
            }
            if (this.appId != null) {
                c6093a.mo13475e(2, this.appId);
            }
            c6093a.mo13480iz(3, this.cBc);
            if (this.iconUrl != null) {
                c6093a.mo13475e(4, this.iconUrl);
            }
            c6093a.mo13480iz(5, this.type);
            if (this.csu != null) {
                c6093a.mo13475e(6, this.csu);
            }
            if (this.wfO != null) {
                c6093a.mo13475e(7, this.wfO);
            }
            AppMethodBeat.m2505o(51388);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = C6091a.m9575f(1, this.username) + 0;
            } else {
                f = 0;
            }
            if (this.appId != null) {
                f += C6091a.m9575f(2, this.appId);
            }
            f += C6091a.m9572bs(3, this.cBc);
            if (this.iconUrl != null) {
                f += C6091a.m9575f(4, this.iconUrl);
            }
            f += C6091a.m9572bs(5, this.type);
            if (this.csu != null) {
                f += C6091a.m9575f(6, this.csu);
            }
            if (this.wfO != null) {
                f += C6091a.m9575f(7, this.wfO);
            }
            AppMethodBeat.m2505o(51388);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51388);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aap aap = (aap) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aap.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51388);
                    return 0;
                case 2:
                    aap.appId = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51388);
                    return 0;
                case 3:
                    aap.cBc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51388);
                    return 0;
                case 4:
                    aap.iconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51388);
                    return 0;
                case 5:
                    aap.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51388);
                    return 0;
                case 6:
                    aap.csu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51388);
                    return 0;
                case 7:
                    aap.wfO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51388);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51388);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51388);
            return -1;
        }
    }
}
