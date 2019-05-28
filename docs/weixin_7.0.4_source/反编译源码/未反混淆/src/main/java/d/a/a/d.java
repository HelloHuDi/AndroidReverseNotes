package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class d extends a {
    public String BTs;
    public String BTt;
    public int BTu;
    public f BTv;
    public String url;
    public String wqf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(57009);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.BTs != null) {
                aVar.e(1, this.BTs);
            }
            if (this.BTt != null) {
                aVar.e(2, this.BTt);
            }
            aVar.iz(3, this.BTu);
            if (this.wqf != null) {
                aVar.e(4, this.wqf);
            }
            if (this.url != null) {
                aVar.e(5, this.url);
            }
            if (this.BTv != null) {
                aVar.iy(6, this.BTv.computeSize());
                this.BTv.writeFields(aVar);
            }
            AppMethodBeat.o(57009);
            return 0;
        } else if (i == 1) {
            if (this.BTs != null) {
                f = e.a.a.b.b.a.f(1, this.BTs) + 0;
            } else {
                f = 0;
            }
            if (this.BTt != null) {
                f += e.a.a.b.b.a.f(2, this.BTt);
            }
            f += e.a.a.b.b.a.bs(3, this.BTu);
            if (this.wqf != null) {
                f += e.a.a.b.b.a.f(4, this.wqf);
            }
            if (this.url != null) {
                f += e.a.a.b.b.a.f(5, this.url);
            }
            if (this.BTv != null) {
                f += e.a.a.a.ix(6, this.BTv.computeSize());
            }
            AppMethodBeat.o(57009);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(57009);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.BTs = aVar3.BTU.readString();
                    AppMethodBeat.o(57009);
                    return 0;
                case 2:
                    dVar.BTt = aVar3.BTU.readString();
                    AppMethodBeat.o(57009);
                    return 0;
                case 3:
                    dVar.BTu = aVar3.BTU.vd();
                    AppMethodBeat.o(57009);
                    return 0;
                case 4:
                    dVar.wqf = aVar3.BTU.readString();
                    AppMethodBeat.o(57009);
                    return 0;
                case 5:
                    dVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(57009);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        f fVar = new f();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.BTv = fVar;
                    }
                    AppMethodBeat.o(57009);
                    return 0;
                default:
                    AppMethodBeat.o(57009);
                    return -1;
            }
        } else {
            AppMethodBeat.o(57009);
            return -1;
        }
    }
}
