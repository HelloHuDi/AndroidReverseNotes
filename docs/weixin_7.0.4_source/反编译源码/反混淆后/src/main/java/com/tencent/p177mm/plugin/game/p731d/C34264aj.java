package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.aj */
public final class C34264aj extends C1331a {
    public C34271cb naR;
    public C34271cb naS;
    public C34271cb naT;
    public C39194cz naU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111576);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.naR != null) {
                c6093a.mo13479iy(1, this.naR.computeSize());
                this.naR.writeFields(c6093a);
            }
            if (this.naS != null) {
                c6093a.mo13479iy(2, this.naS.computeSize());
                this.naS.writeFields(c6093a);
            }
            if (this.naT != null) {
                c6093a.mo13479iy(3, this.naT.computeSize());
                this.naT.writeFields(c6093a);
            }
            if (this.naU != null) {
                c6093a.mo13479iy(4, this.naU.computeSize());
                this.naU.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(111576);
            return 0;
        } else if (i == 1) {
            if (this.naR != null) {
                ix = C6087a.m9557ix(1, this.naR.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.naS != null) {
                ix += C6087a.m9557ix(2, this.naS.computeSize());
            }
            if (this.naT != null) {
                ix += C6087a.m9557ix(3, this.naT.computeSize());
            }
            if (this.naU != null) {
                ix += C6087a.m9557ix(4, this.naU.computeSize());
            }
            AppMethodBeat.m2505o(111576);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111576);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C34264aj c34264aj = (C34264aj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C34271cb c34271cb;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c34271cb = new C34271cb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c34271cb.populateBuilderWithField(c6086a3, c34271cb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34264aj.naR = c34271cb;
                    }
                    AppMethodBeat.m2505o(111576);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c34271cb = new C34271cb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c34271cb.populateBuilderWithField(c6086a3, c34271cb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34264aj.naS = c34271cb;
                    }
                    AppMethodBeat.m2505o(111576);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c34271cb = new C34271cb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c34271cb.populateBuilderWithField(c6086a3, c34271cb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34264aj.naT = c34271cb;
                    }
                    AppMethodBeat.m2505o(111576);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C39194cz c39194cz = new C39194cz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c39194cz.populateBuilderWithField(c6086a3, c39194cz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c34264aj.naU = c39194cz;
                    }
                    AppMethodBeat.m2505o(111576);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111576);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111576);
            return -1;
        }
    }
}
