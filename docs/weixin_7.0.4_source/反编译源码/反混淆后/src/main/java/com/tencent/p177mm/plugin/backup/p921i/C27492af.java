package com.tencent.p177mm.plugin.backup.p921i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.backup.i.af */
public final class C27492af extends C1331a {
    public String jBt;
    public LinkedList<Long> jCP = new LinkedList();
    public LinkedList<String> jCQ = new LinkedList();
    public LinkedList<String> jCR = new LinkedList();

    public C27492af() {
        AppMethodBeat.m2504i(18081);
        AppMethodBeat.m2505o(18081);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(18082);
        C6092b c6092b;
        int c;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jBt == null) {
                c6092b = new C6092b("Not all required fields were included: BakChatName");
                AppMethodBeat.m2505o(18082);
                throw c6092b;
            }
            c6093a.mo13474e(1, 3, this.jCP);
            c6093a.mo13474e(2, 1, this.jCQ);
            c6093a.mo13474e(3, 1, this.jCR);
            if (this.jBt != null) {
                c6093a.mo13475e(4, this.jBt);
            }
            AppMethodBeat.m2505o(18082);
            return 0;
        } else if (i == 1) {
            c = ((C6087a.m9552c(1, 3, this.jCP) + 0) + C6087a.m9552c(2, 1, this.jCQ)) + C6087a.m9552c(3, 1, this.jCR);
            if (this.jBt != null) {
                c += C6091a.m9575f(4, this.jBt);
            }
            AppMethodBeat.m2505o(18082);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jCP.clear();
            this.jCQ.clear();
            this.jCR.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            if (this.jBt == null) {
                c6092b = new C6092b("Not all required fields were included: BakChatName");
                AppMethodBeat.m2505o(18082);
                throw c6092b;
            }
            AppMethodBeat.m2505o(18082);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27492af c27492af = (C27492af) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c27492af.jCP.add(Long.valueOf(c6086a2.BTU.mo13459ve()));
                    AppMethodBeat.m2505o(18082);
                    return 0;
                case 2:
                    c27492af.jCQ.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(18082);
                    return 0;
                case 3:
                    c27492af.jCR.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(18082);
                    return 0;
                case 4:
                    c27492af.jBt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(18082);
                    return 0;
                default:
                    AppMethodBeat.m2505o(18082);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(18082);
            return -1;
        }
    }
}
