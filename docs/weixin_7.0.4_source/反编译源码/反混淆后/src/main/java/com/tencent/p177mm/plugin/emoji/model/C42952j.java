package com.tencent.p177mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.emoji.p227a.C32498b;
import com.tencent.p177mm.emoji.sync.EmojiSyncManager;
import com.tencent.p177mm.emoji.sync.EmojiSyncManager.C9287a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p1177ao.C25779b;
import com.tencent.p177mm.p1177ao.C37462a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C17926b;
import com.tencent.p177mm.p190at.p191a.p827a.C17926b.C17925a;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.p211cb.C26005f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.emoji.PluginEmoji;
import com.tencent.p177mm.plugin.emoji.p382d.C20358a;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.EmojiStoreV2SingleRecommendView;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p947e.C20362f;
import com.tencent.p177mm.plugin.emoji.p947e.C20365h;
import com.tencent.p177mm.plugin.emoji.p947e.C38878k;
import com.tencent.p177mm.plugin.emoji.p947e.C38878k.C277361;
import com.tencent.p177mm.plugin.emoji.p947e.C42944i;
import com.tencent.p177mm.plugin.emoji.p947e.C45850c;
import com.tencent.p177mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.p177mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.p177mm.plugin.emoji.sync.C27745c;
import com.tencent.p177mm.plugin.emoji.sync.C38888a;
import com.tencent.p177mm.plugin.emojicapture.api.C27791b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C44796m;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.RecommendView;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e.C35870a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44081e.C40477b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.C44219aq;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.C15437n;
import com.tencent.p177mm.storage.emotion.C15439u;
import com.tencent.p177mm.storage.emotion.C23516c;
import com.tencent.p177mm.storage.emotion.C23517f;
import com.tencent.p177mm.storage.emotion.C23519l;
import com.tencent.p177mm.storage.emotion.C30303d;
import com.tencent.p177mm.storage.emotion.C40627p;
import com.tencent.p177mm.storage.emotion.C44225j;
import com.tencent.p177mm.storage.emotion.C44227q;
import com.tencent.p177mm.storage.emotion.C46623a;
import com.tencent.p177mm.storage.emotion.C46624h;
import com.tencent.p177mm.storage.emotion.C46625s;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.view.C5740c;
import com.tencent.p177mm.view.p1628d.C44419a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.emoji.model.j */
public class C42952j implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C20378d kVL;
    private C44219aq kVM;
    private C20365h kVN;
    private C42955k kVO;
    private C20384g kVP;
    private C20382e kVQ;
    private C38888a<C27745c> kVR;
    private volatile C42944i kVS;
    private volatile C45850c kVT;
    private volatile C38878k kVU;
    private C25815a kVV;
    private C27739c kVW;

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$6 */
    class C29376 implements C35870a {
        C29376() {
        }

        /* renamed from: t */
        public final /* synthetic */ RecommendView mo7123t(Context context, boolean z) {
            AppMethodBeat.m2504i(53061);
            EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = new EmojiStoreV2SingleRecommendView(context, z);
            AppMethodBeat.m2505o(53061);
            return emojiStoreV2SingleRecommendView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$2 */
    static class C115592 implements C1366d {
        C115592() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46625s.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$3 */
    static class C115603 implements C1366d {
        C115603() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C23517f.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$10 */
    static class C2038610 implements C1366d {
        C2038610() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C44225j.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$11 */
    static class C2038711 implements C1366d {
        C2038711() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C40627p.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$5 */
    class C203885 implements C40477b {
        C203885() {
        }

        /* renamed from: dF */
        public final ChatFooterPanel mo35682dF(Context context) {
            AppMethodBeat.m2504i(53060);
            C5740c c5740c = new C5740c(context, false);
            AppMethodBeat.m2505o(53060);
            return c5740c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$1 */
    static class C339541 implements C1366d {
        C339541() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C30303d.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$4 */
    static class C339554 implements C1366d {
        C339554() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return new String[]{"DROP TABLE IF EXISTS EmotionDetail ", "DROP TABLE IF EXISTS EmojiSummaryInfo", "DROP TABLE IF EXISTS RewardMagicInfo"};
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$7 */
    class C339567 implements Runnable {
        C339567() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53062);
            ((C27791b) C1720g.m3530M(C27791b.class)).getRes();
            AppMethodBeat.m2505o(53062);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$8 */
    static class C339578 implements C1366d {
        C339578() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46623a.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$12 */
    static class C3888412 implements C1366d {
        C3888412() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C23519l.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$14 */
    static class C3888514 implements C1366d {
        C3888514() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C15437n.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$9 */
    static class C388869 implements C1366d {
        C388869() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C23516c.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$13 */
    static class C4295313 implements C1366d {
        C4295313() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C46624h.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.model.j$15 */
    static class C4295415 implements C1366d {
        C4295415() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C44227q.fnj;
        }
    }

    private static C42952j bkg() {
        AppMethodBeat.m2504i(53063);
        C42952j c42952j = (C42952j) C7485q.m12925Y(C42952j.class);
        AppMethodBeat.m2505o(53063);
        return c42952j;
    }

    public static C25815a bjW() {
        AppMethodBeat.m2504i(53064);
        C1720g.m3534RN().mo5159QU();
        if (C42952j.bkg().kVV == null) {
            C17925a c17925a = new C17925a(C4996ah.getContext());
            c17925a.fGV = new C20358a();
            c17925a.fGT = new C44419a();
            C17926b ahx = c17925a.ahx();
            C42952j.bkg().kVV = new C25815a(ahx);
        }
        C25815a c25815a = C42952j.bkg().kVV;
        AppMethodBeat.m2505o(53064);
        return c25815a;
    }

    public static C20378d bkh() {
        AppMethodBeat.m2504i(53065);
        C1720g.m3534RN().mo5159QU();
        if (C42952j.bkg().kVL == null) {
            C42952j.bkg().kVL = new C20378d();
        }
        C20378d c20378d = C42952j.bkg().kVL;
        AppMethodBeat.m2505o(53065);
        return c20378d;
    }

    public static C44219aq getEmojiDescMgr() {
        AppMethodBeat.m2504i(53066);
        C1720g.m3534RN().mo5159QU();
        if (C42952j.bkg().kVM == null) {
            C42952j.bkg().kVM = new C44219aq();
        }
        C44219aq c44219aq = C42952j.bkg().kVM;
        AppMethodBeat.m2505o(53066);
        return c44219aq;
    }

    public static C20365h bki() {
        AppMethodBeat.m2504i(53067);
        C1720g.m3534RN().mo5159QU();
        if (C42952j.bkg().kVN == null) {
            C42952j.bkg().kVN = new C20365h();
        }
        C20365h c20365h = C42952j.bkg().kVN;
        AppMethodBeat.m2505o(53067);
        return c20365h;
    }

    public static C38888a<C27745c> bkj() {
        AppMethodBeat.m2504i(53068);
        C1720g.m3534RN().mo5159QU();
        if (C42952j.bkg().kVR == null) {
            C42952j.bkg().kVR = new C38888a();
        }
        C38888a c38888a = C42952j.bkg().kVR;
        AppMethodBeat.m2505o(53068);
        return c38888a;
    }

    private static synchronized C42944i bkk() {
        C42944i c42944i;
        synchronized (C42952j.class) {
            AppMethodBeat.m2504i(53069);
            C1720g.m3534RN().mo5159QU();
            if (C42952j.bkg().kVS == null) {
                C42952j.bkg().kVS = new C42944i();
            }
            c42944i = C42952j.bkg().kVS;
            AppMethodBeat.m2505o(53069);
        }
        return c42944i;
    }

    private static C45850c bkl() {
        AppMethodBeat.m2504i(53070);
        C1720g.m3534RN().mo5159QU();
        if (C42952j.bkg().kVT == null) {
            C42952j.bkg().kVT = new C45850c();
        }
        C45850c c45850c = C42952j.bkg().kVT;
        AppMethodBeat.m2505o(53070);
        return c45850c;
    }

    public static C23505at getEmojiStorageMgr() {
        AppMethodBeat.m2504i(53071);
        C23505at dsZ = C23505at.dsZ();
        AppMethodBeat.m2505o(53071);
        return dsZ;
    }

    public static C38878k bkm() {
        AppMethodBeat.m2504i(53072);
        C1720g.m3534RN().mo5159QU();
        if (C42952j.bkg().kVU == null) {
            C42952j.bkg().kVU = new C38878k();
        }
        C38878k c38878k = C42952j.bkg().kVU;
        AppMethodBeat.m2505o(53072);
        return c38878k;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(53073);
        C4990ab.m7416i("MicroMsg.emoji.SubCoreEmoji", "onAccountRelease: ");
        C42944i bkk = C42952j.bkk();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("emotionstore", bkk.kTV, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("NewRecommendEmotion", bkk.kTW, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("EmojiBackup", bkk.kTX, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("EmotionBackup", bkk.kTX, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("SelfieEmojiBackup", bkk.kTX, true);
        C45850c bkl = C42952j.bkl();
        C4879a.xxA.mo10053d(bkl.kTp);
        C4879a.xxA.mo10053d(bkl.kTt);
        C4879a.xxA.mo10053d(bkl.kTu);
        C4879a.xxA.mo10053d(bkl.kTv);
        C4879a.xxA.mo10053d(bkl.kTw);
        C4879a.xxA.mo10053d(bkl.kTx);
        C4879a.xxA.mo10053d(bkl.kTy);
        C4879a.xxA.mo10053d(bkl.kTz);
        C4879a.xxA.mo10053d(bkl.kTA);
        C4879a.xxA.mo10053d(bkl.kTq);
        C4879a.xxA.mo10053d(bkl.kTr);
        C4879a.xxA.mo10053d(bkl.kTB);
        C4879a.xxA.mo10053d(bkl.kTC);
        C4879a.xxA.mo10053d(bkl.kTs);
        C23505at dsZ = C23505at.dsZ();
        dsZ.xYn.mo10117d(dsZ.xYF);
        dsZ.xYo.mo10117d(dsZ.xYD);
        dsZ.xYp.mo10117d(dsZ.xYE);
        C4879a.xxA.mo10053d(dsZ.xYG);
        C32497a c32497a = dsZ.xYz;
        if (c32497a.eyA != null) {
            c32497a.eyA.clear();
        }
        if (c32497a.eyB != null) {
            c32497a.eyB.clear();
        }
        C42952j.getEmojiDescMgr().clear();
        ((C6835d) C1720g.m3530M(C6835d.class)).removeEmojiMgr();
        C1202f bkh = C42952j.bkh();
        C1720g.m3535RO().eJo.mo14546b((int) ErrorCode.NEEDDOWNLOAD_FALSE_5, bkh);
        bkh.kVh.clear();
        bkh.kVf.clear();
        bkh.kVk.clear();
        C38878k bkm = C42952j.bkm();
        bkm.kUF = null;
        if (bkm.kUG != null) {
            bkm.kUG.clear();
        }
        BKGLoaderManager bKGLoaderManager = C42952j.bkj().kXj;
        C4990ab.m7410d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
        bKGLoaderManager.bkF();
        C4879a.xxA.mo10053d(bKGLoaderManager.kXG);
        C4879a.xxA.mo10053d(bKGLoaderManager.kXH);
        if (bKGLoaderManager.kXC != null) {
            C4996ah.getContext().unregisterReceiver(bKGLoaderManager.kXC);
            bKGLoaderManager.kXC = null;
        }
        C20362f.bjK().isRunning = false;
        if (this.kVO != null) {
            C42955k c42955k = this.kVO;
            C4879a.xxA.mo10053d(c42955k.kWb);
            C4879a.xxA.mo10053d(c42955k.kWc);
        }
        if (this.kVP != null) {
            C20384g c20384g = this.kVP;
            c20384g.kVv.clear();
            C42952j.bkh().kVj = null;
            c20384g.kVw.dead();
        }
        if (this.kVV != null) {
            this.kVV.detach();
        }
        C1720g.m3535RO().eJo.mo14546b(697, C42952j.bko());
        C25779b.afY().fAP.dead();
        C9287a c9287a = EmojiSyncManager.ezA;
        C9287a.m16849Pg().destroy();
        c9287a = EmojiSyncManager.ezA;
        C9287a.m16850Ph().destroy();
        AppMethodBeat.m2505o(53073);
    }

    static {
        AppMethodBeat.m2504i(53077);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new C339541());
        eaA.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new C339578());
        eaA.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new C388869());
        eaA.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new C2038610());
        eaA.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new C2038711());
        eaA.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new C3888412());
        eaA.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new C4295313());
        eaA.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new C3888514());
        eaA.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new C4295415());
        eaA.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new C115592());
        eaA.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new C115603());
        eaA.put(Integer.valueOf("DELETE".hashCode()), new C339554());
        AppMethodBeat.m2505o(53077);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        long currentTimeMillis;
        boolean z2;
        AppMethodBeat.m2504i(53074);
        C4990ab.m7416i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
        C44081e.vom = new C203885();
        C44081e.von = new C29376();
        C23505at dsZ = C23505at.dsZ();
        if (C1720g.m3536RP().eJN == null || !C1720g.m3536RP().eJN.isOpen()) {
            C4990ab.m7421w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", C1720g.m3536RP().eJN);
        }
        dsZ.xYn = new C30303d(C1720g.m3536RP().eJN);
        dsZ.xYo = new C46623a(C1720g.m3536RP().eJN);
        dsZ.xYp = new C23516c(C1720g.m3536RP().eJN);
        dsZ.xYr = new C44225j(C1720g.m3536RP().eJN);
        dsZ.xYs = new C23519l(C1720g.m3536RP().eJN);
        dsZ.xYt = new C46624h(C1720g.m3536RP().eJN);
        dsZ.xYq = new C40627p(C1720g.m3536RP().eJN);
        dsZ.xYu = new C15437n(C1720g.m3536RP().eJN);
        dsZ.xYv = new C44227q(C1720g.m3536RP().eJN);
        dsZ.xYw = new C46625s(C1720g.m3536RP().eJN);
        dsZ.xYx = new C23517f(C1720g.m3536RP().eJN);
        dsZ.xYy = new C15439u();
        dsZ.xYz = C32497a.m53203OB();
        ((C6835d) C1720g.m3530M(C6835d.class)).setEmojiMgr();
        C42944i bkk = C42952j.bkk();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("emotionstore", bkk.kTV, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("NewRecommendEmotion", bkk.kTW, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("EmojiBackup", bkk.kTX, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("EmotionBackup", bkk.kTX, true);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("SelfieEmojiBackup", bkk.kTX, true);
        C45850c bkl = C42952j.bkl();
        C4879a.xxA.mo10052c(bkl.kTp);
        C4879a.xxA.mo10052c(bkl.kTt);
        C4879a.xxA.mo10052c(bkl.kTu);
        C4879a.xxA.mo10052c(bkl.kTv);
        C4879a.xxA.mo10052c(bkl.kTw);
        C4879a.xxA.mo10052c(bkl.kTx);
        C4879a.xxA.mo10052c(bkl.kTy);
        C4879a.xxA.mo10052c(bkl.kTz);
        C4879a.xxA.mo10052c(bkl.kTA);
        C4879a.xxA.mo10052c(bkl.kTq);
        C4879a.xxA.mo10052c(bkl.kTr);
        C4879a.xxA.mo10052c(bkl.kTB);
        C4879a.xxA.mo10052c(bkl.kTC);
        C4879a.xxA.mo10052c(bkl.kTs);
        dsZ = C23505at.dsZ();
        dsZ.xYn.mo10116c(dsZ.xYF);
        dsZ.xYo.mo10116c(dsZ.xYD);
        dsZ.xYp.mo10116c(dsZ.xYE);
        C4879a.xxA.mo10052c(dsZ.xYG);
        C42952j.getEmojiDescMgr();
        C38878k bkm = C42952j.bkm();
        String value = C26373g.m41964Nu().getValue("EmotionRewardTipsLimit");
        if (!C5046bo.isNullOrNil(value)) {
            C4990ab.m7417i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", value);
            String[] split = value.split(",");
            if (split != null && split.length == 3) {
                long j;
                if (C5046bo.getInt(split[0], 0) == 0) {
                    j = 863913600000L;
                } else {
                    j = ((long) C5046bo.getInt(split[0], 0)) * 86400000;
                }
                bkm.kUD = j;
                bkm.kUE = C5046bo.getInt(split[1], 20) - 1;
                bkm.emW = C5046bo.getInt(split[2], 80) - 1;
            }
        }
        boolean z3 = C26072e.m41616OK() && ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_REWARD_TIP_ENABLE_BOOLEAN, Boolean.TRUE)).booleanValue();
        bkm.kUC = z3;
        C4990ab.m7417i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", Boolean.valueOf(bkm.kUC), Boolean.valueOf(r1), Boolean.valueOf(r3));
        C1720g.m3539RS().mo10302aa(new C277361());
        BKGLoaderManager bKGLoaderManager = C42952j.bkj().kXj;
        C4990ab.m7410d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
        C4879a.xxA.mo10052c(bKGLoaderManager.kXG);
        C4879a.xxA.mo10052c(bKGLoaderManager.kXH);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        bKGLoaderManager.kXC = new ConnectivityReceiver();
        C4996ah.getContext().registerReceiver(bKGLoaderManager.kXC, intentFilter);
        C4990ab.m7416i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
        C23505at dsZ2 = C23505at.dsZ();
        Context context = C4996ah.getContext();
        if (context != null) {
            C4990ab.m7417i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", String.valueOf(((Boolean) C1720g.m3536RP().mo5239Ry().get(274480, Boolean.TRUE)).booleanValue()));
            if (((Boolean) C1720g.m3536RP().mo5239Ry().get(274480, Boolean.TRUE)).booleanValue()) {
                dsZ2.xYn.mo48583hi(context);
                dsZ2.xYo.mo74787hi(context);
            }
            C1720g.m3536RP().mo5239Ry().set(274480, Boolean.FALSE);
        }
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_CUREENT_VERSION_INT, Integer.valueOf(0))).intValue() != C7243d.vxo) {
            currentTimeMillis = System.currentTimeMillis();
            dsZ2.xYo.duN();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_CUREENT_VERSION_INT, Integer.valueOf(C7243d.vxo));
            C4990ab.m7417i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_UPDATE_EMOJI_GROUP_COUNT_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            currentTimeMillis = System.currentTimeMillis();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_UPDATE_EMOJI_GROUP_COUNT_BOOLEAN, Boolean.valueOf(!dsZ2.xYo.duO()));
            C4990ab.m7417i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        this.kVO = new C42955k();
        this.kVP = new C20384g();
        C37462a.m63176cM(z);
        C1720g.m3535RO().eJo.mo14539a(697, C42952j.bko());
        boolean dqN = C26005f.dqL().dqN();
        C26003e dqK = C26003e.dqK();
        C4990ab.m7416i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
        ArrayList bjP = ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getEmojiMgr().bjP();
        if (bjP == null || bjP.isEmpty()) {
            dqK.aRs();
            z2 = true;
        } else {
            dqK.aRs();
            z2 = false;
        }
        if (dqN && ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0))).intValue() > 0) {
            C14845c.veg.mo27152f(37, 1, -1, false);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0));
            C1720g.m3535RO().eJo.mo14541a(new C44796m(37), 0);
            C7060h.pYm.mo8378a(165, 10, 1, false);
        }
        if (z2 && ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0))).intValue() > 0) {
            C14845c.veg.mo27152f(37, 2, -1, false);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0));
            C1720g.m3535RO().eJo.mo14541a(new C44796m(37), 0);
            C7060h.pYm.mo8378a(165, 11, 1, false);
        }
        C25779b afY = C25779b.afY();
        C4990ab.m7416i("MicroMsg.FontResLogic", "init");
        afY.fAP.dnU();
        if (afY.agb()) {
            C7060h.pYm.mo15419k(933, 4, 1);
        } else {
            C7060h.pYm.mo15419k(933, 5, 1);
            C14845c.veg;
            String gM = C14839b.m23097gM(57, 1);
            if (C5730e.m8628ct(gM)) {
                C7060h.pYm.mo15419k(933, 6, 1);
                C4990ab.m7417i("MicroMsg.FontResLogic", "cache file exist %s", gM);
                afY.mo43743e(gM, 57, 1, 1);
            }
        }
        C9287a c9287a = EmojiSyncManager.ezA;
        C9287a.m16849Pg().init();
        c9287a = EmojiSyncManager.ezA;
        C9287a.m16850Ph().init();
        C32498b c32498b = C32498b.eyD;
        C32498b.m53215OG();
        C7305d.xDG.execute(new C339567());
        AppMethodBeat.m2505o(53074);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public static C20382e bkn() {
        AppMethodBeat.m2504i(53075);
        C1720g.m3534RN().mo5159QU();
        if (C42952j.bkg().kVQ == null) {
            C42952j.bkg().kVQ = new C20382e();
        }
        C20382e c20382e = C42952j.bkg().kVQ;
        AppMethodBeat.m2505o(53075);
        return c20382e;
    }

    public static C27739c bko() {
        AppMethodBeat.m2504i(53076);
        C1720g.m3534RN().mo5159QU();
        if (C42952j.bkg().kVW == null) {
            C42952j.bkg().kVW = new C27739c();
        }
        C27739c c27739c = C42952j.bkg().kVW;
        AppMethodBeat.m2505o(53076);
        return c27739c;
    }
}
