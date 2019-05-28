package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.dr */
public final class C30178dr extends C1331a {
    public LinkedList<bha> ckO = new LinkedList();
    public LinkedList<bhb> vCr = new LinkedList();
    public int vFv;

    public C30178dr() {
        AppMethodBeat.m2504i(80016);
        AppMethodBeat.m2505o(80016);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80017);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vFv);
            c6093a.mo13474e(2, 8, this.vCr);
            c6093a.mo13474e(3, 8, this.ckO);
            AppMethodBeat.m2505o(80017);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.vFv) + 0) + C6087a.m9552c(2, 8, this.vCr)) + C6087a.m9552c(3, 8, this.ckO);
            AppMethodBeat.m2505o(80017);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vCr.clear();
            this.ckO.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80017);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30178dr c30178dr = (C30178dr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c30178dr.vFv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80017);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhb bhb = new bhb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhb.populateBuilderWithField(c6086a3, bhb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30178dr.vCr.add(bhb);
                    }
                    AppMethodBeat.m2505o(80017);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bha bha = new bha();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bha.populateBuilderWithField(c6086a3, bha, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30178dr.ckO.add(bha);
                    }
                    AppMethodBeat.m2505o(80017);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80017);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80017);
            return -1;
        }
    }
}
