package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.c */
public final class C11504c extends C1331a {
    public String csB;
    public String kKY;
    public String kKZ;
    public String kLa;
    public int kLb;
    public C42909g kLc;
    public String kLd;
    public int status;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35527);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.csB == null) {
                c6092b = new C6092b("Not all required fields were included: appid");
                AppMethodBeat.m2505o(35527);
                throw c6092b;
            } else if (this.kKY == null) {
                c6092b = new C6092b("Not all required fields were included: app_name");
                AppMethodBeat.m2505o(35527);
                throw c6092b;
            } else {
                if (this.csB != null) {
                    c6093a.mo13475e(1, this.csB);
                }
                if (this.kKY != null) {
                    c6093a.mo13475e(2, this.kKY);
                }
                if (this.kKZ != null) {
                    c6093a.mo13475e(3, this.kKZ);
                }
                if (this.kLa != null) {
                    c6093a.mo13475e(4, this.kLa);
                }
                c6093a.mo13480iz(5, this.kLb);
                c6093a.mo13480iz(6, this.status);
                if (this.kLc != null) {
                    c6093a.mo13479iy(7, this.kLc.computeSize());
                    this.kLc.writeFields(c6093a);
                }
                if (this.kLd != null) {
                    c6093a.mo13475e(8, this.kLd);
                }
                AppMethodBeat.m2505o(35527);
                return 0;
            }
        } else if (i == 1) {
            if (this.csB != null) {
                f = C6091a.m9575f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.kKY != null) {
                f += C6091a.m9575f(2, this.kKY);
            }
            if (this.kKZ != null) {
                f += C6091a.m9575f(3, this.kKZ);
            }
            if (this.kLa != null) {
                f += C6091a.m9575f(4, this.kLa);
            }
            f = (f + C6091a.m9572bs(5, this.kLb)) + C6091a.m9572bs(6, this.status);
            if (this.kLc != null) {
                f += C6087a.m9557ix(7, this.kLc.computeSize());
            }
            if (this.kLd != null) {
                f += C6091a.m9575f(8, this.kLd);
            }
            AppMethodBeat.m2505o(35527);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.csB == null) {
                c6092b = new C6092b("Not all required fields were included: appid");
                AppMethodBeat.m2505o(35527);
                throw c6092b;
            } else if (this.kKY == null) {
                c6092b = new C6092b("Not all required fields were included: app_name");
                AppMethodBeat.m2505o(35527);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(35527);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C11504c c11504c = (C11504c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c11504c.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35527);
                    return 0;
                case 2:
                    c11504c.kKY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35527);
                    return 0;
                case 3:
                    c11504c.kKZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35527);
                    return 0;
                case 4:
                    c11504c.kLa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35527);
                    return 0;
                case 5:
                    c11504c.kLb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35527);
                    return 0;
                case 6:
                    c11504c.status = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(35527);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C42909g c42909g = new C42909g();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c42909g.populateBuilderWithField(c6086a3, c42909g, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c11504c.kLc = c42909g;
                    }
                    AppMethodBeat.m2505o(35527);
                    return 0;
                case 8:
                    c11504c.kLd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35527);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35527);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35527);
            return -1;
        }
    }
}
