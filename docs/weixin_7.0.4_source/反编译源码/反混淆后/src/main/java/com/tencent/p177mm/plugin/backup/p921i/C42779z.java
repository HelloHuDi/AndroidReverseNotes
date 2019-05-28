package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.z */
public final class C42779z extends C1331a {
    public String jBt;
    public long jCE;
    public long jCF;
    public String jCG;
    public String jCH;
    public LinkedList<String> jCl = new LinkedList();

    public C42779z() {
        AppMethodBeat.m2504i(18074);
        AppMethodBeat.m2505o(18074);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18075);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBt == null) {
                c6092b = new C6092b("Not all required fields were included: BakChatName");
                AppMethodBeat.m2505o(18075);
                throw c6092b;
            } else if (this.jCG == null) {
                c6092b = new C6092b("Not all required fields were included: MsgDataID");
                AppMethodBeat.m2505o(18075);
                throw c6092b;
            } else if (this.jCH == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(18075);
                throw c6092b;
            } else {
                if (this.jBt != null) {
                    c6093a.mo13475e(1, this.jBt);
                }
                c6093a.mo13472ai(2, this.jCE);
                c6093a.mo13472ai(3, this.jCF);
                if (this.jCG != null) {
                    c6093a.mo13475e(4, this.jCG);
                }
                if (this.jCH != null) {
                    c6093a.mo13475e(5, this.jCH);
                }
                c6093a.mo13474e(6, 1, this.jCl);
                AppMethodBeat.m2505o(18075);
                return 0;
            }
        } else if (i == 1) {
            if (this.jBt != null) {
                f = C6091a.m9575f(1, this.jBt) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9578o(2, this.jCE)) + C6091a.m9578o(3, this.jCF);
            if (this.jCG != null) {
                f += C6091a.m9575f(4, this.jCG);
            }
            if (this.jCH != null) {
                f += C6091a.m9575f(5, this.jCH);
            }
            int c = f + C6087a.m9552c(6, 1, this.jCl);
            AppMethodBeat.m2505o(18075);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jCl.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.jBt == null) {
                c6092b = new C6092b("Not all required fields were included: BakChatName");
                AppMethodBeat.m2505o(18075);
                throw c6092b;
            } else if (this.jCG == null) {
                c6092b = new C6092b("Not all required fields were included: MsgDataID");
                AppMethodBeat.m2505o(18075);
                throw c6092b;
            } else if (this.jCH == null) {
                c6092b = new C6092b("Not all required fields were included: NickName");
                AppMethodBeat.m2505o(18075);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(18075);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C42779z c42779z = (C42779z) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c42779z.jBt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18075);
                    return 0;
                case 2:
                    c42779z.jCE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18075);
                    return 0;
                case 3:
                    c42779z.jCF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(18075);
                    return 0;
                case 4:
                    c42779z.jCG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18075);
                    return 0;
                case 5:
                    c42779z.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18075);
                    return 0;
                case 6:
                    c42779z.jCl.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(18075);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18075);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18075);
            return -1;
        }
    }
}
