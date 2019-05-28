package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.j */
public final class C28198j extends C1331a {
    public String Desc;
    public String IconUrl;
    public String Title;
    public String mZL;
    public int mZN;
    public String mZj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111550);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.IconUrl == null) {
                c6092b = new C6092b("Not all required fields were included: IconUrl");
                AppMethodBeat.m2505o(111550);
                throw c6092b;
            } else if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111550);
                throw c6092b;
            } else if (this.mZj == null) {
                c6092b = new C6092b("Not all required fields were included: JumpUrl");
                AppMethodBeat.m2505o(111550);
                throw c6092b;
            } else {
                if (this.IconUrl != null) {
                    c6093a.mo13475e(1, this.IconUrl);
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
                c6093a.mo13480iz(5, this.mZN);
                if (this.mZL != null) {
                    c6093a.mo13475e(6, this.mZL);
                }
                AppMethodBeat.m2505o(111550);
                return 0;
            }
        } else if (i == 1) {
            if (this.IconUrl != null) {
                f = C6091a.m9575f(1, this.IconUrl) + 0;
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
            f += C6091a.m9572bs(5, this.mZN);
            if (this.mZL != null) {
                f += C6091a.m9575f(6, this.mZL);
            }
            AppMethodBeat.m2505o(111550);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.IconUrl == null) {
                c6092b = new C6092b("Not all required fields were included: IconUrl");
                AppMethodBeat.m2505o(111550);
                throw c6092b;
            } else if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(111550);
                throw c6092b;
            } else if (this.mZj == null) {
                c6092b = new C6092b("Not all required fields were included: JumpUrl");
                AppMethodBeat.m2505o(111550);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(111550);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28198j c28198j = (C28198j) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c28198j.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111550);
                    return 0;
                case 2:
                    c28198j.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111550);
                    return 0;
                case 3:
                    c28198j.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111550);
                    return 0;
                case 4:
                    c28198j.mZj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111550);
                    return 0;
                case 5:
                    c28198j.mZN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111550);
                    return 0;
                case 6:
                    c28198j.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111550);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111550);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111550);
            return -1;
        }
    }
}
