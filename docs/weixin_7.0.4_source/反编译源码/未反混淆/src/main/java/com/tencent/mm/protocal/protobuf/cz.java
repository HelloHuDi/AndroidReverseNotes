package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cz extends a {
    public int cIb;
    public int pOA;
    public String pPZ;
    public int scene;
    public String vFb;
    public String vFc;
    public String vFd;
    public abv vFe;
    public String vFf;
    public int vFg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56702);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vFb == null) {
                bVar = new b("Not all required fields were included: f2f_id");
                AppMethodBeat.o(56702);
                throw bVar;
            } else if (this.vFd == null) {
                bVar = new b("Not all required fields were included: payok_checksign");
                AppMethodBeat.o(56702);
                throw bVar;
            } else {
                if (this.vFb != null) {
                    aVar.e(1, this.vFb);
                }
                if (this.vFc != null) {
                    aVar.e(2, this.vFc);
                }
                aVar.iz(3, this.cIb);
                aVar.iz(4, this.pOA);
                aVar.iz(5, this.scene);
                if (this.vFd != null) {
                    aVar.e(6, this.vFd);
                }
                if (this.vFe != null) {
                    aVar.iy(7, this.vFe.computeSize());
                    this.vFe.writeFields(aVar);
                }
                if (this.vFf != null) {
                    aVar.e(8, this.vFf);
                }
                if (this.pPZ != null) {
                    aVar.e(9, this.pPZ);
                }
                aVar.iz(10, this.vFg);
                AppMethodBeat.o(56702);
                return 0;
            }
        } else if (i == 1) {
            if (this.vFb != null) {
                f = e.a.a.b.b.a.f(1, this.vFb) + 0;
            } else {
                f = 0;
            }
            if (this.vFc != null) {
                f += e.a.a.b.b.a.f(2, this.vFc);
            }
            f = ((f + e.a.a.b.b.a.bs(3, this.cIb)) + e.a.a.b.b.a.bs(4, this.pOA)) + e.a.a.b.b.a.bs(5, this.scene);
            if (this.vFd != null) {
                f += e.a.a.b.b.a.f(6, this.vFd);
            }
            if (this.vFe != null) {
                f += e.a.a.a.ix(7, this.vFe.computeSize());
            }
            if (this.vFf != null) {
                f += e.a.a.b.b.a.f(8, this.vFf);
            }
            if (this.pPZ != null) {
                f += e.a.a.b.b.a.f(9, this.pPZ);
            }
            int bs = f + e.a.a.b.b.a.bs(10, this.vFg);
            AppMethodBeat.o(56702);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.vFb == null) {
                bVar = new b("Not all required fields were included: f2f_id");
                AppMethodBeat.o(56702);
                throw bVar;
            } else if (this.vFd == null) {
                bVar = new b("Not all required fields were included: payok_checksign");
                AppMethodBeat.o(56702);
                throw bVar;
            } else {
                AppMethodBeat.o(56702);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cz czVar = (cz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    czVar.vFb = aVar3.BTU.readString();
                    AppMethodBeat.o(56702);
                    return 0;
                case 2:
                    czVar.vFc = aVar3.BTU.readString();
                    AppMethodBeat.o(56702);
                    return 0;
                case 3:
                    czVar.cIb = aVar3.BTU.vd();
                    AppMethodBeat.o(56702);
                    return 0;
                case 4:
                    czVar.pOA = aVar3.BTU.vd();
                    AppMethodBeat.o(56702);
                    return 0;
                case 5:
                    czVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(56702);
                    return 0;
                case 6:
                    czVar.vFd = aVar3.BTU.readString();
                    AppMethodBeat.o(56702);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        abv abv = new abv();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = abv.populateBuilderWithField(aVar4, abv, a.getNextFieldNumber(aVar4))) {
                        }
                        czVar.vFe = abv;
                    }
                    AppMethodBeat.o(56702);
                    return 0;
                case 8:
                    czVar.vFf = aVar3.BTU.readString();
                    AppMethodBeat.o(56702);
                    return 0;
                case 9:
                    czVar.pPZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56702);
                    return 0;
                case 10:
                    czVar.vFg = aVar3.BTU.vd();
                    AppMethodBeat.o(56702);
                    return 0;
                default:
                    AppMethodBeat.o(56702);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56702);
            return -1;
        }
    }
}
