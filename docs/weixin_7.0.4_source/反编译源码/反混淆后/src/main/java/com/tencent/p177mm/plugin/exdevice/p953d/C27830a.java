package com.tencent.p177mm.plugin.exdevice.p953d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.exdevice.d.a */
public final class C27830a extends C1331a {
    public int luF;
    public String luG;
    public String luH;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(19415);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.luF);
            if (this.luG != null) {
                c6093a.mo13475e(2, this.luG);
            }
            if (this.luH != null) {
                c6093a.mo13475e(3, this.luH);
            }
            AppMethodBeat.m2505o(19415);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.luF) + 0;
            if (this.luG != null) {
                bs += C6091a.m9575f(2, this.luG);
            }
            if (this.luH != null) {
                bs += C6091a.m9575f(3, this.luH);
            }
            AppMethodBeat.m2505o(19415);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(19415);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27830a c27830a = (C27830a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c27830a.luF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(19415);
                    return 0;
                case 2:
                    c27830a.luG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19415);
                    return 0;
                case 3:
                    c27830a.luH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(19415);
                    return 0;
                default:
                    AppMethodBeat.m2505o(19415);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(19415);
            return -1;
        }
    }
}
