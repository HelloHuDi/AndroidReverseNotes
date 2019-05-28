package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;

public final class v {

    public static class a extends d implements com.tencent.mm.protocal.l.b {
        public byte[] vxU;
        public beg vyI = new beg();

        public a() {
            AppMethodBeat.i(58861);
            AppMethodBeat.o(58861);
        }

        public final byte[] ZT() {
            byte[] bArr;
            int i = -1;
            AppMethodBeat.i(58862);
            a(z.dmv());
            this.vyI.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            this.vyI.setBaseRequest(l.a(this));
            this.vyI.wHV = g.xya;
            xu xuVar = new xu();
            xuVar.wdx = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(xuVar.wdx, pByteArray, pByteArray2);
            byte[] bArr2 = pByteArray.value;
            byte[] bArr3 = pByteArray2.value;
            if (bArr3 != null) {
                bArr = bArr3;
            } else {
                bArr = new byte[0];
            }
            this.vxU = bArr;
            String str = "MicroMsg.MMReg2.Req";
            String str2 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(xuVar.wdx);
            objArr[1] = Integer.valueOf(generateECKey);
            objArr[2] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
            if (bArr3 != null) {
                i = bArr3.length;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = bo.ca(bArr2);
            objArr[5] = bo.ca(bArr3);
            ab.d(str, str2, objArr);
            xuVar.vIn = new SKBuiltinBuffer_t().setBuffer(bArr2);
            this.vyI.vIr = xuVar;
            bArr = this.vyI.toByteArray();
            AppMethodBeat.o(58862);
            return bArr;
        }

        public final int ZU() {
            return 126;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public int eCX = 0;
        private byte[] gcB;
        private byte[] gcC;
        public byte[] vxW;
        private byte[] vxX;
        public beh vyJ = new beh();

        public b() {
            AppMethodBeat.i(58863);
            AppMethodBeat.o(58863);
        }

        public final int P(byte[] bArr) {
            AppMethodBeat.i(58864);
            this.eCX = 0;
            this.vyJ = (beh) new beh().parseFrom(bArr);
            l.a(this, this.vyJ.getBaseResponse());
            this.eCX = 0;
            int i = this.vyJ.getBaseResponse().Ret;
            AppMethodBeat.o(58864);
            return i;
        }

        public final int getCmdId() {
            return 0;
        }

        public final void b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            AppMethodBeat.i(58865);
            this.vxX = bArr;
            this.gcB = bArr2;
            this.gcC = bArr3;
            ab.i("MicroMsg.MMReg2.Resp", "summerauths setSession [%s] [%s] [%s]", bo.anv(bo.ca(this.vxX)), bo.anv(bo.ca(this.gcB)), bo.anv(bo.ca(this.gcC)));
            AppMethodBeat.o(58865);
        }

        public final byte[] LA(int i) {
            byte[] bArr = new byte[0];
            switch (i) {
                case 1:
                    return this.vxX;
                case 2:
                    return this.gcB;
                case 3:
                    return this.gcC;
                default:
                    return bArr;
            }
        }
    }
}
