package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class km extends a {
    public boolean vNA;
    public int vNB;
    public boolean vNC;
    public hf vND;
    public boolean vNE;
    public String vNb;
    public int vNt;
    public int vNu;
    public int vNv;
    public int vNw;
    public long vNx;
    public long vNy;
    public int vNz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11710);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vNb == null) {
                bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(11710);
                throw bVar;
            }
            if (this.vNb != null) {
                aVar.e(1, this.vNb);
            }
            aVar.iz(2, this.vNt);
            aVar.iz(3, this.vNu);
            aVar.iz(4, this.vNv);
            aVar.iz(5, this.vNw);
            aVar.ai(6, this.vNx);
            aVar.ai(7, this.vNy);
            aVar.iz(8, this.vNz);
            aVar.aO(9, this.vNA);
            aVar.iz(10, this.vNB);
            aVar.aO(11, this.vNC);
            if (this.vND != null) {
                aVar.iy(12, this.vND.computeSize());
                this.vND.writeFields(aVar);
            }
            aVar.aO(13, this.vNE);
            AppMethodBeat.o(11710);
            return 0;
        } else if (i == 1) {
            if (this.vNb != null) {
                f = e.a.a.b.b.a.f(1, this.vNb) + 0;
            } else {
                f = 0;
            }
            f = (((((((((f + e.a.a.b.b.a.bs(2, this.vNt)) + e.a.a.b.b.a.bs(3, this.vNu)) + e.a.a.b.b.a.bs(4, this.vNv)) + e.a.a.b.b.a.bs(5, this.vNw)) + e.a.a.b.b.a.o(6, this.vNx)) + e.a.a.b.b.a.o(7, this.vNy)) + e.a.a.b.b.a.bs(8, this.vNz)) + (e.a.a.b.b.a.fv(9) + 1)) + e.a.a.b.b.a.bs(10, this.vNB)) + (e.a.a.b.b.a.fv(11) + 1);
            if (this.vND != null) {
                f += e.a.a.a.ix(12, this.vND.computeSize());
            }
            int fv = f + (e.a.a.b.b.a.fv(13) + 1);
            AppMethodBeat.o(11710);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.vNb == null) {
                bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(11710);
                throw bVar;
            }
            AppMethodBeat.o(11710);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            km kmVar = (km) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    kmVar.vNb = aVar3.BTU.readString();
                    AppMethodBeat.o(11710);
                    return 0;
                case 2:
                    kmVar.vNt = aVar3.BTU.vd();
                    AppMethodBeat.o(11710);
                    return 0;
                case 3:
                    kmVar.vNu = aVar3.BTU.vd();
                    AppMethodBeat.o(11710);
                    return 0;
                case 4:
                    kmVar.vNv = aVar3.BTU.vd();
                    AppMethodBeat.o(11710);
                    return 0;
                case 5:
                    kmVar.vNw = aVar3.BTU.vd();
                    AppMethodBeat.o(11710);
                    return 0;
                case 6:
                    kmVar.vNx = aVar3.BTU.ve();
                    AppMethodBeat.o(11710);
                    return 0;
                case 7:
                    kmVar.vNy = aVar3.BTU.ve();
                    AppMethodBeat.o(11710);
                    return 0;
                case 8:
                    kmVar.vNz = aVar3.BTU.vd();
                    AppMethodBeat.o(11710);
                    return 0;
                case 9:
                    kmVar.vNA = aVar3.BTU.ehX();
                    AppMethodBeat.o(11710);
                    return 0;
                case 10:
                    kmVar.vNB = aVar3.BTU.vd();
                    AppMethodBeat.o(11710);
                    return 0;
                case 11:
                    kmVar.vNC = aVar3.BTU.ehX();
                    AppMethodBeat.o(11710);
                    return 0;
                case 12:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hf hfVar = new hf();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hfVar.populateBuilderWithField(aVar4, hfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kmVar.vND = hfVar;
                    }
                    AppMethodBeat.o(11710);
                    return 0;
                case 13:
                    kmVar.vNE = aVar3.BTU.ehX();
                    AppMethodBeat.o(11710);
                    return 0;
                default:
                    AppMethodBeat.o(11710);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11710);
            return -1;
        }
    }
}
