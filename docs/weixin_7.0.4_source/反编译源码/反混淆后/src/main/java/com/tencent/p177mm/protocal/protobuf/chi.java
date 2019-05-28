package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.chi */
public final class chi extends C1331a {
    public String Md5;
    public int Version;
    public int jCt;
    public String vZm;
    public int vZn;
    public int wUX;
    public String wld;
    public LinkedList<chh> xgc = new LinkedList();
    public boolean xgd;
    public LinkedList<chj> xge = new LinkedList();
    public String xgf;

    public chi() {
        AppMethodBeat.m2504i(14756);
        AppMethodBeat.m2505o(14756);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14757);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jCt);
            c6093a.mo13480iz(2, this.Version);
            if (this.vZm != null) {
                c6093a.mo13475e(3, this.vZm);
            }
            if (this.Md5 != null) {
                c6093a.mo13475e(4, this.Md5);
            }
            c6093a.mo13480iz(5, this.vZn);
            c6093a.mo13480iz(6, this.wUX);
            c6093a.mo13474e(7, 8, this.xgc);
            c6093a.mo13471aO(8, this.xgd);
            if (this.wld != null) {
                c6093a.mo13475e(9, this.wld);
            }
            c6093a.mo13474e(10, 8, this.xge);
            if (this.xgf != null) {
                c6093a.mo13475e(11, this.xgf);
            }
            AppMethodBeat.m2505o(14757);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.jCt) + 0) + C6091a.m9572bs(2, this.Version);
            if (this.vZm != null) {
                bs += C6091a.m9575f(3, this.vZm);
            }
            if (this.Md5 != null) {
                bs += C6091a.m9575f(4, this.Md5);
            }
            bs = (((bs + C6091a.m9572bs(5, this.vZn)) + C6091a.m9572bs(6, this.wUX)) + C6087a.m9552c(7, 8, this.xgc)) + (C6091a.m9576fv(8) + 1);
            if (this.wld != null) {
                bs += C6091a.m9575f(9, this.wld);
            }
            bs += C6087a.m9552c(10, 8, this.xge);
            if (this.xgf != null) {
                bs += C6091a.m9575f(11, this.xgf);
            }
            AppMethodBeat.m2505o(14757);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xgc.clear();
            this.xge.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14757);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            chi chi = (chi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    chi.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 2:
                    chi.Version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 3:
                    chi.vZm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 4:
                    chi.Md5 = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 5:
                    chi.vZn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 6:
                    chi.wUX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chh chh = new chh();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chh.populateBuilderWithField(c6086a3, chh, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chi.xgc.add(chh);
                    }
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 8:
                    chi.xgd = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 9:
                    chi.wld = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chj chj = new chj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chj.populateBuilderWithField(c6086a3, chj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        chi.xge.add(chj);
                    }
                    AppMethodBeat.m2505o(14757);
                    return 0;
                case 11:
                    chi.xgf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14757);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14757);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14757);
            return -1;
        }
    }
}
