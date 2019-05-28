package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.atf */
public final class atf extends C1331a {
    public String pLH;
    public int state;
    public String title;
    public String vPX;
    public String wxf;
    public long wxg;
    public String wxh;
    public String wxi;
    public String wxj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48866);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vPX != null) {
                c6093a.mo13475e(1, this.vPX);
            }
            c6093a.mo13480iz(2, this.state);
            if (this.title != null) {
                c6093a.mo13475e(3, this.title);
            }
            if (this.wxf != null) {
                c6093a.mo13475e(4, this.wxf);
            }
            c6093a.mo13472ai(5, this.wxg);
            if (this.wxh != null) {
                c6093a.mo13475e(6, this.wxh);
            }
            if (this.pLH != null) {
                c6093a.mo13475e(7, this.pLH);
            }
            if (this.wxi != null) {
                c6093a.mo13475e(8, this.wxi);
            }
            if (this.wxj != null) {
                c6093a.mo13475e(9, this.wxj);
            }
            AppMethodBeat.m2505o(48866);
            return 0;
        } else if (i == 1) {
            if (this.vPX != null) {
                f = C6091a.m9575f(1, this.vPX) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.state);
            if (this.title != null) {
                f += C6091a.m9575f(3, this.title);
            }
            if (this.wxf != null) {
                f += C6091a.m9575f(4, this.wxf);
            }
            f += C6091a.m9578o(5, this.wxg);
            if (this.wxh != null) {
                f += C6091a.m9575f(6, this.wxh);
            }
            if (this.pLH != null) {
                f += C6091a.m9575f(7, this.pLH);
            }
            if (this.wxi != null) {
                f += C6091a.m9575f(8, this.wxi);
            }
            if (this.wxj != null) {
                f += C6091a.m9575f(9, this.wxj);
            }
            AppMethodBeat.m2505o(48866);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48866);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            atf atf = (atf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    atf.vPX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48866);
                    return 0;
                case 2:
                    atf.state = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48866);
                    return 0;
                case 3:
                    atf.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48866);
                    return 0;
                case 4:
                    atf.wxf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48866);
                    return 0;
                case 5:
                    atf.wxg = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(48866);
                    return 0;
                case 6:
                    atf.wxh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48866);
                    return 0;
                case 7:
                    atf.pLH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48866);
                    return 0;
                case 8:
                    atf.wxi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48866);
                    return 0;
                case 9:
                    atf.wxj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48866);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48866);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48866);
            return -1;
        }
    }
}
