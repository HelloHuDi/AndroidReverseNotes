package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.a */
public final class C35390a extends C1331a {
    public LinkedList<C35391c> tmA = new LinkedList();
    public C35396n tmB;

    public C35390a() {
        AppMethodBeat.m2504i(56640);
        AppMethodBeat.m2505o(56640);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56641);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(1, 8, this.tmA);
            if (this.tmB != null) {
                c6093a.mo13479iy(2, this.tmB.computeSize());
                this.tmB.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56641);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.tmA) + 0;
            if (this.tmB != null) {
                c += C6087a.m9557ix(2, this.tmB.computeSize());
            }
            AppMethodBeat.m2505o(56641);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tmA.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56641);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35390a c35390a = (C35390a) objArr[1];
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
                        C35391c c35391c = new C35391c();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35391c.populateBuilderWithField(c6086a3, c35391c, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35390a.tmA.add(c35391c);
                    }
                    AppMethodBeat.m2505o(56641);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C35396n c35396n = new C35396n();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35396n.populateBuilderWithField(c6086a3, c35396n, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35390a.tmB = c35396n;
                    }
                    AppMethodBeat.m2505o(56641);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56641);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56641);
            return -1;
        }
    }
}
