package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ckb */
public final class ckb extends bsr {
    public int Scene;
    public SKBuiltinBuffer_t vLz;
    public String xil;
    public String xim;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(59395);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.xil != null) {
                c6093a.mo13475e(2, this.xil);
            }
            if (this.xim != null) {
                c6093a.mo13475e(3, this.xim);
            }
            c6093a.mo13480iz(4, this.Scene);
            if (this.vLz != null) {
                c6093a.mo13479iy(5, this.vLz.computeSize());
                this.vLz.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(59395);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xil != null) {
                ix += C6091a.m9575f(2, this.xil);
            }
            if (this.xim != null) {
                ix += C6091a.m9575f(3, this.xim);
            }
            ix += C6091a.m9572bs(4, this.Scene);
            if (this.vLz != null) {
                ix += C6087a.m9557ix(5, this.vLz.computeSize());
            }
            AppMethodBeat.m2505o(59395);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(59395);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ckb ckb = (ckb) objArr[1];
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
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ckb.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(59395);
                    return 0;
                case 2:
                    ckb.xil = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(59395);
                    return 0;
                case 3:
                    ckb.xim = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(59395);
                    return 0;
                case 4:
                    ckb.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(59395);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ckb.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(59395);
                    return 0;
                default:
                    AppMethodBeat.m2505o(59395);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(59395);
            return -1;
        }
    }
}
