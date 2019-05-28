package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.crx */
public final class crx extends C1331a {
    public String Desc;
    public String ProductID;
    public String Title;
    public String nzz;
    public int vEq;
    public String wOs;
    public String xpy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28709);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Title != null) {
                c6093a.mo13475e(1, this.Title);
            }
            if (this.wOs != null) {
                c6093a.mo13475e(2, this.wOs);
            }
            if (this.nzz != null) {
                c6093a.mo13475e(3, this.nzz);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(4, this.Desc);
            }
            if (this.xpy != null) {
                c6093a.mo13475e(5, this.xpy);
            }
            c6093a.mo13480iz(6, this.vEq);
            if (this.ProductID != null) {
                c6093a.mo13475e(7, this.ProductID);
            }
            AppMethodBeat.m2505o(28709);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = C6091a.m9575f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.wOs != null) {
                f += C6091a.m9575f(2, this.wOs);
            }
            if (this.nzz != null) {
                f += C6091a.m9575f(3, this.nzz);
            }
            if (this.Desc != null) {
                f += C6091a.m9575f(4, this.Desc);
            }
            if (this.xpy != null) {
                f += C6091a.m9575f(5, this.xpy);
            }
            f += C6091a.m9572bs(6, this.vEq);
            if (this.ProductID != null) {
                f += C6091a.m9575f(7, this.ProductID);
            }
            AppMethodBeat.m2505o(28709);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28709);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            crx crx = (crx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crx.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28709);
                    return 0;
                case 2:
                    crx.wOs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28709);
                    return 0;
                case 3:
                    crx.nzz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28709);
                    return 0;
                case 4:
                    crx.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28709);
                    return 0;
                case 5:
                    crx.xpy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28709);
                    return 0;
                case 6:
                    crx.vEq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28709);
                    return 0;
                case 7:
                    crx.ProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28709);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28709);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28709);
            return -1;
        }
    }
}
