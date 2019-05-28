package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.afx */
public final class afx extends bsr {
    /* renamed from: Cn */
    public int f17914Cn;
    public String data;
    public String wbO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11767);
        C6092b c6092b;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wbO == null) {
                c6092b = new C6092b("Not all required fields were included: corp_id");
                AppMethodBeat.m2505o(11767);
                throw c6092b;
            } else if (this.data == null) {
                c6092b = new C6092b("Not all required fields were included: data");
                AppMethodBeat.m2505o(11767);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.wbO != null) {
                    c6093a.mo13475e(2, this.wbO);
                }
                c6093a.mo13480iz(3, this.f17914Cn);
                if (this.data != null) {
                    c6093a.mo13475e(4, this.data);
                }
                AppMethodBeat.m2505o(11767);
                return 0;
            }
        } else if (i == 1) {
            int ix;
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbO != null) {
                ix += C6091a.m9575f(2, this.wbO);
            }
            ix += C6091a.m9572bs(3, this.f17914Cn);
            if (this.data != null) {
                ix += C6091a.m9575f(4, this.data);
            }
            AppMethodBeat.m2505o(11767);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (int nextFieldNumber = C1331a.getNextFieldNumber(c6086a); nextFieldNumber > 0; nextFieldNumber = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, nextFieldNumber)) {
                    c6086a.ems();
                }
            }
            if (this.wbO == null) {
                c6092b = new C6092b("Not all required fields were included: corp_id");
                AppMethodBeat.m2505o(11767);
                throw c6092b;
            } else if (bArr == null) {
                c6092b = new C6092b("Not all required fields were included: data");
                AppMethodBeat.m2505o(11767);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(11767);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            afx afx = (afx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        afx.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(11767);
                    return 0;
                case 2:
                    afx.wbO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11767);
                    return 0;
                case 3:
                    afx.f17914Cn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11767);
                    return 0;
                case 4:
                    afx.data = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11767);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11767);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11767);
            return -1;
        }
    }
}
