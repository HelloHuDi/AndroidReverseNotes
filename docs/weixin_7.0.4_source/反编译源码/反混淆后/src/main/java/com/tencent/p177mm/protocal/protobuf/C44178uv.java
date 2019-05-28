package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.uv */
public final class C44178uv extends bsr {
    public String Name;
    public int jBv;
    public String wcl;
    public String wcm;
    public axx wcn;
    public LinkedList<bts> wco = new LinkedList();
    public String wcp;
    public String wcq;

    public C44178uv() {
        AppMethodBeat.m2504i(28377);
        AppMethodBeat.m2505o(28377);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28378);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wcn == null) {
                c6092b = new C6092b("Not all required fields were included: Loc");
                AppMethodBeat.m2505o(28378);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.Name != null) {
                c6093a.mo13475e(2, this.Name);
            }
            if (this.wcl != null) {
                c6093a.mo13475e(3, this.wcl);
            }
            if (this.wcm != null) {
                c6093a.mo13475e(4, this.wcm);
            }
            if (this.wcn != null) {
                c6093a.mo13479iy(5, this.wcn.computeSize());
                this.wcn.writeFields(c6093a);
            }
            c6093a.mo13480iz(6, this.jBv);
            c6093a.mo13474e(7, 8, this.wco);
            if (this.wcp != null) {
                c6093a.mo13475e(8, this.wcp);
            }
            if (this.wcq != null) {
                c6093a.mo13475e(9, this.wcq);
            }
            AppMethodBeat.m2505o(28378);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.Name != null) {
                ix += C6091a.m9575f(2, this.Name);
            }
            if (this.wcl != null) {
                ix += C6091a.m9575f(3, this.wcl);
            }
            if (this.wcm != null) {
                ix += C6091a.m9575f(4, this.wcm);
            }
            if (this.wcn != null) {
                ix += C6087a.m9557ix(5, this.wcn.computeSize());
            }
            ix = (ix + C6091a.m9572bs(6, this.jBv)) + C6087a.m9552c(7, 8, this.wco);
            if (this.wcp != null) {
                ix += C6091a.m9575f(8, this.wcp);
            }
            if (this.wcq != null) {
                ix += C6091a.m9575f(9, this.wcq);
            }
            AppMethodBeat.m2505o(28378);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wco.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wcn == null) {
                c6092b = new C6092b("Not all required fields were included: Loc");
                AppMethodBeat.m2505o(28378);
                throw c6092b;
            }
            AppMethodBeat.m2505o(28378);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44178uv c44178uv = (C44178uv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44178uv.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(28378);
                    return 0;
                case 2:
                    c44178uv.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28378);
                    return 0;
                case 3:
                    c44178uv.wcl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28378);
                    return 0;
                case 4:
                    c44178uv.wcm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28378);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axx axx = new axx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = axx.populateBuilderWithField(c6086a3, axx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44178uv.wcn = axx;
                    }
                    AppMethodBeat.m2505o(28378);
                    return 0;
                case 6:
                    c44178uv.jBv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28378);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c44178uv.wco.add(bts);
                    }
                    AppMethodBeat.m2505o(28378);
                    return 0;
                case 8:
                    c44178uv.wcp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28378);
                    return 0;
                case 9:
                    c44178uv.wcq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28378);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28378);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28378);
            return -1;
        }
    }
}
