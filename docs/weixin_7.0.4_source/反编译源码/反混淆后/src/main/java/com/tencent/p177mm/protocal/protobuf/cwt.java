package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cwt */
public final class cwt extends C1331a {
    public int cOq;
    public String cOr;
    public String fKh;
    public String iBB;
    public int iBG;
    public int jCt;
    public int lvf;
    public int pXC;
    public int pXD;
    public int ugc;
    public String vGA;
    public String xso;
    public String xsp;
    public int xsq;
    public String xsr;
    public int xss;
    public String xst;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96330);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jCt);
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            if (this.xso != null) {
                c6093a.mo13475e(3, this.xso);
            }
            c6093a.mo13480iz(4, this.pXC);
            c6093a.mo13480iz(5, this.lvf);
            c6093a.mo13480iz(6, this.pXD);
            if (this.xsp != null) {
                c6093a.mo13475e(7, this.xsp);
            }
            c6093a.mo13480iz(8, this.xsq);
            if (this.vGA != null) {
                c6093a.mo13475e(9, this.vGA);
            }
            if (this.xsr != null) {
                c6093a.mo13475e(10, this.xsr);
            }
            c6093a.mo13480iz(11, this.ugc);
            c6093a.mo13480iz(12, this.xss);
            if (this.xst != null) {
                c6093a.mo13475e(13, this.xst);
            }
            if (this.iBB != null) {
                c6093a.mo13475e(14, this.iBB);
            }
            c6093a.mo13480iz(15, this.cOq);
            if (this.cOr != null) {
                c6093a.mo13475e(16, this.cOr);
            }
            c6093a.mo13480iz(17, this.iBG);
            AppMethodBeat.m2505o(96330);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.jCt) + 0;
            if (this.fKh != null) {
                bs += C6091a.m9575f(2, this.fKh);
            }
            if (this.xso != null) {
                bs += C6091a.m9575f(3, this.xso);
            }
            bs = ((bs + C6091a.m9572bs(4, this.pXC)) + C6091a.m9572bs(5, this.lvf)) + C6091a.m9572bs(6, this.pXD);
            if (this.xsp != null) {
                bs += C6091a.m9575f(7, this.xsp);
            }
            bs += C6091a.m9572bs(8, this.xsq);
            if (this.vGA != null) {
                bs += C6091a.m9575f(9, this.vGA);
            }
            if (this.xsr != null) {
                bs += C6091a.m9575f(10, this.xsr);
            }
            bs = (bs + C6091a.m9572bs(11, this.ugc)) + C6091a.m9572bs(12, this.xss);
            if (this.xst != null) {
                bs += C6091a.m9575f(13, this.xst);
            }
            if (this.iBB != null) {
                bs += C6091a.m9575f(14, this.iBB);
            }
            bs += C6091a.m9572bs(15, this.cOq);
            if (this.cOr != null) {
                bs += C6091a.m9575f(16, this.cOr);
            }
            bs += C6091a.m9572bs(17, this.iBG);
            AppMethodBeat.m2505o(96330);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96330);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cwt cwt = (cwt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cwt.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 2:
                    cwt.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 3:
                    cwt.xso = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 4:
                    cwt.pXC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 5:
                    cwt.lvf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 6:
                    cwt.pXD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 7:
                    cwt.xsp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 8:
                    cwt.xsq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 9:
                    cwt.vGA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 10:
                    cwt.xsr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 11:
                    cwt.ugc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 12:
                    cwt.xss = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 13:
                    cwt.xst = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 14:
                    cwt.iBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 15:
                    cwt.cOq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 16:
                    cwt.cOr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                case 17:
                    cwt.iBG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96330);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96330);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96330);
            return -1;
        }
    }
}
