package com.tencent.p177mm.protocal.p1084a.p1085a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.a.a.b */
public final class C30161b extends C1331a {
    public int nettype;
    public int uin;
    public int vyR;
    public LinkedList<C14993a> vyS = new LinkedList();

    public C30161b() {
        AppMethodBeat.m2504i(72816);
        AppMethodBeat.m2505o(72816);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72817);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.uin);
            c6093a.mo13480iz(2, this.vyR);
            c6093a.mo13474e(3, 8, this.vyS);
            c6093a.mo13480iz(4, this.nettype);
            AppMethodBeat.m2505o(72817);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.uin) + 0) + C6091a.m9572bs(2, this.vyR)) + C6087a.m9552c(3, 8, this.vyS)) + C6091a.m9572bs(4, this.nettype);
            AppMethodBeat.m2505o(72817);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vyS.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72817);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30161b c30161b = (C30161b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c30161b.uin = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72817);
                    return 0;
                case 2:
                    c30161b.vyR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72817);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C14993a c14993a = new C14993a();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c14993a.populateBuilderWithField(c6086a3, c14993a, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30161b.vyS.add(c14993a);
                    }
                    AppMethodBeat.m2505o(72817);
                    return 0;
                case 4:
                    c30161b.nettype = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72817);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72817);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72817);
            return -1;
        }
    }
}
