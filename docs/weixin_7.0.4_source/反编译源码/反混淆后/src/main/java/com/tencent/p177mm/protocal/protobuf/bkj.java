package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bkj */
public final class bkj extends C1331a {
    public String mZV;
    public cvr wNv;
    public cvu wNw;
    public cvn wNx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63690);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZV == null) {
                c6092b = new C6092b("Not all required fields were included: PkgId");
                AppMethodBeat.m2505o(63690);
                throw c6092b;
            }
            if (this.mZV != null) {
                c6093a.mo13475e(1, this.mZV);
            }
            if (this.wNv != null) {
                c6093a.mo13479iy(2, this.wNv.computeSize());
                this.wNv.writeFields(c6093a);
            }
            if (this.wNw != null) {
                c6093a.mo13479iy(3, this.wNw.computeSize());
                this.wNw.writeFields(c6093a);
            }
            if (this.wNx != null) {
                c6093a.mo13479iy(4, this.wNx.computeSize());
                this.wNx.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(63690);
            return 0;
        } else if (i == 1) {
            if (this.mZV != null) {
                f = C6091a.m9575f(1, this.mZV) + 0;
            } else {
                f = 0;
            }
            if (this.wNv != null) {
                f += C6087a.m9557ix(2, this.wNv.computeSize());
            }
            if (this.wNw != null) {
                f += C6087a.m9557ix(3, this.wNw.computeSize());
            }
            if (this.wNx != null) {
                f += C6087a.m9557ix(4, this.wNx.computeSize());
            }
            AppMethodBeat.m2505o(63690);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.mZV == null) {
                c6092b = new C6092b("Not all required fields were included: PkgId");
                AppMethodBeat.m2505o(63690);
                throw c6092b;
            }
            AppMethodBeat.m2505o(63690);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bkj bkj = (bkj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bkj.mZV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63690);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvr cvr = new cvr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvr.populateBuilderWithField(c6086a3, cvr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkj.wNv = cvr;
                    }
                    AppMethodBeat.m2505o(63690);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvu cvu = new cvu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvu.populateBuilderWithField(c6086a3, cvu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkj.wNw = cvu;
                    }
                    AppMethodBeat.m2505o(63690);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvn cvn = new cvn();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvn.populateBuilderWithField(c6086a3, cvn, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bkj.wNx = cvn;
                    }
                    AppMethodBeat.m2505o(63690);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63690);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63690);
            return -1;
        }
    }
}
