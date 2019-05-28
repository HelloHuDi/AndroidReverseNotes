package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class baz extends a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guW;
    public int wBT;
    public String wBU;
    public int wFJ;
    public bts wFK;
    public bts wFL;
    public bts wFM;
    public int wbA;
    public bts wcG;
    public bts wce;
    public bts wcf;
    public bts wyX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5594);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcG == null) {
                bVar = new b("Not all required fields were included: MemberName");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wFK == null) {
                bVar = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wFL == null) {
                bVar = new b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wFM == null) {
                bVar = new b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.o(5594);
                throw bVar;
            } else {
                if (this.wcG != null) {
                    aVar.iy(1, this.wcG.computeSize());
                    this.wcG.writeFields(aVar);
                }
                aVar.iz(2, this.wFJ);
                if (this.wyX != null) {
                    aVar.iy(3, this.wyX.computeSize());
                    this.wyX.writeFields(aVar);
                }
                if (this.wce != null) {
                    aVar.iy(4, this.wce.computeSize());
                    this.wce.writeFields(aVar);
                }
                if (this.wcf != null) {
                    aVar.iy(5, this.wcf.computeSize());
                    this.wcf.writeFields(aVar);
                }
                aVar.iz(6, this.guN);
                if (this.wFK != null) {
                    aVar.iy(9, this.wFK.computeSize());
                    this.wFK.writeFields(aVar);
                }
                if (this.wFL != null) {
                    aVar.iy(10, this.wFL.computeSize());
                    this.wFL.writeFields(aVar);
                }
                if (this.wFM != null) {
                    aVar.iy(11, this.wFM.computeSize());
                    this.wFM.writeFields(aVar);
                }
                aVar.iz(12, this.wbA);
                if (this.guO != null) {
                    aVar.e(13, this.guO);
                }
                if (this.guP != null) {
                    aVar.e(14, this.guP);
                }
                if (this.guQ != null) {
                    aVar.e(15, this.guQ);
                }
                aVar.iz(16, this.guR);
                aVar.iz(17, this.wBT);
                if (this.wBU != null) {
                    aVar.e(18, this.wBU);
                }
                if (this.guW != null) {
                    aVar.e(19, this.guW);
                }
                AppMethodBeat.o(5594);
                return 0;
            }
        } else if (i == 1) {
            if (this.wcG != null) {
                ix = e.a.a.a.ix(1, this.wcG.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.wFJ);
            if (this.wyX != null) {
                ix += e.a.a.a.ix(3, this.wyX.computeSize());
            }
            if (this.wce != null) {
                ix += e.a.a.a.ix(4, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += e.a.a.a.ix(5, this.wcf.computeSize());
            }
            ix += e.a.a.b.b.a.bs(6, this.guN);
            if (this.wFK != null) {
                ix += e.a.a.a.ix(9, this.wFK.computeSize());
            }
            if (this.wFL != null) {
                ix += e.a.a.a.ix(10, this.wFL.computeSize());
            }
            if (this.wFM != null) {
                ix += e.a.a.a.ix(11, this.wFM.computeSize());
            }
            ix += e.a.a.b.b.a.bs(12, this.wbA);
            if (this.guO != null) {
                ix += e.a.a.b.b.a.f(13, this.guO);
            }
            if (this.guP != null) {
                ix += e.a.a.b.b.a.f(14, this.guP);
            }
            if (this.guQ != null) {
                ix += e.a.a.b.b.a.f(15, this.guQ);
            }
            ix = (ix + e.a.a.b.b.a.bs(16, this.guR)) + e.a.a.b.b.a.bs(17, this.wBT);
            if (this.wBU != null) {
                ix += e.a.a.b.b.a.f(18, this.wBU);
            }
            if (this.guW != null) {
                ix += e.a.a.b.b.a.f(19, this.guW);
            }
            AppMethodBeat.o(5594);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wcG == null) {
                bVar = new b("Not all required fields were included: MemberName");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wyX == null) {
                bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wFK == null) {
                bVar = new b("Not all required fields were included: Remark");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wFL == null) {
                bVar = new b("Not all required fields were included: RemarkPYInitial");
                AppMethodBeat.o(5594);
                throw bVar;
            } else if (this.wFM == null) {
                bVar = new b("Not all required fields were included: RemarkQuanPin");
                AppMethodBeat.o(5594);
                throw bVar;
            } else {
                AppMethodBeat.o(5594);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            baz baz = (baz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        baz.wcG = bts;
                    }
                    AppMethodBeat.o(5594);
                    return 0;
                case 2:
                    baz.wFJ = aVar3.BTU.vd();
                    AppMethodBeat.o(5594);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        baz.wyX = bts;
                    }
                    AppMethodBeat.o(5594);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        baz.wce = bts;
                    }
                    AppMethodBeat.o(5594);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        baz.wcf = bts;
                    }
                    AppMethodBeat.o(5594);
                    return 0;
                case 6:
                    baz.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(5594);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        baz.wFK = bts;
                    }
                    AppMethodBeat.o(5594);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        baz.wFL = bts;
                    }
                    AppMethodBeat.o(5594);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        baz.wFM = bts;
                    }
                    AppMethodBeat.o(5594);
                    return 0;
                case 12:
                    baz.wbA = aVar3.BTU.vd();
                    AppMethodBeat.o(5594);
                    return 0;
                case 13:
                    baz.guO = aVar3.BTU.readString();
                    AppMethodBeat.o(5594);
                    return 0;
                case 14:
                    baz.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(5594);
                    return 0;
                case 15:
                    baz.guQ = aVar3.BTU.readString();
                    AppMethodBeat.o(5594);
                    return 0;
                case 16:
                    baz.guR = aVar3.BTU.vd();
                    AppMethodBeat.o(5594);
                    return 0;
                case 17:
                    baz.wBT = aVar3.BTU.vd();
                    AppMethodBeat.o(5594);
                    return 0;
                case 18:
                    baz.wBU = aVar3.BTU.readString();
                    AppMethodBeat.o(5594);
                    return 0;
                case 19:
                    baz.guW = aVar3.BTU.readString();
                    AppMethodBeat.o(5594);
                    return 0;
                default:
                    AppMethodBeat.o(5594);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5594);
            return -1;
        }
    }
}
