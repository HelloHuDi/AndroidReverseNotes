package com.tencent.mm.plugin.bbom;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.v;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.a.c;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;

public final class o implements c {
    /* JADX WARNING: Removed duplicated region for block: B:71:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
        Exception e;
        AppMethodBeat.i(18274);
        String str;
        ui uiVar;
        byte[] bArr3;
        switch (i) {
            case 10:
                ab.d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
                b bVar = new b();
                bVar.deviceID = q.LM();
                try {
                    if (new v(bVar, 10).a(10, bArr, null, 0)) {
                        aw.Rg().onSceneEnd(0, 0, "", new f(bVar));
                    }
                    AppMethodBeat.o(18274);
                    return;
                } catch (RemoteException e2) {
                    ab.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", e2, "", new Object[0]);
                    AppMethodBeat.o(18274);
                    return;
                }
            case 102:
                ab.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
                AppMethodBeat.o(18274);
                return;
            case 120:
                NotifyService.jG("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                sz szVar = new sz();
                szVar.cPf.cPh = true;
                a.xxA.m(szVar);
                str = szVar.cPg.cPj;
                if (!bo.isNullOrNil(str)) {
                    ab.v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: ".concat(String.valueOf(str)));
                    szVar = new sz();
                    szVar.cPf.cPi = true;
                    a.xxA.m(szVar);
                }
                if (bArr != null && bArr.length > 0) {
                    if (bArr[0] == (byte) 1) {
                        ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
                        uiVar = new ui();
                        uiVar.cQx.cAd = 3;
                        uiVar.cQx.cQr = bArr;
                        a.xxA.m(uiVar);
                        AppMethodBeat.o(18274);
                        return;
                    } else if (bArr[0] == (byte) 101) {
                        ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
                        is isVar = new is();
                        isVar.cDS.cDT = bArr;
                        a.xxA.m(isVar);
                        AppMethodBeat.o(18274);
                        return;
                    } else if (bArr[0] == (byte) 3) {
                        ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
                        uiVar = new ui();
                        uiVar.cQx.cAd = 9;
                        uiVar.cQx.cQr = bArr;
                        a.xxA.m(uiVar);
                        AppMethodBeat.o(18274);
                        return;
                    } else if (bArr[0] == (byte) 2) {
                        ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        uiVar = new ui();
                        uiVar.cQx.cAd = 10;
                        uiVar.cQx.cQr = bArr;
                        a.xxA.m(uiVar);
                        AppMethodBeat.o(18274);
                        return;
                    } else if (bArr[0] == (byte) 102) {
                        ab.d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        ug ugVar = new ug();
                        ugVar.cQq.cQr = bArr;
                        a.xxA.m(ugVar);
                        AppMethodBeat.o(18274);
                        return;
                    }
                }
                break;
            case ErrorCode.NEEDDOWNLOAD_FALSE_4 /*174*/:
                ab.i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
                uiVar = new ui();
                uiVar.cQx.cAd = 6;
                uiVar.cQx.cQr = bArr;
                a.xxA.m(uiVar);
                AppMethodBeat.o(18274);
                return;
            case az.CTRL_INDEX /*192*/:
                gg ggVar = new gg();
                ggVar.cAF.cAG = bArr;
                a.xxA.m(ggVar);
                AppMethodBeat.o(18274);
                return;
            case d.MIC_PTU_QINGCONG /*241*/:
                ab.i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
                if (bArr.length >= 8) {
                    byte[] bArr4 = new byte[4];
                    bArr3 = new byte[4];
                    System.arraycopy(bArr, 0, bArr4, 0, 4);
                    System.arraycopy(bArr, 4, bArr3, 0, 4);
                    ku kuVar = new ku();
                    kuVar.cGJ.cGK = com.tencent.mm.a.o.t(bArr4, 0);
                    kuVar.cGJ.cGL = com.tencent.mm.a.o.t(bArr3, 0);
                    ab.i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", Integer.valueOf(kuVar.cGJ.cGK), Integer.valueOf(kuVar.cGJ.cGL));
                    a.xxA.m(kuVar);
                }
                AppMethodBeat.o(18274);
                return;
            case 318:
                String str2 = "MicroMsg.NotifyReceiverCallbackImpl";
                String str3 = "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                ab.i(str2, str3, objArr);
                byte[] bArr5 = null;
                e.pXa.a(403, 38, 1, false);
                if (bArr != null) {
                    bvy bvy = new bvy();
                    try {
                        bvy.parseFrom(bArr);
                        ab.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", Integer.valueOf(bvy.wWH), Integer.valueOf(bvy.wWI), Integer.valueOf(bvy.wWJ), Integer.valueOf(bvy.wWK), Integer.valueOf(bvy.wWL), Integer.valueOf(bvy.wWM));
                        if (bvy.wWH == 13) {
                            g.RQ();
                            byte[] jQ = g.RO().jQ(3);
                            bArr3 = UtilsJni.AesGcmDecryptWithUncompress(jQ, bvy.wdt.wR);
                            try {
                                String str4 = "MicroMsg.NotifyReceiverCallbackImpl";
                                String str5 = "summerbadcr MM_PKT_SILENCE_NOTIFY AES_GCM_ENCRYPT serverSession[%s] data[%s]";
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = Integer.valueOf(jQ == null ? -1 : jQ.length);
                                objArr2[1] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
                                ab.i(str4, str5, objArr2);
                                bArr5 = bArr3;
                            } catch (Exception e3) {
                                e = e3;
                                bArr5 = bArr3;
                                ab.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + e.getMessage());
                                e.pXa.a(403, 39, 1, false);
                                if (bArr5 != null) {
                                }
                            }
                        } else {
                            bArr5 = MMProtocalJni.decodeSecureNotifyData(bArr2, bvy.wWH, bvy.wWI, bvy.wWJ, bvy.wWK, bvy.wWL, bvy.wWM, bvy.wWN, bvy.wdt.wR);
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
                if (bArr5 != null) {
                    ab.e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    e.pXa.a(403, 40, 1, false);
                    break;
                }
                ab.i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", Integer.valueOf(bArr5.length));
                qu quVar = new qu();
                quVar.cMZ.data = bArr5;
                a.xxA.m(quVar);
                AppMethodBeat.o(18274);
                return;
            case 268369923:
                NotifyService.jG("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                if (!bo.cb(bArr)) {
                    str = new String(bArr);
                    ak akVar = new ak();
                    akVar.cto.type = 4;
                    akVar.cto.ctq = str;
                    a.xxA.m(akVar);
                    AppMethodBeat.o(18274);
                    return;
                }
                break;
        }
        AppMethodBeat.o(18274);
    }
}
