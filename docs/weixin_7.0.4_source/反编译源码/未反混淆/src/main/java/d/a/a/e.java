package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.bt.b;
import java.util.LinkedList;

public final class e extends a {
    public String BTG;
    public String BTH;
    public String BTI;
    public String BTJ;
    public String BTK;
    public int BTL;
    public d BTM;
    public b BTN;
    public b BTO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(57010);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.BTG != null) {
                aVar.e(1, this.BTG);
            }
            if (this.BTH != null) {
                aVar.e(2, this.BTH);
            }
            if (this.BTI != null) {
                aVar.e(3, this.BTI);
            }
            if (this.BTJ != null) {
                aVar.e(4, this.BTJ);
            }
            if (this.BTK != null) {
                aVar.e(5, this.BTK);
            }
            aVar.iz(6, this.BTL);
            if (this.BTM != null) {
                aVar.iy(7, this.BTM.computeSize());
                this.BTM.writeFields(aVar);
            }
            if (this.BTN != null) {
                aVar.c(8, this.BTN);
            }
            if (this.BTO != null) {
                aVar.c(9, this.BTO);
            }
            AppMethodBeat.o(57010);
            return 0;
        } else if (i == 1) {
            if (this.BTG != null) {
                f = e.a.a.b.b.a.f(1, this.BTG) + 0;
            } else {
                f = 0;
            }
            if (this.BTH != null) {
                f += e.a.a.b.b.a.f(2, this.BTH);
            }
            if (this.BTI != null) {
                f += e.a.a.b.b.a.f(3, this.BTI);
            }
            if (this.BTJ != null) {
                f += e.a.a.b.b.a.f(4, this.BTJ);
            }
            if (this.BTK != null) {
                f += e.a.a.b.b.a.f(5, this.BTK);
            }
            f += e.a.a.b.b.a.bs(6, this.BTL);
            if (this.BTM != null) {
                f += e.a.a.a.ix(7, this.BTM.computeSize());
            }
            if (this.BTN != null) {
                f += e.a.a.b.b.a.b(8, this.BTN);
            }
            if (this.BTO != null) {
                f += e.a.a.b.b.a.b(9, this.BTO);
            }
            AppMethodBeat.o(57010);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(57010);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.BTG = aVar3.BTU.readString();
                    AppMethodBeat.o(57010);
                    return 0;
                case 2:
                    eVar.BTH = aVar3.BTU.readString();
                    AppMethodBeat.o(57010);
                    return 0;
                case 3:
                    eVar.BTI = aVar3.BTU.readString();
                    AppMethodBeat.o(57010);
                    return 0;
                case 4:
                    eVar.BTJ = aVar3.BTU.readString();
                    AppMethodBeat.o(57010);
                    return 0;
                case 5:
                    eVar.BTK = aVar3.BTU.readString();
                    AppMethodBeat.o(57010);
                    return 0;
                case 6:
                    eVar.BTL = aVar3.BTU.vd();
                    AppMethodBeat.o(57010);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.BTM = dVar;
                    }
                    AppMethodBeat.o(57010);
                    return 0;
                case 8:
                    eVar.BTN = aVar3.BTU.emu();
                    AppMethodBeat.o(57010);
                    return 0;
                case 9:
                    eVar.BTO = aVar3.BTU.emu();
                    AppMethodBeat.o(57010);
                    return 0;
                default:
                    AppMethodBeat.o(57010);
                    return -1;
            }
        } else {
            AppMethodBeat.o(57010);
            return -1;
        }
    }
}
