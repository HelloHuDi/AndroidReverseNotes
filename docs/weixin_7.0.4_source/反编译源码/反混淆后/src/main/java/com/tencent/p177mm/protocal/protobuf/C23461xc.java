package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.xc */
public final class C23461xc extends C1331a {
    public String title;
    public int type;
    public btr vCP;
    public C46586ta vQL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48839);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.type);
            if (this.title != null) {
                c6093a.mo13475e(2, this.title);
            }
            if (this.vCP != null) {
                c6093a.mo13479iy(3, this.vCP.computeSize());
                this.vCP.writeFields(c6093a);
            }
            if (this.vQL != null) {
                c6093a.mo13479iy(4, this.vQL.computeSize());
                this.vQL.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48839);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.type) + 0;
            if (this.title != null) {
                bs += C6091a.m9575f(2, this.title);
            }
            if (this.vCP != null) {
                bs += C6087a.m9557ix(3, this.vCP.computeSize());
            }
            if (this.vQL != null) {
                bs += C6087a.m9557ix(4, this.vQL.computeSize());
            }
            AppMethodBeat.m2505o(48839);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48839);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23461xc c23461xc = (C23461xc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c23461xc.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48839);
                    return 0;
                case 2:
                    c23461xc.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48839);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(c6086a3, btr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23461xc.vCP = btr;
                    }
                    AppMethodBeat.m2505o(48839);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C46586ta c46586ta = new C46586ta();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46586ta.populateBuilderWithField(c6086a3, c46586ta, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c23461xc.vQL = c46586ta;
                    }
                    AppMethodBeat.m2505o(48839);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48839);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48839);
            return -1;
        }
    }
}
