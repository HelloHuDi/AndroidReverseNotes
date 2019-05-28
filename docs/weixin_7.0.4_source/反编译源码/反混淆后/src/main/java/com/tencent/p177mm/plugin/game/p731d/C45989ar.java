package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ar */
public final class C45989ar extends C1331a {
    public String naq;
    public LinkedList<String> nbh = new LinkedList();

    public C45989ar() {
        AppMethodBeat.m2504i(111585);
        AppMethodBeat.m2505o(111585);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111586);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.naq == null) {
                c6092b = new C6092b("Not all required fields were included: Detail");
                AppMethodBeat.m2505o(111586);
                throw c6092b;
            }
            if (this.naq != null) {
                c6093a.mo13475e(2, this.naq);
            }
            c6093a.mo13474e(3, 1, this.nbh);
            AppMethodBeat.m2505o(111586);
            return 0;
        } else if (i == 1) {
            if (this.naq != null) {
                f = C6091a.m9575f(2, this.naq) + 0;
            } else {
                f = 0;
            }
            int c = f + C6087a.m9552c(3, 1, this.nbh);
            AppMethodBeat.m2505o(111586);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.nbh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.naq == null) {
                c6092b = new C6092b("Not all required fields were included: Detail");
                AppMethodBeat.m2505o(111586);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111586);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45989ar c45989ar = (C45989ar) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    c45989ar.naq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111586);
                    return 0;
                case 3:
                    c45989ar.nbh.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(111586);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111586);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111586);
            return -1;
        }
    }
}
