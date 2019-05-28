package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ben */
public final class ben extends bsr {
    public int vOn;
    public SKBuiltinBuffer_t vOo;
    public int vOr;
    public int vOs;
    public String wID;
    public String wIE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(81505);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vOo == null) {
                c6092b = new C6092b("Not all required fields were included: ImageBuffer");
                AppMethodBeat.m2505o(81505);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vOn);
            if (this.vOo != null) {
                c6093a.mo13479iy(3, this.vOo.computeSize());
                this.vOo.writeFields(c6093a);
            }
            c6093a.mo13480iz(4, this.vOr);
            if (this.wID != null) {
                c6093a.mo13475e(5, this.wID);
            }
            if (this.wIE != null) {
                c6093a.mo13475e(6, this.wIE);
            }
            c6093a.mo13480iz(7, this.vOs);
            AppMethodBeat.m2505o(81505);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.vOn);
            if (this.vOo != null) {
                ix += C6087a.m9557ix(3, this.vOo.computeSize());
            }
            ix += C6091a.m9572bs(4, this.vOr);
            if (this.wID != null) {
                ix += C6091a.m9575f(5, this.wID);
            }
            if (this.wIE != null) {
                ix += C6091a.m9575f(6, this.wIE);
            }
            int bs = ix + C6091a.m9572bs(7, this.vOs);
            AppMethodBeat.m2505o(81505);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vOo == null) {
                c6092b = new C6092b("Not all required fields were included: ImageBuffer");
                AppMethodBeat.m2505o(81505);
                throw c6092b;
            }
            AppMethodBeat.m2505o(81505);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ben ben = (ben) objArr[1];
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
                        ben.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(81505);
                    return 0;
                case 2:
                    ben.vOn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81505);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ben.vOo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(81505);
                    return 0;
                case 4:
                    ben.vOr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81505);
                    return 0;
                case 5:
                    ben.wID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(81505);
                    return 0;
                case 6:
                    ben.wIE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(81505);
                    return 0;
                case 7:
                    ben.vOs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(81505);
                    return 0;
                default:
                    AppMethodBeat.m2505o(81505);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(81505);
            return -1;
        }
    }
}
