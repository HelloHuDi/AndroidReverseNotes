package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class e extends a {
    public String Desc;
    public String Name;
    public int Version;
    public int jBT;
    public boolean mZA;
    public boolean mZB;
    public boolean mZC;
    public boolean mZD;
    public cg mZE;
    public int mZF;
    public bx mZG;
    public LinkedList<String> mZH = new LinkedList();
    public String mZm;
    public String mZo;
    public String mZr;
    public String mZs;
    public String mZt;
    public String mZu;
    public int mZv;
    public q mZw;
    public int mZx;
    public boolean mZy;
    public LinkedList<String> mZz = new LinkedList();

    public e() {
        AppMethodBeat.i(111545);
        AppMethodBeat.o(111545);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111546);
        b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.mZr == null) {
                bVar = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(111546);
                throw bVar;
            } else if (this.mZs == null) {
                bVar = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(111546);
                throw bVar;
            } else {
                if (this.mZr != null) {
                    aVar.e(1, this.mZr);
                }
                if (this.mZs != null) {
                    aVar.e(2, this.mZs);
                }
                if (this.Name != null) {
                    aVar.e(3, this.Name);
                }
                if (this.Desc != null) {
                    aVar.e(4, this.Desc);
                }
                if (this.mZt != null) {
                    aVar.e(5, this.mZt);
                }
                if (this.mZm != null) {
                    aVar.e(6, this.mZm);
                }
                if (this.mZu != null) {
                    aVar.e(7, this.mZu);
                }
                aVar.iz(8, this.mZv);
                if (this.mZw != null) {
                    aVar.iy(9, this.mZw.computeSize());
                    this.mZw.writeFields(aVar);
                }
                aVar.iz(10, this.jBT);
                aVar.iz(11, this.mZx);
                if (this.mZo != null) {
                    aVar.e(12, this.mZo);
                }
                aVar.aO(13, this.mZy);
                aVar.e(14, 1, this.mZz);
                aVar.aO(15, this.mZA);
                aVar.iz(16, this.Version);
                aVar.aO(17, this.mZB);
                aVar.aO(18, this.mZC);
                aVar.aO(19, this.mZD);
                if (this.mZE != null) {
                    aVar.iy(20, this.mZE.computeSize());
                    this.mZE.writeFields(aVar);
                }
                aVar.iz(21, this.mZF);
                if (this.mZG != null) {
                    aVar.iy(22, this.mZG.computeSize());
                    this.mZG.writeFields(aVar);
                }
                aVar.e(23, 1, this.mZH);
                AppMethodBeat.o(111546);
                return 0;
            }
        } else if (i == 1) {
            if (this.mZr != null) {
                f = e.a.a.b.b.a.f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.mZs != null) {
                f += e.a.a.b.b.a.f(2, this.mZs);
            }
            if (this.Name != null) {
                f += e.a.a.b.b.a.f(3, this.Name);
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.mZt != null) {
                f += e.a.a.b.b.a.f(5, this.mZt);
            }
            if (this.mZm != null) {
                f += e.a.a.b.b.a.f(6, this.mZm);
            }
            if (this.mZu != null) {
                f += e.a.a.b.b.a.f(7, this.mZu);
            }
            f += e.a.a.b.b.a.bs(8, this.mZv);
            if (this.mZw != null) {
                f += e.a.a.a.ix(9, this.mZw.computeSize());
            }
            f = (f + e.a.a.b.b.a.bs(10, this.jBT)) + e.a.a.b.b.a.bs(11, this.mZx);
            if (this.mZo != null) {
                f += e.a.a.b.b.a.f(12, this.mZo);
            }
            f = ((((((f + (e.a.a.b.b.a.fv(13) + 1)) + e.a.a.a.c(14, 1, this.mZz)) + (e.a.a.b.b.a.fv(15) + 1)) + e.a.a.b.b.a.bs(16, this.Version)) + (e.a.a.b.b.a.fv(17) + 1)) + (e.a.a.b.b.a.fv(18) + 1)) + (e.a.a.b.b.a.fv(19) + 1);
            if (this.mZE != null) {
                f += e.a.a.a.ix(20, this.mZE.computeSize());
            }
            f += e.a.a.b.b.a.bs(21, this.mZF);
            if (this.mZG != null) {
                f += e.a.a.a.ix(22, this.mZG.computeSize());
            }
            int c = f + e.a.a.a.c(23, 1, this.mZH);
            AppMethodBeat.o(111546);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.mZz.clear();
            this.mZH.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.mZr == null) {
                bVar = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(111546);
                throw bVar;
            } else if (this.mZs == null) {
                bVar = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(111546);
                throw bVar;
            } else {
                AppMethodBeat.o(111546);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    eVar.mZr = aVar3.BTU.readString();
                    AppMethodBeat.o(111546);
                    return 0;
                case 2:
                    eVar.mZs = aVar3.BTU.readString();
                    AppMethodBeat.o(111546);
                    return 0;
                case 3:
                    eVar.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(111546);
                    return 0;
                case 4:
                    eVar.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(111546);
                    return 0;
                case 5:
                    eVar.mZt = aVar3.BTU.readString();
                    AppMethodBeat.o(111546);
                    return 0;
                case 6:
                    eVar.mZm = aVar3.BTU.readString();
                    AppMethodBeat.o(111546);
                    return 0;
                case 7:
                    eVar.mZu = aVar3.BTU.readString();
                    AppMethodBeat.o(111546);
                    return 0;
                case 8:
                    eVar.mZv = aVar3.BTU.vd();
                    AppMethodBeat.o(111546);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        q qVar = new q();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.populateBuilderWithField(aVar4, qVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.mZw = qVar;
                    }
                    AppMethodBeat.o(111546);
                    return 0;
                case 10:
                    eVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(111546);
                    return 0;
                case 11:
                    eVar.mZx = aVar3.BTU.vd();
                    AppMethodBeat.o(111546);
                    return 0;
                case 12:
                    eVar.mZo = aVar3.BTU.readString();
                    AppMethodBeat.o(111546);
                    return 0;
                case 13:
                    eVar.mZy = aVar3.BTU.ehX();
                    AppMethodBeat.o(111546);
                    return 0;
                case 14:
                    eVar.mZz.add(aVar3.BTU.readString());
                    AppMethodBeat.o(111546);
                    return 0;
                case 15:
                    eVar.mZA = aVar3.BTU.ehX();
                    AppMethodBeat.o(111546);
                    return 0;
                case 16:
                    eVar.Version = aVar3.BTU.vd();
                    AppMethodBeat.o(111546);
                    return 0;
                case 17:
                    eVar.mZB = aVar3.BTU.ehX();
                    AppMethodBeat.o(111546);
                    return 0;
                case 18:
                    eVar.mZC = aVar3.BTU.ehX();
                    AppMethodBeat.o(111546);
                    return 0;
                case 19:
                    eVar.mZD = aVar3.BTU.ehX();
                    AppMethodBeat.o(111546);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cg cgVar = new cg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgVar.populateBuilderWithField(aVar4, cgVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.mZE = cgVar;
                    }
                    AppMethodBeat.o(111546);
                    return 0;
                case 21:
                    eVar.mZF = aVar3.BTU.vd();
                    AppMethodBeat.o(111546);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bx bxVar = new bx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxVar.populateBuilderWithField(aVar4, bxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.mZG = bxVar;
                    }
                    AppMethodBeat.o(111546);
                    return 0;
                case 23:
                    eVar.mZH.add(aVar3.BTU.readString());
                    AppMethodBeat.o(111546);
                    return 0;
                default:
                    AppMethodBeat.o(111546);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111546);
            return -1;
        }
    }
}
