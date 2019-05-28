package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.k */
public final class C27706k extends C1331a {
    public boolean kLB;
    public String kLC;
    public String kLD;
    public String kLE;
    public int kLF;
    public boolean kLG;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35537);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.kLB);
            if (this.kLC != null) {
                c6093a.mo13475e(2, this.kLC);
            }
            if (this.kLD != null) {
                c6093a.mo13475e(3, this.kLD);
            }
            if (this.kLE != null) {
                c6093a.mo13475e(4, this.kLE);
            }
            c6093a.mo13480iz(5, this.kLF);
            c6093a.mo13471aO(6, this.kLG);
            AppMethodBeat.m2505o(35537);
            return 0;
        } else if (i == 1) {
            fv = (C6091a.m9576fv(1) + 1) + 0;
            if (this.kLC != null) {
                fv += C6091a.m9575f(2, this.kLC);
            }
            if (this.kLD != null) {
                fv += C6091a.m9575f(3, this.kLD);
            }
            if (this.kLE != null) {
                fv += C6091a.m9575f(4, this.kLE);
            }
            fv = (fv + C6091a.m9572bs(5, this.kLF)) + (C6091a.m9576fv(6) + 1);
            AppMethodBeat.m2505o(35537);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35537);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27706k c27706k = (C27706k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c27706k.kLB = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(35537);
                    return 0;
                case 2:
                    c27706k.kLC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35537);
                    return 0;
                case 3:
                    c27706k.kLD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35537);
                    return 0;
                case 4:
                    c27706k.kLE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35537);
                    return 0;
                case 5:
                    c27706k.kLF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35537);
                    return 0;
                case 6:
                    c27706k.kLG = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(35537);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35537);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35537);
            return -1;
        }
    }
}
