package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chr */
public final class chr extends C1331a {
    public int Scene;
    public int nbk;
    public String ncM;
    public int vFH;
    public int vGB;
    public String wDM;
    public String wUo;
    public String wbI;
    public String xgs;
    public String xgw;
    public String xgx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124369);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wUo != null) {
                c6093a.mo13475e(1, this.wUo);
            }
            if (this.xgx != null) {
                c6093a.mo13475e(2, this.xgx);
            }
            c6093a.mo13480iz(3, this.nbk);
            if (this.xgs != null) {
                c6093a.mo13475e(4, this.xgs);
            }
            if (this.ncM != null) {
                c6093a.mo13475e(5, this.ncM);
            }
            c6093a.mo13480iz(6, this.Scene);
            if (this.wDM != null) {
                c6093a.mo13475e(7, this.wDM);
            }
            c6093a.mo13480iz(8, this.vGB);
            if (this.wbI != null) {
                c6093a.mo13475e(9, this.wbI);
            }
            if (this.xgw != null) {
                c6093a.mo13475e(10, this.xgw);
            }
            c6093a.mo13480iz(11, this.vFH);
            AppMethodBeat.m2505o(124369);
            return 0;
        } else if (i == 1) {
            if (this.wUo != null) {
                f = C6091a.m9575f(1, this.wUo) + 0;
            } else {
                f = 0;
            }
            if (this.xgx != null) {
                f += C6091a.m9575f(2, this.xgx);
            }
            f += C6091a.m9572bs(3, this.nbk);
            if (this.xgs != null) {
                f += C6091a.m9575f(4, this.xgs);
            }
            if (this.ncM != null) {
                f += C6091a.m9575f(5, this.ncM);
            }
            f += C6091a.m9572bs(6, this.Scene);
            if (this.wDM != null) {
                f += C6091a.m9575f(7, this.wDM);
            }
            f += C6091a.m9572bs(8, this.vGB);
            if (this.wbI != null) {
                f += C6091a.m9575f(9, this.wbI);
            }
            if (this.xgw != null) {
                f += C6091a.m9575f(10, this.xgw);
            }
            int bs = f + C6091a.m9572bs(11, this.vFH);
            AppMethodBeat.m2505o(124369);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124369);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chr chr = (chr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chr.wUo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 2:
                    chr.xgx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 3:
                    chr.nbk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 4:
                    chr.xgs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 5:
                    chr.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 6:
                    chr.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 7:
                    chr.wDM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 8:
                    chr.vGB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 9:
                    chr.wbI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 10:
                    chr.xgw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                case 11:
                    chr.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124369);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124369);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124369);
            return -1;
        }
    }
}
