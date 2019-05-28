package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class i extends a {
    public String ncH;
    public String pcU;
    public double pcV;
    public String pcW;
    public int pcX;
    public String pcY;
    public int pcZ;
    public String pda;
    public int pdb;
    public int pdc;
    public String pdd;
    public String pde;
    public String pdf;
    public String pdg;
    public String pdh;
    public int pdi;
    public LinkedList<k> pdj = new LinkedList();
    public String pdk;
    public String pdl;
    public double pdm;
    public String pdn;

    public i() {
        AppMethodBeat.i(56618);
        AppMethodBeat.o(56618);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56619);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pcU != null) {
                aVar.e(1, this.pcU);
            }
            aVar.f(2, this.pcV);
            if (this.pcW != null) {
                aVar.e(3, this.pcW);
            }
            aVar.iz(4, this.pcX);
            if (this.pcY != null) {
                aVar.e(5, this.pcY);
            }
            aVar.iz(6, this.pcZ);
            if (this.pda != null) {
                aVar.e(7, this.pda);
            }
            aVar.iz(8, this.pdb);
            aVar.iz(9, this.pdc);
            if (this.pdd != null) {
                aVar.e(10, this.pdd);
            }
            if (this.ncH != null) {
                aVar.e(11, this.ncH);
            }
            if (this.pde != null) {
                aVar.e(12, this.pde);
            }
            if (this.pdf != null) {
                aVar.e(13, this.pdf);
            }
            if (this.pdg != null) {
                aVar.e(14, this.pdg);
            }
            if (this.pdh != null) {
                aVar.e(15, this.pdh);
            }
            aVar.iz(16, this.pdi);
            aVar.e(17, 8, this.pdj);
            if (this.pdk != null) {
                aVar.e(18, this.pdk);
            }
            if (this.pdl != null) {
                aVar.e(19, this.pdl);
            }
            aVar.f(20, this.pdm);
            if (this.pdn != null) {
                aVar.e(21, this.pdn);
            }
            AppMethodBeat.o(56619);
            return 0;
        } else if (i == 1) {
            if (this.pcU != null) {
                f = e.a.a.b.b.a.f(1, this.pcU) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.fv(2) + 8;
            if (this.pcW != null) {
                f += e.a.a.b.b.a.f(3, this.pcW);
            }
            f += e.a.a.b.b.a.bs(4, this.pcX);
            if (this.pcY != null) {
                f += e.a.a.b.b.a.f(5, this.pcY);
            }
            f += e.a.a.b.b.a.bs(6, this.pcZ);
            if (this.pda != null) {
                f += e.a.a.b.b.a.f(7, this.pda);
            }
            f = (f + e.a.a.b.b.a.bs(8, this.pdb)) + e.a.a.b.b.a.bs(9, this.pdc);
            if (this.pdd != null) {
                f += e.a.a.b.b.a.f(10, this.pdd);
            }
            if (this.ncH != null) {
                f += e.a.a.b.b.a.f(11, this.ncH);
            }
            if (this.pde != null) {
                f += e.a.a.b.b.a.f(12, this.pde);
            }
            if (this.pdf != null) {
                f += e.a.a.b.b.a.f(13, this.pdf);
            }
            if (this.pdg != null) {
                f += e.a.a.b.b.a.f(14, this.pdg);
            }
            if (this.pdh != null) {
                f += e.a.a.b.b.a.f(15, this.pdh);
            }
            f = (f + e.a.a.b.b.a.bs(16, this.pdi)) + e.a.a.a.c(17, 8, this.pdj);
            if (this.pdk != null) {
                f += e.a.a.b.b.a.f(18, this.pdk);
            }
            if (this.pdl != null) {
                f += e.a.a.b.b.a.f(19, this.pdl);
            }
            f += e.a.a.b.b.a.fv(20) + 8;
            if (this.pdn != null) {
                f += e.a.a.b.b.a.f(21, this.pdn);
            }
            AppMethodBeat.o(56619);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.pdj.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56619);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.pcU = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 2:
                    iVar.pcV = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56619);
                    return 0;
                case 3:
                    iVar.pcW = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 4:
                    iVar.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(56619);
                    return 0;
                case 5:
                    iVar.pcY = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 6:
                    iVar.pcZ = aVar3.BTU.vd();
                    AppMethodBeat.o(56619);
                    return 0;
                case 7:
                    iVar.pda = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 8:
                    iVar.pdb = aVar3.BTU.vd();
                    AppMethodBeat.o(56619);
                    return 0;
                case 9:
                    iVar.pdc = aVar3.BTU.vd();
                    AppMethodBeat.o(56619);
                    return 0;
                case 10:
                    iVar.pdd = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 11:
                    iVar.ncH = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 12:
                    iVar.pde = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 13:
                    iVar.pdf = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 14:
                    iVar.pdg = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 15:
                    iVar.pdh = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 16:
                    iVar.pdi = aVar3.BTU.vd();
                    AppMethodBeat.o(56619);
                    return 0;
                case 17:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        k kVar = new k();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = kVar.populateBuilderWithField(aVar4, kVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.pdj.add(kVar);
                    }
                    AppMethodBeat.o(56619);
                    return 0;
                case 18:
                    iVar.pdk = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 19:
                    iVar.pdl = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                case 20:
                    iVar.pdm = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56619);
                    return 0;
                case 21:
                    iVar.pdn = aVar3.BTU.readString();
                    AppMethodBeat.o(56619);
                    return 0;
                default:
                    AppMethodBeat.o(56619);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56619);
            return -1;
        }
    }
}
