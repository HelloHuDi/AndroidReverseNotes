package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class oc extends a {
    public String vTE;
    public String vTF;
    public String vTG;
    public int vTH;
    public String vTI;
    public ny vTJ;
    public String vTK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89038);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vTE != null) {
                aVar.e(1, this.vTE);
            }
            if (this.vTF != null) {
                aVar.e(2, this.vTF);
            }
            if (this.vTG != null) {
                aVar.e(3, this.vTG);
            }
            aVar.iz(4, this.vTH);
            if (this.vTI != null) {
                aVar.e(5, this.vTI);
            }
            if (this.vTJ != null) {
                aVar.iy(6, this.vTJ.computeSize());
                this.vTJ.writeFields(aVar);
            }
            if (this.vTK != null) {
                aVar.e(7, this.vTK);
            }
            AppMethodBeat.o(89038);
            return 0;
        } else if (i == 1) {
            if (this.vTE != null) {
                f = e.a.a.b.b.a.f(1, this.vTE) + 0;
            } else {
                f = 0;
            }
            if (this.vTF != null) {
                f += e.a.a.b.b.a.f(2, this.vTF);
            }
            if (this.vTG != null) {
                f += e.a.a.b.b.a.f(3, this.vTG);
            }
            f += e.a.a.b.b.a.bs(4, this.vTH);
            if (this.vTI != null) {
                f += e.a.a.b.b.a.f(5, this.vTI);
            }
            if (this.vTJ != null) {
                f += e.a.a.a.ix(6, this.vTJ.computeSize());
            }
            if (this.vTK != null) {
                f += e.a.a.b.b.a.f(7, this.vTK);
            }
            AppMethodBeat.o(89038);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89038);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oc ocVar = (oc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ocVar.vTE = aVar3.BTU.readString();
                    AppMethodBeat.o(89038);
                    return 0;
                case 2:
                    ocVar.vTF = aVar3.BTU.readString();
                    AppMethodBeat.o(89038);
                    return 0;
                case 3:
                    ocVar.vTG = aVar3.BTU.readString();
                    AppMethodBeat.o(89038);
                    return 0;
                case 4:
                    ocVar.vTH = aVar3.BTU.vd();
                    AppMethodBeat.o(89038);
                    return 0;
                case 5:
                    ocVar.vTI = aVar3.BTU.readString();
                    AppMethodBeat.o(89038);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ny nyVar = new ny();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nyVar.populateBuilderWithField(aVar4, nyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ocVar.vTJ = nyVar;
                    }
                    AppMethodBeat.o(89038);
                    return 0;
                case 7:
                    ocVar.vTK = aVar3.BTU.readString();
                    AppMethodBeat.o(89038);
                    return 0;
                default:
                    AppMethodBeat.o(89038);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89038);
            return -1;
        }
    }
}
