package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.alm */
public final class alm extends C1331a {
    public String aOt;
    public String app_id;
    public LinkedList<String> wqM = new LinkedList();

    public alm() {
        AppMethodBeat.m2504i(80085);
        AppMethodBeat.m2505o(80085);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80086);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.aOt != null) {
                c6093a.mo13475e(1, this.aOt);
            }
            if (this.app_id != null) {
                c6093a.mo13475e(2, this.app_id);
            }
            c6093a.mo13474e(3, 1, this.wqM);
            AppMethodBeat.m2505o(80086);
            return 0;
        } else if (i == 1) {
            if (this.aOt != null) {
                f = C6091a.m9575f(1, this.aOt) + 0;
            } else {
                f = 0;
            }
            if (this.app_id != null) {
                f += C6091a.m9575f(2, this.app_id);
            }
            int c = f + C6087a.m9552c(3, 1, this.wqM);
            AppMethodBeat.m2505o(80086);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wqM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80086);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            alm alm = (alm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alm.aOt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80086);
                    return 0;
                case 2:
                    alm.app_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80086);
                    return 0;
                case 3:
                    alm.wqM.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(80086);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80086);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80086);
            return -1;
        }
    }
}
