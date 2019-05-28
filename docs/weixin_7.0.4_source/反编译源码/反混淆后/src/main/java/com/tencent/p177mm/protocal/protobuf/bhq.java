package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bhq */
public final class bhq extends C1331a {
    public C35956tc wIw;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(60057);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wIw == null) {
                c6092b = new C6092b("Not all required fields were included: Oplog");
                AppMethodBeat.m2505o(60057);
                throw c6092b;
            }
            if (this.wIw != null) {
                c6093a.mo13479iy(1, this.wIw.computeSize());
                this.wIw.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(60057);
            return 0;
        } else if (i == 1) {
            if (this.wIw != null) {
                ix = C6087a.m9557ix(1, this.wIw.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.m2505o(60057);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wIw == null) {
                c6092b = new C6092b("Not all required fields were included: Oplog");
                AppMethodBeat.m2505o(60057);
                throw c6092b;
            }
            AppMethodBeat.m2505o(60057);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bhq bhq = (bhq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C35956tc c35956tc = new C35956tc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c35956tc.populateBuilderWithField(c6086a3, c35956tc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bhq.wIw = c35956tc;
                    }
                    AppMethodBeat.m2505o(60057);
                    return 0;
                default:
                    AppMethodBeat.m2505o(60057);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(60057);
            return -1;
        }
    }
}
