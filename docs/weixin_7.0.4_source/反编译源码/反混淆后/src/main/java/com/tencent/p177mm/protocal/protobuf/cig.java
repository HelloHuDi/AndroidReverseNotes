package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cig */
public final class cig extends C1331a {
    public String AesKey;
    public String vRA;
    public int xhn;
    public int xho;
    public long xhp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51437);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.xhn);
            if (this.vRA != null) {
                c6093a.mo13475e(2, this.vRA);
            }
            if (this.AesKey != null) {
                c6093a.mo13475e(3, this.AesKey);
            }
            c6093a.mo13480iz(4, this.xho);
            c6093a.mo13472ai(5, this.xhp);
            AppMethodBeat.m2505o(51437);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.xhn) + 0;
            if (this.vRA != null) {
                bs += C6091a.m9575f(2, this.vRA);
            }
            if (this.AesKey != null) {
                bs += C6091a.m9575f(3, this.AesKey);
            }
            bs = (bs + C6091a.m9572bs(4, this.xho)) + C6091a.m9578o(5, this.xhp);
            AppMethodBeat.m2505o(51437);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51437);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cig cig = (cig) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cig.xhn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51437);
                    return 0;
                case 2:
                    cig.vRA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51437);
                    return 0;
                case 3:
                    cig.AesKey = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51437);
                    return 0;
                case 4:
                    cig.xho = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51437);
                    return 0;
                case 5:
                    cig.xhp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(51437);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51437);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51437);
            return -1;
        }
    }
}
