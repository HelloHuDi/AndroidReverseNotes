package com.tencent.p177mm.p209c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.c.b */
public final class C37624b extends C1331a {
    public String apkMd5;
    public int cdf;
    public String cdg;
    public int cdh;
    public String cdi;
    public String cdj;
    public boolean cdk;
    public int cdl;
    public boolean cdm;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(125684);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.apkMd5 == null) {
                c6092b = new C6092b("Not all required fields were included: apkMd5");
                AppMethodBeat.m2505o(125684);
                throw c6092b;
            }
            if (this.apkMd5 != null) {
                c6093a.mo13475e(1, this.apkMd5);
            }
            c6093a.mo13478iA(2, this.cdf);
            if (this.cdg != null) {
                c6093a.mo13475e(3, this.cdg);
            }
            c6093a.mo13478iA(4, this.cdh);
            if (this.cdi != null) {
                c6093a.mo13475e(5, this.cdi);
            }
            if (this.cdj != null) {
                c6093a.mo13475e(6, this.cdj);
            }
            c6093a.mo13471aO(7, this.cdk);
            c6093a.mo13478iA(8, this.cdl);
            c6093a.mo13471aO(9, this.cdm);
            AppMethodBeat.m2505o(125684);
            return 0;
        } else if (i == 1) {
            if (this.apkMd5 != null) {
                f = C6087a.m9555f(1, this.apkMd5) + 0;
            } else {
                f = 0;
            }
            f += C6087a.m9556iw(2, this.cdf);
            if (this.cdg != null) {
                f += C6087a.m9555f(3, this.cdg);
            }
            f += C6087a.m9556iw(4, this.cdh);
            if (this.cdi != null) {
                f += C6087a.m9555f(5, this.cdi);
            }
            if (this.cdj != null) {
                f += C6087a.m9555f(6, this.cdj);
            }
            int Vg = ((f + C6087a.m9551Vg(7)) + C6087a.m9556iw(8, this.cdl)) + C6087a.m9551Vg(9);
            AppMethodBeat.m2505o(125684);
            return Vg;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.apkMd5 == null) {
                c6092b = new C6092b("Not all required fields were included: apkMd5");
                AppMethodBeat.m2505o(125684);
                throw c6092b;
            }
            AppMethodBeat.m2505o(125684);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C37624b c37624b = (C37624b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c37624b.apkMd5 = c6086a2.emq();
                    AppMethodBeat.m2505o(125684);
                    return 0;
                case 2:
                    c37624b.cdf = c6086a2.emp();
                    AppMethodBeat.m2505o(125684);
                    return 0;
                case 3:
                    c37624b.cdg = c6086a2.emq();
                    AppMethodBeat.m2505o(125684);
                    return 0;
                case 4:
                    c37624b.cdh = c6086a2.emp();
                    AppMethodBeat.m2505o(125684);
                    return 0;
                case 5:
                    c37624b.cdi = c6086a2.emq();
                    AppMethodBeat.m2505o(125684);
                    return 0;
                case 6:
                    c37624b.cdj = c6086a2.emq();
                    AppMethodBeat.m2505o(125684);
                    return 0;
                case 7:
                    c37624b.cdk = c6086a2.emr();
                    AppMethodBeat.m2505o(125684);
                    return 0;
                case 8:
                    c37624b.cdl = c6086a2.emp();
                    AppMethodBeat.m2505o(125684);
                    return 0;
                case 9:
                    c37624b.cdm = c6086a2.emr();
                    AppMethodBeat.m2505o(125684);
                    return 0;
                default:
                    AppMethodBeat.m2505o(125684);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(125684);
            return -1;
        }
    }
}
