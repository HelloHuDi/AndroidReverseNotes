package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.e;
import com.tencent.mm.cb.f;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;

public final class c {
    public com.tencent.mm.sdk.b.c kTA = new com.tencent.mm.sdk.b.c<cv>() {
        {
            AppMethodBeat.i(52843);
            this.xxI = cv.class.getName().hashCode();
            AppMethodBeat.o(52843);
        }

        private static boolean a(cv cvVar) {
            AppMethodBeat.i(52844);
            if (cvVar != null && (cvVar instanceof cv)) {
                boolean z = cvVar.cvX.enable;
                g.RP().Ry().set(a.USERINFO_EMOJI_REWARD_TIP_ENABLE_BOOLEAN, Boolean.valueOf(z));
                j.bkm().kUC = z;
                if (z) {
                    Toast.makeText(ah.getContext(), R.string.b9t, 0).show();
                } else {
                    h.pYm.e(12953, Integer.valueOf(2), "");
                    Toast.makeText(ah.getContext(), R.string.b9r, 0).show();
                }
            }
            AppMethodBeat.o(52844);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c kTB = new com.tencent.mm.sdk.b.c<cs>() {
        {
            AppMethodBeat.i(52846);
            this.xxI = cs.class.getName().hashCode();
            AppMethodBeat.o(52846);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(52847);
            switch (((cs) bVar).cvT.cuu) {
                case 1:
                    f.dqL().dqO();
                    e.dqK().aRs();
                    com.tencent.mm.sdk.b.a.xxA.m(new ny());
                    break;
                case 2:
                    e.dqK().aRs();
                    com.tencent.mm.sdk.b.a.xxA.m(new ny());
                    break;
                default:
                    ab.i("MicroMsg.emoji.EmojiEventMgr", "unknown event.");
                    break;
            }
            AppMethodBeat.o(52847);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c kTC = new com.tencent.mm.sdk.b.c<ih>() {
        {
            AppMethodBeat.i(52828);
            this.xxI = ih.class.getName().hashCode();
            AppMethodBeat.o(52828);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(52829);
            switch (((ih) bVar).cDr.errorCode) {
                case 101:
                    h.pYm.a(401, 3, 1, false);
                    break;
                case 102:
                    h.pYm.a(401, 4, 1, false);
                    break;
                case 104:
                    h.pYm.a(401, 6, 1, false);
                    break;
                case 105:
                    h.pYm.a(401, 7, 1, false);
                    break;
                case 106:
                    h.pYm.a(401, 8, 1, false);
                    break;
                case 107:
                    h.pYm.a(401, 9, 1, false);
                    break;
                case 108:
                    h.pYm.a(401, 10, 1, false);
                    break;
                case 109:
                    h.pYm.a(401, 11, 1, false);
                    break;
                case 110:
                    h.pYm.a(401, 12, 1, false);
                    break;
                case 111:
                    h.pYm.a(401, 13, 1, false);
                    break;
                case 112:
                    h.pYm.a(401, 14, 1, false);
                    break;
                case 113:
                    h.pYm.a(401, 15, 1, false);
                    break;
            }
            AppMethodBeat.o(52829);
            return false;
        }
    };
    public com.tencent.mm.plugin.emoji.c.a kTp = new com.tencent.mm.plugin.emoji.c.a();
    public com.tencent.mm.plugin.emoji.c.b kTq = new com.tencent.mm.plugin.emoji.c.b();
    public d kTr = new d();
    public com.tencent.mm.plugin.emoji.c.c kTs = new com.tencent.mm.plugin.emoji.c.c();
    public com.tencent.mm.sdk.b.c kTt = new com.tencent.mm.sdk.b.c<ua>() {
        {
            AppMethodBeat.i(52826);
            this.xxI = ua.class.getName().hashCode();
            AppMethodBeat.o(52826);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(52827);
            bi biVar = ((ua) bVar).cQj.csG;
            EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(biVar.field_imgPath);
            if (aqi != null) {
                EmojiInfo emojiInfo;
                if (aqi.field_type == EmojiInfo.zYR) {
                    Cursor cursor = null;
                    if (EmojiInfo.Mw(aqi.field_catalog)) {
                        cursor = j.getEmojiStorageMgr().xYn.MB(aqi.field_catalog);
                    } else if (aqi.field_catalog == EmojiInfo.yax && aqi.getContent().length() > 0 && EmojiInfo.Mw(bo.getInt(aqi.getContent(), 0))) {
                        cursor = j.getEmojiStorageMgr().xYn.MB(bo.getInt(aqi.getContent(), 0));
                    }
                    if (cursor != null) {
                        int gV = bo.gV(cursor.getCount() - 1, 0);
                        aqi = new EmojiInfo();
                        cursor.moveToPosition(gV);
                        aqi.d(cursor);
                        cursor.close();
                        emojiInfo = aqi;
                    } else {
                        emojiInfo = aqi;
                    }
                    biVar.jv(emojiInfo.Aq());
                    biVar.ht(0);
                    ap aps = ap.aps(biVar.field_content);
                    aps.fWX = false;
                    biVar.setStatus(1);
                    biVar.setContent(aps.dsX());
                    ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().a(biVar.field_msgId, biVar);
                } else {
                    emojiInfo = aqi;
                }
                j.bki().a(biVar.field_talker, emojiInfo, biVar);
            }
            AppMethodBeat.o(52827);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c kTu = new com.tencent.mm.sdk.b.c<jt>() {
        {
            AppMethodBeat.i(52830);
            this.xxI = jt.class.getName().hashCode();
            AppMethodBeat.o(52830);
        }

        private static boolean a(jt jtVar) {
            AppMethodBeat.i(52831);
            if (jtVar != null && (jtVar instanceof jt)) {
                ab.i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
                if (jtVar.cER.csN) {
                    g.RP().Ry().set(a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                    g.RP().Ry().set(a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                }
            }
            AppMethodBeat.o(52831);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c kTv = new com.tencent.mm.sdk.b.c<cu>() {
        {
            AppMethodBeat.i(52833);
            this.xxI = cu.class.getName().hashCode();
            AppMethodBeat.o(52833);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(52834);
            switch (((cu) bVar).cvW.state) {
                case 0:
                    e bjJ = e.bjJ();
                    String Yb = com.tencent.mm.plugin.emoji.h.b.Yb();
                    bjJ.kTL = true;
                    if (bo.isNullOrNil(Yb)) {
                        ab.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "filepath is empty.");
                    } else {
                        ab.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "need clean emoji file:%B", Boolean.valueOf(System.currentTimeMillis() - ((Long) g.RP().Ry().get(a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(0))).longValue() >= 86400000));
                        if (System.currentTimeMillis() - ((Long) g.RP().Ry().get(a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(0))).longValue() >= 86400000) {
                            ab.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "startClean");
                            g.RS().aa(new com.tencent.mm.plugin.emoji.e.e.AnonymousClass1(Yb));
                        }
                    }
                    f bjK = f.bjK();
                    if (bjK.isEnable()) {
                        if (!bjK.isRunning) {
                            bjK.isRunning = true;
                            if ((System.currentTimeMillis() - ((Long) g.RP().Ry().get(a.USERINFO_EMOJI_ENCODE_EMOJI_FILE_TASK_LONG, Long.valueOf(0))).longValue() >= 86400000 ? 1 : null) != null) {
                                com.tencent.mm.sdk.g.d.xDH.ak(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(52864);
                                        if (g.RK()) {
                                            ArrayList dvj = j.getEmojiStorageMgr().xYn.dvj();
                                            if (dvj != null && dvj.size() > 0) {
                                                Iterator it = dvj.iterator();
                                                while (it.hasNext()) {
                                                    EmojiInfo emojiInfo = (EmojiInfo) it.next();
                                                    if (f.this.isRunning) {
                                                        f.this.c(emojiInfo, false);
                                                    }
                                                }
                                            }
                                            if (f.this.isRunning) {
                                                g.RP().Ry().set(a.USERINFO_EMOJI_ENCODE_EMOJI_FILE_TASK_LONG, Long.valueOf(System.currentTimeMillis()));
                                            }
                                            AppMethodBeat.o(52864);
                                            return;
                                        }
                                        AppMethodBeat.o(52864);
                                    }
                                });
                                break;
                            }
                            ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "need no encrypt.");
                            break;
                        }
                        ab.d("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt process file is running.");
                        break;
                    }
                    ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt is disable.");
                    break;
                case 1:
                    e.bjJ().kTL = false;
                    f.bjK().isRunning = false;
                    break;
            }
            AppMethodBeat.o(52834);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c kTw = new com.tencent.mm.sdk.b.c<ct>() {
        {
            AppMethodBeat.i(52835);
            this.xxI = ct.class.getName().hashCode();
            AppMethodBeat.o(52835);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(52836);
            ct ctVar = (ct) bVar;
            d bjH = d.bjH();
            if (ctVar != null && (ctVar instanceof ct)) {
                ctVar = ctVar;
                switch (ctVar.cvU.scene) {
                    case 0:
                        g.RS().aa(new com.tencent.mm.plugin.emoji.e.d.AnonymousClass1(ctVar.cvU.cvV));
                        break;
                    case 1:
                        g.RS().aa(new com.tencent.mm.plugin.emoji.e.d.AnonymousClass2(ctVar.cvU.cvV));
                        break;
                }
            }
            AppMethodBeat.o(52836);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c kTx = new com.tencent.mm.sdk.b.c<ax>() {
        {
            AppMethodBeat.i(52837);
            this.xxI = ax.class.getName().hashCode();
            AppMethodBeat.o(52837);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(52838);
            ax axVar = (ax) bVar;
            int i = axVar.cua.type;
            EmojiInfo emojiInfo;
            if (i == 0) {
                emojiInfo = axVar.cua.cuc;
                if (emojiInfo != null && emojiInfo.duP()) {
                    axVar.cub.csN = f.bjK().m(emojiInfo);
                    if (!axVar.cub.csN) {
                        h.pYm.a(252, 8, 1, false);
                    }
                }
            } else if (i == 1) {
                String str = axVar.cua.cud;
                if (!bo.isNullOrNil(str)) {
                    emojiInfo = j.getEmojiStorageMgr().xYn.aqk(str);
                    if (emojiInfo != null && emojiInfo.duP()) {
                        axVar.cub.csN = f.bjK().m(emojiInfo);
                        if (!axVar.cub.csN) {
                            h.pYm.a(252, 9, 1, false);
                        }
                    }
                }
            }
            AppMethodBeat.o(52838);
            return false;
        }
    };
    public final com.tencent.mm.sdk.b.c kTy = new com.tencent.mm.sdk.b.c<bc>() {
        {
            AppMethodBeat.i(52839);
            this.xxI = bc.class.getName().hashCode();
            AppMethodBeat.o(52839);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(52840);
            aq emojiDescMgr = j.getEmojiDescMgr();
            ab.i("MicroMsg.emoji.EmojiDescNewMgr", "[cpan] language change Current Language:%s LastLanguage:%s", aa.dor().toLowerCase(), emojiDescMgr.xXM);
            if (!(bo.isNullOrNil(emojiDescMgr.xXM) || emojiDescMgr.xXM.equalsIgnoreCase(r1))) {
                emojiDescMgr.dsY();
            }
            com.tencent.mm.emoji.a.a.OB().cc(true);
            AppMethodBeat.o(52840);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c kTz = new com.tencent.mm.sdk.b.c<nf>() {
        {
            AppMethodBeat.i(52841);
            this.xxI = nf.class.getName().hashCode();
            AppMethodBeat.o(52841);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(52842);
            nf nfVar = (nf) bVar;
            if (!(nfVar == null || !(nfVar instanceof nf) || nfVar.cJv == null)) {
                String str = nfVar.cJv.cwg;
                if (!bo.isNullOrNil(str) && j.getEmojiStorageMgr().xYo.aqc(str)) {
                    j.getEmojiDescMgr().dsY();
                }
            }
            AppMethodBeat.o(52842);
            return false;
        }
    };

    public c() {
        AppMethodBeat.i(52848);
        AppMethodBeat.o(52848);
    }
}
