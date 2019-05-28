package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.azg */
public final class azg extends C1331a {
    public String csB;
    public String kKY;
    public int kLb;
    public String wDa;
    public String wDb;
    public String wDc;
    public String wDd;
    public int wDe;
    public String wDf;
    public int wDg;
    public int wDh;
    public String wDi;
    public int wDj;
    public int wDk;
    public String wDl;
    public int wDm;
    public int wDn;
    public String wDo;
    public String wDp;
    public String wDq;
    public String wDr;
    public int wcR;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80121);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.csB != null) {
                c6093a.mo13475e(1, this.csB);
            }
            if (this.wDa != null) {
                c6093a.mo13475e(20, this.wDa);
            }
            if (this.wDb != null) {
                c6093a.mo13475e(21, this.wDb);
            }
            if (this.wDc != null) {
                c6093a.mo13475e(22, this.wDc);
            }
            if (this.wDd != null) {
                c6093a.mo13475e(23, this.wDd);
            }
            if (this.kKY != null) {
                c6093a.mo13475e(31, this.kKY);
            }
            c6093a.mo13480iz(32, this.kLb);
            c6093a.mo13480iz(33, this.wDe);
            if (this.wDf != null) {
                c6093a.mo13475e(34, this.wDf);
            }
            c6093a.mo13480iz(35, this.wDg);
            c6093a.mo13480iz(36, this.wDh);
            if (this.wDi != null) {
                c6093a.mo13475e(37, this.wDi);
            }
            c6093a.mo13480iz(38, this.wDj);
            c6093a.mo13480iz(39, this.wDk);
            if (this.wDl != null) {
                c6093a.mo13475e(41, this.wDl);
            }
            c6093a.mo13480iz(200, this.wDm);
            c6093a.mo13480iz(201, this.wDn);
            c6093a.mo13480iz(202, this.wcR);
            if (this.wDo != null) {
                c6093a.mo13475e(203, this.wDo);
            }
            if (this.wDp != null) {
                c6093a.mo13475e(204, this.wDp);
            }
            if (this.wDq != null) {
                c6093a.mo13475e(205, this.wDq);
            }
            if (this.wDr != null) {
                c6093a.mo13475e(206, this.wDr);
            }
            AppMethodBeat.m2505o(80121);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = C6091a.m9575f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.wDa != null) {
                f += C6091a.m9575f(20, this.wDa);
            }
            if (this.wDb != null) {
                f += C6091a.m9575f(21, this.wDb);
            }
            if (this.wDc != null) {
                f += C6091a.m9575f(22, this.wDc);
            }
            if (this.wDd != null) {
                f += C6091a.m9575f(23, this.wDd);
            }
            if (this.kKY != null) {
                f += C6091a.m9575f(31, this.kKY);
            }
            f = (f + C6091a.m9572bs(32, this.kLb)) + C6091a.m9572bs(33, this.wDe);
            if (this.wDf != null) {
                f += C6091a.m9575f(34, this.wDf);
            }
            f = (f + C6091a.m9572bs(35, this.wDg)) + C6091a.m9572bs(36, this.wDh);
            if (this.wDi != null) {
                f += C6091a.m9575f(37, this.wDi);
            }
            f = (f + C6091a.m9572bs(38, this.wDj)) + C6091a.m9572bs(39, this.wDk);
            if (this.wDl != null) {
                f += C6091a.m9575f(41, this.wDl);
            }
            f = ((f + C6091a.m9572bs(200, this.wDm)) + C6091a.m9572bs(201, this.wDn)) + C6091a.m9572bs(202, this.wcR);
            if (this.wDo != null) {
                f += C6091a.m9575f(203, this.wDo);
            }
            if (this.wDp != null) {
                f += C6091a.m9575f(204, this.wDp);
            }
            if (this.wDq != null) {
                f += C6091a.m9575f(205, this.wDq);
            }
            if (this.wDr != null) {
                f += C6091a.m9575f(206, this.wDr);
            }
            AppMethodBeat.m2505o(80121);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80121);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            azg azg = (azg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    azg.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 20:
                    azg.wDa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 21:
                    azg.wDb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 22:
                    azg.wDc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 23:
                    azg.wDd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 31:
                    azg.kKY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 32:
                    azg.kLb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 33:
                    azg.wDe = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 34:
                    azg.wDf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 35:
                    azg.wDg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 36:
                    azg.wDh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case C2275g.CTRL_INDEX /*37*/:
                    azg.wDi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 38:
                    azg.wDj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 39:
                    azg.wDk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 41:
                    azg.wDl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 200:
                    azg.wDm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 201:
                    azg.wDn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 202:
                    azg.wcR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 203:
                    azg.wDo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 204:
                    azg.wDp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 205:
                    azg.wDq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                case 206:
                    azg.wDr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80121);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80121);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80121);
            return -1;
        }
    }
}
