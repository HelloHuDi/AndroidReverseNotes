package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bwn */
public final class bwn extends C1331a {
    public String geZ;
    public String vEP;
    public String wWZ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80184);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.geZ == null) {
                c6092b = new C6092b("Not all required fields were included: tp_username");
                AppMethodBeat.m2505o(80184);
                throw c6092b;
            } else if (this.wWZ == null) {
                c6092b = new C6092b("Not all required fields were included: verify_content");
                AppMethodBeat.m2505o(80184);
                throw c6092b;
            } else if (this.vEP == null) {
                c6092b = new C6092b("Not all required fields were included: antispam_ticket");
                AppMethodBeat.m2505o(80184);
                throw c6092b;
            } else {
                if (this.geZ != null) {
                    c6093a.mo13475e(1, this.geZ);
                }
                if (this.wWZ != null) {
                    c6093a.mo13475e(2, this.wWZ);
                }
                if (this.vEP != null) {
                    c6093a.mo13475e(3, this.vEP);
                }
                AppMethodBeat.m2505o(80184);
                return 0;
            }
        } else if (i == 1) {
            if (this.geZ != null) {
                f = C6091a.m9575f(1, this.geZ) + 0;
            } else {
                f = 0;
            }
            if (this.wWZ != null) {
                f += C6091a.m9575f(2, this.wWZ);
            }
            if (this.vEP != null) {
                f += C6091a.m9575f(3, this.vEP);
            }
            AppMethodBeat.m2505o(80184);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.geZ == null) {
                c6092b = new C6092b("Not all required fields were included: tp_username");
                AppMethodBeat.m2505o(80184);
                throw c6092b;
            } else if (this.wWZ == null) {
                c6092b = new C6092b("Not all required fields were included: verify_content");
                AppMethodBeat.m2505o(80184);
                throw c6092b;
            } else if (this.vEP == null) {
                c6092b = new C6092b("Not all required fields were included: antispam_ticket");
                AppMethodBeat.m2505o(80184);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(80184);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bwn bwn = (bwn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bwn.geZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80184);
                    return 0;
                case 2:
                    bwn.wWZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80184);
                    return 0;
                case 3:
                    bwn.vEP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80184);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80184);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80184);
            return -1;
        }
    }
}
