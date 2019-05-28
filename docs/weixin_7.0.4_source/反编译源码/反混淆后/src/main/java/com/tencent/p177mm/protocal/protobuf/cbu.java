package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cbu */
public final class cbu extends C1331a {
    public int wUX;
    public int xbg;
    public LinkedList<cbb> xbh = new LinkedList();
    public int xbi;
    public int xbj;

    public cbu() {
        AppMethodBeat.m2504i(94600);
        AppMethodBeat.m2505o(94600);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94601);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.xbg);
            c6093a.mo13474e(2, 8, this.xbh);
            c6093a.mo13480iz(3, this.xbi);
            c6093a.mo13480iz(4, this.wUX);
            c6093a.mo13480iz(5, this.xbj);
            AppMethodBeat.m2505o(94601);
            return 0;
        } else if (i == 1) {
            bs = ((((C6091a.m9572bs(1, this.xbg) + 0) + C6087a.m9552c(2, 8, this.xbh)) + C6091a.m9572bs(3, this.xbi)) + C6091a.m9572bs(4, this.wUX)) + C6091a.m9572bs(5, this.xbj);
            AppMethodBeat.m2505o(94601);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xbh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94601);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cbu cbu = (cbu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cbu.xbg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94601);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbb cbb = new cbb();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cbb.populateBuilderWithField(c6086a3, cbb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cbu.xbh.add(cbb);
                    }
                    AppMethodBeat.m2505o(94601);
                    return 0;
                case 3:
                    cbu.xbi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94601);
                    return 0;
                case 4:
                    cbu.wUX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94601);
                    return 0;
                case 5:
                    cbu.xbj = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94601);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94601);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94601);
            return -1;
        }
    }
}
