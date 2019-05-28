package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.storage.C7616ad;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.lk */
public final class C30201lk extends C1331a {
    public C7616ad ehM;
    public C16527d pkW;
    public String userName;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14716);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.userName == null) {
                c6092b = new C6092b("Not all required fields were included: userName");
                AppMethodBeat.m2505o(14716);
                throw c6092b;
            }
            if (this.userName != null) {
                c6093a.mo13475e(1, this.userName);
            }
            AppMethodBeat.m2505o(14716);
            return 0;
        } else if (i == 1) {
            if (this.userName != null) {
                f = C6091a.m9575f(1, this.userName) + 0;
            } else {
                f = 0;
            }
            AppMethodBeat.m2505o(14716);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.userName == null) {
                c6092b = new C6092b("Not all required fields were included: userName");
                AppMethodBeat.m2505o(14716);
                throw c6092b;
            }
            AppMethodBeat.m2505o(14716);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30201lk c30201lk = (C30201lk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c30201lk.userName = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14716);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14716);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14716);
            return -1;
        }
    }
}
