package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ati */
public final class ati extends C1331a {
    public String cIY;
    public int iAd;
    public String kdf;
    public String vYh;
    public long wch;
    public String wpp;
    public int wxp;
    public long wxq;
    public long wxr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48870);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vYh != null) {
                c6093a.mo13475e(1, this.vYh);
            }
            c6093a.mo13472ai(2, this.wch);
            c6093a.mo13480iz(3, this.wxp);
            c6093a.mo13472ai(4, this.wxq);
            c6093a.mo13472ai(5, this.wxr);
            if (this.wpp != null) {
                c6093a.mo13475e(6, this.wpp);
            }
            if (this.kdf != null) {
                c6093a.mo13475e(7, this.kdf);
            }
            c6093a.mo13480iz(8, this.iAd);
            if (this.cIY != null) {
                c6093a.mo13475e(9, this.cIY);
            }
            AppMethodBeat.m2505o(48870);
            return 0;
        } else if (i == 1) {
            if (this.vYh != null) {
                f = C6091a.m9575f(1, this.vYh) + 0;
            } else {
                f = 0;
            }
            f = (((f + C6091a.m9578o(2, this.wch)) + C6091a.m9572bs(3, this.wxp)) + C6091a.m9578o(4, this.wxq)) + C6091a.m9578o(5, this.wxr);
            if (this.wpp != null) {
                f += C6091a.m9575f(6, this.wpp);
            }
            if (this.kdf != null) {
                f += C6091a.m9575f(7, this.kdf);
            }
            f += C6091a.m9572bs(8, this.iAd);
            if (this.cIY != null) {
                f += C6091a.m9575f(9, this.cIY);
            }
            AppMethodBeat.m2505o(48870);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48870);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ati ati = (ati) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ati.vYh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48870);
                    return 0;
                case 2:
                    ati.wch = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48870);
                    return 0;
                case 3:
                    ati.wxp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48870);
                    return 0;
                case 4:
                    ati.wxq = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48870);
                    return 0;
                case 5:
                    ati.wxr = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48870);
                    return 0;
                case 6:
                    ati.wpp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48870);
                    return 0;
                case 7:
                    ati.kdf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48870);
                    return 0;
                case 8:
                    ati.iAd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48870);
                    return 0;
                case 9:
                    ati.cIY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48870);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48870);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48870);
            return -1;
        }
    }
}
