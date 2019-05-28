package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.vh */
public final class C35960vh extends bsr {
    public String vEf;
    public LinkedList<String> vEg = new LinkedList();

    public C35960vh() {
        AppMethodBeat.m2504i(118268);
        AppMethodBeat.m2505o(118268);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(118269);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vEf == null) {
                c6092b = new C6092b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.m2505o(118269);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vEf != null) {
                c6093a.mo13475e(2, this.vEf);
            }
            c6093a.mo13474e(3, 1, this.vEg);
            AppMethodBeat.m2505o(118269);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vEf != null) {
                ix += C6091a.m9575f(2, this.vEf);
            }
            int c = ix + C6087a.m9552c(3, 1, this.vEg);
            AppMethodBeat.m2505o(118269);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEg.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vEf == null) {
                c6092b = new C6092b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.m2505o(118269);
                throw c6092b;
            }
            AppMethodBeat.m2505o(118269);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35960vh c35960vh = (C35960vh) objArr[1];
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
                        c35960vh.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(118269);
                    return 0;
                case 2:
                    c35960vh.vEf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(118269);
                    return 0;
                case 3:
                    c35960vh.vEg.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(118269);
                    return 0;
                default:
                    AppMethodBeat.m2505o(118269);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(118269);
            return -1;
        }
    }
}
