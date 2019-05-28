package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.b */
public final class C12814b extends C1331a {
    public String name;
    public LinkedList<C21439i> phB = new LinkedList();

    public C12814b() {
        AppMethodBeat.m2504i(56622);
        AppMethodBeat.m2505o(56622);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56623);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.name != null) {
                c6093a.mo13475e(1, this.name);
            }
            c6093a.mo13474e(2, 8, this.phB);
            AppMethodBeat.m2505o(56623);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                f = C6091a.m9575f(1, this.name) + 0;
            } else {
                f = 0;
            }
            int c = f + C6087a.m9552c(2, 8, this.phB);
            AppMethodBeat.m2505o(56623);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.phB.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56623);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12814b c12814b = (C12814b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c12814b.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56623);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C21439i c21439i = new C21439i();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c21439i.populateBuilderWithField(c6086a3, c21439i, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12814b.phB.add(c21439i);
                    }
                    AppMethodBeat.m2505o(56623);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56623);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56623);
            return -1;
        }
    }
}
