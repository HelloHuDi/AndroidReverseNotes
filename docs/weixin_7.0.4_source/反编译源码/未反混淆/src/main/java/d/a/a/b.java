package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class b extends a {
    public f BTv;
    public String BTw;
    public String BTx;
    public String BTy;
    public String BTz;
    public String url;
    public int xis;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(57006);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.BTv != null) {
                aVar.iy(1, this.BTv.computeSize());
                this.BTv.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.BTw != null) {
                aVar.e(3, this.BTw);
            }
            if (this.BTx != null) {
                aVar.e(4, this.BTx);
            }
            aVar.iz(5, this.xis);
            if (this.BTy != null) {
                aVar.e(6, this.BTy);
            }
            if (this.BTz != null) {
                aVar.e(7, this.BTz);
            }
            AppMethodBeat.o(57006);
            return 0;
        } else if (i == 1) {
            if (this.BTv != null) {
                ix = e.a.a.a.ix(1, this.BTv.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(2, this.url);
            }
            if (this.BTw != null) {
                ix += e.a.a.b.b.a.f(3, this.BTw);
            }
            if (this.BTx != null) {
                ix += e.a.a.b.b.a.f(4, this.BTx);
            }
            ix += e.a.a.b.b.a.bs(5, this.xis);
            if (this.BTy != null) {
                ix += e.a.a.b.b.a.f(6, this.BTy);
            }
            if (this.BTz != null) {
                ix += e.a.a.b.b.a.f(7, this.BTz);
            }
            AppMethodBeat.o(57006);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(57006);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        f fVar = new f();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.BTv = fVar;
                    }
                    AppMethodBeat.o(57006);
                    return 0;
                case 2:
                    bVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(57006);
                    return 0;
                case 3:
                    bVar.BTw = aVar3.BTU.readString();
                    AppMethodBeat.o(57006);
                    return 0;
                case 4:
                    bVar.BTx = aVar3.BTU.readString();
                    AppMethodBeat.o(57006);
                    return 0;
                case 5:
                    bVar.xis = aVar3.BTU.vd();
                    AppMethodBeat.o(57006);
                    return 0;
                case 6:
                    bVar.BTy = aVar3.BTU.readString();
                    AppMethodBeat.o(57006);
                    return 0;
                case 7:
                    bVar.BTz = aVar3.BTU.readString();
                    AppMethodBeat.o(57006);
                    return 0;
                default:
                    AppMethodBeat.o(57006);
                    return -1;
            }
        } else {
            AppMethodBeat.o(57006);
            return -1;
        }
    }
}
