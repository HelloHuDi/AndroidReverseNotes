package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cot */
public final class cot extends bsr {
    public int vZF;
    public long wOP;
    public int wOQ;
    public String xmv;
    public C1332b xmw;
    public C1332b xmx;
    public String xmy;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(135447);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xmv == null) {
                c6092b = new C6092b("Not all required fields were included: ToBizUserName");
                AppMethodBeat.m2505o(135447);
                throw c6092b;
            } else if (this.xmx == null) {
                c6092b = new C6092b("Not all required fields were included: CapInfo");
                AppMethodBeat.m2505o(135447);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.wOQ);
                if (this.xmv != null) {
                    c6093a.mo13475e(3, this.xmv);
                }
                c6093a.mo13480iz(4, this.vZF);
                if (this.xmw != null) {
                    c6093a.mo13473c(5, this.xmw);
                }
                if (this.xmx != null) {
                    c6093a.mo13473c(6, this.xmx);
                }
                c6093a.mo13472ai(7, this.wOP);
                if (this.xmy != null) {
                    c6093a.mo13475e(8, this.xmy);
                }
                AppMethodBeat.m2505o(135447);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.wOQ);
            if (this.xmv != null) {
                ix += C6091a.m9575f(3, this.xmv);
            }
            ix += C6091a.m9572bs(4, this.vZF);
            if (this.xmw != null) {
                ix += C6091a.m9571b(5, this.xmw);
            }
            if (this.xmx != null) {
                ix += C6091a.m9571b(6, this.xmx);
            }
            ix += C6091a.m9578o(7, this.wOP);
            if (this.xmy != null) {
                ix += C6091a.m9575f(8, this.xmy);
            }
            AppMethodBeat.m2505o(135447);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xmv == null) {
                c6092b = new C6092b("Not all required fields were included: ToBizUserName");
                AppMethodBeat.m2505o(135447);
                throw c6092b;
            } else if (this.xmx == null) {
                c6092b = new C6092b("Not all required fields were included: CapInfo");
                AppMethodBeat.m2505o(135447);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(135447);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cot cot = (cot) objArr[1];
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
                        cot.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(135447);
                    return 0;
                case 2:
                    cot.wOQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135447);
                    return 0;
                case 3:
                    cot.xmv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135447);
                    return 0;
                case 4:
                    cot.vZF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135447);
                    return 0;
                case 5:
                    cot.xmw = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(135447);
                    return 0;
                case 6:
                    cot.xmx = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(135447);
                    return 0;
                case 7:
                    cot.wOP = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(135447);
                    return 0;
                case 8:
                    cot.xmy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(135447);
                    return 0;
                default:
                    AppMethodBeat.m2505o(135447);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(135447);
            return -1;
        }
    }
}
