package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bds */
public final class bds extends C1331a {
    public auj vQK;
    public cgv wbo;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48900);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vQK != null) {
                c6093a.mo13479iy(1, this.vQK.computeSize());
                this.vQK.writeFields(c6093a);
            }
            if (this.wbo != null) {
                c6093a.mo13479iy(2, this.wbo.computeSize());
                this.wbo.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48900);
            return 0;
        } else if (i == 1) {
            if (this.vQK != null) {
                ix = C6087a.m9557ix(1, this.vQK.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbo != null) {
                ix += C6087a.m9557ix(2, this.wbo.computeSize());
            }
            AppMethodBeat.m2505o(48900);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48900);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bds bds = (bds) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        auj auj = new auj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.populateBuilderWithField(c6086a3, auj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bds.vQK = auj;
                    }
                    AppMethodBeat.m2505o(48900);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bds.wbo = cgv;
                    }
                    AppMethodBeat.m2505o(48900);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48900);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48900);
            return -1;
        }
    }
}
