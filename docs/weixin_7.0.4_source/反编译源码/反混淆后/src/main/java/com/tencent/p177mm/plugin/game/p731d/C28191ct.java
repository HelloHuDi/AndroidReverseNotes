package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.ct */
public final class C28191ct extends C1331a {
    public C20956dq ndn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111660);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ndn == null) {
                c6092b = new C6092b("Not all required fields were included: AppInfo");
                AppMethodBeat.m2505o(111660);
                throw c6092b;
            }
            if (this.ndn != null) {
                c6093a.mo13479iy(1, this.ndn.computeSize());
                this.ndn.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(111660);
            return 0;
        } else if (i == 1) {
            if (this.ndn != null) {
                ix = C6087a.m9557ix(1, this.ndn.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.m2505o(111660);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.ndn == null) {
                c6092b = new C6092b("Not all required fields were included: AppInfo");
                AppMethodBeat.m2505o(111660);
                throw c6092b;
            }
            AppMethodBeat.m2505o(111660);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C28191ct c28191ct = (C28191ct) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C20956dq c20956dq = new C20956dq();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c20956dq.populateBuilderWithField(c6086a3, c20956dq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c28191ct.ndn = c20956dq;
                    }
                    AppMethodBeat.m2505o(111660);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111660);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111660);
            return -1;
        }
    }
}
