package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.atu */
public final class atu extends C1331a {
    public String Title;
    public String Url;
    public int jCt;
    public String ncH;
    public String vYK;
    public String wxR;
    public String wxS;
    public String wxT;
    public String wxU;
    public int wxV;
    public String wxW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28527);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            if (this.wxR != null) {
                c6093a.mo13475e(2, this.wxR);
            }
            c6093a.mo13480iz(3, this.jCt);
            if (this.Url != null) {
                c6093a.mo13475e(4, this.Url);
            }
            if (this.wxS != null) {
                c6093a.mo13475e(5, this.wxS);
            }
            if (this.vYK != null) {
                c6093a.mo13475e(6, this.vYK);
            }
            if (this.wxT != null) {
                c6093a.mo13475e(7, this.wxT);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(8, this.ncH);
            }
            if (this.wxU != null) {
                c6093a.mo13475e(9, this.wxU);
            }
            c6093a.mo13480iz(10, this.wxV);
            if (this.wxW != null) {
                c6093a.mo13475e(11, this.wxW);
            }
            AppMethodBeat.m2505o(28527);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.wxR != null) {
                f += C6091a.m9575f(2, this.wxR);
            }
            f += C6091a.m9572bs(3, this.jCt);
            if (this.Url != null) {
                f += C6091a.m9575f(4, this.Url);
            }
            if (this.wxS != null) {
                f += C6091a.m9575f(5, this.wxS);
            }
            if (this.vYK != null) {
                f += C6091a.m9575f(6, this.vYK);
            }
            if (this.wxT != null) {
                f += C6091a.m9575f(7, this.wxT);
            }
            if (this.ncH != null) {
                f += C6091a.m9575f(8, this.ncH);
            }
            if (this.wxU != null) {
                f += C6091a.m9575f(9, this.wxU);
            }
            f += C6091a.m9572bs(10, this.wxV);
            if (this.wxW != null) {
                f += C6091a.m9575f(11, this.wxW);
            }
            AppMethodBeat.m2505o(28527);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28527);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            atu atu = (atu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atu.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 2:
                    atu.wxR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 3:
                    atu.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 4:
                    atu.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 5:
                    atu.wxS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 6:
                    atu.vYK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 7:
                    atu.wxT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 8:
                    atu.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 9:
                    atu.wxU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 10:
                    atu.wxV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                case 11:
                    atu.wxW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28527);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28527);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28527);
            return -1;
        }
    }
}
