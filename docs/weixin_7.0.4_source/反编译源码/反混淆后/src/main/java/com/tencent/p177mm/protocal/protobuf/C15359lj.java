package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.lj */
public final class C15359lj extends C1331a {
    public String vNb;
    public LinkedList<String> vOW = new LinkedList();

    public C15359lj() {
        AppMethodBeat.m2504i(11729);
        AppMethodBeat.m2505o(11729);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11730);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vNb == null) {
                c6092b = new C6092b("Not all required fields were included: brand_user_name");
                AppMethodBeat.m2505o(11730);
                throw c6092b;
            }
            if (this.vNb != null) {
                c6093a.mo13475e(2, this.vNb);
            }
            c6093a.mo13474e(3, 1, this.vOW);
            AppMethodBeat.m2505o(11730);
            return 0;
        } else if (i == 1) {
            if (this.vNb != null) {
                f = C6091a.m9575f(2, this.vNb) + 0;
            } else {
                f = 0;
            }
            int c = f + C6087a.m9552c(3, 1, this.vOW);
            AppMethodBeat.m2505o(11730);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vOW.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.vNb == null) {
                c6092b = new C6092b("Not all required fields were included: brand_user_name");
                AppMethodBeat.m2505o(11730);
                throw c6092b;
            }
            AppMethodBeat.m2505o(11730);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15359lj c15359lj = (C15359lj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    c15359lj.vNb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11730);
                    return 0;
                case 3:
                    c15359lj.vOW.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(11730);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11730);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11730);
            return -1;
        }
    }
}
