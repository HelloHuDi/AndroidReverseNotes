package com.tencent.p177mm.protocal.p1084a.p1085a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.a.a.g */
public final class C44096g extends C1331a {
    public int vyT;
    public int vzj;
    public LinkedList<C30161b> vzk = new LinkedList();
    public C1332b vzl;

    public C44096g() {
        AppMethodBeat.m2504i(72823);
        AppMethodBeat.m2505o(72823);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72824);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vyT);
            c6093a.mo13480iz(2, this.vzj);
            c6093a.mo13474e(3, 8, this.vzk);
            if (this.vzl != null) {
                c6093a.mo13473c(4, this.vzl);
            }
            AppMethodBeat.m2505o(72824);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.vyT) + 0) + C6091a.m9572bs(2, this.vzj)) + C6087a.m9552c(3, 8, this.vzk);
            if (this.vzl != null) {
                bs += C6091a.m9571b(4, this.vzl);
            }
            AppMethodBeat.m2505o(72824);
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
            AppMethodBeat.m2505o(72824);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44096g c44096g = (C44096g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c44096g.vyT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72824);
                    return 0;
                case 2:
                    c44096g.vzj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72824);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30161b c30161b = new C30161b();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c30161b.populateBuilderWithField(c6086a3, c30161b, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44096g.vzk.add(c30161b);
                    }
                    AppMethodBeat.m2505o(72824);
                    return 0;
                case 4:
                    c44096g.vzl = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(72824);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72824);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72824);
            return -1;
        }
    }
}
