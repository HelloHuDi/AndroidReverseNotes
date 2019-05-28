package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.f */
public final class C30181f extends bsr {
    public int scene;
    public String title;
    public String vzM;
    public int vzO;
    public long vzP;
    public LinkedList<String> vzQ = new LinkedList();
    public C15319aw vzR;
    public long vzS;

    public C30181f() {
        AppMethodBeat.m2504i(56672);
        AppMethodBeat.m2505o(56672);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56673);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vzO);
            c6093a.mo13472ai(3, this.vzP);
            if (this.title != null) {
                c6093a.mo13475e(4, this.title);
            }
            c6093a.mo13474e(5, 1, this.vzQ);
            c6093a.mo13480iz(6, this.scene);
            if (this.vzM != null) {
                c6093a.mo13475e(7, this.vzM);
            }
            if (this.vzR != null) {
                c6093a.mo13479iy(8, this.vzR.computeSize());
                this.vzR.writeFields(c6093a);
            }
            c6093a.mo13472ai(9, this.vzS);
            AppMethodBeat.m2505o(56673);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.vzO)) + C6091a.m9578o(3, this.vzP);
            if (this.title != null) {
                ix += C6091a.m9575f(4, this.title);
            }
            ix = (ix + C6087a.m9552c(5, 1, this.vzQ)) + C6091a.m9572bs(6, this.scene);
            if (this.vzM != null) {
                ix += C6091a.m9575f(7, this.vzM);
            }
            if (this.vzR != null) {
                ix += C6087a.m9557ix(8, this.vzR.computeSize());
            }
            int o = ix + C6091a.m9578o(9, this.vzS);
            AppMethodBeat.m2505o(56673);
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
            AppMethodBeat.m2505o(56673);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30181f c30181f = (C30181f) objArr[1];
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
                        c30181f.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56673);
                    return 0;
                case 2:
                    c30181f.vzO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56673);
                    return 0;
                case 3:
                    c30181f.vzP = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56673);
                    return 0;
                case 4:
                    c30181f.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56673);
                    return 0;
                case 5:
                    c30181f.vzQ.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(56673);
                    return 0;
                case 6:
                    c30181f.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56673);
                    return 0;
                case 7:
                    c30181f.vzM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56673);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C15319aw c15319aw = new C15319aw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c15319aw.populateBuilderWithField(c6086a3, c15319aw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30181f.vzR = c15319aw;
                    }
                    AppMethodBeat.m2505o(56673);
                    return 0;
                case 9:
                    c30181f.vzS = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56673);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56673);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56673);
            return -1;
        }
    }
}
