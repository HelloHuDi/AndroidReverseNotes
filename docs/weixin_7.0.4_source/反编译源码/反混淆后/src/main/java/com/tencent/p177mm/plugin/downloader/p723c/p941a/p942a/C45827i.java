package com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.a.a.i */
public final class C45827i extends C1331a {
    public LinkedList<C42907h> kKA = new LinkedList();

    public C45827i() {
        AppMethodBeat.m2504i(35517);
        AppMethodBeat.m2505o(35517);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35518);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((C6093a) objArr[0]).mo13474e(1, 8, this.kKA);
            AppMethodBeat.m2505o(35518);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.kKA) + 0;
            AppMethodBeat.m2505o(35518);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kKA.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35518);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45827i c45827i = (C45827i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C42907h c42907h = new C42907h();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c42907h.populateBuilderWithField(c6086a3, c42907h, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45827i.kKA.add(c42907h);
                    }
                    AppMethodBeat.m2505o(35518);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35518);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35518);
            return -1;
        }
    }
}
