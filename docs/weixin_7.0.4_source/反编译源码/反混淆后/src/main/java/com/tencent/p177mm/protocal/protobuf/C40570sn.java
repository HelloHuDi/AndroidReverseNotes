package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.sn */
public final class C40570sn extends bsr {
    public int scene;
    public String vEG;
    public String vMR;
    public int vZW;
    public String vZX;
    public LinkedList<C44168sm> vZY = new LinkedList();
    public int vZZ;
    public bxk waa;
    public byj wab;

    public C40570sn() {
        AppMethodBeat.m2504i(11737);
        AppMethodBeat.m2505o(11737);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11738);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vZW);
            if (this.vZX != null) {
                c6093a.mo13475e(3, this.vZX);
            }
            if (this.vMR != null) {
                c6093a.mo13475e(4, this.vMR);
            }
            if (this.vEG != null) {
                c6093a.mo13475e(5, this.vEG);
            }
            c6093a.mo13474e(6, 8, this.vZY);
            c6093a.mo13480iz(7, this.scene);
            c6093a.mo13480iz(8, this.vZZ);
            if (this.waa != null) {
                c6093a.mo13479iy(9, this.waa.computeSize());
                this.waa.writeFields(c6093a);
            }
            if (this.wab != null) {
                c6093a.mo13479iy(10, this.wab.computeSize());
                this.wab.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(11738);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.vZW);
            if (this.vZX != null) {
                ix += C6091a.m9575f(3, this.vZX);
            }
            if (this.vMR != null) {
                ix += C6091a.m9575f(4, this.vMR);
            }
            if (this.vEG != null) {
                ix += C6091a.m9575f(5, this.vEG);
            }
            ix = ((ix + C6087a.m9552c(6, 8, this.vZY)) + C6091a.m9572bs(7, this.scene)) + C6091a.m9572bs(8, this.vZZ);
            if (this.waa != null) {
                ix += C6087a.m9557ix(9, this.waa.computeSize());
            }
            if (this.wab != null) {
                ix += C6087a.m9557ix(10, this.wab.computeSize());
            }
            AppMethodBeat.m2505o(11738);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vZY.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11738);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40570sn c40570sn = (C40570sn) objArr[1];
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
                        c40570sn.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(11738);
                    return 0;
                case 2:
                    c40570sn.vZW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11738);
                    return 0;
                case 3:
                    c40570sn.vZX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11738);
                    return 0;
                case 4:
                    c40570sn.vMR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11738);
                    return 0;
                case 5:
                    c40570sn.vEG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11738);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C44168sm c44168sm = new C44168sm();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c44168sm.populateBuilderWithField(c6086a3, c44168sm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40570sn.vZY.add(c44168sm);
                    }
                    AppMethodBeat.m2505o(11738);
                    return 0;
                case 7:
                    c40570sn.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11738);
                    return 0;
                case 8:
                    c40570sn.vZZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11738);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bxk bxk = new bxk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxk.populateBuilderWithField(c6086a3, bxk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40570sn.waa = bxk;
                    }
                    AppMethodBeat.m2505o(11738);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        byj byj = new byj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = byj.populateBuilderWithField(c6086a3, byj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40570sn.wab = byj;
                    }
                    AppMethodBeat.m2505o(11738);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11738);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11738);
            return -1;
        }
    }
}
