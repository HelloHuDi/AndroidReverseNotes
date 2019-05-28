package com.tencent.p177mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.C4836l.C4832b;
import com.tencent.p177mm.protocal.C4836l.C4833c;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C7253bag;
import com.tencent.p177mm.protocal.protobuf.C7261gg;
import com.tencent.p177mm.protocal.protobuf.C7262gh;
import com.tencent.p177mm.protocal.protobuf.C7287xu;
import com.tencent.p177mm.protocal.protobuf.C7540ge;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.baf;
import com.tencent.p177mm.protocal.protobuf.bah;
import com.tencent.p177mm.protocal.protobuf.cjj;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C7574bs;
import java.io.IOException;

/* renamed from: com.tencent.mm.protocal.j */
public final class C4824j {

    /* renamed from: com.tencent.mm.protocal.j$c */
    public interface C4823c {

        /* renamed from: com.tencent.mm.protocal.j$c$a */
        public static class C4822a {
            public static C4823c vxR;
        }

        /* renamed from: ZP */
        int mo9983ZP();

        /* renamed from: a */
        void mo9984a(C4825f c4825f, C4826g c4826g, int i, int i2, String str);

        /* renamed from: cn */
        C1929q mo9985cn(int i, int i2);
    }

    /* renamed from: com.tencent.mm.protocal.j$f */
    public static abstract class C4825f extends C4834d implements C4832b {
        public byte[] vxU;

        public abstract String getUri();

        /* renamed from: bL */
        public final void mo9986bL(byte[] bArr) {
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.vxU = bArr;
        }
    }

    /* renamed from: com.tencent.mm.protocal.j$g */
    public static abstract class C4826g extends C4835e implements C4833c {
        public int eCX = 0;
        private byte[] gcB;
        private byte[] gcC;
        public String gcF;
        public cjj vxV = new cjj();
        public byte[] vxW;
        private byte[] vxX;

        /* renamed from: b */
        public final void mo9989b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.vxX = bArr;
            this.gcB = bArr2;
            this.gcC = bArr3;
            C4990ab.m7417i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", C5046bo.anv(C5046bo.m7539ca(this.vxX)), C5046bo.anv(C5046bo.m7539ca(this.gcB)), C5046bo.anv(C5046bo.m7539ca(this.gcC)));
        }

