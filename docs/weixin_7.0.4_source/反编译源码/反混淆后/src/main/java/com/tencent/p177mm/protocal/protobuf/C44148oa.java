package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.oa */
public final class C44148oa extends C1331a {
    public int vTs;
    public String vTt;
    public String vTu;
    public String vTv;
    public int vTw;
    public String vTx;
    public C30208ny vTy;
    public String vTz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89037);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vTs);
            if (this.vTt != null) {
                c6093a.mo13475e(2, this.vTt);
            }
            if (this.vTu != null) {
                c6093a.mo13475e(3, this.vTu);
            }
            if (this.vTv != null) {
                c6093a.mo13475e(4, this.vTv);
            }
            c6093a.mo13480iz(5, this.vTw);
            if (this.vTx != null) {
                c6093a.mo13475e(6, this.vTx);
            }
            if (this.vTy != null) {
                c6093a.mo13479iy(7, this.vTy.computeSize());
                this.vTy.writeFields(c6093a);
            }
            if (this.vTz != null) {
                c6093a.mo13475e(8, this.vTz);
            }
            AppMethodBeat.m2505o(89037);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.vTs) + 0;
            if (this.vTt != null) {
                bs += C6091a.m9575f(2, this.vTt);
            }
            if (this.vTu != null) {
                bs += C6091a.m9575f(3, this.vTu);
            }
            if (this.vTv != null) {
                bs += C6091a.m9575f(4, this.vTv);
            }
            bs += C6091a.m9572bs(5, this.vTw);
            if (this.vTx != null) {
                bs += C6091a.m9575f(6, this.vTx);
            }
            if (this.vTy != null) {
                bs += C6087a.m9557ix(7, this.vTy.computeSize());
            }
            if (this.vTz != null) {
                bs += C6091a.m9575f(8, this.vTz);
            }
            AppMethodBeat.m2505o(89037);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89037);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44148oa c44148oa = (C44148oa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c44148oa.vTs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89037);
                    return 0;
                case 2:
                    c44148oa.vTt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89037);
                    return 0;
                case 3:
                    c44148oa.vTu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89037);
                    return 0;
                case 4:
                    c44148oa.vTv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89037);
                    return 0;
                case 5:
                    c44148oa.vTw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89037);
                    return 0;
                case 6:
                    c44148oa.vTx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89037);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C30208ny c30208ny = new C30208ny();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c30208ny.populateBuilderWithField(c6086a3, c30208ny, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44148oa.vTy = c30208ny;
                    }
                    AppMethodBeat.m2505o(89037);
                    return 0;
                case 8:
                    c44148oa.vTz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89037);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89037);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89037);
            return -1;
        }
    }
}
