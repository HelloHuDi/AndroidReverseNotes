package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class j extends a {
    public a kLA;
    public c kLw;
    public d kLx;
    public f kLy;
    public k kLz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35536);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.kLw == null) {
                bVar = new b("Not all required fields were included: base_info");
                AppMethodBeat.o(35536);
                throw bVar;
            }
            if (this.kLw != null) {
                aVar.iy(1, this.kLw.computeSize());
                this.kLw.writeFields(aVar);
            }
            if (this.kLx != null) {
                aVar.iy(2, this.kLx.computeSize());
                this.kLx.writeFields(aVar);
            }
            if (this.kLy != null) {
                aVar.iy(3, this.kLy.computeSize());
                this.kLy.writeFields(aVar);
            }
            if (this.kLz != null) {
                aVar.iy(4, this.kLz.computeSize());
                this.kLz.writeFields(aVar);
            }
            if (this.kLA != null) {
                aVar.iy(5, this.kLA.computeSize());
                this.kLA.writeFields(aVar);
            }
            AppMethodBeat.o(35536);
            return 0;
        } else if (i == 1) {
            if (this.kLw != null) {
                ix = e.a.a.a.ix(1, this.kLw.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.kLx != null) {
                ix += e.a.a.a.ix(2, this.kLx.computeSize());
            }
            if (this.kLy != null) {
                ix += e.a.a.a.ix(3, this.kLy.computeSize());
            }
            if (this.kLz != null) {
                ix += e.a.a.a.ix(4, this.kLz.computeSize());
            }
            if (this.kLA != null) {
                ix += e.a.a.a.ix(5, this.kLA.computeSize());
            }
            AppMethodBeat.o(35536);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.kLw == null) {
                bVar = new b("Not all required fields were included: base_info");
                AppMethodBeat.o(35536);
                throw bVar;
            }
            AppMethodBeat.o(35536);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
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
                        c cVar = new c();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cVar.populateBuilderWithField(aVar4, cVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.kLw = cVar;
                    }
                    AppMethodBeat.o(35536);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.kLx = dVar;
                    }
                    AppMethodBeat.o(35536);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        f fVar = new f();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.kLy = fVar;
                    }
                    AppMethodBeat.o(35536);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        k kVar = new k();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kVar.populateBuilderWithField(aVar4, kVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.kLz = kVar;
                    }
                    AppMethodBeat.o(35536);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.populateBuilderWithField(aVar4, aVar5, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.kLA = aVar5;
                    }
                    AppMethodBeat.o(35536);
                    return 0;
                default:
                    AppMethodBeat.o(35536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35536);
            return -1;
        }
    }
}
