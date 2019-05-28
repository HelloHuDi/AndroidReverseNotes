package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.zs */
public final class C23469zs extends C1331a {
    public String Name;
    public long lhy;
    public int wfb;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73703);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.lhy);
            if (this.Name != null) {
                c6093a.mo13475e(2, this.Name);
            }
            c6093a.mo13480iz(3, this.wfb);
            AppMethodBeat.m2505o(73703);
            return 0;
        } else if (i == 1) {
            o = C6091a.m9578o(1, this.lhy) + 0;
            if (this.Name != null) {
                o += C6091a.m9575f(2, this.Name);
            }
            o += C6091a.m9572bs(3, this.wfb);
            AppMethodBeat.m2505o(73703);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73703);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23469zs c23469zs = (C23469zs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23469zs.lhy = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(73703);
                    return 0;
                case 2:
                    c23469zs.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73703);
                    return 0;
                case 3:
                    c23469zs.wfb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73703);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73703);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73703);
            return -1;
        }
    }
}
