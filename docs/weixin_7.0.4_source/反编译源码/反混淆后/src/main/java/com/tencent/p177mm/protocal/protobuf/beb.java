package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.beb */
public final class beb extends bsr {
    public String jBB;
    public String luQ;
    public SKBuiltinBuffer_t wHH;
    public SKBuiltinBuffer_t wHI;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58917);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wHH == null) {
                c6092b = new C6092b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.m2505o(58917);
                throw c6092b;
            } else if (this.wHI == null) {
                c6092b = new C6092b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.m2505o(58917);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.jBB != null) {
                    c6093a.mo13475e(2, this.jBB);
                }
                if (this.wHH != null) {
                    c6093a.mo13479iy(3, this.wHH.computeSize());
                    this.wHH.writeFields(c6093a);
                }
                if (this.wHI != null) {
                    c6093a.mo13479iy(4, this.wHI.computeSize());
                    this.wHI.writeFields(c6093a);
                }
                if (this.luQ != null) {
                    c6093a.mo13475e(5, this.luQ);
                }
                AppMethodBeat.m2505o(58917);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.jBB != null) {
                ix += C6091a.m9575f(2, this.jBB);
            }
            if (this.wHH != null) {
                ix += C6087a.m9557ix(3, this.wHH.computeSize());
            }
            if (this.wHI != null) {
                ix += C6087a.m9557ix(4, this.wHI.computeSize());
            }
            if (this.luQ != null) {
                ix += C6091a.m9575f(5, this.luQ);
            }
            AppMethodBeat.m2505o(58917);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wHH == null) {
                c6092b = new C6092b("Not all required fields were included: CurrentSynckey");
                AppMethodBeat.m2505o(58917);
                throw c6092b;
            } else if (this.wHI == null) {
                c6092b = new C6092b("Not all required fields were included: MaxSynckey");
                AppMethodBeat.m2505o(58917);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(58917);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            beb beb = (beb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        beb.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(58917);
                    return 0;
                case 2:
                    beb.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58917);
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
                        beb.wHH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58917);
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
                        beb.wHI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58917);
                    return 0;
                case 5:
                    beb.luQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58917);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58917);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58917);
            return -1;
        }
    }
}
