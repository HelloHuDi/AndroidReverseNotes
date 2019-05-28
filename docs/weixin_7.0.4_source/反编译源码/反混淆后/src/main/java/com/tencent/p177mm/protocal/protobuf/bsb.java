package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bsb */
public final class bsb extends bsr {
    public LinkedList<String> EmotionList = new LinkedList();
    public int jCt;
    public brw wUe;
    public bsl wUf;
    public String wdK;

    public bsb() {
        AppMethodBeat.m2504i(65417);
        AppMethodBeat.m2505o(65417);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(65418);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            c6093a.mo13480iz(2, this.jCt);
            if (this.wUe != null) {
                c6093a.mo13479iy(3, this.wUe.computeSize());
                this.wUe.writeFields(c6093a);
            }
            if (this.wUf != null) {
                c6093a.mo13479iy(4, this.wUf.computeSize());
                this.wUf.writeFields(c6093a);
            }
            if (this.wdK != null) {
                c6093a.mo13475e(5, this.wdK);
            }
            c6093a.mo13474e(6, 1, this.EmotionList);
            AppMethodBeat.m2505o(65418);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.jCt);
            if (this.wUe != null) {
                ix += C6087a.m9557ix(3, this.wUe.computeSize());
            }
            if (this.wUf != null) {
                ix += C6087a.m9557ix(4, this.wUf.computeSize());
            }
            if (this.wdK != null) {
                ix += C6091a.m9575f(5, this.wdK);
            }
            int c = ix + C6087a.m9552c(6, 1, this.EmotionList);
            AppMethodBeat.m2505o(65418);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.EmotionList.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(65418);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bsb bsb = (bsb) objArr[1];
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
                        bsb.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(65418);
                    return 0;
                case 2:
                    bsb.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(65418);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        brw brw = new brw();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = brw.populateBuilderWithField(c6086a3, brw, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bsb.wUe = brw;
                    }
                    AppMethodBeat.m2505o(65418);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bsl bsl = new bsl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsl.populateBuilderWithField(c6086a3, bsl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bsb.wUf = bsl;
                    }
                    AppMethodBeat.m2505o(65418);
                    return 0;
                case 5:
                    bsb.wdK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(65418);
                    return 0;
                case 6:
                    bsb.EmotionList.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(65418);
                    return 0;
                default:
                    AppMethodBeat.m2505o(65418);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(65418);
            return -1;
        }
    }
}
