package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ctv */
public final class ctv extends C1331a {
    public String dFt;
    public String jBG;
    public int vFE;
    public String wbq;
    public String xqs;
    public String xqt;
    public String xqu;
    public String xqv;
    public String xqw;
    public String xqx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28732);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xqs == null) {
                c6092b = new C6092b("Not all required fields were included: LocalNodeId");
                AppMethodBeat.m2505o(28732);
                throw c6092b;
            }
            if (this.xqs != null) {
                c6093a.mo13475e(1, this.xqs);
            }
            if (this.jBG != null) {
                c6093a.mo13475e(2, this.jBG);
            }
            if (this.xqt != null) {
                c6093a.mo13475e(3, this.xqt);
            }
            if (this.dFt != null) {
                c6093a.mo13475e(4, this.dFt);
            }
            if (this.xqu != null) {
                c6093a.mo13475e(5, this.xqu);
            }
            if (this.wbq != null) {
                c6093a.mo13475e(6, this.wbq);
            }
            if (this.xqv != null) {
                c6093a.mo13475e(7, this.xqv);
            }
            if (this.xqw != null) {
                c6093a.mo13475e(8, this.xqw);
            }
            if (this.xqx != null) {
                c6093a.mo13475e(9, this.xqx);
            }
            c6093a.mo13480iz(10, this.vFE);
            AppMethodBeat.m2505o(28732);
            return 0;
        } else if (i == 1) {
            if (this.xqs != null) {
                f = C6091a.m9575f(1, this.xqs) + 0;
            } else {
                f = 0;
            }
            if (this.jBG != null) {
                f += C6091a.m9575f(2, this.jBG);
            }
            if (this.xqt != null) {
                f += C6091a.m9575f(3, this.xqt);
            }
            if (this.dFt != null) {
                f += C6091a.m9575f(4, this.dFt);
            }
            if (this.xqu != null) {
                f += C6091a.m9575f(5, this.xqu);
            }
            if (this.wbq != null) {
                f += C6091a.m9575f(6, this.wbq);
            }
            if (this.xqv != null) {
                f += C6091a.m9575f(7, this.xqv);
            }
            if (this.xqw != null) {
                f += C6091a.m9575f(8, this.xqw);
            }
            if (this.xqx != null) {
                f += C6091a.m9575f(9, this.xqx);
            }
            int bs = f + C6091a.m9572bs(10, this.vFE);
            AppMethodBeat.m2505o(28732);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.xqs == null) {
                c6092b = new C6092b("Not all required fields were included: LocalNodeId");
                AppMethodBeat.m2505o(28732);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28732);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ctv ctv = (ctv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctv.xqs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                case 2:
                    ctv.jBG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                case 3:
                    ctv.xqt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                case 4:
                    ctv.dFt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                case 5:
                    ctv.xqu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                case 6:
                    ctv.wbq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                case 7:
                    ctv.xqv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                case 8:
                    ctv.xqw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                case 9:
                    ctv.xqx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                case 10:
                    ctv.vFE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28732);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28732);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28732);
            return -1;
        }
    }
}
