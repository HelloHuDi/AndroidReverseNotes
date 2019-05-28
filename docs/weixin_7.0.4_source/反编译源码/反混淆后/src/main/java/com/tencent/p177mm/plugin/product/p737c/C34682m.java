package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.m */
public final class C34682m extends C1331a {
    public String phX;
    public String phY;
    public LinkedList<C46133h> phZ = new LinkedList();

    public C34682m() {
        AppMethodBeat.m2504i(56637);
        AppMethodBeat.m2505o(56637);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56638);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.phX != null) {
                c6093a.mo13475e(1, this.phX);
            }
            if (this.phY != null) {
                c6093a.mo13475e(2, this.phY);
            }
            c6093a.mo13474e(3, 8, this.phZ);
            AppMethodBeat.m2505o(56638);
            return 0;
        } else if (i == 1) {
            if (this.phX != null) {
                f = C6091a.m9575f(1, this.phX) + 0;
            } else {
                f = 0;
            }
            if (this.phY != null) {
                f += C6091a.m9575f(2, this.phY);
            }
            int c = f + C6087a.m9552c(3, 8, this.phZ);
            AppMethodBeat.m2505o(56638);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.phZ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56638);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34682m c34682m = (C34682m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c34682m.phX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56638);
                    return 0;
                case 2:
                    c34682m.phY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56638);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46133h c46133h = new C46133h();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c46133h.populateBuilderWithField(c6086a3, c46133h, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34682m.phZ.add(c46133h);
                    }
                    AppMethodBeat.m2505o(56638);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56638);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56638);
            return -1;
        }
    }
}
