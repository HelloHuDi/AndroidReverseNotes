package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.t;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public final yk vyy = new yk();

        public a() {
            AppMethodBeat.i(79996);
            hB(0);
            this.vyy.wek = new yj();
            this.vyy.wek.wei = new rq();
            this.vyy.wej = new yl();
            AppMethodBeat.o(79996);
        }

        public final byte[] ZT() {
            AppMethodBeat.i(79997);
            a(z.dmv());
            this.vyy.wek.setBaseRequest(l.a(this));
            this.vyy.wej.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.vyi = this.vyy.wej.vLz.getBuffer().toByteArray();
            this.vyh = new com.tencent.mm.protocal.l.a() {
                public final boolean a(PByteArray pByteArray, int i, byte[] bArr, byte[] bArr2, int i2) {
                    long j;
                    AppMethodBeat.i(79995);
                    com.tencent.mm.protocal.l.b bVar = (com.tencent.mm.protocal.l.b) this;
                    long j2 = (long) this.vyb;
                    if (com.tencent.mm.sdk.a.b.dnO() && j2 == 0) {
                        j = d.vxn;
                    } else {
                        j = j2;
                    }
                    z zVar = this.vyj;
                    byte[] bArr3;
                    if (i == 722) {
                        ab.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
                        yk ykVar = ((a) this).vyy;
                        byte[][] a = t.a(j, ykVar.wej, ykVar.wek);
                        if (a == null) {
                            AppMethodBeat.o(79995);
                            return false;
                        }
                        bArr3 = a[0];
                        byte[] bArr4 = a[1];
                        if (MMProtocalJni.packHybrid(pByteArray, bArr, this.vye, (int) j, bVar.ZU(), zVar.ver, bArr3, bArr4, zVar.vyO.getBytes(), zVar.vyP.getBytes(), this.vyi, i2, ((a) this).fsO)) {
                            ab.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i2));
                            AppMethodBeat.o(79995);
                            return true;
                        }
                    } else if (i == 784) {
                        ab.i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", Integer.valueOf(zVar.ver), Boolean.valueOf(f.vxx), Long.valueOf(((com.tencent.mm.protocal.l.b) this).ads()));
                        ((com.tencent.mm.protocal.l.b) this).ZU();
                        PByteArray pByteArray2 = new PByteArray();
                        byte[] ZT = ((com.tencent.mm.protocal.l.b) this).ZT();
                        if (ZT == null) {
                            ab.f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
                            AppMethodBeat.o(79995);
                            return false;
                        }
                        long bK = f.bK(null);
                        this.vyk = bK;
                        bArr3 = UtilsJni.HybridEcdhEncrypt(bK, ZT);
                        ab.d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", Integer.valueOf(i), Integer.valueOf(f.vxC), Integer.valueOf(pByteArray2.value.length), Integer.valueOf(i2), Boolean.valueOf(MMProtocalJni.packHybridEcdh(pByteArray2, bArr, this.vye, (int) j, bVar.ZU(), f.vxC, bArr3, i2, bVar.dmr())));
                        AppMethodBeat.o(79995);
                        return MMProtocalJni.packHybridEcdh(pByteArray2, bArr, this.vye, (int) j, bVar.ZU(), f.vxC, bArr3, i2, bVar.dmr());
                    }
                    AppMethodBeat.o(79995);
                    return false;
                }
            };
            byte[] toByteArray = this.vyy.toByteArray();
            AppMethodBeat.o(79997);
            return toByteArray;
        }

        public final int ZU() {
            return f.vxx ? 784 : 722;
        }
    }

    public static class b extends e implements c {
        public final rr vyB = new rr();

        public b() {
            AppMethodBeat.i(79998);
            AppMethodBeat.o(79998);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(79999);
            this.vyB.parseFrom(bArr);
            int i = this.vyB.BaseResponse.Ret;
            AppMethodBeat.o(79999);
            return i;
        }
    }
}
