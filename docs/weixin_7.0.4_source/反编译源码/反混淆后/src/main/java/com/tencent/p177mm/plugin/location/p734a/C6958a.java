package com.tencent.p177mm.plugin.location.p734a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.location.a.a */
public final class C6958a extends C1331a {
    public LinkedList<String> cGh = new LinkedList();
    public double latitude;
    public double longitude;
    public String nJq;
    public long timestamp;
    public String username;

    public C6958a() {
        AppMethodBeat.m2504i(113289);
        AppMethodBeat.m2505o(113289);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(113290);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.username == null) {
                c6092b = new C6092b("Not all required fields were included: username");
                AppMethodBeat.m2505o(113290);
                throw c6092b;
            }
            if (this.username != null) {
                c6093a.mo13475e(1, this.username);
            }
            c6093a.mo13474e(2, 1, this.cGh);
            c6093a.mo13476f(3, this.longitude);
            c6093a.mo13476f(4, this.latitude);
            if (this.nJq != null) {
                c6093a.mo13475e(5, this.nJq);
            }
            c6093a.mo13472ai(6, this.timestamp);
            AppMethodBeat.m2505o(113290);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = C6091a.m9575f(1, this.username) + 0;
            } else {
                f = 0;
            }
            f = ((f + C6087a.m9552c(2, 1, this.cGh)) + (C6091a.m9576fv(3) + 8)) + (C6091a.m9576fv(4) + 8);
            if (this.nJq != null) {
                f += C6091a.m9575f(5, this.nJq);
            }
            int o = f + C6091a.m9578o(6, this.timestamp);
            AppMethodBeat.m2505o(113290);
            return o;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.cGh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.username == null) {
                c6092b = new C6092b("Not all required fields were included: username");
                AppMethodBeat.m2505o(113290);
                throw c6092b;
            }
            AppMethodBeat.m2505o(113290);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6958a c6958a = (C6958a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c6958a.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113290);
                    return 0;
                case 2:
                    c6958a.cGh.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(113290);
                    return 0;
                case 3:
                    c6958a.longitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113290);
                    return 0;
                case 4:
                    c6958a.latitude = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113290);
                    return 0;
                case 5:
                    c6958a.nJq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113290);
                    return 0;
                case 6:
                    c6958a.timestamp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(113290);
                    return 0;
                default:
                    AppMethodBeat.m2505o(113290);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(113290);
            return -1;
        }
    }
}
