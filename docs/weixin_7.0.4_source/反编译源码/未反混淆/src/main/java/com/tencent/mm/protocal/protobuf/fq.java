package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class fq extends a {
    public String Name;
    public String Title;
    public String vEA;
    public fr vHA;
    public String vHz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94510);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHA == null) {
                bVar = new b("Not all required fields were included: ArtisIcon");
                AppMethodBeat.o(94510);
                throw bVar;
            }
            if (this.Name != null) {
                aVar.e(1, this.Name);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.vHz != null) {
                aVar.e(3, this.vHz);
            }
            if (this.vEA != null) {
                aVar.e(4, this.vEA);
            }
            if (this.vHA != null) {
                aVar.iy(5, this.vHA.computeSize());
                this.vHA.writeFields(aVar);
            }
            AppMethodBeat.o(94510);
            return 0;
        } else if (i == 1) {
            if (this.Name != null) {
                f = e.a.a.b.b.a.f(1, this.Name) + 0;
            } else {
                f = 0;
            }
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.vHz != null) {
                f += e.a.a.b.b.a.f(3, this.vHz);
            }
            if (this.vEA != null) {
                f += e.a.a.b.b.a.f(4, this.vEA);
            }
            if (this.vHA != null) {
                f += e.a.a.a.ix(5, this.vHA.computeSize());
            }
            AppMethodBeat.o(94510);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.vHA == null) {
                bVar = new b("Not all required fields were included: ArtisIcon");
                AppMethodBeat.o(94510);
                throw bVar;
            }
            AppMethodBeat.o(94510);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fq fqVar = (fq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fqVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(94510);
                    return 0;
                case 2:
                    fqVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(94510);
                    return 0;
                case 3:
                    fqVar.vHz = aVar3.BTU.readString();
                    AppMethodBeat.o(94510);
                    return 0;
                case 4:
                    fqVar.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(94510);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        fr frVar = new fr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = frVar.populateBuilderWithField(aVar4, frVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fqVar.vHA = frVar;
                    }
                    AppMethodBeat.o(94510);
                    return 0;
                default:
                    AppMethodBeat.o(94510);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94510);
            return -1;
        }
    }
}
