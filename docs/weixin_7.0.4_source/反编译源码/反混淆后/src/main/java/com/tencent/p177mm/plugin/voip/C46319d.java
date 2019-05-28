package com.tencent.p177mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p231a.C26250ui.C26251b;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.model.C14055q;
import com.tencent.p177mm.plugin.voip.model.C14058r;
import com.tencent.p177mm.plugin.voip.model.C40033o.C22460a;
import com.tencent.p177mm.plugin.voip.model.C4286s;
import com.tencent.p177mm.plugin.voip.model.C46323n;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.cpm;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.tencent.mm.plugin.voip.d */
public final class C46319d extends C4884c<C26250ui> {
    public C46319d() {
        AppMethodBeat.m2504i(4318);
        this.xxI = C26250ui.class.getName().hashCode();
        AppMethodBeat.m2505o(4318);
    }

    /* renamed from: a */
    private static boolean m86992a(C26250ui c26250ui) {
        int i = true;
        AppMethodBeat.m2504i(4319);
        if (c26250ui instanceof C26250ui) {
            if (C1720g.m3531RK()) {
                byte[] bArr;
                C14058r cIj;
                byte[] bArr2;
                C4286s c4286s;
                cpm cpm;
                switch (c26250ui.cQx.cAd) {
                    case 1:
                        C43727b.cIj();
                        C22460a abW = C14058r.abW(c26250ui.cQx.content);
                        if (abW != null) {
                            if (!abW.cJh()) {
                                if (abW.sQU != C22460a.sRb) {
                                    i = 0;
                                }
                                if (i != 0) {
                                    c26250ui.cQy.type = 3;
                                    break;
                                }
                            }
                            c26250ui.cQy.type = 2;
                            break;
                        }
                        break;
                    case 2:
                        c26250ui.cQy.cQz = C43727b.cIj().con;
                        break;
                    case 3:
                        C14058r cIj2 = C43727b.cIj();
                        byte[] bArr3 = c26250ui.cQx.cQr;
                        if (bArr3 != null && bArr3.length >= 10 && bArr3[0] == (byte) 1) {
                            bArr = new byte[(bArr3.length - 1)];
                            System.arraycopy(bArr3, 1, bArr, 0, bArr.length);
                            C46323n c46323n = cIj2.sSP.sNl.sPp.sVH;
                            c46323n.sQK = System.currentTimeMillis();
                            C46317a.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + c46323n.sQK);
                            try {
                                cpm cpm2 = (cpm) new cpm().parseFrom(bArr);
                                C4990ab.m7410d("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify");
                                if (!cIj2.sTe) {
                                    C46317a.m86991c(cpm2.wem, cpm2.wen, 1, 2);
                                    cIj2.sTe = true;
                                }
                                if (!cIj2.sSP.cKg()) {
                                    C7060h.pYm.mo8377a(11523, true, true, Integer.valueOf(cpm2.wem), Long.valueOf(cpm2.wen), Integer.valueOf(cpm2.xmL), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                                    cIj2.mo26349b(cpm2);
                                    break;
                                }
                                C7060h.pYm.mo8377a(11523, true, true, Integer.valueOf(cpm2.wem), Long.valueOf(cpm2.wen), Integer.valueOf(cpm2.xmL), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                                break;
                            } catch (IOException e) {
                                C4990ab.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                                break;
                            }
                        }
                    case 4:
                        boolean z;
                        C26251b c26251b = c26250ui.cQy;
                        C14058r cIj3 = C43727b.cIj();
                        Context context = C4996ah.getContext();
                        if (cIj3.con && cIj3.sTa && !cIj3.sTb) {
                            C4990ab.m7410d("MicroMsg.Voip.VoipService", "isVideoCalling " + cIj3.sSR + " isAudioCalling " + cIj3.sSS);
                            if (!(C5046bo.isNullOrNil(cIj3.talker) || ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(cIj3.talker) == null)) {
                                C14058r.m22216a(context, cIj3.talker, true, cIj3.sSR, true);
                                z = true;
                                c26251b.cQA = z;
                                break;
                            }
                        }
                        z = false;
                        c26251b.cQA = z;
                    case 5:
                        if (!C35973a.m59176Oo()) {
                            if (c26250ui.cQx.cQs != 2) {
                                if (c26250ui.cQx.cQs != 3) {
                                    if (c26250ui.cQx.cQs == 4) {
                                        C14055q.m22212aY(c26250ui.cQx.context, c26250ui.cQx.talker);
                                        break;
                                    }
                                }
                                C14055q.m22211aX(c26250ui.cQx.context, c26250ui.cQx.talker);
                                break;
                            }
                            C14055q.m22210aW(c26250ui.cQx.context, c26250ui.cQx.talker);
                            break;
                        }
                        C30379h.m48467g(c26250ui.cQx.context, C25738R.string.f65, C25738R.string.f9238tz);
                        break;
                        break;
                    case 6:
                        cIj = C43727b.cIj();
                        bArr2 = c26250ui.cQx.cQr;
                        if (bArr2 != null) {
                            C4990ab.m7416i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + bArr2.length);
                            int i2 = ByteBuffer.wrap(bArr2, 0, 4).getInt();
                            long j = ByteBuffer.wrap(bArr2, 4, 8).getLong();
                            C4990ab.m7416i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + i2 + " roomkey:" + j);
                            if (cIj.sTc == null) {
                                C4990ab.m7417i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", Integer.valueOf(cIj.sSP.sNl.sPp.nwu), Integer.valueOf(i2));
                                if (i2 == 0 || r5.sNl.sPp.nwu != i2) {
                                    i = 0;
                                }
                                if (i == 0) {
                                    C4990ab.m7412e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                                    break;
                                }
                            }
                            if (bArr2.length > 12) {
                                cIj.mo26348b(C14058r.m22215U(bArr2, bArr2.length - 12), i2, j);
                            }
                            c4286s = cIj.sSP;
                            C46317a.Logi("MicroMsg.Voip.VoipServiceEx", C1447g.m3075Mq() + " need doSync by notify, status:" + c4286s.sNl.mStatus);
                            c4286s.sNl.sPs.mo9302a(null, false, 7);
                            break;
                        }
                        C4990ab.m7416i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                        break;
                    case 9:
                        cIj = C43727b.cIj();
                        bArr2 = c26250ui.cQx.cQr;
                        if (!C5046bo.m7540cb(bArr2) && bArr2[0] == (byte) 3) {
                            try {
                                C4990ab.m7416i("MicroMsg.Voip.VoipService", "onCancelNotify");
                                bArr = new byte[(bArr2.length - 1)];
                                System.arraycopy(bArr2, 1, bArr, 0, bArr.length);
                                cpm = new cpm();
                                cpm.parseFrom(bArr);
                                cIj.mo26339Gv(cpm.wem);
                                if (!(cIj.sTc == null || cpm.wem != cIj.sTc.wem || cIj.oGx.doT())) {
                                    cIj.sTc = null;
                                    cIj.sTd = 0;
                                    cIj.oGx.stopTimer();
                                }
                                c4286s = cIj.sSP;
                                C4990ab.m7417i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", Integer.valueOf(cpm.wem));
                                if (c4286s.sNl.sPu != null && cpm.wem == c4286s.sNl.sPu.wem) {
                                    c4286s.cKn();
                                    c4286s.sNl.shutdown();
                                    break;
                                }
                            } catch (Exception e2) {
                                C4990ab.m7413e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", e2.getMessage());
                                break;
                            }
                        }
                    case 10:
                        cIj = C43727b.cIj();
                        bArr2 = c26250ui.cQx.cQr;
                        if (!C5046bo.m7540cb(bArr2) && bArr2[0] == (byte) 2) {
                            try {
                                C4990ab.m7416i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                                bArr = new byte[(bArr2.length - 1)];
                                System.arraycopy(bArr2, 1, bArr, 0, bArr.length);
                                cpm = new cpm();
                                cpm.parseFrom(bArr);
                                c4286s = cIj.sSP;
                                C4990ab.m7417i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", Integer.valueOf(cpm.wem));
                                if (cpm.wem == c4286s.sNl.sPu.wem) {
                                    if (!c4286s.sNl.cJn) {
                                        C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                                        c4286s.cKn();
                                        c4286s.sNl.shutdown();
                                        break;
                                    }
                                    C4990ab.m7416i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                                    break;
                                }
                            } catch (Exception e22) {
                                C4990ab.m7413e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", e22.getMessage());
                                break;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.m2505o(4319);
            return false;
        }
        AppMethodBeat.m2505o(4319);
        return false;
    }
}
