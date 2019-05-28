package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.fv */
public final class C7259fv extends C1331a {
    public int luF;
    public String vCp;
    public C7287xu vHF;
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

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58886);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vHF == null) {
                c6092b = new C6092b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else if (this.vHG == null) {
                c6092b = new C6092b("Not all required fields were included: SessionKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else if (this.vHH == null) {
                c6092b = new C6092b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else if (this.vHY == null) {
                c6092b = new C6092b("Not all required fields were included: ClientSessionKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else if (this.vHZ == null) {
                c6092b = new C6092b("Not all required fields were included: ServerSessionKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.luF);
                if (this.vHF != null) {
                    c6093a.mo13479iy(2, this.vHF.computeSize());
                    this.vHF.writeFields(c6093a);
                }
                if (this.vHG != null) {
                    c6093a.mo13479iy(3, this.vHG.computeSize());
                    this.vHG.writeFields(c6093a);
                }
                if (this.vHH != null) {
                    c6093a.mo13479iy(4, this.vHH.computeSize());
                    this.vHH.writeFields(c6093a);
                }
                c6093a.mo13480iz(5, this.vHI);
                if (this.vHJ != null) {
                    c6093a.mo13479iy(6, this.vHJ.computeSize());
                    this.vHJ.writeFields(c6093a);
                }
                if (this.vHK != null) {
                    c6093a.mo13479iy(7, this.vHK.computeSize());
                    this.vHK.writeFields(c6093a);
                }
                if (this.vHL != null) {
                    c6093a.mo13479iy(8, this.vHL.computeSize());
                    this.vHL.writeFields(c6093a);
                }
                if (this.vHM != null) {
                    c6093a.mo13479iy(9, this.vHM.computeSize());
                    this.vHM.writeFields(c6093a);
                }
                if (this.vHN != null) {
                    c6093a.mo13479iy(10, this.vHN.computeSize());
                    this.vHN.writeFields(c6093a);
                }
                if (this.vHO != null) {
                    c6093a.mo13475e(11, this.vHO);
                }
                if (this.vHP != null) {
                    c6093a.mo13479iy(12, this.vHP.computeSize());
                    this.vHP.writeFields(c6093a);
                }
                if (this.vHQ != null) {
                    c6093a.mo13475e(14, this.vHQ);
                }
                if (this.vHR != null) {
                    c6093a.mo13479iy(15, this.vHR.computeSize());
                    this.vHR.writeFields(c6093a);
                }
                if (this.vHS != null) {
                    c6093a.mo13475e(16, this.vHS);
                }
                c6093a.mo13480iz(17, this.vHT);
                c6093a.mo13480iz(18, this.vHU);
                c6093a.mo13480iz(19, this.vHV);
                if (this.vCp != null) {
                    c6093a.mo13475e(20, this.vCp);
                }
                c6093a.mo13480iz(21, this.vHW);
                c6093a.mo13480iz(22, this.vHX);
                if (this.vHY != null) {
                    c6093a.mo13479iy(23, this.vHY.computeSize());
                    this.vHY.writeFields(c6093a);
                }
                if (this.vHZ != null) {
                    c6093a.mo13479iy(24, this.vHZ.computeSize());
                    this.vHZ.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(58886);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.luF) + 0;
            if (this.vHF != null) {
                bs += C6087a.m9557ix(2, this.vHF.computeSize());
            }
            if (this.vHG != null) {
                bs += C6087a.m9557ix(3, this.vHG.computeSize());
            }
            if (this.vHH != null) {
                bs += C6087a.m9557ix(4, this.vHH.computeSize());
            }
            bs += C6091a.m9572bs(5, this.vHI);
            if (this.vHJ != null) {
                bs += C6087a.m9557ix(6, this.vHJ.computeSize());
            }
            if (this.vHK != null) {
                bs += C6087a.m9557ix(7, this.vHK.computeSize());
            }
            if (this.vHL != null) {
                bs += C6087a.m9557ix(8, this.vHL.computeSize());
            }
            if (this.vHM != null) {
                bs += C6087a.m9557ix(9, this.vHM.computeSize());
            }
            if (this.vHN != null) {
                bs += C6087a.m9557ix(10, this.vHN.computeSize());
            }
            if (this.vHO != null) {
                bs += C6091a.m9575f(11, this.vHO);
            }
            if (this.vHP != null) {
                bs += C6087a.m9557ix(12, this.vHP.computeSize());
            }
            if (this.vHQ != null) {
                bs += C6091a.m9575f(14, this.vHQ);
            }
            if (this.vHR != null) {
                bs += C6087a.m9557ix(15, this.vHR.computeSize());
            }
            if (this.vHS != null) {
                bs += C6091a.m9575f(16, this.vHS);
            }
            bs = ((bs + C6091a.m9572bs(17, this.vHT)) + C6091a.m9572bs(18, this.vHU)) + C6091a.m9572bs(19, this.vHV);
            if (this.vCp != null) {
                bs += C6091a.m9575f(20, this.vCp);
            }
            bs = (bs + C6091a.m9572bs(21, this.vHW)) + C6091a.m9572bs(22, this.vHX);
            if (this.vHY != null) {
                bs += C6087a.m9557ix(23, this.vHY.computeSize());
            }
            if (this.vHZ != null) {
                bs += C6087a.m9557ix(24, this.vHZ.computeSize());
            }
            AppMethodBeat.m2505o(58886);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.vHF == null) {
                c6092b = new C6092b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else if (this.vHG == null) {
                c6092b = new C6092b("Not all required fields were included: SessionKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else if (this.vHH == null) {
                c6092b = new C6092b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else if (this.vHY == null) {
                c6092b = new C6092b("Not all required fields were included: ClientSessionKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else if (this.vHZ == null) {
                c6092b = new C6092b("Not all required fields were included: ServerSessionKey");
                AppMethodBeat.m2505o(58886);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(58886);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7259fv c7259fv = (C7259fv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    c7259fv.luF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7287xu c7287xu = new C7287xu();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7287xu.populateBuilderWithField(c6086a3, c7287xu, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHF = c7287xu;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 5:
                    c7259fv.vHI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cse cse = new cse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cse.populateBuilderWithField(c6086a3, cse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHK = cse;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwe cwe = new cwe();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwe.populateBuilderWithField(c6086a3, cwe, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHL = cwe;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHM = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHN = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 11:
                    c7259fv.vHO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 14:
                    c7259fv.vHQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzr bzr = new bzr();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzr.populateBuilderWithField(c6086a3, bzr, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHR = bzr;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 16:
                    c7259fv.vHS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 17:
                    c7259fv.vHT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 18:
                    c7259fv.vHU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 19:
                    c7259fv.vHV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 20:
                    c7259fv.vCp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 21:
                    c7259fv.vHW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 22:
                    c7259fv.vHX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                case 24:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7259fv.vHZ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(58886);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58886);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58886);
            return -1;
        }
    }
}
