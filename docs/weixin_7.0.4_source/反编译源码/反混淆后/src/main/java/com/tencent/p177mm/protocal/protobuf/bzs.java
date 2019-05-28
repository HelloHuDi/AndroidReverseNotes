package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bzs */
public final class bzs extends C1331a {
    public int actionType;
    public String cEh;
    public String cIY;
    /* renamed from: id */
    public String f4415id;
    public String jcF;
    public String title;
    public String url;
    public long wYN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55701);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f4415id != null) {
                c6093a.mo13475e(1, this.f4415id);
            }
            if (this.cEh != null) {
                c6093a.mo13475e(2, this.cEh);
            }
            c6093a.mo13472ai(3, this.wYN);
            c6093a.mo13480iz(4, this.actionType);
            if (this.url != null) {
                c6093a.mo13475e(5, this.url);
            }
            if (this.title != null) {
                c6093a.mo13475e(6, this.title);
            }
            if (this.jcF != null) {
                c6093a.mo13475e(7, this.jcF);
            }
            if (this.cIY != null) {
                c6093a.mo13475e(8, this.cIY);
            }
            AppMethodBeat.m2505o(55701);
            return 0;
        } else if (i == 1) {
            if (this.f4415id != null) {
                f = C6091a.m9575f(1, this.f4415id) + 0;
            } else {
                f = 0;
            }
            if (this.cEh != null) {
                f += C6091a.m9575f(2, this.cEh);
            }
            f = (f + C6091a.m9578o(3, this.wYN)) + C6091a.m9572bs(4, this.actionType);
            if (this.url != null) {
                f += C6091a.m9575f(5, this.url);
            }
            if (this.title != null) {
                f += C6091a.m9575f(6, this.title);
            }
            if (this.jcF != null) {
                f += C6091a.m9575f(7, this.jcF);
            }
            if (this.cIY != null) {
                f += C6091a.m9575f(8, this.cIY);
            }
            AppMethodBeat.m2505o(55701);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55701);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bzs bzs = (bzs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzs.f4415id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55701);
                    return 0;
                case 2:
                    bzs.cEh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55701);
                    return 0;
                case 3:
                    bzs.wYN = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55701);
                    return 0;
                case 4:
                    bzs.actionType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55701);
                    return 0;
                case 5:
                    bzs.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55701);
                    return 0;
                case 6:
                    bzs.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55701);
                    return 0;
                case 7:
                    bzs.jcF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55701);
                    return 0;
                case 8:
                    bzs.cIY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55701);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55701);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55701);
            return -1;
        }
    }
}
