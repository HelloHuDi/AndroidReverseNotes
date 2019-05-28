package com.tencent.mm.al;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.mv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d extends m implements k {
    public static long fzj = 0;
    private static Map<String, a> fzk = new HashMap();
    private final b ehh;
    private f ehi;
    private String fzl = "";
    int scene = 0;
    public long startTime = 0;

    static class a {
        boolean fzm = false;
        long fzn = 0;
        long fzo = 0;
        long fzp = 0;

        a() {
        }

        public final String toString() {
            AppMethodBeat.i(78065);
            String format = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.fzm), Long.valueOf(this.fzn), Long.valueOf(this.fzo), Long.valueOf(this.fzp)});
            AppMethodBeat.o(78065);
            return format;
        }
    }

    static {
        AppMethodBeat.i(78071);
        AppMethodBeat.o(78071);
    }

    protected d(int i) {
        AppMethodBeat.i(78066);
        ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", Integer.valueOf(i), bo.dpG());
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new agb();
        aVar.fsK = new agc();
        aVar.uri = "/cgi-bin/micromsg-bin/getcdndns";
        aVar.fsI = 379;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.scene = i;
        agb agb = (agb) this.ehh.fsG.fsP;
        agb.wnb = "";
        agb.Scene = i;
        AppMethodBeat.o(78066);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78067);
        this.ehi = fVar;
        g.RN();
        int QF = com.tencent.mm.kernel.a.QF();
        if (QF == 0) {
            ab.e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
            AppMethodBeat.o(78067);
            return -1;
        }
        if (fzj != ((long) QF)) {
            fzj = (long) QF;
            fzk.clear();
        }
        long anT = bo.anT();
        a aVar;
        if (this.scene == 0) {
            this.fzl = bo.bc(aft(), "");
            aVar = (a) fzk.get(this.fzl);
            if (aVar == null) {
                aVar = new a();
                fzk.put(this.fzl, aVar);
                ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", aVar, this.fzl);
            }
            if (aVar.fzm) {
                aVar.fzn = anT;
                aVar.fzo = anT;
                aVar.fzp = 0;
            }
            ab.d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", Long.valueOf(anT - aVar.fzn), Long.valueOf(anT - aVar.fzo), Long.valueOf(aVar.fzp));
            if (anT > aVar.fzn && anT - aVar.fzn < 10) {
                ab.w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", Long.valueOf(anT - aVar.fzn), aVar);
                AppMethodBeat.o(78067);
                return -1;
            } else if (anT <= aVar.fzo || anT - aVar.fzo >= 3600 || aVar.fzp < 90) {
                aVar.fzn = anT;
                if (anT < aVar.fzo || anT - aVar.fzp > 3600) {
                    aVar.fzo = anT;
                    aVar.fzp = 0;
                } else {
                    aVar.fzp++;
                }
            } else {
                ab.w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", Long.valueOf(anT - aVar.fzo), aVar);
                AppMethodBeat.o(78067);
                return -1;
            }
        }
        this.fzl = "";
        Iterator it = fzk.values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar != null) {
                    aVar.fzn = anT;
                    if (anT < aVar.fzo || anT - aVar.fzp > 3600) {
                        aVar.fzo = anT;
                        aVar.fzp = 0;
                    } else {
                        aVar.fzp++;
                    }
                }
            }
        }
        this.startTime = anT;
        h.pYm.a(546, this.scene == 0 ? 0 : 1, 1, true);
        QF = a(eVar, this.ehh, this);
        AppMethodBeat.o(78067);
        return QF;
    }

    private static String aft() {
        AppMethodBeat.i(78068);
        if (at.isConnected(ah.getContext())) {
            String str;
            if (at.isWifi(ah.getContext())) {
                str = "wifi_" + at.gE(ah.getContext());
            } else {
                str = "mobile_" + at.getNetTypeString(ah.getContext()) + "_" + at.getISPCode(ah.getContext());
            }
            ab.d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", str);
            if (str == null || str.length() < 2) {
                AppMethodBeat.o(78068);
                return null;
            }
            str = String.format("%x", new Object[]{Integer.valueOf(str.hashCode())});
            StringBuilder stringBuilder = new StringBuilder();
            f.afu();
            str = stringBuilder.append(f.afv()).append(str).toString();
            AppMethodBeat.o(78068);
            return str;
        }
        AppMethodBeat.o(78068);
        return null;
    }

    private static CdnInfoParams a(mv mvVar) {
        AppMethodBeat.i(78069);
        CdnInfoParams cdnInfoParams = new CdnInfoParams();
        cdnInfoParams.c2CretryIntervalMs = mvVar.vQR;
        cdnInfoParams.c2CrwtimeoutMs = mvVar.vQT;
        cdnInfoParams.c2CshowErrorDelayMs = mvVar.vQP;
        cdnInfoParams.snsretryIntervalMs = mvVar.vQS;
        cdnInfoParams.snsrwtimeoutMs = mvVar.vQU;
        cdnInfoParams.snsshowErrorDelayMs = mvVar.vQQ;
        AppMethodBeat.o(78069);
        return cdnInfoParams;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78070);
        ab.d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        agc agc = (agc) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0 && agc.vMl != null) {
            String aft = aft();
            if (!(bo.isNullOrNil(aft) || bo.isNullOrNil(this.fzl) || aft.equals(this.fzl))) {
                ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", aft, this.fzl);
                h.pYm.a(546, 6, 1, true);
            }
            fzk.clear();
            byte[] bArr2 = null;
            if (agc.vMo != null && agc.vMo.getILen() > 0) {
                ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(agc.vMo.getILen()));
                bArr2 = aa.a(agc.vMo);
            }
            byte[] bArr3 = null;
            if (agc.vMp != null && agc.vMp.getILen() > 0) {
                ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(agc.vMp.getILen()));
                bArr3 = aa.a(agc.vMp);
            }
            ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", agc.vMq);
            if (agc.vMq != null) {
                ab.i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", Integer.valueOf(agc.vMq.luF), agc.vMq.vRb);
            }
            if (f.afy().a(agc.vMl, agc.vMm, agc.vMn, bArr2, bArr3, agc.vMq)) {
                ab.i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", agc.vMs, agc.vMt, Integer.valueOf(agc.vMr));
                if (!(agc.vMs == null || agc.vMt == null)) {
                    CdnLogic.setCdnInfoParams(a(agc.vMs), a(agc.vMt), agc.vMr);
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(78070);
                return;
            }
            ab.e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(78070);
            return;
        }
        h.pYm.e(10769, Integer.valueOf(c.fzi), Integer.valueOf(0), Long.valueOf(this.startTime));
        String str2 = "MicroMsg.NetSceneGetCDNDns";
        String str3 = "onGYNetEnd: [%d ,%d]  info is null :%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(agc.vMl == null);
        ab.w(str2, str3, objArr);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78070);
    }

    public final int getType() {
        return 379;
    }
}
