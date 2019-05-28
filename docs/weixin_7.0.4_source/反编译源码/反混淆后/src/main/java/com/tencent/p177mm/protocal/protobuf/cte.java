package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cte */
public final class cte extends C1331a {
    public String Desc;
    public LinkedList<acc> xqk = new LinkedList();
    public String xql;

    public cte() {
        AppMethodBeat.m2504i(63691);
        AppMethodBeat.m2505o(63691);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63692);
        C6092b c6092b;
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xql == null) {
                c6092b = new C6092b("Not all required fields were included: Charset");
                AppMethodBeat.m2505o(63692);
                throw c6092b;
            }
            c6093a.mo13474e(1, 8, this.xqk);
            if (this.xql != null) {
                c6093a.mo13475e(2, this.xql);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(3, this.Desc);
            }
            AppMethodBeat.m2505o(63692);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.xqk) + 0;
            if (this.xql != null) {
                c += C6091a.m9575f(2, this.xql);
            }
            if (this.Desc != null) {
                c += C6091a.m9575f(3, this.Desc);
            }
            AppMethodBeat.m2505o(63692);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xqk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            if (this.xql == null) {
                c6092b = new C6092b("Not all required fields were included: Charset");
                AppMethodBeat.m2505o(63692);
                throw c6092b;
            }
            AppMethodBeat.m2505o(63692);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cte cte = (cte) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acc acc = new acc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = acc.populateBuilderWithField(c6086a3, acc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cte.xqk.add(acc);
                    }
                    AppMethodBeat.m2505o(63692);
                    return 0;
                case 2:
                    cte.xql = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63692);
                    return 0;
                case 3:
                    cte.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63692);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63692);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63692);
            return -1;
        }
    }
}
