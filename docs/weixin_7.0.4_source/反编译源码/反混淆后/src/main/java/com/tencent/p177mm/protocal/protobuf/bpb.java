package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bpb */
public final class bpb extends C1331a {
    public String SmallImgUrl;
    public String jBB;
    public String jCH;
    public int wRw;
    public String wfK;
    public String wlF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102516);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB != null) {
                c6093a.mo13475e(1, this.jBB);
            }
            c6093a.mo13480iz(2, this.wRw);
            if (this.jCH != null) {
                c6093a.mo13475e(3, this.jCH);
            }
            if (this.SmallImgUrl != null) {
                c6093a.mo13475e(4, this.SmallImgUrl);
            }
            if (this.wfK != null) {
                c6093a.mo13475e(5, this.wfK);
            }
            if (this.wlF != null) {
                c6093a.mo13475e(6, this.wlF);
            }
            AppMethodBeat.m2505o(102516);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = C6091a.m9575f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wRw);
            if (this.jCH != null) {
                f += C6091a.m9575f(3, this.jCH);
            }
            if (this.SmallImgUrl != null) {
                f += C6091a.m9575f(4, this.SmallImgUrl);
            }
            if (this.wfK != null) {
                f += C6091a.m9575f(5, this.wfK);
            }
            if (this.wlF != null) {
                f += C6091a.m9575f(6, this.wlF);
            }
            AppMethodBeat.m2505o(102516);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102516);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bpb bpb = (bpb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bpb.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102516);
                    return 0;
                case 2:
                    bpb.wRw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102516);
                    return 0;
                case 3:
                    bpb.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102516);
                    return 0;
                case 4:
                    bpb.SmallImgUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102516);
                    return 0;
                case 5:
                    bpb.wfK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102516);
                    return 0;
                case 6:
                    bpb.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102516);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102516);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102516);
            return -1;
        }
    }
}
