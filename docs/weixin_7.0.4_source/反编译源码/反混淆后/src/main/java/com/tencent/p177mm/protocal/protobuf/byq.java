package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.byq */
public final class byq extends btd {
    public int fJT;
    public float fJV;
    public int wXR;
    public SKBuiltinBuffer_t wXS;
    public SKBuiltinBuffer_t wXT;
    public SKBuiltinBuffer_t wXU;
    public SKBuiltinBuffer_t wXV;
    public SKBuiltinBuffer_t wXW;
    public int wXX;
    public int wXY;
    public String wXZ;
    public SKBuiltinBuffer_t wrC;
    public SKBuiltinBuffer_t wrD;
    public SKBuiltinBuffer_t wrE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(28647);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXS == null) {
                c6092b = new C6092b("Not all required fields were included: SongName");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXT == null) {
                c6092b = new C6092b("Not all required fields were included: SongSinger");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wrD == null) {
                c6092b = new C6092b("Not all required fields were included: SongAlbum");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wrE == null) {
                c6092b = new C6092b("Not all required fields were included: SongAlbumUrl");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXU == null) {
                c6092b = new C6092b("Not all required fields were included: SongWifiUrl");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXV == null) {
                c6092b = new C6092b("Not all required fields were included: SongWapLinkUrl");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXW == null) {
                c6092b = new C6092b("Not all required fields were included: SongWebUrl");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wrC == null) {
                c6092b = new C6092b("Not all required fields were included: SongLyric");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                c6093a.mo13480iz(2, this.fJT);
                c6093a.mo13480iz(3, this.wXR);
                c6093a.mo13481r(4, this.fJV);
                if (this.wXS != null) {
                    c6093a.mo13479iy(5, this.wXS.computeSize());
                    this.wXS.writeFields(c6093a);
                }
                if (this.wXT != null) {
                    c6093a.mo13479iy(6, this.wXT.computeSize());
                    this.wXT.writeFields(c6093a);
                }
                if (this.wrD != null) {
                    c6093a.mo13479iy(7, this.wrD.computeSize());
                    this.wrD.writeFields(c6093a);
                }
                if (this.wrE != null) {
                    c6093a.mo13479iy(8, this.wrE.computeSize());
                    this.wrE.writeFields(c6093a);
                }
                if (this.wXU != null) {
                    c6093a.mo13479iy(9, this.wXU.computeSize());
                    this.wXU.writeFields(c6093a);
                }
                if (this.wXV != null) {
                    c6093a.mo13479iy(10, this.wXV.computeSize());
                    this.wXV.writeFields(c6093a);
                }
                if (this.wXW != null) {
                    c6093a.mo13479iy(11, this.wXW.computeSize());
                    this.wXW.writeFields(c6093a);
                }
                if (this.wrC != null) {
                    c6093a.mo13479iy(12, this.wrC.computeSize());
                    this.wrC.writeFields(c6093a);
                }
                c6093a.mo13480iz(13, this.wXX);
                c6093a.mo13480iz(14, this.wXY);
                if (this.wXZ != null) {
                    c6093a.mo13475e(15, this.wXZ);
                }
                AppMethodBeat.m2505o(28647);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + C6091a.m9572bs(2, this.fJT)) + C6091a.m9572bs(3, this.wXR)) + (C6091a.m9576fv(4) + 4);
            if (this.wXS != null) {
                ix += C6087a.m9557ix(5, this.wXS.computeSize());
            }
            if (this.wXT != null) {
                ix += C6087a.m9557ix(6, this.wXT.computeSize());
            }
            if (this.wrD != null) {
                ix += C6087a.m9557ix(7, this.wrD.computeSize());
            }
            if (this.wrE != null) {
                ix += C6087a.m9557ix(8, this.wrE.computeSize());
            }
            if (this.wXU != null) {
                ix += C6087a.m9557ix(9, this.wXU.computeSize());
            }
            if (this.wXV != null) {
                ix += C6087a.m9557ix(10, this.wXV.computeSize());
            }
            if (this.wXW != null) {
                ix += C6087a.m9557ix(11, this.wXW.computeSize());
            }
            if (this.wrC != null) {
                ix += C6087a.m9557ix(12, this.wrC.computeSize());
            }
            ix = (ix + C6091a.m9572bs(13, this.wXX)) + C6091a.m9572bs(14, this.wXY);
            if (this.wXZ != null) {
                ix += C6091a.m9575f(15, this.wXZ);
            }
            AppMethodBeat.m2505o(28647);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXS == null) {
                c6092b = new C6092b("Not all required fields were included: SongName");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXT == null) {
                c6092b = new C6092b("Not all required fields were included: SongSinger");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wrD == null) {
                c6092b = new C6092b("Not all required fields were included: SongAlbum");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wrE == null) {
                c6092b = new C6092b("Not all required fields were included: SongAlbumUrl");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXU == null) {
                c6092b = new C6092b("Not all required fields were included: SongWifiUrl");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXV == null) {
                c6092b = new C6092b("Not all required fields were included: SongWapLinkUrl");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wXW == null) {
                c6092b = new C6092b("Not all required fields were included: SongWebUrl");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else if (this.wrC == null) {
                c6092b = new C6092b("Not all required fields were included: SongLyric");
                AppMethodBeat.m2505o(28647);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(28647);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            byq byq = (byq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 2:
                    byq.fJT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 3:
                    byq.wXR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 4:
                    byq.fJV = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byq.wXS = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28647);
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
                        byq.wXT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byq.wrD = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byq.wrE = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28647);
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
                        byq.wXU = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28647);
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
                        byq.wXV = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        byq.wXW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28647);
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
                        byq.wrC = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 13:
                    byq.wXX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 14:
                    byq.wXY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(28647);
                    return 0;
                case 15:
                    byq.wXZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(28647);
                    return 0;
                default:
                    AppMethodBeat.m2505o(28647);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(28647);
            return -1;
        }
    }
}
