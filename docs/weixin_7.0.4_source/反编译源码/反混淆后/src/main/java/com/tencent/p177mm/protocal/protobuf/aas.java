package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aas */
public final class aas extends C1331a {
    public String desc;
    public String hHV;
    public long lgR;
    public String title;
    public aaz vzK;
    public boolean wfS = false;
    public boolean wfT = false;
    public abu whA;
    public boolean whB = false;
    public abe whC;
    public boolean whD = false;
    public abo whE;
    public boolean whF = false;
    public boolean whG = false;
    public long whH;
    public boolean whI = false;
    public int whJ = -1;
    public boolean whK = false;
    public boolean whL = false;
    public boolean whM = false;
    public aap whN;
    public boolean whO = false;
    public aat whw;
    public boolean whx = false;
    public aay why;
    public boolean whz = false;

    /* renamed from: c */
    public final aas mo48444c(aat aat) {
        this.whw = aat;
        this.whx = true;
        return this;
    }

    /* renamed from: a */
    public final aas mo48440a(aay aay) {
        this.why = aay;
        this.whz = true;
        return this;
    }

    /* renamed from: a */
    public final aas mo48443a(abu abu) {
        this.whA = abu;
        this.whB = true;
        return this;
    }

    /* renamed from: a */
    public final aas mo48441a(abe abe) {
        this.whC = abe;
        this.whD = true;
        return this;
    }

    /* renamed from: a */
    public final aas mo48442a(abo abo) {
        this.whE = abo;
        this.whF = true;
        return this;
    }

    /* renamed from: a */
    public final aas mo48439a(aap aap) {
        this.whN = aap;
        this.whO = true;
        return this;
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51391);
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.whw != null) {
                c6093a.mo13479iy(1, this.whw.computeSize());
                this.whw.writeFields(c6093a);
            }
            if (this.why != null) {
                c6093a.mo13479iy(2, this.why.computeSize());
                this.why.writeFields(c6093a);
            }
            if (this.whA != null) {
                c6093a.mo13479iy(3, this.whA.computeSize());
                this.whA.writeFields(c6093a);
            }
            if (this.whC != null) {
                c6093a.mo13479iy(4, this.whC.computeSize());
                this.whC.writeFields(c6093a);
            }
            if (this.whE != null) {
                c6093a.mo13479iy(5, this.whE.computeSize());
                this.whE.writeFields(c6093a);
            }
            if (this.hHV != null) {
                c6093a.mo13475e(6, this.hHV);
            }
            if (this.title != null) {
                c6093a.mo13475e(7, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(8, this.desc);
            }
            if (this.whI) {
                c6093a.mo13472ai(9, this.whH);
            }
            if (this.whK) {
                c6093a.mo13480iz(101, this.whJ);
            }
            if (this.whL) {
                c6093a.mo13472ai(11, this.lgR);
            }
            if (this.vzK != null) {
                c6093a.mo13479iy(12, this.vzK.computeSize());
                this.vzK.writeFields(c6093a);
            }
            if (this.whN != null) {
                c6093a.mo13479iy(13, this.whN.computeSize());
                this.whN.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(51391);
            return 0;
        } else if (i == 1) {
            if (this.whw != null) {
                ix = C6087a.m9557ix(1, this.whw.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.why != null) {
                ix += C6087a.m9557ix(2, this.why.computeSize());
            }
            if (this.whA != null) {
                ix += C6087a.m9557ix(3, this.whA.computeSize());
            }
            if (this.whC != null) {
                ix += C6087a.m9557ix(4, this.whC.computeSize());
            }
            if (this.whE != null) {
                ix += C6087a.m9557ix(5, this.whE.computeSize());
            }
            if (this.hHV != null) {
                ix += C6091a.m9575f(6, this.hHV);
            }
            if (this.title != null) {
                ix += C6091a.m9575f(7, this.title);
            }
            if (this.desc != null) {
                ix += C6091a.m9575f(8, this.desc);
            }
            if (this.whI) {
                ix += C6091a.m9578o(9, this.whH);
            }
            if (this.whK) {
                ix += C6091a.m9572bs(101, this.whJ);
            }
            if (this.whL) {
                ix += C6091a.m9578o(11, this.lgR);
            }
            if (this.vzK != null) {
                ix += C6087a.m9557ix(12, this.vzK.computeSize());
            }
            if (this.whN != null) {
                ix += C6087a.m9557ix(13, this.whN.computeSize());
            }
            AppMethodBeat.m2505o(51391);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51391);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aas aas = (aas) objArr[1];
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
                        aat aat = new aat();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aat.populateBuilderWithField(c6086a3, aat, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aas.whw = aat;
                    }
                    aas.whx = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aay aay = new aay();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aay.populateBuilderWithField(c6086a3, aay, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aas.why = aay;
                    }
                    aas.whz = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abu abu = new abu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abu.populateBuilderWithField(c6086a3, abu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aas.whA = abu;
                    }
                    aas.whB = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abe abe = new abe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abe.populateBuilderWithField(c6086a3, abe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aas.whC = abe;
                    }
                    aas.whD = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abo abo = new abo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abo.populateBuilderWithField(c6086a3, abo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aas.whE = abo;
                    }
                    aas.whF = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 6:
                    aas.hHV = c6086a2.BTU.readString();
                    aas.whG = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 7:
                    aas.title = c6086a2.BTU.readString();
                    aas.wfS = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 8:
                    aas.desc = c6086a2.BTU.readString();
                    aas.wfT = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 9:
                    aas.whH = c6086a2.BTU.mo13459ve();
                    aas.whI = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 11:
                    aas.lgR = c6086a2.BTU.mo13459ve();
                    aas.whL = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aaz aaz = new aaz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aaz.populateBuilderWithField(c6086a3, aaz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aas.vzK = aaz;
                    }
                    aas.whM = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aap aap = new aap();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aap.populateBuilderWithField(c6086a3, aap, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aas.whN = aap;
                    }
                    aas.whO = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                case 101:
                    aas.whJ = c6086a2.BTU.mo13458vd();
                    aas.whK = true;
                    AppMethodBeat.m2505o(51391);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51391);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51391);
            return -1;
        }
    }
}
