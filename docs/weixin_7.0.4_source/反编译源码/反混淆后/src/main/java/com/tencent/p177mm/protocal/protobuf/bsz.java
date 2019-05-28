package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bsz */
public final class bsz extends C1331a {
    public int FileSize;
    public String Url;
    public int wVf;
    public int wVg;
    public LinkedList<bzu> wVh = new LinkedList();
    public String wVi;
    public String wdO;
    public C1332b wdt;

    public bsz() {
        AppMethodBeat.m2504i(80164);
        AppMethodBeat.m2505o(80164);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80165);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wdO == null) {
                c6092b = new C6092b("Not all required fields were included: MD5");
                AppMethodBeat.m2505o(80165);
                throw c6092b;
            } else if (this.Url == null) {
                c6092b = new C6092b("Not all required fields were included: Url");
                AppMethodBeat.m2505o(80165);
                throw c6092b;
            } else if (this.wVi == null) {
                c6092b = new C6092b("Not all required fields were included: OriginalMD5");
                AppMethodBeat.m2505o(80165);
                throw c6092b;
            } else {
                if (this.wdO != null) {
                    c6093a.mo13475e(1, this.wdO);
                }
                c6093a.mo13480iz(2, this.wVf);
                if (this.Url != null) {
                    c6093a.mo13475e(3, this.Url);
                }
                c6093a.mo13480iz(4, this.wVg);
                c6093a.mo13474e(5, 8, this.wVh);
                if (this.wdt != null) {
                    c6093a.mo13473c(6, this.wdt);
                }
                if (this.wVi != null) {
                    c6093a.mo13475e(7, this.wVi);
                }
                c6093a.mo13480iz(8, this.FileSize);
                AppMethodBeat.m2505o(80165);
                return 0;
            }
        } else if (i == 1) {
            if (this.wdO != null) {
                f = C6091a.m9575f(1, this.wdO) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wVf);
            if (this.Url != null) {
                f += C6091a.m9575f(3, this.Url);
            }
            f = (f + C6091a.m9572bs(4, this.wVg)) + C6087a.m9552c(5, 8, this.wVh);
            if (this.wdt != null) {
                f += C6091a.m9571b(6, this.wdt);
            }
            if (this.wVi != null) {
                f += C6091a.m9575f(7, this.wVi);
            }
            int bs = f + C6091a.m9572bs(8, this.FileSize);
            AppMethodBeat.m2505o(80165);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wVh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.wdO == null) {
                c6092b = new C6092b("Not all required fields were included: MD5");
                AppMethodBeat.m2505o(80165);
                throw c6092b;
            } else if (this.Url == null) {
                c6092b = new C6092b("Not all required fields were included: Url");
                AppMethodBeat.m2505o(80165);
                throw c6092b;
            } else if (this.wVi == null) {
                c6092b = new C6092b("Not all required fields were included: OriginalMD5");
                AppMethodBeat.m2505o(80165);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(80165);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bsz bsz = (bsz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bsz.wdO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80165);
                    return 0;
                case 2:
                    bsz.wVf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80165);
                    return 0;
                case 3:
                    bsz.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80165);
                    return 0;
                case 4:
                    bsz.wVg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80165);
                    return 0;
                case 5:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzu bzu = new bzu();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bzu.populateBuilderWithField(c6086a3, bzu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bsz.wVh.add(bzu);
                    }
                    AppMethodBeat.m2505o(80165);
                    return 0;
                case 6:
                    bsz.wdt = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(80165);
                    return 0;
                case 7:
                    bsz.wVi = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80165);
                    return 0;
                case 8:
                    bsz.FileSize = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80165);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80165);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80165);
            return -1;
        }
    }
}
