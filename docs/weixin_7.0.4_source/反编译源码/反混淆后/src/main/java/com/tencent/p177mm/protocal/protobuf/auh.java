package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.auh */
public final class auh extends C1331a {
    public String pdz;
    public String pho;
    public String wma;
    public String wym;
    public String wyn;
    public String wyo;
    public String wyp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48873);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pho == null) {
                c6092b = new C6092b("Not all required fields were included: product_id");
                AppMethodBeat.m2505o(48873);
                throw c6092b;
            } else if (this.pdz == null) {
                c6092b = new C6092b("Not all required fields were included: price");
                AppMethodBeat.m2505o(48873);
                throw c6092b;
            } else if (this.wma == null) {
                c6092b = new C6092b("Not all required fields were included: currency_type");
                AppMethodBeat.m2505o(48873);
                throw c6092b;
            } else if (this.wym == null) {
                c6092b = new C6092b("Not all required fields were included: session_data");
                AppMethodBeat.m2505o(48873);
                throw c6092b;
            } else {
                if (this.pho != null) {
                    c6093a.mo13475e(1, this.pho);
                }
                if (this.pdz != null) {
                    c6093a.mo13475e(2, this.pdz);
                }
                if (this.wma != null) {
                    c6093a.mo13475e(3, this.wma);
                }
                if (this.wym != null) {
                    c6093a.mo13475e(4, this.wym);
                }
                if (this.wyn != null) {
                    c6093a.mo13475e(5, this.wyn);
                }
                if (this.wyo != null) {
                    c6093a.mo13475e(6, this.wyo);
                }
                if (this.wyp != null) {
                    c6093a.mo13475e(7, this.wyp);
                }
                AppMethodBeat.m2505o(48873);
                return 0;
            }
        } else if (i == 1) {
            if (this.pho != null) {
                f = C6091a.m9575f(1, this.pho) + 0;
            } else {
                f = 0;
            }
            if (this.pdz != null) {
                f += C6091a.m9575f(2, this.pdz);
            }
            if (this.wma != null) {
                f += C6091a.m9575f(3, this.wma);
            }
            if (this.wym != null) {
                f += C6091a.m9575f(4, this.wym);
            }
            if (this.wyn != null) {
                f += C6091a.m9575f(5, this.wyn);
            }
            if (this.wyo != null) {
                f += C6091a.m9575f(6, this.wyo);
            }
            if (this.wyp != null) {
                f += C6091a.m9575f(7, this.wyp);
            }
            AppMethodBeat.m2505o(48873);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.pho == null) {
                c6092b = new C6092b("Not all required fields were included: product_id");
                AppMethodBeat.m2505o(48873);
                throw c6092b;
            } else if (this.pdz == null) {
                c6092b = new C6092b("Not all required fields were included: price");
                AppMethodBeat.m2505o(48873);
                throw c6092b;
            } else if (this.wma == null) {
                c6092b = new C6092b("Not all required fields were included: currency_type");
                AppMethodBeat.m2505o(48873);
                throw c6092b;
            } else if (this.wym == null) {
                c6092b = new C6092b("Not all required fields were included: session_data");
                AppMethodBeat.m2505o(48873);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(48873);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            auh auh = (auh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    auh.pho = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48873);
                    return 0;
                case 2:
                    auh.pdz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48873);
                    return 0;
                case 3:
                    auh.wma = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48873);
                    return 0;
                case 4:
                    auh.wym = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48873);
                    return 0;
                case 5:
                    auh.wyn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48873);
                    return 0;
                case 6:
                    auh.wyo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48873);
                    return 0;
                case 7:
                    auh.wyp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48873);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48873);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48873);
            return -1;
        }
    }
}
