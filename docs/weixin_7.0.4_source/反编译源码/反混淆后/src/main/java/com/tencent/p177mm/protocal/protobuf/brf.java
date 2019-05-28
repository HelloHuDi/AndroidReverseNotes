package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.brf */
public final class brf extends C1331a {
    public SKBuiltinBuffer_t wTA;
    public SKBuiltinBuffer_t wTB;
    public SKBuiltinBuffer_t wTC;
    public SKBuiltinBuffer_t wTD;
    public int wTz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94553);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wTz);
            if (this.wTA != null) {
                c6093a.mo13479iy(2, this.wTA.computeSize());
                this.wTA.writeFields(c6093a);
            }
            if (this.wTB != null) {
                c6093a.mo13479iy(3, this.wTB.computeSize());
                this.wTB.writeFields(c6093a);
            }
            if (this.wTC != null) {
                c6093a.mo13479iy(4, this.wTC.computeSize());
                this.wTC.writeFields(c6093a);
            }
            if (this.wTD != null) {
                c6093a.mo13479iy(5, this.wTD.computeSize());
                this.wTD.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(94553);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wTz) + 0;
            if (this.wTA != null) {
                bs += C6087a.m9557ix(2, this.wTA.computeSize());
            }
            if (this.wTB != null) {
                bs += C6087a.m9557ix(3, this.wTB.computeSize());
            }
            if (this.wTC != null) {
                bs += C6087a.m9557ix(4, this.wTC.computeSize());
            }
            if (this.wTD != null) {
                bs += C6087a.m9557ix(5, this.wTD.computeSize());
            }
            AppMethodBeat.m2505o(94553);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94553);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            brf brf = (brf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    brf.wTz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94553);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        brf.wTA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94553);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        brf.wTB = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94553);
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
                        brf.wTC = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94553);
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
                        brf.wTD = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(94553);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94553);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94553);
            return -1;
        }
    }
}
