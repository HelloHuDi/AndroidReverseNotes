package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cug */
public final class cug extends C1331a {
    public String Title;
    public String ncM;
    public int ndE;
    public int wXt;
    public String wyw;
    public boolean xqI;
    public boolean xqJ;
    public boolean xqK;
    public C1332b xqr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28746);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wyw == null) {
                c6092b = new C6092b("Not all required fields were included: Talker");
                AppMethodBeat.m2505o(28746);
                throw c6092b;
            } else if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(28746);
                throw c6092b;
            } else if (this.ncM == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(28746);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.ndE);
                if (this.wyw != null) {
                    c6093a.mo13475e(2, this.wyw);
                }
                if (this.Title != null) {
                    c6093a.mo13475e(3, this.Title);
                }
                if (this.ncM != null) {
                    c6093a.mo13475e(4, this.ncM);
                }
                c6093a.mo13480iz(5, this.wXt);
                if (this.xqr != null) {
                    c6093a.mo13473c(6, this.xqr);
                }
                c6093a.mo13471aO(7, this.xqI);
                c6093a.mo13471aO(8, this.xqJ);
                c6093a.mo13471aO(9, this.xqK);
                AppMethodBeat.m2505o(28746);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.ndE) + 0;
            if (this.wyw != null) {
                bs += C6091a.m9575f(2, this.wyw);
            }
            if (this.Title != null) {
                bs += C6091a.m9575f(3, this.Title);
            }
            if (this.ncM != null) {
                bs += C6091a.m9575f(4, this.ncM);
            }
            bs += C6091a.m9572bs(5, this.wXt);
            if (this.xqr != null) {
                bs += C6091a.m9571b(6, this.xqr);
            }
            bs = ((bs + (C6091a.m9576fv(7) + 1)) + (C6091a.m9576fv(8) + 1)) + (C6091a.m9576fv(9) + 1);
            AppMethodBeat.m2505o(28746);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wyw == null) {
                c6092b = new C6092b("Not all required fields were included: Talker");
                AppMethodBeat.m2505o(28746);
                throw c6092b;
            } else if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(28746);
                throw c6092b;
            } else if (this.ncM == null) {
                c6092b = new C6092b("Not all required fields were included: Content");
                AppMethodBeat.m2505o(28746);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28746);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cug cug = (cug) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cug.ndE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28746);
                    return 0;
                case 2:
                    cug.wyw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28746);
                    return 0;
                case 3:
                    cug.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28746);
                    return 0;
                case 4:
                    cug.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28746);
                    return 0;
                case 5:
                    cug.wXt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28746);
                    return 0;
                case 6:
                    cug.xqr = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28746);
                    return 0;
                case 7:
                    cug.xqI = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28746);
                    return 0;
                case 8:
                    cug.xqJ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28746);
                    return 0;
                case 9:
                    cug.xqK = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28746);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28746);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28746);
            return -1;
        }
    }
}
