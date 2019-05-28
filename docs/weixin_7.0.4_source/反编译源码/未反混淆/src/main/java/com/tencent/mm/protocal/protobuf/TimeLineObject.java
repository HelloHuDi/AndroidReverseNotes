package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public class TimeLineObject extends a {
    public String Id;
    public int dtW;
    public int fgt;
    public String ijx;
    public String jBB;
    public int pcX;
    public av qNO;
    public cvi qNQ;
    public String rCK;
    public String rjC;
    public String vjM;
    public int wEJ;
    public String xfF;
    public ayt xfG;
    public ds xfH;
    public uf xfI;
    public String xfJ;
    public int xfK;
    public int xfL;
    public String xfM;
    public cfg xfN;
    public cth xfO;
    public int xfP;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94634);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            aVar.iz(3, this.wEJ);
            aVar.iz(4, this.pcX);
            if (this.xfF != null) {
                aVar.e(5, this.xfF);
            }
            if (this.xfG != null) {
                aVar.iy(6, this.xfG.computeSize());
                this.xfG.writeFields(aVar);
            }
            if (this.xfH != null) {
                aVar.iy(7, this.xfH.computeSize());
                this.xfH.writeFields(aVar);
            }
            if (this.xfI != null) {
                aVar.iy(8, this.xfI.computeSize());
                this.xfI.writeFields(aVar);
            }
            if (this.ijx != null) {
                aVar.e(9, this.ijx);
            }
            if (this.vjM != null) {
                aVar.e(10, this.vjM);
            }
            if (this.xfJ != null) {
                aVar.e(11, this.xfJ);
            }
            aVar.iz(12, this.xfK);
            aVar.iz(13, this.xfL);
            if (this.xfM != null) {
                aVar.e(14, this.xfM);
            }
            if (this.qNO != null) {
                aVar.iy(15, this.qNO.computeSize());
                this.qNO.writeFields(aVar);
            }
            aVar.iz(16, this.fgt);
            if (this.xfN != null) {
                aVar.iy(17, this.xfN.computeSize());
                this.xfN.writeFields(aVar);
            }
            if (this.rjC != null) {
                aVar.e(18, this.rjC);
            }
            if (this.rCK != null) {
                aVar.e(19, this.rCK);
            }
            if (this.xfO != null) {
                aVar.iy(20, this.xfO.computeSize());
                this.xfO.writeFields(aVar);
            }
            aVar.iz(21, this.xfP);
            if (this.qNQ != null) {
                aVar.iy(22, this.qNQ.computeSize());
                this.qNQ.writeFields(aVar);
            }
            aVar.iz(23, this.dtW);
            AppMethodBeat.o(94634);
            return 0;
        } else if (i == 1) {
            if (this.Id != null) {
                f = e.a.a.b.b.a.f(1, this.Id) + 0;
            } else {
                f = 0;
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(2, this.jBB);
            }
            f = (f + e.a.a.b.b.a.bs(3, this.wEJ)) + e.a.a.b.b.a.bs(4, this.pcX);
            if (this.xfF != null) {
                f += e.a.a.b.b.a.f(5, this.xfF);
            }
            if (this.xfG != null) {
                f += e.a.a.a.ix(6, this.xfG.computeSize());
            }
            if (this.xfH != null) {
                f += e.a.a.a.ix(7, this.xfH.computeSize());
            }
            if (this.xfI != null) {
                f += e.a.a.a.ix(8, this.xfI.computeSize());
            }
            if (this.ijx != null) {
                f += e.a.a.b.b.a.f(9, this.ijx);
            }
            if (this.vjM != null) {
                f += e.a.a.b.b.a.f(10, this.vjM);
            }
            if (this.xfJ != null) {
                f += e.a.a.b.b.a.f(11, this.xfJ);
            }
            f = (f + e.a.a.b.b.a.bs(12, this.xfK)) + e.a.a.b.b.a.bs(13, this.xfL);
            if (this.xfM != null) {
                f += e.a.a.b.b.a.f(14, this.xfM);
            }
            if (this.qNO != null) {
                f += e.a.a.a.ix(15, this.qNO.computeSize());
            }
            f += e.a.a.b.b.a.bs(16, this.fgt);
            if (this.xfN != null) {
                f += e.a.a.a.ix(17, this.xfN.computeSize());
            }
            if (this.rjC != null) {
                f += e.a.a.b.b.a.f(18, this.rjC);
            }
            if (this.rCK != null) {
                f += e.a.a.b.b.a.f(19, this.rCK);
            }
            if (this.xfO != null) {
                f += e.a.a.a.ix(20, this.xfO.computeSize());
            }
            f += e.a.a.b.b.a.bs(21, this.xfP);
            if (this.qNQ != null) {
                f += e.a.a.a.ix(22, this.qNQ.computeSize());
            }
            int bs = f + e.a.a.b.b.a.bs(23, this.dtW);
            AppMethodBeat.o(94634);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94634);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            TimeLineObject timeLineObject = (TimeLineObject) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    timeLineObject.Id = aVar3.BTU.readString();
                    AppMethodBeat.o(94634);
                    return 0;
                case 2:
                    timeLineObject.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(94634);
                    return 0;
                case 3:
                    timeLineObject.wEJ = aVar3.BTU.vd();
                    AppMethodBeat.o(94634);
                    return 0;
                case 4:
                    timeLineObject.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(94634);
                    return 0;
                case 5:
                    timeLineObject.xfF = aVar3.BTU.readString();
                    AppMethodBeat.o(94634);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayt ayt = new ayt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayt.populateBuilderWithField(aVar4, ayt, a.getNextFieldNumber(aVar4))) {
                        }
                        timeLineObject.xfG = ayt;
                    }
                    AppMethodBeat.o(94634);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ds dsVar = new ds();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dsVar.populateBuilderWithField(aVar4, dsVar, a.getNextFieldNumber(aVar4))) {
                        }
                        timeLineObject.xfH = dsVar;
                    }
                    AppMethodBeat.o(94634);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        uf ufVar = new uf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ufVar.populateBuilderWithField(aVar4, ufVar, a.getNextFieldNumber(aVar4))) {
                        }
                        timeLineObject.xfI = ufVar;
                    }
                    AppMethodBeat.o(94634);
                    return 0;
                case 9:
                    timeLineObject.ijx = aVar3.BTU.readString();
                    AppMethodBeat.o(94634);
                    return 0;
                case 10:
                    timeLineObject.vjM = aVar3.BTU.readString();
                    AppMethodBeat.o(94634);
                    return 0;
                case 11:
                    timeLineObject.xfJ = aVar3.BTU.readString();
                    AppMethodBeat.o(94634);
                    return 0;
                case 12:
                    timeLineObject.xfK = aVar3.BTU.vd();
                    AppMethodBeat.o(94634);
                    return 0;
                case 13:
                    timeLineObject.xfL = aVar3.BTU.vd();
                    AppMethodBeat.o(94634);
                    return 0;
                case 14:
                    timeLineObject.xfM = aVar3.BTU.readString();
                    AppMethodBeat.o(94634);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        av avVar = new av();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avVar.populateBuilderWithField(aVar4, avVar, a.getNextFieldNumber(aVar4))) {
                        }
                        timeLineObject.qNO = avVar;
                    }
                    AppMethodBeat.o(94634);
                    return 0;
                case 16:
                    timeLineObject.fgt = aVar3.BTU.vd();
                    AppMethodBeat.o(94634);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cfg cfg = new cfg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfg.populateBuilderWithField(aVar4, cfg, a.getNextFieldNumber(aVar4))) {
                        }
                        timeLineObject.xfN = cfg;
                    }
                    AppMethodBeat.o(94634);
                    return 0;
                case 18:
                    timeLineObject.rjC = aVar3.BTU.readString();
                    AppMethodBeat.o(94634);
                    return 0;
                case 19:
                    timeLineObject.rCK = aVar3.BTU.readString();
                    AppMethodBeat.o(94634);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cth cth = new cth();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cth.populateBuilderWithField(aVar4, cth, a.getNextFieldNumber(aVar4))) {
                        }
                        timeLineObject.xfO = cth;
                    }
                    AppMethodBeat.o(94634);
                    return 0;
                case 21:
                    timeLineObject.xfP = aVar3.BTU.vd();
                    AppMethodBeat.o(94634);
                    return 0;
                case 22:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvi cvi = new cvi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvi.populateBuilderWithField(aVar4, cvi, a.getNextFieldNumber(aVar4))) {
                        }
                        timeLineObject.qNQ = cvi;
                    }
                    AppMethodBeat.o(94634);
                    return 0;
                case 23:
                    timeLineObject.dtW = aVar3.BTU.vd();
                    AppMethodBeat.o(94634);
                    return 0;
                default:
                    AppMethodBeat.o(94634);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94634);
            return -1;
        }
    }
}
