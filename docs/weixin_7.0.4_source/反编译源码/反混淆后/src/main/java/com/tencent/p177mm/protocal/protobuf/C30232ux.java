package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ux */
public final class C30232ux extends C1331a {
    public bdq wcs;
    public LinkedList<C23461xc> wct = new LinkedList();
    public LinkedList<cnv> wcu = new LinkedList();
    public String wcv;

    public C30232ux() {
        AppMethodBeat.m2504i(48830);
        AppMethodBeat.m2505o(48830);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48831);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcs != null) {
                c6093a.mo13479iy(1, this.wcs.computeSize());
                this.wcs.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.wct);
            c6093a.mo13474e(3, 8, this.wcu);
            if (this.wcv != null) {
                c6093a.mo13475e(4, this.wcv);
            }
            AppMethodBeat.m2505o(48831);
            return 0;
        } else if (i == 1) {
            if (this.wcs != null) {
                ix = C6087a.m9557ix(1, this.wcs.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6087a.m9552c(2, 8, this.wct)) + C6087a.m9552c(3, 8, this.wcu);
            if (this.wcv != null) {
                ix += C6091a.m9575f(4, this.wcv);
            }
            AppMethodBeat.m2505o(48831);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wct.clear();
            this.wcu.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48831);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30232ux c30232ux = (C30232ux) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdq bdq = new bdq();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdq.populateBuilderWithField(c6086a3, bdq, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30232ux.wcs = bdq;
                    }
                    AppMethodBeat.m2505o(48831);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23461xc c23461xc = new C23461xc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23461xc.populateBuilderWithField(c6086a3, c23461xc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30232ux.wct.add(c23461xc);
                    }
                    AppMethodBeat.m2505o(48831);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnv cnv = new cnv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnv.populateBuilderWithField(c6086a3, cnv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30232ux.wcu.add(cnv);
                    }
                    AppMethodBeat.m2505o(48831);
                    return 0;
                case 4:
                    c30232ux.wcv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48831);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48831);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48831);
            return -1;
        }
    }
}
