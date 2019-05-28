package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.crt */
public final class crt extends C1331a {
    public String ProductID;
    public String Title;
    public String wOs;
    public int xpo;
    public String xpp;
    public String xpq;
    public String xpr;
    public String xps;
    public String xpt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28705);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            if (this.ProductID != null) {
                c6093a.mo13475e(2, this.ProductID);
            }
            c6093a.mo13480iz(3, this.xpo);
            if (this.xpp != null) {
                c6093a.mo13475e(4, this.xpp);
            }
            if (this.wOs != null) {
                c6093a.mo13475e(5, this.wOs);
            }
            if (this.xpq != null) {
                c6093a.mo13475e(6, this.xpq);
            }
            if (this.xpr != null) {
                c6093a.mo13475e(7, this.xpr);
            }
            if (this.xps != null) {
                c6093a.mo13475e(8, this.xps);
            }
            if (this.xpt != null) {
                c6093a.mo13475e(9, this.xpt);
            }
            AppMethodBeat.m2505o(28705);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.ProductID != null) {
                f += C6091a.m9575f(2, this.ProductID);
            }
            f += C6091a.m9572bs(3, this.xpo);
            if (this.xpp != null) {
                f += C6091a.m9575f(4, this.xpp);
            }
            if (this.wOs != null) {
                f += C6091a.m9575f(5, this.wOs);
            }
            if (this.xpq != null) {
                f += C6091a.m9575f(6, this.xpq);
            }
            if (this.xpr != null) {
                f += C6091a.m9575f(7, this.xpr);
            }
            if (this.xps != null) {
                f += C6091a.m9575f(8, this.xps);
            }
            if (this.xpt != null) {
                f += C6091a.m9575f(9, this.xpt);
            }
            AppMethodBeat.m2505o(28705);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28705);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            crt crt = (crt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crt.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28705);
                    return 0;
                case 2:
                    crt.ProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28705);
                    return 0;
                case 3:
                    crt.xpo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28705);
                    return 0;
                case 4:
                    crt.xpp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28705);
                    return 0;
                case 5:
                    crt.wOs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28705);
                    return 0;
                case 6:
                    crt.xpq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28705);
                    return 0;
                case 7:
                    crt.xpr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28705);
                    return 0;
                case 8:
                    crt.xps = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28705);
                    return 0;
                case 9:
                    crt.xpt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28705);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28705);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28705);
            return -1;
        }
    }
}
