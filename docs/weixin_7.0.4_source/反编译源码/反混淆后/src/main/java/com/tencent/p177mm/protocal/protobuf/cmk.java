package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cmk */
public final class cmk extends C1331a {
    public String IconUrl;
    public String jBF;
    public String ncH;
    public String vIk;
    public String wLX;
    public String wbq;
    public String wwn;
    public long xkn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28694);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wbq != null) {
                c6093a.mo13475e(1, this.wbq);
            }
            if (this.vIk != null) {
                c6093a.mo13475e(2, this.vIk);
            }
            if (this.wLX != null) {
                c6093a.mo13475e(3, this.wLX);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(4, this.ncH);
            }
            if (this.jBF != null) {
                c6093a.mo13475e(5, this.jBF);
            }
            if (this.IconUrl != null) {
                c6093a.mo13475e(6, this.IconUrl);
            }
            if (this.wwn != null) {
                c6093a.mo13475e(7, this.wwn);
            }
            c6093a.mo13472ai(8, this.xkn);
            AppMethodBeat.m2505o(28694);
            return 0;
        } else if (i == 1) {
            if (this.wbq != null) {
                f = C6091a.m9575f(1, this.wbq) + 0;
            } else {
                f = 0;
            }
            if (this.vIk != null) {
                f += C6091a.m9575f(2, this.vIk);
            }
            if (this.wLX != null) {
                f += C6091a.m9575f(3, this.wLX);
            }
            if (this.ncH != null) {
                f += C6091a.m9575f(4, this.ncH);
            }
            if (this.jBF != null) {
                f += C6091a.m9575f(5, this.jBF);
            }
            if (this.IconUrl != null) {
                f += C6091a.m9575f(6, this.IconUrl);
            }
            if (this.wwn != null) {
                f += C6091a.m9575f(7, this.wwn);
            }
            int o = f + C6091a.m9578o(8, this.xkn);
            AppMethodBeat.m2505o(28694);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28694);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cmk cmk = (cmk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cmk.wbq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28694);
                    return 0;
                case 2:
                    cmk.vIk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28694);
                    return 0;
                case 3:
                    cmk.wLX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28694);
                    return 0;
                case 4:
                    cmk.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28694);
                    return 0;
                case 5:
                    cmk.jBF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28694);
                    return 0;
                case 6:
                    cmk.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28694);
                    return 0;
                case 7:
                    cmk.wwn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28694);
                    return 0;
                case 8:
                    cmk.xkn = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(28694);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28694);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28694);
            return -1;
        }
    }
}
