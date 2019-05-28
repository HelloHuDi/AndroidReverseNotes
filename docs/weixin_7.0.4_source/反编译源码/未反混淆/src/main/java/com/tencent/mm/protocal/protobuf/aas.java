package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class aas extends a {
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

    public final aas c(aat aat) {
        this.whw = aat;
        this.whx = true;
        return this;
    }

    public final aas a(aay aay) {
        this.why = aay;
        this.whz = true;
        return this;
    }

    public final aas a(abu abu) {
        this.whA = abu;
        this.whB = true;
        return this;
    }

    public final aas a(abe abe) {
        this.whC = abe;
        this.whD = true;
        return this;
    }

    public final aas a(abo abo) {
        this.whE = abo;
        this.whF = true;
        return this;
    }

    public final aas a(aap aap) {
        this.whN = aap;
        this.whO = true;
        return this;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51391);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.whw != null) {
                aVar.iy(1, this.whw.computeSize());
                this.whw.writeFields(aVar);
            }
            if (this.why != null) {
                aVar.iy(2, this.why.computeSize());
                this.why.writeFields(aVar);
            }
            if (this.whA != null) {
                aVar.iy(3, this.whA.computeSize());
                this.whA.writeFields(aVar);
            }
            if (this.whC != null) {
                aVar.iy(4, this.whC.computeSize());
                this.whC.writeFields(aVar);
            }
            if (this.whE != null) {
                aVar.iy(5, this.whE.computeSize());
                this.whE.writeFields(aVar);
            }
            if (this.hHV != null) {
                aVar.e(6, this.hHV);
            }
            if (this.title != null) {
                aVar.e(7, this.title);
            }
            if (this.desc != null) {
                aVar.e(8, this.desc);
            }
            if (this.whI) {
                aVar.ai(9, this.whH);
            }
            if (this.whK) {
                aVar.iz(101, this.whJ);
            }
            if (this.whL) {
                aVar.ai(11, this.lgR);
            }
            if (this.vzK != null) {
                aVar.iy(12, this.vzK.computeSize());
                this.vzK.writeFields(aVar);
            }
            if (this.whN != null) {
                aVar.iy(13, this.whN.computeSize());
                this.whN.writeFields(aVar);
            }
            AppMethodBeat.o(51391);
            return 0;
        } else if (i == 1) {
            if (this.whw != null) {
                ix = e.a.a.a.ix(1, this.whw.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.why != null) {
                ix += e.a.a.a.ix(2, this.why.computeSize());
            }
            if (this.whA != null) {
                ix += e.a.a.a.ix(3, this.whA.computeSize());
            }
            if (this.whC != null) {
                ix += e.a.a.a.ix(4, this.whC.computeSize());
            }
            if (this.whE != null) {
                ix += e.a.a.a.ix(5, this.whE.computeSize());
            }
            if (this.hHV != null) {
                ix += e.a.a.b.b.a.f(6, this.hHV);
            }
            if (this.title != null) {
                ix += e.a.a.b.b.a.f(7, this.title);
            }
            if (this.desc != null) {
                ix += e.a.a.b.b.a.f(8, this.desc);
            }
            if (this.whI) {
                ix += e.a.a.b.b.a.o(9, this.whH);
            }
            if (this.whK) {
                ix += e.a.a.b.b.a.bs(101, this.whJ);
            }
            if (this.whL) {
                ix += e.a.a.b.b.a.o(11, this.lgR);
            }
            if (this.vzK != null) {
                ix += e.a.a.a.ix(12, this.vzK.computeSize());
            }
            if (this.whN != null) {
                ix += e.a.a.a.ix(13, this.whN.computeSize());
            }
            AppMethodBeat.o(51391);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51391);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aas aas = (aas) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aat aat = new aat();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aat.populateBuilderWithField(aVar4, aat, a.getNextFieldNumber(aVar4))) {
                        }
                        aas.whw = aat;
                    }
                    aas.whx = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aay aay = new aay();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aay.populateBuilderWithField(aVar4, aay, a.getNextFieldNumber(aVar4))) {
                        }
                        aas.why = aay;
                    }
                    aas.whz = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abu abu = new abu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abu.populateBuilderWithField(aVar4, abu, a.getNextFieldNumber(aVar4))) {
                        }
                        aas.whA = abu;
                    }
                    aas.whB = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abe abe = new abe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abe.populateBuilderWithField(aVar4, abe, a.getNextFieldNumber(aVar4))) {
                        }
                        aas.whC = abe;
                    }
                    aas.whD = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abo abo = new abo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abo.populateBuilderWithField(aVar4, abo, a.getNextFieldNumber(aVar4))) {
                        }
                        aas.whE = abo;
                    }
                    aas.whF = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 6:
                    aas.hHV = aVar3.BTU.readString();
                    aas.whG = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 7:
                    aas.title = aVar3.BTU.readString();
                    aas.wfS = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 8:
                    aas.desc = aVar3.BTU.readString();
                    aas.wfT = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 9:
                    aas.whH = aVar3.BTU.ve();
                    aas.whI = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 11:
                    aas.lgR = aVar3.BTU.ve();
                    aas.whL = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aaz aaz = new aaz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aaz.populateBuilderWithField(aVar4, aaz, a.getNextFieldNumber(aVar4))) {
                        }
                        aas.vzK = aaz;
                    }
                    aas.whM = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aap aap = new aap();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aap.populateBuilderWithField(aVar4, aap, a.getNextFieldNumber(aVar4))) {
                        }
                        aas.whN = aap;
                    }
                    aas.whO = true;
                    AppMethodBeat.o(51391);
                    return 0;
                case 101:
                    aas.whJ = aVar3.BTU.vd();
                    aas.whK = true;
                    AppMethodBeat.o(51391);
                    return 0;
                default:
                    AppMethodBeat.o(51391);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51391);
            return -1;
        }
    }
}
