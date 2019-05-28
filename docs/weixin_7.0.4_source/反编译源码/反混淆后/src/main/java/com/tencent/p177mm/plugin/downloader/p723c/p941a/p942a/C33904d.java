package com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.downloader.p723c.p724b.C20312j;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.a.a.d */
public final class C33904d extends C1331a {
    public C20312j kKr;
    public C20308e kKs;
    public C20307c kKt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35511);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kKr == null) {
                c6092b = new C6092b("Not all required fields were included: app_info");
                AppMethodBeat.m2505o(35511);
                throw c6092b;
            }
            if (this.kKr != null) {
                c6093a.mo13479iy(1, this.kKr.computeSize());
                this.kKr.writeFields(c6093a);
            }
            if (this.kKs != null) {
                c6093a.mo13479iy(2, this.kKs.computeSize());
                this.kKs.writeFields(c6093a);
            }
            if (this.kKt != null) {
                c6093a.mo13479iy(3, this.kKt.computeSize());
                this.kKt.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(35511);
            return 0;
        } else if (i == 1) {
            if (this.kKr != null) {
                ix = C6087a.m9557ix(1, this.kKr.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kKs != null) {
                ix += C6087a.m9557ix(2, this.kKs.computeSize());
            }
            if (this.kKt != null) {
                ix += C6087a.m9557ix(3, this.kKt.computeSize());
            }
            AppMethodBeat.m2505o(35511);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.kKr == null) {
                c6092b = new C6092b("Not all required fields were included: app_info");
                AppMethodBeat.m2505o(35511);
                throw c6092b;
            }
            AppMethodBeat.m2505o(35511);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C33904d c33904d = (C33904d) objArr[1];
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
                        C20312j c20312j = new C20312j();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20312j.populateBuilderWithField(c6086a3, c20312j, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c33904d.kKr = c20312j;
                    }
                    AppMethodBeat.m2505o(35511);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20308e c20308e = new C20308e();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20308e.populateBuilderWithField(c6086a3, c20308e, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c33904d.kKs = c20308e;
                    }
                    AppMethodBeat.m2505o(35511);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C20307c c20307c = new C20307c();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c20307c.populateBuilderWithField(c6086a3, c20307c, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c33904d.kKt = c20307c;
                    }
                    AppMethodBeat.m2505o(35511);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35511);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35511);
            return -1;
        }
    }
}
