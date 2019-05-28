package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.el */
public final class C15335el extends bsr {
    public int kdC;
    public int scene;
    public String session_id;
    public String url;
    public int vFO;
    public int vFP;
    public int vFQ;
    public int vGr;
    public String vGs;
    public int vGt;
    public int vGu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14696);
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
            c6093a.mo13480iz(5, this.vGr);
            if (this.vGs != null) {
                c6093a.mo13475e(6, this.vGs);
            }
            c6093a.mo13480iz(7, this.vGt);
            c6093a.mo13480iz(8, this.kdC);
            c6093a.mo13480iz(9, this.vGu);
            c6093a.mo13480iz(10, this.scene);
            c6093a.mo13480iz(11, this.vFQ);
            c6093a.mo13480iz(12, this.vFP);
            c6093a.mo13480iz(13, this.vFO);
            if (this.session_id != null) {
                c6093a.mo13475e(14, this.session_id);
            }
            AppMethodBeat.m2505o(14696);
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
            ix += C6091a.m9572bs(5, this.vGr);
            if (this.vGs != null) {
                ix += C6091a.m9575f(6, this.vGs);
            }
            ix = ((((((ix + C6091a.m9572bs(7, this.vGt)) + C6091a.m9572bs(8, this.kdC)) + C6091a.m9572bs(9, this.vGu)) + C6091a.m9572bs(10, this.scene)) + C6091a.m9572bs(11, this.vFQ)) + C6091a.m9572bs(12, this.vFP)) + C6091a.m9572bs(13, this.vFO);
            if (this.session_id != null) {
                ix += C6091a.m9575f(14, this.session_id);
            }
            AppMethodBeat.m2505o(14696);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14696);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15335el c15335el = (C15335el) objArr[1];
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
                        c15335el.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 2:
                    c15335el.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 5:
                    c15335el.vGr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 6:
                    c15335el.vGs = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 7:
                    c15335el.vGt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 8:
                    c15335el.kdC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 9:
                    c15335el.vGu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 10:
                    c15335el.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 11:
                    c15335el.vFQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 12:
                    c15335el.vFP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 13:
                    c15335el.vFO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                case 14:
                    c15335el.session_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14696);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14696);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14696);
            return -1;
        }
    }
}
