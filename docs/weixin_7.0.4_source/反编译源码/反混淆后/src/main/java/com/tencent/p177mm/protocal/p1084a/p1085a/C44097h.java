package com.tencent.p177mm.protocal.p1084a.p1085a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.a.a.h */
public final class C44097h extends C1331a {
    public int ret;
    public int vyT;
    public int vyU;
    public C40497o vyV;
    public C40497o vyW;
    public int vyX;
    public int vyY;
    public int vzm;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72825);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.ret);
            c6093a.mo13480iz(2, this.vyT);
            c6093a.mo13480iz(3, this.vyU);
            if (this.vyV != null) {
                c6093a.mo13479iy(4, this.vyV.computeSize());
                this.vyV.writeFields(c6093a);
            }
            if (this.vyW != null) {
                c6093a.mo13479iy(5, this.vyW.computeSize());
                this.vyW.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.vyX);
            c6093a.mo13480iz(7, this.vzm);
            c6093a.mo13480iz(8, this.vyY);
            AppMethodBeat.m2505o(72825);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.ret) + 0) + C6091a.m9572bs(2, this.vyT)) + C6091a.m9572bs(3, this.vyU);
            if (this.vyV != null) {
                bs += C6087a.m9557ix(4, this.vyV.computeSize());
            }
            if (this.vyW != null) {
                bs += C6087a.m9557ix(5, this.vyW.computeSize());
            }
            bs = ((bs + C6091a.m9572bs(6, this.vyX)) + C6091a.m9572bs(7, this.vzm)) + C6091a.m9572bs(8, this.vyY);
            AppMethodBeat.m2505o(72825);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72825);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44097h c44097h = (C44097h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C40497o c40497o;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c44097h.ret = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72825);
                    return 0;
                case 2:
                    c44097h.vyT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72825);
                    return 0;
                case 3:
                    c44097h.vyU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72825);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c40497o = new C40497o();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40497o.populateBuilderWithField(c6086a3, c40497o, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44097h.vyV = c40497o;
                    }
                    AppMethodBeat.m2505o(72825);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c40497o = new C40497o();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40497o.populateBuilderWithField(c6086a3, c40497o, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44097h.vyW = c40497o;
                    }
                    AppMethodBeat.m2505o(72825);
                    return 0;
                case 6:
                    c44097h.vyX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72825);
                    return 0;
                case 7:
                    c44097h.vzm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72825);
                    return 0;
                case 8:
                    c44097h.vyY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72825);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72825);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72825);
            return -1;
        }
    }
}
