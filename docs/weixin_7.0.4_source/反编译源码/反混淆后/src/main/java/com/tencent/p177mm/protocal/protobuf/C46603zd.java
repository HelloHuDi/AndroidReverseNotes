package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.zd */
public final class C46603zd extends C1331a {
    public int count;
    public String csB;
    public String iAa;
    public String iAb;
    public String iAc;
    public int iAd;
    public String iAe;
    public String izZ;
    public int position;
    public String username;
    public int wez;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(134427);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.username != null) {
                c6093a.mo13475e(1, this.username);
            }
            c6093a.mo13480iz(2, this.count);
            if (this.izZ != null) {
                c6093a.mo13475e(3, this.izZ);
            }
            if (this.iAa != null) {
                c6093a.mo13475e(4, this.iAa);
            }
            c6093a.mo13480iz(5, this.wez);
            if (this.csB != null) {
                c6093a.mo13475e(6, this.csB);
            }
            if (this.iAb != null) {
                c6093a.mo13475e(7, this.iAb);
            }
            if (this.iAc != null) {
                c6093a.mo13475e(8, this.iAc);
            }
            c6093a.mo13480iz(9, this.iAd);
            if (this.iAe != null) {
                c6093a.mo13475e(10, this.iAe);
            }
            c6093a.mo13480iz(11, this.position);
            AppMethodBeat.m2505o(134427);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = C6091a.m9575f(1, this.username) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.count);
            if (this.izZ != null) {
                f += C6091a.m9575f(3, this.izZ);
            }
            if (this.iAa != null) {
                f += C6091a.m9575f(4, this.iAa);
            }
            f += C6091a.m9572bs(5, this.wez);
            if (this.csB != null) {
                f += C6091a.m9575f(6, this.csB);
            }
            if (this.iAb != null) {
                f += C6091a.m9575f(7, this.iAb);
            }
            if (this.iAc != null) {
                f += C6091a.m9575f(8, this.iAc);
            }
            f += C6091a.m9572bs(9, this.iAd);
            if (this.iAe != null) {
                f += C6091a.m9575f(10, this.iAe);
            }
            int bs = f + C6091a.m9572bs(11, this.position);
            AppMethodBeat.m2505o(134427);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(134427);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46603zd c46603zd = (C46603zd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46603zd.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 2:
                    c46603zd.count = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 3:
                    c46603zd.izZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 4:
                    c46603zd.iAa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 5:
                    c46603zd.wez = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 6:
                    c46603zd.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 7:
                    c46603zd.iAb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 8:
                    c46603zd.iAc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 9:
                    c46603zd.iAd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 10:
                    c46603zd.iAe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                case 11:
                    c46603zd.position = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134427);
                    return 0;
                default:
                    AppMethodBeat.m2505o(134427);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(134427);
            return -1;
        }
    }
}
