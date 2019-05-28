package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.db */
public final class C39196db extends C1331a {
    public String Title;
    public String mZi;
    public String mZj;
    public int ndC;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111669);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            if (this.mZj != null) {
                c6093a.mo13475e(2, this.mZj);
            }
            if (this.mZi != null) {
                c6093a.mo13475e(3, this.mZi);
            }
            c6093a.mo13480iz(4, this.ndC);
            AppMethodBeat.m2505o(111669);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.mZj != null) {
                f += C6091a.m9575f(2, this.mZj);
            }
            if (this.mZi != null) {
                f += C6091a.m9575f(3, this.mZi);
            }
            int bs = f + C6091a.m9572bs(4, this.ndC);
            AppMethodBeat.m2505o(111669);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111669);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39196db c39196db = (C39196db) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c39196db.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111669);
                    return 0;
                case 2:
                    c39196db.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111669);
                    return 0;
                case 3:
                    c39196db.mZi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111669);
                    return 0;
                case 4:
                    c39196db.ndC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111669);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111669);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111669);
            return -1;
        }
    }
}
