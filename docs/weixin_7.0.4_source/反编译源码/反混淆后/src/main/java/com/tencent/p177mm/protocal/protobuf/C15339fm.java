package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fm */
public final class C15339fm extends C1331a {
    public String cxb;
    public String fLi;
    public String geY;
    public LinkedList<String> vHv = new LinkedList();
    public long vHw;

    public C15339fm() {
        AppMethodBeat.m2504i(118265);
        AppMethodBeat.m2505o(118265);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(118266);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.geY == null) {
                c6092b = new C6092b("Not all required fields were included: roomname");
                AppMethodBeat.m2505o(118266);
                throw c6092b;
            }
            if (this.geY != null) {
                c6093a.mo13475e(1, this.geY);
            }
            if (this.cxb != null) {
                c6093a.mo13475e(2, this.cxb);
            }
            if (this.fLi != null) {
                c6093a.mo13475e(3, this.fLi);
            }
            c6093a.mo13474e(4, 1, this.vHv);
            c6093a.mo13472ai(5, this.vHw);
            AppMethodBeat.m2505o(118266);
            return 0;
        } else if (i == 1) {
            if (this.geY != null) {
                f = C6091a.m9575f(1, this.geY) + 0;
            } else {
                f = 0;
            }
            if (this.cxb != null) {
                f += C6091a.m9575f(2, this.cxb);
            }
            if (this.fLi != null) {
                f += C6091a.m9575f(3, this.fLi);
            }
            int c = (f + C6087a.m9552c(4, 1, this.vHv)) + C6091a.m9578o(5, this.vHw);
            AppMethodBeat.m2505o(118266);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vHv.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.geY == null) {
                c6092b = new C6092b("Not all required fields were included: roomname");
                AppMethodBeat.m2505o(118266);
                throw c6092b;
            }
            AppMethodBeat.m2505o(118266);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15339fm c15339fm = (C15339fm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15339fm.geY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(118266);
                    return 0;
                case 2:
                    c15339fm.cxb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(118266);
                    return 0;
                case 3:
                    c15339fm.fLi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(118266);
                    return 0;
                case 4:
                    c15339fm.vHv.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(118266);
                    return 0;
                case 5:
                    c15339fm.vHw = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(118266);
                    return 0;
                default:
                    AppMethodBeat.m2505o(118266);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(118266);
            return -1;
        }
    }
}
