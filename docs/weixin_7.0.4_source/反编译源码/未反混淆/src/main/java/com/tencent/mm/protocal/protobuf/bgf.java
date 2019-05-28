package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bgf extends a {
    public String app_id;
    public int cvd;
    public int dtS;
    public String geZ;
    public String hHV;
    public String nickname;
    public int type;
    public String vEP;
    public String wJW;
    public String wJX;
    public String wKh;
    public String wKj;
    public String wKk;
    public String wKl;
    public String wKm;
    public bgg wKn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80132);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.geZ != null) {
                aVar.e(1, this.geZ);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            aVar.iz(3, this.type);
            if (this.hHV != null) {
                aVar.e(4, this.hHV);
            }
            if (this.wJW != null) {
                aVar.e(5, this.wJW);
            }
            if (this.wJX != null) {
                aVar.e(6, this.wJX);
            }
            aVar.iz(7, this.cvd);
            if (this.wKj != null) {
                aVar.e(8, this.wKj);
            }
            if (this.wKk != null) {
                aVar.e(9, this.wKk);
            }
            if (this.wKl != null) {
                aVar.e(10, this.wKl);
            }
            if (this.wKm != null) {
                aVar.e(11, this.wKm);
            }
            if (this.wKn != null) {
                aVar.iy(12, this.wKn.computeSize());
                this.wKn.writeFields(aVar);
            }
            if (this.vEP != null) {
                aVar.e(13, this.vEP);
            }
            if (this.app_id != null) {
                aVar.e(14, this.app_id);
            }
            aVar.iz(15, this.dtS);
            if (this.wKh != null) {
                aVar.e(16, this.wKh);
            }
            AppMethodBeat.o(80132);
            return 0;
        } else if (i == 1) {
            if (this.geZ != null) {
                f = e.a.a.b.b.a.f(1, this.geZ) + 0;
            } else {
                f = 0;
            }
            if (this.nickname != null) {
                f += e.a.a.b.b.a.f(2, this.nickname);
            }
            f += e.a.a.b.b.a.bs(3, this.type);
            if (this.hHV != null) {
                f += e.a.a.b.b.a.f(4, this.hHV);
            }
            if (this.wJW != null) {
                f += e.a.a.b.b.a.f(5, this.wJW);
            }
            if (this.wJX != null) {
                f += e.a.a.b.b.a.f(6, this.wJX);
            }
            f += e.a.a.b.b.a.bs(7, this.cvd);
            if (this.wKj != null) {
                f += e.a.a.b.b.a.f(8, this.wKj);
            }
            if (this.wKk != null) {
                f += e.a.a.b.b.a.f(9, this.wKk);
            }
            if (this.wKl != null) {
                f += e.a.a.b.b.a.f(10, this.wKl);
            }
            if (this.wKm != null) {
                f += e.a.a.b.b.a.f(11, this.wKm);
            }
            if (this.wKn != null) {
                f += e.a.a.a.ix(12, this.wKn.computeSize());
            }
            if (this.vEP != null) {
                f += e.a.a.b.b.a.f(13, this.vEP);
            }
            if (this.app_id != null) {
                f += e.a.a.b.b.a.f(14, this.app_id);
            }
            f += e.a.a.b.b.a.bs(15, this.dtS);
            if (this.wKh != null) {
                f += e.a.a.b.b.a.f(16, this.wKh);
            }
            AppMethodBeat.o(80132);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80132);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bgf bgf = (bgf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bgf.geZ = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 2:
                    bgf.nickname = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 3:
                    bgf.type = aVar3.BTU.vd();
                    AppMethodBeat.o(80132);
                    return 0;
                case 4:
                    bgf.hHV = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 5:
                    bgf.wJW = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 6:
                    bgf.wJX = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 7:
                    bgf.cvd = aVar3.BTU.vd();
                    AppMethodBeat.o(80132);
                    return 0;
                case 8:
                    bgf.wKj = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 9:
                    bgf.wKk = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 10:
                    bgf.wKl = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 11:
                    bgf.wKm = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 12:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bgg bgg = new bgg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bgg.populateBuilderWithField(aVar4, bgg, a.getNextFieldNumber(aVar4))) {
                        }
                        bgf.wKn = bgg;
                    }
                    AppMethodBeat.o(80132);
                    return 0;
                case 13:
                    bgf.vEP = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 14:
                    bgf.app_id = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                case 15:
                    bgf.dtS = aVar3.BTU.vd();
                    AppMethodBeat.o(80132);
                    return 0;
                case 16:
                    bgf.wKh = aVar3.BTU.readString();
                    AppMethodBeat.o(80132);
                    return 0;
                default:
                    AppMethodBeat.o(80132);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80132);
            return -1;
        }
    }
}
