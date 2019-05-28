package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.clz */
public final class clz extends C1331a {
    public int Height;
    public int Width;
    public C1332b xjH;
    public int xjI;
    public long xjJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124371);
        int b;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xjH != null) {
                c6093a.mo13473c(1, this.xjH);
            }
            c6093a.mo13480iz(2, this.xjI);
            c6093a.mo13472ai(3, this.xjJ);
            c6093a.mo13480iz(4, this.Width);
            c6093a.mo13480iz(5, this.Height);
            AppMethodBeat.m2505o(124371);
            return 0;
        } else if (i == 1) {
            if (this.xjH != null) {
                b = C6091a.m9571b(1, this.xjH) + 0;
            } else {
                b = 0;
            }
            int bs = (((b + C6091a.m9572bs(2, this.xjI)) + C6091a.m9578o(3, this.xjJ)) + C6091a.m9572bs(4, this.Width)) + C6091a.m9572bs(5, this.Height);
            AppMethodBeat.m2505o(124371);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (b = C1331a.getNextFieldNumber(c6086a); b > 0; b = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, b)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124371);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            clz clz = (clz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clz.xjH = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(124371);
                    return 0;
                case 2:
                    clz.xjI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124371);
                    return 0;
                case 3:
                    clz.xjJ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(124371);
                    return 0;
                case 4:
                    clz.Width = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124371);
                    return 0;
                case 5:
                    clz.Height = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124371);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124371);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124371);
            return -1;
        }
    }
}
