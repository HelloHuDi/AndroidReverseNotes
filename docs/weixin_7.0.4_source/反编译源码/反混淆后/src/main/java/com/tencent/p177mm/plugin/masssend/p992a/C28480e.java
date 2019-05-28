package com.tencent.p177mm.plugin.masssend.p992a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.masssend.a.e */
public final class C28480e extends C1331a {
    public int count;
    public LinkedList<C21269d> oog = new LinkedList();

    public C28480e() {
        AppMethodBeat.m2504i(22736);
        AppMethodBeat.m2505o(22736);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(22737);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.count);
            c6093a.mo13474e(2, 8, this.oog);
            AppMethodBeat.m2505o(22737);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.count) + 0) + C6087a.m9552c(2, 8, this.oog);
            AppMethodBeat.m2505o(22737);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.oog.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(22737);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28480e c28480e = (C28480e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c28480e.count = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(22737);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C21269d c21269d = new C21269d();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c21269d.populateBuilderWithField(c6086a3, c21269d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28480e.oog.add(c21269d);
                    }
                    AppMethodBeat.m2505o(22737);
                    return 0;
                default:
                    AppMethodBeat.m2505o(22737);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(22737);
            return -1;
        }
    }
}
