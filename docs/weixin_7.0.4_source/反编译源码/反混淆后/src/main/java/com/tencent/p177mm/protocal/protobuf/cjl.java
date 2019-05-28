package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cjl */
public final class cjl extends bsr {
    public String vMV;
    public String vNb;
    public C23407kg xig;
    public C23407kg xih;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11820);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vNb == null) {
                c6092b = new C6092b("Not all required fields were included: brand_user_name");
                AppMethodBeat.m2505o(11820);
                throw c6092b;
            } else if (this.vMV == null) {
                c6092b = new C6092b("Not all required fields were included: bizchat_id");
                AppMethodBeat.m2505o(11820);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.vNb != null) {
                    c6093a.mo13475e(2, this.vNb);
                }
                if (this.vMV != null) {
                    c6093a.mo13475e(3, this.vMV);
                }
                if (this.xig != null) {
                    c6093a.mo13479iy(4, this.xig.computeSize());
                    this.xig.writeFields(c6093a);
                }
                if (this.xih != null) {
                    c6093a.mo13479iy(5, this.xih.computeSize());
                    this.xih.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(11820);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vNb != null) {
                ix += C6091a.m9575f(2, this.vNb);
            }
            if (this.vMV != null) {
                ix += C6091a.m9575f(3, this.vMV);
            }
            if (this.xig != null) {
                ix += C6087a.m9557ix(4, this.xig.computeSize());
            }
            if (this.xih != null) {
                ix += C6087a.m9557ix(5, this.xih.computeSize());
            }
            AppMethodBeat.m2505o(11820);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vNb == null) {
                c6092b = new C6092b("Not all required fields were included: brand_user_name");
                AppMethodBeat.m2505o(11820);
                throw c6092b;
            } else if (this.vMV == null) {
                c6092b = new C6092b("Not all required fields were included: bizchat_id");
                AppMethodBeat.m2505o(11820);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(11820);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cjl cjl = (cjl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            C23407kg c23407kg;
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
                        cjl.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(11820);
                    return 0;
                case 2:
                    cjl.vNb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11820);
                    return 0;
                case 3:
                    cjl.vMV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11820);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23407kg = new C23407kg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23407kg.populateBuilderWithField(c6086a3, c23407kg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cjl.xig = c23407kg;
                    }
                    AppMethodBeat.m2505o(11820);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c23407kg = new C23407kg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23407kg.populateBuilderWithField(c6086a3, c23407kg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cjl.xih = c23407kg;
                    }
                    AppMethodBeat.m2505o(11820);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11820);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11820);
            return -1;
        }
    }
}
