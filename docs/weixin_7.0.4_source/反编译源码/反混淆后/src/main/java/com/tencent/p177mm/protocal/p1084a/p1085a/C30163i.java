package com.tencent.p177mm.protocal.p1084a.p1085a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.a.a.i */
public final class C30163i extends C1331a {
    public int vyT;
    public int vzh;
    public int vzj;
    public LinkedList<C46513e> vzk = new LinkedList();
    public C1332b vzl;

    public C30163i() {
        AppMethodBeat.m2504i(72826);
        AppMethodBeat.m2505o(72826);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72827);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vyT);
            c6093a.mo13480iz(2, this.vzj);
            c6093a.mo13480iz(3, this.vzh);
            c6093a.mo13474e(4, 8, this.vzk);
            if (this.vzl != null) {
                c6093a.mo13473c(5, this.vzl);
            }
            AppMethodBeat.m2505o(72827);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.vyT) + 0) + C6091a.m9572bs(2, this.vzj)) + C6091a.m9572bs(3, this.vzh)) + C6087a.m9552c(4, 8, this.vzk);
            if (this.vzl != null) {
                bs += C6091a.m9571b(5, this.vzl);
            }
            AppMethodBeat.m2505o(72827);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzk.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72827);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30163i c30163i = (C30163i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c30163i.vyT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72827);
                    return 0;
                case 2:
                    c30163i.vzj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72827);
                    return 0;
                case 3:
                    c30163i.vzh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72827);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46513e c46513e = new C46513e();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c46513e.populateBuilderWithField(c6086a3, c46513e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30163i.vzk.add(c46513e);
                    }
                    AppMethodBeat.m2505o(72827);
                    return 0;
                case 5:
                    c30163i.vzl = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(72827);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72827);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72827);
            return -1;
        }
    }
}
