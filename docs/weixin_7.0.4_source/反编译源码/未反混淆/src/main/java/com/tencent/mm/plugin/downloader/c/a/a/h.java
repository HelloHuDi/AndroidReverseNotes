package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class h extends a {
    public d kKy;
    public String kKz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35516);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kKy == null) {
                bVar = new b("Not all required fields were included: app_info");
                AppMethodBeat.o(35516);
                throw bVar;
            }
            if (this.kKy != null) {
                aVar.iy(1, this.kKy.computeSize());
                this.kKy.writeFields(aVar);
            }
            if (this.kKz != null) {
                aVar.e(2, this.kKz);
            }
            AppMethodBeat.o(35516);
            return 0;
        } else if (i == 1) {
            if (this.kKy != null) {
                ix = e.a.a.a.ix(1, this.kKy.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kKz != null) {
                ix += e.a.a.b.b.a.f(2, this.kKz);
            }
            AppMethodBeat.o(35516);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.kKy == null) {
                bVar = new b("Not all required fields were included: app_info");
                AppMethodBeat.o(35516);
                throw bVar;
            }
            AppMethodBeat.o(35516);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.kKy = dVar;
                    }
                    AppMethodBeat.o(35516);
                    return 0;
                case 2:
                    hVar.kKz = aVar3.BTU.readString();
                    AppMethodBeat.o(35516);
                    return 0;
                default:
                    AppMethodBeat.o(35516);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35516);
            return -1;
        }
    }
}
