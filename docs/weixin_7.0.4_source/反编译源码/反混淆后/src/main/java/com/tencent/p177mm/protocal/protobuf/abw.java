package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abw */
public final class abw extends C1331a {
    public String vWF;
    public long wji;
    public long wjj;
    public long wjk;
    public String wjl;
    public long wjm;
    public String wjn;
    public String wjo;
    public String wjp;
    public String wjq;
    public String wjr;
    public String wjs;
    public int wjt;
    public String wju;
    public int wjv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56792);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.wji);
            c6093a.mo13472ai(2, this.wjj);
            c6093a.mo13472ai(3, this.wjk);
            if (this.wjl != null) {
                c6093a.mo13475e(4, this.wjl);
            }
            c6093a.mo13472ai(5, this.wjm);
            if (this.wjn != null) {
                c6093a.mo13475e(6, this.wjn);
            }
            if (this.wjo != null) {
                c6093a.mo13475e(7, this.wjo);
            }
            if (this.wjp != null) {
                c6093a.mo13475e(8, this.wjp);
            }
            if (this.wjq != null) {
                c6093a.mo13475e(9, this.wjq);
            }
            if (this.wjr != null) {
                c6093a.mo13475e(10, this.wjr);
            }
            if (this.wjs != null) {
                c6093a.mo13475e(11, this.wjs);
            }
            c6093a.mo13480iz(12, this.wjt);
            if (this.wju != null) {
                c6093a.mo13475e(13, this.wju);
            }
            c6093a.mo13480iz(14, this.wjv);
            if (this.vWF != null) {
                c6093a.mo13475e(15, this.vWF);
            }
            AppMethodBeat.m2505o(56792);
            return 0;
        } else if (i == 1) {
            o = ((C6091a.m9578o(1, this.wji) + 0) + C6091a.m9578o(2, this.wjj)) + C6091a.m9578o(3, this.wjk);
            if (this.wjl != null) {
                o += C6091a.m9575f(4, this.wjl);
            }
            o += C6091a.m9578o(5, this.wjm);
            if (this.wjn != null) {
                o += C6091a.m9575f(6, this.wjn);
            }
            if (this.wjo != null) {
                o += C6091a.m9575f(7, this.wjo);
            }
            if (this.wjp != null) {
                o += C6091a.m9575f(8, this.wjp);
            }
            if (this.wjq != null) {
                o += C6091a.m9575f(9, this.wjq);
            }
            if (this.wjr != null) {
                o += C6091a.m9575f(10, this.wjr);
            }
            if (this.wjs != null) {
                o += C6091a.m9575f(11, this.wjs);
            }
            o += C6091a.m9572bs(12, this.wjt);
            if (this.wju != null) {
                o += C6091a.m9575f(13, this.wju);
            }
            o += C6091a.m9572bs(14, this.wjv);
            if (this.vWF != null) {
                o += C6091a.m9575f(15, this.vWF);
            }
            AppMethodBeat.m2505o(56792);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56792);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abw abw = (abw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abw.wji = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 2:
                    abw.wjj = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 3:
                    abw.wjk = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 4:
                    abw.wjl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 5:
                    abw.wjm = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 6:
                    abw.wjn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 7:
                    abw.wjo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 8:
                    abw.wjp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 9:
                    abw.wjq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 10:
                    abw.wjr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 11:
                    abw.wjs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 12:
                    abw.wjt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 13:
                    abw.wju = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 14:
                    abw.wjv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                case 15:
                    abw.vWF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56792);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56792);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56792);
            return -1;
        }
    }
}
