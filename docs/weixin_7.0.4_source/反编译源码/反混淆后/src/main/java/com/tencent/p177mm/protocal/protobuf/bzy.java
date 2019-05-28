package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bzy */
public final class bzy extends C1331a {
    public int type;
    public String vJS;
    public cgv wHp;
    public bto wYU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48963);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wHp != null) {
                c6093a.mo13479iy(1, this.wHp.computeSize());
                this.wHp.writeFields(c6093a);
            }
            if (this.wYU != null) {
                c6093a.mo13479iy(2, this.wYU.computeSize());
                this.wYU.writeFields(c6093a);
            }
            c6093a.mo13480iz(3, this.type);
            if (this.vJS != null) {
                c6093a.mo13475e(4, this.vJS);
            }
            AppMethodBeat.m2505o(48963);
            return 0;
        } else if (i == 1) {
            if (this.wHp != null) {
                ix = C6087a.m9557ix(1, this.wHp.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wYU != null) {
                ix += C6087a.m9557ix(2, this.wYU.computeSize());
            }
            ix += C6091a.m9572bs(3, this.type);
            if (this.vJS != null) {
                ix += C6091a.m9575f(4, this.vJS);
            }
            AppMethodBeat.m2505o(48963);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48963);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bzy bzy = (bzy) objArr[1];
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
                        cgv cgv = new cgv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(c6086a3, cgv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bzy.wHp = cgv;
                    }
                    AppMethodBeat.m2505o(48963);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bto bto = new bto();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bto.populateBuilderWithField(c6086a3, bto, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bzy.wYU = bto;
                    }
                    AppMethodBeat.m2505o(48963);
                    return 0;
                case 3:
                    bzy.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48963);
                    return 0;
                case 4:
                    bzy.vJS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48963);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48963);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48963);
            return -1;
        }
    }
}
