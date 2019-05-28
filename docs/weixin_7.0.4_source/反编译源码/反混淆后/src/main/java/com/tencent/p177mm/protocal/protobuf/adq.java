package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.adq */
public final class adq extends C1331a {
    public int bJt;
    public int wlM;
    public LinkedList<C15402za> wlN = new LinkedList();
    public int wlO;

    public adq() {
        AppMethodBeat.m2504i(118196);
        AppMethodBeat.m2505o(118196);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(118197);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wlM);
            c6093a.mo13474e(2, 8, this.wlN);
            c6093a.mo13480iz(3, this.wlO);
            c6093a.mo13480iz(4, this.bJt);
            AppMethodBeat.m2505o(118197);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.wlM) + 0) + C6087a.m9552c(2, 8, this.wlN)) + C6091a.m9572bs(3, this.wlO)) + C6091a.m9572bs(4, this.bJt);
            AppMethodBeat.m2505o(118197);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wlN.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(118197);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            adq adq = (adq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    adq.wlM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(118197);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15402za c15402za = new C15402za();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c15402za.populateBuilderWithField(c6086a3, c15402za, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        adq.wlN.add(c15402za);
                    }
                    AppMethodBeat.m2505o(118197);
                    return 0;
                case 3:
                    adq.wlO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(118197);
                    return 0;
                case 4:
                    adq.bJt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(118197);
                    return 0;
                default:
                    AppMethodBeat.m2505o(118197);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(118197);
            return -1;
        }
    }
}
