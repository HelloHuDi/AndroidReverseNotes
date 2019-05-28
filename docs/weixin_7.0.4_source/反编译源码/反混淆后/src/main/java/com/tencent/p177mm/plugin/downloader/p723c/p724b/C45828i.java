package com.tencent.p177mm.plugin.downloader.p723c.p724b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.b.i */
public final class C45828i extends C1331a {
    public String egm;
    public long kKP;
    public String kKT;
    public String kKW;
    public C6832l kLu;
    public String kLv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35535);
        C6092b c6092b;
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.egm == null) {
                c6092b = new C6092b("Not all required fields were included: download_url");
                AppMethodBeat.m2505o(35535);
                throw c6092b;
            }
            if (this.egm != null) {
                c6093a.mo13475e(1, this.egm);
            }
            c6093a.mo13472ai(2, this.kKP);
            if (this.kLu != null) {
                c6093a.mo13479iy(3, this.kLu.computeSize());
                this.kLu.writeFields(c6093a);
            }
            if (this.kLv != null) {
                c6093a.mo13475e(4, this.kLv);
            }
            if (this.kKW != null) {
                c6093a.mo13475e(5, this.kKW);
            }
            if (this.kKT != null) {
                c6093a.mo13475e(6, this.kKT);
            }
            AppMethodBeat.m2505o(35535);
            return 0;
        } else if (i == 1) {
            if (this.egm != null) {
                f = C6091a.m9575f(1, this.egm) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9578o(2, this.kKP);
            if (this.kLu != null) {
                f += C6087a.m9557ix(3, this.kLu.computeSize());
            }
            if (this.kLv != null) {
                f += C6091a.m9575f(4, this.kLv);
            }
            if (this.kKW != null) {
                f += C6091a.m9575f(5, this.kKW);
            }
            if (this.kKT != null) {
                f += C6091a.m9575f(6, this.kKT);
            }
            AppMethodBeat.m2505o(35535);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.egm == null) {
                c6092b = new C6092b("Not all required fields were included: download_url");
                AppMethodBeat.m2505o(35535);
                throw c6092b;
            }
            AppMethodBeat.m2505o(35535);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45828i c45828i = (C45828i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c45828i.egm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35535);
                    return 0;
                case 2:
                    c45828i.kKP = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(35535);
                    return 0;
                case 3:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        C6832l c6832l = new C6832l();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c6832l.populateBuilderWithField(c6086a3, c6832l, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c45828i.kLu = c6832l;
                    }
                    AppMethodBeat.m2505o(35535);
                    return 0;
                case 4:
                    c45828i.kLv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35535);
                    return 0;
                case 5:
                    c45828i.kKW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35535);
                    return 0;
                case 6:
                    c45828i.kKT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35535);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35535);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35535);
            return -1;
        }
    }
}
