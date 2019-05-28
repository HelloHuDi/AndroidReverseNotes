package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.crs */
public final class crs extends C1331a {
    public SKBuiltinBuffer_t xpk;
    public SKBuiltinBuffer_t xpl;
    public SKBuiltinBuffer_t xpm;
    public SKBuiltinBuffer_t xpn;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(123522);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xpk != null) {
                c6093a.mo13479iy(1, this.xpk.computeSize());
                this.xpk.writeFields(c6093a);
            }
            if (this.xpl != null) {
                c6093a.mo13479iy(2, this.xpl.computeSize());
                this.xpl.writeFields(c6093a);
            }
            if (this.xpm != null) {
                c6093a.mo13479iy(3, this.xpm.computeSize());
                this.xpm.writeFields(c6093a);
            }
            if (this.xpn != null) {
                c6093a.mo13479iy(4, this.xpn.computeSize());
                this.xpn.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(123522);
            return 0;
        } else if (i == 1) {
            if (this.xpk != null) {
                ix = C6087a.m9557ix(1, this.xpk.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xpl != null) {
                ix += C6087a.m9557ix(2, this.xpl.computeSize());
            }
            if (this.xpm != null) {
                ix += C6087a.m9557ix(3, this.xpm.computeSize());
            }
            if (this.xpn != null) {
                ix += C6087a.m9557ix(4, this.xpn.computeSize());
            }
            AppMethodBeat.m2505o(123522);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(123522);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            crs crs = (crs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        crs.xpk = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(123522);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        crs.xpl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(123522);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        crs.xpm = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(123522);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        crs.xpn = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(123522);
                    return 0;
                default:
                    AppMethodBeat.m2505o(123522);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(123522);
            return -1;
        }
    }
}
