package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class c extends a {
    public int BTA;
    public int BTB;
    public int BTC;
    public e BTD;
    public String BTE;
    public b BTF;
    public String wdr;
    public String wev;
    public LinkedList<g> wew = new LinkedList();
    public int wex;
    public a wey;

    public c() {
        AppMethodBeat.i(57007);
        AppMethodBeat.o(57007);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(57008);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.wew);
            aVar.iz(2, this.BTA);
            if (this.wdr != null) {
                aVar.e(3, this.wdr);
            }
            aVar.iz(4, this.wex);
            if (this.wey != null) {
                aVar.iy(5, this.wey.computeSize());
                this.wey.writeFields(aVar);
            }
            if (this.wev != null) {
                aVar.e(6, this.wev);
            }
            aVar.iz(7, this.BTB);
            aVar.iz(8, this.BTC);
            if (this.BTD != null) {
                aVar.iy(9, this.BTD.computeSize());
                this.BTD.writeFields(aVar);
            }
            if (this.BTE != null) {
                aVar.e(10, this.BTE);
            }
            if (this.BTF != null) {
                aVar.iy(11, this.BTF.computeSize());
                this.BTF.writeFields(aVar);
            }
            AppMethodBeat.o(57008);
            return 0;
        } else if (i == 1) {
            c = (e.a.a.a.c(1, 8, this.wew) + 0) + e.a.a.b.b.a.bs(2, this.BTA);
            if (this.wdr != null) {
                c += e.a.a.b.b.a.f(3, this.wdr);
            }
            c += e.a.a.b.b.a.bs(4, this.wex);
            if (this.wey != null) {
                c += e.a.a.a.ix(5, this.wey.computeSize());
            }
            if (this.wev != null) {
                c += e.a.a.b.b.a.f(6, this.wev);
            }
            c = (c + e.a.a.b.b.a.bs(7, this.BTB)) + e.a.a.b.b.a.bs(8, this.BTC);
            if (this.BTD != null) {
                c += e.a.a.a.ix(9, this.BTD.computeSize());
            }
            if (this.BTE != null) {
                c += e.a.a.b.b.a.f(10, this.BTE);
            }
            if (this.BTF != null) {
                c += e.a.a.a.ix(11, this.BTF.computeSize());
            }
            AppMethodBeat.o(57008);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wew.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(57008);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
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
                        g gVar = new g();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.wew.add(gVar);
                    }
                    AppMethodBeat.o(57008);
                    return 0;
                case 2:
                    cVar.BTA = aVar3.BTU.vd();
                    AppMethodBeat.o(57008);
                    return 0;
                case 3:
                    cVar.wdr = aVar3.BTU.readString();
                    AppMethodBeat.o(57008);
                    return 0;
                case 4:
                    cVar.wex = aVar3.BTU.vd();
                    AppMethodBeat.o(57008);
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
                        cVar.wey = aVar5;
                    }
                    AppMethodBeat.o(57008);
                    return 0;
                case 6:
                    cVar.wev = aVar3.BTU.readString();
                    AppMethodBeat.o(57008);
                    return 0;
                case 7:
                    cVar.BTB = aVar3.BTU.vd();
                    AppMethodBeat.o(57008);
                    return 0;
                case 8:
                    cVar.BTC = aVar3.BTU.vd();
                    AppMethodBeat.o(57008);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.BTD = eVar;
                    }
                    AppMethodBeat.o(57008);
                    return 0;
                case 10:
                    cVar.BTE = aVar3.BTU.readString();
                    AppMethodBeat.o(57008);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        b bVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.BTF = bVar;
                    }
                    AppMethodBeat.o(57008);
                    return 0;
                default:
                    AppMethodBeat.o(57008);
                    return -1;
            }
        } else {
            AppMethodBeat.o(57008);
            return -1;
        }
    }
}
