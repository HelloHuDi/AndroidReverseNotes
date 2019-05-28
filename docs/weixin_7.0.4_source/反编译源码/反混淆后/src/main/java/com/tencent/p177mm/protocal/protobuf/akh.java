package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.akh */
public final class akh extends bsr {
    public int Scene;
    public int vIJ;
    public axx wcn;
    public String wkD;
    public SKBuiltinBuffer_t wpP;
    public int wpQ;
    public int wpR;
    public LinkedList<bkh> wpS = new LinkedList();
    public int wpT;

    public akh() {
        AppMethodBeat.m2504i(28445);
        AppMethodBeat.m2505o(28445);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28446);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcn == null) {
                c6092b = new C6092b("Not all required fields were included: Loc");
                AppMethodBeat.m2505o(28446);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.vIJ);
            c6093a.mo13480iz(3, this.Scene);
            if (this.wpP != null) {
                c6093a.mo13479iy(4, this.wpP.computeSize());
                this.wpP.writeFields(c6093a);
            }
            if (this.wcn != null) {
                c6093a.mo13479iy(5, this.wcn.computeSize());
                this.wcn.writeFields(c6093a);
            }
            if (this.wkD != null) {
                c6093a.mo13475e(6, this.wkD);
            }
            c6093a.mo13480iz(7, this.wpQ);
            c6093a.mo13480iz(8, this.wpR);
            c6093a.mo13474e(11, 8, this.wpS);
            c6093a.mo13480iz(12, this.wpT);
            AppMethodBeat.m2505o(28446);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + C6091a.m9572bs(2, this.vIJ)) + C6091a.m9572bs(3, this.Scene);
            if (this.wpP != null) {
                ix += C6087a.m9557ix(4, this.wpP.computeSize());
            }
            if (this.wcn != null) {
                ix += C6087a.m9557ix(5, this.wcn.computeSize());
            }
            if (this.wkD != null) {
                ix += C6091a.m9575f(6, this.wkD);
            }
            int bs = (((ix + C6091a.m9572bs(7, this.wpQ)) + C6091a.m9572bs(8, this.wpR)) + C6087a.m9552c(11, 8, this.wpS)) + C6091a.m9572bs(12, this.wpT);
            AppMethodBeat.m2505o(28446);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpS.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wcn == null) {
                c6092b = new C6092b("Not all required fields were included: Loc");
                AppMethodBeat.m2505o(28446);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28446);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            akh akh = (akh) objArr[1];
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
                        akh.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28446);
                    return 0;
                case 2:
                    akh.vIJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28446);
                    return 0;
                case 3:
                    akh.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28446);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        akh.wpP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28446);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axx axx = new axx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axx.populateBuilderWithField(c6086a3, axx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        akh.wcn = axx;
                    }
                    AppMethodBeat.m2505o(28446);
                    return 0;
                case 6:
                    akh.wkD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28446);
                    return 0;
                case 7:
                    akh.wpQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28446);
                    return 0;
                case 8:
                    akh.wpR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28446);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkh bkh = new bkh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkh.populateBuilderWithField(c6086a3, bkh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        akh.wpS.add(bkh);
                    }
                    AppMethodBeat.m2505o(28446);
                    return 0;
                case 12:
                    akh.wpT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28446);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28446);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28446);
            return -1;
        }
    }
}
