package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bis */
public final class bis extends bsr {
    public String pcU;
    public int pdc;
    public String pdn;
    public C15319aw vRP;
    public int wMd;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56880);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.wMd);
            if (this.pcU != null) {
                c6093a.mo13475e(3, this.pcU);
            }
            c6093a.mo13480iz(4, this.pdc);
            if (this.pdn != null) {
                c6093a.mo13475e(5, this.pdn);
            }
            if (this.vRP != null) {
                c6093a.mo13479iy(6, this.vRP.computeSize());
                this.vRP.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56880);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.wMd);
            if (this.pcU != null) {
                ix += C6091a.m9575f(3, this.pcU);
            }
            ix += C6091a.m9572bs(4, this.pdc);
            if (this.pdn != null) {
                ix += C6091a.m9575f(5, this.pdn);
            }
            if (this.vRP != null) {
                ix += C6087a.m9557ix(6, this.vRP.computeSize());
            }
            AppMethodBeat.m2505o(56880);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56880);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bis bis = (bis) objArr[1];
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
                        bis.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56880);
                    return 0;
                case 2:
                    bis.wMd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56880);
                    return 0;
                case 3:
                    bis.pcU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56880);
                    return 0;
                case 4:
                    bis.pdc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56880);
                    return 0;
                case 5:
                    bis.pdn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56880);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15319aw c15319aw = new C15319aw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15319aw.populateBuilderWithField(c6086a3, c15319aw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bis.vRP = c15319aw;
                    }
                    AppMethodBeat.m2505o(56880);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56880);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56880);
            return -1;
        }
    }
}
