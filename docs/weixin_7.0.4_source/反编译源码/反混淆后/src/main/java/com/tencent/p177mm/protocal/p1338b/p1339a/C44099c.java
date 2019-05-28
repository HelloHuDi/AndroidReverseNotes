package com.tencent.p177mm.protocal.p1338b.p1339a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aaz;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.b.a.c */
public final class C44099c extends C1331a {
    public String desc;
    public LinkedList<aar> fjr = new LinkedList();
    public long lgR;
    public String title;
    public String vzJ;
    public aaz vzK;

    public C44099c() {
        AppMethodBeat.m2504i(111120);
        AppMethodBeat.m2505o(111120);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(111121);
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
            c6093a.mo13474e(3, 8, this.fjr);
            if (this.vzJ != null) {
                c6093a.mo13475e(4, this.vzJ);
            }
            if (this.vzK != null) {
                c6093a.mo13479iy(5, this.vzK.computeSize());
                this.vzK.writeFields(c6093a);
            }
            c6093a.mo13472ai(6, this.lgR);
            AppMethodBeat.m2505o(111121);
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
            f += C6087a.m9552c(3, 8, this.fjr);
            if (this.vzJ != null) {
                f += C6091a.m9575f(4, this.vzJ);
            }
            if (this.vzK != null) {
                f += C6087a.m9557ix(5, this.vzK.computeSize());
            }
            int o = f + C6091a.m9578o(6, this.lgR);
            AppMethodBeat.m2505o(111121);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fjr.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(111121);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44099c c44099c = (C44099c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c44099c.title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111121);
                    return 0;
                case 2:
                    c44099c.desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111121);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aar aar = new aar();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aar.populateBuilderWithField(c6086a3, aar, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44099c.fjr.add(aar);
                    }
                    AppMethodBeat.m2505o(111121);
                    return 0;
                case 4:
                    c44099c.vzJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(111121);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aaz aaz = new aaz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aaz.populateBuilderWithField(c6086a3, aaz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44099c.vzK = aaz;
                    }
                    AppMethodBeat.m2505o(111121);
                    return 0;
                case 6:
                    c44099c.lgR = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(111121);
                    return 0;
                default:
                    AppMethodBeat.m2505o(111121);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(111121);
            return -1;
        }
    }
}
