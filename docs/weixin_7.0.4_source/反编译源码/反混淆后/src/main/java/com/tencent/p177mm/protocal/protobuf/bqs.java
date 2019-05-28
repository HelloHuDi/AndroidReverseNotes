package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bqs */
public final class bqs extends C1331a {
    public String csB;
    public String path;
    public String tff;
    public int type;
    public String wTe;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56957);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.type);
            if (this.csB != null) {
                c6093a.mo13475e(2, this.csB);
            }
            if (this.wTe != null) {
                c6093a.mo13475e(3, this.wTe);
            }
            if (this.path != null) {
                c6093a.mo13475e(4, this.path);
            }
            if (this.tff != null) {
                c6093a.mo13475e(5, this.tff);
            }
            AppMethodBeat.m2505o(56957);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.type) + 0;
            if (this.csB != null) {
                bs += C6091a.m9575f(2, this.csB);
            }
            if (this.wTe != null) {
                bs += C6091a.m9575f(3, this.wTe);
            }
            if (this.path != null) {
                bs += C6091a.m9575f(4, this.path);
            }
            if (this.tff != null) {
                bs += C6091a.m9575f(5, this.tff);
            }
            AppMethodBeat.m2505o(56957);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56957);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bqs bqs = (bqs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqs.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56957);
                    return 0;
                case 2:
                    bqs.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56957);
                    return 0;
                case 3:
                    bqs.wTe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56957);
                    return 0;
                case 4:
                    bqs.path = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56957);
                    return 0;
                case 5:
                    bqs.tff = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56957);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56957);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56957);
            return -1;
        }
    }
}
