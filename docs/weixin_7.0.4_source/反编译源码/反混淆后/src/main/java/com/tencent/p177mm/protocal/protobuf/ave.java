package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ave */
public final class ave extends C1331a {
    public String vJS;
    public cgv wza;
    public LinkedList<cgd> wzb = new LinkedList();
    public cgv wzc;

    public ave() {
        AppMethodBeat.m2504i(48879);
        AppMethodBeat.m2505o(48879);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48880);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wza != null) {
                c6093a.mo13479iy(1, this.wza.computeSize());
                this.wza.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.wzb);
            if (this.wzc != null) {
                c6093a.mo13479iy(3, this.wzc.computeSize());
                this.wzc.writeFields(c6093a);
            }
            if (this.vJS != null) {
                c6093a.mo13475e(4, this.vJS);
            }
            AppMethodBeat.m2505o(48880);
            return 0;
        } else if (i == 1) {
            if (this.wza != null) {
                ix = C6087a.m9557ix(1, this.wza.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.wzb);
            if (this.wzc != null) {
                ix += C6087a.m9557ix(3, this.wzc.computeSize());
            }
            if (this.vJS != null) {
                ix += C6091a.m9575f(4, this.vJS);
            }
            AppMethodBeat.m2505o(48880);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzb.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48880);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ave ave = (ave) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cgv cgv;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ave.wza = cgv;
                    }
                    AppMethodBeat.m2505o(48880);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgd cgd = new cgd();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgd.populateBuilderWithField(c6086a3, cgd, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ave.wzb.add(cgd);
                    }
                    AppMethodBeat.m2505o(48880);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        ave.wzc = cgv;
                    }
                    AppMethodBeat.m2505o(48880);
                    return 0;
                case 4:
                    ave.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48880);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48880);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48880);
            return -1;
        }
    }
}
