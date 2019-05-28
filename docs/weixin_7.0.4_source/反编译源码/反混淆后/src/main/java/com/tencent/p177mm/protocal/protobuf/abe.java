package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abe */
public final class abe extends C1331a {
    public String desc;
    public String info;
    public String thumbUrl;
    public String title;
    public int type;
    public boolean wfS = false;
    public boolean wfT = false;
    public boolean wiq = false;
    public boolean wir = false;
    public boolean wis = false;

    public final abe alw(String str) {
        this.title = str;
        this.wfS = true;
        return this;
    }

    public final abe alx(String str) {
        this.desc = str;
        this.wfT = true;
        return this;
    }

    public final abe aly(String str) {
        this.thumbUrl = str;
        this.wiq = true;
        return this;
    }

    public final abe alz(String str) {
        this.info = str;
        this.wir = true;
        return this;
    }

    /* renamed from: LK */
    public final abe mo27436LK(int i) {
        this.type = i;
        this.wis = true;
        return this;
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51403);
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
            if (this.wis) {
                c6093a.mo13480iz(5, this.type);
            }
            AppMethodBeat.m2505o(51403);
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
            if (this.wis) {
                f += C6091a.m9572bs(5, this.type);
            }
            AppMethodBeat.m2505o(51403);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51403);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abe abe = (abe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abe.title = c6086a2.BTU.readString();
                    abe.wfS = true;
                    AppMethodBeat.m2505o(51403);
                    return 0;
                case 2:
                    abe.desc = c6086a2.BTU.readString();
                    abe.wfT = true;
                    AppMethodBeat.m2505o(51403);
                    return 0;
                case 3:
                    abe.thumbUrl = c6086a2.BTU.readString();
                    abe.wiq = true;
                    AppMethodBeat.m2505o(51403);
                    return 0;
                case 4:
                    abe.info = c6086a2.BTU.readString();
                    abe.wir = true;
                    AppMethodBeat.m2505o(51403);
                    return 0;
                case 5:
                    abe.type = c6086a2.BTU.mo13458vd();
                    abe.wis = true;
                    AppMethodBeat.m2505o(51403);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51403);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51403);
            return -1;
        }
    }
}
