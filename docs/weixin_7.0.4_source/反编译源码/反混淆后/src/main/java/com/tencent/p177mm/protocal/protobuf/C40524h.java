package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.h */
public final class C40524h extends bsr {
    public int scene;
    public String title;
    public String vzM;
    public LinkedList<C40532j> vzQ = new LinkedList();
    public C15319aw vzR;
    public long vzS;
    public long vzU;

    public C40524h() {
        AppMethodBeat.m2504i(56675);
        AppMethodBeat.m2505o(56675);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56676);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.title != null) {
                c6093a.mo13475e(2, this.title);
            }
            c6093a.mo13472ai(3, this.vzU);
            c6093a.mo13474e(5, 8, this.vzQ);
            c6093a.mo13480iz(7, this.scene);
            if (this.vzM != null) {
                c6093a.mo13475e(8, this.vzM);
            }
            if (this.vzR != null) {
                c6093a.mo13479iy(9, this.vzR.computeSize());
                this.vzR.writeFields(c6093a);
            }
            c6093a.mo13472ai(10, this.vzS);
            AppMethodBeat.m2505o(56676);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.title != null) {
                ix += C6091a.m9575f(2, this.title);
            }
            ix = ((ix + C6091a.m9578o(3, this.vzU)) + C6087a.m9552c(5, 8, this.vzQ)) + C6091a.m9572bs(7, this.scene);
            if (this.vzM != null) {
                ix += C6091a.m9575f(8, this.vzM);
            }
            if (this.vzR != null) {
                ix += C6087a.m9557ix(9, this.vzR.computeSize());
            }
            int o = ix + C6091a.m9578o(10, this.vzS);
            AppMethodBeat.m2505o(56676);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzQ.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56676);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40524h c40524h = (C40524h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        c40524h.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56676);
                    return 0;
                case 2:
                    c40524h.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56676);
                    return 0;
                case 3:
                    c40524h.vzU = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56676);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40532j c40532j = new C40532j();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40532j.populateBuilderWithField(c6086a3, c40532j, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40524h.vzQ.add(c40532j);
                    }
                    AppMethodBeat.m2505o(56676);
                    return 0;
                case 7:
                    c40524h.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56676);
                    return 0;
                case 8:
                    c40524h.vzM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56676);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15319aw c15319aw = new C15319aw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15319aw.populateBuilderWithField(c6086a3, c15319aw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40524h.vzR = c15319aw;
                    }
                    AppMethodBeat.m2505o(56676);
                    return 0;
                case 10:
                    c40524h.vzS = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56676);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56676);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56676);
            return -1;
        }
    }
}
