package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.btr */
public final class btr extends C1331a {
    public int type;
    public String url;
    public chf wVC;
    public C30241xb wVD;
    public int wVE;
    public boolean wVF;
    public C30232ux wVG;
    public C23370ba wVH;
    public LinkedList<C23461xc> wct = new LinkedList();

    public btr() {
        AppMethodBeat.m2504i(48961);
        AppMethodBeat.m2505o(48961);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48962);
        int bs;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.type);
            if (this.url != null) {
                c6093a.mo13475e(2, this.url);
            }
            if (this.wVC != null) {
                c6093a.mo13479iy(3, this.wVC.computeSize());
                this.wVC.writeFields(c6093a);
            }
            if (this.wVD != null) {
                c6093a.mo13479iy(4, this.wVD.computeSize());
                this.wVD.writeFields(c6093a);
            }
            c6093a.mo13480iz(5, this.wVE);
            c6093a.mo13471aO(6, this.wVF);
            c6093a.mo13474e(7, 8, this.wct);
            if (this.wVG != null) {
                c6093a.mo13479iy(8, this.wVG.computeSize());
                this.wVG.writeFields(c6093a);
            }
            if (this.wVH != null) {
                c6093a.mo13479iy(9, this.wVH.computeSize());
                this.wVH.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48962);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.type) + 0;
            if (this.url != null) {
                bs += C6091a.m9575f(2, this.url);
            }
            if (this.wVC != null) {
                bs += C6087a.m9557ix(3, this.wVC.computeSize());
            }
            if (this.wVD != null) {
                bs += C6087a.m9557ix(4, this.wVD.computeSize());
            }
            bs = ((bs + C6091a.m9572bs(5, this.wVE)) + (C6091a.m9576fv(6) + 1)) + C6087a.m9552c(7, 8, this.wct);
            if (this.wVG != null) {
                bs += C6087a.m9557ix(8, this.wVG.computeSize());
            }
            if (this.wVH != null) {
                bs += C6087a.m9557ix(9, this.wVH.computeSize());
            }
            AppMethodBeat.m2505o(48962);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wct.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48962);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            btr btr = (btr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    btr.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48962);
                    return 0;
                case 2:
                    btr.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48962);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chf chf = new chf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = chf.populateBuilderWithField(c6086a3, chf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        btr.wVC = chf;
                    }
                    AppMethodBeat.m2505o(48962);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30241xb c30241xb = new C30241xb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30241xb.populateBuilderWithField(c6086a3, c30241xb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        btr.wVD = c30241xb;
                    }
                    AppMethodBeat.m2505o(48962);
                    return 0;
                case 5:
                    btr.wVE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48962);
                    return 0;
                case 6:
                    btr.wVF = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48962);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23461xc c23461xc = new C23461xc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23461xc.populateBuilderWithField(c6086a3, c23461xc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        btr.wct.add(c23461xc);
                    }
                    AppMethodBeat.m2505o(48962);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C30232ux c30232ux = new C30232ux();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c30232ux.populateBuilderWithField(c6086a3, c30232ux, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        btr.wVG = c30232ux;
                    }
                    AppMethodBeat.m2505o(48962);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23370ba c23370ba = new C23370ba();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23370ba.populateBuilderWithField(c6086a3, c23370ba, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        btr.wVH = c23370ba;
                    }
                    AppMethodBeat.m2505o(48962);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48962);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48962);
            return -1;
        }
    }
}
