package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.cx */
public final class C34273cx extends C1331a {
    public String Desc;
    public String Title;
    public String fKh;
    public String mZL;
    public String mZi;
    public String mZj;
    public String ncH;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111664);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ncH == null) {
                c6092b = new C6092b("Not all required fields were included: AppName");
                AppMethodBeat.m2505o(111664);
                throw c6092b;
            }
            if (this.ncH != null) {
                c6093a.mo13475e(1, this.ncH);
            }
            if (this.mZi != null) {
                c6093a.mo13475e(2, this.mZi);
            }
            if (this.Title != null) {
                c6093a.mo13475e(3, this.Title);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(4, this.Desc);
            }
            if (this.mZL != null) {
                c6093a.mo13475e(5, this.mZL);
            }
            if (this.mZj != null) {
                c6093a.mo13475e(6, this.mZj);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(7, this.fKh);
            }
            AppMethodBeat.m2505o(111664);
            return 0;
        } else if (i == 1) {
            if (this.ncH != null) {
                f = C6091a.m9575f(1, this.ncH) + 0;
            } else {
                f = 0;
            }
            if (this.mZi != null) {
                f += C6091a.m9575f(2, this.mZi);
            }
            if (this.Title != null) {
                f += C6091a.m9575f(3, this.Title);
            }
            if (this.Desc != null) {
                f += C6091a.m9575f(4, this.Desc);
            }
            if (this.mZL != null) {
                f += C6091a.m9575f(5, this.mZL);
            }
            if (this.mZj != null) {
                f += C6091a.m9575f(6, this.mZj);
            }
            if (this.fKh != null) {
                f += C6091a.m9575f(7, this.fKh);
            }
            AppMethodBeat.m2505o(111664);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.ncH == null) {
                c6092b = new C6092b("Not all required fields were included: AppName");
                AppMethodBeat.m2505o(111664);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111664);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34273cx c34273cx = (C34273cx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c34273cx.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111664);
                    return 0;
                case 2:
                    c34273cx.mZi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111664);
                    return 0;
                case 3:
                    c34273cx.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111664);
                    return 0;
                case 4:
                    c34273cx.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111664);
                    return 0;
                case 5:
                    c34273cx.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111664);
                    return 0;
                case 6:
                    c34273cx.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111664);
                    return 0;
                case 7:
                    c34273cx.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111664);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111664);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111664);
            return -1;
        }
    }
}
