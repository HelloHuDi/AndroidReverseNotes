package com.tencent.p177mm.protocal.p1084a.p1085a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.a.a.e */
public final class C46513e extends C1331a {
    public int nettype;
    public int uin;
    public int vyR;
    public LinkedList<C23364d> vyS = new LinkedList();
    public String vzb;
    public String vzc;
    public String vzd;
    public String vze;
    public String vzf;
    public int vzg;

    public C46513e() {
        AppMethodBeat.m2504i(72820);
        AppMethodBeat.m2505o(72820);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72821);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.uin);
            c6093a.mo13480iz(2, this.vyR);
            c6093a.mo13480iz(3, this.nettype);
            c6093a.mo13474e(4, 8, this.vyS);
            if (this.vzb != null) {
                c6093a.mo13475e(5, this.vzb);
            }
            if (this.vzc != null) {
                c6093a.mo13475e(6, this.vzc);
            }
            if (this.vzd != null) {
                c6093a.mo13475e(7, this.vzd);
            }
            if (this.vze != null) {
                c6093a.mo13475e(8, this.vze);
            }
            if (this.vzf != null) {
                c6093a.mo13475e(9, this.vzf);
            }
            c6093a.mo13480iz(10, this.vzg);
            AppMethodBeat.m2505o(72821);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.uin) + 0) + C6091a.m9572bs(2, this.vyR)) + C6091a.m9572bs(3, this.nettype)) + C6087a.m9552c(4, 8, this.vyS);
            if (this.vzb != null) {
                bs += C6091a.m9575f(5, this.vzb);
            }
            if (this.vzc != null) {
                bs += C6091a.m9575f(6, this.vzc);
            }
            if (this.vzd != null) {
                bs += C6091a.m9575f(7, this.vzd);
            }
            if (this.vze != null) {
                bs += C6091a.m9575f(8, this.vze);
            }
            if (this.vzf != null) {
                bs += C6091a.m9575f(9, this.vzf);
            }
            bs += C6091a.m9572bs(10, this.vzg);
            AppMethodBeat.m2505o(72821);
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
            AppMethodBeat.m2505o(72821);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46513e c46513e = (C46513e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c46513e.uin = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72821);
                    return 0;
                case 2:
                    c46513e.vyR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72821);
                    return 0;
                case 3:
                    c46513e.nettype = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72821);
                    return 0;
                case 4:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23364d c23364d = new C23364d();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c23364d.populateBuilderWithField(c6086a3, c23364d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46513e.vyS.add(c23364d);
                    }
                    AppMethodBeat.m2505o(72821);
                    return 0;
                case 5:
                    c46513e.vzb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72821);
                    return 0;
                case 6:
                    c46513e.vzc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72821);
                    return 0;
                case 7:
                    c46513e.vzd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72821);
                    return 0;
                case 8:
                    c46513e.vze = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72821);
                    return 0;
                case 9:
                    c46513e.vzf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72821);
                    return 0;
                case 10:
                    c46513e.vzg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72821);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72821);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72821);
            return -1;
        }
    }
}
