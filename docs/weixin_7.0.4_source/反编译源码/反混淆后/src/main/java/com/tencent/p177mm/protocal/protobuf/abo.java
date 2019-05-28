package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abo */
public final class abo extends C1331a {
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;
    public boolean wfS = false;
    public boolean wfT = false;
    public boolean wiq = false;
    public boolean wir = false;

    public final abo alM(String str) {
        this.title = str;
        this.wfS = true;
        return this;
    }

    public final abo alN(String str) {
        this.desc = str;
        this.wfT = true;
        return this;
    }

    public final abo alO(String str) {
        this.thumbUrl = str;
        this.wiq = true;
        return this;
    }

    public final abo alP(String str) {
        this.info = str;
        this.wir = true;
        return this;
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51415);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(2, this.desc);
            }
            if (this.thumbUrl != null) {
                c6093a.mo13475e(3, this.thumbUrl);
            }
            if (this.info != null) {
                c6093a.mo13475e(4, this.info);
            }
            AppMethodBeat.m2505o(51415);
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
            if (this.thumbUrl != null) {
                f += C6091a.m9575f(3, this.thumbUrl);
            }
            if (this.info != null) {
                f += C6091a.m9575f(4, this.info);
            }
            AppMethodBeat.m2505o(51415);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51415);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abo abo = (abo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abo.title = c6086a2.BTU.readString();
                    abo.wfS = true;
                    AppMethodBeat.m2505o(51415);
                    return 0;
                case 2:
                    abo.desc = c6086a2.BTU.readString();
                    abo.wfT = true;
                    AppMethodBeat.m2505o(51415);
                    return 0;
                case 3:
                    abo.thumbUrl = c6086a2.BTU.readString();
                    abo.wiq = true;
                    AppMethodBeat.m2505o(51415);
                    return 0;
                case 4:
                    abo.info = c6086a2.BTU.readString();
                    abo.wir = true;
                    AppMethodBeat.m2505o(51415);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51415);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51415);
            return -1;
        }
    }
}
