package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.a.ui.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.n;
import com.tencent.mm.plugin.voip.model.o.a;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class d extends c<ui> {
    public d() {
        AppMethodBeat.i(4318);
        this.xxI = ui.class.getName().hashCode();
        AppMethodBeat.o(4318);
    }

    private static boolean a(ui uiVar) {
        int i = true;
        AppMethodBeat.i(4319);
        if (uiVar instanceof ui) {
            if (g.RK()) {
                byte[] bArr;
                r cIj;
                byte[] bArr2;
                s sVar;
                cpm cpm;
                switch (uiVar.cQx.cAd) {
                    case 1:
                        b.cIj();
                        a abW = r.abW(uiVar.cQx.content);
                        if (abW != null) {
                            if (!abW.cJh()) {
                                if (abW.sQU != a.sRb) {
                                    i = 0;
                                }
                                if (i != 0) {
                                    uiVar.cQy.type = 3;
                                    break;
                                }
                            }
                            uiVar.cQy.type = 2;
                            break;
                        }
                        break;
                    case 2:
                        uiVar.cQy.cQz = b.cIj().con;
                        break;
                    case 3:
                        r cIj2 = b.cIj();
                        byte[] bArr3 = uiVar.cQx.cQr;
                        if (bArr3 != null && bArr3.length >= 10 && bArr3[0] == (byte) 1) {
                            bArr = new byte[(bArr3.length - 1)];
                            System.arraycopy(bArr3, 1, bArr, 0, bArr.length);
                            n nVar = cIj2.sSP.sNl.sPp.sVH;
                            nVar.sQK = System.currentTimeMillis();
                            com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + nVar.sQK);
                            try {
                                cpm cpm2 = (cpm) new cpm().parseFrom(bArr);
                                ab.d("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify");
                                if (!cIj2.sTe) {
                                    com.tencent.mm.plugin.voip.a.a.c(cpm2.wem, cpm2.wen, 1, 2);
                                    cIj2.sTe = true;
                                }
                                if (!cIj2.sSP.cKg()) {
                                    h.pYm.a(11523, true, true, Integer.valueOf(cpm2.wem), Long.valueOf(cpm2.wen), Integer.valueOf(cpm2.xmL), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                                    cIj2.b(cpm2);
                                    break;
                                }
                                h.pYm.a(11523, true, true, Integer.valueOf(cpm2.wem), Long.valueOf(cpm2.wen), Integer.valueOf(cpm2.xmL), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                                break;
                            } catch (IOException e) {
                                ab.printErrStackTrace("MicroMsg.Voip.VoipService", e, "", new Object[0]);
                                break;
                            }
                        }
                    case 4:
                        boolean z;
                        b bVar = uiVar.cQy;
                        r cIj3 = b.cIj();
                        Context context = ah.getContext();
                        if (cIj3.con && cIj3.sTa && !cIj3.sTb) {
                            ab.d("MicroMsg.Voip.VoipService", "isVideoCalling " + cIj3.sSR + " isAudioCalling " + cIj3.sSS);
                            if (!(bo.isNullOrNil(cIj3.talker) || ((j) g.K(j.class)).XM().aoO(cIj3.talker) == null)) {
                                r.a(context, cIj3.talker, true, cIj3.sSR, true);
                                z = true;
                                bVar.cQA = z;
                                break;
                            }
                        }
                        z = false;
                        bVar.cQA = z;
                    case 5:
                        if (!com.tencent.mm.r.a.Oo()) {
                            if (uiVar.cQx.cQs != 2) {
                                if (uiVar.cQx.cQs != 3) {
                                    if (uiVar.cQx.cQs == 4) {
                                        q.aY(uiVar.cQx.context, uiVar.cQx.talker);
                                        break;
                                    }
                                }
                                q.aX(uiVar.cQx.context, uiVar.cQx.talker);
                                break;
                            }
                            q.aW(uiVar.cQx.context, uiVar.cQx.talker);
                            break;
                        }
                        com.tencent.mm.ui.base.h.g(uiVar.cQx.context, R.string.f65, R.string.tz);
                        break;
                        break;
                    case 6:
                        cIj = b.cIj();
                        bArr2 = uiVar.cQx.cQr;
                        if (bArr2 != null) {
                            ab.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + bArr2.length);
                            int i2 = ByteBuffer.wrap(bArr2, 0, 4).getInt();
                            long j = ByteBuffer.wrap(bArr2, 4, 8).getLong();
                            ab.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + i2 + " roomkey:" + j);
                            if (cIj.sTc == null) {
                                ab.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", Integer.valueOf(cIj.sSP.sNl.sPp.nwu), Integer.valueOf(i2));
                                if (i2 == 0 || r5.sNl.sPp.nwu != i2) {
                                    i = 0;
                                }
                                if (i == 0) {
                                    ab.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                                    break;
                                }
                            }
                            if (bArr2.length > 12) {
                                cIj.b(r.U(bArr2, bArr2.length - 12), i2, j);
                            }
                            sVar = cIj.sSP;
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.VoipServiceEx", com.tencent.mm.compatible.util.g.Mq() + " need doSync by notify, status:" + sVar.sNl.mStatus);
                            sVar.sNl.sPs.a(null, false, 7);
                            break;
                        }
                        ab.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                        break;
                    case 9:
                        cIj = b.cIj();
                        bArr2 = uiVar.cQx.cQr;
                        if (!bo.cb(bArr2) && bArr2[0] == (byte) 3) {
                            try {
                                ab.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                                bArr = new byte[(bArr2.length - 1)];
                                System.arraycopy(bArr2, 1, bArr, 0, bArr.length);
                                cpm = new cpm();
                                cpm.parseFrom(bArr);
                                cIj.Gv(cpm.wem);
                                if (!(cIj.sTc == null || cpm.wem != cIj.sTc.wem || cIj.oGx.doT())) {
                                    cIj.sTc = null;
                                    cIj.sTd = 0;
                                    cIj.oGx.stopTimer();
                                }
                                sVar = cIj.sSP;
                                ab.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", Integer.valueOf(cpm.wem));
                                if (sVar.sNl.sPu != null && cpm.wem == sVar.sNl.sPu.wem) {
                                    sVar.cKn();
                                    sVar.sNl.shutdown();
                                    break;
                                }
                            } catch (Exception e2) {
                                ab.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", e2.getMessage());
                                break;
                            }
                        }
                    case 10:
                        cIj = b.cIj();
                        bArr2 = uiVar.cQx.cQr;
                        if (!bo.cb(bArr2) && bArr2[0] == (byte) 2) {
                            try {
                                ab.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                                bArr = new byte[(bArr2.length - 1)];
                                System.arraycopy(bArr2, 1, bArr, 0, bArr.length);
                                cpm = new cpm();
                                cpm.parseFrom(bArr);
                                sVar = cIj.sSP;
                                ab.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", Integer.valueOf(cpm.wem));
                                if (cpm.wem == sVar.sNl.sPu.wem) {
                                    if (!sVar.sNl.cJn) {
                                        ab.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                                        sVar.cKn();
                                        sVar.sNl.shutdown();
                                        break;
                                    }
                                    ab.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                                    break;
                                }
                            } catch (Exception e22) {
                                ab.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", e22.getMessage());
                                break;
                            }
                        }
                        break;
                }
            }
            AppMethodBeat.o(4319);
            return false;
        }
        AppMethodBeat.o(4319);
        return false;
    }
}
