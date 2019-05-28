package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cux */
public final class cux extends C1331a {
    public C1332b vHn;
    public int wdn;
    public String wyw;
    public boolean xqX;
    public boolean xqY;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28765);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wyw == null) {
                c6092b = new C6092b("Not all required fields were included: Talker");
                AppMethodBeat.m2505o(28765);
                throw c6092b;
            }
            if (this.wyw != null) {
                c6093a.mo13475e(1, this.wyw);
            }
            c6093a.mo13480iz(2, this.wdn);
            if (this.vHn != null) {
                c6093a.mo13473c(3, this.vHn);
            }
            c6093a.mo13471aO(4, this.xqX);
            c6093a.mo13471aO(5, this.xqY);
            AppMethodBeat.m2505o(28765);
            return 0;
        } else if (i == 1) {
            if (this.wyw != null) {
                f = C6091a.m9575f(1, this.wyw) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wdn);
            if (this.vHn != null) {
                f += C6091a.m9571b(3, this.vHn);
            }
            int fv = (f + (C6091a.m9576fv(4) + 1)) + (C6091a.m9576fv(5) + 1);
            AppMethodBeat.m2505o(28765);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wyw == null) {
                c6092b = new C6092b("Not all required fields were included: Talker");
                AppMethodBeat.m2505o(28765);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28765);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cux cux = (cux) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cux.wyw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28765);
                    return 0;
                case 2:
                    cux.wdn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28765);
                    return 0;
                case 3:
                    cux.vHn = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(28765);
                    return 0;
                case 4:
                    cux.xqX = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28765);
                    return 0;
                case 5:
                    cux.xqY = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(28765);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28765);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28765);
            return -1;
        }
    }
}
