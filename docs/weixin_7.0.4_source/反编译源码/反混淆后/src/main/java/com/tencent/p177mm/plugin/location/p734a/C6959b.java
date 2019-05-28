package com.tencent.p177mm.plugin.location.p734a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.location.a.b */
public final class C6959b extends C1331a {
    public LinkedList<C6958a> nJr = new LinkedList();
    public String nJs;

    public C6959b() {
        AppMethodBeat.m2504i(113291);
        AppMethodBeat.m2505o(113291);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(113292);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.nJr);
            if (this.nJs != null) {
                c6093a.mo13475e(2, this.nJs);
            }
            AppMethodBeat.m2505o(113292);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.nJr) + 0;
            if (this.nJs != null) {
                c += C6091a.m9575f(2, this.nJs);
            }
            AppMethodBeat.m2505o(113292);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nJr.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(113292);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6959b c6959b = (C6959b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C6958a c6958a = new C6958a();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c6958a.populateBuilderWithField(c6086a3, c6958a, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c6959b.nJr.add(c6958a);
                    }
                    AppMethodBeat.m2505o(113292);
                    return 0;
                case 2:
                    c6959b.nJs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113292);
                    return 0;
                default:
                    AppMethodBeat.m2505o(113292);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(113292);
            return -1;
        }
    }
}
