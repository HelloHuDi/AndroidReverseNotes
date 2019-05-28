package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.zx */
public final class C23470zx extends bsr {
    public String duc;
    public String dud;
    public String lvz;
    public String wfd;
    public String wfe;
    public long wff;
    public double wfg;
    public double wfh;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56784);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.lvz != null) {
                c6093a.mo13475e(2, this.lvz);
            }
            if (this.dud != null) {
                c6093a.mo13475e(3, this.dud);
            }
            if (this.duc != null) {
                c6093a.mo13475e(4, this.duc);
            }
            if (this.wfd != null) {
                c6093a.mo13475e(5, this.wfd);
            }
            if (this.wfe != null) {
                c6093a.mo13475e(6, this.wfe);
            }
            c6093a.mo13472ai(7, this.wff);
            c6093a.mo13476f(8, this.wfg);
            c6093a.mo13476f(9, this.wfh);
            AppMethodBeat.m2505o(56784);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.lvz != null) {
                ix += C6091a.m9575f(2, this.lvz);
            }
            if (this.dud != null) {
                ix += C6091a.m9575f(3, this.dud);
            }
            if (this.duc != null) {
                ix += C6091a.m9575f(4, this.duc);
            }
            if (this.wfd != null) {
                ix += C6091a.m9575f(5, this.wfd);
            }
            if (this.wfe != null) {
                ix += C6091a.m9575f(6, this.wfe);
            }
            int o = ((ix + C6091a.m9578o(7, this.wff)) + (C6091a.m9576fv(8) + 8)) + (C6091a.m9576fv(9) + 8);
            AppMethodBeat.m2505o(56784);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56784);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23470zx c23470zx = (C23470zx) objArr[1];
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
                        c23470zx.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56784);
                    return 0;
                case 2:
                    c23470zx.lvz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56784);
                    return 0;
                case 3:
                    c23470zx.dud = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56784);
                    return 0;
                case 4:
                    c23470zx.duc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56784);
                    return 0;
                case 5:
                    c23470zx.wfd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56784);
                    return 0;
                case 6:
                    c23470zx.wfe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56784);
                    return 0;
                case 7:
                    c23470zx.wff = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56784);
                    return 0;
                case 8:
                    c23470zx.wfg = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56784);
                    return 0;
                case 9:
                    c23470zx.wfh = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(56784);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56784);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56784);
            return -1;
        }
    }
}
