package com.tencent.p177mm.p211cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.cb.a */
public final class C45277a extends C1331a {
    public LinkedList<C37628d> xFx = new LinkedList();
    public LinkedList<C45278c> xFy = new LinkedList();

    public C45277a() {
        AppMethodBeat.m2504i(62642);
        AppMethodBeat.m2505o(62642);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62643);
        int c;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13474e(3, 8, this.xFx);
            c6093a.mo13474e(4, 8, this.xFy);
            AppMethodBeat.m2505o(62643);
            return 0;
        } else if (i == 1) {
            c = (C6087a.m9552c(3, 8, this.xFx) + 0) + C6087a.m9552c(4, 8, this.xFy);
            AppMethodBeat.m2505o(62643);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xFx.clear();
            this.xFy.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62643);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45277a c45277a = (C45277a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C37628d c37628d = new C37628d();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c37628d.populateBuilderWithField(c6086a3, c37628d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45277a.xFx.add(c37628d);
                    }
                    AppMethodBeat.m2505o(62643);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C45278c c45278c = new C45278c();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c45278c.populateBuilderWithField(c6086a3, c45278c, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45277a.xFy.add(c45278c);
                    }
                    AppMethodBeat.m2505o(62643);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62643);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62643);
            return -1;
        }
    }
}
