package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.an */
public final class C6933an extends C1331a {
    public String Desc;
    public String Title;
    public String fKh;
    public String mZj;
    public String nbe;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111580);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nbe != null) {
                c6093a.mo13475e(1, this.nbe);
            }
            if (this.Title != null) {
                c6093a.mo13475e(2, this.Title);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(3, this.Desc);
            }
            if (this.mZj != null) {
                c6093a.mo13475e(4, this.mZj);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(5, this.fKh);
            }
            AppMethodBeat.m2505o(111580);
            return 0;
        } else if (i == 1) {
            if (this.nbe != null) {
                f = C6091a.m9575f(1, this.nbe) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += C6091a.m9575f(2, this.Title);
            }
            if (this.Desc != null) {
                f += C6091a.m9575f(3, this.Desc);
            }
            if (this.mZj != null) {
                f += C6091a.m9575f(4, this.mZj);
            }
            if (this.fKh != null) {
                f += C6091a.m9575f(5, this.fKh);
            }
            AppMethodBeat.m2505o(111580);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111580);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6933an c6933an = (C6933an) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c6933an.nbe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111580);
                    return 0;
                case 2:
                    c6933an.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111580);
                    return 0;
                case 3:
                    c6933an.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111580);
                    return 0;
                case 4:
                    c6933an.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111580);
                    return 0;
                case 5:
                    c6933an.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111580);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111580);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111580);
            return -1;
        }
    }
}
