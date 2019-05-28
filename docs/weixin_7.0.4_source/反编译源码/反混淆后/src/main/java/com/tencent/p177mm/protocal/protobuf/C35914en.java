package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.en */
public final class C35914en extends bsr {
    public String fBq;
    public int kdC;
    public int scene;
    public String session_id;
    public String url;
    public int vFO;
    public int vFP;
    public int vFQ;
    public String vGv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14698);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.url != null) {
                c6093a.mo13475e(2, this.url);
            }
            if (this.fBq != null) {
                c6093a.mo13475e(3, this.fBq);
            }
            if (this.vGv != null) {
                c6093a.mo13475e(4, this.vGv);
            }
            c6093a.mo13480iz(5, this.scene);
            c6093a.mo13480iz(6, this.vFQ);
            c6093a.mo13480iz(7, this.vFP);
            c6093a.mo13480iz(8, this.kdC);
            c6093a.mo13480iz(10, this.vFO);
            if (this.session_id != null) {
                c6093a.mo13475e(11, this.session_id);
            }
            AppMethodBeat.m2505o(14698);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.url != null) {
                ix += C6091a.m9575f(2, this.url);
            }
            if (this.fBq != null) {
                ix += C6091a.m9575f(3, this.fBq);
            }
            if (this.vGv != null) {
                ix += C6091a.m9575f(4, this.vGv);
            }
            ix = ((((ix + C6091a.m9572bs(5, this.scene)) + C6091a.m9572bs(6, this.vFQ)) + C6091a.m9572bs(7, this.vFP)) + C6091a.m9572bs(8, this.kdC)) + C6091a.m9572bs(10, this.vFO);
            if (this.session_id != null) {
                ix += C6091a.m9575f(11, this.session_id);
            }
            AppMethodBeat.m2505o(14698);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14698);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35914en c35914en = (C35914en) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c35914en.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(14698);
                    return 0;
                case 2:
                    c35914en.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14698);
                    return 0;
                case 3:
                    c35914en.fBq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14698);
                    return 0;
                case 4:
                    c35914en.vGv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14698);
                    return 0;
                case 5:
                    c35914en.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14698);
                    return 0;
                case 6:
                    c35914en.vFQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14698);
                    return 0;
                case 7:
                    c35914en.vFP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14698);
                    return 0;
                case 8:
                    c35914en.kdC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14698);
                    return 0;
                case 10:
                    c35914en.vFO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14698);
                    return 0;
                case 11:
                    c35914en.session_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14698);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14698);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14698);
            return -1;
        }
    }
}
