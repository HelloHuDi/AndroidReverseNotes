package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class db extends a {
    public String nbs;
    public fq vFj;
    public LinkedList<ary> vFk = new LinkedList();

    public db() {
        AppMethodBeat.i(94504);
        AppMethodBeat.o(94504);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94505);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vFj == null) {
                bVar = new b("Not all required fields were included: ArtisAuthor");
                AppMethodBeat.o(94505);
                throw bVar;
            }
            if (this.vFj != null) {
                aVar.iy(1, this.vFj.computeSize());
                this.vFj.writeFields(aVar);
            }
            aVar.e(2, 8, this.vFk);
            if (this.nbs != null) {
                aVar.e(3, this.nbs);
            }
            AppMethodBeat.o(94505);
            return 0;
        } else if (i == 1) {
            if (this.vFj != null) {
                ix = e.a.a.a.ix(1, this.vFj.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.vFk);
            if (this.nbs != null) {
                ix += e.a.a.b.b.a.f(3, this.nbs);
            }
            AppMethodBeat.o(94505);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vFk.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vFj == null) {
                bVar = new b("Not all required fields were included: ArtisAuthor");
                AppMethodBeat.o(94505);
                throw bVar;
            }
            AppMethodBeat.o(94505);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            db dbVar = (db) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fq fqVar = new fq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fqVar.populateBuilderWithField(aVar4, fqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dbVar.vFj = fqVar;
                    }
                    AppMethodBeat.o(94505);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ary ary = new ary();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ary.populateBuilderWithField(aVar4, ary, a.getNextFieldNumber(aVar4))) {
                        }
                        dbVar.vFk.add(ary);
                    }
                    AppMethodBeat.o(94505);
                    return 0;
                case 3:
                    dbVar.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(94505);
                    return 0;
                default:
                    AppMethodBeat.o(94505);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94505);
            return -1;
        }
    }
}
