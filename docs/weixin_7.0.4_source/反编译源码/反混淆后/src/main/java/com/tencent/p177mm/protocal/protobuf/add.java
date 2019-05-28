package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.add */
public final class add extends C1331a {
    public String Desc;
    public String ThumbUrl;
    public String Title;
    public String fKh;
    public String ncH;
    public int vNm;
    public String wkC;
    public int wkX;
    public int wkY;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(112434);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(112434);
                throw c6092b;
            } else if (this.Desc == null) {
                c6092b = new C6092b("Not all required fields were included: Desc");
                AppMethodBeat.m2505o(112434);
                throw c6092b;
            } else if (this.ThumbUrl == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.m2505o(112434);
                throw c6092b;
            } else {
                if (this.Title != null) {
                    c6093a.mo13475e(1, this.Title);
                }
                if (this.Desc != null) {
                    c6093a.mo13475e(2, this.Desc);
                }
                if (this.ThumbUrl != null) {
                    c6093a.mo13475e(3, this.ThumbUrl);
                }
                if (this.wkC != null) {
                    c6093a.mo13475e(4, this.wkC);
                }
                c6093a.mo13480iz(5, this.wkX);
                c6093a.mo13480iz(6, this.wkY);
                if (this.fKh != null) {
                    c6093a.mo13475e(7, this.fKh);
                }
                c6093a.mo13480iz(8, this.vNm);
                if (this.ncH != null) {
                    c6093a.mo13475e(9, this.ncH);
                }
                AppMethodBeat.m2505o(112434);
                return 0;
            }
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.Desc != null) {
                f += C6091a.m9575f(2, this.Desc);
            }
            if (this.ThumbUrl != null) {
                f += C6091a.m9575f(3, this.ThumbUrl);
            }
            if (this.wkC != null) {
                f += C6091a.m9575f(4, this.wkC);
            }
            f = (f + C6091a.m9572bs(5, this.wkX)) + C6091a.m9572bs(6, this.wkY);
            if (this.fKh != null) {
                f += C6091a.m9575f(7, this.fKh);
            }
            f += C6091a.m9572bs(8, this.vNm);
            if (this.ncH != null) {
                f += C6091a.m9575f(9, this.ncH);
            }
            AppMethodBeat.m2505o(112434);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.Title == null) {
                c6092b = new C6092b("Not all required fields were included: Title");
                AppMethodBeat.m2505o(112434);
                throw c6092b;
            } else if (this.Desc == null) {
                c6092b = new C6092b("Not all required fields were included: Desc");
                AppMethodBeat.m2505o(112434);
                throw c6092b;
            } else if (this.ThumbUrl == null) {
                c6092b = new C6092b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.m2505o(112434);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(112434);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            add add = (add) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    add.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112434);
                    return 0;
                case 2:
                    add.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112434);
                    return 0;
                case 3:
                    add.ThumbUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112434);
                    return 0;
                case 4:
                    add.wkC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112434);
                    return 0;
                case 5:
                    add.wkX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(112434);
                    return 0;
                case 6:
                    add.wkY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(112434);
                    return 0;
                case 7:
                    add.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112434);
                    return 0;
                case 8:
                    add.vNm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(112434);
                    return 0;
                case 9:
                    add.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(112434);
                    return 0;
                default:
                    AppMethodBeat.m2505o(112434);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(112434);
            return -1;
        }
    }
}
