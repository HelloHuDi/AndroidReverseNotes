package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

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

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28647);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXS == null) {
                bVar = new b("Not all required fields were included: SongName");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXT == null) {
                bVar = new b("Not all required fields were included: SongSinger");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wrD == null) {
                bVar = new b("Not all required fields were included: SongAlbum");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wrE == null) {
                bVar = new b("Not all required fields were included: SongAlbumUrl");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXU == null) {
                bVar = new b("Not all required fields were included: SongWifiUrl");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXV == null) {
                bVar = new b("Not all required fields were included: SongWapLinkUrl");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXW == null) {
                bVar = new b("Not all required fields were included: SongWebUrl");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wrC == null) {
                bVar = new b("Not all required fields were included: SongLyric");
                AppMethodBeat.o(28647);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.fJT);
                aVar.iz(3, this.wXR);
                aVar.r(4, this.fJV);
                if (this.wXS != null) {
                    aVar.iy(5, this.wXS.computeSize());
                    this.wXS.writeFields(aVar);
                }
                if (this.wXT != null) {
                    aVar.iy(6, this.wXT.computeSize());
                    this.wXT.writeFields(aVar);
                }
                if (this.wrD != null) {
                    aVar.iy(7, this.wrD.computeSize());
                    this.wrD.writeFields(aVar);
                }
                if (this.wrE != null) {
                    aVar.iy(8, this.wrE.computeSize());
                    this.wrE.writeFields(aVar);
                }
                if (this.wXU != null) {
                    aVar.iy(9, this.wXU.computeSize());
                    this.wXU.writeFields(aVar);
                }
                if (this.wXV != null) {
                    aVar.iy(10, this.wXV.computeSize());
                    this.wXV.writeFields(aVar);
                }
                if (this.wXW != null) {
                    aVar.iy(11, this.wXW.computeSize());
                    this.wXW.writeFields(aVar);
                }
                if (this.wrC != null) {
                    aVar.iy(12, this.wrC.computeSize());
                    this.wrC.writeFields(aVar);
                }
                aVar.iz(13, this.wXX);
                aVar.iz(14, this.wXY);
                if (this.wXZ != null) {
                    aVar.e(15, this.wXZ);
                }
                AppMethodBeat.o(28647);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.fJT)) + e.a.a.b.b.a.bs(3, this.wXR)) + (e.a.a.b.b.a.fv(4) + 4);
            if (this.wXS != null) {
                ix += e.a.a.a.ix(5, this.wXS.computeSize());
            }
            if (this.wXT != null) {
                ix += e.a.a.a.ix(6, this.wXT.computeSize());
            }
            if (this.wrD != null) {
                ix += e.a.a.a.ix(7, this.wrD.computeSize());
            }
            if (this.wrE != null) {
                ix += e.a.a.a.ix(8, this.wrE.computeSize());
            }
            if (this.wXU != null) {
                ix += e.a.a.a.ix(9, this.wXU.computeSize());
            }
            if (this.wXV != null) {
                ix += e.a.a.a.ix(10, this.wXV.computeSize());
            }
            if (this.wXW != null) {
                ix += e.a.a.a.ix(11, this.wXW.computeSize());
            }
            if (this.wrC != null) {
                ix += e.a.a.a.ix(12, this.wrC.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(13, this.wXX)) + e.a.a.b.b.a.bs(14, this.wXY);
            if (this.wXZ != null) {
                ix += e.a.a.b.b.a.f(15, this.wXZ);
            }
            AppMethodBeat.o(28647);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXS == null) {
                bVar = new b("Not all required fields were included: SongName");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXT == null) {
                bVar = new b("Not all required fields were included: SongSinger");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wrD == null) {
                bVar = new b("Not all required fields were included: SongAlbum");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wrE == null) {
                bVar = new b("Not all required fields were included: SongAlbumUrl");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXU == null) {
                bVar = new b("Not all required fields were included: SongWifiUrl");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXV == null) {
                bVar = new b("Not all required fields were included: SongWapLinkUrl");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wXW == null) {
                bVar = new b("Not all required fields were included: SongWebUrl");
                AppMethodBeat.o(28647);
                throw bVar;
            } else if (this.wrC == null) {
                bVar = new b("Not all required fields were included: SongLyric");
                AppMethodBeat.o(28647);
                throw bVar;
            } else {
                AppMethodBeat.o(28647);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byq byq = (byq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28647);
                    return 0;
                case 2:
                    byq.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(28647);
                    return 0;
                case 3:
                    byq.wXR = aVar3.BTU.vd();
                    AppMethodBeat.o(28647);
                    return 0;
                case 4:
                    byq.fJV = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(28647);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byq.wXS = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28647);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byq.wXT = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28647);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byq.wrD = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28647);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byq.wrE = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28647);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byq.wXU = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28647);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byq.wXV = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28647);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byq.wXW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28647);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byq.wrC = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28647);
                    return 0;
                case 13:
                    byq.wXX = aVar3.BTU.vd();
                    AppMethodBeat.o(28647);
                    return 0;
                case 14:
                    byq.wXY = aVar3.BTU.vd();
                    AppMethodBeat.o(28647);
                    return 0;
                case 15:
                    byq.wXZ = aVar3.BTU.readString();
                    AppMethodBeat.o(28647);
                    return 0;
                default:
                    AppMethodBeat.o(28647);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28647);
            return -1;
        }
    }
}
