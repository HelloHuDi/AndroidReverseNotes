package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.yi */
public final class C40590yi extends C1331a {
    public int vEq;
    public String wea;
    public String web;
    public String wec;
    public String wed;
    public String wee;
    public int wef;
    public int weg;
    public String weh;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62544);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wea == null) {
                c6092b = new C6092b("Not all required fields were included: BegWord");
                AppMethodBeat.m2505o(62544);
                throw c6092b;
            } else if (this.web == null) {
                c6092b = new C6092b("Not all required fields were included: BegPicUrl");
                AppMethodBeat.m2505o(62544);
                throw c6092b;
            } else if (this.wec == null) {
                c6092b = new C6092b("Not all required fields were included: ThanksPicUrl");
                AppMethodBeat.m2505o(62544);
                throw c6092b;
            } else {
                if (this.wea != null) {
                    c6093a.mo13475e(1, this.wea);
                }
                if (this.web != null) {
                    c6093a.mo13475e(2, this.web);
                }
                if (this.wec != null) {
                    c6093a.mo13475e(3, this.wec);
                }
                if (this.wed != null) {
                    c6093a.mo13475e(4, this.wed);
                }
                if (this.wee != null) {
                    c6093a.mo13475e(5, this.wee);
                }
                c6093a.mo13480iz(6, this.wef);
                c6093a.mo13480iz(7, this.weg);
                if (this.weh != null) {
                    c6093a.mo13475e(8, this.weh);
                }
                c6093a.mo13480iz(9, this.vEq);
                AppMethodBeat.m2505o(62544);
                return 0;
            }
        } else if (i == 1) {
            if (this.wea != null) {
                f = C6091a.m9575f(1, this.wea) + 0;
            } else {
                f = 0;
            }
            if (this.web != null) {
                f += C6091a.m9575f(2, this.web);
            }
            if (this.wec != null) {
                f += C6091a.m9575f(3, this.wec);
            }
            if (this.wed != null) {
                f += C6091a.m9575f(4, this.wed);
            }
            if (this.wee != null) {
                f += C6091a.m9575f(5, this.wee);
            }
            f = (f + C6091a.m9572bs(6, this.wef)) + C6091a.m9572bs(7, this.weg);
            if (this.weh != null) {
                f += C6091a.m9575f(8, this.weh);
            }
            int bs = f + C6091a.m9572bs(9, this.vEq);
            AppMethodBeat.m2505o(62544);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wea == null) {
                c6092b = new C6092b("Not all required fields were included: BegWord");
                AppMethodBeat.m2505o(62544);
                throw c6092b;
            } else if (this.web == null) {
                c6092b = new C6092b("Not all required fields were included: BegPicUrl");
                AppMethodBeat.m2505o(62544);
                throw c6092b;
            } else if (this.wec == null) {
                c6092b = new C6092b("Not all required fields were included: ThanksPicUrl");
                AppMethodBeat.m2505o(62544);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(62544);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40590yi c40590yi = (C40590yi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40590yi.wea = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62544);
                    return 0;
                case 2:
                    c40590yi.web = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62544);
                    return 0;
                case 3:
                    c40590yi.wec = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62544);
                    return 0;
                case 4:
                    c40590yi.wed = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62544);
                    return 0;
                case 5:
                    c40590yi.wee = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62544);
                    return 0;
                case 6:
                    c40590yi.wef = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62544);
                    return 0;
                case 7:
                    c40590yi.weg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62544);
                    return 0;
                case 8:
                    c40590yi.weh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62544);
                    return 0;
                case 9:
                    c40590yi.vEq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62544);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62544);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62544);
            return -1;
        }
    }
}
