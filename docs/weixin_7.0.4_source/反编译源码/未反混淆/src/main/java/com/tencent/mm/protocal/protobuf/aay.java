package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class aay extends a {
    public int cED;
    public String cIK;
    public String label;
    public double lat;
    public double lng;
    public boolean wih = false;
    public boolean wii = false;
    public boolean wij = false;
    public boolean wik = false;
    public boolean wil = false;

    public final aay D(double d) {
        this.lng = d;
        this.wih = true;
        return this;
    }

    public final aay E(double d) {
        this.lat = d;
        this.wii = true;
        return this;
    }

    public final aay LJ(int i) {
        this.cED = i;
        this.wij = true;
        return this;
    }

    public final aay alu(String str) {
        this.label = str;
        this.wik = true;
        return this;
    }

    public final aay alv(String str) {
        this.cIK = str;
        this.wil = true;
        return this;
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51399);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wih) {
                aVar.f(1, this.lng);
            }
            if (this.wii) {
                aVar.f(2, this.lat);
            }
            if (this.wij) {
                aVar.iz(3, this.cED);
            }
            if (this.label != null) {
                aVar.e(4, this.label);
            }
            if (this.cIK != null) {
                aVar.e(5, this.cIK);
            }
            AppMethodBeat.o(51399);
            return 0;
        } else if (i == 1) {
            if (this.wih) {
                fv = (e.a.a.b.b.a.fv(1) + 8) + 0;
            } else {
                fv = 0;
            }
            if (this.wii) {
                fv += e.a.a.b.b.a.fv(2) + 8;
            }
            if (this.wij) {
                fv += e.a.a.b.b.a.bs(3, this.cED);
            }
            if (this.label != null) {
                fv += e.a.a.b.b.a.f(4, this.label);
            }
            if (this.cIK != null) {
                fv += e.a.a.b.b.a.f(5, this.cIK);
            }
            AppMethodBeat.o(51399);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51399);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aay aay = (aay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aay.lng = Double.longBitsToDouble(aVar3.BTU.eib());
                    aay.wih = true;
                    AppMethodBeat.o(51399);
                    return 0;
                case 2:
                    aay.lat = Double.longBitsToDouble(aVar3.BTU.eib());
                    aay.wii = true;
                    AppMethodBeat.o(51399);
                    return 0;
                case 3:
                    aay.cED = aVar3.BTU.vd();
                    aay.wij = true;
                    AppMethodBeat.o(51399);
                    return 0;
                case 4:
                    aay.label = aVar3.BTU.readString();
                    aay.wik = true;
                    AppMethodBeat.o(51399);
                    return 0;
                case 5:
                    aay.cIK = aVar3.BTU.readString();
                    aay.wil = true;
                    AppMethodBeat.o(51399);
                    return 0;
                default:
                    AppMethodBeat.o(51399);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51399);
            return -1;
        }
    }
}
