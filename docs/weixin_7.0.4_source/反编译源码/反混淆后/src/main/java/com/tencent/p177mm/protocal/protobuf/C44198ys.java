package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ys */
public final class C44198ys extends bsr {
    public String fKh;
    public int pXD;
    public C15319aw vRP;
    public String wes;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56773);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.wes != null) {
                c6093a.mo13475e(2, this.wes);
            }
            if (this.fKh != null) {
                c6093a.mo13475e(3, this.fKh);
            }
            c6093a.mo13480iz(4, this.pXD);
            if (this.vRP != null) {
                c6093a.mo13479iy(5, this.vRP.computeSize());
                this.vRP.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(56773);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wes != null) {
                ix += C6091a.m9575f(2, this.wes);
            }
            if (this.fKh != null) {
                ix += C6091a.m9575f(3, this.fKh);
            }
            ix += C6091a.m9572bs(4, this.pXD);
            if (this.vRP != null) {
                ix += C6087a.m9557ix(5, this.vRP.computeSize());
            }
            AppMethodBeat.m2505o(56773);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56773);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44198ys c44198ys = (C44198ys) objArr[1];
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
                        c44198ys.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56773);
                    return 0;
                case 2:
                    c44198ys.wes = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56773);
                    return 0;
                case 3:
                    c44198ys.fKh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56773);
                    return 0;
                case 4:
                    c44198ys.pXD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56773);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15319aw c15319aw = new C15319aw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15319aw.populateBuilderWithField(c6086a3, c15319aw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44198ys.vRP = c15319aw;
                    }
                    AppMethodBeat.m2505o(56773);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56773);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56773);
            return -1;
        }
    }
}
