package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.mm */
public final class C7272mm extends C1331a {
    public String pdB;
    public String vQq;
    public String vQr;
    public String vQs;
    public int vQt;
    public String vQu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124299);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vQq == null) {
                c6092b = new C6092b("Not all required fields were included: ProductId");
                AppMethodBeat.m2505o(124299);
                throw c6092b;
            } else if (this.pdB == null) {
                c6092b = new C6092b("Not all required fields were included: ProductName");
                AppMethodBeat.m2505o(124299);
                throw c6092b;
            } else if (this.vQr == null) {
                c6092b = new C6092b("Not all required fields were included: SellerName");
                AppMethodBeat.m2505o(124299);
                throw c6092b;
            } else if (this.vQs == null) {
                c6092b = new C6092b("Not all required fields were included: SellerUserName");
                AppMethodBeat.m2505o(124299);
                throw c6092b;
            } else {
                if (this.vQq != null) {
                    c6093a.mo13475e(1, this.vQq);
                }
                if (this.pdB != null) {
                    c6093a.mo13475e(2, this.pdB);
                }
                if (this.vQr != null) {
                    c6093a.mo13475e(3, this.vQr);
                }
                if (this.vQs != null) {
                    c6093a.mo13475e(4, this.vQs);
                }
                c6093a.mo13480iz(5, this.vQt);
                if (this.vQu != null) {
                    c6093a.mo13475e(6, this.vQu);
                }
                AppMethodBeat.m2505o(124299);
                return 0;
            }
        } else if (i == 1) {
            if (this.vQq != null) {
                f = C6091a.m9575f(1, this.vQq) + 0;
            } else {
                f = 0;
            }
            if (this.pdB != null) {
                f += C6091a.m9575f(2, this.pdB);
            }
            if (this.vQr != null) {
                f += C6091a.m9575f(3, this.vQr);
            }
            if (this.vQs != null) {
                f += C6091a.m9575f(4, this.vQs);
            }
            f += C6091a.m9572bs(5, this.vQt);
            if (this.vQu != null) {
                f += C6091a.m9575f(6, this.vQu);
            }
            AppMethodBeat.m2505o(124299);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.vQq == null) {
                c6092b = new C6092b("Not all required fields were included: ProductId");
                AppMethodBeat.m2505o(124299);
                throw c6092b;
            } else if (this.pdB == null) {
                c6092b = new C6092b("Not all required fields were included: ProductName");
                AppMethodBeat.m2505o(124299);
                throw c6092b;
            } else if (this.vQr == null) {
                c6092b = new C6092b("Not all required fields were included: SellerName");
                AppMethodBeat.m2505o(124299);
                throw c6092b;
            } else if (this.vQs == null) {
                c6092b = new C6092b("Not all required fields were included: SellerUserName");
                AppMethodBeat.m2505o(124299);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(124299);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7272mm c7272mm = (C7272mm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7272mm.vQq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124299);
                    return 0;
                case 2:
                    c7272mm.pdB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124299);
                    return 0;
                case 3:
                    c7272mm.vQr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124299);
                    return 0;
                case 4:
                    c7272mm.vQs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124299);
                    return 0;
                case 5:
                    c7272mm.vQt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124299);
                    return 0;
                case 6:
                    c7272mm.vQu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124299);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124299);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124299);
            return -1;
        }
    }
}
