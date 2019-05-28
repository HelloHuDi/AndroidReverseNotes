package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.LinkedList;

public final class abf extends a {
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
        AppMethodBeat.i(51404);
        AppMethodBeat.o(51404);
    }

    public final abf a(abl abl) {
        this.wit = abl;
        this.wiu = true;
        return this;
    }

    public final abf aE(LinkedList<aar> linkedList) {
        this.wiv = linkedList;
        this.wiw = true;
        return this;
    }

    public final abf b(aay aay) {
        this.why = aay;
        this.whz = true;
        return this;
    }

    public final abf b(abu abu) {
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

    public final abf mj(long j) {
        this.whH = j;
        this.whI = true;
        return this;
    }

    public final abf LL(int i) {
        this.whJ = i;
        this.whK = true;
        return this;
    }

    public final abf b(abe abe) {
        this.whC = abe;
        this.whD = true;
        return this;
    }

    public final abf mk(long j) {
        this.lgR = j;
        this.whL = true;
        return this;
    }

    public final abf b(abo abo) {
        this.whE = abo;
        this.whF = true;
        return this;
    }

    public final abf LM(int i) {
        this.version = i;
        this.wix = true;
        return this;
    }

    public final abf a(aaz aaz) {
        this.vzK = aaz;
        this.whM = true;
        return this;
    }

    public final abf b(aap aap) {
        this.whN = aap;
        this.whO = true;
        return this;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51405);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wit != null) {
                aVar.iy(1, this.wit.computeSize());
                this.wit.writeFields(aVar);
            }
            aVar.e(2, 8, this.wiv);
            if (this.why != null) {
                aVar.iy(3, this.why.computeSize());
                this.why.writeFields(aVar);
            }
            if (this.whA != null) {
                aVar.iy(4, this.whA.computeSize());
                this.whA.writeFields(aVar);
            }
            if (this.hHV != null) {
                aVar.e(5, this.hHV);
            }
            if (this.title != null) {
                aVar.e(6, this.title);
            }
            if (this.desc != null) {
                aVar.e(7, this.desc);
            }
            if (this.whI) {
                aVar.ai(8, this.whH);
            }
            if (this.whK) {
                aVar.iz(91, this.whJ);
            }
            if (this.whC != null) {
                aVar.iy(10, this.whC.computeSize());
                this.whC.writeFields(aVar);
            }
            if (this.whL) {
                aVar.ai(11, this.lgR);
            }
            if (this.whE != null) {
                aVar.iy(12, this.whE.computeSize());
                this.whE.writeFields(aVar);
            }
            if (this.wix) {
                aVar.iz(13, this.version);
            }
            if (this.vzK != null) {
                aVar.iy(14, this.vzK.computeSize());
                this.vzK.writeFields(aVar);
            }
            if (this.whN != null) {
                aVar.iy(15, this.whN.computeSize());
                this.whN.writeFields(aVar);
            }
            AppMethodBeat.o(51405);
            return 0;
        } else if (i == 1) {
            if (this.wit != null) {
                ix = e.a.a.a.ix(1, this.wit.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.wiv);
            if (this.why != null) {
                ix += e.a.a.a.ix(3, this.why.computeSize());
            }
            if (this.whA != null) {
                ix += e.a.a.a.ix(4, this.whA.computeSize());
            }
            if (this.hHV != null) {
                ix += e.a.a.b.b.a.f(5, this.hHV);
            }
            if (this.title != null) {
                ix += e.a.a.b.b.a.f(6, this.title);
            }
            if (this.desc != null) {
                ix += e.a.a.b.b.a.f(7, this.desc);
            }
            if (this.whI) {
                ix += e.a.a.b.b.a.o(8, this.whH);
            }
            if (this.whK) {
                ix += e.a.a.b.b.a.bs(91, this.whJ);
            }
            if (this.whC != null) {
                ix += e.a.a.a.ix(10, this.whC.computeSize());
            }
            if (this.whL) {
                ix += e.a.a.b.b.a.o(11, this.lgR);
            }
            if (this.whE != null) {
                ix += e.a.a.a.ix(12, this.whE.computeSize());
            }
            if (this.wix) {
                ix += e.a.a.b.b.a.bs(13, this.version);
            }
            if (this.vzK != null) {
                ix += e.a.a.a.ix(14, this.vzK.computeSize());
            }
            if (this.whN != null) {
                ix += e.a.a.a.ix(15, this.whN.computeSize());
            }
            AppMethodBeat.o(51405);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wiv.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51405);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            abf abf = (abf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abl abl = new abl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abl.populateBuilderWithField(aVar4, abl, a.getNextFieldNumber(aVar4))) {
                        }
                        abf.wit = abl;
                    }
                    abf.wiu = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aar aar = new aar();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aar.populateBuilderWithField(aVar4, aar, a.getNextFieldNumber(aVar4))) {
                        }
                        abf.wiv.add(aar);
                    }
                    abf.wiw = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aay aay = new aay();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aay.populateBuilderWithField(aVar4, aay, a.getNextFieldNumber(aVar4))) {
                        }
                        abf.why = aay;
                    }
                    abf.whz = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abu abu = new abu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abu.populateBuilderWithField(aVar4, abu, a.getNextFieldNumber(aVar4))) {
                        }
                        abf.whA = abu;
                    }
                    abf.whB = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 5:
                    abf.hHV = aVar3.BTU.readString();
                    abf.whG = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 6:
                    abf.title = aVar3.BTU.readString();
                    abf.wfS = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 7:
                    abf.desc = aVar3.BTU.readString();
                    abf.wfT = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 8:
                    abf.whH = aVar3.BTU.ve();
                    abf.whI = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abe abe = new abe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abe.populateBuilderWithField(aVar4, abe, a.getNextFieldNumber(aVar4))) {
                        }
                        abf.whC = abe;
                    }
                    abf.whD = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 11:
                    abf.lgR = aVar3.BTU.ve();
                    abf.whL = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abo abo = new abo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abo.populateBuilderWithField(aVar4, abo, a.getNextFieldNumber(aVar4))) {
                        }
                        abf.whE = abo;
                    }
                    abf.whF = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 13:
                    abf.version = aVar3.BTU.vd();
                    abf.wix = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aaz aaz = new aaz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aaz.populateBuilderWithField(aVar4, aaz, a.getNextFieldNumber(aVar4))) {
                        }
                        abf.vzK = aaz;
                    }
                    abf.whM = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aap aap = new aap();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aap.populateBuilderWithField(aVar4, aap, a.getNextFieldNumber(aVar4))) {
                        }
                        abf.whN = aap;
                    }
                    abf.whO = true;
                    AppMethodBeat.o(51405);
                    return 0;
                case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    abf.whJ = aVar3.BTU.vd();
                    abf.whK = true;
                    AppMethodBeat.o(51405);
                    return 0;
                default:
                    AppMethodBeat.o(51405);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51405);
            return -1;
        }
    }
}
