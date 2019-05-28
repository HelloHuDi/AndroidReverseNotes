package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.downloader.c.b.j;
import e.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public j kKr;
    public e kKs;
    public c kKt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35511);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kKr == null) {
                bVar = new b("Not all required fields were included: app_info");
                AppMethodBeat.o(35511);
                throw bVar;
            }
            if (this.kKr != null) {
                aVar.iy(1, this.kKr.computeSize());
                this.kKr.writeFields(aVar);
            }
            if (this.kKs != null) {
                aVar.iy(2, this.kKs.computeSize());
                this.kKs.writeFields(aVar);
            }
            if (this.kKt != null) {
                aVar.iy(3, this.kKt.computeSize());
                this.kKt.writeFields(aVar);
            }
            AppMethodBeat.o(35511);
            return 0;
        } else if (i == 1) {
            if (this.kKr != null) {
                ix = e.a.a.a.ix(1, this.kKr.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kKs != null) {
                ix += e.a.a.a.ix(2, this.kKs.computeSize());
            }
            if (this.kKt != null) {
                ix += e.a.a.a.ix(3, this.kKt.computeSize());
            }
            AppMethodBeat.o(35511);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.kKr == null) {
                bVar = new b("Not all required fields were included: app_info");
                AppMethodBeat.o(35511);
                throw bVar;
            }
            AppMethodBeat.o(35511);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
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
                        j jVar = new j();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jVar.populateBuilderWithField(aVar4, jVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.kKr = jVar;
                    }
                    AppMethodBeat.o(35511);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.kKs = eVar;
                    }
                    AppMethodBeat.o(35511);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c cVar = new c();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cVar.populateBuilderWithField(aVar4, cVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.kKt = cVar;
                    }
                    AppMethodBeat.o(35511);
                    return 0;
                default:
                    AppMethodBeat.o(35511);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35511);
            return -1;
        }
    }
}
