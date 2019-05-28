package com.tencent.p177mm.plugin.bbom;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.NotifyReceiver.NotifyService;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C32824f;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.p183ai.C7477v;
import com.tencent.p177mm.p230g.p231a.C18301is;
import com.tencent.p177mm.p230g.p231a.C26225qu;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C37754ku;
import com.tencent.p177mm.p230g.p231a.C42062sz;
import com.tencent.p177mm.p230g.p231a.C42070ug;
import com.tencent.p177mm.p230g.p231a.C45326gg;
import com.tencent.p177mm.p230g.p231a.C6459ak;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.zero.p591a.C44034c;
import com.tencent.p177mm.protocal.C46518p.C46517b;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.protocal.protobuf.bvy;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.bbom.o */
public final class C44721o implements C44034c {
    /* JADX WARNING: Removed duplicated region for block: B:71:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x02ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo56551a(NotifyService notifyService, int i, byte[] bArr, byte[] bArr2, long j) {
        Exception e;
        AppMethodBeat.m2504i(18274);
        String str;
        C26250ui c26250ui;
        byte[] bArr3;
        switch (i) {
            case 10:
                C4990ab.m7410d("MicroMsg.NotifyReceiverCallbackImpl", "on direct send notify");
                C46517b c46517b = new C46517b();
                c46517b.deviceID = C1427q.m3028LM();
                try {
                    if (new C7477v(c46517b, 10).mo9965a(10, bArr, null, 0)) {
                        C9638aw.m17182Rg().onSceneEnd(0, 0, "", new C32824f(c46517b));
                    }
                    AppMethodBeat.m2505o(18274);
                    return;
                } catch (RemoteException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.NotifyReceiverCallbackImpl", e2, "", new Object[0]);
                    AppMethodBeat.m2505o(18274);
                    return;
                }
            case 102:
                C4990ab.m7416i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MM_VOIP_CS_PUSHTYPE_SYN do VoipSync");
                AppMethodBeat.m2505o(18274);
                return;
            case 120:
                NotifyService.m41408jG("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                C42062sz c42062sz = new C42062sz();
                c42062sz.cPf.cPh = true;
                C4879a.xxA.mo10055m(c42062sz);
                str = c42062sz.cPg.cPj;
                if (!C5046bo.isNullOrNil(str)) {
                    C4990ab.m7418v("MicroMsg.NotifyReceiverCallbackImpl", "voipinvite, exit talkroom first: ".concat(String.valueOf(str)));
                    c42062sz = new C42062sz();
                    c42062sz.cPf.cPi = true;
                    C4879a.xxA.mo10055m(c42062sz);
                }
                if (bArr != null && bArr.length > 0) {
                    if (bArr[0] == (byte) 1) {
                        C4990ab.m7410d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_VOIP_PUSHTYPE_INVITE, will launch voipUI");
                        c26250ui = new C26250ui();
                        c26250ui.cQx.cAd = 3;
                        c26250ui.cQx.cQr = bArr;
                        C4879a.xxA.mo10055m(c26250ui);
                        AppMethodBeat.m2505o(18274);
                        return;
                    } else if (bArr[0] == (byte) 101) {
                        C4990ab.m7410d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify case MM_PSTN_PUSHTYPE_INVITE");
                        C18301is c18301is = new C18301is();
                        c18301is.cDS.cDT = bArr;
                        C4879a.xxA.mo10055m(c18301is);
                        AppMethodBeat.m2505o(18274);
                        return;
                    } else if (bArr[0] == (byte) 3) {
                        C4990ab.m7410d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_CANCEL");
                        c26250ui = new C26250ui();
                        c26250ui.cQx.cAd = 9;
                        c26250ui.cQx.cQr = bArr;
                        C4879a.xxA.mo10055m(c26250ui);
                        AppMethodBeat.m2505o(18274);
                        return;
                    } else if (bArr[0] == (byte) 2) {
                        C4990ab.m7410d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        c26250ui = new C26250ui();
                        c26250ui.cQx.cAd = 10;
                        c26250ui.cQx.cQr = bArr;
                        C4879a.xxA.mo10055m(c26250ui);
                        AppMethodBeat.m2505o(18274);
                        return;
                    } else if (bArr[0] == (byte) 102) {
                        C4990ab.m7410d("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify, MM_VOIP_PUSHTYPE_ANSWERED");
                        C42070ug c42070ug = new C42070ug();
                        c42070ug.cQq.cQr = bArr;
                        C4879a.xxA.mo10055m(c42070ug);
                        AppMethodBeat.m2505o(18274);
                        return;
                    }
                }
                break;
            case ErrorCode.NEEDDOWNLOAD_FALSE_4 /*174*/:
                C4990ab.m7416i("MicroMsg.NotifyReceiverCallbackImpl", "dealWithNotify MMFunc_VoipSync do VoipSync");
                c26250ui = new C26250ui();
                c26250ui.cQx.cAd = 6;
                c26250ui.cQx.cQr = bArr;
                C4879a.xxA.mo10055m(c26250ui);
                AppMethodBeat.m2505o(18274);
                return;
            case C33250az.CTRL_INDEX /*192*/:
                C45326gg c45326gg = new C45326gg();
                c45326gg.cAF.cAG = bArr;
                C4879a.xxA.mo10055m(c45326gg);
                AppMethodBeat.m2505o(18274);
                return;
            case C31128d.MIC_PTU_QINGCONG /*241*/:
                C4990ab.m7416i("MicroMsg.NotifyReceiverCallbackImpl", "jacks do voice notify UI");
                if (bArr.length >= 8) {
                    byte[] bArr4 = new byte[4];
                    bArr3 = new byte[4];
                    System.arraycopy(bArr, 0, bArr4, 0, 4);
                    System.arraycopy(bArr, 4, bArr3, 0, 4);
                    C37754ku c37754ku = new C37754ku();
                    c37754ku.cGJ.cGK = C37432o.m63092t(bArr4, 0);
                    c37754ku.cGJ.cGL = C37432o.m63092t(bArr3, 0);
                    C4990ab.m7417i("MicroMsg.NotifyReceiverCallbackImpl", "notifyId: %d, sequence: %d", Integer.valueOf(c37754ku.cGJ.cGK), Integer.valueOf(c37754ku.cGJ.cGL));
                    C4879a.xxA.mo10055m(c37754ku);
                }
                AppMethodBeat.m2505o(18274);
                return;
            case 318:
                String str2 = "MicroMsg.NotifyReceiverCallbackImpl";
                String str3 = "summerbadcr on MM_PKT_SILENCE_NOTIFY notify respBuf len[%d]";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                C4990ab.m7417i(str2, str3, objArr);
                byte[] bArr5 = null;
                C7053e.pXa.mo8378a(403, 38, 1, false);
                if (bArr != null) {
                    bvy bvy = new bvy();
                    try {
                        bvy.parseFrom(bArr);
                        C4990ab.m7417i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData[%d, %d, %d, %d, %d, %d]", Integer.valueOf(bvy.wWH), Integer.valueOf(bvy.wWI), Integer.valueOf(bvy.wWJ), Integer.valueOf(bvy.wWK), Integer.valueOf(bvy.wWL), Integer.valueOf(bvy.wWM));
                        if (bvy.wWH == 13) {
                            C1720g.m3537RQ();
                            byte[] jQ = C1720g.m3535RO().mo5189jQ(3);
                            bArr3 = UtilsJni.AesGcmDecryptWithUncompress(jQ, bvy.wdt.f1226wR);
                            try {
                                String str4 = "MicroMsg.NotifyReceiverCallbackImpl";
                                String str5 = "summerbadcr MM_PKT_SILENCE_NOTIFY AES_GCM_ENCRYPT serverSession[%s] data[%s]";
                                Object[] objArr2 = new Object[2];
                                objArr2[0] = Integer.valueOf(jQ == null ? -1 : jQ.length);
                                objArr2[1] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
                                C4990ab.m7417i(str4, str5, objArr2);
                                bArr5 = bArr3;
                            } catch (Exception e3) {
                                e = e3;
                                bArr5 = bArr3;
                                C4990ab.m7412e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr MM_PKT_SILENCE_NOTIFY secureData parseFrom e: " + e.getMessage());
                                C7053e.pXa.mo8378a(403, 39, 1, false);
                                if (bArr5 != null) {
                                }
                            }
                        } else {
                            bArr5 = MMProtocalJni.decodeSecureNotifyData(bArr2, bvy.wWH, bvy.wWI, bvy.wWJ, bvy.wWK, bvy.wWL, bvy.wWM, bvy.wWN, bvy.wdt.f1226wR);
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
                if (bArr5 != null) {
                    C4990ab.m7412e("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data is null");
                    C7053e.pXa.mo8378a(403, 40, 1, false);
                    break;
                }
                C4990ab.m7417i("MicroMsg.NotifyReceiverCallbackImpl", "summerbadcr on MM_PKT_SILENCE_NOTIFY data len:%d", Integer.valueOf(bArr5.length));
                C26225qu c26225qu = new C26225qu();
                c26225qu.cMZ.data = bArr5;
                C4879a.xxA.mo10055m(c26225qu);
                AppMethodBeat.m2505o(18274);
                return;
            case 268369923:
                NotifyService.m41408jG("NotifyReceiver.dealWithNotify:MM_PKT_VOIP_REQ");
                if (!C5046bo.m7540cb(bArr)) {
                    str = new String(bArr);
                    C6459ak c6459ak = new C6459ak();
                    c6459ak.cto.type = 4;
                    c6459ak.cto.ctq = str;
                    C4879a.xxA.mo10055m(c6459ak);
                    AppMethodBeat.m2505o(18274);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(18274);
    }
}
