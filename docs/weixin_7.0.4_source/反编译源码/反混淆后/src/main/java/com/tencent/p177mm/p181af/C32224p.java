package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.af.p */
public final class C32224p extends C1331a {
    public String fgd;
    public int fjA;
    public int fjB;
    public String fjC;
    public String fjD;
    public int fjE;
    public int fjF;
    public String fjG;
    public String fjH;
    public String fjI;
    public String fjJ;
    public String fjK;
    public String fjL;
    public int fjM;
    public int fjN;
    public String fjO;
    public String fjv;
    public String fjw;
    public String fjx;
    public String fjy;
    public String fjz;
    public long time;
    public String title;
    public int type;
    public String url;
    public int videoHeight;
    public int videoWidth;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(105479);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.url != null) {
                c6093a.mo13475e(2, this.url);
            }
            if (this.fjv != null) {
                c6093a.mo13475e(3, this.fjv);
            }
            if (this.fjw != null) {
                c6093a.mo13475e(4, this.fjw);
            }
            c6093a.mo13472ai(5, this.time);
            if (this.fjx != null) {
                c6093a.mo13475e(6, this.fjx);
            }
            if (this.fjy != null) {
                c6093a.mo13475e(7, this.fjy);
            }
            if (this.fjz != null) {
                c6093a.mo13475e(8, this.fjz);
            }
            c6093a.mo13480iz(9, this.type);
            c6093a.mo13480iz(10, this.fjA);
            c6093a.mo13480iz(11, this.fjB);
            if (this.fjC != null) {
                c6093a.mo13475e(12, this.fjC);
            }
            if (this.fjD != null) {
                c6093a.mo13475e(13, this.fjD);
            }
            c6093a.mo13480iz(14, this.fjE);
            c6093a.mo13480iz(15, this.fjF);
            if (this.fjG != null) {
                c6093a.mo13475e(16, this.fjG);
            }
            if (this.fjH != null) {
                c6093a.mo13475e(17, this.fjH);
            }
            if (this.fjI != null) {
                c6093a.mo13475e(18, this.fjI);
            }
            if (this.fjJ != null) {
                c6093a.mo13475e(19, this.fjJ);
            }
            if (this.fjK != null) {
                c6093a.mo13475e(20, this.fjK);
            }
            if (this.fjL != null) {
                c6093a.mo13475e(21, this.fjL);
            }
            c6093a.mo13480iz(22, this.fjM);
            c6093a.mo13480iz(23, this.fjN);
            if (this.fjO != null) {
                c6093a.mo13475e(24, this.fjO);
            }
            c6093a.mo13480iz(25, this.videoWidth);
            c6093a.mo13480iz(26, this.videoHeight);
            if (this.fgd != null) {
                c6093a.mo13475e(27, this.fgd);
            }
            AppMethodBeat.m2505o(105479);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.url != null) {
                f += C6091a.m9575f(2, this.url);
            }
            if (this.fjv != null) {
                f += C6091a.m9575f(3, this.fjv);
            }
            if (this.fjw != null) {
                f += C6091a.m9575f(4, this.fjw);
            }
            f += C6091a.m9578o(5, this.time);
            if (this.fjx != null) {
                f += C6091a.m9575f(6, this.fjx);
            }
            if (this.fjy != null) {
                f += C6091a.m9575f(7, this.fjy);
            }
            if (this.fjz != null) {
                f += C6091a.m9575f(8, this.fjz);
            }
            f = ((f + C6091a.m9572bs(9, this.type)) + C6091a.m9572bs(10, this.fjA)) + C6091a.m9572bs(11, this.fjB);
            if (this.fjC != null) {
                f += C6091a.m9575f(12, this.fjC);
            }
            if (this.fjD != null) {
                f += C6091a.m9575f(13, this.fjD);
            }
            f = (f + C6091a.m9572bs(14, this.fjE)) + C6091a.m9572bs(15, this.fjF);
            if (this.fjG != null) {
                f += C6091a.m9575f(16, this.fjG);
            }
            if (this.fjH != null) {
                f += C6091a.m9575f(17, this.fjH);
            }
            if (this.fjI != null) {
                f += C6091a.m9575f(18, this.fjI);
            }
            if (this.fjJ != null) {
                f += C6091a.m9575f(19, this.fjJ);
            }
            if (this.fjK != null) {
                f += C6091a.m9575f(20, this.fjK);
            }
            if (this.fjL != null) {
                f += C6091a.m9575f(21, this.fjL);
            }
            f = (f + C6091a.m9572bs(22, this.fjM)) + C6091a.m9572bs(23, this.fjN);
            if (this.fjO != null) {
                f += C6091a.m9575f(24, this.fjO);
            }
            f = (f + C6091a.m9572bs(25, this.videoWidth)) + C6091a.m9572bs(26, this.videoHeight);
            if (this.fgd != null) {
                f += C6091a.m9575f(27, this.fgd);
            }
            AppMethodBeat.m2505o(105479);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(105479);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C32224p c32224p = (C32224p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c32224p.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 2:
                    c32224p.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 3:
                    c32224p.fjv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 4:
                    c32224p.fjw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 5:
                    c32224p.time = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 6:
                    c32224p.fjx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 7:
                    c32224p.fjy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 8:
                    c32224p.fjz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 9:
                    c32224p.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 10:
                    c32224p.fjA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 11:
                    c32224p.fjB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 12:
                    c32224p.fjC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 13:
                    c32224p.fjD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 14:
                    c32224p.fjE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 15:
                    c32224p.fjF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 16:
                    c32224p.fjG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 17:
                    c32224p.fjH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 18:
                    c32224p.fjI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 19:
                    c32224p.fjJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 20:
                    c32224p.fjK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 21:
                    c32224p.fjL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 22:
                    c32224p.fjM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 23:
                    c32224p.fjN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 24:
                    c32224p.fjO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 25:
                    c32224p.videoWidth = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 26:
                    c32224p.videoHeight = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                case 27:
                    c32224p.fgd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(105479);
                    return 0;
                default:
                    AppMethodBeat.m2505o(105479);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(105479);
            return -1;
        }
    }
}
