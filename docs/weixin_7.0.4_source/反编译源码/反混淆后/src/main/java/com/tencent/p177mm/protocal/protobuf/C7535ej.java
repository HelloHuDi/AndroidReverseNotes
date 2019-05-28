package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ej */
public final class C7535ej extends bsr {
    public String fgd;
    public int nettype;
    public int scene;
    public String session_id;
    public String url;
    public int vFP;
    public int vFQ;
    public int vGf;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14693);
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
            if (this.fgd != null) {
                c6093a.mo13475e(3, this.fgd);
            }
            c6093a.mo13480iz(4, this.scene);
            c6093a.mo13480iz(5, this.vFQ);
            c6093a.mo13480iz(6, this.nettype);
            if (this.session_id != null) {
                c6093a.mo13475e(7, this.session_id);
            }
            c6093a.mo13480iz(8, this.vFP);
            c6093a.mo13480iz(9, this.vGf);
            AppMethodBeat.m2505o(14693);
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
            if (this.fgd != null) {
                ix += C6091a.m9575f(3, this.fgd);
            }
            ix = ((ix + C6091a.m9572bs(4, this.scene)) + C6091a.m9572bs(5, this.vFQ)) + C6091a.m9572bs(6, this.nettype);
            if (this.session_id != null) {
                ix += C6091a.m9575f(7, this.session_id);
            }
            int bs = (ix + C6091a.m9572bs(8, this.vFP)) + C6091a.m9572bs(9, this.vGf);
            AppMethodBeat.m2505o(14693);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14693);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7535ej c7535ej = (C7535ej) objArr[1];
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
                        c7535ej.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(14693);
                    return 0;
                case 2:
                    c7535ej.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14693);
                    return 0;
                case 3:
                    c7535ej.fgd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14693);
                    return 0;
                case 4:
                    c7535ej.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14693);
                    return 0;
                case 5:
                    c7535ej.vFQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14693);
                    return 0;
                case 6:
                    c7535ej.nettype = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14693);
                    return 0;
                case 7:
                    c7535ej.session_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14693);
                    return 0;
                case 8:
                    c7535ej.vFP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14693);
                    return 0;
                case 9:
                    c7535ej.vGf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14693);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14693);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14693);
            return -1;
        }
    }
}
