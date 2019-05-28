package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import java.io.IOException;

public final class j {

    public interface c {

        public static class a {
            public static c vxR;
        }

        int ZP();

        void a(f fVar, g gVar, int i, int i2, String str);

        q cn(int i, int i2);
    }

    public static abstract class f extends com.tencent.mm.protocal.l.d implements com.tencent.mm.protocal.l.b {
        public byte[] vxU;

        public abstract String getUri();

        public final void bL(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.vxU = bArr;
        }
    }

    public static abstract class g extends com.tencent.mm.protocal.l.e implements com.tencent.mm.protocal.l.c {
        public int eCX = 0;
        private byte[] gcB;
        private byte[] gcC;
        public String gcF;
        public cjj vxV = new cjj();
        public byte[] vxW;
        private byte[] vxX;

        public final void b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.vxX = bArr;
            this.gcB = bArr2;
            this.gcC = bArr3;
            ab.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", bo.anv(bo.ca(this.vxX)), bo.anv(bo.ca(this.gcB)), bo.anv(bo.ca(this.gcC)));
        }

        public final byte[] LA(int i) {
            byte[] bArr = new byte[0];
            switch (i) {
                case 1:
                    bArr = this.vxX;
                    break;
                case 2:
                    bArr = this.gcB;
                    break;
                case 3:
                    bArr = this.gcC;
                    break;
            }
            String str = "MicroMsg.MMAuth";
            String str2 = "summerauths getSession seesionKeyType[%s] [%s]";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            ab.i(str, str2, objArr);
            return bArr;
        }
    }

    public static class a extends f implements com.tencent.mm.protocal.l.b {
        public String username;
        public gg vxQ = new gg();

        public a() {
            AppMethodBeat.i(58833);
            AppMethodBeat.o(58833);
        }

        public final byte[] ZT() {
            int i;
            int i2 = -1;
            AppMethodBeat.i(58834);
            com.tencent.mm.kernel.a.lD("");
            if (this.vyf == 12) {
                i = 1;
            } else {
                com.tencent.mm.kernel.g.RQ();
                i = com.tencent.mm.kernel.g.RP().eJH.Ml(46);
            }
            ab.d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r3), Integer.valueOf(i));
            a(z.dmv());
            if (10002 == ae.giz && ae.giA > 0) {
                ae.giA = 0;
                z.O("", "", 0);
            }
            ge geVar = this.vxQ.vIp;
            geVar.setBaseRequest(l.a(this));
            ab.i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", Integer.valueOf(this.vyb));
            geVar.nqc = com.tencent.mm.compatible.e.q.LK();
            geVar.vIh = com.tencent.mm.plugin.normsg.a.b.oTO.An(i);
            geVar.vIi = 0;
            geVar.vIj = com.tencent.mm.kernel.a.Rb();
            geVar.guQ = bo.gS(ah.getContext());
            geVar.jBF = d.DEVICE_NAME;
            geVar.vIk = bs.dut();
            geVar.luQ = aa.dor();
            geVar.luP = bo.dpA();
            geVar.vAM = com.tencent.mm.sdk.platformtools.g.cdf;
            com.tencent.mm.kernel.g.RQ();
            ab.d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", (String) com.tencent.mm.kernel.g.RP().eJH.get(18), Integer.valueOf(geVar.vIg.vJW));
            geVar.vIg.vJU.vMb = new SKBuiltinBuffer_t().setBuffer(bo.anf(r0));
            try {
                byte[] bVS = com.tencent.mm.plugin.normsg.a.b.oTO.bVS();
                String str = "MicroMsg.AutoReq";
                String str2 = "[tomys] ccd set on auto auth, len: %s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bVS != null ? bVS.length : -1);
                ab.d(str, str2, objArr);
                geVar.vIl = new SKBuiltinBuffer_t().setBuffer(bVS);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.AutoReq", th, "cc throws exception.", new Object[0]);
            }
            gh ghVar = this.vxQ.vIo;
            xu xuVar = new xu();
            xuVar.wdx = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(xuVar.wdx, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            bL(bArr2);
            String str3 = "MicroMsg.AutoReq";
            String str4 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr2 = new Object[6];
            objArr2[0] = Integer.valueOf(xuVar.wdx);
            objArr2[1] = Integer.valueOf(generateECKey);
            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr2[3] = Integer.valueOf(i2);
            objArr2[4] = bo.ca(bArr);
            objArr2[5] = bo.ca(bArr2);
            ab.d(str3, str4, objArr2);
            xuVar.vIn = new SKBuiltinBuffer_t().setBuffer(bArr);
            ghVar.vIr = xuVar;
            ab.i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", geVar.nqc, geVar.vIh, geVar.vIj, geVar.guQ, geVar.jBF, geVar.vIk, geVar.luQ, geVar.luP, Integer.valueOf(geVar.vAM), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.cdf), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.xya));
            try {
                byte[] toByteArray = this.vxQ.toByteArray();
                AppMethodBeat.o(58834);
                return toByteArray;
            } catch (IOException e) {
                ab.e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", bo.l(e));
                AppMethodBeat.o(58834);
                return null;
            }
        }

        public final int ZU() {
            return f.vxx ? 763 : 702;
        }

        public final String getUri() {
            return f.vxx ? "/cgi-bin/micromsg-bin/secautoauth" : "/cgi-bin/micromsg-bin/autoauth";
        }
    }

    public static class b extends g implements com.tencent.mm.protocal.l.c {
        public final int P(byte[] bArr) {
            AppMethodBeat.i(58835);
            try {
                this.vxV = (cjj) this.vxV.parseFrom(bArr);
                l.a(this, this.vxV.getBaseResponse());
                this.eCX = 0;
                if (this.vxV.getBaseResponse().Ret == 0 && (this.vxV.xid == null || this.vxV.xid.luF == 0 || bo.cb(com.tencent.mm.platformtools.aa.a(this.vxV.xid.vHG)))) {
                    ab.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.vxV.getBaseResponse().Ret = -1;
                }
                ab.i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", this.vyn);
                com.tencent.mm.kernel.a.lD(r0);
                int i = this.vxV.getBaseResponse().Ret;
                AppMethodBeat.o(58835);
                return i;
            } catch (IOException e) {
                ab.e("MicroMsg.MMAuth", "toProtoBuf :%s", bo.l(e));
                this.vxV.getBaseResponse().Ret = -1;
                AppMethodBeat.o(58835);
                return -1;
            }
        }
    }

    public static class d extends f implements com.tencent.mm.protocal.l.b {
        public bag vxS = new bag();
        public boolean vxT = false;

        public d() {
            AppMethodBeat.i(58836);
            AppMethodBeat.o(58836);
        }

        public final byte[] ZT() {
            int i;
            int i2 = -1;
            AppMethodBeat.i(58837);
            com.tencent.mm.kernel.a.lD("");
            if (this.vyf == 16) {
                i = 1;
            } else if (this.vxT) {
                i = 3;
            } else {
                com.tencent.mm.kernel.g.RQ();
                i = com.tencent.mm.kernel.g.RP().eJH.Ml(46);
            }
            ab.d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r4), Integer.valueOf(i));
            if (10002 == ae.giz && ae.giA > 0) {
                ae.giA = 0;
                z.O("", "", 0);
            }
            a(z.dmv());
            baf baf = this.vxS.wEc;
            baf.setBaseRequest(l.a(this));
            baf.nqc = com.tencent.mm.compatible.e.q.LK();
            baf.vIh = com.tencent.mm.plugin.normsg.a.b.oTO.An(i);
            baf.vIi = 0;
            baf.vIj = com.tencent.mm.kernel.a.Rb();
            baf.guQ = bo.gS(ah.getContext());
            baf.jBF = d.DEVICE_NAME;
            baf.vIk = bs.dut();
            baf.luQ = aa.dor();
            baf.luP = bo.dpA();
            baf.vAM = com.tencent.mm.sdk.platformtools.g.cdf;
            if (10012 == ae.giz && ae.giA > 0) {
                baf.vAM = ae.giA;
            }
            baf.vOA = d.vxi;
            baf.vOz = d.vxj;
            baf.wDX = d.vxk;
            baf.wdz = com.tencent.mm.compatible.e.q.getSimCountryIso();
            com.tencent.mm.kernel.g.RQ();
            ab.d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", (String) com.tencent.mm.kernel.g.RP().eJH.get(18), Integer.valueOf(baf.vIg.vJW));
            baf.vIg.vJU.vMb = new SKBuiltinBuffer_t().setBuffer(bo.anf(r0));
            try {
                byte[] bVS = com.tencent.mm.plugin.normsg.a.b.oTO.bVS();
                String str = "MicroMsg.ManualReq";
                String str2 = "[tomys] ccd set on manual auth, len: %s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bVS != null ? bVS.length : -1);
                ab.d(str, str2, objArr);
                baf.vIl = new SKBuiltinBuffer_t().setBuffer(bVS);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.ManualReq", th, "cc throws exception.", new Object[0]);
            }
            bah bah = this.vxS.wEb;
            bah.vLz = new SKBuiltinBuffer_t().setBuffer(bo.dpz());
            xu xuVar = new xu();
            xuVar.wdx = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(xuVar.wdx, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            bL(bArr2);
            String str3 = "MicroMsg.ManualReq";
            String str4 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr2 = new Object[6];
            objArr2[0] = Integer.valueOf(xuVar.wdx);
            objArr2[1] = Integer.valueOf(generateECKey);
            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr2[3] = Integer.valueOf(i2);
            objArr2[4] = bo.ca(bArr);
            objArr2[5] = bo.ca(bArr2);
            ab.d(str3, str4, objArr2);
            xuVar.vIn = new SKBuiltinBuffer_t().setBuffer(bArr);
            bah.vIr = xuVar;
            ab.i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", baf.nqc, baf.vIh, baf.vIj, baf.guQ, baf.jBF, baf.vIk, baf.luQ, baf.luP, Integer.valueOf(baf.vAM), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.cdf), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.xya), baf.vOA, baf.vOz, baf.wDX, baf.wdz);
            try {
                byte[] toByteArray = this.vxS.toByteArray();
                AppMethodBeat.o(58837);
                return toByteArray;
            } catch (IOException e) {
                ab.e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", bo.l(e));
                AppMethodBeat.o(58837);
                return null;
            }
        }

        public final int ZU() {
            return f.vxx ? 252 : 701;
        }

        public final String getUri() {
            return f.vxx ? "/cgi-bin/micromsg-bin/secmanualauth" : "/cgi-bin/micromsg-bin/manualauth";
        }
    }

    public static class e extends g implements com.tencent.mm.protocal.l.c {
        public final int P(byte[] bArr) {
            AppMethodBeat.i(58838);
            try {
                this.vxV = (cjj) this.vxV.parseFrom(bArr);
                l.a(this, this.vxV.getBaseResponse());
                this.eCX = 0;
                if (this.vxV.getBaseResponse().Ret == 0 && (this.vxV.xid == null || this.vxV.xid.luF == 0 || bo.cb(com.tencent.mm.platformtools.aa.a(this.vxV.xid.vHG)))) {
                    ab.e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.vxV.getBaseResponse().Ret = -1;
                }
                ab.i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", this.vyn);
                com.tencent.mm.kernel.a.lD(r0);
                int i = this.vxV.getBaseResponse().Ret;
                AppMethodBeat.o(58838);
                return i;
            } catch (IOException e) {
                ab.e("MicroMsg.MMAuth", "toProtoBuf :%s", bo.l(e));
                this.vxV.getBaseResponse().Ret = -1;
                AppMethodBeat.o(58838);
                return -1;
            }
        }
    }
}
