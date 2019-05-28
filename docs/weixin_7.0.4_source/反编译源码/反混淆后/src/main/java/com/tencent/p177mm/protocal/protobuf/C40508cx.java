package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cx */
public final class C40508cx extends C1331a {
    public String guO;
    public String guP;
    public String guW;
    public String jBB;
    public String naq;
    public String vEV;
    public String vEW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56701);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.guW != null) {
                c6093a.mo13475e(1, this.guW);
            }
            if (this.guO != null) {
                c6093a.mo13475e(2, this.guO);
            }
            if (this.guP != null) {
                c6093a.mo13475e(3, this.guP);
            }
            if (this.naq != null) {
                c6093a.mo13475e(4, this.naq);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(5, this.jBB);
            }
            if (this.vEV != null) {
                c6093a.mo13475e(6, this.vEV);
            }
            if (this.vEW != null) {
                c6093a.mo13475e(7, this.vEW);
            }
            AppMethodBeat.m2505o(56701);
            return 0;
        } else if (i == 1) {
            if (this.guW != null) {
                f = C6091a.m9575f(1, this.guW) + 0;
            } else {
                f = 0;
            }
            if (this.guO != null) {
                f += C6091a.m9575f(2, this.guO);
            }
            if (this.guP != null) {
                f += C6091a.m9575f(3, this.guP);
            }
            if (this.naq != null) {
                f += C6091a.m9575f(4, this.naq);
            }
            if (this.jBB != null) {
                f += C6091a.m9575f(5, this.jBB);
            }
            if (this.vEV != null) {
                f += C6091a.m9575f(6, this.vEV);
            }
            if (this.vEW != null) {
                f += C6091a.m9575f(7, this.vEW);
            }
            AppMethodBeat.m2505o(56701);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56701);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40508cx c40508cx = (C40508cx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40508cx.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56701);
                    return 0;
                case 2:
                    c40508cx.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56701);
                    return 0;
                case 3:
                    c40508cx.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56701);
                    return 0;
                case 4:
                    c40508cx.naq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56701);
                    return 0;
                case 5:
                    c40508cx.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56701);
                    return 0;
                case 6:
                    c40508cx.vEV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56701);
                    return 0;
                case 7:
                    c40508cx.vEW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56701);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56701);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56701);
            return -1;
        }
    }
}
