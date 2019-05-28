package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fo */
public final class C30184fo extends C1331a {
    public String cxb;
    public String geY;
    public bgc vHx;
    public LinkedList<bgc> vHy = new LinkedList();

    public C30184fo() {
        AppMethodBeat.m2504i(80020);
        AppMethodBeat.m2505o(80020);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80021);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.geY != null) {
                c6093a.mo13475e(1, this.geY);
            }
            if (this.vHx != null) {
                c6093a.mo13479iy(2, this.vHx.computeSize());
                this.vHx.writeFields(c6093a);
            }
            c6093a.mo13474e(3, 8, this.vHy);
            if (this.cxb != null) {
                c6093a.mo13475e(4, this.cxb);
            }
            AppMethodBeat.m2505o(80021);
            return 0;
        } else if (i == 1) {
            if (this.geY != null) {
                f = C6091a.m9575f(1, this.geY) + 0;
            } else {
                f = 0;
            }
            if (this.vHx != null) {
                f += C6087a.m9557ix(2, this.vHx.computeSize());
            }
            f += C6087a.m9552c(3, 8, this.vHy);
            if (this.cxb != null) {
                f += C6091a.m9575f(4, this.cxb);
            }
            AppMethodBeat.m2505o(80021);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vHy.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80021);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30184fo c30184fo = (C30184fo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            bgc bgc;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c30184fo.geY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80021);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgc = new bgc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgc.populateBuilderWithField(c6086a3, bgc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30184fo.vHx = bgc;
                    }
                    AppMethodBeat.m2505o(80021);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgc = new bgc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgc.populateBuilderWithField(c6086a3, bgc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30184fo.vHy.add(bgc);
                    }
                    AppMethodBeat.m2505o(80021);
                    return 0;
                case 4:
                    c30184fo.cxb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80021);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80021);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80021);
            return -1;
        }
    }
}
