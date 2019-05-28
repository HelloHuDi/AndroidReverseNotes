package com.tencent.p177mm.protocal.p1338b.p1339a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.b.a.d */
public final class C44100d extends C1331a {
    public int cKc;
    public String desc;
    public String mjO;
    public String thumbPath;
    public String title;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111122);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(2, this.desc);
            }
            if (this.thumbPath != null) {
                c6093a.mo13475e(3, this.thumbPath);
            }
            c6093a.mo13480iz(4, this.cKc);
            if (this.mjO != null) {
                c6093a.mo13475e(5, this.mjO);
            }
            AppMethodBeat.m2505o(111122);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += C6091a.m9575f(2, this.desc);
            }
            if (this.thumbPath != null) {
                f += C6091a.m9575f(3, this.thumbPath);
            }
            f += C6091a.m9572bs(4, this.cKc);
            if (this.mjO != null) {
                f += C6091a.m9575f(5, this.mjO);
            }
            AppMethodBeat.m2505o(111122);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111122);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44100d c44100d = (C44100d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44100d.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111122);
                    return 0;
                case 2:
                    c44100d.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111122);
                    return 0;
                case 3:
                    c44100d.thumbPath = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111122);
                    return 0;
                case 4:
                    c44100d.cKc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111122);
                    return 0;
                case 5:
                    c44100d.mjO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111122);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111122);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111122);
            return -1;
        }
    }
}
