package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abf */
public final class abf extends C1331a {
    public String desc;
    public String hHV;
    public long lgR;
    public String title;
    public int version;
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
    public aay why;
    public boolean whz = false;
    public abl wit;
    public boolean wiu = false;
    public LinkedList<aar> wiv = new LinkedList();
    public boolean wiw = false;
    public boolean wix = false;

    public abf() {
        AppMethodBeat.m2504i(51404);
        AppMethodBeat.m2505o(51404);
    }

    /* renamed from: a */
    public final abf mo74737a(abl abl) {
        this.wit = abl;
        this.wiu = true;
        return this;
    }

    /* renamed from: aE */
    public final abf mo74738aE(LinkedList<aar> linkedList) {
        this.wiv = linkedList;
        this.wiw = true;
        return this;
    }

    /* renamed from: b */
    public final abf mo74743b(aay aay) {
        this.why = aay;
        this.whz = true;
        return this;
    }

    /* renamed from: b */
    public final abf mo74746b(abu abu) {
        this.whA = abu;
        this.whB = true;
        return this;
    }

    public final abf alA(String str) {
        this.hHV = str;
        this.whG = true;
        return this;
    }

    public final abf alB(String str) {
        this.title = str;
        this.wfS = true;
        return this;
    }

    public final abf alC(String str) {
        this.desc = str;
        this.wfT = true;
        return this;
    }

    /* renamed from: mj */
    public final abf mo74747mj(long j) {
        this.whH = j;
        this.whI = true;
        return this;
    }

    /* renamed from: LL */
    public final abf mo74734LL(int i) {
        this.whJ = i;
        this.whK = true;
        return this;
    }

    /* renamed from: b */
    public final abf mo74744b(abe abe) {
        this.whC = abe;
        this.whD = true;
        return this;
    }

    /* renamed from: mk */
    public final abf mo74748mk(long j) {
        this.lgR = j;
        this.whL = true;
        return this;
    }

    /* renamed from: b */
    public final abf mo74745b(abo abo) {
        this.whE = abo;
        this.whF = true;
        return this;
    }

    /* renamed from: LM */
    public final abf mo74735LM(int i) {
        this.version = i;
        this.wix = true;
        return this;
    }

    /* renamed from: a */
    public final abf mo74736a(aaz aaz) {
        this.vzK = aaz;
        this.whM = true;
        return this;
    }

    /* renamed from: b */
    public final abf mo74742b(aap aap) {
        this.whN = aap;
        this.whO = true;
        return this;
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51405);
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wit != null) {
                c6093a.mo13479iy(1, this.wit.computeSize());
                this.wit.writeFields(c6093a);
            }
            c6093a.mo13474e(2, 8, this.wiv);
            if (this.why != null) {
                c6093a.mo13479iy(3, this.why.computeSize());
                this.why.writeFields(c6093a);
            }
            if (this.whA != null) {
                c6093a.mo13479iy(4, this.whA.computeSize());
                this.whA.writeFields(c6093a);
            }
            if (this.hHV != null) {
                c6093a.mo13475e(5, this.hHV);
            }
            if (this.title != null) {
                c6093a.mo13475e(6, this.title);
            }
            if (this.desc != null) {
                c6093a.mo13475e(7, this.desc);
            }
            if (this.whI) {
                c6093a.mo13472ai(8, this.whH);
            }
            if (this.whK) {
                c6093a.mo13480iz(91, this.whJ);
            }
            if (this.whC != null) {
                c6093a.mo13479iy(10, this.whC.computeSize());
                this.whC.writeFields(c6093a);
            }
            if (this.whL) {
                c6093a.mo13472ai(11, this.lgR);
            }
            if (this.whE != null) {
                c6093a.mo13479iy(12, this.whE.computeSize());
                this.whE.writeFields(c6093a);
            }
            if (this.wix) {
                c6093a.mo13480iz(13, this.version);
            }
            if (this.vzK != null) {
                c6093a.mo13479iy(14, this.vzK.computeSize());
                this.vzK.writeFields(c6093a);
            }
            if (this.whN != null) {
                c6093a.mo13479iy(15, this.whN.computeSize());
                this.whN.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(51405);
            return 0;
        } else if (i == 1) {
            if (this.wit != null) {
                ix = C6087a.m9557ix(1, this.wit.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += C6087a.m9552c(2, 8, this.wiv);
            if (this.why != null) {
                ix += C6087a.m9557ix(3, this.why.computeSize());
            }
            if (this.whA != null) {
                ix += C6087a.m9557ix(4, this.whA.computeSize());
            }
            if (this.hHV != null) {
                ix += C6091a.m9575f(5, this.hHV);
            }
            if (this.title != null) {
                ix += C6091a.m9575f(6, this.title);
            }
            if (this.desc != null) {
                ix += C6091a.m9575f(7, this.desc);
            }
            if (this.whI) {
                ix += C6091a.m9578o(8, this.whH);
            }
            if (this.whK) {
                ix += C6091a.m9572bs(91, this.whJ);
            }
            if (this.whC != null) {
                ix += C6087a.m9557ix(10, this.whC.computeSize());
            }
            if (this.whL) {
                ix += C6091a.m9578o(11, this.lgR);
            }
            if (this.whE != null) {
                ix += C6087a.m9557ix(12, this.whE.computeSize());
            }
            if (this.wix) {
                ix += C6091a.m9572bs(13, this.version);
            }
            if (this.vzK != null) {
                ix += C6087a.m9557ix(14, this.vzK.computeSize());
            }
            if (this.whN != null) {
                ix += C6087a.m9557ix(15, this.whN.computeSize());
            }
            AppMethodBeat.m2505o(51405);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wiv.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51405);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abf abf = (abf) objArr[1];
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
                        abl abl = new abl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abl.populateBuilderWithField(c6086a3, abl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        abf.wit = abl;
                    }
                    abf.wiu = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aar aar = new aar();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aar.populateBuilderWithField(c6086a3, aar, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        abf.wiv.add(aar);
                    }
                    abf.wiw = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aay aay = new aay();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aay.populateBuilderWithField(c6086a3, aay, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        abf.why = aay;
                    }
                    abf.whz = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abu abu = new abu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abu.populateBuilderWithField(c6086a3, abu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        abf.whA = abu;
                    }
                    abf.whB = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 5:
                    abf.hHV = c6086a2.BTU.readString();
                    abf.whG = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 6:
                    abf.title = c6086a2.BTU.readString();
                    abf.wfS = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 7:
                    abf.desc = c6086a2.BTU.readString();
                    abf.wfT = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 8:
                    abf.whH = c6086a2.BTU.mo13459ve();
                    abf.whI = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abe abe = new abe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abe.populateBuilderWithField(c6086a3, abe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        abf.whC = abe;
                    }
                    abf.whD = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 11:
                    abf.lgR = c6086a2.BTU.mo13459ve();
                    abf.whL = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abo abo = new abo();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abo.populateBuilderWithField(c6086a3, abo, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        abf.whE = abo;
                    }
                    abf.whF = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 13:
                    abf.version = c6086a2.BTU.mo13458vd();
                    abf.wix = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 14:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aaz aaz = new aaz();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aaz.populateBuilderWithField(c6086a3, aaz, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        abf.vzK = aaz;
                    }
                    abf.whM = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aap aap = new aap();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = aap.populateBuilderWithField(c6086a3, aap, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        abf.whN = aap;
                    }
                    abf.whO = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    abf.whJ = c6086a2.BTU.mo13458vd();
                    abf.whK = true;
                    AppMethodBeat.m2505o(51405);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51405);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51405);
            return -1;
        }
    }
}
