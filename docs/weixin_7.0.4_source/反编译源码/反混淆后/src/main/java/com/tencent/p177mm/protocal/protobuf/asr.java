package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.asr */
public final class asr extends C1331a {
    public String IconUrl;
    public int dFp;
    public long dFq;
    public String dFr;
    public String dFs;
    public String dFt;
    public String dFu;
    public String guS;
    public String mZj;
    public String vHO;
    public String vKF;
    public String wwm;
    public String wwn;
    public int wwo;
    public int wwp;
    public int wwq;
    public int wwr;
    public String wws;
    public String wwt;
    public String wwu;
    public String wwv;
    public int www;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10190);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wwm != null) {
                c6093a.mo13475e(1, this.wwm);
            }
            if (this.vHO != null) {
                c6093a.mo13475e(2, this.vHO);
            }
            if (this.vKF != null) {
                c6093a.mo13475e(3, this.vKF);
            }
            if (this.wwn != null) {
                c6093a.mo13475e(4, this.wwn);
            }
            c6093a.mo13480iz(5, this.wwo);
            c6093a.mo13480iz(6, this.wwp);
            c6093a.mo13480iz(7, this.wwq);
            c6093a.mo13480iz(8, this.wwr);
            if (this.wws != null) {
                c6093a.mo13475e(9, this.wws);
            }
            if (this.guS != null) {
                c6093a.mo13475e(10, this.guS);
            }
            if (this.IconUrl != null) {
                c6093a.mo13475e(11, this.IconUrl);
            }
            if (this.mZj != null) {
                c6093a.mo13475e(12, this.mZj);
            }
            if (this.wwt != null) {
                c6093a.mo13475e(13, this.wwt);
            }
            if (this.wwu != null) {
                c6093a.mo13475e(14, this.wwu);
            }
            if (this.wwv != null) {
                c6093a.mo13475e(15, this.wwv);
            }
            c6093a.mo13480iz(16, this.www);
            c6093a.mo13480iz(17, this.dFp);
            c6093a.mo13472ai(18, this.dFq);
            if (this.dFr != null) {
                c6093a.mo13475e(19, this.dFr);
            }
            if (this.dFs != null) {
                c6093a.mo13475e(20, this.dFs);
            }
            if (this.dFt != null) {
                c6093a.mo13475e(21, this.dFt);
            }
            if (this.dFu != null) {
                c6093a.mo13475e(22, this.dFu);
            }
            AppMethodBeat.m2505o(10190);
            return 0;
        } else if (i == 1) {
            if (this.wwm != null) {
                f = C6091a.m9575f(1, this.wwm) + 0;
            } else {
                f = 0;
            }
            if (this.vHO != null) {
                f += C6091a.m9575f(2, this.vHO);
            }
            if (this.vKF != null) {
                f += C6091a.m9575f(3, this.vKF);
            }
            if (this.wwn != null) {
                f += C6091a.m9575f(4, this.wwn);
            }
            f = (((f + C6091a.m9572bs(5, this.wwo)) + C6091a.m9572bs(6, this.wwp)) + C6091a.m9572bs(7, this.wwq)) + C6091a.m9572bs(8, this.wwr);
            if (this.wws != null) {
                f += C6091a.m9575f(9, this.wws);
            }
            if (this.guS != null) {
                f += C6091a.m9575f(10, this.guS);
            }
            if (this.IconUrl != null) {
                f += C6091a.m9575f(11, this.IconUrl);
            }
            if (this.mZj != null) {
                f += C6091a.m9575f(12, this.mZj);
            }
            if (this.wwt != null) {
                f += C6091a.m9575f(13, this.wwt);
            }
            if (this.wwu != null) {
                f += C6091a.m9575f(14, this.wwu);
            }
            if (this.wwv != null) {
                f += C6091a.m9575f(15, this.wwv);
            }
            f = ((f + C6091a.m9572bs(16, this.www)) + C6091a.m9572bs(17, this.dFp)) + C6091a.m9578o(18, this.dFq);
            if (this.dFr != null) {
                f += C6091a.m9575f(19, this.dFr);
            }
            if (this.dFs != null) {
                f += C6091a.m9575f(20, this.dFs);
            }
            if (this.dFt != null) {
                f += C6091a.m9575f(21, this.dFt);
            }
            if (this.dFu != null) {
                f += C6091a.m9575f(22, this.dFu);
            }
            AppMethodBeat.m2505o(10190);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10190);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            asr asr = (asr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    asr.wwm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 2:
                    asr.vHO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 3:
                    asr.vKF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 4:
                    asr.wwn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 5:
                    asr.wwo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 6:
                    asr.wwp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 7:
                    asr.wwq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 8:
                    asr.wwr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 9:
                    asr.wws = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 10:
                    asr.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 11:
                    asr.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 12:
                    asr.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 13:
                    asr.wwt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 14:
                    asr.wwu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 15:
                    asr.wwv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 16:
                    asr.www = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 17:
                    asr.dFp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 18:
                    asr.dFq = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 19:
                    asr.dFr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 20:
                    asr.dFs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 21:
                    asr.dFt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                case 22:
                    asr.dFu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10190);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10190);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10190);
            return -1;
        }
    }
}
