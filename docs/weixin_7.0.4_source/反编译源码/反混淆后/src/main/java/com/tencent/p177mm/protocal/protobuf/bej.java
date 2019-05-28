package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bej */
public final class bej extends C1331a {
    public int Scene;
    public String vIk;
    public int vTN;
    public SKBuiltinBuffer_t vTO;
    public C35956tc wIw;
    public int wIx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58922);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wIw == null) {
                c6092b = new C6092b("Not all required fields were included: Oplog");
                AppMethodBeat.m2505o(58922);
                throw c6092b;
            } else if (this.vTO == null) {
                c6092b = new C6092b("Not all required fields were included: KeyBuf");
                AppMethodBeat.m2505o(58922);
                throw c6092b;
            } else {
                if (this.wIw != null) {
                    c6093a.mo13479iy(1, this.wIw.computeSize());
                    this.wIw.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.vTN);
                if (this.vTO != null) {
                    c6093a.mo13479iy(3, this.vTO.computeSize());
                    this.vTO.writeFields(c6093a);
                }
                c6093a.mo13480iz(4, this.Scene);
                if (this.vIk != null) {
                    c6093a.mo13475e(5, this.vIk);
                }
                c6093a.mo13480iz(6, this.wIx);
                AppMethodBeat.m2505o(58922);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIw != null) {
                ix = C6087a.m9557ix(1, this.wIw.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6091a.m9572bs(2, this.vTN);
            if (this.vTO != null) {
                ix += C6087a.m9557ix(3, this.vTO.computeSize());
            }
            ix += C6091a.m9572bs(4, this.Scene);
            if (this.vIk != null) {
                ix += C6091a.m9575f(5, this.vIk);
            }
            int bs = ix + C6091a.m9572bs(6, this.wIx);
            AppMethodBeat.m2505o(58922);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wIw == null) {
                c6092b = new C6092b("Not all required fields were included: Oplog");
                AppMethodBeat.m2505o(58922);
                throw c6092b;
            } else if (this.vTO == null) {
                c6092b = new C6092b("Not all required fields were included: KeyBuf");
                AppMethodBeat.m2505o(58922);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(58922);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bej bej = (bej) objArr[1];
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
                        C35956tc c35956tc = new C35956tc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c35956tc.populateBuilderWithField(c6086a3, c35956tc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bej.wIw = c35956tc;
                    }
                    AppMethodBeat.m2505o(58922);
                    return 0;
                case 2:
                    bej.vTN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58922);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bej.vTO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58922);
                    return 0;
                case 4:
                    bej.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58922);
                    return 0;
                case 5:
                    bej.vIk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58922);
                    return 0;
                case 6:
                    bej.wIx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58922);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58922);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58922);
            return -1;
        }
    }
}
