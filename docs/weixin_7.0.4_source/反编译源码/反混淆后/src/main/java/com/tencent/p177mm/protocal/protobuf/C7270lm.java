package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.lm */
public final class C7270lm extends C1331a {
    public int vOZ;
    public int vPa;
    public int vPb;
    public LinkedList<C7269ll> vPc = new LinkedList();
    public LinkedList<C7269ll> vPd = new LinkedList();

    public C7270lm() {
        AppMethodBeat.m2504i(58895);
        AppMethodBeat.m2505o(58895);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58896);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vOZ);
            c6093a.mo13480iz(2, this.vPa);
            c6093a.mo13480iz(5, this.vPb);
            c6093a.mo13474e(3, 8, this.vPc);
            c6093a.mo13474e(4, 8, this.vPd);
            AppMethodBeat.m2505o(58896);
            return 0;
        } else if (i == 1) {
            bs = ((((C6091a.m9572bs(1, this.vOZ) + 0) + C6091a.m9572bs(2, this.vPa)) + C6091a.m9572bs(5, this.vPb)) + C6087a.m9552c(3, 8, this.vPc)) + C6087a.m9552c(4, 8, this.vPd);
            AppMethodBeat.m2505o(58896);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vPc.clear();
            this.vPd.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58896);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7270lm c7270lm = (C7270lm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C7269ll c7269ll;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c7270lm.vOZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58896);
                    return 0;
                case 2:
                    c7270lm.vPa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58896);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7269ll = new C7269ll();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7269ll.populateBuilderWithField(c6086a3, c7269ll, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7270lm.vPc.add(c7269ll);
                    }
                    AppMethodBeat.m2505o(58896);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7269ll = new C7269ll();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7269ll.populateBuilderWithField(c6086a3, c7269ll, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7270lm.vPd.add(c7269ll);
                    }
                    AppMethodBeat.m2505o(58896);
                    return 0;
                case 5:
                    c7270lm.vPb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58896);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58896);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58896);
            return -1;
        }
    }
}
