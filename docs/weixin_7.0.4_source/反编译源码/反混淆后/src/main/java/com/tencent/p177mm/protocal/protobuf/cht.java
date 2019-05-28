package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cht */
public final class cht extends C1331a {
    public String cIY;
    public String cJb;
    public int dtW;
    public String extInfo;
    public int fQi;
    public long fRS;
    public int tZU;
    public String text;
    public int type;
    public int uaU;
    public int uaV;
    public int uaW;
    public int xgA;
    public long xgB;
    public long xgz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(55706);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cJb != null) {
                c6093a.mo13475e(1, this.cJb);
            }
            c6093a.mo13480iz(2, this.uaU);
            c6093a.mo13480iz(3, this.uaV);
            c6093a.mo13472ai(4, this.fRS);
            c6093a.mo13480iz(5, this.tZU);
            c6093a.mo13480iz(6, this.type);
            if (this.text != null) {
                c6093a.mo13475e(7, this.text);
            }
            if (this.cIY != null) {
                c6093a.mo13475e(8, this.cIY);
            }
            c6093a.mo13472ai(9, this.xgz);
            c6093a.mo13480iz(10, this.uaW);
            c6093a.mo13480iz(11, this.xgA);
            c6093a.mo13472ai(12, this.xgB);
            c6093a.mo13480iz(13, this.dtW);
            c6093a.mo13480iz(14, this.fQi);
            if (this.extInfo != null) {
                c6093a.mo13475e(15, this.extInfo);
            }
            AppMethodBeat.m2505o(55706);
            return 0;
        } else if (i == 1) {
            if (this.cJb != null) {
                f = C6091a.m9575f(1, this.cJb) + 0;
            } else {
                f = 0;
            }
            f = ((((f + C6091a.m9572bs(2, this.uaU)) + C6091a.m9572bs(3, this.uaV)) + C6091a.m9578o(4, this.fRS)) + C6091a.m9572bs(5, this.tZU)) + C6091a.m9572bs(6, this.type);
            if (this.text != null) {
                f += C6091a.m9575f(7, this.text);
            }
            if (this.cIY != null) {
                f += C6091a.m9575f(8, this.cIY);
            }
            f = (((((f + C6091a.m9578o(9, this.xgz)) + C6091a.m9572bs(10, this.uaW)) + C6091a.m9572bs(11, this.xgA)) + C6091a.m9578o(12, this.xgB)) + C6091a.m9572bs(13, this.dtW)) + C6091a.m9572bs(14, this.fQi);
            if (this.extInfo != null) {
                f += C6091a.m9575f(15, this.extInfo);
            }
            AppMethodBeat.m2505o(55706);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(55706);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cht cht = (cht) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cht.cJb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 2:
                    cht.uaU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 3:
                    cht.uaV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 4:
                    cht.fRS = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 5:
                    cht.tZU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 6:
                    cht.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 7:
                    cht.text = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 8:
                    cht.cIY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 9:
                    cht.xgz = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 10:
                    cht.uaW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 11:
                    cht.xgA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 12:
                    cht.xgB = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 13:
                    cht.dtW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 14:
                    cht.fQi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                case 15:
                    cht.extInfo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(55706);
                    return 0;
                default:
                    AppMethodBeat.m2505o(55706);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(55706);
            return -1;
        }
    }
}
