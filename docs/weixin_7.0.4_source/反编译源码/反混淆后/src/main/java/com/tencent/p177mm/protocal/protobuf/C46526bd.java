package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bd */
public final class C46526bd extends C1331a {
    public C44101be vDb;
    public C44101be vDc;
    public C44101be vDd;
    public C44101be vDe;
    public C44101be vDf;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73643);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vDb != null) {
                c6093a.mo13479iy(1, this.vDb.computeSize());
                this.vDb.writeFields(c6093a);
            }
            if (this.vDc != null) {
                c6093a.mo13479iy(2, this.vDc.computeSize());
                this.vDc.writeFields(c6093a);
            }
            if (this.vDd != null) {
                c6093a.mo13479iy(3, this.vDd.computeSize());
                this.vDd.writeFields(c6093a);
            }
            if (this.vDe != null) {
                c6093a.mo13479iy(4, this.vDe.computeSize());
                this.vDe.writeFields(c6093a);
            }
            if (this.vDf != null) {
                c6093a.mo13479iy(5, this.vDf.computeSize());
                this.vDf.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(73643);
            return 0;
        } else if (i == 1) {
            if (this.vDb != null) {
                ix = C6087a.m9557ix(1, this.vDb.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vDc != null) {
                ix += C6087a.m9557ix(2, this.vDc.computeSize());
            }
            if (this.vDd != null) {
                ix += C6087a.m9557ix(3, this.vDd.computeSize());
            }
            if (this.vDe != null) {
                ix += C6087a.m9557ix(4, this.vDe.computeSize());
            }
            if (this.vDf != null) {
                ix += C6087a.m9557ix(5, this.vDf.computeSize());
            }
            AppMethodBeat.m2505o(73643);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73643);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46526bd c46526bd = (C46526bd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C44101be c44101be;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44101be = new C44101be();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44101be.populateBuilderWithField(c6086a3, c44101be, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46526bd.vDb = c44101be;
                    }
                    AppMethodBeat.m2505o(73643);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44101be = new C44101be();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44101be.populateBuilderWithField(c6086a3, c44101be, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46526bd.vDc = c44101be;
                    }
                    AppMethodBeat.m2505o(73643);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44101be = new C44101be();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44101be.populateBuilderWithField(c6086a3, c44101be, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46526bd.vDd = c44101be;
                    }
                    AppMethodBeat.m2505o(73643);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44101be = new C44101be();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44101be.populateBuilderWithField(c6086a3, c44101be, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46526bd.vDe = c44101be;
                    }
                    AppMethodBeat.m2505o(73643);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c44101be = new C44101be();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44101be.populateBuilderWithField(c6086a3, c44101be, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46526bd.vDf = c44101be;
                    }
                    AppMethodBeat.m2505o(73643);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73643);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73643);
            return -1;
        }
    }
}
