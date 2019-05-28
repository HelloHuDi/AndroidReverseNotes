package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.lp */
public final class C44141lp extends C1331a {
    public LinkedList<abw> vPg = new LinkedList();
    public LinkedList<abv> vPh = new LinkedList();
    public String vPi;
    public String vPj;
    public String vPk;

    public C44141lp() {
        AppMethodBeat.m2504i(56718);
        AppMethodBeat.m2505o(56718);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56719);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.vPg);
            c6093a.mo13474e(2, 8, this.vPh);
            if (this.vPi != null) {
                c6093a.mo13475e(3, this.vPi);
            }
            if (this.vPj != null) {
                c6093a.mo13475e(4, this.vPj);
            }
            if (this.vPk != null) {
                c6093a.mo13475e(5, this.vPk);
            }
            AppMethodBeat.m2505o(56719);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(1, 8, this.vPg) + 0) + C6087a.m9552c(2, 8, this.vPh);
            if (this.vPi != null) {
                c += C6091a.m9575f(3, this.vPi);
            }
            if (this.vPj != null) {
                c += C6091a.m9575f(4, this.vPj);
            }
            if (this.vPk != null) {
                c += C6091a.m9575f(5, this.vPk);
            }
            AppMethodBeat.m2505o(56719);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vPg.clear();
            this.vPh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56719);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44141lp c44141lp = (C44141lp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abw abw = new abw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abw.populateBuilderWithField(c6086a3, abw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44141lp.vPg.add(abw);
                    }
                    AppMethodBeat.m2505o(56719);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abv abv = new abv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abv.populateBuilderWithField(c6086a3, abv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44141lp.vPh.add(abv);
                    }
                    AppMethodBeat.m2505o(56719);
                    return 0;
                case 3:
                    c44141lp.vPi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56719);
                    return 0;
                case 4:
                    c44141lp.vPj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56719);
                    return 0;
                case 5:
                    c44141lp.vPk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56719);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56719);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56719);
            return -1;
        }
    }
}
