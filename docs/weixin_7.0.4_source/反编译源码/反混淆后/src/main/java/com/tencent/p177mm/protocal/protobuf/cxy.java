package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cxy */
public final class cxy extends C1331a {
    public String csB;
    public int iCZ;
    public int iDa;
    public int type;
    public String xts;
    public String xtt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96346);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.type);
            if (this.csB != null) {
                c6093a.mo13475e(2, this.csB);
            }
            if (this.xts != null) {
                c6093a.mo13475e(3, this.xts);
            }
            if (this.xtt != null) {
                c6093a.mo13475e(4, this.xtt);
            }
            c6093a.mo13480iz(5, this.iCZ);
            c6093a.mo13480iz(6, this.iDa);
            AppMethodBeat.m2505o(96346);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.type) + 0;
            if (this.csB != null) {
                bs += C6091a.m9575f(2, this.csB);
            }
            if (this.xts != null) {
                bs += C6091a.m9575f(3, this.xts);
            }
            if (this.xtt != null) {
                bs += C6091a.m9575f(4, this.xtt);
            }
            bs = (bs + C6091a.m9572bs(5, this.iCZ)) + C6091a.m9572bs(6, this.iDa);
            AppMethodBeat.m2505o(96346);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96346);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cxy cxy = (cxy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxy.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96346);
                    return 0;
                case 2:
                    cxy.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96346);
                    return 0;
                case 3:
                    cxy.xts = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96346);
                    return 0;
                case 4:
                    cxy.xtt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96346);
                    return 0;
                case 5:
                    cxy.iCZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96346);
                    return 0;
                case 6:
                    cxy.iDa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96346);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96346);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96346);
            return -1;
        }
    }
}
