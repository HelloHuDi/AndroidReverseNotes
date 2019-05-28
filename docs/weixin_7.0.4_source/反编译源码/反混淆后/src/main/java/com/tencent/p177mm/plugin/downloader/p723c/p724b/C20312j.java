package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.j */
public final class C20312j extends C1331a {
    public C20310a kLA;
    public C11504c kLw;
    public C20311d kLx;
    public C38845f kLy;
    public C27706k kLz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35536);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kLw == null) {
                c6092b = new C6092b("Not all required fields were included: base_info");
                AppMethodBeat.m2505o(35536);
                throw c6092b;
            }
            if (this.kLw != null) {
                c6093a.mo13479iy(1, this.kLw.computeSize());
                this.kLw.writeFields(c6093a);
            }
            if (this.kLx != null) {
                c6093a.mo13479iy(2, this.kLx.computeSize());
                this.kLx.writeFields(c6093a);
            }
            if (this.kLy != null) {
                c6093a.mo13479iy(3, this.kLy.computeSize());
                this.kLy.writeFields(c6093a);
            }
            if (this.kLz != null) {
                c6093a.mo13479iy(4, this.kLz.computeSize());
                this.kLz.writeFields(c6093a);
            }
            if (this.kLA != null) {
                c6093a.mo13479iy(5, this.kLA.computeSize());
                this.kLA.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(35536);
            return 0;
        } else if (i == 1) {
            if (this.kLw != null) {
                ix = C6087a.m9557ix(1, this.kLw.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kLx != null) {
                ix += C6087a.m9557ix(2, this.kLx.computeSize());
            }
            if (this.kLy != null) {
                ix += C6087a.m9557ix(3, this.kLy.computeSize());
            }
            if (this.kLz != null) {
                ix += C6087a.m9557ix(4, this.kLz.computeSize());
            }
            if (this.kLA != null) {
                ix += C6087a.m9557ix(5, this.kLA.computeSize());
            }
            AppMethodBeat.m2505o(35536);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.kLw == null) {
                c6092b = new C6092b("Not all required fields were included: base_info");
                AppMethodBeat.m2505o(35536);
                throw c6092b;
            }
            AppMethodBeat.m2505o(35536);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C20312j c20312j = (C20312j) objArr[1];
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
                        C11504c c11504c = new C11504c();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c11504c.populateBuilderWithField(c6086a3, c11504c, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20312j.kLw = c11504c;
                    }
                    AppMethodBeat.m2505o(35536);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20311d c20311d = new C20311d();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20311d.populateBuilderWithField(c6086a3, c20311d, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20312j.kLx = c20311d;
                    }
                    AppMethodBeat.m2505o(35536);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C38845f c38845f = new C38845f();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c38845f.populateBuilderWithField(c6086a3, c38845f, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20312j.kLy = c38845f;
                    }
                    AppMethodBeat.m2505o(35536);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C27706k c27706k = new C27706k();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c27706k.populateBuilderWithField(c6086a3, c27706k, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20312j.kLz = c27706k;
                    }
                    AppMethodBeat.m2505o(35536);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20310a c20310a = new C20310a();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20310a.populateBuilderWithField(c6086a3, c20310a, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c20312j.kLA = c20310a;
                    }
                    AppMethodBeat.m2505o(35536);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35536);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35536);
            return -1;
        }
    }
}
