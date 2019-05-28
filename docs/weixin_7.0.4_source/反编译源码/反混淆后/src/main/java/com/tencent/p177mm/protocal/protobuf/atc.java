package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.atc */
public final class atc extends C1331a {
    public String wwU;
    public String wwV;
    public String wwW;
    public String wwX;
    public String wwY;
    public String wwZ;
    public String wxa;
    public String wxb;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56844);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wwU != null) {
                c6093a.mo13475e(1, this.wwU);
            }
            if (this.wwV != null) {
                c6093a.mo13475e(2, this.wwV);
            }
            if (this.wwW != null) {
                c6093a.mo13475e(3, this.wwW);
            }
            if (this.wwX != null) {
                c6093a.mo13475e(4, this.wwX);
            }
            if (this.wwY != null) {
                c6093a.mo13475e(5, this.wwY);
            }
            if (this.wwZ != null) {
                c6093a.mo13475e(6, this.wwZ);
            }
            if (this.wxa != null) {
                c6093a.mo13475e(7, this.wxa);
            }
            if (this.wxb != null) {
                c6093a.mo13475e(8, this.wxb);
            }
            AppMethodBeat.m2505o(56844);
            return 0;
        } else if (i == 1) {
            if (this.wwU != null) {
                f = C6091a.m9575f(1, this.wwU) + 0;
            } else {
                f = 0;
            }
            if (this.wwV != null) {
                f += C6091a.m9575f(2, this.wwV);
            }
            if (this.wwW != null) {
                f += C6091a.m9575f(3, this.wwW);
            }
            if (this.wwX != null) {
                f += C6091a.m9575f(4, this.wwX);
            }
            if (this.wwY != null) {
                f += C6091a.m9575f(5, this.wwY);
            }
            if (this.wwZ != null) {
                f += C6091a.m9575f(6, this.wwZ);
            }
            if (this.wxa != null) {
                f += C6091a.m9575f(7, this.wxa);
            }
            if (this.wxb != null) {
                f += C6091a.m9575f(8, this.wxb);
            }
            AppMethodBeat.m2505o(56844);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56844);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            atc atc = (atc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atc.wwU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56844);
                    return 0;
                case 2:
                    atc.wwV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56844);
                    return 0;
                case 3:
                    atc.wwW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56844);
                    return 0;
                case 4:
                    atc.wwX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56844);
                    return 0;
                case 5:
                    atc.wwY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56844);
                    return 0;
                case 6:
                    atc.wwZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56844);
                    return 0;
                case 7:
                    atc.wxa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56844);
                    return 0;
                case 8:
                    atc.wxb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56844);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56844);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56844);
            return -1;
        }
    }
}
