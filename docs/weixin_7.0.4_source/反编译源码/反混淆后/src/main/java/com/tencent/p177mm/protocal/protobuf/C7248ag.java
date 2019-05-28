package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ag */
public final class C7248ag extends C1331a {
    public int vBo;
    public int vBp;
    public int vBq;
    public LinkedList<C7246ae> vBr = new LinkedList();
    public int vBs;
    public LinkedList<C7246ae> vBt = new LinkedList();

    public C7248ag() {
        AppMethodBeat.m2504i(72839);
        AppMethodBeat.m2505o(72839);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72840);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vBo);
            c6093a.mo13480iz(2, this.vBq);
            c6093a.mo13474e(3, 8, this.vBr);
            c6093a.mo13480iz(4, this.vBp);
            c6093a.mo13480iz(5, this.vBs);
            c6093a.mo13474e(6, 8, this.vBt);
            AppMethodBeat.m2505o(72840);
            return 0;
        } else if (i == 1) {
            bs = (((((C6091a.m9572bs(1, this.vBo) + 0) + C6091a.m9572bs(2, this.vBq)) + C6087a.m9552c(3, 8, this.vBr)) + C6091a.m9572bs(4, this.vBp)) + C6091a.m9572bs(5, this.vBs)) + C6087a.m9552c(6, 8, this.vBt);
            AppMethodBeat.m2505o(72840);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vBr.clear();
            this.vBt.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72840);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7248ag c7248ag = (C7248ag) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C7246ae c7246ae;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c7248ag.vBo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72840);
                    return 0;
                case 2:
                    c7248ag.vBq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72840);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7246ae = new C7246ae();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7246ae.populateBuilderWithField(c6086a3, c7246ae, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7248ag.vBr.add(c7246ae);
                    }
                    AppMethodBeat.m2505o(72840);
                    return 0;
                case 4:
                    c7248ag.vBp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72840);
                    return 0;
                case 5:
                    c7248ag.vBs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72840);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c7246ae = new C7246ae();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7246ae.populateBuilderWithField(c6086a3, c7246ae, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7248ag.vBt.add(c7246ae);
                    }
                    AppMethodBeat.m2505o(72840);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72840);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72840);
            return -1;
        }
    }
}
