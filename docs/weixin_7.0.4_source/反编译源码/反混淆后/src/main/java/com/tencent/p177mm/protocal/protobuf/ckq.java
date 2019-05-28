package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ckq */
public final class ckq extends bsr {
    public String fKh;
    public String jBB;
    public int jCt;
    public int ptw;
    public int ptx;
    public int pty;
    public SKBuiltinBuffer_t ptz;
    public int vFE;
    public String wdO;
    public String xit;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28687);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(28687);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(2, this.fKh);
            }
            c6093a.mo13480iz(3, this.vFE);
            if (this.xit != null) {
                c6093a.mo13475e(4, this.xit);
            }
            if (this.jBB != null) {
                c6093a.mo13475e(5, this.jBB);
            }
            c6093a.mo13480iz(6, this.ptw);
            c6093a.mo13480iz(7, this.ptx);
            c6093a.mo13480iz(8, this.pty);
            if (this.ptz != null) {
                c6093a.mo13479iy(9, this.ptz.computeSize());
                this.ptz.writeFields(c6093a);
            }
            c6093a.mo13480iz(10, this.jCt);
            if (this.wdO != null) {
                c6093a.mo13475e(11, this.wdO);
            }
            AppMethodBeat.m2505o(28687);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += C6091a.m9575f(2, this.fKh);
            }
            ix += C6091a.m9572bs(3, this.vFE);
            if (this.xit != null) {
                ix += C6091a.m9575f(4, this.xit);
            }
            if (this.jBB != null) {
                ix += C6091a.m9575f(5, this.jBB);
            }
            ix = ((ix + C6091a.m9572bs(6, this.ptw)) + C6091a.m9572bs(7, this.ptx)) + C6091a.m9572bs(8, this.pty);
            if (this.ptz != null) {
                ix += C6087a.m9557ix(9, this.ptz.computeSize());
            }
            ix += C6091a.m9572bs(10, this.jCt);
            if (this.wdO != null) {
                ix += C6091a.m9575f(11, this.wdO);
            }
            AppMethodBeat.m2505o(28687);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.ptz == null) {
                c6092b = new C6092b("Not all required fields were included: Data");
                AppMethodBeat.m2505o(28687);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28687);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ckq ckq = (ckq) objArr[1];
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
                        ckq.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 2:
                    ckq.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 3:
                    ckq.vFE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 4:
                    ckq.xit = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 5:
                    ckq.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 6:
                    ckq.ptw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 7:
                    ckq.ptx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 8:
                    ckq.pty = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ckq.ptz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 10:
                    ckq.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28687);
                    return 0;
                case 11:
                    ckq.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28687);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28687);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28687);
            return -1;
        }
    }
}
