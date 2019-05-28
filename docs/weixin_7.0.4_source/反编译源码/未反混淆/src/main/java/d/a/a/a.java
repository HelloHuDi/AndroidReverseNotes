package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bt.a {
    public String BTs;
    public String BTt;
    public int BTu;
    public f BTv;
    public String url;
    public String wqf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(57005);
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
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            if (this.BTv != null) {
                aVar.iy(5, this.BTv.computeSize());
                this.BTv.writeFields(aVar);
            }
            if (this.wqf != null) {
                aVar.e(6, this.wqf);
            }
            AppMethodBeat.o(57005);
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
            if (this.url != null) {
                f += e.a.a.b.b.a.f(4, this.url);
            }
            if (this.BTv != null) {
                f += e.a.a.a.ix(5, this.BTv.computeSize());
            }
            if (this.wqf != null) {
                f += e.a.a.b.b.a.f(6, this.wqf);
            }
            AppMethodBeat.o(57005);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(57005);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.BTs = aVar3.BTU.readString();
                    AppMethodBeat.o(57005);
                    return 0;
                case 2:
                    aVar4.BTt = aVar3.BTU.readString();
                    AppMethodBeat.o(57005);
                    return 0;
                case 3:
                    aVar4.BTu = aVar3.BTU.vd();
                    AppMethodBeat.o(57005);
                    return 0;
                case 4:
                    aVar4.url = aVar3.BTU.readString();
                    AppMethodBeat.o(57005);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        f fVar = new f();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fVar.populateBuilderWithField(aVar5, fVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.BTv = fVar;
                    }
                    AppMethodBeat.o(57005);
                    return 0;
                case 6:
                    aVar4.wqf = aVar3.BTU.readString();
                    AppMethodBeat.o(57005);
                    return 0;
                default:
                    AppMethodBeat.o(57005);
                    return -1;
            }
        } else {
            AppMethodBeat.o(57005);
            return -1;
        }
    }
}
