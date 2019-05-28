package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.hh */
public final class C7266hh extends C1331a {
    public SKBuiltinBuffer_t vHM;
    public SKBuiltinBuffer_t vHN;
    public String vHS;
    public SKBuiltinBuffer_t vJT;
    public csd vJU;
    public cwd vJV;
    public int vJW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58891);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vJT != null) {
                c6093a.mo13479iy(1, this.vJT.computeSize());
                this.vJT.writeFields(c6093a);
            }
            if (this.vJU != null) {
                c6093a.mo13479iy(2, this.vJU.computeSize());
                this.vJU.writeFields(c6093a);
            }
            if (this.vJV != null) {
                c6093a.mo13479iy(3, this.vJV.computeSize());
                this.vJV.writeFields(c6093a);
            }
            if (this.vHM != null) {
                c6093a.mo13479iy(4, this.vHM.computeSize());
                this.vHM.writeFields(c6093a);
            }
            if (this.vHN != null) {
                c6093a.mo13479iy(5, this.vHN.computeSize());
                this.vHN.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.vJW);
            if (this.vHS != null) {
                c6093a.mo13475e(7, this.vHS);
            }
            AppMethodBeat.m2505o(58891);
            return 0;
        } else if (i == 1) {
            if (this.vJT != null) {
                ix = C6087a.m9557ix(1, this.vJT.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vJU != null) {
                ix += C6087a.m9557ix(2, this.vJU.computeSize());
            }
            if (this.vJV != null) {
                ix += C6087a.m9557ix(3, this.vJV.computeSize());
            }
            if (this.vHM != null) {
                ix += C6087a.m9557ix(4, this.vHM.computeSize());
            }
            if (this.vHN != null) {
                ix += C6087a.m9557ix(5, this.vHN.computeSize());
            }
            ix += C6091a.m9572bs(6, this.vJW);
            if (this.vHS != null) {
                ix += C6091a.m9575f(7, this.vHS);
            }
            AppMethodBeat.m2505o(58891);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58891);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7266hh c7266hh = (C7266hh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7266hh.vJT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58891);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        csd csd = new csd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = csd.populateBuilderWithField(c6086a3, csd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7266hh.vJU = csd;
                    }
                    AppMethodBeat.m2505o(58891);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwd cwd = new cwd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwd.populateBuilderWithField(c6086a3, cwd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7266hh.vJV = cwd;
                    }
                    AppMethodBeat.m2505o(58891);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7266hh.vHM = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58891);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7266hh.vHN = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58891);
                    return 0;
                case 6:
                    c7266hh.vJW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58891);
                    return 0;
                case 7:
                    c7266hh.vHS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58891);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58891);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58891);
            return -1;
        }
    }
}
