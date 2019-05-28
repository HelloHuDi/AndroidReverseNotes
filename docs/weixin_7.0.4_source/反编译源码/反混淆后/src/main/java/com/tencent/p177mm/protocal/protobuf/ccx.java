package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ccx */
public final class ccx extends C1331a {
    public int vZF;
    public int wem;
    public int xcA;
    public int xcB;
    public int xcr;
    public int xcs;
    public int xct;
    public int xcu;
    public int xcv;
    public LinkedList<Integer> xcw = new LinkedList();
    public int xcx;
    public int xcy;
    public LinkedList<Integer> xcz = new LinkedList();

    public ccx() {
        AppMethodBeat.m2504i(5221);
        AppMethodBeat.m2505o(5221);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5222);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wem);
            c6093a.mo13480iz(2, this.xcr);
            c6093a.mo13480iz(3, this.vZF);
            c6093a.mo13480iz(4, this.xcs);
            c6093a.mo13480iz(5, this.xct);
            c6093a.mo13480iz(6, this.xcu);
            c6093a.mo13480iz(7, this.xcv);
            c6093a.mo13474e(8, 2, this.xcw);
            c6093a.mo13480iz(9, this.xcx);
            c6093a.mo13480iz(10, this.xcy);
            c6093a.mo13474e(11, 2, this.xcz);
            c6093a.mo13480iz(12, this.xcA);
            c6093a.mo13480iz(13, this.xcB);
            AppMethodBeat.m2505o(5222);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((((C6091a.m9572bs(1, this.wem) + 0) + C6091a.m9572bs(2, this.xcr)) + C6091a.m9572bs(3, this.vZF)) + C6091a.m9572bs(4, this.xcs)) + C6091a.m9572bs(5, this.xct)) + C6091a.m9572bs(6, this.xcu)) + C6091a.m9572bs(7, this.xcv)) + C6087a.m9552c(8, 2, this.xcw)) + C6091a.m9572bs(9, this.xcx)) + C6091a.m9572bs(10, this.xcy)) + C6087a.m9552c(11, 2, this.xcz)) + C6091a.m9572bs(12, this.xcA)) + C6091a.m9572bs(13, this.xcB);
            AppMethodBeat.m2505o(5222);
            return bs;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.xcw.clear();
            this.xcz.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(5222);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ccx ccx = (ccx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccx.wem = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 2:
                    ccx.xcr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 3:
                    ccx.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 4:
                    ccx.xcs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 5:
                    ccx.xct = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 6:
                    ccx.xcu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 7:
                    ccx.xcv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 8:
                    ccx.xcw.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 9:
                    ccx.xcx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 10:
                    ccx.xcy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 11:
                    ccx.xcz.add(Integer.valueOf(c6086a2.BTU.mo13458vd()));
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 12:
                    ccx.xcA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                case 13:
                    ccx.xcB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5222);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5222);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5222);
            return -1;
        }
    }
}
