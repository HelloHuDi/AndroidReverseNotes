package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.btx */
public final class btx extends C1331a {
    public int jBv;
    public String wOG;
    public String wOH;
    public String wrm;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56962);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wrm != null) {
                c6093a.mo13475e(1, this.wrm);
            }
            if (this.wOH != null) {
                c6093a.mo13475e(2, this.wOH);
            }
            c6093a.mo13480iz(3, this.jBv);
            if (this.wOG != null) {
                c6093a.mo13475e(4, this.wOG);
            }
            AppMethodBeat.m2505o(56962);
            return 0;
        } else if (i == 1) {
            if (this.wrm != null) {
                f = C6091a.m9575f(1, this.wrm) + 0;
            } else {
                f = 0;
            }
            if (this.wOH != null) {
                f += C6091a.m9575f(2, this.wOH);
            }
            f += C6091a.m9572bs(3, this.jBv);
            if (this.wOG != null) {
                f += C6091a.m9575f(4, this.wOG);
            }
            AppMethodBeat.m2505o(56962);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56962);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            btx btx = (btx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btx.wrm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56962);
                    return 0;
                case 2:
                    btx.wOH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56962);
                    return 0;
                case 3:
                    btx.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56962);
                    return 0;
                case 4:
                    btx.wOG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56962);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56962);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56962);
            return -1;
        }
    }
}
