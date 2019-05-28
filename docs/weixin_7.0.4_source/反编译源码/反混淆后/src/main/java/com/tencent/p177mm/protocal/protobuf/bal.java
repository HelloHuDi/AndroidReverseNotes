package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bal */
public final class bal extends C1331a {
    public String bssid;
    public String cuH;
    public int cyC;
    public int mue;
    public String ssid;
    public int wEh;
    public String wEi;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28547);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ssid != null) {
                c6093a.mo13475e(1, this.ssid);
            }
            if (this.bssid != null) {
                c6093a.mo13475e(2, this.bssid);
            }
            c6093a.mo13480iz(3, this.cyC);
            c6093a.mo13480iz(4, this.wEh);
            if (this.wEi != null) {
                c6093a.mo13475e(5, this.wEi);
            }
            if (this.cuH != null) {
                c6093a.mo13475e(6, this.cuH);
            }
            c6093a.mo13480iz(7, this.mue);
            AppMethodBeat.m2505o(28547);
            return 0;
        } else if (i == 1) {
            if (this.ssid != null) {
                f = C6091a.m9575f(1, this.ssid) + 0;
            } else {
                f = 0;
            }
            if (this.bssid != null) {
                f += C6091a.m9575f(2, this.bssid);
            }
            f = (f + C6091a.m9572bs(3, this.cyC)) + C6091a.m9572bs(4, this.wEh);
            if (this.wEi != null) {
                f += C6091a.m9575f(5, this.wEi);
            }
            if (this.cuH != null) {
                f += C6091a.m9575f(6, this.cuH);
            }
            int bs = f + C6091a.m9572bs(7, this.mue);
            AppMethodBeat.m2505o(28547);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28547);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bal bal = (bal) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bal.ssid = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28547);
                    return 0;
                case 2:
                    bal.bssid = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28547);
                    return 0;
                case 3:
                    bal.cyC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28547);
                    return 0;
                case 4:
                    bal.wEh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28547);
                    return 0;
                case 5:
                    bal.wEi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28547);
                    return 0;
                case 6:
                    bal.cuH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28547);
                    return 0;
                case 7:
                    bal.mue = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28547);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28547);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28547);
            return -1;
        }
    }
}
