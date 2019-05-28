package com.tencent.p177mm.p187al;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnInfoParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23417mv;
import com.tencent.p177mm.protocal.protobuf.agb;
import com.tencent.p177mm.protocal.protobuf.agc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.al.d */
public final class C32243d extends C1207m implements C1918k {
    public static long fzj = 0;
    private static Map<String, C17910a> fzk = new HashMap();
    private final C7472b ehh;
    private C1202f ehi;
    private String fzl = "";
    int scene = 0;
    public long startTime = 0;

    /* renamed from: com.tencent.mm.al.d$a */
    static class C17910a {
        boolean fzm = false;
        long fzn = 0;
        long fzo = 0;
        long fzp = 0;

        C17910a() {
        }

        public final String toString() {
            AppMethodBeat.m2504i(78065);
            String format = String.format("LastGetResult(%x){isTimeOut=%b, lastGetCDNDns_TenSecond=%d, lastTime_Hour=%d, lastCount_Hour=%d}", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.fzm), Long.valueOf(this.fzn), Long.valueOf(this.fzo), Long.valueOf(this.fzp)});
            AppMethodBeat.m2505o(78065);
            return format;
        }
    }

    static {
        AppMethodBeat.m2504i(78071);
        AppMethodBeat.m2505o(78071);
    }

    protected C32243d(int i) {
        AppMethodBeat.m2504i(78066);
        C4990ab.m7417i("MicroMsg.NetSceneGetCDNDns", "summersafecdn init Scene:%d  [%s]", Integer.valueOf(i), C5046bo.dpG());
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new agb();
        c1196a.fsK = new agc();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcdndns";
        c1196a.fsI = 379;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.scene = i;
        agb agb = (agb) this.ehh.fsG.fsP;
        agb.wnb = "";
        agb.Scene = i;
        AppMethodBeat.m2505o(78066);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78067);
        this.ehi = c1202f;
        C1720g.m3534RN();
        int QF = C1668a.m3383QF();
        if (QF == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetCDNDns", "has not set uin.");
            AppMethodBeat.m2505o(78067);
            return -1;
        }
        if (fzj != ((long) QF)) {
            fzj = (long) QF;
            fzk.clear();
        }
        long anT = C5046bo.anT();
        C17910a c17910a;
        if (this.scene == 0) {
            this.fzl = C5046bo.m7532bc(C32243d.aft(), "");
            c17910a = (C17910a) fzk.get(this.fzl);
            if (c17910a == null) {
                c17910a = new C17910a();
                fzk.put(this.fzl, c17910a);
                C4990ab.m7417i("MicroMsg.NetSceneGetCDNDns", "summersafecdn doScene NEW lastGetResult[%s] path[%s]", c17910a, this.fzl);
            }
            if (c17910a.fzm) {
                c17910a.fzn = anT;
                c17910a.fzo = anT;
                c17910a.fzp = 0;
            }
            C4990ab.m7411d("MicroMsg.NetSceneGetCDNDns", "cdntra doscene Sec:%d Hour[%d,%d]", Long.valueOf(anT - c17910a.fzn), Long.valueOf(anT - c17910a.fzo), Long.valueOf(c17910a.fzp));
            if (anT > c17910a.fzn && anT - c17910a.fzn < 10) {
                C4990ab.m7421w("MicroMsg.NetSceneGetCDNDns", "Last get dns at %d ago . ignore!, lastGetResult[%s]", Long.valueOf(anT - c17910a.fzn), c17910a);
                AppMethodBeat.m2505o(78067);
                return -1;
            } else if (anT <= c17910a.fzo || anT - c17910a.fzo >= 3600 || c17910a.fzp < 90) {
                c17910a.fzn = anT;
                if (anT < c17910a.fzo || anT - c17910a.fzp > 3600) {
                    c17910a.fzo = anT;
                    c17910a.fzp = 0;
                } else {
                    c17910a.fzp++;
                }
            } else {
                C4990ab.m7421w("MicroMsg.NetSceneGetCDNDns", "in 1 hour , get dns more than 90  (%d). ignore!, lastGetResult[%s]", Long.valueOf(anT - c17910a.fzo), c17910a);
                AppMethodBeat.m2505o(78067);
                return -1;
            }
        }
        this.fzl = "";
        Iterator it = fzk.values().iterator();
        if (it != null) {
            while (it.hasNext()) {
                c17910a = (C17910a) it.next();
                if (c17910a != null) {
                    c17910a.fzn = anT;
                    if (anT < c17910a.fzo || anT - c17910a.fzp > 3600) {
                        c17910a.fzo = anT;
                        c17910a.fzp = 0;
                    } else {
                        c17910a.fzp++;
                    }
                }
            }
        }
        this.startTime = anT;
        C7060h.pYm.mo8378a(546, this.scene == 0 ? 0 : 1, 1, true);
        QF = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78067);
        return QF;
    }

    private static String aft() {
        AppMethodBeat.m2504i(78068);
        if (C5023at.isConnected(C4996ah.getContext())) {
            String str;
            if (C5023at.isWifi(C4996ah.getContext())) {
                str = "wifi_" + C5023at.m7474gE(C4996ah.getContext());
            } else {
                str = "mobile_" + C5023at.getNetTypeString(C4996ah.getContext()) + "_" + C5023at.getISPCode(C4996ah.getContext());
            }
            C4990ab.m7411d("MicroMsg.NetSceneGetCDNDns", "cdntra getCurCacheFullPath file:%s", str);
            if (str == null || str.length() < 2) {
                AppMethodBeat.m2505o(78068);
                return null;
            }
            str = String.format("%x", new Object[]{Integer.valueOf(str.hashCode())});
            StringBuilder stringBuilder = new StringBuilder();
            C37461f.afu();
            str = stringBuilder.append(C37461f.afv()).append(str).toString();
            AppMethodBeat.m2505o(78068);
            return str;
        }
        AppMethodBeat.m2505o(78068);
        return null;
    }

    /* renamed from: a */
    private static CdnInfoParams m52593a(C23417mv c23417mv) {
        AppMethodBeat.m2504i(78069);
        CdnInfoParams cdnInfoParams = new CdnInfoParams();
        cdnInfoParams.c2CretryIntervalMs = c23417mv.vQR;
        cdnInfoParams.c2CrwtimeoutMs = c23417mv.vQT;
        cdnInfoParams.c2CshowErrorDelayMs = c23417mv.vQP;
        cdnInfoParams.snsretryIntervalMs = c23417mv.vQS;
        cdnInfoParams.snsrwtimeoutMs = c23417mv.vQU;
        cdnInfoParams.snsshowErrorDelayMs = c23417mv.vQQ;
        AppMethodBeat.m2505o(78069);
        return cdnInfoParams;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78070);
        C4990ab.m7410d("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        agc agc = (agc) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0 && agc.vMl != null) {
            String aft = C32243d.aft();
            if (!(C5046bo.isNullOrNil(aft) || C5046bo.isNullOrNil(this.fzl) || aft.equals(this.fzl))) {
                C4990ab.m7417i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd revised cacheFullPath[%s] to [%s]", aft, this.fzl);
                C7060h.pYm.mo8378a(546, 6, 1, true);
            }
            fzk.clear();
            byte[] bArr2 = null;
            if (agc.vMo != null && agc.vMo.getILen() > 0) {
                C4990ab.m7417i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(agc.vMo.getILen()));
                bArr2 = C1946aa.m4150a(agc.vMo);
            }
            byte[] bArr3 = null;
            if (agc.vMp != null && agc.vMp.getILen() > 0) {
                C4990ab.m7417i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(agc.vMp.getILen()));
                bArr3 = C1946aa.m4150a(agc.vMp);
            }
            C4990ab.m7417i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo:%s", agc.vMq);
            if (agc.vMq != null) {
                C4990ab.m7417i("MicroMsg.NetSceneGetCDNDns", "summersafecdn onGYNetEnd FakeDnsInfo FakeUin:%d NewAuthKey:%s", Integer.valueOf(agc.vMq.luF), agc.vMq.vRb);
            }
            if (C37461f.afy().mo20369a(agc.vMl, agc.vMm, agc.vMn, bArr2, bArr3, agc.vMq)) {
                C4990ab.m7417i("MicroMsg.NetSceneGetCDNDns", "getcdndns defaultcfg %s, disastercfg %s, getcdninterval %d", agc.vMs, agc.vMt, Integer.valueOf(agc.vMr));
                if (!(agc.vMs == null || agc.vMt == null)) {
                    CdnLogic.setCdnInfoParams(C32243d.m52593a(agc.vMs), C32243d.m52593a(agc.vMt), agc.vMr);
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(78070);
                return;
            }
            C4990ab.m7412e("MicroMsg.NetSceneGetCDNDns", "onGYNetEnd setCDNDnsInfo failed ");
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(78070);
            return;
        }
        C7060h.pYm.mo8381e(10769, Integer.valueOf(C37458c.fzi), Integer.valueOf(0), Long.valueOf(this.startTime));
        String str2 = "MicroMsg.NetSceneGetCDNDns";
        String str3 = "onGYNetEnd: [%d ,%d]  info is null :%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(agc.vMl == null);
        C4990ab.m7421w(str2, str3, objArr);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78070);
    }

    public final int getType() {
        return 379;
    }
}
