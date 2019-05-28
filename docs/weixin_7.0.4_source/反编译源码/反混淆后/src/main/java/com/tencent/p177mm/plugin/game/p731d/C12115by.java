package com.tencent.p177mm.plugin.game.p731d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.game.d.by */
public final class C12115by extends C1331a {
    public C28193dg ncJ;
    public C43168co ncK;
    public C43173u ncL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111632);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ncJ != null) {
                c6093a.mo13479iy(1, this.ncJ.computeSize());
                this.ncJ.writeFields(c6093a);
            }
            if (this.ncK != null) {
                c6093a.mo13479iy(2, this.ncK.computeSize());
                this.ncK.writeFields(c6093a);
            }
            if (this.ncL != null) {
                c6093a.mo13479iy(3, this.ncL.computeSize());
                this.ncL.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(111632);
            return 0;
        } else if (i == 1) {
            if (this.ncJ != null) {
                ix = C6087a.m9557ix(1, this.ncJ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncK != null) {
                ix += C6087a.m9557ix(2, this.ncK.computeSize());
            }
            if (this.ncL != null) {
                ix += C6087a.m9557ix(3, this.ncL.computeSize());
            }
            AppMethodBeat.m2505o(111632);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111632);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C12115by c12115by = (C12115by) objArr[1];
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
                        C28193dg c28193dg = new C28193dg();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c28193dg.populateBuilderWithField(c6086a3, c28193dg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12115by.ncJ = c28193dg;
                    }
                    AppMethodBeat.m2505o(111632);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43168co c43168co = new C43168co();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43168co.populateBuilderWithField(c6086a3, c43168co, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12115by.ncK = c43168co;
                    }
                    AppMethodBeat.m2505o(111632);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C43173u c43173u = new C43173u();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c43173u.populateBuilderWithField(c6086a3, c43173u, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c12115by.ncL = c43173u;
                    }
                    AppMethodBeat.m2505o(111632);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111632);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111632);
            return -1;
        }
    }
}
