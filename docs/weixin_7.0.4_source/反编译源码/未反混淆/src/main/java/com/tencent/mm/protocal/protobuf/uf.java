package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class uf extends a {
    public String Desc;
    public String Title;
    public String Url;
    public int wbJ;
    public LinkedList<bau> wbK = new LinkedList();
    public int wbL;
    public String wbM;
    public azu wbN;

    public uf() {
        AppMethodBeat.i(94516);
        AppMethodBeat.o(94516);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94517);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Desc != null) {
                aVar.e(1, this.Desc);
            }
            aVar.iz(2, this.wbJ);
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            if (this.Url != null) {
                aVar.e(4, this.Url);
            }
            aVar.e(5, 8, this.wbK);
            aVar.iz(6, this.wbL);
            if (this.wbM != null) {
                aVar.e(7, this.wbM);
            }
            if (this.wbN != null) {
                aVar.iy(8, this.wbN.computeSize());
                this.wbN.writeFields(aVar);
            }
            AppMethodBeat.o(94517);
            return 0;
        } else if (i == 1) {
            if (this.Desc != null) {
                f = e.a.a.b.b.a.f(1, this.Desc) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wbJ);
            if (this.Title != null) {
                f += e.a.a.b.b.a.f(3, this.Title);
            }
            if (this.Url != null) {
                f += e.a.a.b.b.a.f(4, this.Url);
            }
            f = (f + e.a.a.a.c(5, 8, this.wbK)) + e.a.a.b.b.a.bs(6, this.wbL);
            if (this.wbM != null) {
                f += e.a.a.b.b.a.f(7, this.wbM);
            }
            if (this.wbN != null) {
                f += e.a.a.a.ix(8, this.wbN.computeSize());
            }
            AppMethodBeat.o(94517);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wbK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94517);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            uf ufVar = (uf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ufVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(94517);
                    return 0;
                case 2:
                    ufVar.wbJ = aVar3.BTU.vd();
                    AppMethodBeat.o(94517);
                    return 0;
                case 3:
                    ufVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(94517);
                    return 0;
                case 4:
                    ufVar.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(94517);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bau bau = new bau();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bau.populateBuilderWithField(aVar4, bau, a.getNextFieldNumber(aVar4))) {
                        }
                        ufVar.wbK.add(bau);
                    }
                    AppMethodBeat.o(94517);
                    return 0;
                case 6:
                    ufVar.wbL = aVar3.BTU.vd();
                    AppMethodBeat.o(94517);
                    return 0;
                case 7:
                    ufVar.wbM = aVar3.BTU.readString();
                    AppMethodBeat.o(94517);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        azu azu = new azu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azu.populateBuilderWithField(aVar4, azu, a.getNextFieldNumber(aVar4))) {
                        }
                        ufVar.wbN = azu;
                    }
                    AppMethodBeat.o(94517);
                    return 0;
                default:
                    AppMethodBeat.o(94517);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94517);
            return -1;
        }
    }
}
