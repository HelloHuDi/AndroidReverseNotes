package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class i extends a {
    public String egm;
    public long kKP;
    public String kKT;
    public String kKW;
    public l kLu;
    public String kLv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35535);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.egm == null) {
                bVar = new b("Not all required fields were included: download_url");
                AppMethodBeat.o(35535);
                throw bVar;
            }
            if (this.egm != null) {
                aVar.e(1, this.egm);
            }
            aVar.ai(2, this.kKP);
            if (this.kLu != null) {
                aVar.iy(3, this.kLu.computeSize());
                this.kLu.writeFields(aVar);
            }
            if (this.kLv != null) {
                aVar.e(4, this.kLv);
            }
            if (this.kKW != null) {
                aVar.e(5, this.kKW);
            }
            if (this.kKT != null) {
                aVar.e(6, this.kKT);
            }
            AppMethodBeat.o(35535);
            return 0;
        } else if (i == 1) {
            if (this.egm != null) {
                f = e.a.a.b.b.a.f(1, this.egm) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.o(2, this.kKP);
            if (this.kLu != null) {
                f += e.a.a.a.ix(3, this.kLu.computeSize());
            }
            if (this.kLv != null) {
                f += e.a.a.b.b.a.f(4, this.kLv);
            }
            if (this.kKW != null) {
                f += e.a.a.b.b.a.f(5, this.kKW);
            }
            if (this.kKT != null) {
                f += e.a.a.b.b.a.f(6, this.kKT);
            }
            AppMethodBeat.o(35535);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.egm == null) {
                bVar = new b("Not all required fields were included: download_url");
                AppMethodBeat.o(35535);
                throw bVar;
            }
            AppMethodBeat.o(35535);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.egm = aVar3.BTU.readString();
                    AppMethodBeat.o(35535);
                    return 0;
                case 2:
                    iVar.kKP = aVar3.BTU.ve();
                    AppMethodBeat.o(35535);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        l lVar = new l();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = lVar.populateBuilderWithField(aVar4, lVar, a.getNextFieldNumber(aVar4))) {
                        }
                        iVar.kLu = lVar;
                    }
                    AppMethodBeat.o(35535);
                    return 0;
                case 4:
                    iVar.kLv = aVar3.BTU.readString();
                    AppMethodBeat.o(35535);
                    return 0;
                case 5:
                    iVar.kKW = aVar3.BTU.readString();
                    AppMethodBeat.o(35535);
                    return 0;
                case 6:
                    iVar.kKT = aVar3.BTU.readString();
                    AppMethodBeat.o(35535);
                    return 0;
                default:
                    AppMethodBeat.o(35535);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35535);
            return -1;
        }
    }
}