        /* renamed from: LA */
        public final byte[] mo9988LA(int i) {
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
            C4990ab.m7417i(str, str2, objArr);
            return bArr;
        }
    }

    /* renamed from: com.tencent.mm.protocal.j$a */
    public static class C4827a extends C4825f implements C4832b {
        public String username;
        public C7261gg vxQ = new C7261gg();

        public C4827a() {
            AppMethodBeat.m2504i(58833);
            AppMethodBeat.m2505o(58833);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            int i;
            int i2 = -1;
            AppMethodBeat.m2504i(58834);
            C1668a.m3405lD("");
            if (this.vyf == 12) {
                i = 1;
            } else {
                C1720g.m3537RQ();
                i = C1720g.m3536RP().eJH.mo10573Ml(46);
            }
            C4990ab.m7411d("MicroMsg.AutoReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r3), Integer.valueOf(i));
            mo9995a(C4851z.dmv());
            if (10002 == C1947ae.giz && C1947ae.giA > 0) {
                C1947ae.giA = 0;
                C4851z.m7216O("", "", 0);
            }
            C7540ge c7540ge = this.vxQ.vIp;
            c7540ge.setBaseRequest(C4836l.m7194a(this));
            C4990ab.m7417i("MicroMsg.AutoReq", "summerauth autoauth toProtoBuf uin[%d]", Integer.valueOf(this.vyb));
            c7540ge.nqc = C1427q.m3026LK();
            c7540ge.vIh = C6998b.oTO.mo8083An(i);
            c7540ge.vIi = 0;
            c7540ge.vIj = C1668a.m3397Rb();
            c7540ge.guQ = C5046bo.m7557gS(C4996ah.getContext());
            c7540ge.jBF = C7243d.DEVICE_NAME;
            c7540ge.vIk = C7574bs.dut();
            c7540ge.luQ = C4988aa.dor();
            c7540ge.luP = C5046bo.dpA();
            c7540ge.vAM = C5059g.cdf;
            C1720g.m3537RQ();
            C4990ab.m7411d("MicroMsg.AutoReq", "summerecdh ksid:%s, flag:%d", (String) C1720g.m3536RP().eJH.get(18), Integer.valueOf(c7540ge.vIg.vJW));
            c7540ge.vIg.vJU.vMb = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(r0));
            try {
                byte[] bVS = C6998b.oTO.bVS();
                String str = "MicroMsg.AutoReq";
                String str2 = "[tomys] ccd set on auto auth, len: %s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bVS != null ? bVS.length : -1);
                C4990ab.m7411d(str, str2, objArr);
                c7540ge.vIl = new SKBuiltinBuffer_t().setBuffer(bVS);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.AutoReq", th, "cc throws exception.", new Object[0]);
            }
            C7262gh c7262gh = this.vxQ.vIo;
            C7287xu c7287xu = new C7287xu();
            c7287xu.wdx = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(c7287xu.wdx, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            mo9986bL(bArr2);
            String str3 = "MicroMsg.AutoReq";
            String str4 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr2 = new Object[6];
            objArr2[0] = Integer.valueOf(c7287xu.wdx);
            objArr2[1] = Integer.valueOf(generateECKey);
            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr2[3] = Integer.valueOf(i2);
            objArr2[4] = C5046bo.m7539ca(bArr);
            objArr2[5] = C5046bo.m7539ca(bArr2);
            C4990ab.m7411d(str3, str4, objArr2);
            c7287xu.vIn = new SKBuiltinBuffer_t().setBuffer(bArr);
            c7262gh.vIr = c7287xu;
            C4990ab.m7417i("MicroMsg.AutoReq", "summerauth auto IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d]", c7540ge.nqc, c7540ge.vIh, c7540ge.vIj, c7540ge.guQ, c7540ge.jBF, c7540ge.vIk, c7540ge.luQ, c7540ge.luP, Integer.valueOf(c7540ge.vAM), Integer.valueOf(C5059g.cdf), Integer.valueOf(C5059g.xya));
            try {
                byte[] toByteArray = this.vxQ.toByteArray();
                AppMethodBeat.m2505o(58834);
                return toByteArray;
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.AutoReq", "summerauth toProtoBuf :%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(58834);
                return null;
            }
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C4815f.vxx ? 763 : 702;
        }

        public final String getUri() {
            return C4815f.vxx ? "/cgi-bin/micromsg-bin/secautoauth" : "/cgi-bin/micromsg-bin/autoauth";
        }
    }

    /* renamed from: com.tencent.mm.protocal.j$b */
    public static class C4828b extends C4826g implements C4833c {
        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(58835);
            try {
                this.vxV = (cjj) this.vxV.parseFrom(bArr);
                C4836l.m7195a(this, this.vxV.getBaseResponse());
                this.eCX = 0;
                if (this.vxV.getBaseResponse().Ret == 0 && (this.vxV.xid == null || this.vxV.xid.luF == 0 || C5046bo.m7540cb(C1946aa.m4150a(this.vxV.xid.vHG)))) {
                    C4990ab.m7412e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.vxV.getBaseResponse().Ret = -1;
                }
                C4990ab.m7417i("MicroMsg.MMAuth", "summerauthkick auto errmsg[%s]", this.vyn);
                C1668a.m3405lD(r0);
                int i = this.vxV.getBaseResponse().Ret;
                AppMethodBeat.m2505o(58835);
                return i;
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.MMAuth", "toProtoBuf :%s", C5046bo.m7574l(e));
                this.vxV.getBaseResponse().Ret = -1;
                AppMethodBeat.m2505o(58835);
                return -1;
            }
        }
    }

    /* renamed from: com.tencent.mm.protocal.j$d */
    public static class C4829d extends C4825f implements C4832b {
        public C7253bag vxS = new C7253bag();
        public boolean vxT = false;

        public C4829d() {
            AppMethodBeat.m2504i(58836);
            AppMethodBeat.m2505o(58836);
        }

        /* renamed from: ZT */
        public final byte[] mo5742ZT() {
            int i;
            int i2 = -1;
            AppMethodBeat.m2504i(58837);
            C1668a.m3405lD("");
            if (this.vyf == 16) {
                i = 1;
            } else if (this.vxT) {
                i = 3;
            } else {
                C1720g.m3537RQ();
                i = C1720g.m3536RP().eJH.mo10573Ml(46);
            }
            C4990ab.m7411d("MicroMsg.ManualReq", "summerstatus[%d] clientUpgrade[%d]", Integer.valueOf(r4), Integer.valueOf(i));
            if (10002 == C1947ae.giz && C1947ae.giA > 0) {
                C1947ae.giA = 0;
                C4851z.m7216O("", "", 0);
            }
            mo9995a(C4851z.dmv());
            baf baf = this.vxS.wEc;
            baf.setBaseRequest(C4836l.m7194a(this));
            baf.nqc = C1427q.m3026LK();
            baf.vIh = C6998b.oTO.mo8083An(i);
            baf.vIi = 0;
            baf.vIj = C1668a.m3397Rb();
            baf.guQ = C5046bo.m7557gS(C4996ah.getContext());
            baf.jBF = C7243d.DEVICE_NAME;
            baf.vIk = C7574bs.dut();
            baf.luQ = C4988aa.dor();
            baf.luP = C5046bo.dpA();
            baf.vAM = C5059g.cdf;
            if (10012 == C1947ae.giz && C1947ae.giA > 0) {
                baf.vAM = C1947ae.giA;
            }
            baf.vOA = C7243d.vxi;
            baf.vOz = C7243d.vxj;
            baf.wDX = C7243d.vxk;
            baf.wdz = C1427q.getSimCountryIso();
            C1720g.m3537RQ();
            C4990ab.m7411d("MicroMsg.ManualReq", "summerauth ksid:%s authreq flag:%d", (String) C1720g.m3536RP().eJH.get(18), Integer.valueOf(baf.vIg.vJW));
            baf.vIg.vJU.vMb = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(r0));
            try {
                byte[] bVS = C6998b.oTO.bVS();
                String str = "MicroMsg.ManualReq";
                String str2 = "[tomys] ccd set on manual auth, len: %s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bVS != null ? bVS.length : -1);
                C4990ab.m7411d(str, str2, objArr);
                baf.vIl = new SKBuiltinBuffer_t().setBuffer(bVS);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.ManualReq", th, "cc throws exception.", new Object[0]);
            }
            bah bah = this.vxS.wEb;
            bah.vLz = new SKBuiltinBuffer_t().setBuffer(C5046bo.dpz());
            C7287xu c7287xu = new C7287xu();
            c7287xu.wdx = 713;
            PByteArray pByteArray = new PByteArray();
            PByteArray pByteArray2 = new PByteArray();
            int generateECKey = MMProtocalJni.generateECKey(c7287xu.wdx, pByteArray, pByteArray2);
            byte[] bArr = pByteArray.value;
            byte[] bArr2 = pByteArray2.value;
            mo9986bL(bArr2);
            String str3 = "MicroMsg.ManualReq";
            String str4 = "summerecdh nid:%d ret:%d, pub len: %d, pri len:%d, pub:%s, pri:%s";
            Object[] objArr2 = new Object[6];
            objArr2[0] = Integer.valueOf(c7287xu.wdx);
            objArr2[1] = Integer.valueOf(generateECKey);
            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            if (bArr2 != null) {
                i2 = bArr2.length;
            }
            objArr2[3] = Integer.valueOf(i2);
            objArr2[4] = C5046bo.m7539ca(bArr);
            objArr2[5] = C5046bo.m7539ca(bArr2);
            C4990ab.m7411d(str3, str4, objArr2);
            c7287xu.vIn = new SKBuiltinBuffer_t().setBuffer(bArr);
            bah.vIr = c7287xu;
            C4990ab.m7417i("MicroMsg.ManualReq", "summerauth manual IMEI:%s SoftType:%s ClientSeqID:%s Signature:%s DeviceName:%s DeviceType:%s Language:%s TimeZone:%s chan[%d,%d,%d] DeviceBrand:%s DeviceModel:%s OSType:%s RealCountry:%s", baf.nqc, baf.vIh, baf.vIj, baf.guQ, baf.jBF, baf.vIk, baf.luQ, baf.luP, Integer.valueOf(baf.vAM), Integer.valueOf(C5059g.cdf), Integer.valueOf(C5059g.xya), baf.vOA, baf.vOz, baf.wDX, baf.wdz);
            try {
                byte[] toByteArray = this.vxS.toByteArray();
                AppMethodBeat.m2505o(58837);
                return toByteArray;
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.ManualReq", "summerauth toProtoBuf :%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(58837);
                return null;
            }
        }

        /* renamed from: ZU */
        public final int mo5743ZU() {
            return C4815f.vxx ? 252 : 701;
        }

        public final String getUri() {
            return C4815f.vxx ? "/cgi-bin/micromsg-bin/secmanualauth" : "/cgi-bin/micromsg-bin/manualauth";
        }
    }

    /* renamed from: com.tencent.mm.protocal.j$e */
    public static class C4830e extends C4826g implements C4833c {
        /* renamed from: P */
        public final int mo5744P(byte[] bArr) {
            AppMethodBeat.m2504i(58838);
            try {
                this.vxV = (cjj) this.vxV.parseFrom(bArr);
                C4836l.m7195a(this, this.vxV.getBaseResponse());
                this.eCX = 0;
                if (this.vxV.getBaseResponse().Ret == 0 && (this.vxV.xid == null || this.vxV.xid.luF == 0 || C5046bo.m7540cb(C1946aa.m4150a(this.vxV.xid.vHG)))) {
                    C4990ab.m7412e("MicroMsg.MMAuth", "retcode 0 but invalid auth sect resp or invalid uin or invalid session");
                    this.vxV.getBaseResponse().Ret = -1;
                }
                C4990ab.m7417i("MicroMsg.MMAuth", "summerauthkick manual errmsg[%s]", this.vyn);
                C1668a.m3405lD(r0);
                int i = this.vxV.getBaseResponse().Ret;
                AppMethodBeat.m2505o(58838);
                return i;
            } catch (IOException e) {
                C4990ab.m7413e("MicroMsg.MMAuth", "toProtoBuf :%s", C5046bo.m7574l(e));
                this.vxV.getBaseResponse().Ret = -1;
                AppMethodBeat.m2505o(58838);
                return -1;
            }
        }
    }
}
