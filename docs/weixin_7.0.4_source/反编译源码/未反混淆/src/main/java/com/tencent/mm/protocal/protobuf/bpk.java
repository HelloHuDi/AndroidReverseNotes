package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bpk extends a {
    public int id;
    public bts wRO;
    public bts wRP;
    public bts wRQ;
    public bts wRR;
    public bts wRS;
    public bts wRT;
    public bts wRU;
    public bts wRV;
    public bts wRW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28605);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wRP == null) {
                bVar = new b("Not all required fields were included: province");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRQ == null) {
                bVar = new b("Not all required fields were included: city");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRR == null) {
                bVar = new b("Not all required fields were included: district");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRS == null) {
                bVar = new b("Not all required fields were included: zipcode");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRT == null) {
                bVar = new b("Not all required fields were included: detail");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRU == null) {
                bVar = new b("Not all required fields were included: name");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRV == null) {
                bVar = new b("Not all required fields were included: phone");
                AppMethodBeat.o(28605);
                throw bVar;
            } else {
                aVar.iz(1, this.id);
                if (this.wRO != null) {
                    aVar.iy(2, this.wRO.computeSize());
                    this.wRO.writeFields(aVar);
                }
                if (this.wRP != null) {
                    aVar.iy(3, this.wRP.computeSize());
                    this.wRP.writeFields(aVar);
                }
                if (this.wRQ != null) {
                    aVar.iy(4, this.wRQ.computeSize());
                    this.wRQ.writeFields(aVar);
                }
                if (this.wRR != null) {
                    aVar.iy(5, this.wRR.computeSize());
                    this.wRR.writeFields(aVar);
                }
                if (this.wRS != null) {
                    aVar.iy(6, this.wRS.computeSize());
                    this.wRS.writeFields(aVar);
                }
                if (this.wRT != null) {
                    aVar.iy(7, this.wRT.computeSize());
                    this.wRT.writeFields(aVar);
                }
                if (this.wRU != null) {
                    aVar.iy(8, this.wRU.computeSize());
                    this.wRU.writeFields(aVar);
                }
                if (this.wRV != null) {
                    aVar.iy(9, this.wRV.computeSize());
                    this.wRV.writeFields(aVar);
                }
                if (this.wRW != null) {
                    aVar.iy(10, this.wRW.computeSize());
                    this.wRW.writeFields(aVar);
                }
                AppMethodBeat.o(28605);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.id) + 0;
            if (this.wRO != null) {
                bs += e.a.a.a.ix(2, this.wRO.computeSize());
            }
            if (this.wRP != null) {
                bs += e.a.a.a.ix(3, this.wRP.computeSize());
            }
            if (this.wRQ != null) {
                bs += e.a.a.a.ix(4, this.wRQ.computeSize());
            }
            if (this.wRR != null) {
                bs += e.a.a.a.ix(5, this.wRR.computeSize());
            }
            if (this.wRS != null) {
                bs += e.a.a.a.ix(6, this.wRS.computeSize());
            }
            if (this.wRT != null) {
                bs += e.a.a.a.ix(7, this.wRT.computeSize());
            }
            if (this.wRU != null) {
                bs += e.a.a.a.ix(8, this.wRU.computeSize());
            }
            if (this.wRV != null) {
                bs += e.a.a.a.ix(9, this.wRV.computeSize());
            }
            if (this.wRW != null) {
                bs += e.a.a.a.ix(10, this.wRW.computeSize());
            }
            AppMethodBeat.o(28605);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wRP == null) {
                bVar = new b("Not all required fields were included: province");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRQ == null) {
                bVar = new b("Not all required fields were included: city");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRR == null) {
                bVar = new b("Not all required fields were included: district");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRS == null) {
                bVar = new b("Not all required fields were included: zipcode");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRT == null) {
                bVar = new b("Not all required fields were included: detail");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRU == null) {
                bVar = new b("Not all required fields were included: name");
                AppMethodBeat.o(28605);
                throw bVar;
            } else if (this.wRV == null) {
                bVar = new b("Not all required fields were included: phone");
                AppMethodBeat.o(28605);
                throw bVar;
            } else {
                AppMethodBeat.o(28605);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpk bpk = (bpk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bpk.id = aVar3.BTU.vd();
                    AppMethodBeat.o(28605);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bpk.wRO = bts;
                    }
                    AppMethodBeat.o(28605);
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
                        bpk.wRP = bts;
                    }
                    AppMethodBeat.o(28605);
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
                        bpk.wRQ = bts;
                    }
                    AppMethodBeat.o(28605);
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
                        bpk.wRR = bts;
                    }
                    AppMethodBeat.o(28605);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bpk.wRS = bts;
                    }
                    AppMethodBeat.o(28605);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bpk.wRT = bts;
                    }
                    AppMethodBeat.o(28605);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bpk.wRU = bts;
                    }
                    AppMethodBeat.o(28605);
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
                        bpk.wRV = bts;
                    }
                    AppMethodBeat.o(28605);
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
                        bpk.wRW = bts;
                    }
                    AppMethodBeat.o(28605);
                    return 0;
                default:
                    AppMethodBeat.o(28605);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28605);
            return -1;
        }
    }
}
