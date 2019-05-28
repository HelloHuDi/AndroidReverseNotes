package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chp */
public final class chp extends C1331a {
    public int Scene;
    public String Title;
    public String ncM;
    public int vFH;
    public int vGB;
    public String wDM;
    public String wUo;
    public String wbI;
    public String xgs;
    public String xgt;
    public String xgu;
    public String xgv;
    public String xgw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124367);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xgs != null) {
                c6093a.mo13475e(1, this.xgs);
            }
            if (this.wUo != null) {
                c6093a.mo13475e(2, this.wUo);
            }
            if (this.ncM != null) {
                c6093a.mo13475e(3, this.ncM);
            }
            if (this.xgt != null) {
                c6093a.mo13475e(4, this.xgt);
            }
            if (this.xgu != null) {
                c6093a.mo13475e(5, this.xgu);
            }
            if (this.xgv != null) {
                c6093a.mo13475e(6, this.xgv);
            }
            if (this.Title != null) {
                c6093a.mo13475e(7, this.Title);
            }
            if (this.wDM != null) {
                c6093a.mo13475e(8, this.wDM);
            }
            c6093a.mo13480iz(9, this.Scene);
            c6093a.mo13480iz(10, this.vGB);
            if (this.xgw != null) {
                c6093a.mo13475e(11, this.xgw);
            }
            if (this.wbI != null) {
                c6093a.mo13475e(12, this.wbI);
            }
            c6093a.mo13480iz(13, this.vFH);
            AppMethodBeat.m2505o(124367);
            return 0;
        } else if (i == 1) {
            if (this.xgs != null) {
                f = C6091a.m9575f(1, this.xgs) + 0;
            } else {
                f = 0;
            }
            if (this.wUo != null) {
                f += C6091a.m9575f(2, this.wUo);
            }
            if (this.ncM != null) {
                f += C6091a.m9575f(3, this.ncM);
            }
            if (this.xgt != null) {
                f += C6091a.m9575f(4, this.xgt);
            }
            if (this.xgu != null) {
                f += C6091a.m9575f(5, this.xgu);
            }
            if (this.xgv != null) {
                f += C6091a.m9575f(6, this.xgv);
            }
            if (this.Title != null) {
                f += C6091a.m9575f(7, this.Title);
            }
            if (this.wDM != null) {
                f += C6091a.m9575f(8, this.wDM);
            }
            f = (f + C6091a.m9572bs(9, this.Scene)) + C6091a.m9572bs(10, this.vGB);
            if (this.xgw != null) {
                f += C6091a.m9575f(11, this.xgw);
            }
            if (this.wbI != null) {
                f += C6091a.m9575f(12, this.wbI);
            }
            int bs = f + C6091a.m9572bs(13, this.vFH);
            AppMethodBeat.m2505o(124367);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124367);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chp chp = (chp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    chp.xgs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 2:
                    chp.wUo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 3:
                    chp.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 4:
                    chp.xgt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 5:
                    chp.xgu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 6:
                    chp.xgv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 7:
                    chp.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 8:
                    chp.wDM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 9:
                    chp.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 10:
                    chp.vGB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 11:
                    chp.xgw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 12:
                    chp.wbI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                case 13:
                    chp.vFH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124367);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124367);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124367);
            return -1;
        }
    }
}
