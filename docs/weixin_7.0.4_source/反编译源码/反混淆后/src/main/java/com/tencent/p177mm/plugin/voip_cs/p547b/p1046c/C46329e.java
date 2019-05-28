package com.tencent.p177mm.plugin.voip_cs.p547b.p1046c;

import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.model.C35355p;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43746a;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43749c;
import com.tencent.p177mm.plugin.voip_cs.p547b.C43750d;
import com.tencent.p177mm.plugin.voip_cs.p547b.p548a.C43744a;
import com.tencent.p177mm.protocal.protobuf.coy;
import com.tencent.p177mm.protocal.protobuf.coz;
import com.tencent.p177mm.protocal.protobuf.cpa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.c.e */
public final class C46329e extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0546  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0353  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0546  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0353  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C46329e(long j, long j2) {
        int i;
        C35355p cJR;
        AppMethodBeat.m2504i(135383);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new coz();
        c1196a.fsK = new cpa();
        c1196a.uri = "/cgi-bin/micromsg-bin/csvoipreport";
        this.ehh = c1196a.acD();
        coz coz = (coz) this.ehh.fsG.fsP;
        coz.xeF = j;
        coz.wen = j2;
        LinkedList linkedList = coz.xmJ;
        C43750d cMg = C43749c.cMg();
        coy coy = new coy();
        coy.jCt = 1;
        coy.xmI = cMg.nxW;
        C4990ab.m7417i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", coy.xmI);
        linkedList.add(coy);
        coz.xmJ.add(C43749c.cMg().cMj());
        LinkedList linkedList2 = coz.xmJ;
        C43750d cMg2 = C43749c.cMg();
        coy coy2 = new coy();
        coy2.jCt = 3;
        cMg2.sUr = C1407g.m2946KK().mo4826Lb();
        cMg2.mo69459GW(C43744a.cMn().sTj.cLN());
        int i2 = cMg2.cpuFlag0 & 255;
        cMg2.sVG = i2;
        cMg2.sVG = i2;
        cMg2.tds = C43749c.cMe().tew.field_audioDuration;
        cMg2.tdt = C43749c.cMe().tew.field_videoDuration;
        if (cMg2.tcW != 1 && cMg2.tdE != 1) {
            cMg2.tdk = 1;
        } else if (cMg2.tcW != 1) {
            cMg2.tdk = 2;
        } else if (cMg2.tdE != 1) {
            cMg2.tdk = 3;
        } else {
            cMg2.tdk = 0;
        }
        cMg2.tdd = C46317a.getNetType(C4996ah.getContext());
        C43746a c43746a = C43749c.cMe().tew;
        c43746a.setJNIAppCmd(1, c43746a.sVq, c43746a.sVq.length);
        i2 = (int) (v2protocal.m68582bt(c43746a.sVq) / 1000);
        if (cMg2.tdz == 0 || i2 <= cMg2.tdz) {
            i2 = 0;
        } else {
            i2 -= cMg2.tdz;
        }
        cMg2.tdr = (long) i2;
        coy2.xmI = cMg2.sUl + "," + cMg2.tda + "," + cMg2.nwv + "," + cMg2.tdb + "," + cMg2.tdc + "," + cMg2.sTX + "," + cMg2.tdd + "," + cMg2.tde + "," + cMg2.tdf + "," + cMg2.tdg + "," + cMg2.sUr + "," + cMg2.sUq + "," + cMg2.tdh + "," + cMg2.tdi + "," + cMg2.tdj + "," + cMg2.tdk + "," + cMg2.tdl + "," + cMg2.tdm + "," + cMg2.tdn + "," + cMg2.tdo + "," + cMg2.tdp + "," + cMg2.tdq + "," + cMg2.tdr + "," + cMg2.nxM + "," + cMg2.tds + "," + cMg2.tdt + "," + cMg2.channelStrategy + "," + cMg2.sVG + "," + cMg2.sUs + "," + cMg2.tdu + "," + cMg2.tdv + "," + cMg2.tdw + "," + cMg2.deviceModel + "," + cMg2.tdx + "," + cMg2.tdy;
        C4990ab.m7417i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", coy2.xmI);
        linkedList2.add(coy2);
        linkedList = coz.xmJ;
        cMg = C43749c.cMg();
        coy = new coy();
        coy.jCt = 4;
        cMg.networkType = C43750d.getNetType(C4996ah.getContext());
        String simOperator = ((TelephonyManager) C4996ah.getContext().getSystemService("phone")).getSimOperator();
        if (simOperator != null) {
            if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                i = 1;
                cMg.tcX = i;
                cMg.tcO = (int) (System.currentTimeMillis() / 1000);
                cMg.tcY = C43750d.cMk();
                cMg.sUr = C1407g.m2946KK().mo4826Lb();
                cJR = C35355p.cJR();
                if (cJR.sSG != 0) {
                    i = cJR.sSF / cJR.sSG;
                } else {
                    i = -1;
                }
                cMg.tcZ = i;
                if (cMg.tcZ == -1) {
                    byte[] bArr = new byte[4];
                    if (C43749c.cMe().tew.setAppCmd(10, bArr, 4) < 0) {
                        cMg.tcZ = 0;
                        C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                    } else {
                        cMg.tcZ = C5046bo.m7533bf(bArr);
                    }
                }
                C4990ab.m7417i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", Integer.valueOf(cMg.dataType), Integer.valueOf(cMg.tcO), Integer.valueOf(cMg.tcP), Integer.valueOf(cMg.tcQ), Integer.valueOf(cMg.videoFps), Integer.valueOf(cMg.tcR), Integer.valueOf(cMg.tcS), Integer.valueOf(cMg.tcT), Integer.valueOf(cMg.tcU), Integer.valueOf(cMg.tcV), Integer.valueOf(cMg.tcW), Integer.valueOf(cMg.networkType), Integer.valueOf(cMg.tcX), Integer.valueOf(cMg.tcY), Integer.valueOf(cMg.tcZ));
                coy.xmI = cMg.dataType + "," + cMg.tcO + "," + cMg.tcP + "," + cMg.tcQ + "," + cMg.videoFps + "," + cMg.tcR + "," + cMg.tcS + "," + cMg.tcT + "," + cMg.tcU + "," + cMg.tcV + "," + cMg.tcW + "," + cMg.networkType + "," + cMg.tcX + "," + cMg.tcY + "," + cMg.tcZ + "," + cMg.tda + "," + cMg.nwv;
                C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + coy.xmI);
                linkedList.add(coy);
                AppMethodBeat.m2505o(135383);
            }
            if (simOperator.equals("46001")) {
                i = 3;
            } else if (simOperator.equals("46003")) {
                i = 2;
            }
            cMg.tcX = i;
            cMg.tcO = (int) (System.currentTimeMillis() / 1000);
            cMg.tcY = C43750d.cMk();
            cMg.sUr = C1407g.m2946KK().mo4826Lb();
            cJR = C35355p.cJR();
            if (cJR.sSG != 0) {
            }
            cMg.tcZ = i;
            if (cMg.tcZ == -1) {
            }
            C4990ab.m7417i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", Integer.valueOf(cMg.dataType), Integer.valueOf(cMg.tcO), Integer.valueOf(cMg.tcP), Integer.valueOf(cMg.tcQ), Integer.valueOf(cMg.videoFps), Integer.valueOf(cMg.tcR), Integer.valueOf(cMg.tcS), Integer.valueOf(cMg.tcT), Integer.valueOf(cMg.tcU), Integer.valueOf(cMg.tcV), Integer.valueOf(cMg.tcW), Integer.valueOf(cMg.networkType), Integer.valueOf(cMg.tcX), Integer.valueOf(cMg.tcY), Integer.valueOf(cMg.tcZ));
            coy.xmI = cMg.dataType + "," + cMg.tcO + "," + cMg.tcP + "," + cMg.tcQ + "," + cMg.videoFps + "," + cMg.tcR + "," + cMg.tcS + "," + cMg.tcT + "," + cMg.tcU + "," + cMg.tcV + "," + cMg.tcW + "," + cMg.networkType + "," + cMg.tcX + "," + cMg.tcY + "," + cMg.tcZ + "," + cMg.tda + "," + cMg.nwv;
            C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + coy.xmI);
            linkedList.add(coy);
            AppMethodBeat.m2505o(135383);
        }
        i = 0;
        cMg.tcX = i;
        cMg.tcO = (int) (System.currentTimeMillis() / 1000);
        cMg.tcY = C43750d.cMk();
        cMg.sUr = C1407g.m2946KK().mo4826Lb();
        cJR = C35355p.cJR();
        if (cJR.sSG != 0) {
        }
        cMg.tcZ = i;
        if (cMg.tcZ == -1) {
        }
        C4990ab.m7417i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", Integer.valueOf(cMg.dataType), Integer.valueOf(cMg.tcO), Integer.valueOf(cMg.tcP), Integer.valueOf(cMg.tcQ), Integer.valueOf(cMg.videoFps), Integer.valueOf(cMg.tcR), Integer.valueOf(cMg.tcS), Integer.valueOf(cMg.tcT), Integer.valueOf(cMg.tcU), Integer.valueOf(cMg.tcV), Integer.valueOf(cMg.tcW), Integer.valueOf(cMg.networkType), Integer.valueOf(cMg.tcX), Integer.valueOf(cMg.tcY), Integer.valueOf(cMg.tcZ));
        coy.xmI = cMg.dataType + "," + cMg.tcO + "," + cMg.tcP + "," + cMg.tcQ + "," + cMg.videoFps + "," + cMg.tcR + "," + cMg.tcS + "," + cMg.tcT + "," + cMg.tcU + "," + cMg.tcV + "," + cMg.tcW + "," + cMg.networkType + "," + cMg.tcX + "," + cMg.tcY + "," + cMg.tcZ + "," + cMg.tda + "," + cMg.nwv;
        C4990ab.m7410d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + coy.xmI);
        linkedList.add(coy);
        AppMethodBeat.m2505o(135383);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135384);
        C4990ab.m7417i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(135384);
    }

    public final int getType() {
        return 312;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135385);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(135385);
        return a;
    }
}
