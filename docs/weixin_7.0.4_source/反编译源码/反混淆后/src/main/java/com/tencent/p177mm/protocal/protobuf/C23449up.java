package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.up */
public final class C23449up extends bsr {
    public int Scene;
    public int ehB;
    public LinkedList<bay> vEh = new LinkedList();
    public bts wcc;
    public SKBuiltinBuffer_t wcd;

    public C23449up() {
        AppMethodBeat.m2504i(5568);
        AppMethodBeat.m2505o(5568);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5569);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcc == null) {
                c6092b = new C6092b("Not all required fields were included: Topic");
                AppMethodBeat.m2505o(5569);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wcc != null) {
                c6093a.mo13479iy(2, this.wcc.computeSize());
                this.wcc.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.ehB);
            c6093a.mo13474e(4, 8, this.vEh);
            c6093a.mo13480iz(5, this.Scene);
            if (this.wcd != null) {
                c6093a.mo13479iy(6, this.wcd.computeSize());
                this.wcd.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(5569);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcc != null) {
                ix += C6087a.m9557ix(2, this.wcc.computeSize());
            }
            ix = ((ix + C6091a.m9572bs(3, this.ehB)) + C6087a.m9552c(4, 8, this.vEh)) + C6091a.m9572bs(5, this.Scene);
            if (this.wcd != null) {
                ix += C6087a.m9557ix(6, this.wcd.computeSize());
            }
            AppMethodBeat.m2505o(5569);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wcc == null) {
                c6092b = new C6092b("Not all required fields were included: Topic");
                AppMethodBeat.m2505o(5569);
                throw c6092b;
            }
            AppMethodBeat.m2505o(5569);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23449up c23449up = (C23449up) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        c23449up.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(5569);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23449up.wcc = bts;
                    }
                    AppMethodBeat.m2505o(5569);
                    return 0;
                case 3:
                    c23449up.ehB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5569);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bay bay = new bay();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bay.populateBuilderWithField(c6086a3, bay, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23449up.vEh.add(bay);
                    }
                    AppMethodBeat.m2505o(5569);
                    return 0;
                case 5:
                    c23449up.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5569);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23449up.wcd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5569);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5569);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5569);
            return -1;
        }
    }
}
