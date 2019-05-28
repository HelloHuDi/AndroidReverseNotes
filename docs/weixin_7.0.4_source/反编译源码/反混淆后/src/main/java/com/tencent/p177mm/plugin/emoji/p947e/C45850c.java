package com.tencent.p177mm.plugin.emoji.p947e;

import android.database.Cursor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.p211cb.C26005f;
import com.tencent.p177mm.p230g.p231a.C18407ua;
import com.tencent.p177mm.p230g.p231a.C26085ax;
import com.tencent.p177mm.p230g.p231a.C32529cs;
import com.tencent.p177mm.p230g.p231a.C32532ct;
import com.tencent.p177mm.p230g.p231a.C32533cu;
import com.tencent.p177mm.p230g.p231a.C37736ih;
import com.tencent.p177mm.p230g.p231a.C37748jt;
import com.tencent.p177mm.p230g.p231a.C37767nf;
import com.tencent.p177mm.p230g.p231a.C45348ny;
import com.tencent.p177mm.p230g.p231a.C9298bc;
import com.tencent.p177mm.p230g.p231a.C9311cv;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p1252c.C20357b;
import com.tencent.p177mm.plugin.emoji.p1252c.C27731a;
import com.tencent.p177mm.plugin.emoji.p1252c.C27732c;
import com.tencent.p177mm.plugin.emoji.p1252c.C38875d;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p947e.C20360e.C203611;
import com.tencent.p177mm.plugin.emoji.p947e.C20362f.C203631;
import com.tencent.p177mm.plugin.emoji.p947e.C42942d.C429392;
import com.tencent.p177mm.plugin.emoji.p947e.C42942d.C429431;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C44219aq;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.plugin.emoji.e.c */
public final class C45850c {
    public C4884c kTA = new C115529();
    public C4884c kTB = new C1155010();
    public C4884c kTC = new C203592();
    public C27731a kTp = new C27731a();
    public C20357b kTq = new C20357b();
    public C38875d kTr = new C38875d();
    public C27732c kTs = new C27732c();
    public C4884c kTt = new C277341();
    public C4884c kTu = new C429363();
    public C4884c kTv = new C429374();
    public C4884c kTw = new C429385();
    public C4884c kTx = new C458496();
    public final C4884c kTy = new C115517();
    public C4884c kTz = new C339478();

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$10 */
    class C1155010 extends C4884c<C32529cs> {
        C1155010() {
            AppMethodBeat.m2504i(52846);
            this.xxI = C32529cs.class.getName().hashCode();
            AppMethodBeat.m2505o(52846);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(52847);
            switch (((C32529cs) c4883b).cvT.cuu) {
                case 1:
                    C26005f.dqL().dqO();
                    C26003e.dqK().aRs();
                    C4879a.xxA.mo10055m(new C45348ny());
                    break;
                case 2:
                    C26003e.dqK().aRs();
                    C4879a.xxA.mo10055m(new C45348ny());
                    break;
                default:
                    C4990ab.m7416i("MicroMsg.emoji.EmojiEventMgr", "unknown event.");
                    break;
            }
            AppMethodBeat.m2505o(52847);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$7 */
    class C115517 extends C4884c<C9298bc> {
        C115517() {
            AppMethodBeat.m2504i(52839);
            this.xxI = C9298bc.class.getName().hashCode();
            AppMethodBeat.m2505o(52839);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(52840);
            C44219aq emojiDescMgr = C42952j.getEmojiDescMgr();
            C4990ab.m7417i("MicroMsg.emoji.EmojiDescNewMgr", "[cpan] language change Current Language:%s LastLanguage:%s", C4988aa.dor().toLowerCase(), emojiDescMgr.xXM);
            if (!(C5046bo.isNullOrNil(emojiDescMgr.xXM) || emojiDescMgr.xXM.equalsIgnoreCase(r1))) {
                emojiDescMgr.dsY();
            }
            C32497a.m53203OB().mo53140cc(true);
            AppMethodBeat.m2505o(52840);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$9 */
    class C115529 extends C4884c<C9311cv> {
        C115529() {
            AppMethodBeat.m2504i(52843);
            this.xxI = C9311cv.class.getName().hashCode();
            AppMethodBeat.m2505o(52843);
        }

        /* renamed from: a */
        private static boolean m19369a(C9311cv c9311cv) {
            AppMethodBeat.m2504i(52844);
            if (c9311cv != null && (c9311cv instanceof C9311cv)) {
                boolean z = c9311cv.cvX.enable;
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_REWARD_TIP_ENABLE_BOOLEAN, Boolean.valueOf(z));
                C42952j.bkm().kUC = z;
                if (z) {
                    Toast.makeText(C4996ah.getContext(), C25738R.string.b9t, 0).show();
                } else {
                    C7060h.pYm.mo8381e(12953, Integer.valueOf(2), "");
                    Toast.makeText(C4996ah.getContext(), C25738R.string.b9r, 0).show();
                }
            }
            AppMethodBeat.m2505o(52844);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$2 */
    class C203592 extends C4884c<C37736ih> {
        C203592() {
            AppMethodBeat.m2504i(52828);
            this.xxI = C37736ih.class.getName().hashCode();
            AppMethodBeat.m2505o(52828);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(52829);
            switch (((C37736ih) c4883b).cDr.errorCode) {
                case 101:
                    C7060h.pYm.mo8378a(401, 3, 1, false);
                    break;
                case 102:
                    C7060h.pYm.mo8378a(401, 4, 1, false);
                    break;
                case 104:
                    C7060h.pYm.mo8378a(401, 6, 1, false);
                    break;
                case 105:
                    C7060h.pYm.mo8378a(401, 7, 1, false);
                    break;
                case 106:
                    C7060h.pYm.mo8378a(401, 8, 1, false);
                    break;
                case 107:
                    C7060h.pYm.mo8378a(401, 9, 1, false);
                    break;
                case 108:
                    C7060h.pYm.mo8378a(401, 10, 1, false);
                    break;
                case 109:
                    C7060h.pYm.mo8378a(401, 11, 1, false);
                    break;
                case 110:
                    C7060h.pYm.mo8378a(401, 12, 1, false);
                    break;
                case 111:
                    C7060h.pYm.mo8378a(401, 13, 1, false);
                    break;
                case 112:
                    C7060h.pYm.mo8378a(401, 14, 1, false);
                    break;
                case 113:
                    C7060h.pYm.mo8378a(401, 15, 1, false);
                    break;
            }
            AppMethodBeat.m2505o(52829);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$1 */
    class C277341 extends C4884c<C18407ua> {
        C277341() {
            AppMethodBeat.m2504i(52826);
            this.xxI = C18407ua.class.getName().hashCode();
            AppMethodBeat.m2505o(52826);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(52827);
            C7620bi c7620bi = ((C18407ua) c4883b).cQj.csG;
            EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(c7620bi.field_imgPath);
            if (aqi != null) {
                EmojiInfo emojiInfo;
                if (aqi.field_type == EmojiInfo.zYR) {
                    Cursor cursor = null;
                    if (EmojiInfo.m48209Mw(aqi.field_catalog)) {
                        cursor = C42952j.getEmojiStorageMgr().xYn.mo48560MB(aqi.field_catalog);
                    } else if (aqi.field_catalog == EmojiInfo.yax && aqi.getContent().length() > 0 && EmojiInfo.m48209Mw(C5046bo.getInt(aqi.getContent(), 0))) {
                        cursor = C42952j.getEmojiStorageMgr().xYn.mo48560MB(C5046bo.getInt(aqi.getContent(), 0));
                    }
                    if (cursor != null) {
                        int gV = C5046bo.m7560gV(cursor.getCount() - 1, 0);
                        aqi = new EmojiInfo();
                        cursor.moveToPosition(gV);
                        aqi.mo8995d(cursor);
                        cursor.close();
                        emojiInfo = aqi;
                    } else {
                        emojiInfo = aqi;
                    }
                    c7620bi.mo14795jv(emojiInfo.mo20410Aq());
                    c7620bi.mo14785ht(0);
                    C44218ap aps = C44218ap.aps(c7620bi.field_content);
                    aps.fWX = false;
                    c7620bi.setStatus(1);
                    c7620bi.setContent(aps.dsX());
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c7620bi.field_msgId, c7620bi);
                } else {
                    emojiInfo = aqi;
                }
                C42952j.bki().mo35620a(c7620bi.field_talker, emojiInfo, c7620bi);
            }
            AppMethodBeat.m2505o(52827);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$8 */
    class C339478 extends C4884c<C37767nf> {
        C339478() {
            AppMethodBeat.m2504i(52841);
            this.xxI = C37767nf.class.getName().hashCode();
            AppMethodBeat.m2505o(52841);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(52842);
            C37767nf c37767nf = (C37767nf) c4883b;
            if (!(c37767nf == null || !(c37767nf instanceof C37767nf) || c37767nf.cJv == null)) {
                String str = c37767nf.cJv.cwg;
                if (!C5046bo.isNullOrNil(str) && C42952j.getEmojiStorageMgr().xYo.aqc(str)) {
                    C42952j.getEmojiDescMgr().dsY();
                }
            }
            AppMethodBeat.m2505o(52842);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$3 */
    class C429363 extends C4884c<C37748jt> {
        C429363() {
            AppMethodBeat.m2504i(52830);
            this.xxI = C37748jt.class.getName().hashCode();
            AppMethodBeat.m2505o(52830);
        }

        /* renamed from: a */
        private static boolean m76257a(C37748jt c37748jt) {
            AppMethodBeat.m2504i(52831);
            if (c37748jt != null && (c37748jt instanceof C37748jt)) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiEventMgr", "manualAuthEventListener callback");
                if (c37748jt.cER.csN) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
                }
            }
            AppMethodBeat.m2505o(52831);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$4 */
    class C429374 extends C4884c<C32533cu> {
        C429374() {
            AppMethodBeat.m2504i(52833);
            this.xxI = C32533cu.class.getName().hashCode();
            AppMethodBeat.m2505o(52833);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(52834);
            switch (((C32533cu) c4883b).cvW.state) {
                case 0:
                    C20360e bjJ = C20360e.bjJ();
                    String Yb = C2933b.m5221Yb();
                    bjJ.kTL = true;
                    if (C5046bo.isNullOrNil(Yb)) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiFileCleanTaskManager", "filepath is empty.");
                    } else {
                        C4990ab.m7417i("MicroMsg.emoji.EmojiFileCleanTaskManager", "need clean emoji file:%B", Boolean.valueOf(System.currentTimeMillis() - ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(0))).longValue() >= 86400000));
                        if (System.currentTimeMillis() - ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_CLEAN_TEMP_FILE_TASK_LONG, Long.valueOf(0))).longValue() >= 86400000) {
                            C4990ab.m7416i("MicroMsg.emoji.EmojiFileCleanTaskManager", "startClean");
                            C1720g.m3539RS().mo10302aa(new C203611(Yb));
                        }
                    }
                    C20362f bjK = C20362f.bjK();
                    if (bjK.isEnable()) {
                        if (!bjK.isRunning) {
                            bjK.isRunning = true;
                            if ((System.currentTimeMillis() - ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_ENCODE_EMOJI_FILE_TASK_LONG, Long.valueOf(0))).longValue() >= 86400000 ? 1 : null) != null) {
                                C7305d.xDH.mo10142ak(new C203631());
                                break;
                            }
                            C4990ab.m7416i("MicroMsg.emoji.EmojiFileEncryptMgr", "need no encrypt.");
                            break;
                        }
                        C4990ab.m7410d("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt process file is running.");
                        break;
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiFileEncryptMgr", "encrypt is disable.");
                    break;
                case 1:
                    C20360e.bjJ().kTL = false;
                    C20362f.bjK().isRunning = false;
                    break;
            }
            AppMethodBeat.m2505o(52834);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$5 */
    class C429385 extends C4884c<C32532ct> {
        C429385() {
            AppMethodBeat.m2504i(52835);
            this.xxI = C32532ct.class.getName().hashCode();
            AppMethodBeat.m2505o(52835);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(52836);
            C32532ct c32532ct = (C32532ct) c4883b;
            C42942d bjH = C42942d.bjH();
            if (c32532ct != null && (c32532ct instanceof C32532ct)) {
                c32532ct = c32532ct;
                switch (c32532ct.cvU.scene) {
                    case 0:
                        C1720g.m3539RS().mo10302aa(new C429431(c32532ct.cvU.cvV));
                        break;
                    case 1:
                        C1720g.m3539RS().mo10302aa(new C429392(c32532ct.cvU.cvV));
                        break;
                }
            }
            AppMethodBeat.m2505o(52836);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.e.c$6 */
    class C458496 extends C4884c<C26085ax> {
        C458496() {
            AppMethodBeat.m2504i(52837);
            this.xxI = C26085ax.class.getName().hashCode();
            AppMethodBeat.m2505o(52837);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(52838);
            C26085ax c26085ax = (C26085ax) c4883b;
            int i = c26085ax.cua.type;
            EmojiInfo emojiInfo;
            if (i == 0) {
                emojiInfo = c26085ax.cua.cuc;
                if (emojiInfo != null && emojiInfo.duP()) {
                    c26085ax.cub.csN = C20362f.bjK().mo35594m(emojiInfo);
                    if (!c26085ax.cub.csN) {
                        C7060h.pYm.mo8378a(252, 8, 1, false);
                    }
                }
            } else if (i == 1) {
                String str = c26085ax.cua.cud;
                if (!C5046bo.isNullOrNil(str)) {
                    emojiInfo = C42952j.getEmojiStorageMgr().xYn.aqk(str);
                    if (emojiInfo != null && emojiInfo.duP()) {
                        c26085ax.cub.csN = C20362f.bjK().mo35594m(emojiInfo);
                        if (!c26085ax.cub.csN) {
                            C7060h.pYm.mo8378a(252, 9, 1, false);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(52838);
            return false;
        }
    }

    public C45850c() {
        AppMethodBeat.m2504i(52848);
        AppMethodBeat.m2505o(52848);
    }
}
