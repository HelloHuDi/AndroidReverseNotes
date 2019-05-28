package com.tencent.mm.plugin.voip_cs.b.c;

import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.plugin.voip_cs.b.d;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.protocal.protobuf.coz;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class e extends m implements k {
    public b ehh;
    private f ehi;

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0546  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0353  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0546  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0353  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(long j, long j2) {
        int i;
        p cJR;
        AppMethodBeat.i(135383);
        a aVar = new a();
        aVar.fsJ = new coz();
        aVar.fsK = new cpa();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipreport";
        this.ehh = aVar.acD();
        coz coz = (coz) this.ehh.fsG.fsP;
        coz.xeF = j;
        coz.wen = j2;
        LinkedList linkedList = coz.xmJ;
        d cMg = c.cMg();
        coy coy = new coy();
        coy.jCt = 1;
        coy.xmI = cMg.nxW;
        ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSChannelReportData, result: %s", coy.xmI);
        linkedList.add(coy);
        coz.xmJ.add(c.cMg().cMj());
        LinkedList linkedList2 = coz.xmJ;
        d cMg2 = c.cMg();
        coy coy2 = new coy();
        coy2.jCt = 3;
        cMg2.sUr = g.KK().Lb();
        cMg2.GW(com.tencent.mm.plugin.voip_cs.b.a.a.cMn().sTj.cLN());
        int i2 = cMg2.cpuFlag0 & 255;
        cMg2.sVG = i2;
        cMg2.sVG = i2;
        cMg2.tds = c.cMe().tew.field_audioDuration;
        cMg2.tdt = c.cMe().tew.field_videoDuration;
        if (cMg2.tcW != 1 && cMg2.tdE != 1) {
            cMg2.tdk = 1;
        } else if (cMg2.tcW != 1) {
            cMg2.tdk = 2;
        } else if (cMg2.tdE != 1) {
            cMg2.tdk = 3;
        } else {
            cMg2.tdk = 0;
        }
        cMg2.tdd = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
        com.tencent.mm.plugin.voip_cs.b.a aVar2 = c.cMe().tew;
        aVar2.setJNIAppCmd(1, aVar2.sVq, aVar2.sVq.length);
        i2 = (int) (v2protocal.bt(aVar2.sVq) / 1000);
        if (cMg2.tdz == 0 || i2 <= cMg2.tdz) {
            i2 = 0;
        } else {
            i2 -= cMg2.tdz;
        }
        cMg2.tdr = (long) i2;
        coy2.xmI = cMg2.sUl + "," + cMg2.tda + "," + cMg2.nwv + "," + cMg2.tdb + "," + cMg2.tdc + "," + cMg2.sTX + "," + cMg2.tdd + "," + cMg2.tde + "," + cMg2.tdf + "," + cMg2.tdg + "," + cMg2.sUr + "," + cMg2.sUq + "," + cMg2.tdh + "," + cMg2.tdi + "," + cMg2.tdj + "," + cMg2.tdk + "," + cMg2.tdl + "," + cMg2.tdm + "," + cMg2.tdn + "," + cMg2.tdo + "," + cMg2.tdp + "," + cMg2.tdq + "," + cMg2.tdr + "," + cMg2.nxM + "," + cMg2.tds + "," + cMg2.tdt + "," + cMg2.channelStrategy + "," + cMg2.sVG + "," + cMg2.sUs + "," + cMg2.tdu + "," + cMg2.tdv + "," + cMg2.tdw + "," + cMg2.deviceModel + "," + cMg2.tdx + "," + cMg2.tdy;
        ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSClientReportData, result: %s", coy2.xmI);
        linkedList2.add(coy2);
        linkedList = coz.xmJ;
        cMg = c.cMg();
        coy = new coy();
        coy.jCt = 4;
        cMg.networkType = d.getNetType(ah.getContext());
        String simOperator = ((TelephonyManager) ah.getContext().getSystemService("phone")).getSimOperator();
        if (simOperator != null) {
            if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                i = 1;
                cMg.tcX = i;
                cMg.tcO = (int) (System.currentTimeMillis() / 1000);
                cMg.tcY = d.cMk();
                cMg.sUr = g.KK().Lb();
                cJR = p.cJR();
                if (cJR.sSG != 0) {
                    i = cJR.sSF / cJR.sSG;
                } else {
                    i = -1;
                }
                cMg.tcZ = i;
                if (cMg.tcZ == -1) {
                    byte[] bArr = new byte[4];
                    if (c.cMe().tew.setAppCmd(10, bArr, 4) < 0) {
                        cMg.tcZ = 0;
                        ab.d("MicroMsg.VoipCSReportHelper", "get netStatus failed");
                    } else {
                        cMg.tcZ = bo.bf(bArr);
                    }
                }
                ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", Integer.valueOf(cMg.dataType), Integer.valueOf(cMg.tcO), Integer.valueOf(cMg.tcP), Integer.valueOf(cMg.tcQ), Integer.valueOf(cMg.videoFps), Integer.valueOf(cMg.tcR), Integer.valueOf(cMg.tcS), Integer.valueOf(cMg.tcT), Integer.valueOf(cMg.tcU), Integer.valueOf(cMg.tcV), Integer.valueOf(cMg.tcW), Integer.valueOf(cMg.networkType), Integer.valueOf(cMg.tcX), Integer.valueOf(cMg.tcY), Integer.valueOf(cMg.tcZ));
                coy.xmI = cMg.dataType + "," + cMg.tcO + "," + cMg.tcP + "," + cMg.tcQ + "," + cMg.videoFps + "," + cMg.tcR + "," + cMg.tcS + "," + cMg.tcT + "," + cMg.tcU + "," + cMg.tcV + "," + cMg.tcW + "," + cMg.networkType + "," + cMg.tcX + "," + cMg.tcY + "," + cMg.tcZ + "," + cMg.tda + "," + cMg.nwv;
                ab.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + coy.xmI);
                linkedList.add(coy);
                AppMethodBeat.o(135383);
            }
            if (simOperator.equals("46001")) {
                i = 3;
            } else if (simOperator.equals("46003")) {
                i = 2;
            }
            cMg.tcX = i;
            cMg.tcO = (int) (System.currentTimeMillis() / 1000);
            cMg.tcY = d.cMk();
            cMg.sUr = g.KK().Lb();
            cJR = p.cJR();
            if (cJR.sSG != 0) {
            }
            cMg.tcZ = i;
            if (cMg.tcZ == -1) {
            }
            ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", Integer.valueOf(cMg.dataType), Integer.valueOf(cMg.tcO), Integer.valueOf(cMg.tcP), Integer.valueOf(cMg.tcQ), Integer.valueOf(cMg.videoFps), Integer.valueOf(cMg.tcR), Integer.valueOf(cMg.tcS), Integer.valueOf(cMg.tcT), Integer.valueOf(cMg.tcU), Integer.valueOf(cMg.tcV), Integer.valueOf(cMg.tcW), Integer.valueOf(cMg.networkType), Integer.valueOf(cMg.tcX), Integer.valueOf(cMg.tcY), Integer.valueOf(cMg.tcZ));
            coy.xmI = cMg.dataType + "," + cMg.tcO + "," + cMg.tcP + "," + cMg.tcQ + "," + cMg.videoFps + "," + cMg.tcR + "," + cMg.tcS + "," + cMg.tcT + "," + cMg.tcU + "," + cMg.tcV + "," + cMg.tcW + "," + cMg.networkType + "," + cMg.tcX + "," + cMg.tcY + "," + cMg.tcZ + "," + cMg.tda + "," + cMg.nwv;
            ab.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + coy.xmI);
            linkedList.add(coy);
            AppMethodBeat.o(135383);
        }
        i = 0;
        cMg.tcX = i;
        cMg.tcO = (int) (System.currentTimeMillis() / 1000);
        cMg.tcY = d.cMk();
        cMg.sUr = g.KK().Lb();
        cJR = p.cJR();
        if (cJR.sSG != 0) {
        }
        cMg.tcZ = i;
        if (cMg.tcZ == -1) {
        }
        ab.i("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData Report dataType=%d, dataTime=%s, isClickClose=%d, clickCloseTime=%s, videoFps=%d, videoRate=%d, cameraPixelWidth=%d, cameraPixelHeight=%d, recordPixelWidth=%d, recordPixelHeight=%d, cameraState=%d, networkType=%s, mobileType=%s, mobileNetworkType=%s, networkQuality=%d", Integer.valueOf(cMg.dataType), Integer.valueOf(cMg.tcO), Integer.valueOf(cMg.tcP), Integer.valueOf(cMg.tcQ), Integer.valueOf(cMg.videoFps), Integer.valueOf(cMg.tcR), Integer.valueOf(cMg.tcS), Integer.valueOf(cMg.tcT), Integer.valueOf(cMg.tcU), Integer.valueOf(cMg.tcV), Integer.valueOf(cMg.tcW), Integer.valueOf(cMg.networkType), Integer.valueOf(cMg.tcX), Integer.valueOf(cMg.tcY), Integer.valueOf(cMg.tcZ));
        coy.xmI = cMg.dataType + "," + cMg.tcO + "," + cMg.tcP + "," + cMg.tcQ + "," + cMg.videoFps + "," + cMg.tcR + "," + cMg.tcS + "," + cMg.tcT + "," + cMg.tcU + "," + cMg.tcV + "," + cMg.tcW + "," + cMg.networkType + "," + cMg.tcX + "," + cMg.tcY + "," + cMg.tcZ + "," + cMg.tda + "," + cMg.nwv;
        ab.d("MicroMsg.VoipCSReportHelper", "getVoipCSThirdPartData, result: " + coy.xmI);
        linkedList.add(coy);
        AppMethodBeat.o(135383);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135384);
        ab.i("MicroMsg.NetSceneVoipCSReport", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(135384);
    }

    public final int getType() {
        return 312;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(135385);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(135385);
        return a;
    }
}
