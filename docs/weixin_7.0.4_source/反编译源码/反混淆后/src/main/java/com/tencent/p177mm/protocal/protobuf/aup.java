package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aup */
public final class aup extends bsr {
    public String wbO;
    public String wyL;
    public LinkedList<String> wyM = new LinkedList();

    public aup() {
        AppMethodBeat.m2504i(11774);
        AppMethodBeat.m2505o(11774);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11775);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wbO == null) {
                c6092b = new C6092b("Not all required fields were included: corp_id");
                AppMethodBeat.m2505o(11775);
                throw c6092b;
            } else if (this.wyL == null) {
                c6092b = new C6092b("Not all required fields were included: bizchat_name");
                AppMethodBeat.m2505o(11775);
                throw c6092b;
            } else {
                if (this.BaseRequest != null) {
                    c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(c6093a);
                }
                if (this.wbO != null) {
                    c6093a.mo13475e(2, this.wbO);
                }
                if (this.wyL != null) {
                    c6093a.mo13475e(3, this.wyL);
                }
                c6093a.mo13474e(4, 1, this.wyM);
                AppMethodBeat.m2505o(11775);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbO != null) {
                ix += C6091a.m9575f(2, this.wbO);
            }
            if (this.wyL != null) {
                ix += C6091a.m9575f(3, this.wyL);
            }
            int c = ix + C6087a.m9552c(4, 1, this.wyM);
            AppMethodBeat.m2505o(11775);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wyM.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wbO == null) {
                c6092b = new C6092b("Not all required fields were included: corp_id");
                AppMethodBeat.m2505o(11775);
                throw c6092b;
            } else if (this.wyL == null) {
                c6092b = new C6092b("Not all required fields were included: bizchat_name");
                AppMethodBeat.m2505o(11775);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(11775);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aup aup = (aup) objArr[1];
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
                        aup.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(11775);
                    return 0;
                case 2:
                    aup.wbO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11775);
                    return 0;
                case 3:
                    aup.wyL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11775);
                    return 0;
                case 4:
                    aup.wyM.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(11775);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11775);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11775);
            return -1;
        }
    }
}
