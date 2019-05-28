package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.hu */
public final class C23398hu extends C1331a {
    public int ReqType;
    public int vIK;
    public int vKj;
    public LinkedList<String> vKk = new LinkedList();

    public C23398hu() {
        AppMethodBeat.m2504i(62519);
        AppMethodBeat.m2505o(62519);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62520);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vKj);
            c6093a.mo13480iz(2, this.ReqType);
            c6093a.mo13474e(3, 1, this.vKk);
            c6093a.mo13480iz(4, this.vIK);
            AppMethodBeat.m2505o(62520);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.vKj) + 0) + C6091a.m9572bs(2, this.ReqType)) + C6087a.m9552c(3, 1, this.vKk)) + C6091a.m9572bs(4, this.vIK);
            AppMethodBeat.m2505o(62520);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.vKk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62520);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23398hu c23398hu = (C23398hu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23398hu.vKj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62520);
                    return 0;
                case 2:
                    c23398hu.ReqType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62520);
                    return 0;
                case 3:
                    c23398hu.vKk.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(62520);
                    return 0;
                case 4:
                    c23398hu.vIK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62520);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62520);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62520);
            return -1;
        }
    }
}
