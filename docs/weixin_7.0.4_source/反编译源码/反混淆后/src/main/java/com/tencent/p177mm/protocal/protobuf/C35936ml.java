package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ml */
public final class C35936ml extends C1331a {
    public String Title;
    public String Url;
    public String vQl;
    public String vQm;
    public int vQn;
    public String vQo;
    public int vQp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124298);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(124298);
                throw c6092b;
            } else if (this.Url == null) {
                c6092b = new C6092b("Not all required fields were included: Url");
                AppMethodBeat.m2505o(124298);
                throw c6092b;
            } else if (this.vQl == null) {
                c6092b = new C6092b("Not all required fields were included: Position");
                AppMethodBeat.m2505o(124298);
                throw c6092b;
            } else if (this.vQm == null) {
                c6092b = new C6092b("Not all required fields were included: DetailInfo");
                AppMethodBeat.m2505o(124298);
                throw c6092b;
            } else {
                if (this.Title != null) {
                    c6093a.mo13475e(1, this.Title);
                }
                if (this.Url != null) {
                    c6093a.mo13475e(2, this.Url);
                }
                if (this.vQl != null) {
                    c6093a.mo13475e(3, this.vQl);
                }
                if (this.vQm != null) {
                    c6093a.mo13475e(4, this.vQm);
                }
                c6093a.mo13480iz(5, this.vQn);
                if (this.vQo != null) {
                    c6093a.mo13475e(6, this.vQo);
                }
                c6093a.mo13480iz(7, this.vQp);
                AppMethodBeat.m2505o(124298);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.Url != null) {
                f += C6091a.m9575f(2, this.Url);
            }
            if (this.vQl != null) {
                f += C6091a.m9575f(3, this.vQl);
            }
            if (this.vQm != null) {
                f += C6091a.m9575f(4, this.vQm);
            }
            f += C6091a.m9572bs(5, this.vQn);
            if (this.vQo != null) {
                f += C6091a.m9575f(6, this.vQo);
            }
            int bs = f + C6091a.m9572bs(7, this.vQp);
            AppMethodBeat.m2505o(124298);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(124298);
                throw c6092b;
            } else if (this.Url == null) {
                c6092b = new C6092b("Not all required fields were included: Url");
                AppMethodBeat.m2505o(124298);
                throw c6092b;
            } else if (this.vQl == null) {
                c6092b = new C6092b("Not all required fields were included: Position");
                AppMethodBeat.m2505o(124298);
                throw c6092b;
            } else if (this.vQm == null) {
                c6092b = new C6092b("Not all required fields were included: DetailInfo");
                AppMethodBeat.m2505o(124298);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(124298);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35936ml c35936ml = (C35936ml) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35936ml.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124298);
                    return 0;
                case 2:
                    c35936ml.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124298);
                    return 0;
                case 3:
                    c35936ml.vQl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124298);
                    return 0;
                case 4:
                    c35936ml.vQm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124298);
                    return 0;
                case 5:
                    c35936ml.vQn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124298);
                    return 0;
                case 6:
                    c35936ml.vQo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124298);
                    return 0;
                case 7:
                    c35936ml.vQp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124298);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124298);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124298);
            return -1;
        }
    }
}
