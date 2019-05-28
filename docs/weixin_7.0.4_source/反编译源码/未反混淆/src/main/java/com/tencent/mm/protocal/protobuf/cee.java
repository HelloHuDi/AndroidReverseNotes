package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cee extends a {
    public boolean aIM;
    public int eTb;
    public String eYi;
    public long endTime;
    public boolean fbV;
    public String musicUrl;
    public int rTW;
    public boolean rTZ;
    public cei smk;
    public long startTime;
    public String thumbPath;
    public long timeStamp;
    public String videoPath;
    public String xdR;
    public int xdS;
    public int xdT;
    public int xdU;
    public int xdV;
    public LinkedList<hk> xdW = new LinkedList();
    public int xdX;
    public ced xdY;
    public int xdZ;
    public long xea;

    public cee() {
        AppMethodBeat.i(56513);
        AppMethodBeat.o(56513);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56514);
        b bVar;
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.videoPath == null) {
                bVar = new b("Not all required fields were included: videoPath");
                AppMethodBeat.o(56514);
                throw bVar;
            } else if (this.thumbPath == null) {
                bVar = new b("Not all required fields were included: thumbPath");
                AppMethodBeat.o(56514);
                throw bVar;
            } else {
                if (this.videoPath != null) {
                    aVar.e(1, this.videoPath);
                }
                aVar.ai(2, this.startTime);
                aVar.ai(3, this.endTime);
                if (this.xdR != null) {
                    aVar.e(4, this.xdR);
                }
                aVar.iz(5, this.eTb);
                if (this.thumbPath != null) {
                    aVar.e(6, this.thumbPath);
                }
                if (this.eYi != null) {
                    aVar.e(7, this.eYi);
                }
                aVar.iz(8, this.rTW);
                if (this.musicUrl != null) {
                    aVar.e(9, this.musicUrl);
                }
                aVar.aO(10, this.aIM);
                aVar.aO(11, this.rTZ);
                aVar.iz(12, this.xdS);
                aVar.iz(13, this.xdT);
                aVar.iz(14, this.xdU);
                aVar.iz(15, this.xdV);
                aVar.e(16, 8, this.xdW);
                aVar.ai(17, this.timeStamp);
                aVar.iz(18, this.xdX);
                aVar.aO(19, this.fbV);
                if (this.smk != null) {
                    aVar.iy(20, this.smk.computeSize());
                    this.smk.writeFields(aVar);
                }
                if (this.xdY != null) {
                    aVar.iy(21, this.xdY.computeSize());
                    this.xdY.writeFields(aVar);
                }
                aVar.iz(22, this.xdZ);
                aVar.ai(23, this.xea);
                AppMethodBeat.o(56514);
                return 0;
            }
        } else if (i == 1) {
            if (this.videoPath != null) {
                f = e.a.a.b.b.a.f(1, this.videoPath) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.o(2, this.startTime)) + e.a.a.b.b.a.o(3, this.endTime);
            if (this.xdR != null) {
                f += e.a.a.b.b.a.f(4, this.xdR);
            }
            f += e.a.a.b.b.a.bs(5, this.eTb);
            if (this.thumbPath != null) {
                f += e.a.a.b.b.a.f(6, this.thumbPath);
            }
            if (this.eYi != null) {
                f += e.a.a.b.b.a.f(7, this.eYi);
            }
            f += e.a.a.b.b.a.bs(8, this.rTW);
            if (this.musicUrl != null) {
                f += e.a.a.b.b.a.f(9, this.musicUrl);
            }
            f = (((((((((f + (e.a.a.b.b.a.fv(10) + 1)) + (e.a.a.b.b.a.fv(11) + 1)) + e.a.a.b.b.a.bs(12, this.xdS)) + e.a.a.b.b.a.bs(13, this.xdT)) + e.a.a.b.b.a.bs(14, this.xdU)) + e.a.a.b.b.a.bs(15, this.xdV)) + e.a.a.a.c(16, 8, this.xdW)) + e.a.a.b.b.a.o(17, this.timeStamp)) + e.a.a.b.b.a.bs(18, this.xdX)) + (e.a.a.b.b.a.fv(19) + 1);
            if (this.smk != null) {
                f += e.a.a.a.ix(20, this.smk.computeSize());
            }
            if (this.xdY != null) {
                f += e.a.a.a.ix(21, this.xdY.computeSize());
            }
            int bs = (f + e.a.a.b.b.a.bs(22, this.xdZ)) + e.a.a.b.b.a.o(23, this.xea);
            AppMethodBeat.o(56514);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xdW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.videoPath == null) {
                bVar = new b("Not all required fields were included: videoPath");
                AppMethodBeat.o(56514);
                throw bVar;
            } else if (this.thumbPath == null) {
                bVar = new b("Not all required fields were included: thumbPath");
                AppMethodBeat.o(56514);
                throw bVar;
            } else {
                AppMethodBeat.o(56514);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cee cee = (cee) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cee.videoPath = aVar3.BTU.readString();
                    AppMethodBeat.o(56514);
                    return 0;
                case 2:
                    cee.startTime = aVar3.BTU.ve();
                    AppMethodBeat.o(56514);
                    return 0;
                case 3:
                    cee.endTime = aVar3.BTU.ve();
                    AppMethodBeat.o(56514);
                    return 0;
                case 4:
                    cee.xdR = aVar3.BTU.readString();
                    AppMethodBeat.o(56514);
                    return 0;
                case 5:
                    cee.eTb = aVar3.BTU.vd();
                    AppMethodBeat.o(56514);
                    return 0;
                case 6:
                    cee.thumbPath = aVar3.BTU.readString();
                    AppMethodBeat.o(56514);
                    return 0;
                case 7:
                    cee.eYi = aVar3.BTU.readString();
                    AppMethodBeat.o(56514);
                    return 0;
                case 8:
                    cee.rTW = aVar3.BTU.vd();
                    AppMethodBeat.o(56514);
                    return 0;
                case 9:
                    cee.musicUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(56514);
                    return 0;
                case 10:
                    cee.aIM = aVar3.BTU.ehX();
                    AppMethodBeat.o(56514);
                    return 0;
                case 11:
                    cee.rTZ = aVar3.BTU.ehX();
                    AppMethodBeat.o(56514);
                    return 0;
                case 12:
                    cee.xdS = aVar3.BTU.vd();
                    AppMethodBeat.o(56514);
                    return 0;
                case 13:
                    cee.xdT = aVar3.BTU.vd();
                    AppMethodBeat.o(56514);
                    return 0;
                case 14:
                    cee.xdU = aVar3.BTU.vd();
                    AppMethodBeat.o(56514);
                    return 0;
                case 15:
                    cee.xdV = aVar3.BTU.vd();
                    AppMethodBeat.o(56514);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hk hkVar = new hk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hkVar.populateBuilderWithField(aVar4, hkVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cee.xdW.add(hkVar);
                    }
                    AppMethodBeat.o(56514);
                    return 0;
                case 17:
                    cee.timeStamp = aVar3.BTU.ve();
                    AppMethodBeat.o(56514);
                    return 0;
                case 18:
                    cee.xdX = aVar3.BTU.vd();
                    AppMethodBeat.o(56514);
                    return 0;
                case 19:
                    cee.fbV = aVar3.BTU.ehX();
                    AppMethodBeat.o(56514);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cei cei = new cei();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cei.populateBuilderWithField(aVar4, cei, a.getNextFieldNumber(aVar4))) {
                        }
                        cee.smk = cei;
                    }
                    AppMethodBeat.o(56514);
                    return 0;
                case 21:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ced ced = new ced();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ced.populateBuilderWithField(aVar4, ced, a.getNextFieldNumber(aVar4))) {
                        }
                        cee.xdY = ced;
                    }
                    AppMethodBeat.o(56514);
                    return 0;
                case 22:
                    cee.xdZ = aVar3.BTU.vd();
                    AppMethodBeat.o(56514);
                    return 0;
                case 23:
                    cee.xea = aVar3.BTU.ve();
                    AppMethodBeat.o(56514);
                    return 0;
                default:
                    AppMethodBeat.o(56514);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56514);
            return -1;
        }
    }
}
