package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ar */
public final class C7251ar extends C1331a {
    public String guS;
    public String jBB;
    public int jBT;
    public String jCH;
    public int vCf;
    public String vCg;
    public String vCh;
    public int vCi;
    public int vCj;
    public String vCk;
    public int vCl;
    public String vCm;
    public String vCn;
    public int vCo;
    public String vCp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58883);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBB != null) {
                c6093a.mo13475e(1, this.jBB);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(2, this.jCH);
            }
            c6093a.mo13480iz(3, this.vCf);
            if (this.vCg != null) {
                c6093a.mo13475e(4, this.vCg);
            }
            if (this.vCh != null) {
                c6093a.mo13475e(5, this.vCh);
            }
            if (this.guS != null) {
                c6093a.mo13475e(6, this.guS);
            }
            c6093a.mo13480iz(8, this.jBT);
            c6093a.mo13480iz(9, this.vCi);
            c6093a.mo13480iz(10, this.vCj);
            if (this.vCk != null) {
                c6093a.mo13475e(11, this.vCk);
            }
            c6093a.mo13480iz(12, this.vCl);
            if (this.vCm != null) {
                c6093a.mo13475e(13, this.vCm);
            }
            if (this.vCn != null) {
                c6093a.mo13475e(14, this.vCn);
            }
            c6093a.mo13480iz(15, this.vCo);
            if (this.vCp != null) {
                c6093a.mo13475e(16, this.vCp);
            }
            AppMethodBeat.m2505o(58883);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = C6091a.m9575f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += C6091a.m9575f(2, this.jCH);
            }
            f += C6091a.m9572bs(3, this.vCf);
            if (this.vCg != null) {
                f += C6091a.m9575f(4, this.vCg);
            }
            if (this.vCh != null) {
                f += C6091a.m9575f(5, this.vCh);
            }
            if (this.guS != null) {
                f += C6091a.m9575f(6, this.guS);
            }
            f = ((f + C6091a.m9572bs(8, this.jBT)) + C6091a.m9572bs(9, this.vCi)) + C6091a.m9572bs(10, this.vCj);
            if (this.vCk != null) {
                f += C6091a.m9575f(11, this.vCk);
            }
            f += C6091a.m9572bs(12, this.vCl);
            if (this.vCm != null) {
                f += C6091a.m9575f(13, this.vCm);
            }
            if (this.vCn != null) {
                f += C6091a.m9575f(14, this.vCn);
            }
            f += C6091a.m9572bs(15, this.vCo);
            if (this.vCp != null) {
                f += C6091a.m9575f(16, this.vCp);
            }
            AppMethodBeat.m2505o(58883);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58883);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7251ar c7251ar = (C7251ar) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7251ar.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 2:
                    c7251ar.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 3:
                    c7251ar.vCf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 4:
                    c7251ar.vCg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 5:
                    c7251ar.vCh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 6:
                    c7251ar.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 8:
                    c7251ar.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 9:
                    c7251ar.vCi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 10:
                    c7251ar.vCj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 11:
                    c7251ar.vCk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 12:
                    c7251ar.vCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 13:
                    c7251ar.vCm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 14:
                    c7251ar.vCn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 15:
                    c7251ar.vCo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                case 16:
                    c7251ar.vCp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58883);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58883);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58883);
            return -1;
        }
    }
}
