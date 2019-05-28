package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aua */
public final class aua extends C1331a {
    public String eCq;
    public int major;
    public LinkedList<auc> wxZ = new LinkedList();

    public aua() {
        AppMethodBeat.m2504i(10192);
        AppMethodBeat.m2505o(10192);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(10193);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.eCq != null) {
                c6093a.mo13475e(1, this.eCq);
            }
            c6093a.mo13480iz(2, this.major);
            c6093a.mo13474e(3, 8, this.wxZ);
            AppMethodBeat.m2505o(10193);
            return 0;
        } else if (i == 1) {
            if (this.eCq != null) {
                f = C6091a.m9575f(1, this.eCq) + 0;
            } else {
                f = 0;
            }
            int bs = (f + C6091a.m9572bs(2, this.major)) + C6087a.m9552c(3, 8, this.wxZ);
            AppMethodBeat.m2505o(10193);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wxZ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(10193);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aua aua = (aua) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aua.eCq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(10193);
                    return 0;
                case 2:
                    aua.major = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(10193);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auc auc = new auc();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = auc.populateBuilderWithField(c6086a3, auc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aua.wxZ.add(auc);
                    }
                    AppMethodBeat.m2505o(10193);
                    return 0;
                default:
                    AppMethodBeat.m2505o(10193);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(10193);
            return -1;
        }
    }
}
