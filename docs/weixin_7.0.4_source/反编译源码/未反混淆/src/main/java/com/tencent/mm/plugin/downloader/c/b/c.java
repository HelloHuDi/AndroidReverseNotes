package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class c extends a {
    public String csB;
    public String kKY;
    public String kKZ;
    public String kLa;
    public int kLb;
    public g kLc;
    public String kLd;
    public int status;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35527);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB == null) {
                bVar = new b("Not all required fields were included: appid");
                AppMethodBeat.o(35527);
                throw bVar;
            } else if (this.kKY == null) {
                bVar = new b("Not all required fields were included: app_name");
                AppMethodBeat.o(35527);
                throw bVar;
            } else {
                if (this.csB != null) {
                    aVar.e(1, this.csB);
                }
                if (this.kKY != null) {
                    aVar.e(2, this.kKY);
                }
                if (this.kKZ != null) {
                    aVar.e(3, this.kKZ);
                }
                if (this.kLa != null) {
                    aVar.e(4, this.kLa);
                }
                aVar.iz(5, this.kLb);
                aVar.iz(6, this.status);
                if (this.kLc != null) {
                    aVar.iy(7, this.kLc.computeSize());
                    this.kLc.writeFields(aVar);
                }
                if (this.kLd != null) {
                    aVar.e(8, this.kLd);
                }
                AppMethodBeat.o(35527);
                return 0;
            }
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.kKY != null) {
                f += e.a.a.b.b.a.f(2, this.kKY);
            }
            if (this.kKZ != null) {
                f += e.a.a.b.b.a.f(3, this.kKZ);
            }
            if (this.kLa != null) {
                f += e.a.a.b.b.a.f(4, this.kLa);
            }
            f = (f + e.a.a.b.b.a.bs(5, this.kLb)) + e.a.a.b.b.a.bs(6, this.status);
            if (this.kLc != null) {
                f += e.a.a.a.ix(7, this.kLc.computeSize());
            }
            if (this.kLd != null) {
                f += e.a.a.b.b.a.f(8, this.kLd);
            }
            AppMethodBeat.o(35527);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.csB == null) {
                bVar = new b("Not all required fields were included: appid");
                AppMethodBeat.o(35527);
                throw bVar;
            } else if (this.kKY == null) {
                bVar = new b("Not all required fields were included: app_name");
                AppMethodBeat.o(35527);
                throw bVar;
            } else {
                AppMethodBeat.o(35527);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(35527);
                    return 0;
                case 2:
                    cVar.kKY = aVar3.BTU.readString();
                    AppMethodBeat.o(35527);
                    return 0;
                case 3:
                    cVar.kKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(35527);
                    return 0;
                case 4:
                    cVar.kLa = aVar3.BTU.readString();
                    AppMethodBeat.o(35527);
                    return 0;
                case 5:
                    cVar.kLb = aVar3.BTU.vd();
                    AppMethodBeat.o(35527);
                    return 0;
                case 6:
                    cVar.status = aVar3.BTU.vd();
                    AppMethodBeat.o(35527);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        g gVar = new g();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.kLc = gVar;
                    }
                    AppMethodBeat.o(35527);
                    return 0;
                case 8:
                    cVar.kLd = aVar3.BTU.readString();
                    AppMethodBeat.o(35527);
                    return 0;
                default:
                    AppMethodBeat.o(35527);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35527);
            return -1;
        }
    }
}
