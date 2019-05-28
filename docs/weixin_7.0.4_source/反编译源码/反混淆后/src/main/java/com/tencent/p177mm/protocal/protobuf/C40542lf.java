package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.lf */
public final class C40542lf extends bsr {
    public int vAM;
    public String vAN;
    public String vMR;
    public ayu vOK;
    public buc vOL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28345);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.vMR != null) {
                c6093a.mo13475e(2, this.vMR);
            }
            if (this.vOK != null) {
                c6093a.mo13479iy(3, this.vOK.computeSize());
                this.vOK.writeFields(c6093a);
            }
            if (this.vOL != null) {
                c6093a.mo13479iy(4, this.vOL.computeSize());
                this.vOL.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.vAM);
            if (this.vAN != null) {
                c6093a.mo13475e(6, this.vAN);
            }
            AppMethodBeat.m2505o(28345);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vMR != null) {
                ix += C6091a.m9575f(2, this.vMR);
            }
            if (this.vOK != null) {
                ix += C6087a.m9557ix(3, this.vOK.computeSize());
            }
            if (this.vOL != null) {
                ix += C6087a.m9557ix(4, this.vOL.computeSize());
            }
            ix += C6091a.m9572bs(5, this.vAM);
            if (this.vAN != null) {
                ix += C6091a.m9575f(6, this.vAN);
            }
            AppMethodBeat.m2505o(28345);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(28345);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40542lf c40542lf = (C40542lf) objArr[1];
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
                        c40542lf.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28345);
                    return 0;
                case 2:
                    c40542lf.vMR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28345);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayu ayu = new ayu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayu.populateBuilderWithField(c6086a3, ayu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40542lf.vOK = ayu;
                    }
                    AppMethodBeat.m2505o(28345);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buc buc = new buc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = buc.populateBuilderWithField(c6086a3, buc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c40542lf.vOL = buc;
                    }
                    AppMethodBeat.m2505o(28345);
                    return 0;
                case 5:
                    c40542lf.vAM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28345);
                    return 0;
                case 6:
                    c40542lf.vAN = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28345);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28345);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28345);
            return -1;
        }
    }
}
