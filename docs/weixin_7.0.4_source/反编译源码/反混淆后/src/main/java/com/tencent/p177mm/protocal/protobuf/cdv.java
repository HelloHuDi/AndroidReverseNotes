package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cdv */
public final class cdv extends C1331a {
    public String ThumbUrl;
    public String ncM;
    public String ndF;
    public String ndG;
    public int pcX;
    public long vQE;
    public int wZF;
    public int wZG;
    public int wZH;
    public int wZL;
    public int xdA;
    public int xdB;
    public int xdC;
    public String xdy;
    public String xdz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56503);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.vQE);
            if (this.ndG != null) {
                c6093a.mo13475e(2, this.ndG);
            }
            if (this.ndF != null) {
                c6093a.mo13475e(3, this.ndF);
            }
            if (this.xdy != null) {
                c6093a.mo13475e(4, this.xdy);
            }
            if (this.xdz != null) {
                c6093a.mo13475e(5, this.xdz);
            }
            c6093a.mo13480iz(6, this.pcX);
            if (this.ncM != null) {
                c6093a.mo13475e(7, this.ncM);
            }
            c6093a.mo13480iz(8, this.xdA);
            c6093a.mo13480iz(9, this.wZL);
            c6093a.mo13480iz(10, this.wZF);
            c6093a.mo13480iz(11, this.wZG);
            c6093a.mo13480iz(12, this.wZH);
            if (this.ThumbUrl != null) {
                c6093a.mo13475e(13, this.ThumbUrl);
            }
            c6093a.mo13480iz(14, this.xdB);
            c6093a.mo13480iz(15, this.xdC);
            AppMethodBeat.m2505o(56503);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.vQE) + 0;
            if (this.ndG != null) {
                o += C6091a.m9575f(2, this.ndG);
            }
            if (this.ndF != null) {
                o += C6091a.m9575f(3, this.ndF);
            }
            if (this.xdy != null) {
                o += C6091a.m9575f(4, this.xdy);
            }
            if (this.xdz != null) {
                o += C6091a.m9575f(5, this.xdz);
            }
            o += C6091a.m9572bs(6, this.pcX);
            if (this.ncM != null) {
                o += C6091a.m9575f(7, this.ncM);
            }
            o = ((((o + C6091a.m9572bs(8, this.xdA)) + C6091a.m9572bs(9, this.wZL)) + C6091a.m9572bs(10, this.wZF)) + C6091a.m9572bs(11, this.wZG)) + C6091a.m9572bs(12, this.wZH);
            if (this.ThumbUrl != null) {
                o += C6091a.m9575f(13, this.ThumbUrl);
            }
            o = (o + C6091a.m9572bs(14, this.xdB)) + C6091a.m9572bs(15, this.xdC);
            AppMethodBeat.m2505o(56503);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56503);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cdv cdv = (cdv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cdv.vQE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 2:
                    cdv.ndG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 3:
                    cdv.ndF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 4:
                    cdv.xdy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 5:
                    cdv.xdz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 6:
                    cdv.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 7:
                    cdv.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 8:
                    cdv.xdA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 9:
                    cdv.wZL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 10:
                    cdv.wZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 11:
                    cdv.wZG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 12:
                    cdv.wZH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 13:
                    cdv.ThumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 14:
                    cdv.xdB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                case 15:
                    cdv.xdC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56503);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56503);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56503);
            return -1;
        }
    }
}
