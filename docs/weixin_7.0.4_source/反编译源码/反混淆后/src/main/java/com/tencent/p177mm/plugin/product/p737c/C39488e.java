package com.tencent.p177mm.plugin.product.p737c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.product.c.e */
public final class C39488e extends C1331a {
    /* renamed from: id */
    public int f16177id;
    public String name;
    public int value;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56628);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.f16177id);
            if (this.name != null) {
                c6093a.mo13475e(2, this.name);
            }
            c6093a.mo13480iz(3, this.value);
            AppMethodBeat.m2505o(56628);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.f16177id) + 0;
            if (this.name != null) {
                bs += C6091a.m9575f(2, this.name);
            }
            bs += C6091a.m9572bs(3, this.value);
            AppMethodBeat.m2505o(56628);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56628);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39488e c39488e = (C39488e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c39488e.f16177id = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56628);
                    return 0;
                case 2:
                    c39488e.name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56628);
                    return 0;
                case 3:
                    c39488e.value = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56628);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56628);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56628);
            return -1;
        }
    }
}
