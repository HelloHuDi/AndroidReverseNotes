package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ajv */
public final class ajv extends bsr {
    public String mvO;
    public String mvP;
    public String mvQ;
    public String vAN;
    public C23460xa vBe;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28439);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.mvO != null) {
                c6093a.mo13475e(2, this.mvO);
            }
            if (this.mvP != null) {
                c6093a.mo13475e(3, this.mvP);
            }
            if (this.mvQ != null) {
                c6093a.mo13475e(4, this.mvQ);
            }
            if (this.vAN != null) {
                c6093a.mo13475e(5, this.vAN);
            }
            if (this.vBe != null) {
                c6093a.mo13479iy(6, this.vBe.computeSize());
                this.vBe.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(28439);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mvO != null) {
                ix += C6091a.m9575f(2, this.mvO);
            }
            if (this.mvP != null) {
                ix += C6091a.m9575f(3, this.mvP);
            }
            if (this.mvQ != null) {
                ix += C6091a.m9575f(4, this.mvQ);
            }
            if (this.vAN != null) {
                ix += C6091a.m9575f(5, this.vAN);
            }
            if (this.vBe != null) {
                ix += C6087a.m9557ix(6, this.vBe.computeSize());
            }
            AppMethodBeat.m2505o(28439);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28439);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ajv ajv = (ajv) objArr[1];
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
                        ajv.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28439);
                    return 0;
                case 2:
                    ajv.mvO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28439);
                    return 0;
                case 3:
                    ajv.mvP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28439);
                    return 0;
                case 4:
                    ajv.mvQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28439);
                    return 0;
                case 5:
                    ajv.vAN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28439);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23460xa c23460xa = new C23460xa();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23460xa.populateBuilderWithField(c6086a3, c23460xa, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ajv.vBe = c23460xa;
                    }
                    AppMethodBeat.m2505o(28439);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28439);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28439);
            return -1;
        }
    }
}
