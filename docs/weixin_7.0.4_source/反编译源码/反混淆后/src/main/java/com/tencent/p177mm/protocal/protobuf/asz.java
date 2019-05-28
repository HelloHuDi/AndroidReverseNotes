package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.asz */
public final class asz extends C1331a {
    public C46547hj wwG;
    public C23418na wwH;
    public bba wwI;
    public cdp wwJ;
    public buk wwK;
    public C23443td wwL;
    public abx wwM;
    public acu wwN;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(2542);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wwG != null) {
                c6093a.mo13479iy(1, this.wwG.computeSize());
                this.wwG.writeFields(c6093a);
            }
            if (this.wwH != null) {
                c6093a.mo13479iy(2, this.wwH.computeSize());
                this.wwH.writeFields(c6093a);
            }
            if (this.wwI != null) {
                c6093a.mo13479iy(3, this.wwI.computeSize());
                this.wwI.writeFields(c6093a);
            }
            if (this.wwJ != null) {
                c6093a.mo13479iy(4, this.wwJ.computeSize());
                this.wwJ.writeFields(c6093a);
            }
            if (this.wwK != null) {
                c6093a.mo13479iy(6, this.wwK.computeSize());
                this.wwK.writeFields(c6093a);
            }
            if (this.wwL != null) {
                c6093a.mo13479iy(7, this.wwL.computeSize());
                this.wwL.writeFields(c6093a);
            }
            if (this.wwM != null) {
                c6093a.mo13479iy(8, this.wwM.computeSize());
                this.wwM.writeFields(c6093a);
            }
            if (this.wwN != null) {
                c6093a.mo13479iy(9, this.wwN.computeSize());
                this.wwN.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(2542);
            return 0;
        } else if (i == 1) {
            if (this.wwG != null) {
                ix = C6087a.m9557ix(1, this.wwG.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wwH != null) {
                ix += C6087a.m9557ix(2, this.wwH.computeSize());
            }
            if (this.wwI != null) {
                ix += C6087a.m9557ix(3, this.wwI.computeSize());
            }
            if (this.wwJ != null) {
                ix += C6087a.m9557ix(4, this.wwJ.computeSize());
            }
            if (this.wwK != null) {
                ix += C6087a.m9557ix(6, this.wwK.computeSize());
            }
            if (this.wwL != null) {
                ix += C6087a.m9557ix(7, this.wwL.computeSize());
            }
            if (this.wwM != null) {
                ix += C6087a.m9557ix(8, this.wwM.computeSize());
            }
            if (this.wwN != null) {
                ix += C6087a.m9557ix(9, this.wwN.computeSize());
            }
            AppMethodBeat.m2505o(2542);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(2542);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            asz asz = (asz) objArr[1];
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
                        C46547hj c46547hj = new C46547hj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c46547hj.populateBuilderWithField(c6086a3, c46547hj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asz.wwG = c46547hj;
                    }
                    AppMethodBeat.m2505o(2542);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23418na c23418na = new C23418na();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23418na.populateBuilderWithField(c6086a3, c23418na, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asz.wwH = c23418na;
                    }
                    AppMethodBeat.m2505o(2542);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bba bba = new bba();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bba.populateBuilderWithField(c6086a3, bba, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asz.wwI = bba;
                    }
                    AppMethodBeat.m2505o(2542);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdp cdp = new cdp();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdp.populateBuilderWithField(c6086a3, cdp, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asz.wwJ = cdp;
                    }
                    AppMethodBeat.m2505o(2542);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buk buk = new buk();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = buk.populateBuilderWithField(c6086a3, buk, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asz.wwK = buk;
                    }
                    AppMethodBeat.m2505o(2542);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C23443td c23443td = new C23443td();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c23443td.populateBuilderWithField(c6086a3, c23443td, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asz.wwL = c23443td;
                    }
                    AppMethodBeat.m2505o(2542);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abx abx = new abx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abx.populateBuilderWithField(c6086a3, abx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asz.wwM = abx;
                    }
                    AppMethodBeat.m2505o(2542);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acu acu = new acu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = acu.populateBuilderWithField(c6086a3, acu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        asz.wwN = acu;
                    }
                    AppMethodBeat.m2505o(2542);
                    return 0;
                default:
                    AppMethodBeat.m2505o(2542);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(2542);
            return -1;
        }
    }
}
