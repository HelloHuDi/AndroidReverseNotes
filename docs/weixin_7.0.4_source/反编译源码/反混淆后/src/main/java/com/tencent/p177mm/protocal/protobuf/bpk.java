package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bpk */
public final class bpk extends C1331a {
    /* renamed from: id */
    public int f15076id;
    public bts wRO;
    public bts wRP;
    public bts wRQ;
    public bts wRR;
    public bts wRS;
    public bts wRT;
    public bts wRU;
    public bts wRV;
    public bts wRW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28605);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wRP == null) {
                c6092b = new C6092b("Not all required fields were included: province");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRQ == null) {
                c6092b = new C6092b("Not all required fields were included: city");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRR == null) {
                c6092b = new C6092b("Not all required fields were included: district");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRS == null) {
                c6092b = new C6092b("Not all required fields were included: zipcode");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRT == null) {
                c6092b = new C6092b("Not all required fields were included: detail");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRU == null) {
                c6092b = new C6092b("Not all required fields were included: name");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRV == null) {
                c6092b = new C6092b("Not all required fields were included: phone");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else {
                c6093a.mo13480iz(1, this.f15076id);
                if (this.wRO != null) {
                    c6093a.mo13479iy(2, this.wRO.computeSize());
                    this.wRO.writeFields(c6093a);
                }
                if (this.wRP != null) {
                    c6093a.mo13479iy(3, this.wRP.computeSize());
                    this.wRP.writeFields(c6093a);
                }
                if (this.wRQ != null) {
                    c6093a.mo13479iy(4, this.wRQ.computeSize());
                    this.wRQ.writeFields(c6093a);
                }
                if (this.wRR != null) {
                    c6093a.mo13479iy(5, this.wRR.computeSize());
                    this.wRR.writeFields(c6093a);
                }
                if (this.wRS != null) {
                    c6093a.mo13479iy(6, this.wRS.computeSize());
                    this.wRS.writeFields(c6093a);
                }
                if (this.wRT != null) {
                    c6093a.mo13479iy(7, this.wRT.computeSize());
                    this.wRT.writeFields(c6093a);
                }
                if (this.wRU != null) {
                    c6093a.mo13479iy(8, this.wRU.computeSize());
                    this.wRU.writeFields(c6093a);
                }
                if (this.wRV != null) {
                    c6093a.mo13479iy(9, this.wRV.computeSize());
                    this.wRV.writeFields(c6093a);
                }
                if (this.wRW != null) {
                    c6093a.mo13479iy(10, this.wRW.computeSize());
                    this.wRW.writeFields(c6093a);
                }
                AppMethodBeat.m2505o(28605);
                return 0;
            }
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.f15076id) + 0;
            if (this.wRO != null) {
                bs += C6087a.m9557ix(2, this.wRO.computeSize());
            }
            if (this.wRP != null) {
                bs += C6087a.m9557ix(3, this.wRP.computeSize());
            }
            if (this.wRQ != null) {
                bs += C6087a.m9557ix(4, this.wRQ.computeSize());
            }
            if (this.wRR != null) {
                bs += C6087a.m9557ix(5, this.wRR.computeSize());
            }
            if (this.wRS != null) {
                bs += C6087a.m9557ix(6, this.wRS.computeSize());
            }
            if (this.wRT != null) {
                bs += C6087a.m9557ix(7, this.wRT.computeSize());
            }
            if (this.wRU != null) {
                bs += C6087a.m9557ix(8, this.wRU.computeSize());
            }
            if (this.wRV != null) {
                bs += C6087a.m9557ix(9, this.wRV.computeSize());
            }
            if (this.wRW != null) {
                bs += C6087a.m9557ix(10, this.wRW.computeSize());
            }
            AppMethodBeat.m2505o(28605);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wRP == null) {
                c6092b = new C6092b("Not all required fields were included: province");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRQ == null) {
                c6092b = new C6092b("Not all required fields were included: city");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRR == null) {
                c6092b = new C6092b("Not all required fields were included: district");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRS == null) {
                c6092b = new C6092b("Not all required fields were included: zipcode");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRT == null) {
                c6092b = new C6092b("Not all required fields were included: detail");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRU == null) {
                c6092b = new C6092b("Not all required fields were included: name");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else if (this.wRV == null) {
                c6092b = new C6092b("Not all required fields were included: phone");
                AppMethodBeat.m2505o(28605);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28605);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bpk bpk = (bpk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bpk.f15076id = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28605);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpk.wRO = bts;
                    }
                    AppMethodBeat.m2505o(28605);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpk.wRP = bts;
                    }
                    AppMethodBeat.m2505o(28605);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpk.wRQ = bts;
                    }
                    AppMethodBeat.m2505o(28605);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpk.wRR = bts;
                    }
                    AppMethodBeat.m2505o(28605);
                    return 0;
                case 6:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpk.wRS = bts;
                    }
                    AppMethodBeat.m2505o(28605);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpk.wRT = bts;
                    }
                    AppMethodBeat.m2505o(28605);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpk.wRU = bts;
                    }
                    AppMethodBeat.m2505o(28605);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpk.wRV = bts;
                    }
                    AppMethodBeat.m2505o(28605);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpk.wRW = bts;
                    }
                    AppMethodBeat.m2505o(28605);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28605);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28605);
            return -1;
        }
    }
}
