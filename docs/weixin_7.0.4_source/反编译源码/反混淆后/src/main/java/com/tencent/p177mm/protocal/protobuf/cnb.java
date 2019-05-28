package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cnb */
public final class cnb extends bsr {
    public String ProductID;
    public int pdc;
    public String wOs;
    public String wOt;
    public int wOu;
    public String wOv;
    public int xkA;
    public String xkB;
    public SKBuiltinBuffer_t xky;
    public int xkz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56992);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xky == null) {
                c6092b = new C6092b("Not all required fields were included: Receipt");
                AppMethodBeat.m2505o(56992);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.xky != null) {
                c6093a.mo13479iy(2, this.xky.computeSize());
                this.xky.writeFields(c6093a);
            }
            if (this.ProductID != null) {
                c6093a.mo13475e(3, this.ProductID);
            }
            c6093a.mo13480iz(4, this.xkz);
            c6093a.mo13480iz(5, this.pdc);
            if (this.wOs != null) {
                c6093a.mo13475e(6, this.wOs);
            }
            if (this.wOt != null) {
                c6093a.mo13475e(7, this.wOt);
            }
            if (this.wOv != null) {
                c6093a.mo13475e(8, this.wOv);
            }
            c6093a.mo13480iz(9, this.xkA);
            if (this.xkB != null) {
                c6093a.mo13475e(10, this.xkB);
            }
            c6093a.mo13480iz(11, this.wOu);
            AppMethodBeat.m2505o(56992);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xky != null) {
                ix += C6087a.m9557ix(2, this.xky.computeSize());
            }
            if (this.ProductID != null) {
                ix += C6091a.m9575f(3, this.ProductID);
            }
            ix = (ix + C6091a.m9572bs(4, this.xkz)) + C6091a.m9572bs(5, this.pdc);
            if (this.wOs != null) {
                ix += C6091a.m9575f(6, this.wOs);
            }
            if (this.wOt != null) {
                ix += C6091a.m9575f(7, this.wOt);
            }
            if (this.wOv != null) {
                ix += C6091a.m9575f(8, this.wOv);
            }
            ix += C6091a.m9572bs(9, this.xkA);
            if (this.xkB != null) {
                ix += C6091a.m9575f(10, this.xkB);
            }
            int bs = ix + C6091a.m9572bs(11, this.wOu);
            AppMethodBeat.m2505o(56992);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xky == null) {
                c6092b = new C6092b("Not all required fields were included: Receipt");
                AppMethodBeat.m2505o(56992);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56992);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cnb cnb = (cnb) objArr[1];
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
                        cnb.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cnb.xky = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 3:
                    cnb.ProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 4:
                    cnb.xkz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 5:
                    cnb.pdc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 6:
                    cnb.wOs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 7:
                    cnb.wOt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 8:
                    cnb.wOv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 9:
                    cnb.xkA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 10:
                    cnb.xkB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56992);
                    return 0;
                case 11:
                    cnb.wOu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56992);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56992);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56992);
            return -1;
        }
    }
}
