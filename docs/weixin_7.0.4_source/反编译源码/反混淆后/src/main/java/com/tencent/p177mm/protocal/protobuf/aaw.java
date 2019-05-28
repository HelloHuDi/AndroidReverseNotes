package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aaw */
public final class aaw extends C1331a {
    public String appId;
    public String cEV;
    public abf cKb;
    public String csl;
    public String desc;
    public String title;
    public int type;
    public String wif;
    public LinkedList<String> wig = new LinkedList();

    public aaw() {
        AppMethodBeat.m2504i(51396);
        AppMethodBeat.m2505o(51396);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51397);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.title != null) {
                c6093a.mo13475e(1, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(2, this.desc);
            }
            if (this.cEV != null) {
                c6093a.mo13475e(3, this.cEV);
            }
            if (this.wif != null) {
                c6093a.mo13475e(4, this.wif);
            }
            if (this.appId != null) {
                c6093a.mo13475e(5, this.appId);
            }
            if (this.csl != null) {
                c6093a.mo13475e(6, this.csl);
            }
            c6093a.mo13474e(7, 1, this.wig);
            c6093a.mo13480iz(8, this.type);
            if (this.cKb != null) {
                c6093a.mo13479iy(9, this.cKb.computeSize());
                this.cKb.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(51397);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = C6091a.m9575f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += C6091a.m9575f(2, this.desc);
            }
            if (this.cEV != null) {
                f += C6091a.m9575f(3, this.cEV);
            }
            if (this.wif != null) {
                f += C6091a.m9575f(4, this.wif);
            }
            if (this.appId != null) {
                f += C6091a.m9575f(5, this.appId);
            }
            if (this.csl != null) {
                f += C6091a.m9575f(6, this.csl);
            }
            f = (f + C6087a.m9552c(7, 1, this.wig)) + C6091a.m9572bs(8, this.type);
            if (this.cKb != null) {
                f += C6087a.m9557ix(9, this.cKb.computeSize());
            }
            AppMethodBeat.m2505o(51397);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wig.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51397);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aaw aaw = (aaw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aaw.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51397);
                    return 0;
                case 2:
                    aaw.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51397);
                    return 0;
                case 3:
                    aaw.cEV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51397);
                    return 0;
                case 4:
                    aaw.wif = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51397);
                    return 0;
                case 5:
                    aaw.appId = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51397);
                    return 0;
                case 6:
                    aaw.csl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51397);
                    return 0;
                case 7:
                    aaw.wig.add(c6086a2.BTU.readString());
                    AppMethodBeat.m2505o(51397);
                    return 0;
                case 8:
                    aaw.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51397);
                    return 0;
                case 9:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abf abf = new abf();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = abf.populateBuilderWithField(c6086a3, abf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aaw.cKb = abf;
                    }
                    AppMethodBeat.m2505o(51397);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51397);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51397);
            return -1;
        }
    }
}
