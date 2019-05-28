package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class fv extends a {
    public int luF;
    public String vCp;
    public xu vHF;
    public SKBuiltinBuffer_t vHG;
    public SKBuiltinBuffer_t vHH;
    public int vHI;
    public SKBuiltinBuffer_t vHJ;
    public cse vHK;
    public cwe vHL;
    public SKBuiltinBuffer_t vHM;
    public SKBuiltinBuffer_t vHN;
    public String vHO;
    public SKBuiltinBuffer_t vHP;
    public String vHQ;
    public bzr vHR;
    public String vHS;
    public int vHT;
    public int vHU;
    public int vHV;
    public int vHW;
    public int vHX;
    public SKBuiltinBuffer_t vHY;
    public SKBuiltinBuffer_t vHZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58886);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vHF == null) {
                bVar = new b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else if (this.vHG == null) {
                bVar = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else if (this.vHH == null) {
                bVar = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else if (this.vHY == null) {
                bVar = new b("Not all required fields were included: ClientSessionKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else if (this.vHZ == null) {
                bVar = new b("Not all required fields were included: ServerSessionKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else {
                aVar.iz(1, this.luF);
                if (this.vHF != null) {
                    aVar.iy(2, this.vHF.computeSize());
                    this.vHF.writeFields(aVar);
                }
                if (this.vHG != null) {
                    aVar.iy(3, this.vHG.computeSize());
                    this.vHG.writeFields(aVar);
                }
                if (this.vHH != null) {
                    aVar.iy(4, this.vHH.computeSize());
                    this.vHH.writeFields(aVar);
                }
                aVar.iz(5, this.vHI);
                if (this.vHJ != null) {
                    aVar.iy(6, this.vHJ.computeSize());
                    this.vHJ.writeFields(aVar);
                }
                if (this.vHK != null) {
                    aVar.iy(7, this.vHK.computeSize());
                    this.vHK.writeFields(aVar);
                }
                if (this.vHL != null) {
                    aVar.iy(8, this.vHL.computeSize());
                    this.vHL.writeFields(aVar);
                }
                if (this.vHM != null) {
                    aVar.iy(9, this.vHM.computeSize());
                    this.vHM.writeFields(aVar);
                }
                if (this.vHN != null) {
                    aVar.iy(10, this.vHN.computeSize());
                    this.vHN.writeFields(aVar);
                }
                if (this.vHO != null) {
                    aVar.e(11, this.vHO);
                }
                if (this.vHP != null) {
                    aVar.iy(12, this.vHP.computeSize());
                    this.vHP.writeFields(aVar);
                }
                if (this.vHQ != null) {
                    aVar.e(14, this.vHQ);
                }
                if (this.vHR != null) {
                    aVar.iy(15, this.vHR.computeSize());
                    this.vHR.writeFields(aVar);
                }
                if (this.vHS != null) {
                    aVar.e(16, this.vHS);
                }
                aVar.iz(17, this.vHT);
                aVar.iz(18, this.vHU);
                aVar.iz(19, this.vHV);
                if (this.vCp != null) {
                    aVar.e(20, this.vCp);
                }
                aVar.iz(21, this.vHW);
                aVar.iz(22, this.vHX);
                if (this.vHY != null) {
                    aVar.iy(23, this.vHY.computeSize());
                    this.vHY.writeFields(aVar);
                }
                if (this.vHZ != null) {
                    aVar.iy(24, this.vHZ.computeSize());
                    this.vHZ.writeFields(aVar);
                }
                AppMethodBeat.o(58886);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.luF) + 0;
            if (this.vHF != null) {
                bs += e.a.a.a.ix(2, this.vHF.computeSize());
            }
            if (this.vHG != null) {
                bs += e.a.a.a.ix(3, this.vHG.computeSize());
            }
            if (this.vHH != null) {
                bs += e.a.a.a.ix(4, this.vHH.computeSize());
            }
            bs += e.a.a.b.b.a.bs(5, this.vHI);
            if (this.vHJ != null) {
                bs += e.a.a.a.ix(6, this.vHJ.computeSize());
            }
            if (this.vHK != null) {
                bs += e.a.a.a.ix(7, this.vHK.computeSize());
            }
            if (this.vHL != null) {
                bs += e.a.a.a.ix(8, this.vHL.computeSize());
            }
            if (this.vHM != null) {
                bs += e.a.a.a.ix(9, this.vHM.computeSize());
            }
            if (this.vHN != null) {
                bs += e.a.a.a.ix(10, this.vHN.computeSize());
            }
            if (this.vHO != null) {
                bs += e.a.a.b.b.a.f(11, this.vHO);
            }
            if (this.vHP != null) {
                bs += e.a.a.a.ix(12, this.vHP.computeSize());
            }
            if (this.vHQ != null) {
                bs += e.a.a.b.b.a.f(14, this.vHQ);
            }
            if (this.vHR != null) {
                bs += e.a.a.a.ix(15, this.vHR.computeSize());
            }
            if (this.vHS != null) {
                bs += e.a.a.b.b.a.f(16, this.vHS);
            }
            bs = ((bs + e.a.a.b.b.a.bs(17, this.vHT)) + e.a.a.b.b.a.bs(18, this.vHU)) + e.a.a.b.b.a.bs(19, this.vHV);
            if (this.vCp != null) {
                bs += e.a.a.b.b.a.f(20, this.vCp);
            }
            bs = (bs + e.a.a.b.b.a.bs(21, this.vHW)) + e.a.a.b.b.a.bs(22, this.vHX);
            if (this.vHY != null) {
                bs += e.a.a.a.ix(23, this.vHY.computeSize());
            }
            if (this.vHZ != null) {
                bs += e.a.a.a.ix(24, this.vHZ.computeSize());
            }
            AppMethodBeat.o(58886);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vHF == null) {
                bVar = new b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else if (this.vHG == null) {
                bVar = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else if (this.vHH == null) {
                bVar = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else if (this.vHY == null) {
                bVar = new b("Not all required fields were included: ClientSessionKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else if (this.vHZ == null) {
                bVar = new b("Not all required fields were included: ServerSessionKey");
                AppMethodBeat.o(58886);
                throw bVar;
            } else {
                AppMethodBeat.o(58886);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fv fvVar = (fv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    fvVar.luF = aVar3.BTU.vd();
                    AppMethodBeat.o(58886);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xu xuVar = new xu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xuVar.populateBuilderWithField(aVar4, xuVar, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHF = xuVar;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 5:
                    fvVar.vHI = aVar3.BTU.vd();
                    AppMethodBeat.o(58886);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cse cse = new cse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cse.populateBuilderWithField(aVar4, cse, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHK = cse;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwe cwe = new cwe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwe.populateBuilderWithField(aVar4, cwe, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHL = cwe;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHM = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHN = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 11:
                    fvVar.vHO = aVar3.BTU.readString();
                    AppMethodBeat.o(58886);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 14:
                    fvVar.vHQ = aVar3.BTU.readString();
                    AppMethodBeat.o(58886);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzr bzr = new bzr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzr.populateBuilderWithField(aVar4, bzr, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHR = bzr;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 16:
                    fvVar.vHS = aVar3.BTU.readString();
                    AppMethodBeat.o(58886);
                    return 0;
                case 17:
                    fvVar.vHT = aVar3.BTU.vd();
                    AppMethodBeat.o(58886);
                    return 0;
                case 18:
                    fvVar.vHU = aVar3.BTU.vd();
                    AppMethodBeat.o(58886);
                    return 0;
                case 19:
                    fvVar.vHV = aVar3.BTU.vd();
                    AppMethodBeat.o(58886);
                    return 0;
                case 20:
                    fvVar.vCp = aVar3.BTU.readString();
                    AppMethodBeat.o(58886);
                    return 0;
                case 21:
                    fvVar.vHW = aVar3.BTU.vd();
                    AppMethodBeat.o(58886);
                    return 0;
                case 22:
                    fvVar.vHX = aVar3.BTU.vd();
                    AppMethodBeat.o(58886);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                case 24:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        fvVar.vHZ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58886);
                    return 0;
                default:
                    AppMethodBeat.o(58886);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58886);
            return -1;
        }
    }
}
