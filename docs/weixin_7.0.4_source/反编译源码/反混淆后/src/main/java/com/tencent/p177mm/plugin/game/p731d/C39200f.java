package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.f */
public final class C39200f extends C1331a {
    public LinkedList<C39201g> mZI = new LinkedList();

    public C39200f() {
        AppMethodBeat.m2504i(116990);
        AppMethodBeat.m2505o(116990);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(116991);
        int c;
        byte[] bArr;
        if (i == 0) {
            ((C6093a) objArr[0]).mo13474e(1, 8, this.mZI);
            AppMethodBeat.m2505o(116991);
            return 0;
        } else if (i == 1) {
            c = C6087a.m9552c(1, 8, this.mZI) + 0;
            AppMethodBeat.m2505o(116991);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mZI.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (c = C1331a.getNextFieldNumber(c6086a); c > 0; c = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, c)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(116991);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39200f c39200f = (C39200f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39201g c39201g = new C39201g();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c39201g.populateBuilderWithField(c6086a3, c39201g, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c39200f.mZI.add(c39201g);
                    }
                    AppMethodBeat.m2505o(116991);
                    return 0;
                default:
                    AppMethodBeat.m2505o(116991);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(116991);
            return -1;
        }
    }
}
