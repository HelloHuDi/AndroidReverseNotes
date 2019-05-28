package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.dr */
public final class C43169dr extends C1331a {
    public String IconUrl;
    public String fKh;
    public String jBB;
    public String mZL;
    public String ncH;
    public String ndP;
    public int ndQ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111682);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.fKh == null) {
                c6092b = new C6092b("Not all required fields were included: AppId");
                AppMethodBeat.m2505o(111682);
                throw c6092b;
            }
            if (this.fKh != null) {
                c6093a.mo13475e(1, this.fKh);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(2, this.ncH);
            }
            if (this.IconUrl != null) {
                c6093a.mo13475e(3, this.IconUrl);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(4, this.jBB);
            }
            if (this.ndP != null) {
                c6093a.mo13475e(5, this.ndP);
            }
            c6093a.mo13480iz(6, this.ndQ);
            if (this.mZL != null) {
                c6093a.mo13475e(7, this.mZL);
            }
            AppMethodBeat.m2505o(111682);
            return 0;
        } else if (i == 1) {
            if (this.fKh != null) {
                f = C6091a.m9575f(1, this.fKh) + 0;
            } else {
                f = 0;
            }
            if (this.ncH != null) {
                f += C6091a.m9575f(2, this.ncH);
            }
            if (this.IconUrl != null) {
                f += C6091a.m9575f(3, this.IconUrl);
            }
            if (this.jBB != null) {
                f += C6091a.m9575f(4, this.jBB);
            }
            if (this.ndP != null) {
                f += C6091a.m9575f(5, this.ndP);
            }
            f += C6091a.m9572bs(6, this.ndQ);
            if (this.mZL != null) {
                f += C6091a.m9575f(7, this.mZL);
            }
            AppMethodBeat.m2505o(111682);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.fKh == null) {
                c6092b = new C6092b("Not all required fields were included: AppId");
                AppMethodBeat.m2505o(111682);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111682);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C43169dr c43169dr = (C43169dr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c43169dr.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111682);
                    return 0;
                case 2:
                    c43169dr.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111682);
                    return 0;
                case 3:
                    c43169dr.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111682);
                    return 0;
                case 4:
                    c43169dr.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111682);
                    return 0;
                case 5:
                    c43169dr.ndP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111682);
                    return 0;
                case 6:
                    c43169dr.ndQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(111682);
                    return 0;
                case 7:
                    c43169dr.mZL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111682);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111682);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111682);
            return -1;
        }
    }
}
