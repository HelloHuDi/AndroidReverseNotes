package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.uy */
public final class C7285uy extends C1331a {
    public int gvb;
    public String gvc;
    public String gvd;
    public String gve;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60028);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.gvb);
            if (this.gvc != null) {
                c6093a.mo13475e(2, this.gvc);
            }
            if (this.gvd != null) {
                c6093a.mo13475e(3, this.gvd);
            }
            if (this.gve != null) {
                c6093a.mo13475e(4, this.gve);
            }
            AppMethodBeat.m2505o(60028);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.gvb) + 0;
            if (this.gvc != null) {
                bs += C6091a.m9575f(2, this.gvc);
            }
            if (this.gvd != null) {
                bs += C6091a.m9575f(3, this.gvd);
            }
            if (this.gve != null) {
                bs += C6091a.m9575f(4, this.gve);
            }
            AppMethodBeat.m2505o(60028);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(60028);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7285uy c7285uy = (C7285uy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7285uy.gvb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(60028);
                    return 0;
                case 2:
                    c7285uy.gvc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60028);
                    return 0;
                case 3:
                    c7285uy.gvd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60028);
                    return 0;
                case 4:
                    c7285uy.gve = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(60028);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60028);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60028);
            return -1;
        }
    }
}
