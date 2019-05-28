package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cms */
public final class cms extends bsr {
    public int Scene;
    public SKBuiltinBuffer_t vLz;
    public String wTm;
    public String wTn;
    public String wmM;
    public long wmO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(857);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wmM != null) {
                c6093a.mo13475e(2, this.wmM);
            }
            c6093a.mo13472ai(3, this.wmO);
            if (this.vLz != null) {
                c6093a.mo13479iy(4, this.vLz.computeSize());
                this.vLz.writeFields(c6093a);
            }
            if (this.wTm != null) {
                c6093a.mo13475e(5, this.wTm);
            }
            if (this.wTn != null) {
                c6093a.mo13475e(6, this.wTn);
            }
            c6093a.mo13480iz(7, this.Scene);
            AppMethodBeat.m2505o(857);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wmM != null) {
                ix += C6091a.m9575f(2, this.wmM);
            }
            ix += C6091a.m9578o(3, this.wmO);
            if (this.vLz != null) {
                ix += C6087a.m9557ix(4, this.vLz.computeSize());
            }
            if (this.wTm != null) {
                ix += C6091a.m9575f(5, this.wTm);
            }
            if (this.wTn != null) {
                ix += C6091a.m9575f(6, this.wTn);
            }
            int bs = ix + C6091a.m9572bs(7, this.Scene);
            AppMethodBeat.m2505o(857);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(857);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cms cms = (cms) objArr[1];
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
                        cms.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(857);
                    return 0;
                case 2:
                    cms.wmM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(857);
                    return 0;
                case 3:
                    cms.wmO = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(857);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cms.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(857);
                    return 0;
                case 5:
                    cms.wTm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(857);
                    return 0;
                case 6:
                    cms.wTn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(857);
                    return 0;
                case 7:
                    cms.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(857);
                    return 0;
                default:
                    AppMethodBeat.m2505o(857);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(857);
            return -1;
        }
    }
}
