package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bhv */
public final class bhv extends C1331a {
    public String key;
    public String pPk;
    public String value;
    public LinkedList<String> wLa = new LinkedList();

    public bhv() {
        AppMethodBeat.m2504i(90695);
        AppMethodBeat.m2505o(90695);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(90696);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.key == null) {
                c6092b = new C6092b("Not all required fields were included: key");
                AppMethodBeat.m2505o(90696);
                throw c6092b;
            } else if (this.value == null) {
                c6092b = new C6092b("Not all required fields were included: value");
                AppMethodBeat.m2505o(90696);
                throw c6092b;
            } else {
                if (this.key != null) {
                    c6093a.mo13475e(1, this.key);
                }
                if (this.value != null) {
                    c6093a.mo13475e(2, this.value);
                }
                if (this.pPk != null) {
                    c6093a.mo13475e(3, this.pPk);
                }
                c6093a.mo13474e(4, 1, this.wLa);
                AppMethodBeat.m2505o(90696);
                return 0;
            }
        } else if (i == 1) {
            if (this.key != null) {
                f = C6091a.m9575f(1, this.key) + 0;
            } else {
                f = 0;
            }
            if (this.value != null) {
                f += C6091a.m9575f(2, this.value);
            }
            if (this.pPk != null) {
                f += C6091a.m9575f(3, this.pPk);
            }
            int c = f + C6087a.m9552c(4, 1, this.wLa);
            AppMethodBeat.m2505o(90696);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wLa.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.key == null) {
                c6092b = new C6092b("Not all required fields were included: key");
                AppMethodBeat.m2505o(90696);
                throw c6092b;
            } else if (this.value == null) {
                c6092b = new C6092b("Not all required fields were included: value");
                AppMethodBeat.m2505o(90696);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(90696);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bhv bhv = (bhv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bhv.key = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90696);
                    return 0;
                case 2:
                    bhv.value = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90696);
                    return 0;
                case 3:
                    bhv.pPk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(90696);
                    return 0;
                case 4:
                    bhv.wLa.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(90696);
                    return 0;
                default:
                    AppMethodBeat.m2505o(90696);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(90696);
            return -1;
        }
    }
}
